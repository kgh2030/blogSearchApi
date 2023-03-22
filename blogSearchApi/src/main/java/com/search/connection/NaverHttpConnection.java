package com.search.connection;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.search.vo.ParamVO;

public class NaverHttpConnection {
	
	private static final String CLIENT_ID = "eLq1OHRhc4XSXBal_r5x";
	
	private static final String CLIENT_SECRET = "ub5GkdaI03";
	
	private static final String BLOG_URL = "https://openapi.naver.com/v1/search/blog";
	
	
	public Map<String, Object> searchBlogConnection(ParamVO paramVO) throws Exception {
		String query = paramVO.getQuery();
		String sort = paramVO.getSort();
		
		if("accuracy".equals(sort)) {
			sort = "sim";
		}else if("recency".equals(sort)) {
			sort = "date";
		}else {
			sort = "sim";
		}
		
		Integer page = paramVO.getPage();
		Integer size = paramVO.getSize();
		
		String paramStr = "";
		paramStr +="query="+ URLEncoder.encode(query, "UTF-8");
		paramStr +="&sort="+sort;
		paramStr +="&start="+page;
		paramStr +="&display="+size;
		
		HttpConnection conn = new HttpConnection();
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
		requestHeaders.put("X-Naver-Client-Secret", CLIENT_SECRET);
		return conn.httpConnection(BLOG_URL+"?"+paramStr, requestHeaders);
		
	}
	

}
