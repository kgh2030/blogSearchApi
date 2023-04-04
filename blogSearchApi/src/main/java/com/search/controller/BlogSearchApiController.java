package com.search.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.search.response.ResponseUtils;
import com.search.response.Response;
import com.search.service.BlogSearchApiService;
import com.search.vo.ParamVO;

import jakarta.validation.Valid;


@RestController
public class BlogSearchApiController {
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private BlogSearchApiService blogSearchApiService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/api/kakaoBlogSearch")
	public Response<Map<String, Object>> kakaoBlogSearch(@Valid ParamVO paramVO) throws Exception {
		blogSearchApiService.keywordSetting(paramVO);
		
		Map<String, Object> resultMap = blogSearchApiService.kakaoBlogSearchList(paramVO);
		int responseCode = (int) resultMap.get("responseCode");
		String responseData = (String) resultMap.get("responseData");
		Map<String, Object> reponseMap = mapper.readValue(responseData, Map.class);
		
		if(responseCode == 200) {
			return ResponseUtils.success(reponseMap, "kakao");
		}else {
			return ResponseUtils.fail(null, reponseMap, "kakao");
		}
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/api/naverBlogSearch")
	public Response<Map<String, Object>> naverBlogSearch(@Valid ParamVO paramVO) throws Exception {
		blogSearchApiService.keywordSetting(paramVO);
		
		Map<String, Object> resultMap = blogSearchApiService.naverBlogSearchList(paramVO);
		int responseCode = (int) resultMap.get("responseCode");
		String responseData = (String) resultMap.get("responseData");
		Map<String, Object> reponseMap = mapper.readValue(responseData, Map.class);
		
		if(responseCode == 200) {
			return ResponseUtils.success(reponseMap, "naver");
		}else {
			return ResponseUtils.fail(null, reponseMap, "naver");
		}
		
	}
	

	@RequestMapping("/api/popularSearchList")
	public Response<List<Map<String, Object>>> popularSearchList() throws Exception {
		return ResponseUtils.success(blogSearchApiService.popularSearchList(), "local");
	}
	
	

}
