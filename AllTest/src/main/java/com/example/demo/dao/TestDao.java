package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.data;
import com.example.demo.repository.TestRepository;

@Service
@Transactional
public class TestDao {
	
	@Autowired
	TestRepository tr;
	
	private static final Logger logg=LogManager.getLogger(TestDao.class.getName());
	
	public List<data> showData() {
		try {
			logg.info("Fetching the data from repository");
			return tr.getAllData();
		}catch(Exception e) {
			logg.error("Error while fetching the data from Repository:"+e);
			return null;
		}
	}
	public data savedata(data d) {
		try {
			logg.info("Saving the data to the repository");
			return tr.save(d);
		}catch(Exception e) {
			logg.error("Error while saving the data to Repository");
			return null;
		}
	}

}
