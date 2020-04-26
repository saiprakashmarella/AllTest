package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TestDao;
import com.example.demo.model.data;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/test")
public class TestController {
	
	private static final Logger logg=LogManager.getLogger(TestController.class.getName());
	
	@GetMapping
	public String Greet() {
		logg.info("Controller is working");
		return "Hello World";
	}
	
	@Autowired
	TestDao td;
	
	
	
	@GetMapping(value="/showData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<data>> showdata(){
		try {
			logg.info("Fetching the data from server");
			return ResponseEntity.ok().body(td.showData());
		}catch(Exception e) {
			logg.error("error while fetching the data:"+e);
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(value="/addData",consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<data> addData(@Valid @RequestBody data d){
		try {
			logg.info("Saving details to the server");
			return ResponseEntity.ok().body(td.savedata(d));
		}catch(Exception e) {
			logg.error(e);
			return ResponseEntity.notFound().build();
		}
	}

}
