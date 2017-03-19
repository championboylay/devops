package com.devoppsbuddy.integration;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.devoppsbuddy.DevoppsbuddyApplication;
import com.devoppsbuddy.backend.persistence.domain.backend.Plan;
import com.devoppsbuddy.backend.persistence.domain.backend.Role;
import com.devoppsbuddy.backend.persistence.domain.backend.User;
import com.devoppsbuddy.backend.persistence.domain.backend.UserRole;
import com.devoppsbuddy.backend.persistence.repositories.PlanRepository;
import com.devoppsbuddy.backend.persistence.repositories.RoleRepository;
import com.devoppsbuddy.backend.persistence.repositories.UserRepository;
import com.devoppsbuddy.backend.service.UserService;
import com.devoppsbuddy.enums.PlanEnum;
import com.devoppsbuddy.enums.RoleEnum;
import com.devoppsbuddy.utils.UsersUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DevoppsbuddyApplication.class)
public class UserIntegrationTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testCreateNewUser(){
		String username = "proUser";
		String email = "promail@mail.com";
		Set<UserRole> userRoles = new HashSet<>();
		User basicUser = UsersUtils.createBasicUser(username,email);
		userRoles.add(new UserRole(basicUser,new Role(RoleEnum.BASIC)));
		User user = userService.creatUser(basicUser, PlanEnum.BASIC, userRoles);
		org.junit.Assert.assertNotNull(user);
		org.junit.Assert.assertNotNull(user.getId());
	}

	
}
