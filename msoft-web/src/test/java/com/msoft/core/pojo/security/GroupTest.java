package com.msoft.core.pojo.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.msoft.module.security.service.IGroupService;
import com.msoft.module.security.service.IRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager="txManager", defaultRollback=true)
public class GroupTest {
	
	@Autowired
    ApplicationContext ctx;
	
	@Test
	public void add(){
		
	
		
		IGroupService gs = (IGroupService) ctx.getBean("GroupService");
		
		System.out.println(gs.add("group02"));
		
	}
	@Test
	public void get(){
		IGroupService gs = (IGroupService) ctx.getBean("GroupService");
		Group g = gs.getById(1);
		System.out.println(g.getSGroupName());
		System.out.println(g.getAUsers().get(0).getSUserName());
		System.out.println(g.getAUsers().size());
	}

}
