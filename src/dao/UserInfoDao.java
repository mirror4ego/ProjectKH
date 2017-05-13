package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

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
		ps.setString(4, userInfoDto.getUserInfoAddress());
		ps.setInt(5, userInfoDto.getUserInfoPhone());
		ps.setString(6, userInfoDto.getUserInfoEmail());

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
		userInfoDto.setUserInfoNum(rs.getInt("userinfo_num"));
		userInfoDto.setUserInfoAddress(rs.getString("userinfo_address"));
		userInfoDto.setUserInfoPhone(rs.getInt("userinfo_phone"));
		userInfoDto.setUserInfoEmail(rs.getString("userinfo_email"));

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
/*
	*//**한사람의 회원 정보를 얻는 메소드*//*
    public MemberDTO getMemberDTO(String id){
       
        MemberDTO dto = new MemberDTO();
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try {
           
            con = getConn();
            String sql = "select * from tb_member where id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
           
            rs = ps.executeQuery();
           
            if(rs.next()){
                dto.setId(rs.getString("id"));
                dto.setPwd(rs.getString("Pwd"));
                dto.setName(rs.getString("Name"));
                dto.setTel(rs.getString("tel"));
                dto.setAddr(rs.getString("addr"));
                dto.setBirth(rs.getString("birth"));
                dto.setJob(rs.getString("job"));
                dto.setGender(rs.getString("gender"));
                dto.setEmail(rs.getString("email"));
                dto.setIntro(rs.getString("intro"));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return dto;    
    }
   
    *//**멤버리스트 출력*//*
    public Vector getMemberList(){
       
        Vector data = new Vector();  //Jtable에 값을 쉽게 넣는 방법 1. 2차원배열   2. Vector 에 vector추가
       
           
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try{
           
            con = getConn();
            String sql = "select * from tb_member order by name asc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String addr = rs.getString("addr");
                String birth = rs.getString("birth");
                String gender = rs.getString("gender");
                String job = rs.getString("job");
                String email = rs.getString("email");
                String intro = rs.getString("intro");
               
                Vector row = new Vector();
                row.add(id);
                row.add(pwd);
                row.add(name);
                row.add(tel);
                row.add(addr);
                row.add(birth);
                row.add(job);
                row.add(gender);
                row.add(email);
                row.add(intro);
               
                data.add(row);             
            }//while
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }//getMemberList()
   
 
 
    *//**회원 등록*//*
    public boolean insertMember(MemberDTO dto){
       
        boolean ok = false;
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
       
        try{
           
            con = getConn();
            String sql = "insert into tb_member(" +
                        "id,pwd,name,tel,addr,birth," +
                        "job,gender,email,intro) "+
                        "values(?,?,?,?,?,?,?,?,?,?)";
           
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getPwd());
            ps.setString(3, dto.getName());
            ps.setString(4, dto.getTel());
            ps.setString(5, dto.getAddr());
            ps.setString(6, dto.getBirth());
            ps.setString(7, dto.getJob());
            ps.setString(8, dto.getGender());
            ps.setString(9, dto.getEmail());
            ps.setString(10, dto.getIntro());          
            int r = ps.executeUpdate(); //실행 -> 저장
           
           
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
    }//insertMmeber
   
   
    *//**회원정보 수정*//*
    public boolean updateMember(MemberDTO vMem){
        System.out.println("dto="+vMem.toString());
        boolean ok = false;
        Connection con = null;
        PreparedStatement ps = null;
        try{
           
            con = getConn();           
            String sql = "update tb_member set name=?, tel=?, addr=?, birth=?, job=?, gender=?" +
                    ", email=?,intro=? "+ "where id=? and pwd=?";
           
            ps = con.prepareStatement(sql);
           
            ps.setString(1, vMem.getName());
            ps.setString(2, vMem.getTel());
            ps.setString(3, vMem.getAddr());
            ps.setString(4, vMem.getBirth());
            ps.setString(5, vMem.getJob());
            ps.setString(6, vMem.getGender());
            ps.setString(7, vMem.getEmail());
            ps.setString(8, vMem.getIntro());
            ps.setString(9, vMem.getId());
            ps.setString(10, vMem.getPwd());
           
            int r = ps.executeUpdate(); //실행 -> 수정
            // 1~n: 성공 , 0 : 실패
           
            if(r>0) ok = true; //수정이 성공되면 ok값을 true로 변경
           
        }catch(Exception e){
            e.printStackTrace();
        }
       
        return ok;
    }
   
    *//**회원정보 삭제 :
     *tip: 실무에서는 회원정보를 Delete 하지 않고 탈퇴여부만 체크한다.*//*
    public boolean deleteMember(String id, String pwd){
       
        boolean ok =false ;
        Connection con =null;
        PreparedStatement ps =null;
       
        try {
            con = getConn();
            String sql = "delete from tb_member where id=? and pwd=?";
           
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pwd);
            int r = ps.executeUpdate(); // 실행 -> 삭제
           
            if (r>0) ok=true; //삭제됨;
           
        } catch (Exception e) {
            System.out.println(e + "-> 오류발생");
        }      
        return ok;
    }
   
   
    *//**DB데이터 다시 불러오기*//*   
    public void userSelectAll(DefaultTableModel model) {
       
       
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        try {
            con = getConn();
            String sql = "select * from tb_member order by name asc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            // DefaultTableModel에 있는 데이터 지우기
            for (int i = 0; i < model.getRowCount();) {
                model.removeRow(0);
            }
 
            while (rs.next()) {
                Object data[] = { rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                       rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)};
 
                model.addRow(data);                
            }
 
        } catch (SQLException e) {
            System.out.println(e + "=> userSelectAll fail");
        } finally{
           
            if(rs!=null)
                try {
                    rs.close();
                } catch (SQLException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
            if(ps!=null)
                try {
                    ps.close();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            if(con!=null)
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }
	*/
/*	public void selectAll() throws ClassNotFoundException, SQLException { // 
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

	}*/
}
