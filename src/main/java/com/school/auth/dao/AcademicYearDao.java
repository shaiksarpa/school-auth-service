package com.school.auth.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.auth.model.AcademicYearEntity;

@Repository
public interface AcademicYearDao extends MongoRepository<AcademicYearEntity, String> {
	
	public AcademicYearEntity findByCode(String code);
	
	@Query(("{ 'active' : true }"))
	public AcademicYearEntity findActiveAcademicYear();

}
