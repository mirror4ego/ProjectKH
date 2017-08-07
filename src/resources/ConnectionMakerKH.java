package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMakerKH implements ConnectionMaker {

	// 메인서버 접속을 위한 커넥션 정보 설정
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException { 
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "kh", "kh");
		return c;
	}
}
