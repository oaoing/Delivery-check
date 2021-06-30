package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public static Connection dbConn() {
		Connection conn = null;
        try {
            String user = "#"; 
            String pw = "#";
            String url = "jdbc:mariadb://127.0.0.1:3306/#";
            
            Class.forName("org.mariadb.jdbc.Driver");        
            conn = DriverManager.getConnection(url, user, pw);
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
        return conn;
	}
	
	public static void rsClose(ResultSet rs){
		try {
			if(rs!=null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void pstmClose(PreparedStatement pstm) {
		try {
			if(pstm!=null) pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void conClose(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
