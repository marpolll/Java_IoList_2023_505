package com.marpol.iolist.service.impl;

import java.util.List;

import java.util.Scanner;

import com.marpol.iolist.config.DBConnection;
import com.marpol.iolist.config.HelpMessage;
import com.marpol.iolist.config.Line;
import com.marpol.iolist.models.ProductDto;
import com.marpol.iolist.persistance.ProductDao;
import com.marpol.iolist.service.ProductService;

public class ProductServiceImplV1 implements ProductService {

	protected final Scanner scan;
	protected final ProductDao proDao;

	public ProductServiceImplV1() {

		// method Chaining
		proDao = DBConnection.getSessionFactory().openSession(true).getMapper(ProductDao.class);

		scan = new Scanner(System.in);
	}

	public void insert() {

		ProductDto productDto = null;
		while (true) {
			HelpMessage.COMFIRM("상품 정보를 확인 합니다. \n " + "상품코드를 입력해 주세요 QUIT : 종료 ", " 상품코드 >> ");
			String strPCode = scan.nextLine();
			if (strPCode.isBlank()) {
				HelpMessage.ERROR("상품코드를 입력해 주세요 ~~~");
				continue;
			}
			if (strPCode.equals("QUIT"))
				return;
			productDto = proDao.findById(strPCode);

			if (productDto == null) {
				productDto = new ProductDto();
				productDto.pCode = strPCode;
			} else if (productDto != null) {
				String message = String.format("이미 등록된 상품입니다.\n" + "\t상품이름 : %s\n" + "\t매입단가 : %d", productDto.pName,
						productDto.getIPrice());
				String prompt = "상품정보를 수정할까요? (Y:수정) >> ";
				HelpMessage.COMFIRM(message, prompt);
				String yesNo = scan.nextLine();
				if (!yesNo.equalsIgnoreCase("Y"))
					continue;

			}
			break;
		} // 상품코드 입력 while end
		HelpMessage.ALERT("입력한 상품코드 : " + productDto.pCode);

		// 상품명 입력받기
		while (true) {

			String strName = this.inputValue("상품명", productDto.pName);
			if (strName.equals("QUIT"))
				return;
			else if (strName.equals("RE"))
				continue;
			else if (productDto.pName == null && strName.isBlank()) {
				HelpMessage.ERROR("상품명은 반드시 입력해야 합니다. ");
				continue;
			}
			productDto.pName = strName;
			break;
		}
		HelpMessage.ALERT("입력받은 상품명 : " + productDto.pName);

		// 품목명 입력받기
		while (true) {

			String strPItem = this.inputValue("품목명", productDto.pItem);
			if (strPItem.equals("QUIT"))
				return;
			else if (strPItem.equals("RE"))
				continue;
			else if (productDto.pItem == null && strPItem.isEmpty()) {
				HelpMessage.ERROR("품목명을 입력하세요 ");
				continue;
			}
			productDto.pItem = strPItem;
			break;
		}
		HelpMessage.ALERT("입력받은 품목명 : " + productDto.pItem);

		// 매입 단가 입력하기

		while (true) {

			String strIPrice = productDto.getIPrice() == 0 ? null : productDto.getIPrice() + "";

			strIPrice = this.inputValue("매입단가", strIPrice);
			if (strIPrice.equals("QUIT"))
				return;
			if (strIPrice.equals("RE"))
				continue;

			try {
				int iPrice = Integer.valueOf(strIPrice);
				productDto.setIPrice(iPrice);
				break;
			} catch (Exception e) {
				HelpMessage.ERROR("매입단가는 정수로 입력해야 합니다. ");
			}
		} // 매입단가 입력 while end
		HelpMessage.ALERT("입력한 매입단가 : " + productDto.getIPrice());
		HelpMessage.ALERT("계산한 매입단가 : " + productDto.pOPrice);

		int result = 0;

		try {
			result = proDao.insert(productDto);
			if (result > 0)
				HelpMessage.OK("상품정보 추가 OK ~~ ");
		} catch (Exception e) {
			result = proDao.update(productDto);
			if (result > 0)
				HelpMessage.OK("상품정보 수정 OK ~~ ");
		}
		if (result < 1) {
			HelpMessage.ERROR("상품정보 추가, 수정 중에 문제 발생 ", "상품정보 추가, 수정 실패");
		}
	}

	protected String inputValue(String title, String value) {
		String prompt = value == null ? String.format("새로운 %s >> ", title)
				: String.format("%s 수정(%s) : 유지하려면 Enter >> ", title, value);
		System.out.print(prompt);
		String strValue = scan.nextLine();
		if (strValue.equals("QUIT"))
			return strValue;
		if (value == null && strValue.isEmpty()) {
			HelpMessage.ERROR(title + "는(은) 반드시 입력해야 합니다. ");
			return "RE";
		} else if (value != null && strValue.isEmpty()) {
			return value;
		}
		return strValue;
	}

	public void printList() {

		List<ProductDto> productList = proDao.selectAll();
		this.printList(productList);

	}

	public void printList(List<ProductDto> productList) {

		System.out.println(Line.sLine(70));
		System.out.println("상품코드\t상품명\t품목명\t매입단가\t매출단가");
		System.out.println(Line.sLine(70));
		for (ProductDto dto : productList) {
			this.printProduct(dto);
		}
		System.out.println(Line.dLine(70));

	}

	public void printProduct(ProductDto productDto) {

		System.out.printf("%s\t", productDto.pCode);
		System.out.printf("%s\t", productDto.pName);
		System.out.printf("%s\t", productDto.pItem);
		System.out.printf("%s\t", productDto.getIPrice());
		System.out.printf("%s\t", productDto.pOPrice);
	}

	public ProductDto findByPCode() {
		return null;
	}

	public ProductDto findByPName() {
		return null;
	}

}