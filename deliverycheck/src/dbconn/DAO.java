package dbconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DAO {
	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	public List<DTO> searchWayvill(int page) {
		con = DBUtil.dbConn();
		List<DTO> dto = null;
		try {
			pstm = con.prepareStatement("SELECT no, company.code AS cd, name, memo FROM company NATURAL JOIN wayvill LIMIT ?,10");
			pstm.setInt(1, (page-1)*10);
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto.add(new DTO(rs.getInt("no"), rs.getString("cd") + ":" + rs.getString("name"), rs.getString("memo")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		dbClose();
		}
		return dto;
	}
	
	private void dbClose() {
		DBUtil.rsClose(rs);
		DBUtil.pstmClose(pstm);
		DBUtil.conClose(con);
	}
}
