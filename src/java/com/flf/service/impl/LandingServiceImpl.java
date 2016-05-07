package com.flf.service.impl;

import java.util.List;


import com.flf.entity.Landing;
import com.flf.entity.Page;
import com.flf.mapper.LandingMapper;
import com.flf.service.LandingService;


public class LandingServiceImpl implements LandingService{
   
	private LandingMapper landingMapper;
	

	public List<Landing> listPageLanding(Page page) {
		// TODO Auto-generated method stub
		return landingMapper.listPageLanding(page);
	}
	
	public LandingMapper getLandingMapper() {
		return landingMapper;
	}

	public void setLandingMapper(LandingMapper landingMapper) {
		this.landingMapper =landingMapper;
	}

	
}
