package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import resources.ConnectionMaker;
import resources.ConnectionMakerKH;


public class Login {
	
	private ConnectionMaker connectionMaker;

	/*	public static void main(String[] args) {

		boolean test = loginTest("test", "1234");

		System.out.println("로그인 결과 :"+test);
	}*/

	public Login() {
		connectionMaker = new ConnectionMakerKH();
	}
	
	public boolean login(String id, String password) throws SQLException{
		boolean flag = false;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String getPass = null;

		try {
			c = connectionMaker.makeConnection();

			ps = c.prepareStatement("select password from users where id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			System.out.println("판단전");
			
			if (rs.next()==false) {
				rs.next();
				getPass = rs.getString("password");
				System.out.println("DB에서 가져온 비밀번호 : " + getPass);
				if (getPass.equals(password)) {
					System.out.println("DB에서 가져온 비밀번호 : " + getPass);
					flag = true;
				}
			}else{
				System.out.println("오류 발생");
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			rs.close();
			ps.close();
			c.close();
		}

		return flag;
	}
}
