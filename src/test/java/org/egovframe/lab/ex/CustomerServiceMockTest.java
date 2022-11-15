package org.egovframe.lab.ex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.easymock.classextension.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;


@RunWith(UnitilsJUnit4TestClassRunner.class)
public class CustomerServiceMockTest {

	
	@Mock
	@InjectIntoByType
	private CustomerMapper mockMapper;
	
	@TestedObject
	public CustomerServiceImpl customerService;
	
	
	@Test
	public void testSelectCustomerList() {
		assertNotNull("Verify that the targeted object for test is well created", customerService);
		assertNotNull("Verify that the mock object is well created", mockMapper);

		CustomerVO vo1 = new CustomerVO();
		vo1.setId("1");
		vo1.setName("KIM");

		CustomerVO vo2 = new CustomerVO();
		vo2.setId("2");
		vo2.setName("LEE");

		CustomerVO vo3 = new CustomerVO();
		vo3.setId("3");
		vo3.setName("YOON");
		
		// Add and verify the method to be Mocked using EasyMock + Unitils.
		EasyMock.expect(mockMapper.selectCustomerList(null)).andReturn(Arrays.asList(vo1, vo2, vo3));
		EasyMockUnitils.replay();

		// Execute the method to be tested.
		List<CustomerVO> customers = customerService.selectCustomerList(null);
		
		// Check the results.
		assertEquals(3, customers.size());
		System.out.println("testSelectCustomerList>>>" + customers);
	}
	
	@Test
	public void testInsertCustomer() {
		assertNotNull("Verify that the targeted object for test is well created", customerService);
		assertNotNull("Verify that the mock object is well created", mockMapper);
		
		CustomerVO vo = new CustomerVO();
		vo.setId("1");
		vo.setName("KIM");
		
		// Add and verify the method to be Mocked using EasyMock + Unitils.
		mockMapper.insertCustomer(vo);
		EasyMockUnitils.replay();
		
		// Execute the method to be tested.
		customerService.insertCustomer(vo);
	}
}
