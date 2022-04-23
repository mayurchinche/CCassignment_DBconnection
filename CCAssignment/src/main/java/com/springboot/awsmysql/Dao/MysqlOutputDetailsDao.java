package com.springboot.awsmysql.Dao;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import java.util.Stack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.springboot.awsmysql.Entity.input_details;
import com.springboot.awsmysql.Entity.Mayur_Chinche_java_output;

//Repository for performing operations for final output 
@Repository("mysql1")
public class MysqlOutputDetailsDao implements OutPutDetailsDao{
	
	

	private static final Logger logger = LogManager.getLogger(MysqlOutputDetailsDao.class);
	
	
	@Override
	public Collection<Mayur_Chinche_java_output> getAllOutputDetails() {
		
		logger.info("Inside getAllOutputDetails():- ");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence_properties");	
		if(entityManagerFactory!=null)
		{
			logger.info("Established Database Connection successfully.");
		}
		else {

			logger.info("Failed to establish Database Connection");
		}
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		List<Mayur_Chinche_java_output> query=entityManager.createQuery("SELECT a FROM Mayur_Chinche_java_output a", Mayur_Chinche_java_output.class).getResultList();
		
		for(Mayur_Chinche_java_output mayur_Chinche_java_output:query)
			{
			logger.info("Mayur_Chinche_java_output"+mayur_Chinche_java_output.toString());
			}
		
		logger.info("Exiting  getAllOutputDetails() ");
		
		return query;
	}
	@Override
	public Collection<Mayur_Chinche_java_output> insertOutputDetails() {
		
		logger.info("Inside insertOutputDetails():-");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence_properties");		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		
		List<input_details> query=entityManager.createQuery("SELECT a FROM input_details a",input_details.class).getResultList();
		
		ArrayList<Mayur_Chinche_java_output> mayur_Chinche_java_output = new ArrayList<Mayur_Chinche_java_output>();
		
		for( input_details input_details_object : query)
		{
			Mayur_Chinche_java_output  outputDetails=new Mayur_Chinche_java_output();
			String str=input_details_object.getInput_string(); //input_string on which operations to be performed.
			
			
			Stack<Character> stack = new Stack<Character>(); 
		
			str=str.replace(" ", "");
		
			int count=0; //Counting number of intermediate steps for final output
			
			char lastPop='\0';	//to keep the last popped element
			
			char []ch =new char[str.length()];
		
			ch=str.toCharArray();
		
			logger.info("Preparing stack :-");
		
			for(int i=0;i<ch.length;i++)
			{
			
				if(stack.isEmpty()) 
				{
					
					if(lastPop==ch[i])
					{
						continue;
					}
					
					stack.push(ch[i]);
				
					if(stack.peek()==lastPop)
						{
						stack.pop();
						}
				}
			
				else if(stack.peek()!=ch[i] && lastPop !=ch[i]) 
				{
					stack.push(ch[i]);
					lastPop='\0';
				}
				
				else if(stack.peek()==ch[i])
				{
					lastPop=stack.pop();
					
					count++;
				}
				
			
		}
		
		StringBuilder finaloutput = new StringBuilder();//As we are using stack and want to reverse the string which String won't allow using String string builder
		
		while(!stack.isEmpty())
		{
			finaloutput.append(stack.pop());
			
		}
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		  
		String nameWithTimeStamp="Mayur_Chinche"+timestamp.toString();

		outputDetails.setId(input_details_object.getId());
		outputDetails.setCount(count);
		outputDetails.setFinal_ouput(finaloutput.reverse().toString());
		outputDetails.setNameWithTimeStamp(nameWithTimeStamp);
		
		

	    mayur_Chinche_java_output.add(outputDetails);
	
	    
		outputDetails=null;
		
		}
		
		entityManager.getTransaction().begin();
		
		
	for(Mayur_Chinche_java_output mayur_Chinche_java_output_final :mayur_Chinche_java_output)
		{
		
			logger.info("Inserting :-"+mayur_Chinche_java_output.toString());
			entityManager.persist(mayur_Chinche_java_output_final);
			
		}			
	entityManager.getTransaction().commit();

	logger.info("Exiting Operation on input_details");
	
	return mayur_Chinche_java_output;
	
	}
	
	
	


	
}
