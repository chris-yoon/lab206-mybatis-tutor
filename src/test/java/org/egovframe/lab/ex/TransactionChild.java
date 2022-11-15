package org.egovframe.lab.ex;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service("transactionChild")
public class TransactionChild {

	@Resource
	CustomerService customerService;

    @Transactional(propagation=Propagation.NESTED, rollbackFor=Exception.class)
	public void insertCustomers() {
		CustomerVO vo = new CustomerVO();
		vo.setId("4");
		vo.setName("CHILD");
		vo.setAddress("SEOUL");

		try {
			customerService.insertCustomer(vo);
//			throw new RuntimeException("error occurred in the child");
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

}
