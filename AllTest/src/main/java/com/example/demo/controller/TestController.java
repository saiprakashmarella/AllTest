package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	TestDao td;
	
	@GetMapping("/showData")
	public ResponseEntity<List<data>> showdata(){
		try {
			return ResponseEntity.ok().body(td.showData());
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/addData")
	
	public ResponseEntity<data> addData(@Valid @RequestBody data d){
		try {
			return ResponseEntity.ok().body(td.savedata(d));
		}catch(Exception e) {
			System.out.println("error"+e);
			return ResponseEntity.notFound().build();
		}
	}

}
