package kr.co.acorn.dto;

public class PredictDto {
	private String date;
	
	private double bit_arima;
	private double gol_arima;
	private double dj_arima;
	
	private int bit_vote;
	private int bit_knc;
	private int bit_svc;
	private int bit_rfc;
	private int bit_xgbc;
	private int bit_lgbc;
	
	private int gol_vote;
	private int gol_knc;
	private int gol_svc;
	private int gol_rfc;
	private int gol_xgbc;
	private int gol_lgbc;
	
	private int dj_vote;
	private int dj_knc;
	private int dj_svc;
	private int dj_rfc;
	private int dj_xgbc;
	private int dj_lgbc;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getBit_arima() {
		return bit_arima;
	}
	public void setBit_arima(double bit_arima) {
		this.bit_arima = bit_arima;
	}
	public double getGol_arima() {
		return gol_arima;
	}
	public void setGol_arima(double gol_arima) {
		this.gol_arima = gol_arima;
	}
	public double getDj_arima() {
		return dj_arima;
	}
	public void setDj_arima(double dj_arima) {
		this.dj_arima = dj_arima;
	}
	public int getBit_vote() {
		return bit_vote;
	}
	public void setBit_vote(int bit_vote) {
		this.bit_vote = bit_vote;
	}
	public int getBit_knc() {
		return bit_knc;
	}
	public void setBit_knc(int bit_knc) {
		this.bit_knc = bit_knc;
	}
	public int getBit_svc() {
		return bit_svc;
	}
	public void setBit_svc(int bit_svc) {
		this.bit_svc = bit_svc;
	}
	public int getBit_rfc() {
		return bit_rfc;
	}
	public void setBit_rfc(int bit_rfc) {
		this.bit_rfc = bit_rfc;
	}
	public int getBit_xgbc() {
		return bit_xgbc;
	}
	public void setBit_xgbc(int bit_xgbc) {
		this.bit_xgbc = bit_xgbc;
	}
	public int getBit_lgbc() {
		return bit_lgbc;
	}
	public void setBit_lgbc(int bit_lgbc) {
		this.bit_lgbc = bit_lgbc;
	}
	public int getGol_vote() {
		return gol_vote;
	}
	public void setGol_vote(int gol_vote) {
		this.gol_vote = gol_vote;
	}
	public int getGol_knc() {
		return gol_knc;
	}
	public void setGol_knc(int gol_knc) {
		this.gol_knc = gol_knc;
	}
	public int getGol_svc() {
		return gol_svc;
	}
	public void setGol_svc(int gol_svc) {
		this.gol_svc = gol_svc;
	}
	public int getGol_rfc() {
		return gol_rfc;
	}
	public void setGol_rfc(int gol_rfc) {
		this.gol_rfc = gol_rfc;
	}
	public int getGol_xgbc() {
		return gol_xgbc;
	}
	public void setGol_xgbc(int gol_xgbc) {
		this.gol_xgbc = gol_xgbc;
	}
	public int getGol_lgbc() {
		return gol_lgbc;
	}
	public void setGol_lgbc(int gol_lgbc) {
		this.gol_lgbc = gol_lgbc;
	}
	public int getDj_vote() {
		return dj_vote;
	}
	public void setDj_vote(int dj_vote) {
		this.dj_vote = dj_vote;
	}
	public int getDj_knc() {
		return dj_knc;
	}
	public void setDj_knc(int dj_knc) {
		this.dj_knc = dj_knc;
	}
	public int getDj_svc() {
		return dj_svc;
	}
	public void setDj_svc(int dj_svc) {
		this.dj_svc = dj_svc;
	}
	public int getDj_rfc() {
		return dj_rfc;
	}
	public void setDj_rfc(int dj_rfc) {
		this.dj_rfc = dj_rfc;
	}
	public int getDj_xgbc() {
		return dj_xgbc;
	}
	public void setDj_xgbc(int dj_xgbc) {
		this.dj_xgbc = dj_xgbc;
	}
	public int getDj_lgbc() {
		return dj_lgbc;
	}
	public void setDj_lgbc(int dj_lgbc) {
		this.dj_lgbc = dj_lgbc;
	}
	
	public PredictDto(String date, double bit_arima, double gol_arima, double dj_arima, int bit_vote, int bit_knc,
			int bit_svc, int bit_rfc, int bit_xgbc, int bit_lgbc, int gol_vote, int gol_knc, int gol_svc, int gol_rfc,
			int gol_xgbc, int gol_lgbc, int dj_vote, int dj_knc, int dj_svc, int dj_rfc, int dj_xgbc, int dj_lgbc) {
		super();
		this.date = date;
		this.bit_arima = bit_arima;
		this.gol_arima = gol_arima;
		this.dj_arima = dj_arima;
		this.bit_vote = bit_vote;
		this.bit_knc = bit_knc;
		this.bit_svc = bit_svc;
		this.bit_rfc = bit_rfc;
		this.bit_xgbc = bit_xgbc;
		this.bit_lgbc = bit_lgbc;
		this.gol_vote = gol_vote;
		this.gol_knc = gol_knc;
		this.gol_svc = gol_svc;
		this.gol_rfc = gol_rfc;
		this.gol_xgbc = gol_xgbc;
		this.gol_lgbc = gol_lgbc;
		this.dj_vote = dj_vote;
		this.dj_knc = dj_knc;
		this.dj_svc = dj_svc;
		this.dj_rfc = dj_rfc;
		this.dj_xgbc = dj_xgbc;
		this.dj_lgbc = dj_lgbc;
	}
	
	
	
	
}
