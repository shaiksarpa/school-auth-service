package com.school.auth.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.school.auth.model.AdmissionRecordEntity;

@Repository
public class AdmissionRecordDao extends BaseDao<AdmissionRecordEntity>{
	
	@Override
	protected Class<AdmissionRecordEntity> getDomainClass() {
		return AdmissionRecordEntity.class;
	}

	public AdmissionRecordEntity findByAdmissionNumber(String admissionNumber) {
		Query query = new Query();
		query.addCriteria(Criteria.where("admissionNumber").is(admissionNumber));
		List<AdmissionRecordEntity> list = getMongoTemplate().find(query, AdmissionRecordEntity.class);
		if(!CollectionUtils.isEmpty(list)) {
			return list.iterator().next();
		}
		 
		return null;
	}
}
