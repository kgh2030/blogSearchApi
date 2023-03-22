package com.search.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.search.connection.KakaoHttpConnection;
import com.search.connection.NaverHttpConnection;
import com.search.entity.TbKeywordSum;
import com.search.repository.KeyWordSumRepository;
import com.search.service.BlogSearchApiService;
import com.search.vo.ParamVO;

@Service("blogSearchApiService")
public class BlogSearchApiServiceImpl implements BlogSearchApiService{
	
	@Autowired
	private KeyWordSumRepository keyWordSumRepository;
	
	@Override
	public Map<String, Object> kakaoBlogSearchList(ParamVO paramVO) throws Exception {
		KakaoHttpConnection kakaoHttp = new KakaoHttpConnection();
		Map<String, Object> resultMap = kakaoHttp.searchBlogConnection(paramVO);
		
		return resultMap;
	}
	
	@Override
	public Map<String, Object> naverBlogSearchList(ParamVO paramVO) throws Exception {
		
		NaverHttpConnection naverHttp = new NaverHttpConnection();
		Map<String, Object> resultMap = naverHttp.searchBlogConnection(paramVO);
		
		return resultMap;
	}
	
	@Override
	public List<Map<String, Object>> popularSearchList() throws Exception {
		return keyWordSumRepository.popularSearchList();
	}
	
	@Override
	@Async
	public void keywordSetting(ParamVO paramVO) {
		String query = paramVO.getQuery();
		if(!"".equals(query) && null != query) {
			int cnt = keyWordSumRepository.checkKeyWord(query);
			if(cnt > 0) {
				keyWordSumRepository.keywordSumCountPlus(query);
				
			}else {
				TbKeywordSum ts = new TbKeywordSum();
				ts.setKeyWord(query);
				ts.setCount(1);
				keyWordSumRepository.save(ts);
				
			}
		}

	}
	
}
