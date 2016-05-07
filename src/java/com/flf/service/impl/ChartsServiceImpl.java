package com.flf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flf.entity.Charts;
import com.flf.entity.Page;
import com.flf.mapper.ChartsMapper;
import com.flf.service.ChartsService;


public class ChartsServiceImpl implements ChartsService{
   
	private ChartsMapper chartsMapper;
	
	public List<Charts> listPageInfo(Page page) {
		// TODO Auto-generated method stub
		return chartsMapper.listPageInfo(page);
	}

	public ChartsMapper getInfoMapper() {
		return chartsMapper;
	}

	public void setChartsMapper(ChartsMapper chartsMapper) {
		this.chartsMapper = chartsMapper;
	}
}
