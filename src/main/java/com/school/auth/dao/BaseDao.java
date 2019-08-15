package com.school.auth.dao;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.DuplicateKeyException;
import com.school.auth.exception.ApplicationException;

@Repository
public abstract class BaseDao<T> {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
    protected abstract Class<T> getDomainClass();

    protected Class<T> domainClass = getDomainClass();

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public List<T> findAll() {
		return mongoTemplate.findAll(domainClass);
	}
	
	public void insert() {
		 mongoTemplate.insert(domainClass);
	}
	
	public void insertAll(List<T> list) throws ApplicationException { 
		try {
			mongoTemplate.insertAll(list);
		} catch (DuplicateKeyException e) {			
			throw new ApplicationException(ExceptionUtils.getRootCauseMessage(e));
		}
	}
	
	public void update(T t) {
		mongoTemplate.save(t);
	}

}
