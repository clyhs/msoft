package com.msoft.quartz.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MYService extends QuartzJobBean {
	
//    private ApplicationContext cxt;
//	
//	public ApplicationContext getApplicationContext() {
//		return cxt;
//	}
//
//
//	public void setApplicationContext(ApplicationContext applicationContext) {
//		this.cxt = applicationContext;
//	}

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub

		System.out.println("my test");
	}

}
