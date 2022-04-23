package com.springboot.awsmysql.Dao;

import java.util.Collection;
import java.util.List;

import com.springboot.awsmysql.Entity.input_details;
import com.springboot.awsmysql.Entity.Mayur_Chinche_java_output;

//Dao for output details 
public interface OutPutDetailsDao {

	Collection<Mayur_Chinche_java_output> getAllOutputDetails();
	
	Collection<Mayur_Chinche_java_output> insertOutputDetails();

}
