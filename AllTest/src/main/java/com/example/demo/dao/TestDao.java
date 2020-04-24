package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.data;
import com.example.demo.repository.TestRepository;

@Service
public class TestDao {
	
	@Autowired
	TestRepository tr;
	
	public List<data> showData() {
		return tr.getAllData();
	}
	public data savedata(data d) {
		return tr.save(d);
	}

}
