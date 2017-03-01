package com.xiaochun.tao.common.dal;

import java.io.Serializable;

import org.springframework.util.Assert;

import com.xiaochun.tao.common.persistence.BaseSqlMapper;

public class DalUtils
{
	
	/**
	 * 判断是否DO对象是否存在
	 * @param mapper
	 * @param key
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean isExist(BaseSqlMapper mapper,Serializable key) 
	{
		Assert.notNull(mapper);
		Assert.notNull(key);
		Object o = mapper.load(key);
		if (o == null)
		{
			return false;
		}
		return true;
	}
	
}
