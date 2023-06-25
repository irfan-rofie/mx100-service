package com.mx100.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mx100.constant.UserTypeConstant;
import com.mx100.dto.MasterUserDto;
import com.mx100.exception.ApplicationException;
import com.mx100.model.MasterUser;
import com.mx100.repository.MasterUserRepository;
import com.mx100.repository.MasterUserTypeRepository;
import com.mx100.util.Mx100Util;

@Service
public class MasterUserServiceImpl implements MasterUserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MasterUserRepository userRepository;

	@Autowired
	private MasterUserTypeRepository userTypeRepository;
	
	@Override
	public MasterUser createUser(MasterUserDto dto) {
		MasterUser user = new MasterUser();
		user.setUsername(dto.getUsername());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setUserType(userTypeRepository.findById(dto.getUserTypeId()).get());
		user.setCreatedBy("system");
		user.setCreatedDate(getCretaedDate());
		user.setIsDeleted((short) 0);
		return userRepository.save(user);
	}
	
	private static Date getCretaedDate() {
		Calendar calObject = Calendar.getInstance();
		return calObject.getTime();
	}

	@Override
	public Boolean isEmployer() {
		return getUser().getUserType().getUserTypeId().equals(UserTypeConstant.USER_TYPE_EMPLOYER);
	}

	@Override
	public Boolean isFreelancer() {
		return getUser().getUserType().getUserTypeId().equals(UserTypeConstant.USER_TYPE_FREELANCER);
	}
	
	private MasterUser getUser() {
		String username = Mx100Util.getUsername();
		MasterUser user = userRepository.findOneByUsername(username);
		if (user == null) {
			throw new ApplicationException(String.format("User with username %s not found!", username));
		}
		return user;
	}
}
