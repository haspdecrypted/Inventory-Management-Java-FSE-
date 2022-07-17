package com.accenture.lkm.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.services.PurchaseService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PurchaseServiceTest {


	private static final Logger logger = LoggerFactory.getLogger(PurchaseServiceTest.class);
	
	@Autowired
	PurchaseService purchaseService;
	
	@Test
	public void testAddPurchaseDetails() throws Exception {
		//implementation goes here
		
		Assert.assertNotNull("PurchaseSevice object is null",purchaseService);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd"); 
		Date d1 = format. parse("2020-05-17"); 
		System.out.println("Started");
		PurchaseBean purchaseBean = new PurchaseBean((Integer)1, "P_ONL_05172020_THR_1", "Only Vimal", "C001", "T001",(Double)0.0,"Kanchi", "U001",(Integer)4,(Double) 400.0,d1 , "Thread","Silk","Meters","Pending");
		System.out.println("ss"+purchaseService);
		PurchaseBean p1 = purchaseService.addPurchaseDetails(purchaseBean);
		
		Assert.assertNotNull("bean not added", p1);
		Assert.assertEquals("Not equal","P_ONL_05172020_THR_1",p1.getTransactionId());
		
	}

}
