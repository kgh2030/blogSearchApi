package com.search.response;

public class ResponseUtils {
	
	public static <T> Response<T> success(T data, String apiOffer){
		return new Response<>("SUCCESS", null, apiOffer, data, null);
	}
	
	public static <T> Response<T> fail(String message, T apiError, String apiOffer){
		return new Response<>("FAIL", message, apiOffer, null, apiError);
	}
	
	public static <T> Response<T> error(String message){
		return new Response<>("ERROR", message, null, null, null);
	}
	

}
