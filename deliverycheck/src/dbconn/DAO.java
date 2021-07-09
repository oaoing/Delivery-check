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
			pstm = con.prepareStatement("SELECT wayvill, company.code AS cd, name, memo FROM company NATURAL JOIN wayvill");
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto.add(new DTOWayvill(rs.getString("wayvill"), rs.getString("cd"), rs.getString("name"), rs.getString("memo")));
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
	
	public void addWayvill(String wayvill, String company, String memo) {
		con = DBUtil.dbConn();
		try {
			pstm = con.prepareStatement("INSERT INTO wayvill VALUES(NULL, ?, ?, ?)");
			pstm.setString(1, wayvill);
			pstm.setString(2, company);
			pstm.setString(3, memo);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	public List<DTOCompany> searchCompanyList() {
		con = DBUtil.dbConn();
		List<DTOCompany> company = new ArrayList<DTOCompany>();
		try {
			pstm = con.prepareStatement("SELECT code, name FROM company ORDER BY name");
			rs = pstm.executeQuery();
			while(rs.next()) {
				company.add(new DTOCompany(rs.getString("code"), rs.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		dbClose();
		}
		return company;
	}
	
	public DTOCompany searchCompany(String code) {
		con = DBUtil.dbConn();
		DTOCompany company = null;
		try {
			pstm = con.prepareStatement("SELECT code, name FROM company WHERE code=?");
			pstm.setString(1, code);
			rs = pstm.executeQuery();
			if(rs.next()) {
				company = new DTOCompany(rs.getString("code"), rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		dbClose();
		}
		return company;
	}
	
	private void dbClose() {
		DBUtil.rsClose(rs);
		DBUtil.pstmClose(pstm);
		DBUtil.conClose(con);
	}
}
