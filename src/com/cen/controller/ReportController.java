package com.cen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cen.entity.Echarts;
import com.cen.service.Reportservice;

@Controller
@RequestMapping("/Report")
public class ReportController {

	@Autowired
	Reportservice reportService;
	@RequestMapping("/echarts")
	public String Recharts()
	{
		return "echarts";
	}
	
	@RequestMapping("/ageper")
	@ResponseBody
	public List<Echarts> getReport()
	{
		List<Echarts> list=reportService.getReport();
	    return list;
	}
}
