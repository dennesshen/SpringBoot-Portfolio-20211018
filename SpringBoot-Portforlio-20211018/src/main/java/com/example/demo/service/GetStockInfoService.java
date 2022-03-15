package com.example.demo.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TStock;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

@Service
public class GetStockInfoService {
	
	public void refreshInfo(TStock tStock){
		
		try {
			Stock stock = YahooFinance.get(tStock.getSymbol());
			tStock.setPreClosed(stock.getQuote().getPreviousClose());
			tStock.setPrice(stock.getQuote().getPrice());
			tStock.setChangePrice(stock.getQuote().getChange());
			tStock.setChangeInPercent(stock.getQuote().getChangeInPercent());
			tStock.setVolumn(stock.getQuote().getVolume());
			tStock.setTransactionDate(stock.getQuote().getLastTradeTime().getTime());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void refreshInfo(String symbol){
		try {
			Stock stock = YahooFinance.get(symbol);
			System.out.println(stock.getQuote().getChange());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Optional<List<HistoricalQuote>> getHistoricalQuotes(String symbol, Integer period, Integer timeUnit, Interval interval) {
		Calendar from = Calendar.getInstance();
		Calendar to  = Calendar.getInstance();
		from.add(timeUnit, period);
		Optional<List<HistoricalQuote>> optList = Optional.ofNullable(null);
		try {
			Stock stock = YahooFinance.get(symbol);
			optList = Optional.of(stock.getHistory(from, to, interval));
		} catch (Exception e) {
			System.out.println("-----------test-----------");
			e.printStackTrace();
		}
		return optList;
	}
	
}
