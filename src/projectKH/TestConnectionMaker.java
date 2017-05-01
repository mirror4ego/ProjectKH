package projectKH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnectionMaker implements ConnectionMaker {
	
	// 테스트를 위한 커넥션 정보 설정
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException { 
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection(
				"jdbc:oracle:thin:@mirror4ego.iptime.org:1521:orcl", "kh", "kh");
		return c;
	}
	
}
