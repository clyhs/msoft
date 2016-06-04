package com.msoft.module.security.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msoft.core.pojo.security.Group;
import com.msoft.core.pojo.security.User;
import com.msoft.module.common.controller.CommonController;
import com.msoft.module.security.service.IGroupService;
import com.msoft.module.security.service.IUserService;

@Controller
public class GroupController extends CommonController {
	
	@Resource(name="GroupService")
	private IGroupService m_oGroupService;
	
	@RequestMapping(value = "/module/security/getGroup", method = { RequestMethod.GET })
	@ResponseBody
	public Group getUser(HttpServletRequest request,HttpServletResponse response){
		
		Group u = m_oGroupService.getById(1);
		
		return u;
		
	}

}
