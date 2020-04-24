package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.TestController;
import com.example.demo.dao.TestDao;
import com.example.demo.model.data;
import com.example.demo.repository.TestRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AllTestApplicationTests {
	
	public MockMvc mockMvc;
	
	@Autowired
	@InjectMocks
	TestDao td;
	

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
	void showDataUrlCheck() throws Exception{
		mockMvc=MockMvcBuilders.standaloneSetup(testController).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/test"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello World"));
	}
	

}
