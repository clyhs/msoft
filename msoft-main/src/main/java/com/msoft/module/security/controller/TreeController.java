package com.msoft.module.security.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msoft.core.pojo.security.Role;
import com.msoft.core.pojo.security.Tree;
import com.msoft.core.vo.security.TreeVO;
import com.msoft.module.common.controller.CommonController;
import com.msoft.module.security.service.IRoleService;
import com.msoft.module.security.service.ITreeService;

@Controller
public class TreeController extends CommonController {
	
	@Resource(name="TreeService")
	private ITreeService m_oTreeService;
	
	
	@RequestMapping(value = "/module/security/tree/index", method = { RequestMethod.GET })
	public String index(HttpServletRequest request,HttpServletResponse response){
		
		return "security/tree/index";
		
	}
	
	@RequestMapping(value = "/module/security/getTree", method = { RequestMethod.GET })
	@ResponseBody
	public Tree getTree(HttpServletRequest request,HttpServletResponse response){
		
		Tree u = m_oTreeService.getById(1);
		
		return u;
		
	}
	
	@RequestMapping(value = "/module/security/getAllTree", method = { RequestMethod.GET })
	@ResponseBody
	public List<TreeVO> getAllTree(HttpServletRequest request,HttpServletResponse response){
		List<TreeVO> p = new ArrayList<TreeVO>();
		TreeVO u = m_oTreeService.getAllTree();
		p.add(u);
		return p;
		
	}
	
	
	
	

}
