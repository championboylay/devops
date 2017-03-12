package com.devoppsbuddy.backend.persistence.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devoppsbuddy.backend.persistence.domain.backend.User;

/**
 * Created by tedonema on 29/03/2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);
}
