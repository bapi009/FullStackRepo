package com.vmware.calculate;

import com.vmware.calculate.model.BaseResponseTO;
import com.vmware.calculate.model.Operands;
import com.vmware.calculate.service.CalculateService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CalculateApplicationTests {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	CalculateService calculateService;

	@Autowired
	private ObjectMapper objectMapper;

	/*@Test
	void contextLoads() {
	}*/

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void addNumbers_Test() throws Exception {
		Operands operands = getMockOperands();
		String reqJson = objectMapper.writeValueAsString(operands);
		BaseResponseTO<Integer> response = new BaseResponseTO<>(HttpStatus.OK, "Added Successfully");
		response.setResult(operands.getX()+operands.getY());
		mockMvc.perform(post("/api/add").headers(new HttpHeaders()).content(reqJson).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.message", Matchers.is("Added Successfully")))
				.andExpect(jsonPath("$.result", Matchers.is(150))).andReturn();
	}

	@Test
	public void subtractNumbers_Test() throws Exception {
		Operands operands = getMockOperands();
		String reqJson = objectMapper.writeValueAsString(operands);
		BaseResponseTO<Integer> response = new BaseResponseTO<>(HttpStatus.OK, "Subtracted Successfully");
		response.setResult(operands.getX()-operands.getY());
		mockMvc.perform(post("/api/diff").content(reqJson).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.message", Matchers.is("Subtracted Successfully")))
				.andExpect(jsonPath("$.result", Matchers.is(50))).andReturn();
	}

	private Operands getMockOperands(){
		Operands operands = new Operands();
		operands.setX(100);
		operands.setY(50);
		return  operands;
	}
}
