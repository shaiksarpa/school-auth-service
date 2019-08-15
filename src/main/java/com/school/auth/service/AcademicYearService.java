package com.school.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.auth.dao.AcademicYearDao;
import com.school.auth.dto.AcademicYearDto;
import com.school.auth.exception.ApplicationException;
import com.school.auth.model.AcademicYearEntity;

@Service
public class AcademicYearService {
	
	@Autowired
	private AcademicYearDao academicYearDao;

	public List<AcademicYearEntity> findAll() {
		return academicYearDao.findAll();
	}	
	
	public AcademicYearEntity create(AcademicYearDto academicYearDto) throws ApplicationException {
		
		AcademicYearEntity academicYearEntityExists = academicYearDao.findByCode(academicYearDto.getCode());
		if(academicYearEntityExists != null) {
			throw new ApplicationException("Academic Year Exists");
		}
		
		if(academicYearDto.isActive() && academicYearDao.findActiveAcademicYear() != null) {
			throw new ApplicationException("Active Academic Year Exists");
		}
		AcademicYearEntity academicYearEntity = new AcademicYearEntity();
		academicYearEntity.setActive(academicYearDto.isActive());
		academicYearEntity.setCode(academicYearDto.getCode());
		return academicYearDao.save(academicYearEntity);
		
	}
	
	public AcademicYearEntity update(String code, boolean active) throws ApplicationException {
		AcademicYearEntity academicYearEntityExists = academicYearDao.findByCode(code);
		if(academicYearEntityExists == null) {
			throw new ApplicationException("Academic Year doesnt exists");
		}
		if(academicYearEntityExists.isActive() == active) {
			return academicYearEntityExists;
		}
		
		if(active && academicYearDao.findActiveAcademicYear() != null) {
			throw new ApplicationException("Active Academic Year Exists");
		}
		
		academicYearEntityExists.setActive(active);
		return academicYearDao.save(academicYearEntityExists);		
	}
}
