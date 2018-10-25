
package com.verizon.adb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.convert.ThreeTenBackPortConverters.LocalDateTimeToJavaTimeInstantConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.adb.TestUtil.TestUtil;
import com.verizon.adb.model.Customer;
import com.verizon.adb.restapi.CustomerApi;
import com.verizon.adb.service.CustomerService;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerApi.class)
public class CustomerApiTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private CustomerService custServiceMock;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockMvc = null;
	}

	@Test
	public void testGetAllCustomer() throws Exception {
		assertThat(this.custServiceMock).isNotNull();

		List<Customer> empList = new ArrayList<>();
		empList.add(new Customer());

		when(custServiceMock.getAllCustomers()).thenReturn(empList);

		mockMvc.perform(get("/Customer")).andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void testGetCustomerById() throws Exception {
		assertThat(this.custServiceMock).isNotNull();
		int contactId = 1;
	

		Customer custAdded = new Customer();

		custAdded.setFirstName("yamuna");
		custAdded.setEmailId("yamuna@gmail.com");
		custAdded.setMobileNUmber("8977456987");
//		custAdded.setHra(45);
//		custAdded.setDateOfJoining(LocalDate.of(2018, 10, 17));
//		custAdded.setDept(Department.HR);

		when(custServiceMock.getCustomerById(contactId)).thenReturn(custAdded);

		mockMvc.perform(get("/Customer")).andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void testGetAllCustomers() throws Exception {
		assertThat(this.custServiceMock).isNotNull();

		List<Customer> custList = new ArrayList<>();
		custList.add(new Customer());

		when(custServiceMock.getAllCustomers()).thenReturn(custList);

		mockMvc.perform(get("/Customer")).andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void testAddCustomer() throws Exception {
		assertThat(this.custServiceMock).isNotNull();

		Customer cust = new Customer();

//		cust.setEmpName("Raima");
//		cust.setBasic(8977);
//		cust.setHra(45);
//		emp.setDateOfJoining(null);
//		emp.setDept(Department.HR);
		
		cust.setFirstName("yamunaYellanki");
		cust.setEmailId("yyamuna@gmail.com");
		cust.setMobileNUmber("8977400987");

		Customer custAdded = new Customer();
		
		
		custAdded.setFirstName("yamuna");
		custAdded.setEmailId("yamuna@gmail.com");
		custAdded.setMobileNUmber("8977456987");
		
//		empAdded.setEmpId(14);
//		empAdded.setEmpName("Raima");
//		empAdded.setBasic(8977);
//		empAdded.setHra(45);
//		empAdded.setDateOfJoining(null);
//		empAdded.setDept(Department.HR);

		System.out.println(cust);

		when(custServiceMock.addCustomer(Mockito.any(Customer.class))).thenReturn(custAdded);

		mockMvc.perform(post("/Customer").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(cust))).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));

	}

	
//	@Test
//	public void testUpdateCustomer() throws Exception {
//		assertThat(this.custServiceMock).isNotNull();
//
//		Customer cust = new Customer();
//		
//		cust.setFirstName("yamunaYellanki");
//		cust.setEmailId("yyamuna@gmail.com");
//		cust.setMobileNUmber("8977400987");
////		emp.setEmpId(13);
////		emp.setEmpName("RaimaBaby");
////		emp.setBasic(8977);
////		emp.setHra(45);
////		emp.setDateOfJoining(null);
////		emp.setDept(Department.Network);
//
//		int contactId = 13;
//		
//
//		Customer custAdded = new Customer();
//		
//		cust.setContactId(13);
//		cust.setFirstName("yamunaYellanki");
//		cust.setEmailId("yyamuna@gmail.com");
//		cust.setMobileNUmber("8977400987");
//		
//		
////		empAdded.setEmpId(13);
////		empAdded.setEmpName("Aditya");
////		empAdded.setBasic(8977);
////		empAdded.setHra(45);
////		empAdded.setDateOfJoining(LocalDate.of(2018, 10, 17));
////		empAdded.setDept(Department.HR);
//
//		when(custServiceMock.getCustomerById(contactId)).thenReturn(custAdded);
//
//		when(custServiceMock.addCustomer(Mockito.any(Customer.class))).thenReturn(cust);
//
//		mockMvc.perform(put("/Customer").contentType(TestUtil.APPLICATION_JSON_UTF8)
//				.content(TestUtil.convertObjectToJsonBytes(cust))).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));
//
//
//	}
////
	@Test
	public void testDeleteCustomer() throws Exception {
		assertThat(this.custServiceMock).isNotNull();

		int contactId = 1;

		when(custServiceMock.deleteCustomer(contactId)).thenReturn(true);

		mockMvc.perform(delete("/Customer/contactId/1")).andExpect(status().isOk()).andDo(print());

	}

}
