package com.example.demo.to;

import javax.xml.ws.Response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

public class Message {
	String message;
	HttpStatus statusCode;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}


}
