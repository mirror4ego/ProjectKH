package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.UserInfoDto;
import resources.ConnectionMaker;
import resources.ConnectionMakerKH;

public class UserInfoDao {
	private ConnectionMaker connectionMaker;

	public UserInfoDao() {
		connectionMaker = new ConnectionMakerKH();
	}

	public void add(UserInfoDto userInfoDto) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("insert into userinfo values (?,?,?)");

		// 각 물음표 값에 들어갈 값을 지정하고 set
		ps.setString(1, userInfoDto.getUserInfoId());
		ps.setString(2, userInfoDto.getUserInfoPassword());
		ps.setString(3, userInfoDto.getUserInfoName());

		ps.executeUpdate(); // 쿼리 날리기... executeUpdate를 사용한 이유는 insert into라는 sql문은
		// 결과값을 받아올 필요가 없기 때문이다. 쿼리문을 날리고 결과 값을 받아올 필요가 있을때는(ex : select문)
		// executeQuery 메소드를 사용해야 한다.

		ps.close(); // 사용한 ps객체 닫기
		c.close(); // 사용한 c객체 닫기
		// 공유 자원이기 때문에 닫아주지않으면 연결 세션을 계속 점유 하고 있게 된다.
	}

	public UserInfoDto get(String userInfoId) throws ClassNotFoundException, SQLException { // 
		Connection c = connectionMaker.makeConnection(); // DB로의 커넥션 객체 생성

		PreparedStatement ps = c.prepareStatement("select * from userinfo where userinfo_id = ?");
		// preparestatement메소드를 통해서 쿼리문을 날릴 준비를 함
		ps.setString(1, userInfoId);
		// ? 에 매개변수로 받아온 id를 입력해서 쿼리문 완성

		ResultSet rs = ps.executeQuery();
		// 쿼리문을 실행 executeQuery를 통해서 쿼리를 실행한 결과 값을 받아와서 ResultSet의 객체참조주소 rs에 저장

		rs.next(); // 쿼리문을 통해 받아온 값은 start를 가르키는 위치가 있기 때문에 진짜 값이 시작되는 곳을 찾으려면 이 메소드를 꼭 한번 실행해야 한다
		UserInfoDto userInfoDto = new UserInfoDto(); // 고객정보 클래스의 객체를 생성
		userInfoDto.setUserInfoId(rs.getString("userinfo_id"));
		userInfoDto.setUserInfoPassword(rs.getString("userinfo_password"));
		userInfoDto.setUserInfoName(rs.getString("userinfo_name"));

		// DB사용이 끝났으므로 모든 커넥션을 순서대로 닫아준다
		rs.close();
		ps.close();
		c.close();

		return userInfoDto; // 최종적으로 불러온 유저 정보에 관련한 객체를 리턴
		
	}

	public void deleteAll() throws ClassNotFoundException, SQLException { // DB에 저장된 데이터를 전부 삭제하는 메소드
		Connection c = connectionMaker.makeConnection();; // DB로의 커넥션 생성

		PreparedStatement ps = c.prepareStatement("truncate table userinfo");
		// preparestatement메소드를 통해서 쿼리문을 날릴 준비를 함

		ps.executeUpdate(); // 쿼리문 실행

		// 커넥션 close
		ps.close();
		c.close();
	}

	public void selectAll() throws ClassNotFoundException, SQLException { // 
		Connection c = connectionMaker.makeConnection(); // DB로의 커넥션 객체 생성

		PreparedStatement ps = c.prepareStatement("select * from userinfo");
		// preparestatement메소드를 통해서 쿼리문을 날릴 준비를 함
		//ps.setString(1, userInfoId);
		// ? 에 매개변수로 받아온 id를 입력해서 쿼리문 완성

		ResultSet rs = ps.executeQuery();
		// 쿼리문을 실행 executeQuery를 통해서 쿼리를 실행한 결과 값을 받아와서 ResultSet의 객체참조주소 rs에 저장

		rs.next(); // 쿼리문을 통해 받아온 값은 start를 가르키는 위치가 있기 때문에 진짜 값이 시작되는 곳을 찾으려면 이 메소드를 꼭 한번 실행해야 한다
 
		System.out.println(rs.getString("userinfo_id"));
		System.out.println(rs.getString("userinfo_password"));
		System.out.println(rs.getString("userinfo_name"));


		// DB사용이 끝났으므로 모든 커넥션을 순서대로 닫아준다
		rs.close();
		ps.close();
		c.close();

		//return userInfoDto; // 최종적으로 불러온 유저 정보에 관련한 객체를 리턴
		
	}
}
