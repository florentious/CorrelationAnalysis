package kr.co.acorn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.acorn.dto.GoldDto;
import kr.co.acorn.util.ConnLocator;

public class GoldDao {
		// new singleton
		private GoldDao() {	
		}
		private static class Singleton {
			public static final GoldDao INSTANCE = new GoldDao();
		}
		public static GoldDao getInstance() {
			return Singleton.INSTANCE;
		}
		
		
		private void close(Connection con, PreparedStatement ps, ResultSet rs) {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				
			}
		}
		
		public int getTotalRows() {
			int rows = 0;
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				con = ConnLocator.getConnection();
				
				StringBuffer sql = new StringBuffer();
				
				sql.append("SELECT COUNT(gold_date) FROM gold ");
				
				ps = con.prepareStatement(sql.toString());
				
				int index = 0;
				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					index = 0;
					rows = rs.getInt(++index);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(con,ps,rs);
				
			}
			
			
			
			return rows;
		}
		
		public ArrayList<GoldDto> select() {
			ArrayList<GoldDto> list = new ArrayList<GoldDto>();
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				con = ConnLocator.getConnection();
				
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT gold_date, gold_close, gold_open, gold_high, gold_low, gold_volume ");
				sql.append("FROM gold ");
				sql.append("ORDER BY gold_date DESC ");
				ps = con.prepareStatement(sql.toString());
				
				int index = 0;
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					index = 0;
					
					String date = rs.getString(++index);
					double close = rs.getDouble(++index);
					double open = rs.getDouble(++index);
					double high = rs.getDouble(++index);
					double low = rs.getDouble(++index);
					double volume = rs.getDouble(++index);
					
					list.add(new GoldDto(date,close,open,high,low,volume));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(con, ps, rs);
			}
			
			return list;
		}
}
