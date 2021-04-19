package com.Rutuja.demo.Model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="stockinfo")

public class StockDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String symbol;
	private String date;
	private double openprice;
	private double highprice;
	private double lowprice;
	private double closeprice;
	private long volume;
	
	public StockDetails() {
		
	}
	
	public StockDetails(int id, String symbol, String date, double openprice, double highprice, double lowprice,
			double closeprice, long volume) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.date = date;
		this.openprice = openprice;
		this.highprice = highprice;
		this.lowprice = lowprice;
		this.closeprice = closeprice;
		this.volume = volume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getOpenprice() {
		return openprice;
	}

	public void setOpenprice(double openprice) {
		this.openprice = openprice;
	}

	public double getHighprice() {
		return highprice;
	}

	public void setHighprice(double highprice) {
		this.highprice = highprice;
	}

	public double getLowprice() {
		return lowprice;
	}

	public void setLowprice(double lowprice) {
		this.lowprice = lowprice;
	}

	public double getCloseprice() {
		return closeprice;
	}

	public void setCloseprice(double closeprice) {
		this.closeprice = closeprice;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "StockMembers [id=" + id + ", symbol=" + symbol + ", date=" + date + ", openprice=" + openprice
				+ ", highprice=" + highprice + ", lowprice=" + lowprice + ", closeprice=" + closeprice + ", volume="
				+ volume + "]";
	}
}
