package com.xiaochun.tao.common.threadpool;

import com.xiaochun.tao.common.threadpool.ThreadPool.ThreadDiagnose;

/**
 * 诊断信息接口
 */
public interface ThreadPoolDiagnose {

	public boolean running();

	public int maxsize();

	public int size();

	public ThreadDiagnose[] getDiagnose();

}
