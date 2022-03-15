package com.example.demo.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TStock;
import com.example.demo.repository.TStockRepository;
import com.example.demo.service.GetStockInfoService;

import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

@RestController
@RequestMapping("/price")
public class PriceController {
	
	@Autowired
	private TStockRepository tStockRepository;
	
	@Autowired
	private GetStockInfoService getStockInfoService;
	
	
	@RequestMapping("/refresh")
	public List<TStock> refresh() {
		List<TStock> list = tStockRepository.findAll();
		list.stream().peek(ts -> getStockInfoService.refreshInfo(ts)).forEach(ts -> tStockRepository.save(ts));
		return list;
	}
	
	@RequestMapping("/history_quote/{symbol:.+}")
	public List<HistoricalQuote> queryHistoryQuotes(@PathVariable("symbol") String symbol){
		List<HistoricalQuote> historicalQuotes = getStockInfoService.getHistoricalQuotes(symbol, -1, Calendar.MONTH, Interval.DAILY).get();
		
		return historicalQuotes;
	}
	
	
	

}
