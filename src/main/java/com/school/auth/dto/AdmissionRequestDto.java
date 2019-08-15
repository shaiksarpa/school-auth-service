package com.school.auth.dto;

import java.util.List;

import javax.validation.Valid;

import com.school.auth.model.AdmissionRecordEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdmissionRequestDto {
	
	@Valid
	private List<AdmissionRecordEntity> admissionRecords;

}
