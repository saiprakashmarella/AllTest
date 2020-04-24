package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.TestDao;
import com.example.demo.model.data;
import com.example.demo.repository.TestRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class AllTestApplicationTests {
	
	@Autowired
	@InjectMocks
	TestDao td;
	
	@MockBean
	TestRepository tr;
	
	
	
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
	

}
