package com.insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entity.Plan;

@Repository
public interface PlanRepo extends JpaRepository<Plan, Integer> {

	
}
