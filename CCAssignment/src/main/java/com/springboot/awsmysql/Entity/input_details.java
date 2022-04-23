package com.springboot.awsmysql.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

//pojo for input details table

@Entity
public class input_details {
	
	@Id
	private int id;
	private String input_string;
	
	public input_details(int id, String input_string) {
		super();
		this.id = id;
		this.input_string = input_string;
	}
	
	public input_details()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInput_string() {
		return input_string;
	}

	public void setInput_string(String input_string) {
		this.input_string = input_string;
	}

	@Override
	public String toString() {
		return "input_details [id=" + id + ", input_string=" + input_string + "]";
	}
	
	
	
}
