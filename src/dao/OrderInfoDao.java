package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import domain.OrderInfoDto;
import resources.ConnectionMaker;
import resources.ConnectionMakerKH;

public class OrderInfoDao {
	private ConnectionMaker connectionMaker;

	public OrderInfoDao() {
		connectionMaker = new ConnectionMakerKH();
	}

	public void add(OrderInfoDto orderInfoDto) throws ClassNotFoundException, SQLException { // 고객을

		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement(
				"insert into orderinfo values (seq_orderinfo_num.nextval,?,?,?,?,?,?,?,?,?,?,?,?)");


		ps.setString(1, orderInfoDto.getOrderInfoDate());
		ps.setString(2, orderInfoDto.getOrderInfoLocPossibility());
		ps.setString(3, orderInfoDto.getOrderInfoOrderPossibility());
		ps.setString(4, orderInfoDto.getOrderInfoRequestInfo());
		ps.setInt(5, orderInfoDto.getOrderInfoChannelNum());
		ps.setString(6, orderInfoDto.getOrderInfoRequestDelivery());
		ps.setString(7, orderInfoDto.getOrderInfoPackCompletion());
		ps.setString(8, orderInfoDto.getOrderInfoDeliveryCompletion());
		ps.setString(9, orderInfoDto.getOrderInfoOrderCompletion());
		ps.setString(10, orderInfoDto.getOrderInfoMoneyCollection());
		ps.setString(11, orderInfoDto.getOrderInfoDeliveryPredict());
		ps.setInt(12, orderInfoDto.getOrderInfoCustomerNum());

		ps.executeUpdate(); // 쿼리 날리기... executeUpdate를 사용한 이유는 insert into라는

		ps.close(); // 사용한 ps객체 닫기
		c.close(); // 사용한 c객체 닫기

	}
	
	public Vector orderInfoOneCustomer(int orderInfoCustomerNum) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		Vector data = new Vector();
		try{
			PreparedStatement ps = c.prepareStatement("select * from orderinfo where orderinfo_customer_num = ?");
			ps.setInt(1, orderInfoCustomerNum);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Vector row = new Vector();
				row.add(rs.getString("orderinfo_num"));
				row.add(rs.getString("orderinfo_date"));
				row.add(rs.getInt("orderinfo_customer_num"));
				row.add(rs.getInt("orderinfo_userinfo_num"));
				data.add(row); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
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


				Vector row = new Vector();
				row.add(orderInfoNum);
				row.add(orderInfoDate);


				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

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
				orderInfoDto.setOrderInfoLocPossibility(rs.getString("orderInfo_Loc_Possibility"));//주문가능여부(지역)
				orderInfoDto.setOrderInfoOrderPossibility(rs.getString("orderInfo_Order_Possibility"));//주문가능여부(주문량)
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
	}

	//수정 필요
	public int sumOrderMenu(int orderInfoNum) throws ClassNotFoundException, SQLException {

		Connection c = connectionMaker.makeConnection();
		//OrderInfoDto orderInfoDto = new OrderInfoDto();
		int sum = 0;
		try {
			PreparedStatement ps = c.prepareStatement(
					"select * from orderinfo where orderinfo_menu_num=?");
			ps.setInt(1, orderInfoNum);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//			orderInfoDto.setOrderInfoMenuNum(rs.getInt("orderInfoMenuNum"));// 메뉴고유값
				//		orderInfoDto.setOrderInfoMenuAmount(rs.getInt("orderInfoMenuAmount"));// 주문
				// 메뉴양
				sum += rs.getInt("orderinfo_menu_amount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sum;
	}

	public OrderInfoDto get(int orderInfoNum) throws ClassNotFoundException, SQLException { //

		Connection c = connectionMaker.makeConnection(); // DB로의 커넥션 객체 생성
		PreparedStatement ps = c.prepareStatement("select * from orderinfo order by orderinfo_Num asc");

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
		orderInfoDto.setOrderInfoLocPossibility(rs.getString("orderInfo_Loc_Possibility"));//주문가능여부(지역)
		orderInfoDto.setOrderInfoOrderPossibility(rs.getString("orderInfo_Order_Possibility"));//주문가능여부(주문량)
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

	// 주문 수정 메소드


	public boolean updateOrder(OrderInfoDto orderInfoDto){
		System.out.println("dto="+orderInfoDto.toString());
		boolean ok = false;
		try{
			Connection c = connectionMaker.makeConnection();          
			PreparedStatement ps = c.prepareStatement("update orderinfo set orderInfo_Date=?, orderInfo_Loc_Possibility=?, orderInfo_Order_Possibility=?, orderInfo_Request_Info=?,orderInfo_Channel_Num=?, orderInfo_Request_Delivery=?, orderInfo_Pack_Completion=?, orderInfo_Delivery_Completion=?, orderInfo_Order_Completion=?, orderInfo_Money_Collection=?, orderInfo_Delivery_Predict=?"+ "where orderInfo_Num=?");

			ps.setString(1, orderInfoDto.getOrderInfoDate());
			ps.setString(2, orderInfoDto.getOrderInfoLocPossibility());
			ps.setString(3, orderInfoDto.getOrderInfoOrderPossibility());
			ps.setString(4, orderInfoDto.getOrderInfoRequestInfo());
			ps.setInt(5, orderInfoDto.getOrderInfoChannelNum());
			ps.setString(6, orderInfoDto.getOrderInfoRequestDelivery());
			ps.setString(7, orderInfoDto.getOrderInfoPackCompletion());
			ps.setString(8, orderInfoDto.getOrderInfoDeliveryCompletion());
			ps.setString(9, orderInfoDto.getOrderInfoOrderCompletion());
			ps.setString(10, orderInfoDto.getOrderInfoMoneyCollection());
			ps.setString(11, orderInfoDto.getOrderInfoDeliveryPredict());
			ps.setInt(12, orderInfoDto.getOrderInfoCustomerNum());

			int r = ps.executeUpdate();

			if(r>0) ok = true;

		}catch(Exception e){
			e.printStackTrace();

		}

		return ok;
	}
	
	public Vector orderInfoAllPart() throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();
		OrderInfoDto orderInfoDto = new OrderInfoDto();
		Vector data = new Vector();
		try{
			PreparedStatement ps = c.prepareStatement("select * from orderinfo order by orderinfo_num"); // 
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Vector row = new Vector();
				row.add(rs.getString("orderinfo_num"));
				row.add(rs.getString("orderinfo_date"));
				row.add(rs.getInt("orderinfo_customer_num"));



				data.add(row); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public void deleteAll() throws ClassNotFoundException, SQLException { // DB에
		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("truncate table customer");

		ps.executeUpdate();

		ps.close();
		c.close();
	}


	//사용자정보 삭제 메소드
	public boolean deleteOrder(int orderInfoNum){

		boolean ok =false ;

		try {
			Connection c = connectionMaker.makeConnection();   
			PreparedStatement ps = c.prepareStatement("delete from orderinfo where orderInfo_Num = ?");
			ps.setInt(1, orderInfoNum);

			int r = ps.executeUpdate();
			if (r>0) ok=true;
			ps.close();
			c.close();
		} catch (Exception e) {
			System.out.println(e + "-> 오류발생");
		}      
		return ok;
	}


}