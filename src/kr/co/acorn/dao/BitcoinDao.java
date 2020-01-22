package kr.co.acorn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.acorn.dto.BitcoinDto;
import kr.co.acorn.util.ConnLocator;

public class BitcoinDao {
	// new singleton
	private BitcoinDao() {	
	}
	private static class Singleton {
		public static final BitcoinDao INSTANCE = new BitcoinDao();
	}
	public static BitcoinDao getInstance() {
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
			
			sql.append("SELECT COUNT(bit_date) FROM bitcoin");
			
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
	
	public ArrayList<BitcoinDto> select() {
		ArrayList<BitcoinDto> list = new ArrayList<BitcoinDto>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnLocator.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT bit_date, bit_close, bit_open, bit_high, bit_low, bit_volume ");
			sql.append("FROM bitcoin ");
			sql.append("ORDER BY bit_date DESC ");
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
				
				list.add(new BitcoinDto(date,close,open,high,low,volume));
				
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
