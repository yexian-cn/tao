package com.xiaochun.tao.common.utils;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.xiaochun.tao.common.dal.object.AbstractDO;
import com.xiaochun.tao.common.dal.object.BaseConditionVO;
import com.xiaochun.tao.common.persistence.BaseSqlMapper;

public class BaseServiceImpl<T extends AbstractDO, PK extends java.io.Serializable> {
	
	public List<T> queryByPage(BaseSqlMapper<T,PK> mapper,BaseConditionVO vo,T t) {
		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		List<T>  pos = mapper.getPageListByCondition(vo,t, rb);
		vo.setTotalCount(mapper.findNumberByCondition(vo, t));
		return pos;
	}

}
