package com.Rutuja.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.Rutuja.demo.Model.StockDetails;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

@SpringBootApplication
public class ProjectfirstApplication {
//	StockDetails stock;
//	public void getHistoryofSpecifcTimeInterval(String stockName,int day) throws IOException{
//		Calendar from = Calendar.getInstance();//from the day back 
//		Calendar to = Calendar.getInstance(); //todays date
//		from.add(Calendar.DAY_OF_MONTH, Integer.valueOf("-"+day));
//		
//		List<HistoricalQuote> history =YahooFinance.get(stockName).getHistory(from, to, Interval.DAILY);
//		for(HistoricalQuote quote : history) {
////			System.out.println("symbol: "+quote.getSymbol());
////			System.out.println("date: "+convertDate(quote.getDate()));
////			System.out.println("open price: "+quote.getOpen());
////			System.out.println("High price:: "+quote.getHigh());
////			System.out.println("low price: "+quote.getLow());
////			System.out.println("close price: "+quote.getClose());
////			System.out.println("Volume: "+quote.getVolume());
//			stock = new StockDetails();
//			stock.setSymbol(quote.getSymbol());
//			stock.setDate(convertDate(quote.getDate()));
//			stock.setOpenprice(quote.getOpen().doubleValue());
//			stock.setHighprice(quote.getHigh().doubleValue());
//			stock.setLowprice(quote.getLow().doubleValue());
//			stock.setCloseprice(quote.getClose().doubleValue());
//			stock.setVolume(quote.getVolume());
//			System.out.println(stock.toString());
//			
//		}
//			//System.out.println(stock.toString());
//			
//			System.out.println("################################");
//		}
//	
//
//	public String convertDate(Calendar cal) {
//		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
//		String formatDate = fomat.format(cal.getTime());
//		return formatDate;
//	}


	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProjectfirstApplication.class, args);
		//ProjectfirstApplication p = new ProjectfirstApplication();
		//p.getHistoryofSpecifcTimeInterval("WIPRO.NS", 14);
	}

}
