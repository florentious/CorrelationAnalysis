package kr.co.acorn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.acorn.dto.DowJonesDto;
import kr.co.acorn.util.ConnLocator;

public class DowJonesDao {
		// new singleton
		private DowJonesDao() {	
		}
		private static class Singleton {
			public static final DowJonesDao INSTANCE = new DowJonesDao();
		}
		public static DowJonesDao getInstance() {
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
				
				sql.append("SELECT COUNT(dj_date) FROM dowjones ");
				
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
		
		public ArrayList<DowJonesDto> select() {
			ArrayList<DowJonesDto> list = new ArrayList<DowJonesDto>();
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				con = ConnLocator.getConnection();
				
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT dj_date, dj_close, dj_open, dj_high, dj_low, dj_volume ");
				sql.append("FROM dowjones ");
				sql.append("ORDER BY dj_date DESC ");
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
					
					list.add(new DowJonesDto(date,close,open,high,low,volume));
					
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
