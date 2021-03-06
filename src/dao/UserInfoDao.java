package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

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

		PreparedStatement ps = c.prepareStatement("insert into userinfo values (?,?,?,seq_userinfo_num.nextval,?,?,?)");

		// 각 물음표 값에 들어갈 값을 지정하고 set
		ps.setString(1, userInfoDto.getUserInfoId());
		ps.setString(2, userInfoDto.getUserInfoPassword());
		ps.setString(3, userInfoDto.getUserInfoName());
		ps.setString(4, userInfoDto.getUserInfoPhone());
		ps.setString(5, userInfoDto.getUserInfoEmail());

		ps.executeUpdate(); // 쿼리 날리기... executeUpdate를 사용한 이유는 insert into라는 sql문은
		// 결과값을 받아올 필요가 없기 때문이다. 쿼리문을 날리고 결과 값을 받아올 필요가 있을때는(ex : select문)
		// executeQuery 메소드를 사용해야 한다.

		ps.close(); // 사용한 ps객체 닫기
		c.close(); // 사용한 c객체 닫기
		// 공유 자원이기 때문에 닫아주지않으면 연결 세션을 계속 점유 하고 있게 된다.
	}

	public Vector searchUserInfoName(String userInfoName) throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement("select * from userinfo where userinfo_name = ?");
		ps.setString(1,  userInfoName);
		Vector vs = new Vector();

		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Vector vs1 = new Vector();


			vs1.add(rs.getString("userinfo_id"));
			vs1.add(rs.getString("userinfo_employ_status"));
			vs1.add(rs.getString("userinfo_name"));
			vs1.add(rs.getString("userinfo_phone"));
			vs.add(vs1);
		}

		rs.close();
		ps.close();
		c.close();
		System.out.println(vs);

		return vs;
	}

	public Vector searchUserInfoId(String userInfoId) throws ClassNotFoundException, SQLException {
		Connection d = connectionMaker.makeConnection();
		PreparedStatement ps = d.prepareStatement("select * from userInfo where UserInfo_Id = ?");
		ps.setString(1,  userInfoId);
		Vector vs3 = new Vector();

		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Vector vs4 = new Vector();

			vs4.add(rs.getString("userinfo_id"));
			vs4.add(rs.getString("userinfo_employ_status"));
			vs4.add(rs.getString("userinfo_name"));
			vs4.add(rs.getString("userinfo_phone"));
			vs3.add(vs4);
		}

		rs.close();
		ps.close();
		d.close();
		System.out.println(vs3);

		return vs3;
	}


	public Vector userInfoAllPart() throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();
		UserInfoDto userInfoDto = new UserInfoDto();
		Vector data = new Vector();
		try{
			PreparedStatement ps = c.prepareStatement("select * from userinfo order by userinfo_num"); // 
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Vector row = new Vector();
				row.add(rs.getString("userinfo_id"));
				row.add(rs.getString("userinfo_employ_status"));
				row.add(rs.getString("userinfo_name"));
				row.add(rs.getString("userinfo_phone"));


				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}


	public boolean setUserInfoAll(UserInfoDto userInfoDto) throws ClassNotFoundException, SQLException{
		Connection c = connectionMaker.makeConnection();
		boolean ok = false;
		PreparedStatement ps = c.prepareStatement("insert into userinfo values(?,?,?,seq_userinfo_num.nextval,?,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?,?,?,?)");
		//to_date(?,'yyyy-mm-dd hh24:mi:ss')
		ps.setString(1, userInfoDto.getUserInfoId());
		ps.setString(2, userInfoDto.getUserInfoPassword());
		ps.setString(3, userInfoDto.getUserInfoName());
		ps.setString(4, userInfoDto.getUserInfoPhone());
		ps.setString(5, userInfoDto.getUserInfoEmail());
		ps.setString(6, userInfoDto.getUserInfoHireDate());
		ps.setString(7, userInfoDto.getUserInfoEmployStatus());
		ps.setString(8, userInfoDto.getUserInfoTask());
		ps.setString(9, userInfoDto.getUserInfoAttendanceTime());
		ps.setString(10, userInfoDto.getUserInfoQuittingTime());
		ps.setString(11, userInfoDto.getUserInfoAddState());
		ps.setString(12, userInfoDto.getUserInfoAddCity());
		ps.setString(13, userInfoDto.getUserInfoAddStreet());
		ps.setString(14, userInfoDto.getUserInfoAddRest());
		ps.setString(15, userInfoDto.getUserInfoGender()); 

		int r = ps.executeUpdate();

		if(r>0){
			System.out.println("가입 성공");   
			ok=true;
		}else{
			System.out.println("가입 실패");
		}
		return ok;

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
		userInfoDto.setUserInfoNum(rs.getInt("userinfo_num"));
		userInfoDto.setUserInfoPhone(rs.getString("userinfo_phone"));
		userInfoDto.setUserInfoEmail(rs.getString("userinfo_email"));
		userInfoDto.setUserInfoEmployStatus(rs.getString("userinfo_Employ_Status"));
		userInfoDto.setUserInfoTask(rs.getString("userinfo_Task"));
		userInfoDto.setUserInfoEmail(rs.getString("userinfo_email"));
		userInfoDto.setUserInfoAttendanceTime(rs.getString("userinfo_Attendance_Time"));
		userInfoDto.setUserInfoQuittingTime(rs.getString("userinfo_Quitting_Time"));
		userInfoDto.setUserInfoAddState(rs.getString("userinfo_Add_State"));
		userInfoDto.setUserInfoAddCity(rs.getString("userinfo_Add_City"));
		userInfoDto.setUserInfoAddStreet(rs.getString("userinfo_Add_Street"));
		userInfoDto.setUserInfoAddRest(rs.getString("userinfo_Add_Rest"));
		userInfoDto.setUserInfoGender(rs.getString("userinfo_Gender"));

		// DB사용이 끝났으므로 모든 커넥션을 순서대로 닫아준다
		rs.close();
		ps.close();
		c.close();

		return userInfoDto; // 최종적으로 불러온 유저 정보에 관련한 객체를 리턴
	}

	public void deleteAll() throws ClassNotFoundException, SQLException { // DB에 저장된 데이터를 전부 삭제하는 메소드
		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("truncate table userinfo");
		ps.executeUpdate();

		ps.close();
		c.close();
	}


	

	//모든 사용자 리스트를 가져오는 메소드
	public Vector getAllUserIdList() throws ClassNotFoundException, SQLException{
		Connection c = connectionMaker.makeConnection();
		Vector data = new Vector();

		try{
			PreparedStatement ps = c.prepareStatement("select * from userinfo order by userinfo_name asc");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){	
				String userinfo_id = rs.getString("userinfo_id");
				data.add(userinfo_id);             
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
	}

	//사용자 한명의 정보를 가져오는 메소드 (id를 기준으로)
	public UserInfoDto getOneUser(String id) throws ClassNotFoundException, SQLException{

		Connection c = connectionMaker.makeConnection();
		UserInfoDto userInfoDto = new UserInfoDto();

		try{
			PreparedStatement ps = c.prepareStatement("select * from userinfo where userinfo_id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){

				userInfoDto.setUserInfoId(rs.getString("userinfo_id"));
				userInfoDto.setUserInfoEmployStatus(rs.getString("userinfo_employ_status"));
				userInfoDto.setUserInfoName(rs.getString("userinfo_name"));
				userInfoDto.setUserInfoPhone(rs.getString("userinfo_phone"));
//사용되지 않는 메소드
				
			}else{
				JOptionPane.showMessageDialog(null, "사용자의 ID가 존재하지 않습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}      

		return userInfoDto;    
	}

	public ConnectionMaker getConnectionMaker() {
		return connectionMaker;
	}

	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	//사용자 등록 메소드
	public boolean regUser(UserInfoDto userInfoDto) throws ClassNotFoundException, SQLException{

		boolean ok = false;

		Connection c = connectionMaker.makeConnection();       
		try{
			PreparedStatement ps = c.prepareStatement("insert into userinfo values(?,?,?,seq_userinfo_num.nextval,?,?,?)");
			ps.setString(1, userInfoDto.getUserInfoId());
			ps.setString(2, userInfoDto.getUserInfoName());
			ps.setString(3, userInfoDto.getUserInfoPhone());
			ps.setString(4, userInfoDto.getUserInfoEmail());

			int r = ps.executeUpdate();

			if(r>0){
				System.out.println("가입 성공");   
				ok=true;
			}else{
				System.out.println("가입 실패");
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return ok;
	}

	// 사용자 수정 메소드
	public boolean updateUser(UserInfoDto userInfoDto){
		System.out.println("dto="+userInfoDto.toString());
		boolean ok = false;
		try{
			Connection c = connectionMaker.makeConnection();          
			PreparedStatement ps = c.prepareStatement("update userinfo set userinfo_password=?,"
					+ "userinfo_name=?, userinfo_addstate=?, userinfo_addcity=?, userinfo_addstreet=?, userinfo_addrest"
					+ "userinfo_phone=?, userinfo_email=? where userinfo_id=? and userinfo_password=?");

			ps.setString(1, userInfoDto.getUserInfoPassword());
			ps.setString(2, userInfoDto.getUserInfoName());
			ps.setString(4, userInfoDto.getUserInfoPhone());
			ps.setString(5, userInfoDto.getUserInfoEmail());
			ps.setString(6, userInfoDto.getUserInfoId());
			ps.setString(7, userInfoDto.getUserInfoPassword());

			int r = ps.executeUpdate();
			if(r>0) ok = true;

		}catch(Exception e){
			e.printStackTrace();
		}
		return ok;
	}

	//사용자정보 삭제 메소드
	public boolean deleteUser(String userInfoId, String userInfoPassword){

		boolean ok =false ;

		try {
			Connection c = connectionMaker.makeConnection();   
			PreparedStatement ps = c.prepareStatement("delete from userinfo where userinfo_id=? and userinfo_password=?");
			ps.setString(1, userInfoId);
			ps.setString(2, userInfoPassword);
			int r = ps.executeUpdate();
			if (r>0) ok=true;

		} catch (Exception e) {
			System.out.println(e + "-> 오류발생");
		}      
		return ok;
	}

}
