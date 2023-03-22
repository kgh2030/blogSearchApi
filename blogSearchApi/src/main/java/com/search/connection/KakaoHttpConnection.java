package com.search.connection;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.search.vo.ParamVO;

public class KakaoHttpConnection {
	
	private static final String API_KEY = "f2cd178210900b0c6fe7585f496bfab2";
	
	private static final String BLOG_URL = "https://dapi.kakao.com/v2/search/blog";
	
	
	public Map<String, Object> searchBlogConnection(ParamVO paramVO) throws Exception {
		String query = paramVO.getQuery();
		String sort = paramVO.getSort();
		Integer page = paramVO.getPage();
		Integer size = paramVO.getSize();
		
		String paramStr = "";
		paramStr +="query="+ URLEncoder.encode(query, "UTF-8");
		paramStr +="&sort="+sort;
		paramStr +="&page="+page;
		paramStr +="&size="+size;
		
		HttpConnection conn = new HttpConnection();
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Authorization", "KakaoAK " + API_KEY);
		return conn.httpConnection(BLOG_URL+"?"+paramStr, requestHeaders);
		
	}


}
