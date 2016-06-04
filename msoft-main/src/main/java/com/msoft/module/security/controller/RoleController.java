package com.msoft.module.security.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msoft.core.pojo.security.Group;
import com.msoft.core.pojo.security.Role;
import com.msoft.module.common.controller.CommonController;
import com.msoft.module.security.service.IGroupService;
import com.msoft.module.security.service.IRoleService;

@Controller
public class RoleController extends CommonController {

	@Resource(name="RoleService")
	private IRoleService m_oRoleService;
	
	
	@RequestMapping(value = "/module/security/role/index", method = { RequestMethod.GET })
	public String index(HttpServletRequest request,HttpServletResponse response){
		
		return "security/role/index";
		
	}
	
	@RequestMapping(value = "/module/security/getRole", method = { RequestMethod.GET })
	@ResponseBody
	public Role getRole(HttpServletRequest request,HttpServletResponse response){
		
		Role u = m_oRoleService.getById(1);
		
		return u;
		
	}
}
