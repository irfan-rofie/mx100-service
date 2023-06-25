package com.mx100.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mx100.dto.MasterUserDto;
import com.mx100.service.MasterUserService;

@RestController
@RequestMapping("/")
public class RootController {

	@Autowired
	private MasterUserService masterUserService;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> root() {
		MasterUserDto dto = new MasterUserDto();
		dto.setUsername("freelancer2@ajobthing.com");
		dto.setPassword("freelancer2");
		dto.setUserTypeId(2);
		masterUserService.createUser(dto);
		return ResponseEntity.ok("MX100 v1.0.0 is running ......");
	}
	
}
