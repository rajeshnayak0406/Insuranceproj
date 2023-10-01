package com.insurance.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;

@Entity

@Data
@Getter

@Table(name="PLAN_CATEGORY")

public class PlanCategory {
	
@Id
@GeneratedValue
@Column(name="CATEGORY_ID")
 private Integer categoryId;

@Column(name ="CATEGORY_NAME")
 private String categoryName;

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
