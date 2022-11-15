package org.egovframe.lab.ex;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("transactionParent")
public class TransactionParent {

	@Resource
	CustomerService customerService;

	@Resource
	TransactionChild transactionChild;

	@Transactional(rollbackFor=Exception.class)
	public void insertCustomers() {
		CustomerVO vo = new CustomerVO();
		vo.setId("3");
		vo.setName("PARENT");
		vo.setAddress("SEOUL");
		customerService.insertCustomer(vo);

		transactionChild.insertCustomers();
		throw new RuntimeException("error occurred in the parent");
	}

}
