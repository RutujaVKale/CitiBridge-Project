package com.Rutuja.demo.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Rutuja.demo.Model.StockDetails;
import com.Rutuja.demo.Repository.StockRepository;
import com.Rutuja.demo.Service.StockService;

import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

@RestController
public class StockController {
	
	@Autowired
	StockService service;
		
//	@GetMapping("/getstock/{stockName}/{day}")
//	@CrossOrigin
//	@ResponseBody
//	public void getStockInformation(@PathVariable String stockName,@PathVariable int day) throws IOException {
//		service.getStockInfo(stockName, day);
//		
//		}
	@GetMapping("/getStock/{period}")
	@CrossOrigin
	//@ResponseBody
	public void getAllNiftyComapniesStockDetails(@PathVariable int period) throws IOException {
		service.getAllNiftyStocks(period);
	}
	

	
		
}


