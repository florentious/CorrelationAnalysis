package kr.co.acorn.dto;

public class DowJonesDto {
	private String date;
	private double close;
	private double open;
	private double high;
	private double low;
	private double volume;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	public DowJonesDto(String date, double close, double open, double high, double low, double volume) {
		super();
		this.date = date;
		this.close = close;
		this.open = open;
		this.high = high;
		this.low = low;
		this.volume = volume;
	}
	
	
}
