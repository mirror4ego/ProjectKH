package projectKH;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderInfoDao {
	private ConnectionMaker connectionMaker;
	
	public OrderInfoDao() {
		connectionMaker = new TestConnectionMaker();
	}
	
	public void add(OrderInfo orderInfo) throws ClassNotFoundException, SQLException { // 고객을 추가하는 메소드, 매개변수는  Customer클래스의 객체
		Connection c = connectionMaker.makeConnection(); // data소스에 저장된 커넥션 정보를 c에 저장 
		
		PreparedStatement ps = c.prepareStatement("insert into orderinfo values (seq_orderinfo_num.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		//PreparedStatement ps = c.prepareStatement("insert into customer(customer_Num, customer_Reg_Date, customer_Phone_Num, customer_Add_State, customer_Add_City, customer_Add_Street, customer_Add_Rest, customer_Frequent, customer_Age_Predict) values(?,?,?,?,?,?,?,?,?)");
		// c 객체의 메소드인 prepareaStatement를 이용해서 db에 쿼리를 날림
		// 각 칼럼값에 집어넣을 low값을 ?로 설정
		
		// 각 물음표 값에 들어갈 값을 지정하고 set
		//ps.setInt(1, orderInfo.getOrderInfoNum());
		ps.setString(1, orderInfo.getOrderInfoDate());
		ps.setString(2, orderInfo.getOrderInfoLocPossiblity());
		ps.setString(3, orderInfo.getOrderInfoOrderPossiblity());
		ps.setInt(4, orderInfo.getOrderInfoMenuNum());
		ps.setInt(5, orderInfo.getOrderInfoMenuAmount());
		ps.setString(6, orderInfo.getOrderInfoRequestInfo());
		ps.setInt(7, orderInfo.getOrderInfoChannelNum());
		ps.setString(8, orderInfo.getOrderInfoRequestDelivery());
		ps.setString(9, orderInfo.getOrderInfoPackCompletion());
		ps.setString(10, orderInfo.getOrderInfoDeliveryCompletion());
		ps.setString(11, orderInfo.getOrderInfoOrderCompletion());
		ps.setString(12, orderInfo.getOrderInfoMoneyCollection());
		ps.setString(13, orderInfo.getOrderInfoDeliveryPredict());

		ps.executeUpdate(); // 쿼리 날리기... executeUpdate를 사용한 이유는 insert into라는 sql문은
		// 결과값을 받아올 필요가 없기 때문이다. 쿼리문을 날리고 결과 값을 받아올 필요가 있을때는(ex : select문)
		// executeQuery 메소드를 사용해야 한다.

		ps.close(); // 사용한 ps객체 닫기
		c.close(); // 사용한 c객체 닫기
		// 공유 자원이기 때문에 닫아주지않으면 연결 세션을 계속 점유 하고 있게 된다.
	}

	public OrderInfo get(int orderInfoNum) throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection(); // DB로의 커넥션 객체 생성
		
		PreparedStatement ps = c.prepareStatement("select * from customer where customerNum = ?");
		// preparestatement메소드를 통해서 쿼리문을 날릴 준비를 함
		ps.setInt(1, orderInfoNum);
		// ? 에 매개변수로 받아온 id를 입력해서 쿼리문 완성

		ResultSet rs = ps.executeQuery();
		// 쿼리문을 실행 executeQuery를 통해서 쿼리를 실행한 결과 값을 받아와서 ResultSet의 객체참조주소 rs에 저장
		rs.next(); // 쿼리문을 통해 받아온 값은 start를 가르키는 위치가 있기 때문에 진짜 값이 시작되는 곳을 찾으려면 이 메소드를 꼭 한번 실행해야 한다
		OrderInfo orderInfo = new OrderInfo(); // 고객정보 클래스의 객체를 생성
		
		orderInfo.setOrderInfoNum(rs.getInt("orderInfoNum"));
		orderInfo.setOrderInfoDate(rs.getString("orderInfoDate"));
		orderInfo.setOrderInfoLocPossiblity(rs.getString("orderInfoLocPossiblity"));
		orderInfo.setOrderInfoOrderPossiblity(rs.getString("orderInfoOrderPossiblity"));
		orderInfo.setOrderInfoMenuNum(rs.getInt("orderInfoMenuNum"));
		orderInfo.setOrderInfoMenuAmount(rs.getInt("orderInfoMenuAmount"));
		orderInfo.setOrderInfoRequestInfo(rs.getString("orderInfoRequestInfo"));
		orderInfo.setOrderInfoChannelNum(rs.getInt("orderInfoChannelNum"));
		orderInfo.setOrderInfoRequestDelivery(rs.getString("orderInfoRequestDelivery"));
		orderInfo.setOrderInfoPackCompletion(rs.getString("orderInfoPackCompletion"));
		orderInfo.setOrderInfoDeliveryCompletion(rs.getString("orderInfoDeliveryCompletion"));
		orderInfo.setOrderInfoOrderCompletion(rs.getString("orderInfoOrderCompletion"));
		orderInfo.setOrderInfoMoneyCollection(rs.getString("orderInfoMoneyCollection"));
		orderInfo.setOrderInfoDeliveryPredict(rs.getString("orderInfoDeliveryPredict"));
		
		// DB사용이 끝났으므로 모든 커넥션을 순서대로 닫아준다
		rs.close();
		ps.close();
		c.close();
		
		return orderInfo; // 최종적으로 불러온 유저 정보에 관련한 객체를 리턴
	}
	
	public void deleteAll() throws ClassNotFoundException, SQLException { // DB에 저장된 데이터를 전부 삭제하는 메소드
		Connection c = connectionMaker.makeConnection();; // DB로의 커넥션 생성
		
		PreparedStatement ps = c.prepareStatement("truncate table orderinfo");
		// preparestatement메소드를 통해서 쿼리문을 날릴 준비를 함
		
		ps.executeUpdate(); // 쿼리문 실행
		
		// 커넥션 close
		ps.close();
		c.close();
	}
}