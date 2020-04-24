package com.example.demo.repository;

import java.util.List;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.data;
@Repository
public interface TestRepository extends JpaRepository<data, Long>{
	
	@Query(value = "select * from data t",nativeQuery =true)
	public List<data> getAllData();
	

}
