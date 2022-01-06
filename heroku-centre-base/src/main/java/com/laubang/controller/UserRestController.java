package com.laubang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laubang.model.entity.UserProfile;
import com.laubang.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserProfile> getUserProfileList() {
		return userService.selectAll();
	}
	
}
