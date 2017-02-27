package com.devoppsbuddy.backend.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devoppsbuddy.backend.persistence.domain.backend.Plan;
import com.devoppsbuddy.backend.persistence.domain.backend.User;
import com.devoppsbuddy.backend.persistence.domain.backend.UserRole;
import com.devoppsbuddy.backend.persistence.repositories.PlanRepository;
import com.devoppsbuddy.backend.persistence.repositories.RoleRepository;
import com.devoppsbuddy.backend.persistence.repositories.UserRepository;
import com.devoppsbuddy.enums.PlanEnum;

@Service
@Transactional(readOnly =true)
public class UserService {
	
	@Autowired
	private PlanRepository planRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User creatUser(User user,PlanEnum planEnum,Set<UserRole> userRoles){
		Plan p = new Plan(planEnum);
		
		if (!planRepository.exists(p.getId())){
			planRepository.save(p);
		}
		
		user.setPlan(p);
		
		for(UserRole ur : userRoles){
			roleRepository.save(ur.getRole());
		}
		
		user.getUserRoles().addAll(userRoles);
		
		user = userRepository.save(user);
		return user;
	}
}
