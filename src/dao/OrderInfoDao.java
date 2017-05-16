package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import domain.OrderInfoDto;
import domain.UserInfoDto;
import resources.ConnectionMaker;
import resources.ConnectionMakerKH;

public class OrderInfoDao {
	private ConnectionMaker connectionMaker;

	public OrderInfoDao() {
		connectionMaker = new ConnectionMakerKH();
	}

	public void add(OrderInfoDto orderInfoDto) throws ClassNotFoundException, SQLException { // 고객을
																								// 추가하는
																								// 메소드,
																								// 매개변수는
																								// Customer클래스의
																								// 객체
		Connection c = connectionMaker.makeConnection(); // data소스에 저장된 커넥션 정보를
															// c에 저장

		PreparedStatement ps = c.prepareStatement(
				"insert into orderinfo values (seq_orderinfo_num.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		// PreparedStatement ps = c.prepareStatement("insert into
		// customer(customer_Num, customer_Reg_Date, customer_Phone_Num,
		// customer_Add_State, customer_Add_City, customer_Add_Street,
		// customer_Add_Rest, customer_Frequent, customer_Age_Predict)
		// values(?,?,?,?,?,?,?,?,?)");
		// c 객체의 메소드인 prepareaStatement를 이용해서 db에 쿼리를 날림
		// 각 칼럼값에 집어넣을 low값을 ?로 설정

		// 각 물음표 값에 들어갈 값을 지정하고 set
		// ps.setInt(1, orderInfo.getOrderInfoNum());

		ps.setString(1, orderInfoDto.getOrderInfoDate());
		ps.setString(2, orderInfoDto.getOrderInfoLocPossiblity());
		ps.setString(3, orderInfoDto.getOrderInfoOrderPossiblity());
		ps.setInt(4, orderInfoDto.getOrderInfoMenuNum());
		ps.setInt(5, orderInfoDto.getOrderInfoMenuAmount());
		ps.setString(6, orderInfoDto.getOrderInfoRequestInfo());
		ps.setInt(7, orderInfoDto.getOrderInfoChannelNum());
		ps.setString(8, orderInfoDto.getOrderInfoRequestDelivery());
		ps.setString(9, orderInfoDto.getOrderInfoPackCompletion());
		ps.setString(10, orderInfoDto.getOrderInfoDeliveryCompletion());
		ps.setString(11, orderInfoDto.getOrderInfoOrderCompletion());
		ps.setString(12, orderInfoDto.getOrderInfoMoneyCollection());
		ps.setString(13, orderInfoDto.getOrderInfoDeliveryPredict());
		ps.setInt(14, orderInfoDto.getOrderInfoCustomerNum());

		ps.executeUpdate(); // 쿼리 날리기... executeUpdate를 사용한 이유는 insert into라는
							// sql문은
		// 결과값을 받아올 필요가 없기 때문이다. 쿼리문을 날리고 결과 값을 받아올 필요가 있을때는(ex : select문)
		// executeQuery 메소드를 사용해야 한다.

		ps.close(); // 사용한 ps객체 닫기
		c.close(); // 사용한 c객체 닫기
		// 공유 자원이기 때문에 닫아주지않으면 연결 세션을 계속 점유 하고 있게 된다.
	}

	// 모든 주문내역 리스트를 가져오는 메소드
	public Vector getOrderList() throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		Vector data = new Vector();

		try {
			PreparedStatement ps = c.prepareStatement("select * from orderinfo order by orderInfo_Num asc");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int orderInfoNum = rs.getInt("orderInfo_Num"); // 주문번호
				String orderInfoDate = rs.getString("orderInfo_Date");// 주문일자
				int orderInfoMenuNum = rs.getInt("orderInfo_Menu_Num");// 메뉴고유값
				int orderInfoMenuAmount = rs.getInt("orderInfo_Menu_Amount");// 주문메뉴양

				Vector row = new Vector();
				row.add(orderInfoNum);
				row.add(orderInfoDate);
				row.add(orderInfoMenuNum);
				row.add(orderInfoMenuAmount);

				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

<<<<<<< HEAD
	// 선택한 주문내역 정보를 가져오는 메소드 (주문번호를 기준으로)
	public OrderInfoDto getOneOrder(int orderInfoNum) throws ClassNotFoundException, SQLException {

		Connection c = connectionMaker.makeConnection();
		OrderInfoDto orderInfoDto = new OrderInfoDto();

		try {
			PreparedStatement ps = c.prepareStatement("select * from orderinfo where orderInfoNum=?");
			ps.setInt(1, orderInfoNum);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				orderInfoDto.setOrderInfoNum(rs.getInt("orderInfoNum")); // 주문번호
				orderInfoDto.setOrderInfoDate(rs.getString("orderInfoDate"));// 주문일자
				orderInfoDto.setOrderInfoLocPossiblity(rs.getString("orderInfoLocPossiblity"));// 주문가능여부(지역)
				orderInfoDto.setOrderInfoOrderPossiblity(rs.getString("orderInfoOrderPossiblity"));// 주문가능여부(주문량)
				orderInfoDto.setOrderInfoMenuNum(rs.getInt("orderInfoMenuNum"));// 메뉴고유값
				orderInfoDto.setOrderInfoMenuAmount(rs.getInt("orderInfoMenuAmount"));// 주문
																						// 메뉴양
				orderInfoDto.setOrderInfoRequestInfo(rs.getString("orderInfoRequestInfo"));// 주문요청사항
				orderInfoDto.setOrderInfoChannelNum(rs.getInt("orderInfoChannelNum"));// 채널고유값
				orderInfoDto.setOrderInfoRequestDelivery(rs.getString("orderInfoRequestDelivery"));// 배달요청시간
				orderInfoDto.setOrderInfoPackCompletion(rs.getString("orderInfoPackCompletion"));// 주문
																									// 프로세스(포장)완료여부
				orderInfoDto.setOrderInfoDeliveryCompletion(rs.getString("orderInfoDeliveryCompletion"));// 주문
																											// 프로세스(배달)완료여부
				orderInfoDto.setOrderInfoOrderCompletion(rs.getString("orderInfoOrderCompletion"));// 주문
																									// 프로세스완료여부
				orderInfoDto.setOrderInfoMoneyCollection(rs.getString("orderInfoMoneyCollection"));// 수금여부
				orderInfoDto.setOrderInfoDeliveryPredict(rs.getString("orderInfoDeliveryPredict"));// 배달예측시간

			}
		} catch (Exception e) {
			e.printStackTrace();
=======
		//선택한 주문내역 정보를 가져오는 메소드 (주문번호를 기준으로)
		public OrderInfoDto getOneOrder(int orderInfoNum) throws ClassNotFoundException, SQLException{

			Connection c = connectionMaker.makeConnection();
			OrderInfoDto orderInfoDto = new OrderInfoDto();

			try{
				PreparedStatement ps = c.prepareStatement("select * from orderinfo where orderinfo_Num=?");
				ps.setInt(1, orderInfoNum);
				ResultSet rs = ps.executeQuery();

				if(rs.next()){
					
					orderInfoDto.setOrderInfoNum(rs.getInt("orderInfo_Num"));  //주문번호
					orderInfoDto.setOrderInfoDate(rs.getString("orderInfo_Date"));//주문일자
					orderInfoDto.setOrderInfoLocPossiblity(rs.getString("orderInfo_Loc_Possiblity"));//주문가능여부(지역)
					orderInfoDto.setOrderInfoOrderPossiblity(rs.getString("orderInfo_Order_Possiblity"));//주문가능여부(주문량)
					orderInfoDto.setOrderInfoMenuNum(rs.getInt("orderInfo_Menu_Num"));//메뉴고유값
					orderInfoDto.setOrderInfoMenuAmount(rs.getInt("orderInfo_Menu_Amount"));//주문 메뉴양
					orderInfoDto.setOrderInfoRequestInfo(rs.getString("orderInfo_Request_Info"));//주문요청사항
					orderInfoDto.setOrderInfoChannelNum(rs.getInt("orderInfo_Channel_Num"));//채널고유값
					orderInfoDto.setOrderInfoRequestDelivery(rs.getString("orderInfo_Request_Delivery"));//배달요청시간
					orderInfoDto.setOrderInfoPackCompletion(rs.getString("orderInfo_Pack_Completion"));//주문 프로세스(포장)완료여부
					orderInfoDto.setOrderInfoDeliveryCompletion(rs.getString("orderInfo_Delivery_Completion"));//주문 프로세스(배달)완료여부
					orderInfoDto.setOrderInfoOrderCompletion(rs.getString("orderInfo_Order_Completion"));//주문 프로세스완료여부
					orderInfoDto.setOrderInfoMoneyCollection(rs.getString("orderInfo_Money_Collection"));//수금여부
					orderInfoDto.setOrderInfoDeliveryPredict(rs.getString("orderInfo_Delivery_Predict"));//배달예측시간
					orderInfoDto.setOrderInfoCustomerNum(rs.getInt("orderInfo_Customer_Num"));//고객번호
				}
			} catch (Exception e) {
				e.printStackTrace();
			}      

			return orderInfoDto;    
>>>>>>> dd3f7aac5dba0b9b6e75c8d44d383c921c853d39
		}

		return orderInfoDto;
	}

	public int sumOrderMenu(int orderInfoNum) throws ClassNotFoundException, SQLException {

		Connection c = connectionMaker.makeConnection();
		//OrderInfoDto orderInfoDto = new OrderInfoDto();
		int sum = 0;
		try {
			PreparedStatement ps = c.prepareStatement(
					"select * from orderinfo where orderInfoMenuNum=?");
			ps.setInt(1, orderInfoNum);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
	//			orderInfoDto.setOrderInfoMenuNum(rs.getInt("orderInfoMenuNum"));// 메뉴고유값
		//		orderInfoDto.setOrderInfoMenuAmount(rs.getInt("orderInfoMenuAmount"));// 주문
																						// 메뉴양
				sum += rs.getInt("orderInfoMenuAmount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sum;
	}

	public OrderInfoDto get(int orderInfoNum) throws ClassNotFoundException, SQLException { //

		Connection c = connectionMaker.makeConnection(); // DB로의 커넥션 객체 생성

		PreparedStatement ps = c.prepareStatement("select * from customer where customerNum = ?");
		// preparestatement메소드를 통해서 쿼리문을 날릴 준비를 함
		ps.setInt(1, orderInfoNum);
		// ? 에 매개변수로 받아온 id를 입력해서 쿼리문 완성

		ResultSet rs = ps.executeQuery();
		// 쿼리문을 실행 executeQuery를 통해서 쿼리를 실행한 결과 값을 받아와서 ResultSet의 객체참조주소 rs에 저장
		rs.next(); // 쿼리문을 통해 받아온 값은 start를 가르키는 위치가 있기 때문에 진짜 값이 시작되는 곳을 찾으려면 이
					// 메소드를 꼭 한번 실행해야 한다
		OrderInfoDto orderInfoDto = new OrderInfoDto(); // 고객정보 클래스의 객체를 생성

		
		orderInfoDto.setOrderInfoNum(rs.getInt("orderInfo_Num"));  //주문번호
		orderInfoDto.setOrderInfoDate(rs.getString("orderInfo_Date"));//주문일자
		orderInfoDto.setOrderInfoLocPossiblity(rs.getString("orderInfo_Loc_Possiblity"));//주문가능여부(지역)
		orderInfoDto.setOrderInfoOrderPossiblity(rs.getString("orderInfo_Order_Possiblity"));//주문가능여부(주문량)
		orderInfoDto.setOrderInfoMenuNum(rs.getInt("orderInfo_Menu_Num"));//메뉴고유값
		orderInfoDto.setOrderInfoMenuAmount(rs.getInt("orderInfo_Menu_Amount"));//주문 메뉴양
		orderInfoDto.setOrderInfoRequestInfo(rs.getString("orderInfo_Request_Info"));//주문요청사항
		orderInfoDto.setOrderInfoChannelNum(rs.getInt("orderInfo_Channel_Num"));//채널고유값
		orderInfoDto.setOrderInfoRequestDelivery(rs.getString("orderInfo_Request_Delivery"));//배달요청시간
		orderInfoDto.setOrderInfoPackCompletion(rs.getString("orderInfo_Pack_Completion"));//주문 프로세스(포장)완료여부
		orderInfoDto.setOrderInfoDeliveryCompletion(rs.getString("orderInfo_Delivery_Completion"));//주문 프로세스(배달)완료여부
		orderInfoDto.setOrderInfoOrderCompletion(rs.getString("orderInfo_Order_Completion"));//주문 프로세스완료여부
		orderInfoDto.setOrderInfoMoneyCollection(rs.getString("orderInfo_Money_Collection"));//수금여부
		orderInfoDto.setOrderInfoDeliveryPredict(rs.getString("orderInfo_Delivery_Predict"));//배달예측시간
		orderInfoDto.setOrderInfoCustomerNum(rs.getInt("orderInfo_Customer_Num"));//고객번호


		// DB사용이 끝났으므로 모든 커넥션을 순서대로 닫아준다
		rs.close();
		ps.close();
		c.close();

		return orderInfoDto; // 최종적으로 불러온 유저 정보에 관련한 객체를 리턴
	}

	public void deleteAll() throws ClassNotFoundException, SQLException { // DB에
																			// 저장된
																			// 데이터를
																			// 전부
																			// 삭제하는
																			// 메소드
		Connection c = connectionMaker.makeConnection();
		; // DB로의 커넥션 생성

		PreparedStatement ps = c.prepareStatement("truncate table orderinfo");
		// preparestatement메소드를 통해서 쿼리문을 날릴 준비를 함

		ps.executeUpdate(); // 쿼리문 실행

		// 커넥션 close
		ps.close();
		c.close();
	}
}