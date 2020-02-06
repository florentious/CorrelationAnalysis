package kr.co.acorn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import kr.co.acorn.dto.PredictDto;
import kr.co.acorn.util.ConnLocator;

public class PredictDao {
	// new singleton
	private PredictDao() {	
	}
	private static class Singleton {
		public static final PredictDao INSTANCE = new PredictDao();
	}
	public static PredictDao getInstance() {
		return Singleton.INSTANCE;
	}
	
	
	public PredictDto select() {
		PredictDto dto = null;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConnLocator.getConnection();

			StringBuffer sql = new StringBuffer();
			
			ArrayList<String> dataList = new ArrayList<String>();
			
			dataList.add("bit");
			dataList.add("gol");
			dataList.add("dj");
			
			sql.append("SELECT pc_date, pc_bit_arima, pc_gol_arima, pc_dj_arima ");
			
			for (String string : dataList) {
				sql.append(", pc_"+string+"_vote");
				sql.append(", pc_"+string+"_knc");
				sql.append(", pc_"+string+"_svc");
				sql.append(", pc_"+string+"_rfc");
				sql.append(", pc_"+string+"_xgbc");
				sql.append(", pc_"+string+"_lgbc");
			}
			
			sql.append(" FROM pred_clf ");
			sql.append("ORDER BY pc_date DESC ");
			sql.append("LIMIT 0,1 ");

			ps = con.prepareStatement(sql.toString());

			int index = 0;

			rs = ps.executeQuery();

			if (rs.next()) {
				index = 0;
				
				String date = rs.getString(++index);
				
				double bit_arima = rs.getDouble(++index);
				double gol_arima = rs.getDouble(++index);
				double dj_arima = rs.getDouble(++index);
				
				int bit_vote = rs.getInt(++index);
				int bit_knc = rs.getInt(++index);
				int bit_svc = rs.getInt(++index);
				int bit_rfc = rs.getInt(++index);
				int bit_xgbc = rs.getInt(++index);
				int bit_lgbc = rs.getInt(++index);
				
				int gol_vote = rs.getInt(++index);
				int gol_knc = rs.getInt(++index);
				int gol_svc = rs.getInt(++index);
				int gol_rfc = rs.getInt(++index);
				int gol_xgbc = rs.getInt(++index);
				int gol_lgbc = rs.getInt(++index);
				
				int dj_vote = rs.getInt(++index);
				int dj_knc = rs.getInt(++index);
				int dj_svc = rs.getInt(++index);
				int dj_rfc = rs.getInt(++index);
				int dj_xgbc = rs.getInt(++index);
				int dj_lgbc = rs.getInt(++index);
				
				dto = new PredictDto(date, bit_arima, gol_arima, dj_arima, bit_vote, bit_knc, bit_svc, bit_rfc, bit_xgbc, bit_lgbc, gol_vote, gol_knc, gol_svc, gol_rfc, gol_xgbc, gol_lgbc, dj_vote, dj_knc, dj_svc, dj_rfc, dj_xgbc, dj_lgbc );
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}

		}

		return dto;
		
	}
}
