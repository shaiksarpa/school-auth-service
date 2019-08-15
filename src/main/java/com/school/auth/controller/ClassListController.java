package com.school.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.auth.constant.ClassEnum;
import com.school.auth.dto.ResponseList;

@RestController
@RequestMapping("class-list")
public class ClassListController {
	
	@GetMapping
	public ResponseList list() {
		return new ResponseList(ClassEnum.list());		
	}

}
