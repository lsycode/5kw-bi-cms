package com.flf.mapper;

import java.util.List;

import com.flf.entity.Landing;
import com.flf.entity.Page;

public interface LandingMapper {
	List<Landing> listPageLanding(Page page);
}
