package com.marpol.iolist.service;

import java.util.List;

import com.marpol.iolist.models.IoListDto;

/*
 *  판매 등록
 *  1. 상품 판매 내역 등록(장바구니 담기)
 *  2. 장바구니 전체 리스트
 *  3. 기간별 리스트
 *  4. 고객별 리스트
 *  5. 상품별 리스트
 *  6. 고객 + 거래기간별 리스트
 *  
 *  리스트의 공통사항
 *  거래내용, 상품정보, 고객정보 이 3가지 정보를 묶어서
 *  한번에 보여줘야 한다.
 *  ====================================================
 *  seq 거래일자 거래시각 고객ID 고객명 상품코드 상품명 판매단가 수량 판매금액
 */

public interface IoListService {

	public void printIolist(IoListDto iolist);

	public void printList();

	public void printList(List<IoListDto> iolists);
	
	public void input();

	// 기간별 리스트
	public void selectBeteewnDate();

	// 고객별 리스트
	public void selectByBuyer();

	// 상품별 리스트
	public void selectByProduct();

	// 고객 + 기간별 리스트
	public void selectByBuyerBetweenDate();

	// 상품 + 기간별 리스트
	public void selectByProductBetweenDate();

}
