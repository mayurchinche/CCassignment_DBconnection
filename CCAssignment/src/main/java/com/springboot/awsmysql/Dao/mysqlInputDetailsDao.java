package com.springboot.awsmysql.Dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.springboot.awsmysql.Entity.input_details;

//Repository for performing operations on input details.
@Repository("mysql")
public class mysqlInputDetailsDao implements InputDetailsDao{
	
	private static final Logger logger = LogManager.getLogger(mysqlInputDetailsDao.class);
		
	@Override
	public Collection<input_details> getAllInputDetails() {
		
		logger.info("Inside getAllInputDetails() ");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence_properties");		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		logger.info("Established Database Connection successfully.");
		
		
			
		Collection<input_details> input_details_final= entityManager.createQuery("SELECT a FROM input_details a", input_details.class).getResultList();
		
		for(input_details input_details_log:input_details_final)
		{
			logger.info(input_details_log.toString());
		}
		
		return input_details_final;
		}
}
