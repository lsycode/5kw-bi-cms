package com.flf.service;

import java.util.List;

import com.flf.entity.Landing;
import com.flf.entity.Page;

public interface LandingService {
	List<Landing> listPageLanding(Page page);
}
