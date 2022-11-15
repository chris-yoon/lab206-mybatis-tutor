package org.egovframe.lab.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface CustomerMapper {
	public void insertCustomer(CustomerVO vo);

	public int deleteCustomerAll();

	public int deleteCustomerById(@Param("id") String id);

	public List<CustomerVO> selectCustomerList(CustomerVO vo);

}
