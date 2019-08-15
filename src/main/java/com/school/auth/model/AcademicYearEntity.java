package com.school.auth.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="academicYear")
public class AcademicYearEntity {

	@Id
	private String id;
	
	@Indexed
	private String code;
	
	private boolean active;

}
