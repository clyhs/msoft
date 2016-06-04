package com.msoft.module.security.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.msoft.core.pojo.security.User;
import com.msoft.module.common.controller.CommonController;
import com.msoft.module.security.service.IUserService;


@Controller
public class UserController extends CommonController{
	
	@Resource(name="UserService")
	private IUserService m_oUserService;
	
	@RequestMapping(value = "/module/security/getUser", method = { RequestMethod.GET })
	@ResponseBody
	public User getUser(HttpServletRequest request,HttpServletResponse response){
		
		User u = m_oUserService.getById(2);
		
		System.out.println(u.getAGroups().size());
		return u;
		
	}

}
