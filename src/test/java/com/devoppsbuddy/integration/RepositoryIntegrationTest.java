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
import com.devoppsbuddy.enums.PlanEnum;
import com.devoppsbuddy.enums.RoleEnum;
import com.devoppsbuddy.utils.UsersUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DevoppsbuddyApplication.class)
public class RepositoryIntegrationTest {

	@Autowired
	private PlanRepository planRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	

	/*private static final Integer BASIC_ROLE_ID = 1;
	private static final Integer BASIC_PLAN_ID = 1;*/

	@Before
	public void init() {
		org.junit.Assert.assertNotNull(planRepository);
		org.junit.Assert.assertNotNull(roleRepository);
		org.junit.Assert.assertNotNull(userRepository);
	}

	@Test
	@Ignore
	public void testCreateNewPlan() throws Exception {
		Plan plan = createPlan(PlanEnum.BASIC);
		planRepository.save(plan);
		Plan retrievedPlan = planRepository.findOne(PlanEnum.BASIC.getId());
		org.junit.Assert.assertNotNull(retrievedPlan);
	}

	@Test
	@Ignore
	public void testCreateNewRole() throws Exception {

		Role userRole = createRole(RoleEnum.BASIC);
		roleRepository.save(userRole);

		Role retrievedRole = roleRepository.findOne(RoleEnum.BASIC.getId());
		org.junit.Assert.assertNotNull(retrievedRole);
	}
	
	@Test
	public void testCreateUser(){
		Plan plan = createPlan(PlanEnum.BASIC);
		planRepository.save(plan);
		
		User basicUser = UsersUtils.createBasicUser();
		basicUser.setPlan(plan);
		
		Role basicRole = createRole(RoleEnum.BASIC);
		
		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole(basicUser,basicRole);
		
		userRoles.add(userRole);
		
		basicUser.getUserRoles().addAll(userRoles);
		
		for(UserRole ur : userRoles){
			roleRepository.save(ur.getRole());
		}
		
		basicUser = userRepository.save(basicUser);
		User newlyCreatedUser = userRepository.findOne(basicUser.getId());
		org.junit.Assert.assertNotNull(newlyCreatedUser);
		
		Set<UserRole> newlyCreatedUserRoles = newlyCreatedUser.getUserRoles();
		for(UserRole ur:newlyCreatedUserRoles){
			org.junit.Assert.assertNotNull(ur.getRole());
		}
		
	}

	private Role createRole(RoleEnum roleEnum) {
		return new Role(roleEnum);
	}

	private Plan createPlan(PlanEnum planEnum) {
		return new Plan(planEnum);
	}
	
	private User createUser(){
		User user = new User();
		user.setEmail("amh@gmail.com");
		return user;
	}

}
