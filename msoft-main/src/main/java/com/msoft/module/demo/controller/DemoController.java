package com.msoft.module.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.log.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msoft.core.pojo.demo.Demo;
import com.msoft.module.common.controller.CommonController;

@Controller
public class DemoController extends CommonController {
	
	@RequestMapping(value = "/module/demo/index", method = { RequestMethod.GET })
	public String demo(){
		return "demo/index";
	}
	
	@RequestMapping(value = "/module/demo/getPageData", method = { RequestMethod.GET })
	public Map getPageData(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "page", required = true, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = true, defaultValue = "15") int limit){
		
		Log.info("getPageData");
		
		Log.info("page:"+page+",limit:"+limit);
		int offset = 0;
		offset = (page-1) * limit;
		int end = 0;
		end = offset+limit;
		Log.info("page:"+page+",limit:"+limit+",offset:"+offset);
		
		if(end>100){
			end = 100;
		}
		
		
		Map result = new HashMap<String,String>();
		List<Demo> alldata = new ArrayList<Demo>(); 
		
		for(int i = 1;i<=100;i++){
			Demo d = new Demo();
			d.setId(i);
			d.setName("demo"+i);
			d.setPhone("159"+i+"0000000");
			
			if(i % 2 ==0){
				d.setType(1);
				d.setTypeName("type01");
			}else{
				d.setType(2);
				d.setTypeName("type02");
			}
			
			
			d.setAddress("demoadd"+i);
			alldata.add(d);
		}
		List<Demo> data = new ArrayList<Demo>();
		for(int i=offset;i<end;i++){
			data.add(alldata.get(i));
		}
		
		result.put("totals", alldata.size());
		result.put("data", data);
		return result;
		
	}
	
	@RequestMapping(value = "/module/demo/editDemo", method = { RequestMethod.POST })
	public String editDemo(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "id", required = true, defaultValue = "1") int id,
			@RequestParam(value = "phone", required = true, defaultValue = "1") String phone,
			@RequestParam(value = "name", required = true, defaultValue = "1") String name,
			@RequestParam(value = "address", required = true, defaultValue = "1") String address,
			@RequestParam(value = "type", required = true, defaultValue = "1") int type){
		
		Log.info("name:"+name+",id:"+id+",type="+type);
		
		Map<String,String> result = new HashMap<String,String>();
		result.put("success", "true");
		result.put("msg", "success for edit");
		String str = "{\"success\":true,\"msg\":\"test\"}";
		request.setAttribute("sResponse", str);
		return "common/form_response";
		
	}
	@RequestMapping(value = "/module/demo/getCombobox", method = { RequestMethod.GET })
	@ResponseBody
	public String getCombobox(HttpServletRequest request,HttpServletResponse response){
		
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("[{").append("\"id\":").append("1")
		    .append(",").append("\"value\":").append("\"type01\"").append("},")
		    .append("{\"id\":").append("2")
		    .append(",").append("\"value\":").append("\"type02\"").append("}]");
		return sb.toString();
	}

}
