package com.flf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flf.entity.Charts;
import com.flf.entity.Page;
import com.flf.service.ChartsService;

@Controller
@RequestMapping(value="/charts")
public class ChartsController {
	
	@Autowired
	private ChartsService chartsService;
	
	@RequestMapping
	public String charts(Model model,Page page){
		List<Charts> chartsList = chartsService.listPageInfo(page);
		model.addAttribute("chartsList", chartsList);
		model.addAttribute("page", page);
		return "charts";
	}
	
}

