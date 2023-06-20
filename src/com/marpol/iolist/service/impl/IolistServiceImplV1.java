package com.marpol.iolist.service.impl;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.marpol.iolist.config.DBConnection;
import com.marpol.iolist.config.HelpMessage;
import com.marpol.iolist.config.Line;
import com.marpol.iolist.models.BuyerDto;
import com.marpol.iolist.models.IoListDto;
import com.marpol.iolist.models.ProductDto;
import com.marpol.iolist.persistance.BuyerDao;
import com.marpol.iolist.persistance.IoListDao;
import com.marpol.iolist.persistance.ProductDao;
import com.marpol.iolist.service.BuyerService;
import com.marpol.iolist.service.IoListService;
import com.marpol.iolist.service.ProductService;

public class IolistServiceImplV1 implements IoListService {

	// iolist 와 buyer, product 기능을 서로 연결하는 것
	// 의존성 주입(Dependency Injection)
	protected final Scanner scan;

	protected final IoListDao iolistDao;
	protected final BuyerDao buyerDao;
	protected final ProductDao productDao;

	protected final BuyerService buyerService;
	protected final ProductService productService;

	public IolistServiceImplV1() {

		scan = new Scanner(System.in);

		SqlSession sqlSession = DBConnection.getSessionFactory().openSession(true);

		iolistDao = sqlSession.getMapper(IoListDao.class);
		buyerDao = sqlSession.getMapper(BuyerDao.class);
		productDao = sqlSession.getMapper(ProductDao.class);

		buyerService = new BuyerServiceImplV2();
		productService = new ProductServiceImplV1();

	}

	public void printIolist(IoListDto iolist) {

		System.out.printf("%d\t", iolist.ioSEQ);
		System.out.printf("%s\t", iolist.ioDate);
		System.out.printf("%s\t", iolist.ioTime);
		
		System.out.printf("%s\t", "고객ID");
		System.out.printf("%s\t", "고객명");
		
		System.out.printf("%s\t", "상품코드");
		System.out.printf("%s\t", "상품명");
		
		System.out.printf("%d\t", iolist.ioPrice);
		System.out.printf("%d\t", iolist.ioQuan);
		System.out.printf("%d\t", iolist.ioTotal);
		
	}

	public void printList() {
		List<IoListDto> iolists = iolistDao.selectAll();
		this.printList(iolists);

	}

	public void printList(List<IoListDto> iolists) {

		System.out.println(Line.sLine(100));
		System.out.println("SEQ\t거래일자\t거래시각\t고객ID\t고객명\t" + "상품코드\t상품명\t판매단가\t수량\t합계");
		System.out.println(Line.sLine(100));
		for (IoListDto dto : iolists) {
			this.printIolist(dto);
		}

	}

	public void input() {

		while (true) {

			System.out.println(Line.dLine(70));
			System.out.println("장바구니 담기 - v1");
			System.out.println(Line.dLine(70));

			BuyerDto buyerDto = null;

			while (true) {
				buyerDto = buyerService.findByBuName();
				if (buyerDto == null) {
					HelpMessage.COMFIRM("장바구니 담기를 종료할까요?", "Y : 종료 >> ");
					String yesNo = scan.nextLine();
					if (yesNo.equalsIgnoreCase("Y"))
						return;
					else
						continue;
				}
				break;
			}

			ProductDto productDto = null;
			while (true) {
				productDto = productService.findByPName();
				if (productDto == null) {
					HelpMessage.COMFIRM("장바구니 담기를 종료할까요?", "Y : 종료 >> ");
					String yesNo = scan.nextLine();
					if (yesNo.equalsIgnoreCase("Y"))
						return;
					else
						continue;
				}
				break;

			}
		}

	}

	public void selectBeteewnDate() {

	}

	public void selectByBuyer() {

	}

	public void selectByProduct() {

	}

	public void selectByBuyerBetweenDate() {

	}

	public void selectByProductBetweenDate() {

	}

}
