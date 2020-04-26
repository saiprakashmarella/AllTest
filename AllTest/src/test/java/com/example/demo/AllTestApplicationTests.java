package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.TestController;
import com.example.demo.dao.TestDao;
import com.example.demo.model.data;
import com.example.demo.repository.TestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AllTestApplicationTests {
	
	private static final Logger logg=LogManager.getLogger(AllTestApplicationTests.class.getName());
	public MockMvc mockMvc;
	
	@Autowired
	@Mock
	TestDao td;
	
	ObjectMapper om=new ObjectMapper();
	
	@MockBean
	TestRepository tr;
	
	@InjectMocks
	public TestController testController;
		
	
	@Test
	void showDataCheck() {
		when(tr.getAllData()).thenReturn(Stream.of(new data("sai",23,"India"),new data("Marella",23,"India")).collect(Collectors.toList()));
		assertEquals(2, td.showData().size(),"should return the size of data available");
	}
	
	@Test
	void addDataCheck() {
		data d=new data("Sai",25,"India");
		when(tr.save(d)).thenReturn(d);
		assertEquals(d, td.savedata(d));
	}
	
	@Test
	void testControllerCheck() throws Exception{
		mockMvc=MockMvcBuilders.standaloneSetup(testController).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/test"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello World"));
	}
  	@Test
  	void showDataUrlCheck() throws Exception{
  		mockMvc=MockMvcBuilders.standaloneSetup(testController).build();
  		//RequestBuilder rb= MockMvcRequestBuilders.get("/test/showData").accept(MediaType.APPLICATION_JSON);
  		mockMvc.perform(MockMvcRequestBuilders.get("/test/showData").accept(MediaType.APPLICATION_JSON))
  						.andExpect(MockMvcResultMatchers.status().isOk());
//  						.andExpect(jsonPath("$.name",is("sai")))
//  						.andExpect(jsonPath("$.Age",is("25")));
//  		verify(td).showData();
//    		MvcResult result=mockMvc.perform(rb).andReturn();
//    		System.out.println(result.getResponse());
//    		String expected= "{name:sai,age:25,country:India}";
//    		JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);	
  	}
  	
  	@Test
  	void addDataUrlCheck() throws Exception{
  		data d=new data("sujatha",25,"India");
  		String jsonrequest=om.writeValueAsString(d);
  		mockMvc=MockMvcBuilders.standaloneSetup(testController).build();
  		mockMvc.perform(MockMvcRequestBuilders.post("/test/addData").contentType(MediaType.APPLICATION_JSON).content(jsonrequest))
  						.andExpect(MockMvcResultMatchers.status().isOk());
//  		RequestBuilder rb= MockMvcRequestBuilders.post("/test/addData").contentType(MediaType.APPLICATION_JSON).content(jsonrequest);				
//  			MvcResult result=mockMvc.perform(rb).andReturn();
//  			logg.info(result.getResponse().getContentAsString());
////    		String expected= "{name:sai,age:25,country:India}";
//    		JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);	

	}

}
