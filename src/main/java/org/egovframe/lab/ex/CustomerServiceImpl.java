package org.egovframe.lab.ex;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	CustomerMapper customerMapper;
	
	@Override
	public void insertCustomer(CustomerVO vo) {
		customerMapper.insertCustomer(vo);

	}

	@Override
	public void deleteCustomerAll() {
		customerMapper.deleteCustomerAll();

	}

	@Override
	public void deleteCustomerById(String id) {
		customerMapper.deleteCustomerById(id);

	}

	@Override
	public List<CustomerVO> selectCustomerList(CustomerVO vo) {
		return customerMapper.selectCustomerList(vo);
	}

}
