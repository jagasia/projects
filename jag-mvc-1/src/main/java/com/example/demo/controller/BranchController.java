package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.ApiClient;
import com.example.demo.model.Branch;

@Controller
public class BranchController {

	@Autowired
	private ApiClient apiClient;
	
	@GetMapping("/showbranch")
	public ModelAndView showBranch()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("branch");
		List<Branch> branchList = apiClient.read();
		mv.addObject("branches", branchList);
		mv.addObject("branch",new Branch());
		return mv;
	}	
		
		
		@RequestMapping(method = RequestMethod.POST, value = "/branch", params = "add")
		public ModelAndView addBranch(Branch branch)
		{
			System.out.println(branch);
			apiClient.create(branch);
			return showBranch();
		}
		
		@RequestMapping(method = RequestMethod.POST, value = "/branch", params = "modify")
		public ModelAndView modifyBranch(Branch branch)
		{
			apiClient.update(branch);
			return showBranch();
		}
		
		@RequestMapping(method = RequestMethod.POST, value = "/branch", params = "delete")
		public ModelAndView deleteBranch(Branch branch)
		{
			apiClient.delete(branch.getBid());
			return showBranch();
		}
		
		@GetMapping("/select")
		public ModelAndView select(@RequestParam("bid") String bid)
		{
			Branch branch = apiClient.read(bid);
			List<Branch> branches = apiClient.read();
			ModelAndView mv=new ModelAndView();
			mv.setViewName("branch");
			mv.addObject("branch",branch);
			mv.addObject("branches",branches);
			return mv;
		}
}
