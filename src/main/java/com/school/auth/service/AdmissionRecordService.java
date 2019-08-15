package com.school.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.auth.dao.AdmissionRecordDao;
import com.school.auth.exception.ApplicationException;
import com.school.auth.model.AdmissionRecordEntity;

@Service
public class AdmissionRecordService {
	
	@Autowired
	AdmissionRecordDao admissionRecordDao;
	
	public List<AdmissionRecordEntity> findAll() {
		return admissionRecordDao.findAll();
	}
	
	public void saveAll(List<AdmissionRecordEntity> admissionRecords) throws ApplicationException {
		admissionRecordDao.insertAll(admissionRecords);
	}

	public AdmissionRecordEntity findByAdmissionNumber(String admissionNumber) {
		return admissionRecordDao.findByAdmissionNumber(admissionNumber);
	}
	
	public void update(AdmissionRecordEntity admissionRecord) throws ApplicationException {
		
		if(this.findByAdmissionNumber(admissionRecord.getAdmissionNumber()) == null) {
			throw new ApplicationException("Record not found");
		}
		
		admissionRecordDao.update(admissionRecord);
	}
	
}
