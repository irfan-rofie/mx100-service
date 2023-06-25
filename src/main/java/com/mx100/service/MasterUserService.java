package com.mx100.service;

import com.mx100.dto.MasterUserDto;
import com.mx100.model.MasterUser;

public interface MasterUserService {

	public MasterUser createUser(MasterUserDto dto);
	
	public Boolean isEmployer();
	
	public Boolean isFreelancer();
	
}
