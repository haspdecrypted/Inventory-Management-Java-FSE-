package com.accenture.lkm.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.lkm.dao.PurchaseDAO;
import com.accenture.lkm.entity.PurchaseEntity;



@SpringBootTest
public class PurchaseDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(PurchaseDAOTest.class);

	@Autowired
	private PurchaseDAO purchaseDAO;
	// Your Code Here
	
	@Test
	public void testSavePurchaseDetail() throws Exception {
		//implementation goes here
		Assert.assertNotNull("DAO Object is Null",purchaseDAO);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd"); 
		Date d1 = format. parse("2020-05-17"); 
		System.out.println("Started");
		PurchaseEntity purchaseEntity = new PurchaseEntity((Integer)1, "P_ONL_05172020_THR_1", "Only Vimal", "C001", "T001","Kanchi", "U001",(Integer)4,(Double) 400.0,d1 ,"Pending");
		PurchaseEntity p2 = purchaseDAO.savePurchaseDetail(purchaseEntity);
		String status = "Pending";
	
		Assert.assertEquals("Status doesn't match",status,p2.getStatus());
		
	}

}
