package com.Rutuja.demo.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.Rutuja.demo.Model.StockDetails;
import com.Rutuja.demo.Repository.StockRepository;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

@Service
public class StockService {
	
	@Autowired
	StockRepository repo;
	
	
	public String[] niftyCompanies = { "ADANIPORTS.NS", "ASIANPAINT.NS", "AXISBANK.NS", "BAJAJ-AUTO.NS",
			"BAJFINANCE.NS", "BAJAJFINSV.NS", "BPCL.NS", "BHARTIARTL.NS", "HDFCLIFE.NS", "BRITANNIA.NS", "CIPLA.NS",
			"COALINDIA.NS", "DRREDDY.NS", "EICHERMOT.NS", "GAIL.NS", "GRASIM.NS", "HCLTECH.NS", "HDFCBANK.NS",
			"HEROMOTOCO.NS", "HINDALCO.NS", "HINDUNILVR.NS", "HDFC.NS", "ICICIBANK.NS", "ITC.NS", "IOC.NS",
			"INDUSINDBK.NS", "INFY.NS", "JSWSTEEL.NS", "KOTAKBANK.NS", "LT.NS", "M&M.NS", "MARUTI.NS", "NTPC.NS",
			"NESTLEIND.NS", "ONGC.NS", "POWERGRID.NS", "RELIANCE.NS", "SHREECEM.NS", "SBIN.NS", "SUNPHARMA.NS",
			"TCS.NS", "TATAMOTORS.NS", "TATASTEEL.NS", "TECHM.NS", "TITAN.NS", "UPL.NS", "ULTRACEMCO.NS", "VEDL.NS",
			"WIPRO.NS", "DIVISLAB.NS" };
	

	public String convertDate(Calendar cal) {
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
		String formatDate = fomat.format(cal.getTime());
		return formatDate;
	}
	
	StockDetails stock;
	public void getStockInfo(String stockName,int day) throws IOException {
		Calendar from = Calendar.getInstance();//from the day back 
		Calendar to = Calendar.getInstance(); //todays date
		from.add(Calendar.DAY_OF_MONTH, Integer.valueOf("-"+day));
		
		List<HistoricalQuote> history =YahooFinance.get(stockName).getHistory(from, to, Interval.DAILY);
		for(HistoricalQuote quote : history) {
			stock= new StockDetails();
			stock.setSymbol(quote.getSymbol());
			stock.setDate(convertDate(quote.getDate()));
			stock.setOpenprice(quote.getOpen().doubleValue());
			stock.setHighprice(quote.getHigh().doubleValue());
			stock.setLowprice(quote.getLow().doubleValue());
			stock.setCloseprice(quote.getClose().doubleValue());
			stock.setVolume(quote.getVolume());
			System.out.println(stock.toString());
			repo.save(stock);
		
			
		}
			//System.out.println(stock.toString());
		//return stock;
		}
//	public Map<String,HistoricalQuote> getStockInfo(String[] niftyCompanies,int day) throws IOException {
//		Calendar from = Calendar.getInstance();//from the day back 
//		Calendar to = Calendar.getInstance(); //todays date
//		from.add(Calendar.DAY_OF_MONTH, Integer.valueOf("-"+day));
//		
//		Map<String,HistoricalQuote> history =(Map<String, HistoricalQuote>) ((Stock) YahooFinance.get(niftyCompanies)).getHistory(from, to, Interval.DAILY);
//		for(int quote=0;quote<history.size();quote++) {
//			stock= new StockDetails();
//			stock.setSymbol(history.get(quote).getSymbol());
//			stock.setDate(convertDate(history.get(quote).getDate()));
//			stock.setOpenprice(history.get(quote).getOpen().doubleValue());
//			stock.setHighprice(history.get(quote).getHigh().doubleValue());
//			stock.setLowprice(history.get(quote).getLow().doubleValue());
//			stock.setCloseprice(history.get(quote).getClose().doubleValue());
//			stock.setVolume(history.get(quote).getVolume());
//			System.out.println(stock.toString());
//			repo.save(stock);
//		
//			
//		}
//			//System.out.println(stock.toString());
//		//return stock;
//		return history;
//		}
	
	//calling history details for all nifty stocks
	public void getAllNiftyStocks(int period) throws IOException {
		for(int i=0;i<niftyCompanies.length;i++) {
			getStockInfo(niftyCompanies[i],period);
		}
		//getStockInfo(niftyCompanies,period);
	}
	

	
}
