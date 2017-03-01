package com.xiaochun.tao.api.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Objects;
import com.xiaochun.tao.api.res.BaseResponse;
import com.xiaochun.tao.api.res.code.ResCode;
import com.xiaochun.tao.utils.CryptTool;
/**
 * 拦截所有API请求进行MD5通信验签
 * @author ChenBo
 *
 */
public class MethodAuthorityInterceptor implements MethodInterceptor {
	
	private static Logger log =  LoggerFactory.getLogger(MethodAuthorityInterceptor.class);
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Class<?> clazz = invocation.getThis().getClass();
		String controllerName=null;
		String methodName=null;
		if (clazz.isAnnotationPresent(Controller.class)) {
			Controller controller = clazz.getAnnotation(Controller.class);
			controllerName = controller.value().trim();
			methodName = invocation.getMethod().getName();
			//屏蔽搜索引擎接口
	        if(Objects.equal(controllerName, "FlightController") && Objects.equal(methodName, "searchFlight")){
	        	log.info("controllerName:"+controllerName+">methodName:"+methodName+">GDSsearch invalid access.......");
	    		return null;
	        }
			//跳过所有支付回调请求
			if(Objects.equal(controllerName, "PaymentController")){
				if(Objects.equal(methodName, "creditNotify") || Objects.equal(methodName, "creditRecSuc") || Objects.equal(methodName, "creditRecFail")){
					return invocation.proceed();
				}
			}
			if(Objects.equal(controllerName, "StorePaymentController")){
				if(Objects.equal(methodName, "storeNotifyOK") || Objects.equal(methodName, "storeNotifyCancel") || 
				   Objects.equal(methodName, "storeRecSuc") || Objects.equal(methodName, "storeRecFail")){
					return invocation.proceed();
				}
			}
		}
		HttpServletRequest httpServletRequest=null;
		HttpServletResponse httpServletResponse=null;
		Object[] args = invocation.getArguments(); 
        for (int i = 0 ; i < args.length ; i++ ) 
        {  
        	if(args[i] instanceof HttpServletRequest){
        		httpServletRequest=(HttpServletRequest)args[i];
        		continue;
            }
        	if(args[i] instanceof HttpServletResponse){
        		httpServletResponse=(HttpServletResponse)args[i];
        		continue;
        	}
        }
        BaseResponse baseResponse = new BaseResponse();
        String data = httpServletRequest.getParameter("data");
        String sign = httpServletRequest.getParameter("sign");
        String signs=CryptTool.md5DigestUTF8(data+CryptTool.KEY);
        log.info("controllerName:"+controllerName+">methodName:"+methodName+">arguments:"+data);
        if(!Objects.equal(sign, signs)){
        	baseResponse.setRespCode(ResCode.MD5_ERROR.getCode());
        	baseResponse.setRespMsg(ResCode.MD5_ERROR.getMsg());
        	log.error("MD5加密错误>客户端sign:"+sign+"服务端signs:"+signs);
        	httpServletResponse.getWriter().write(JSONObject.toJSONString(baseResponse));
        	return null;
        }
        log.info("controllerName:"+controllerName+">methodName:"+methodName+">start.......");
		Object obj=invocation.proceed();
		log.info("controllerName:"+controllerName+">methodName:"+methodName+">end.......");
		return obj;
	}

}
