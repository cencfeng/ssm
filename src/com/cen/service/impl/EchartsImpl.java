package com.cen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cen.entity.Echarts;
import com.cen.mapper.ReportMapper;
import com.cen.service.Reportservice;
@Service
public class EchartsImpl implements Reportservice {

	@Autowired
	ReportMapper reportMapper;
	@Override
	public List<Echarts> getReport() {
		// TODO Auto-generated method stub
		return reportMapper.getReport();
	}

}
