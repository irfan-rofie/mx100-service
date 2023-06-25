package com.mx100.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response<T> {

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";

	private String status;
	private String message;
	private T data;	

	public Response(T data, String status, String message) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

}
