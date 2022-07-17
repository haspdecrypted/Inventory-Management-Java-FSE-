package com.accenture.lkm.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.accenture.lkm.dao.VendorDAO;
import com.accenture.lkm.entity.VendorEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(VendorDAOTest.class);

	/*
	 * Autowire the VendorDAO object below
	 */
	@Autowired
	private VendorDAO vendorDAO;
	// Your Code Here

	
	/*
	 * Method - notNullVendorDAOTest()
	 * Assert only that VendorDAO object is Not null
	 */
	
	//@SuppressWarnings("deprecation")
	@Test
	public void notNullVendorDAOTest() {
		// Your Code Here
			System.out.println("Vendor object test");
		Assert.assertNotNull("DAO object is null",vendorDAO);
	}

	/*
	 * Method - findByIdVendorDAOTest()
	 * Using VendorDAO fetch an entity by its ID --> "V001" 
	 * Assert that the entity fetch and it is Not null 
	 * Assert that the name of the vendor entity fetch is equal to --> "Only Vimal"
	 */

	VendorEntity vendorEntity;
	@Test
	public void findByIdVendorDAOTest() {
		// Your Code Here
		vendorEntity = vendorDAO.findOne("V001");
		Assert.assertNotNull("Assert with given id is null",vendorEntity);
		String name = vendorEntity.getVendorName();
		Assert.assertEquals("Match not successfull", "Only Vimal",name);
		
		
	}

}
