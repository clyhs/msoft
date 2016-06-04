package com.msoft.core.pojo.security;

import java.io.Serializable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.msoft.module.security.dao.IRoleDao;
import com.msoft.module.security.service.IRoleService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager="txManager", defaultRollback=false)
public class RoleTest {
	
	@Autowired
    ApplicationContext ctx;
	
	@Test
	public void addRole(){
		Role r =new Role();
		r.setNRoleId(2);
		//IRoleDao roleDao  = (IRoleDao) ctx.getBean("RoleDao");
		//System.out.println(roleDao.add(r));
		//Role pid = roleDao.getRoleById(1);
		IRoleService rs = (IRoleService) ctx.getBean("RoleService");
		
		//Role r = rs.getById(1);
		
		//r.setParent(pid);
		System.out.println(rs.add("child06",r));
		
	}
	
	@Test
	public void getRole(){
		IRoleService rs = (IRoleService) ctx.getBean("RoleService");
		Role r = new Role();
		r= rs.getById(5);
		System.out.println(r.getSRoleName());
		System.out.println(r.getOParent().getSRoleName());
	}

}
