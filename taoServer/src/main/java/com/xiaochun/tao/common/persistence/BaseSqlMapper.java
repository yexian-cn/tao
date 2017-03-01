package com.xiaochun.tao.common.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.xiaochun.tao.common.dal.object.AbstractDO;
import com.xiaochun.tao.common.dal.object.BaseConditionVO;


public interface BaseSqlMapper<T extends AbstractDO, PK extends java.io.Serializable> {
	
	public int add(T t);

	public int del(Integer id);
	
	public int remove(T t);

	public int update(T t);
	
	public int edit(T t);

	public T get(Integer id);
	
	public T get(T t);
	
	public int count(T t);
	
	public PK insert(T model);

	public void delete(PK modelPK);
	
	public T load(PK modelPK);
	
	public void updateSelective(T model);
	
	public int countAll();
	
	public List<T> findAll();
	
	public List<PK> findAllIds();
	
	/**
	 * 分页数据
	 * @return
	 */
	public List<T> getPageListByCondition(@Param("vo")BaseConditionVO vo,@Param("t")T t,RowBounds rb);
	
	/**
	 * 分页总数
	 * @return
	 */
	public Integer findNumberByCondition(@Param("vo")BaseConditionVO vo,@Param("t")T t);
	
}
