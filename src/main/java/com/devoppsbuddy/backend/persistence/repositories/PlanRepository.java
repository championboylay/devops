package com.devoppsbuddy.backend.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devoppsbuddy.backend.persistence.domain.backend.Plan;

/**
 * Created by tedonema on 29/03/2016.
 */
@Repository
public interface PlanRepository extends CrudRepository<Plan, Integer> {
}
