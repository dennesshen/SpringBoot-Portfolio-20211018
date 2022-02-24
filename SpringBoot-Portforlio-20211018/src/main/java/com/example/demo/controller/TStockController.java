package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Classify;
import com.example.demo.entity.TStock;
import com.example.demo.repository.ClassifyRepository;
import com.example.demo.repository.TStockRepository;

@RestController
@RequestMapping("/tStock")
public class TStockController {
	
	@Autowired
	private TStockRepository tStockRepository;
	
	@Autowired
	private ClassifyRepository classifyRepository;
	
	@RequestMapping(value = {"/","/query"})
	public List<TStock> query() {
		return tStockRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}")
	public TStock get(@PathVariable("id") Integer id) {
		return tStockRepository.findById(id).get();
	}
	
	@PostMapping(value = {"/", "/add"})
	@Transactional
	public TStock add(@RequestBody Map<String, String> map) {
		Classify classify = classifyRepository.findById(Integer.parseInt(map.get("classify_id"))).get();
		TStock tStock = new TStock(map.get("symbol"), map.get("name"), classify);
		tStockRepository.save(tStock);
		return tStock;
	}
	
	@PutMapping(value = {"/", "/update"})
	@Transactional
	public Boolean update(@RequestBody Map<String, String> map) {
		TStock tStock = tStockRepository.findById(Integer.parseInt(map.get("id") ) ).get();
		Classify classify = classifyRepository.findById(Integer.parseInt(map.get("classify_id"))).get();
		tStock.setName(map.get("name"));
		tStock.setSymbol(map.get("symbol"));
		tStock.setClassify(classify);
		return true;
	}
	
	@DeleteMapping(value = {"/", "/delete"})
	@Transactional
	public Boolean update(@RequestBody String id ) {
		System.out.println("TEST---------------------");
		tStockRepository.myDelete(Integer.parseInt(id));
		//tStockRepository.delete(tStock);
		//tStockRepository.deleteById(Integer.parseInt(id)); // 為什麼會出事呀？
		System.out.println("TEST---------------------");

		return true;
	}
	
	

}
