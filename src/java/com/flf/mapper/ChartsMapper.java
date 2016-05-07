package com.flf.mapper;

import java.util.List;

import com.flf.entity.Charts;
import com.flf.entity.Page;

public interface ChartsMapper {
	List<Charts> listPageInfo(Page page);
}
