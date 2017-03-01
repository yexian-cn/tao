package com.xiaochun.tao.api.res.code;

public enum ResCode {
	
	SUCCESS("0000","成功."),
	FAIL("9999","请求系统异常,请稍候再试."),
	MD5_ERROR("9998","请求参数非法."),
	PWD_NOT_AGREEMENT("9997","输入密码不一致,请确认密码是否一致."),
	ARGUMENTS_ERROR("9996","参数校验错误."),
	REPEAT_REG("9995","该用户已存在."),
	REG_FAIL("9994","注册失败,系统异常请稍候再试."),
	LOGIN_ERROR("9993","登录失败,请稍候再试."),
	LOGIN_NOT_EXIST("9992","用户不存在."),
	PWD_ERROR("9991","登录密码错误."),
	USER_FREEZE("9990","用户已冻结."),
	UPDATE_USER_PWD("9989","系统无此邮箱地址."),
	USER_PWD_ERROR("9988","原密码输入错误"),
	MODIFY_PWD_TIMEOUT("9987","修改登录密码链接过期"),
	MODIFY_PWD_ERROR("9986","修改密码错误"),
	RPP_UNDER2("9799","未满2周岁不可作为乘机人."),
	RPP_BETWEEN2AND12("9780","12-2周岁以下为儿童."),
	FLIGHT_SERACH_ERROR("9599","航班搜索条件错误"),
	FLIGHT_SERACH_ANALYZE_ERROR("9598","航班搜索解析错误"),
	 //********************订单错误ＣＯＤＥ－Ｓｔａｒｔ************************//
	ADD_ORDER_ERROR("9499","下单失败，请稍后再试."),
	ORDER_AMOUNT_ERROR("9498","航班发生变化，请重新下单."),
	DELETE_ORDER_ERROR("9497","删除订单失败."),
	ORDER_NOT_EXIST("9496","该用户无此订单."),
	ORDER_STATUS_UP("9495","删除订单失败，订单状态发生变更."),
	ORDER_QUERY_ERROR("9494","查询订单错误."),
	ORDER_NULL("9493","无订单记录."),
	ORDER_VERIFY_EMAIL("9492","请先验证邮箱在下单."),
	ORDER_PNR_ERROR("9491","航班余票不足，请选择其他航班。"),
	//********************订单错误ＣＯＤＥ－ＥＮＤ************************//
	//**********************支付模块CODE-START***********************************//
	CHOOSE_PAYMENT_ERROR("9399","订单不存在或订单状态发生变更."),
	PAY_PAYMENT_ERROR("9398","信用卡支付失败."),
	QUERY_PAYMENT_ERROR("9397","查询信用卡支付信息失败."),
	STORE_PAYMENT_ERROR("9396","申请便利店支付失败."),
	STORE_USER_ERROR("9395","请完善个人基本信息."),
	//**********************支付模块CODE-END***********************************//
	VERIFY_EMAIL_SEND_ERROR("9801","验证邮箱邮件发送失败."),
	VERIFY_EMAIL_CALLBACK_ERROR("9802","激活邮箱失败.");
	private String code;
	private String msg;
	
	ResCode(String code,String msg){
		this.code=code;
		this.msg=msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
