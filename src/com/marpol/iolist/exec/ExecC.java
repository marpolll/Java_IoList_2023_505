package com.marpol.iolist.exec;

import com.marpol.iolist.service.BuyerService;
import com.marpol.iolist.service.impl.BuyerServiceImplV2;

public class ExecC {

	public static void main(String[] args) {
		BuyerService buyerService = new BuyerServiceImplV2();
		
		buyerService.insert();
		buyerService.printList();
//		buyerService.findByBuId();
	}

}
