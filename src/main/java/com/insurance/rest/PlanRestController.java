package com.insurance.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.constants.AppConstants;
import com.insurance.entity.Plan;
import com.insurance.props.AppProperties;
import com.insurance.service.PlanService;

@RestController
public class PlanRestController {


	
	private PlanService planservice;
	
	
	Map<String, String> messages;
	
	
	public PlanRestController(PlanService planservice,AppProperties appPros) {
	 this.planservice=planservice;

	 this.messages=appPros.getMessage();
	 System.out.println(this.messages);
	 
	}
	
	
	
	
	@GetMapping("/")
	public ModelAndView palnCategories1() {

		ModelAndView mv= new ModelAndView();
		mv.setViewName("index");
		return mv;}
	

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> palnCategories() {

		Map<Integer, String> servcat = planservice.getplanCategories();
		return new ResponseEntity<>(servcat, HttpStatus.OK);

	}

	@PostMapping("/plan")
	public ResponseEntity<String> savepalns(@RequestBody Plan plan) {

	
		String responsemsg=AppConstants.EMPTY_STR;
		boolean issaved = planservice.savePlan(plan);
		if (issaved) {
			responsemsg=messages.get(AppConstants.PLAN_SAVE_SUCC);

		}

		else {
			responsemsg = "Plan Not Saved";
		}

		return new ResponseEntity<>(responsemsg, HttpStatus.CREATED);
	}

	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans() {
		List<Plan> allplans = planservice.getAllPlans();
		return new ResponseEntity<>(allplans, HttpStatus.OK);
	}

	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer palnId) {
		Plan plan = planservice.getPlanByID(palnId);
		return new ResponseEntity<>(plan, HttpStatus.OK);

	}

	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
		boolean isUpdated = planservice.updatePlan(plan);
		
		
		String msg =AppConstants.EMPTY_STR;
		if (isUpdated) {
			msg = messages.get(AppConstants.PLAN_UPDATE_SUCC);
		} else {
			msg =  messages.get(AppConstants.PLAN_UPDATE_FAIL);
	}

		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer palnId) {

		boolean isDelted = planservice.deletePlanById(palnId);
		String msg =AppConstants.EMPTY_STR;
		if (isDelted == true) {
			msg =messages.get(AppConstants.PLAN_DELETE_SUCC);
		} else {
			msg =messages.get(AppConstants.PLAN_DELETE_FAIL);
		}

		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status) {

		String msg = AppConstants.EMPTY_STR;
		boolean isStatusChange = planservice.planStatusChange(planId, status);

		if (isStatusChange) {
			msg =messages.get(AppConstants.PLAN_STATUS_CHANGE);
		} else {
			msg =messages.get(AppConstants.PLAN_STATUS_CAHNGE_FAIL);
		}

		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
