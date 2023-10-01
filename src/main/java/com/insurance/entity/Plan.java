package com.insurance.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PLAN_MASTER")
public class Plan {
	
	@Id
	@GeneratedValue
	@Column(name = "PLAN_ID")
	private Integer palnID;
	
	@Column(name = "PLAN_NAME")
	private String planName;
	
	@Column(name = "PLAN_START_DATE")
	private LocalDate planStartDate;
	
	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;
	
	@Column(name="PLAN_CATEGORY_ID")
	 private Integer planCategoryId;
	
	
	@Column(name = "ACTIVE_SW")
	 private String activeSw;

	@Column(name = "CREATED_BY")
	 private String createdBy;

	@Column(name = "UPDATED_BY")
	 private String updatedBy;

	@Column(name = "CREATED_DATE",updatable=false)
	 private LocalDate createdDate;

	@Column(name = "UPDATE_DATE",updatable = true)
	 private LocalDate updateDate;
	 
	

}
