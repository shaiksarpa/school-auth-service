package com.school.auth.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.auth.dto.AdmissionRequestDto;
import com.school.auth.exception.ApplicationException;
import com.school.auth.model.AdmissionRecordEntity;
import com.school.auth.service.AdmissionRecordService;

@RestController
@RequestMapping("/admission")
public class AdmissionRecordController {
	
	@Autowired
	private AdmissionRecordService admissionRecordService;
	
	@GetMapping("/list")
	public List<AdmissionRecordEntity> findAll() {
		return admissionRecordService.findAll();
	}
	
	@PostMapping
	public void save(@Valid @RequestBody AdmissionRequestDto admissionRequest) throws ApplicationException {
		admissionRecordService.saveAll(admissionRequest.getAdmissionRecords());
	}
	
	@GetMapping("/admissionNumber/{admissionNumber}") 
	public AdmissionRecordEntity findByAdmissionNumber(@PathVariable("admissionNumber") String admissionNumber) { 
		return admissionRecordService.findByAdmissionNumber(admissionNumber);
	}
	
	@PutMapping
	public void update(@Valid @RequestBody AdmissionRecordEntity admissionRecord) throws ApplicationException {
		admissionRecordService.update(admissionRecord);
	}
	
}
