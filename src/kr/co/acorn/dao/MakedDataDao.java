package kr.co.acorn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.acorn.dto.MakedDataDto;
import kr.co.acorn.util.ConnLocator;

public class MakedDataDao {
	// new singleton
	private MakedDataDao() {	
	}
	private static class Singleton {
		public static final MakedDataDao INSTANCE = new MakedDataDao();
	}
	public static MakedDataDao getInstance() {
		return Singleton.INSTANCE;
	}
	
	
	public ArrayList<MakedDataDto> select() {
		ArrayList<MakedDataDto> list = new ArrayList<MakedDataDto>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnLocator.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT md_date, md_bit_close, md_bit_ma5, md_bit_ma60, md_bit_dif, md_bit_dif_b1, ");
			sql.append("md_gol_close, md_gol_ma5, md_gol_ma60, md_gol_dif, md_gol_dif_b1, ");
			sql.append("md_dj_close, md_dj_ma5, md_dj_ma60, md_dj_dif, md_dj_dif_b1, ");
			sql.append("md_bit_change, md_gol_change, md_dj_change ");
			sql.append("FROM makedData ");
			sql.append("WHERE md_date >= DATE_SUB((SELECT md_date FROM makedData ORDER BY md_date DESC LIMIT 0,1 ), INTERVAL 3 YEAR) ");
			
			ps = con.prepareStatement(sql.toString());
			
			int index = 0;
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				index = 0;
				String date = rs.getString(++index);
				
				double bit_close = rs.getDouble(++index);
				double bit_ma5 = rs.getDouble(++index);
				double bit_ma60 = rs.getDouble(++index);
				double bit_dif = rs.getDouble(++index);
				double bit_dif_b1 = rs.getDouble(++index);
				
				double gol_close = rs.getDouble(++index);
				double gol_ma5 = rs.getDouble(++index);
				double gol_ma60 = rs.getDouble(++index);
				double gol_dif = rs.getDouble(++index);
				double gol_dif_b1 = rs.getDouble(++index);
				
				double dj_close = rs.getDouble(++index);
				double dj_ma5 = rs.getDouble(++index);
				double dj_ma60 = rs.getDouble(++index);
				double dj_dif = rs.getDouble(++index);
				double dj_dif_b1 = rs.getDouble(++index);
				
				int bit_change = rs.getInt(++index);
				int gol_change = rs.getInt(++index);
				int dj_change = rs.getInt(++index);
				
				list.add(new MakedDataDto(date, bit_close, bit_ma5, bit_ma60, bit_dif, bit_dif_b1,
						gol_close, gol_ma5, gol_ma60, gol_dif, gol_dif_b1,
						dj_close, dj_ma5, dj_ma60, dj_dif, dj_dif_b1,
						bit_change, gol_change, dj_change));

				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				
			}
			
		}
		
		return list;
		
		
	}
	
}
