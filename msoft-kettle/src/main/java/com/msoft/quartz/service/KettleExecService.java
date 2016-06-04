package com.msoft.quartz.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class KettleExecService extends QuartzJobBean {

    private ApplicationContext cxt;
	
	public ApplicationContext getApplicationContext() {
		return cxt;
	}


	public void setApplicationContext(ApplicationContext applicationContext) {
		this.cxt = applicationContext;
	}

	/**
	 * 执行实际任务
	 * 
	 * @see execute
	 */
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("exec");
	}

	

}