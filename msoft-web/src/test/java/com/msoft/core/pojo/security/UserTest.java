package com.msoft.core.pojo.security;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.msoft.module.security.service.IGroupService;
import com.msoft.module.security.service.IUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager="txManager", defaultRollback=true)
public class UserTest {
	
	@Autowired
    ApplicationContext ctx;
	
	@Test
	public void add(){
		IUserService us = (IUserService) ctx.getBean("UserService");
		
		System.out.println(us.add("user02", null));
	}
	
	@Test
	public void addWithGroup(){
		IUserService us = (IUserService) ctx.getBean("UserService");
		
		IGroupService gs = (IGroupService) ctx.getBean("GroupService");
		Group g = gs.getById(1);
		
		List<Group> groups = new ArrayList<Group>();
		groups.add(g);
		
		System.out.println(us.add("user03withgroup", groups));
	}
	@Test
	
	public void get(){
		IUserService us = (IUserService) ctx.getBean("UserService");
		User u = us.getById(2);
		
		List<Group> groups = new ArrayList<Group>();
		groups = u.getAGroups();
		
		System.out.println(u.getSUserName());
		
		System.out.println(groups.size());
		
		
	}
	

}
