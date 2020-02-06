package kr.co.acorn.dto;

public class MakedDataDto {
	private String date;
	
	private double bit_close;
	private double bit_ma5;
	private double bit_ma60;
	private double bit_dif;
	private double bit_dif_b1;
	
	private double gol_close;
	private double gol_ma5;
	private double gol_ma60;
	private double gol_dif;
	private double gol_dif_b1;
	
	private double dj_close;
	private double dj_ma5;
	private double dj_ma60;
	private double dj_dif;
	private double dj_dif_b1;
	
	private int bit_change;
	private int gol_change;
	private int dj_change;
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getBit_close() {
		return bit_close;
	}

	public void setBit_close(double bit_close) {
		this.bit_close = bit_close;
	}

	public double getBit_ma5() {
		return bit_ma5;
	}

	public void setBit_ma5(double bit_ma5) {
		this.bit_ma5 = bit_ma5;
	}

	public double getBit_ma60() {
		return bit_ma60;
	}

	public void setBit_ma60(double bit_ma60) {
		this.bit_ma60 = bit_ma60;
	}

	public double getBit_dif() {
		return bit_dif;
	}

	public void setBit_dif(double bit_dif) {
		this.bit_dif = bit_dif;
	}

	public double getBit_dif_b1() {
		return bit_dif_b1;
	}

	public void setBit_dif_b1(double bit_dif_b1) {
		this.bit_dif_b1 = bit_dif_b1;
	}

	public double getGol_close() {
		return gol_close;
	}

	public void setGol_close(double gol_close) {
		this.gol_close = gol_close;
	}

	public double getGol_ma5() {
		return gol_ma5;
	}

	public void setGol_ma5(double gol_ma5) {
		this.gol_ma5 = gol_ma5;
	}

	public double getGol_ma60() {
		return gol_ma60;
	}

	public void setGol_ma60(double gol_ma60) {
		this.gol_ma60 = gol_ma60;
	}

	public double getGol_dif() {
		return gol_dif;
	}

	public void setGol_dif(double gol_dif) {
		this.gol_dif = gol_dif;
	}

	public double getGol_dif_b1() {
		return gol_dif_b1;
	}

	public void setGol_dif_b1(double gol_dif_b1) {
		this.gol_dif_b1 = gol_dif_b1;
	}

	public double getDj_close() {
		return dj_close;
	}

	public void setDj_close(double dj_close) {
		this.dj_close = dj_close;
	}

	public double getDj_ma5() {
		return dj_ma5;
	}

	public void setDj_ma5(double dj_ma5) {
		this.dj_ma5 = dj_ma5;
	}

	public double getDj_ma60() {
		return dj_ma60;
	}

	public void setDj_ma60(double dj_ma60) {
		this.dj_ma60 = dj_ma60;
	}

	public double getDj_dif() {
		return dj_dif;
	}

	public void setDj_dif(double dj_dif) {
		this.dj_dif = dj_dif;
	}

	public double getDj_dif_b1() {
		return dj_dif_b1;
	}

	public void setDj_dif_b1(double dj_dif_b1) {
		this.dj_dif_b1 = dj_dif_b1;
	}

	public int getBit_change() {
		return bit_change;
	}

	public void setBit_change(int bit_change) {
		this.bit_change = bit_change;
	}

	public int getGol_change() {
		return gol_change;
	}

	public void setGol_change(int gol_change) {
		this.gol_change = gol_change;
	}

	public int getDj_change() {
		return dj_change;
	}

	public void setDj_change(int dj_change) {
		this.dj_change = dj_change;
	}

	public MakedDataDto(String date, double bit_close, double bit_ma5, double bit_ma60, double bit_dif,
			double bit_dif_b1, double gol_close, double gol_ma5, double gol_ma60, double gol_dif, double gol_dif_b1,
			double dj_close, double dj_ma5, double dj_ma60, double dj_dif, double dj_dif_b1, int bit_change,
			int gol_change, int dj_change) {
		super();
		this.date = date;
		this.bit_close = bit_close;
		this.bit_ma5 = bit_ma5;
		this.bit_ma60 = bit_ma60;
		this.bit_dif = bit_dif;
		this.bit_dif_b1 = bit_dif_b1;
		this.gol_close = gol_close;
		this.gol_ma5 = gol_ma5;
		this.gol_ma60 = gol_ma60;
		this.gol_dif = gol_dif;
		this.gol_dif_b1 = gol_dif_b1;
		this.dj_close = dj_close;
		this.dj_ma5 = dj_ma5;
		this.dj_ma60 = dj_ma60;
		this.dj_dif = dj_dif;
		this.dj_dif_b1 = dj_dif_b1;
		this.bit_change = bit_change;
		this.gol_change = gol_change;
		this.dj_change = dj_change;
	}
	
	
	
	
}
