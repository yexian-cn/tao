package com.xiaochun.tao.common.dal.common.sequence.dao;

import com.xiaochun.tao.common.dal.object.AbstractDO;

public class DalSequenceDO extends AbstractDO {

	private static final long serialVersionUID = 5556648098703289022L;
	
	private String sequenceKey;
	private long sequenceValue;

	public String getSequenceKey() {
		return sequenceKey;
	}

	public void setSequenceKey(String sequenceKey) {
		this.sequenceKey = sequenceKey;
	}

	public long getSequenceValue() {
		return sequenceValue;
	}

	public void setSequenceValue(long sequenceValue) {
		this.sequenceValue = sequenceValue;
	}

	public String getId() {
		return sequenceKey;
	}

}
