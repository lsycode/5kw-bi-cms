package com.flf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flf.entity.Landing;
import com.flf.entity.Page;
import com.flf.service.LandingService;

@Controller
@RequestMapping(value="/landing")
public class LandingController {
	
	@Autowired
	private LandingService landingService;
	
	@RequestMapping
	public String landing(Model model,Page page){
		List<Landing> landingList = landingService.listPageLanding(page);
		model.addAttribute("landingList", landingList);
		model.addAttribute("page", page);
		return "landing";
	}
	
}

