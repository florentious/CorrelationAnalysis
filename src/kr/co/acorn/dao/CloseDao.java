package kr.co.acorn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.acorn.dto.CloseDto;
import kr.co.acorn.util.ConnLocator;

public class CloseDao {
	// new singleton
	private CloseDao() {	
	}
	private static class Singleton {
		public static final CloseDao INSTANCE = new CloseDao();
	}
	public static CloseDao getInstance() {
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
	
	public ArrayList<CloseDto> select() {
		ArrayList<CloseDto> list = new ArrayList<CloseDto>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnLocator.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT cl_date, cl_bitcoin, cl_gold, cl_dowjones ");
			sql.append("FROM al_close ");

			// 3년전 데이터부터 렉이 많이 걸리니까
			sql.append("WHERE cl_date >= DATE_SUB((SELECT cl_date FROM al_close ORDER BY cl_date DESC LIMIT 0,1 ), INTERVAL 3 YEAR) ");
			

			ps = con.prepareStatement(sql.toString());
			
			int index = 0;
//			ps.setInt(++index, 0);
//			ps.setInt(++index, 365);
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				index = 0;
				/*
				int no = rs.getInt(++index);
				String name = rs.getString(++index);
				String loc = rs.getString(++index);
				list.add(new DeptDto(no,name,loc));
				 */
				String date = rs.getString(++index);
				double bitcoin = rs.getDouble(++index);
				double gold = rs.getDouble(++index);
				double dowjones = rs.getDouble(++index);
				
				list.add(new CloseDto(date,bitcoin,gold,dowjones));
				
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
