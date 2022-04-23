package com.springboot.awsmysql.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.awsmysql.Entity.input_details;
import com.springboot.awsmysql.Entity.Mayur_Chinche_java_output;
import com.springboot.awsmysql.Service.InputDetailsService;
import com.springboot.awsmysql.Service.OutputDetailsService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class InputDetailsController {
	

	@Autowired
	private InputDetailsService inputDetailsService;
	
	@Autowired
	private OutputDetailsService outputDetailsService;
	private static final Logger logger = LogManager.getLogger(InputDetailsController.class);
		
		@RequestMapping(value ="/viewAllInputputDetails",method = RequestMethod.GET) //Endpoint to get all the details from input_table.
		public Collection<input_details> getAllInputDetails()
		{
			logger.info("Inside  getAllInputDetails() ");
			return inputDetailsService.getAllInputDetails();
		}

		@RequestMapping(value ="/viewAllOutputDetails",method = RequestMethod.GET) //Endpoint to get all the details from input_table.
		public Collection<Mayur_Chinche_java_output> getAllOutputDetails()
		{
			logger.info("Inside getAllOutputDetails() ");
			return outputDetailsService.getAllOutputDetails();
		}
		
		@RequestMapping(value ="/InsertOutputDetails",method = RequestMethod.GET) //Endpoint to get all the details from input_table.
		public Collection<Mayur_Chinche_java_output> insertOutputDetails()
		{
			logger.info("Inside insertOutputDetails() ");
			return outputDetailsService.insertOutputDetails();
		}
}
