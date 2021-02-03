package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alian;

public interface AlianRepo extends JpaRepository<Alian, Integer> {
	
	
//	List<Alian> findByTech(String tech);
//	
//	List<Alian> findByAidGreaterThan(int aid);
//	
//	@Query("from Alian where tech=?1 order by aname")
//	List<Alian> findByTechSorted(String tech);

	
	

}
