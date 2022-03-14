package com.studycase.airline_ticketing_system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studycase.airline_ticketing_system.business.abstracts.EntityService;
import com.studycase.airline_ticketing_system.business.concrete.PurchaseManager;
import com.studycase.airline_ticketing_system.entities.Purchase;
import com.studycase.airline_ticketing_system.entities.Ticket;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

@SpringBootTest
class PurchaseControllerTests {

	@Autowired
	private EntityService<Purchase> purchaseService;
	@Autowired
	private PurchaseManager purchaseManager;
	
	@Test
	public void getallPurchasesTest(){
		DataResult<List<Purchase>> purchases=this.purchaseService.getAll();
		
		assertNotNull(purchases);
		assertTrue(purchases.isSuccess());
		assertNotNull(purchases.getData());		
	}
	@Test
	public void addPurchaseTest(){
		Purchase purchase=new Purchase(1,"4221-1611-2233-0005",11,2029,907,new Ticket());
		Result result=this.purchaseService.add(purchase);
		
		assertTrue(result.isSuccess());
	}
	@Test
	public void cardMaskTest() {
		String number="4221-1611-2233-0005";
		String maskedNumber=purchaseManager.maskCardNumber(number);

		assertEquals(maskedNumber, "422116******0005");
	}
}
