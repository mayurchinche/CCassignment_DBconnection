package com.springboot.awsmysql.Dao;

import java.util.Collection;

import com.springboot.awsmysql.Entity.input_details;

//Dao of input details.
public interface InputDetailsDao {

	Collection<input_details> getAllInputDetails();

}