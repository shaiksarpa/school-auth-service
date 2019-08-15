package com.school.auth.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.school.auth.config.RequiredParam;

import lombok.Data;

@Data
@Document(collection="admissionRecord")
public class AdmissionRecordEntity {

	@Id
	private String id;
	
	@RequiredParam(message = "{validation.required.field}", customMessage = "First Name")
	private String firstName;
	
	@NotBlank(message = "Last Name {validation.required.field}")
	private String lastName;
	
	@NotBlank(message = "Father Name {validation.required.field}")
	private String fatherName;
	
	@NotBlank(message = "Mother Name {validation.required.field}")
	private String motherName;
	
	@NotNull
	@Past(message="Date of Birth Should be in Past")
	private Date dateOfBirth;

	@NotNull
	private Date dateOfJoin;
	
	@NotBlank(message = "Aadhar Number {validation.required.field}")
	private String aadharNumber;
	
	@NotBlank(message = "Admission Number {validation.required.field}")
	@Indexed
	private String admissionNumber;
	
	@NotBlank(message = "Admitted Class {validation.required.field}")
	private String admittedClass;	
	
	@NotBlank(message="Academic Year {validation.required.field}")
	private String academicYear;
	
	private Date tcIssuedDate;
	
	private String tcIssuedBy;
	
	private String tcIssuedClass;	
	
}
