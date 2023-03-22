package com.search.response;

public class Response<T> {
	
	private String status;
	
	private String message;
	
	private String apiOffer;

	private T data;
	
	private T apiError;
	
	public Response(String status, String message, String apiOffer, T data, T apiError) {
		this.status = status;
		this.message = message;
		this.apiOffer = apiOffer;
		this.data = data;
		this.apiError = apiError;
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getApiOffer() {
		return apiOffer;
	}

	public void setApiOffer(String apiOffer) {
		this.apiOffer = apiOffer;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getApiError() {
		return apiError;
	}

	public void setApiError(T apiError) {
		this.apiError = apiError;
	}
	

}
