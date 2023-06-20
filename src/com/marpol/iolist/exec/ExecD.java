package com.marpol.iolist.exec;

import com.marpol.iolist.service.ProductService;
import com.marpol.iolist.service.impl.ProductServiceImplV1;

public class ExecD {
	
	public static void main(String[] args) {
		
		ProductService productService = new ProductServiceImplV1();
//		productService.findByPCode();
		productService.insert();
	}
}
