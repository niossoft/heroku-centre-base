package com.laubang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laubang.model.entity.UserProfile;
import com.laubang.repository.UserProfileRepository;

@Service
public class UserService extends BaseService<UserProfile> {

	@Autowired
	UserProfileRepository userProfileRepository;

	@Override
	public UserProfile insert(UserProfile entity) {
		return userProfileRepository.save(entity);
	}
	
	@Override
	public UserProfile selectByPrimaryKey(UserProfile entity) {
		return userProfileRepository.getById(entity.getUserId());
	}

	@Override
	public UserProfile update(UserProfile entity) {
		return userProfileRepository.save(entity);
	}

	@Override
	public void delete(UserProfile entity) {
		userProfileRepository.delete(entity);
	}

	@Override
	public List<UserProfile> selectAll() {
		return userProfileRepository.findAll();
	}

}
