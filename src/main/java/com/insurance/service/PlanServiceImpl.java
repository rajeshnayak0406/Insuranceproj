package com.insurance.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entity.Plan;

import com.insurance.entity.PlanCategory;
import com.insurance.repo.PlanCategoryRepo;
import com.insurance.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	private PlanRepo planrepo;

	@Autowired
	private PlanCategoryRepo planCategoryRepo;

	/// InsurancePlans/src/main/java/com/insurance/repo/PlanRepo.java

	@Override
	public Map<Integer, String> getplanCategories() {

		List<PlanCategory> categories = planCategoryRepo.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		categories.forEach(category -> {
			categoryMap.put(category.getCategoryId(), category.getCategoryName());

		});

		return categoryMap;

	}

	@Override
	public boolean savePlan(Plan plan) {

		Plan saved = planrepo.save(plan);

		return saved.getPalnID() != null;

	}

	@Override
	public List<Plan> getAllPlans() {

		return planrepo.findAll();

	}

	@SuppressWarnings("deprecation")
	@Override
	public Plan getPlanByID(Integer planID) {

		Optional<Plan> findbyid = planrepo.findById(planID);
		if (findbyid.isPresent()) {
			return findbyid.get();
		}
		return null;

	}

	@Override
	public boolean updatePlan(Plan plan) {
		planrepo.save(plan);
		return plan.getPalnID() != null;

	}

	@Override
	public boolean deletePlanById(Integer planId) {
		try {
			planrepo.deleteById(planId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		Optional<Plan>findbyid= planrepo.findById(planId);
		
		if(findbyid.isPresent()) {
		Plan plan= findbyid.get();
		plan.setActiveSw(status);
		planrepo.save(plan);
		return true;
	}
		return false;
		
	

}
	

}
