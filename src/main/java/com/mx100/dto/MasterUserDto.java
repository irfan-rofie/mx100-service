package com.mx100.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MasterUserDto {
	private String username;
	private String password;
	private Integer userTypeId;
}
