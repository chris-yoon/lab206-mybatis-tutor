package org.egovframe.lab.ex;

import java.util.List;

public interface CustomerService {
	public void insertCustomer(CustomerVO vo);
	public void deleteCustomerAll();
	public void deleteCustomerById(String id);
	public List<CustomerVO> selectCustomerList(CustomerVO vo);

}
