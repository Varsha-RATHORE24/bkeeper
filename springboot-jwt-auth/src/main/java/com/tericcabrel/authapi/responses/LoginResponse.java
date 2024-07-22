package com.tericcabrel.authapi.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse extends BaseResponse {
    private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


}
