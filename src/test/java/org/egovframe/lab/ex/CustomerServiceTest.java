package org.egovframe.lab.ex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/context-*.xml" })
public class CustomerServiceTest {

	@Resource
	CustomerService customerService;

	@Before
	public void initialize() {
		customerService.deleteCustomerAll();

		CustomerVO vo = new CustomerVO();
		vo.setId("1");
		vo.setName("KIM");
		vo.setAddress("SEOUL");
		customerService.insertCustomer(vo);

		vo.setId("2");
		vo.setName("LEE");
		vo.setAddress("PUSAN");
		customerService.insertCustomer(vo);
	}

	@Test
	public void testInsertCustomer() {
		List<CustomerVO> customers = customerService.selectCustomerList(null);

		assertEquals(2, customers.size());
		System.out.println("testInsertCustomer>>>" + customers);
	}

	@Test
	public void testDeleteCustomerAll() {
		customerService.deleteCustomerAll();
		List<CustomerVO> customers = customerService.selectCustomerList(null);
		assertEquals(0, customers.size());

		System.out.println("testDeleteCustomerAll");
	}

	@Test
	public void testDeleteCustomerById() {
		customerService.deleteCustomerById("1");
		List<CustomerVO> customers = customerService.selectCustomerList(null);
		assertEquals(1, customers.size());
		System.out.println("testDeleteCustomerById>>>" + customers);
	}

	@Test
	public void testSelectCustomerList() {
		CustomerVO vo = new CustomerVO();
//		vo.setId("1");
//		vo.setName("KIM");
		List<CustomerVO> customers = customerService.selectCustomerList(vo);
		assertEquals(2, customers.size());
		System.out.println("testSelectCustomerList>>>" + customers);
	}

	@Resource
	TransactionParent transactionParent;

	@Test
	public void testTransactionRequired() {
		transactionParent.insertCustomers();
	}

}
