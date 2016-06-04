package com.msoft.module.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msoft.module.common.controller.CommonController;

@Controller
public class MainController extends CommonController {
	
	@RequestMapping(value = "/module/main/index", method = { RequestMethod.GET })
	public String index(){
		return "main/index";
	}

}
