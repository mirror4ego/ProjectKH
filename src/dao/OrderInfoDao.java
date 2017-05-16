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

	// 주문정보를 추가하는 메소드, 매개변수는  OrderInfoDto클래스의 객체
	public void add(OrderInfoDto orderInfoDto) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("insert into orderinfo values (seq_orderinfo_num.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		ps.setString(1, orderInfoDto.getOrderInfoDate());
		ps.setString(2, orderInfoDto.getOrderInfoLocPossibility());
		ps.setString(3, orderInfoDto.getOrderInfoOrderPossibility());
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

		ps.executeUpdate();

		ps.close(); // 사용한 ps객체 종료
		c.close(); // 사용한 c객체 종료
	}

	//모든 주문내역 리스트를 가져오는 메소드
	public Vector getOrderList() throws ClassNotFoundException, SQLException{
		Connection c = connectionMaker.makeConnection();
		Vector data = new Vector();

		try{
			PreparedStatement ps = c.prepareStatement("select * from orderinfo order by orderinfo_Num asc");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){	
				int orderInfoNum = rs.getInt("orderInfo_Num"); // 주문번호
				String orderInfoDate = rs.getString("orderInfo_Date"); // 주문일자
				int orderInfoMenuNum = rs.getInt("orderInfo_Menu_Num"); // 메뉴고유값
				int orderInfoMenuAmount = rs.getInt("orderInfo_Menu_Amount");// 주문메뉴양

				Vector row = new Vector();
				row.add(orderInfoNum);
				row.add(orderInfoDate);
				row.add(orderInfoMenuNum);
				row.add(orderInfoMenuAmount);

				data.add(row);             
			}
		}catch(Exception e){
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
				orderInfoDto.setOrderInfoNum(rs.getInt("orderInfo_Num"));  // 주문번호
				orderInfoDto.setOrderInfoDate(rs.getString("orderInfo_Date")); // 주문일자
				orderInfoDto.setOrderInfoLocPossibility(rs.getString("orderInfo_Loc_Possibility")); // 주문가능여부(지역)
				orderInfoDto.setOrderInfoOrderPossibility(rs.getString("orderInfo_Order_Possibility")); // 주문가능여부(주문량)
				orderInfoDto.setOrderInfoMenuNum(rs.getInt("orderInfo_Menu_Num")); // 메뉴고유값
				orderInfoDto.setOrderInfoMenuAmount(rs.getInt("orderInfo_Menu_Amount")); // 주문 메뉴양
				orderInfoDto.setOrderInfoRequestInfo(rs.getString("orderInfo_Request_Info")); // 주문요청사항
				orderInfoDto.setOrderInfoChannelNum(rs.getInt("orderInfo_Channel_Num")); // 채널고유값
				orderInfoDto.setOrderInfoRequestDelivery(rs.getString("orderInfo_Request_Delivery")); // 배달요청시간
				orderInfoDto.setOrderInfoPackCompletion(rs.getString("orderInfo_Pack_Completion")); // 주문 프로세스(포장)완료여부
				orderInfoDto.setOrderInfoDeliveryCompletion(rs.getString("orderInfo_Delivery_Completion")); // 주문 프로세스(배달)완료여부
				orderInfoDto.setOrderInfoOrderCompletion(rs.getString("orderInfo_Order_Completion")); // 주문 프로세스완료여부
				orderInfoDto.setOrderInfoMoneyCollection(rs.getString("orderInfo_Money_Collection")); // 수금여부
				orderInfoDto.setOrderInfoDeliveryPredict(rs.getString("orderInfo_Delivery_Predict")); // 배달예측시간
				orderInfoDto.setOrderInfoCustomerNum(rs.getInt("orderInfo_Customer_Num")); // 고객번호
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInfoDto;    
	}

	//주문내역을 전부 가져오는 메소드
	public OrderInfoDto get(int orderInfoNum) throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();
		OrderInfoDto orderInfoDto = new OrderInfoDto(); // 주문정보 DTO 클래스의 객체를 생성
		
		try{
			PreparedStatement ps = c.prepareStatement("select * from orderinfo where orderinfo_Num=?");
			ps.setInt(1, orderInfoNum);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				orderInfoDto.setOrderInfoNum(rs.getInt("orderInfo_Num"));  // 주문번호
				orderInfoDto.setOrderInfoDate(rs.getString("orderInfo_Date")); // 주문일자
				orderInfoDto.setOrderInfoLocPossibility(rs.getString("orderInfo_Loc_Possibility")); // 주문가능여부(지역)
				orderInfoDto.setOrderInfoOrderPossibility(rs.getString("orderInfo_Order_Possibility")); // 주문가능여부(주문량)
				orderInfoDto.setOrderInfoMenuNum(rs.getInt("orderInfo_Menu_Num")); // 메뉴고유값
				orderInfoDto.setOrderInfoMenuAmount(rs.getInt("orderInfo_Menu_Amount")); // 주문 메뉴양
				orderInfoDto.setOrderInfoRequestInfo(rs.getString("orderInfo_Request_Info")); // 주문요청사항
				orderInfoDto.setOrderInfoChannelNum(rs.getInt("orderInfo_Channel_Num")); // 채널고유값
				orderInfoDto.setOrderInfoRequestDelivery(rs.getString("orderInfo_Request_Delivery")); // 배달요청시간
				orderInfoDto.setOrderInfoPackCompletion(rs.getString("orderInfo_Pack_Completion")); // 주문 프로세스(포장)완료여부
				orderInfoDto.setOrderInfoDeliveryCompletion(rs.getString("orderInfo_Delivery_Completion")); // 주문 프로세스(배달)완료여부
				orderInfoDto.setOrderInfoOrderCompletion(rs.getString("orderInfo_Order_Completion")); // 주문 프로세스완료여부
				orderInfoDto.setOrderInfoMoneyCollection(rs.getString("orderInfo_Money_Collection")); // 수금여부
				orderInfoDto.setOrderInfoDeliveryPredict(rs.getString("orderInfo_Delivery_Predict")); // 배달예측시간
				orderInfoDto.setOrderInfoCustomerNum(rs.getInt("orderInfo_Customer_Num")); // 고객번호
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.close();

		return orderInfoDto;
	}

	// 주문 내역을 수정하는 메소드
	public boolean updateOrder(OrderInfoDto orderInfoDto){
		System.out.println("dto="+orderInfoDto.toString());
		boolean ok = false;
		try{
			Connection c = connectionMaker.makeConnection();          
			PreparedStatement ps = c.prepareStatement("update tb_order set orderInfoDate=?, orderInfoLocPossibility=?, "
					+ "orderInfoOrderPossibility=?, orderInfoMenuNum=?, orderInfoMenuAmount=?, orderInfoRequestInfo=?, "
					+ "orderInfoChannelNum=?, orderInfoRequestDelivery=?, orderInfoPackCompletion=?, orderInfoDeliveryCompletion=?, "
					+ "orderInfoOrderCompletion=?, orderInfoMoneyCollection=?, orderInfoDeliveryPredict=?"+ "where orderInfoNum=?");

			ps.setString(1, orderInfoDto.getOrderInfoDate());
			ps.setString(2, orderInfoDto.getOrderInfoLocPossibility());
			ps.setString(3, orderInfoDto.getOrderInfoOrderPossibility());
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

			int r = ps.executeUpdate();
			if(r>0) ok = true;

		}catch(Exception e){
			e.printStackTrace();
		}
		return ok;
	}

	// 주문정보 삭제 메소드
	public boolean deleteOrder(int orderInfoNum){
		boolean ok =false ;

		try {
			Connection c = connectionMaker.makeConnection();   
			PreparedStatement ps = c.prepareStatement("delete from orderinfo where orderinfo_num = ?");
			ps.setInt(1, orderInfoNum);

			int r = ps.executeUpdate();
			if (r>0) ok=true;

		} catch (Exception e) {
			System.out.println(e + "-> 오류발생");
		}      
		return ok;
	}
}