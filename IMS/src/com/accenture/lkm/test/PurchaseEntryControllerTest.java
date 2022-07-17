package com.accenture.lkm.test;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.entity.PurchaseEntity;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.accenture.lkm.services.PurchaseService;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;
import com.accenture.lkm.web.client.VendorServiceConsumer;
import com.accenture.lkm.web.controller.PurchaseEntryController;

@WebMvcTest(PurchaseEntryController.class)
public class PurchaseEntryControllerTest {


	private static final Logger logger = LoggerFactory.getLogger(PurchaseEntryControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PurchaseService PurchaseServiceMock;

	@MockBean
	private VendorServiceConsumer vendorServiceConsumer;
	
	@MockBean
	private MaterialCategoryConsumer materialCategoryConsumer;
	
	
	  @Test public void testPurchaseEntry() throws Exception {
	  
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd"); Date d1 =
	  format. parse("2020-05-17"); PurchaseBean bean1 = new
	  PurchaseBean((Integer)1, "", "Only Vimal", "C001",
	  "T001",(Double)0.0,"Kanchi", "U001",(Integer)4,(Double) 400.0,d1 ,
	  "Thread","Silk","Meters",""); PurchaseBean bean = new
	  PurchaseBean((Integer)1, "", "Only Vimal", "C001",
	  "T001",(Double)0.0,"Kanchi", "U001",(Integer)4,(Double) 400.0,d1 ,
	  "Thread","Silk","Meters",""); StringBuffer key = new StringBuffer("P_"); if
	  (bean.getVendorName() != null) {
	  key.append(bean.getVendorName().toUpperCase(), 0, 3); key.append("_"); }
	  
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); String
	  strpurchaseDate=sdf.format(bean.getPurchaseDate());
	  
	  String pDate = strpurchaseDate.substring(5,
	  7)+strpurchaseDate.substring(8,10)+strpurchaseDate.substring(0, 4);
	  key.append(pDate); key.append("_"); if (bean.getMaterialCategoryName() !=
	  null) { key.append(bean.getMaterialCategoryName().toUpperCase(), 0, 3);
	  key.append("_"); }
	  
	  String TxId = key.toString(); bean.setTransactionId(TxId);
	  bean.setStatus("Pending"); bean.setPurchaseId(2); PurchaseBean p =
	  PurchaseServiceMock.addPurchaseDetails(bean1); Assert.assertEquals(p, bean);
	  when(PurchaseServiceMock.addPurchaseDetails(bean1)).thenReturn(bean);
	  
	  mockMvc.perform(MockMvcRequestBuilders.get("purchaseEntry.html")).andDo(print
	  ()) .andExpect(view().name("purchaseEntry"))
	  .andReturn().getResponse().getContentAsString();
	  
	  }
	 
	
	  @Test public void testGenerateVendorList() throws MicroServiceException {
	  //implementation goes here
	  Assert.assertNotNull("VendorServiceConsumer is Null",vendorServiceConsumer);
	  List<VendorBean> vendorList = vendorServiceConsumer.getVendorBeanList();
	  Assert.assertNotNull("List of beans is null", vendorList); }
	 

	@Test
	public void testGenerateUnitAndTypeList() {
		//implementation goes here
		
		
	}

	@Test
	public void testGenerateCategoryList() throws MicroServiceException {
		//implementation goes here
		
		Assert.assertNotNull("materialCategoryConsumer is Null", materialCategoryConsumer);
		List<MaterialCategoryBean> materialCategoryList = materialCategoryConsumer.getMaterialCategoryBeanList();	
		Assert.assertNotNull("List of beans is null",materialCategoryList);
	}

	@Test
	public void testAddPurchaseDetail() {
		//implementation goes here
	}
}
