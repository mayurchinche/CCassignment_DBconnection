package com.springboot.awsmysql.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.awsmysql.Dao.InputDetailsDao;
import com.springboot.awsmysql.Dao.OutPutDetailsDao;
import com.springboot.awsmysql.Entity.input_details;
import com.springboot.awsmysql.Entity.Mayur_Chinche_java_output;
//service for managing output details.
@Service
public class OutputDetailsService {
	@Autowired
	@Qualifier("mysql1")
	public OutPutDetailsDao outPutDetailsDao;
	
	public Collection<Mayur_Chinche_java_output>getAllOutputDetails()
	{
		
		return this.outPutDetailsDao.getAllOutputDetails();
	}
	
	public Collection<Mayur_Chinche_java_output> insertOutputDetails()
	{
		return this.outPutDetailsDao.insertOutputDetails();
	}
	
}
