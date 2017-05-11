package test;

import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws SQLException {
		Login login = new Login();
		boolean test = login.login("mirror4ego", "1234");

		System.out.println("로그인 결과 :"+test);
	}
}
