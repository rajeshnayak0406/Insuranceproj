package com.insurance.service;

import java.util.List;
import java.util.Map;

import com.insurance.entity.Plan;



public interface PlanService {
	
	public Map<Integer,String> getplanCategories();
	
	public boolean savePlan(Plan plan);
	
	public List<Plan> getAllPlans();
	
	public Plan getPlanByID(Integer planID);
	
	public boolean updatePlan(Plan plan);
	
	public boolean deletePlanById(Integer planId);
	
	public boolean planStatusChange(Integer planId,String status);
	

}
