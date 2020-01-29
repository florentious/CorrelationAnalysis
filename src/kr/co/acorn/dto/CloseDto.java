package kr.co.acorn.dto;

public class CloseDto {
	private String date;
	private double bitcoin;
	private double gold;
	private double dowjones;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getBitcoin() {
		return bitcoin;
	}
	public void setBitcoin(double bitcoin) {
		this.bitcoin = bitcoin;
	}
	public double getGold() {
		return gold;
	}
	public void setGold(double gold) {
		this.gold = gold;
	}
	public double getDowjones() {
		return dowjones;
	}
	public void setDowjones(double dowjones) {
		this.dowjones = dowjones;
	}
	
	public CloseDto(String date, double bitcoin, double gold, double dowjones) {
		super();
		this.date = date;
		this.bitcoin = bitcoin;
		this.gold = gold;
		this.dowjones = dowjones;
	}
	
	
}
