package com.marpol.iolist.service;

import java.util.List;

import com.marpol.iolist.models.ProductDto;

public interface ProductService {
	
	public void insert();
	public void printList();
	public void printList(List<ProductDto> productList);

	public void printProduct(ProductDto productDto);
	
	public ProductDto findByPCode();
	public ProductDto findByPName();
}
