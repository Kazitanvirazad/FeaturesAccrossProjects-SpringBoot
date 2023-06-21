package com.featuresaccrossprojects.featuresdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featuresaccrossprojects.featuresdata.dao.User;
import com.featuresaccrossprojects.featuresdata.jparepo.UserRepo;

@Service
public class UserDataService {

	@Autowired
	private UserRepo userRepo;

	public User getUserById(String userId) {
		User user = null;
		if (userId != null && userId.length() > 0) {
			user = userRepo.getReferenceById(userId);
		}
		return user;
	}
}
