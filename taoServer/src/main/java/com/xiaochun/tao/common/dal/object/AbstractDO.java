package com.xiaochun.tao.common.dal.object;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class AbstractDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8759440105819549830L;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public abstract Serializable getId();
}
