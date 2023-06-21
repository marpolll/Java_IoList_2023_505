package com.marpol.iolist.exec;

import com.marpol.iolist.service.IoListService;
import com.marpol.iolist.service.impl.IolistServiceImplV1;

public class ExecE {
	
	public static void main(String[] args) {
		
		IoListService ioListService = new IolistServiceImplV1();
		ioListService.input();
		ioListService.printList();
	}

}
