package com.example.demo;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.GetStockInfoService;

import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

@SpringBootTest
class SpringBootPortforlio20211018ApplicationTests {
	
	@Autowired
	GetStockInfoService getStockInfoService;

	@Test
	void contextLoads() throws IOException {
		YahooFinance.get("2330.TW").toString();
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.add(Calendar.MONTH, -1);
		List<HistoricalQuote> list = YahooFinance.get("2331.TW").getHistory(from, to, Interval.DAILY);
		
		list.stream().forEach(System.out::println);
	}

}
