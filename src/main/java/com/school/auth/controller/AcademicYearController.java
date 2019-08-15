package com.school.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.auth.dto.AcademicYearDto;
import com.school.auth.dto.ResponseList;
import com.school.auth.exception.ApplicationException;
import com.school.auth.model.AcademicYearEntity;
import com.school.auth.service.AcademicYearService;

@RestController
@RequestMapping("academic-year")
public class AcademicYearController {

	@Autowired
	private AcademicYearService academicYearService;
	
	@GetMapping
	public ResponseList findAll() {
		return new ResponseList(academicYearService.findAll());
	}
	
	@PostMapping
	public AcademicYearEntity create(@RequestBody AcademicYearDto academicYearDto) throws ApplicationException {
		return academicYearService.create(academicYearDto);
	}
	
	@PutMapping("deactivate/{academicYear}")
	public AcademicYearEntity deactivate(@PathVariable String academicYear) throws ApplicationException {
		return academicYearService.update(academicYear, false);
	}
	
	@PutMapping("activate/{academicYear}")
	public AcademicYearEntity activate(@PathVariable String academicYear) throws ApplicationException {
		return academicYearService.update(academicYear, true);
	}
	
}
