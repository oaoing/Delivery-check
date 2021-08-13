package dbconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	public List<DTOWayvill> searchWayvill() {
		con = DBUtil.dbConn();
		List<DTOWayvill> dto = new ArrayList<DTOWayvill>();
		try {
			pstm = con.prepareStatement("SELECT wayvill, code, company, memo FROM wayvill");
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto.add(new DTOWayvill(rs.getString("wayvill"), rs.getString("code"), rs.getString("company"), rs.getString("memo")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		dbClose();
		}
		return dto;
	}
	
	public void deleteWayvill(String wayvill) {
		con = DBUtil.dbConn();
		try {
			pstm = con.prepareStatement("DELETE FROM wayvill WHERE wayvill=?");
			pstm.setString(1, wayvill);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		dbClose();
		}
	}
	
	public void addWayvill(String wayvill, String code, String company, String memo) {
		con = DBUtil.dbConn();
		try {
			pstm = con.prepareStatement("INSERT INTO wayvill VALUES(NULL, ?, ?, ?, ?)");
			pstm.setString(1, wayvill);
			pstm.setString(2, code);
			pstm.setString(3, company);
			pstm.setString(4, memo);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	private void dbClose() {
		DBUtil.rsClose(rs);
		DBUtil.pstmClose(pstm);
		DBUtil.conClose(con);
	}
}
