package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import domain.OrderInfoDto;
import domain.OrderItemDto;
import resources.ConnectionMaker;
import resources.ConnectionMakerKH;

public class OrderItemDao {
	ConnectionMaker connectionMaker = new ConnectionMakerKH();
	public OrderItemDao() {
		connectionMaker = new ConnectionMakerKH();
	}
	
	
	public Vector getSelectedOrderItem(int orderItemOrderInfoNum) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		Vector data = new Vector();

		try {
			PreparedStatement ps = c.prepareStatement("select * from orderitem where orderitem_orderinfo_num = ?");
			ps.setInt(1, orderItemOrderInfoNum);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt("orderItem_Num"));
				row.add(rs.getInt("orderItem_OrderInfo_Num"));
				row.add(rs.getString("orderItem_Menu_Name"));
				row.add(rs.getInt("orderItem_Quantity"));
				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public void addOneOrderItem(OrderItemDto orderItemDto) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		System.out.println("정상입력1");
		PreparedStatement ps = c.prepareStatement(
				"insert into orderitem values (seq_orderitem_num.nextval, ?, ?, ?)");
		//to_date(?,'yyyy-mm-dd hh24:mi:ss')
		System.out.println("정상입력2");
		ps.setInt(1, orderItemDto.getOrderItemOrderInfoNum());
		ps.setString(2, orderItemDto.getOrderItemMenuName());
		ps.setInt(3, orderItemDto.getOrderItemQuantity());
		System.out.println("정상입력3");
		ps.executeUpdate();
		System.out.println("정상입력4");
		ps.close();
		c.close();
	}

	
	public void addOrderSheet(OrderInfoDto orderInfoDto) throws ClassNotFoundException, SQLException { // 고객을

		Connection c = connectionMaker.makeConnection();

			System.out.println("정상입력1");
			PreparedStatement ps = c.prepareStatement(
					"insert into orderinfo values (seq_orderinfo_num.nextval, to_date(?,'yyyy-mm-dd hh24:mi:ss'), ?, ?, ?, ?, to_date(?,'yyyy-mm-dd hh24:mi:ss'), ?, ?, ?, ?, to_date(?,'yyyy-mm-dd hh24:mi:ss'), ?, ?)");
			//to_date(?,'yyyy-mm-dd hh24:mi:ss')
			System.out.println("정상입력2");
			ps.setString(1, orderInfoDto.getOrderInfoDate());
			ps.setString(2, orderInfoDto.getOrderInfoLocPossibility());
			ps.setString(3, orderInfoDto.getOrderInfoOrderPossibility());
			ps.setString(4, orderInfoDto.getOrderInfoRequestInfo());
			ps.setString(5, orderInfoDto.getOrderInfoChannelName());
			ps.setString(6, orderInfoDto.getOrderInfoRequestDelivery());
			ps.setString(7, orderInfoDto.getOrderInfoPackCompletion());
			ps.setString(8, orderInfoDto.getOrderInfoDeliveryCompletion());
			ps.setString(9, orderInfoDto.getOrderInfoOrderCompletion());
			ps.setString(10, orderInfoDto.getOrderInfoMoneyCollection());
			ps.setString(11, orderInfoDto.getOrderInfoDeliveryPredict());
			ps.setInt(12, orderInfoDto.getOrderInfoCustomerNum());
			ps.setInt(13, orderInfoDto.getOrderInfoUserInfoNum());
			System.out.println("정상입력3");
			ps.executeUpdate();
			System.out.println("정상입력4");
			ps.close();
			c.close();

	}
	
}

