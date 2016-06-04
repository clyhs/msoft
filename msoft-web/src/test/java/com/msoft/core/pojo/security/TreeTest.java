package com.msoft.core.pojo.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.msoft.module.security.service.IRoleService;
import com.msoft.module.security.service.ITreeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager="txManager", defaultRollback=false)
public class TreeTest {
	
	@Autowired
    ApplicationContext ctx;
	
	@Test
	public void addTree(){
		
		ITreeService ts = (ITreeService) ctx.getBean("TreeService");
		
		Tree t = ts.getById(2);
		
		System.out.println(ts.add("child04", "/module/demo/index.html", "leaf", Boolean.TRUE, Boolean.TRUE, t));
		System.out.println(ts.add("child05", "/module/demo/index.html", "leaf", Boolean.TRUE, Boolean.TRUE, t));
		//System.out.println(ts.add("children03", "/module/demo/index.html", "icons-children", Boolean.TRUE, Boolean.TRUE, t));
		
	}

}
