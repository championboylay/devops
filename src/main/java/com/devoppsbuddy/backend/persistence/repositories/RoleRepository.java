package com.devoppsbuddy.backend.persistence.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devoppsbuddy.backend.persistence.domain.backend.Role;

/**
 * Created by tedonema on 29/03/2016.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
