package com.example.demo.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TStock;

@Repository
public interface TStockRepository extends JpaRepository<TStock, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "Delete from portfolio.tstock WHERE id=?1", nativeQuery = true)
	public void myDelete(Integer id);
}
