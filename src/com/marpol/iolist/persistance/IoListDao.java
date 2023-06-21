package com.marpol.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.marpol.iolist.config.DBContract;
import com.marpol.iolist.models.IoListDto;

/*
 *  판매 등록
 *  1. 상품 판매 내역 등록(장바구니 담기)
 *  2. 장바구니 전체 리스트
 *  3. 기간별 리스트
 *  4. 고객별 리스트
 *  5. 상품별 리스트
 *  6. 고객 + 거래기간별 리스트
 */ 

public interface IoListDao {
	
	@Select(" SELECT * FROM " + DBContract.TABLE.IOLIST 
			+ " ORDER BY ioDate, ioTime ")
	public List<IoListDto> selectAll();
	
	/*
	 * mabatis 의 Query method 에 값을 전달할때
	 * 가능하면 Dto(VO) 에 데이터를 담아서 전달하라
	 * 만약 불가피하게 일반 변수(int, String 등등)를 사용하여
	 * 전달할떄 1개만 전달할떄는 문제가 없다
	 * 하지만 2개이상 전달할떄는 반드시 @param Annotation 을 사용하여
	 * 변수 이름도 함께 전달해 주어야 한다.
	 */
	// 기간별 리스트
	@Select(" SELECT * FROM " + DBContract.TABLE.IOLIST 
			+ " WHERE ioDate BETWEEN #{sDate} AND #{eDate} " 
			+ " ORDER BY ioDate, ioTime ")
	public List<IoListDto> selectBeteewnDate(@Param("sDate") String sDate, @Param("eDate") String eDate);
	
	// 고객별 리스트
	@Select(" SELECT * FROM " + DBContract.TABLE.IOLIST 
			+ " WHERE ioBuid = #{buId} " 
			+ " ORDER BY ioDate, ioTime ")
	public List<IoListDto> selectByBuyer(String buId);
	
	// 상품별 리스트
	@Select(" SELECT * FROM " + DBContract.TABLE.IOLIST 
			+ " WHERE ioPcode = #{code} " 
			+ " ORDER BY ioDate, ioTime ")
	public List<IoListDto> selectByProduct(String pCode);
	
	// 고객 + 기간별 리스트
	@Select(" SELECT * FROM " + DBContract.TABLE.IOLIST 
			+ " WHERE ioBuid = #{buId} "
			+ " AND ioDate BETWEEN #{sDate} AND #{eDate} "
			+ " ORDER BY ioDate, ioTime ")
	public List<IoListDto> selectByBuyerBetweenDate(@Param("buId")String buId, @Param("sDate")String sDate, @Param("eDate")String eDate);
	
	// 상품 + 기간별 리스트
	@Select(" SELECT * FROM " + DBContract.TABLE.IOLIST 
			+ " WHERE ioPcode = #{pCode} "
			+ " AND ioDate BETWEEN #{sDate} AND #{eDate} "
			+ " ORDER BY ioDate, ioTime ")
	public List<IoListDto> selectByProductBetweenDate(@Param("pCode")String pCode, @Param("sDate")String sDate, @Param("eDate")String eDate);
	
	@Insert(" INSERT INTO " + DBContract.TABLE.IOLIST
			+ " (ioDate, ioTime, ioBuid, " 
			+ " ioPCode, ioQuan, ioPrice, ioTotal) "
			
			+ " VALUES (#{ioDate}, #{ioTime}, #{ioBuid}, "
			+ " #{ioPCode}, #{ioQuan}, #{ioPrice}, #{ioTotal}) "
			)
	public int insert(IoListDto ioListDto);
}
