package com.msoft.module.tree.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.log.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msoft.core.vo.security.TreeCheckBoxVO;
import com.msoft.core.vo.security.TreeVO;
import com.msoft.module.common.controller.CommonController;

@Controller
public class TTreeController extends CommonController {

	@RequestMapping(value = "/module/ttree/test", method = { RequestMethod.GET })
	@ResponseBody
	public List<TreeCheckBoxVO> test(HttpServletRequest request,HttpServletResponse response){
		List<TreeCheckBoxVO> p = new ArrayList<TreeCheckBoxVO>();
		
		Log.info("tree");
		TreeCheckBoxVO root = new TreeCheckBoxVO();
		root.setId(1);
		root.setText("root");
		root.setIcons("folder");
		root.setUrl("rooturl");
		root.setLeaf(Boolean.FALSE);
		
		List<TreeCheckBoxVO> children = new ArrayList<TreeCheckBoxVO>();
		TreeCheckBoxVO children1 = new TreeCheckBoxVO();
		children1.setId(2);
		children1.setText("children1");
		children1.setIcons("leaf");
		children1.setUrl("children1url");
		children1.setLeaf(Boolean.TRUE);
		children1.setChecked(Boolean.FALSE);
		children.add(children1);
		
		TreeCheckBoxVO children2 = new TreeCheckBoxVO();
		children2.setId(3);
		children2.setText("children2");
		children2.setIcons("leaf");
		children2.setUrl("children2url");
		children2.setLeaf(Boolean.TRUE);
		children.add(children2);
		
		root.setChildren(children);
		
		p.add(root);
		
		
		TreeCheckBoxVO root2 = new TreeCheckBoxVO();
		root2.setId(4);
		root2.setText("root2");
		root2.setIcons("folder");
		root2.setUrl("rooturl");
		root2.setLeaf(Boolean.FALSE);
		
		List<TreeCheckBoxVO> children02 = new ArrayList<TreeCheckBoxVO>();
		TreeCheckBoxVO children12 = new TreeCheckBoxVO();
		children12.setId(5);
		children12.setText("children1");
		children12.setIcons("leaf");
		children12.setUrl("children1url");
		children12.setLeaf(Boolean.TRUE);
		children12.setChecked(Boolean.FALSE);
		children02.add(children12);
		
		TreeCheckBoxVO children22 = new TreeCheckBoxVO();
		children22.setId(6);
		children22.setText("children2");
		children22.setIcons("leaf");
		children22.setUrl("children2url");
		children22.setLeaf(Boolean.TRUE);
		children02.add(children22);
		
		root2.setChildren(children02);
		p.add(root2);
		return p;
	}
	
	@RequestMapping(value = "/module/ttree/test2", method = { RequestMethod.GET })
	@ResponseBody
	public List<TreeVO> test2(HttpServletRequest request,HttpServletResponse response){
		List<TreeVO> p = new ArrayList<TreeVO>();
		
		Log.info("tree");
		TreeVO root = new TreeVO();
		root.setId(1);
		root.setText("test");
		root.setIcons("folder");
		root.setUrl("rooturl");
		root.setLeaf(Boolean.FALSE);
		
		List<TreeVO> children = new ArrayList<TreeVO>();
		TreeVO children1 = new TreeVO();
		children1.setId(2);
		children1.setText("children1");
		children1.setIcons("leaf");
		children1.setUrl("children1url");
		children1.setLeaf(Boolean.TRUE);
		children.add(children1);
		
		TreeVO children2 = new TreeVO();
		children2.setId(3);
		children2.setText("children2");
		children2.setIcons("leaf");
		children2.setUrl("children2url");
		children2.setLeaf(Boolean.TRUE);
		children.add(children2);
		
		root.setChildren(children);
		p.add(root);
		
		return p;
	}
}
