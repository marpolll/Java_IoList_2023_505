package com.marpol.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.marpol.iolist.config.DBContract;
import com.marpol.iolist.models.ProductDto;
import com.marpol.iolist.persistance.sql.ProductSQL;

public interface ProductDao {

	@Select(" SELECT * FROM " + DBContract.TABLE.PRODUCT + " ORDER BY pCode ")
	public List<ProductDto> selectAll();

	@Select(" SELECT * FROM " + DBContract.TABLE.PRODUCT + " WHERE pCode = #{id} ")
	public ProductDto findById(String id);

	@Insert(ProductSQL.INSERT)
	public int insert(ProductDto productDao);

	@Update(ProductSQL.UPDATE)
	public int update(ProductDto productDao);

	@Select(" SELECT * FROM " + DBContract.TABLE.PRODUCT + " WHERE pName LIKE '%' || #{pName} || '%' "
			+ " ORDER BY pName ")
	public List<ProductDto> findByPName(String pName);

}
