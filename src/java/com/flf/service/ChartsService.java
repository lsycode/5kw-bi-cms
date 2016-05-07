package com.flf.service;

import java.util.List;

import com.flf.entity.Charts;
import com.flf.entity.Page;

public interface ChartsService {
	List<Charts> listPageInfo(Page page);
}
