package com.search.service;

import java.util.List;
import java.util.Map;

import com.search.vo.ParamVO;

public interface BlogSearchApiService {
	
	public Map<String, Object> kakaoBlogSearchList(ParamVO paramVO) throws Exception;
	
	public Map<String, Object> naverBlogSearchList(ParamVO paramVO) throws Exception;
	
	public List<Map<String, Object>> popularSearchList() throws Exception;
	
	public void keywordSetting(ParamVO paramVO) throws Exception;

}
