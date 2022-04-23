package com.springboot.awsmysql.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

//pojo for output details table
@Entity
public class Mayur_Chinche_java_output {

	@Id
	private int id;
	private String final_ouput;
	private int count;
	private String nameWithTimeStamp;
	
	public Mayur_Chinche_java_output()
	{
		
	}

	public Mayur_Chinche_java_output(int id, String final_ouput, int count, String nameWithTimeStamp) {
		super();
		this.id = id;
		this.final_ouput = final_ouput;
		this.count = count;
		this.nameWithTimeStamp = nameWithTimeStamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFinal_ouput() {
		return final_ouput;
	}

	public void setFinal_ouput(String final_ouput) {
		this.final_ouput = final_ouput;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNameWithTimeStamp() {
		return nameWithTimeStamp;
	}

	public void setNameWithTimeStamp(String nameWithTimeStamp) {
		this.nameWithTimeStamp = nameWithTimeStamp;
	}

	@Override
	public String toString() {
		return "Mayur_Chinche_java_output [id=" + id + ", final_ouput=" + final_ouput + ", count=" + count + ", nameWithTimeStamp="
				+ nameWithTimeStamp + "]";
	}
	
	
	
	
}
