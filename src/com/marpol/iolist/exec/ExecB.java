package com.marpol.iolist.exec;

import com.marpol.iolist.service.BuyerService;
import com.marpol.iolist.service.impl.BuyerServiceImplV1;

public class ExecB {
	
	public static void main(String[] args) {
		
		BuyerService buyerService = new BuyerServiceImplV1();
		buyerService.printList();
		
//		buyerService.findByBuId();
//		buyerService.findByBuName();
		
//		String newId = buyerService.newBuId();
//		System.out.println(newId);
		
		buyerService.insert();
		
	}

}
