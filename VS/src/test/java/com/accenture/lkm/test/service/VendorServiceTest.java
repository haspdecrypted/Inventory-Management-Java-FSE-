package com.accenture.lkm.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.service.VendorService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(VendorServiceTest.class);

	/*
	 * Autowire the VendorService object below
	 * 
	 */
	@Autowired
	VendorService vendorService;
	// Your Code Here

	/*
	 * Method - notNullVendorServiceTest()
	 * Assert only that VendorService object is Not null
	 * 
	 */

	@Test
	public void notNullVendorServiceTest() {
		// Your Code Here
		logger.info("Vendor Service test started");
		Assert.assertNotNull("Vendor Service object is empty",vendorService);
	}

	/*
	 * Method - notNullGetVendorDetailsTest()
	 * Assert only that VendorService getVendorDetails is not returning a null value
	 * 
	 */

	@Test
	public void notNullGetVendorDetailsTest() {
		// Your Code Here
		Assert.assertNotNull("Get vendor details method is returning null value",vendorService.getVendorDetails());
	}

	/*
	 * Method - countGetVendorDetailsTest()
	 * Assert only that VendorService getVendorDetails list size matches to 5
	 * 
	 */

	@Test
	public void countGetVendorDetailsTest() {
		// Your Code Here
		int Count = vendorService.getVendorDetails().size();
		Assert.assertEquals("Size does not match",5,Count);
	}

	/*
	 * Method - recordGetVendorDetailsTest()
	 * Assert only that VendorService getVendorDetails first bean name matches --> "Only Vimal"
	 * 
	 */
		
	@Test
	public void recordGetVendorDetailsTest() {
		
		VendorBean vendorBean = vendorService.getVendorDetails().get(0);
		String name = vendorBean.getVendorName();
		Assert.assertEquals("Name mismatch","Only Vimal",name);
	}

}