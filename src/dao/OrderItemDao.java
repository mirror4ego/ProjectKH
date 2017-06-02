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


	public Vector getSelectedOrderItemPlus(int orderItemOrderInfoNum) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		Vector data = new Vector();

		try {
			PreparedStatement ps = c.prepareStatement("select * from orderitem a inner join menu b on a.orderitem_menu_name=b.menu_name where orderitem_orderinfo_num = ?");
			ps.setInt(1, orderItemOrderInfoNum);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt("orderItem_Num"));
				row.add(rs.getInt("orderItem_OrderInfo_Num"));
				row.add(rs.getString("orderItem_Menu_Name"));
				row.add(rs.getInt("orderItem_Quantity"));
				row.add(rs.getInt("menu_price"));
				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public Vector getBestSellingItem(int customerNum) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		Vector data = new Vector();

		try {
			PreparedStatement ps = c.prepareStatement("select orderitem_menu_name, sum(orderitem_quantity) as total "
					+ "from orderitem a inner join orderinfo b "
					+ "on a.orderitem_orderinfo_num = b.orderinfo_num "
					+ "inner join customer c "
					+ "on b.orderinfo_customer_num = c.customer_num "
					+ "where c.customer_num = ? group by orderitem_menu_name order by total desc");
			ps.setInt(1, customerNum);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("orderItem_Menu_Name"));
				row.add(rs.getInt("total"));
				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public int getBestSellingItemSum(int customerNum) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		Vector data = new Vector();
		int sumOrder = 0;
		try {
			PreparedStatement ps = c.prepareStatement("select menu_price, sum(orderitem_quantity) as total "
					+ "from orderitem a inner join orderinfo b "
					+ "on a.orderitem_orderinfo_num = b.orderinfo_num "
					+ "inner join customer c "
					+ "on b.orderinfo_customer_num = c.customer_num "
					+ "inner join menu d "
					+ "on d.menu_name = orderitem_menu_name "
					+ "where c.customer_num = ? group by menu_price order by total desc");
			ps.setInt(1, customerNum);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				//rs.getInt("menu_price");
				//rs.getInt("total");
				sumOrder=sumOrder + (Integer.parseInt(String.valueOf(rs.getInt("menu_price")))*Integer.parseInt(String.valueOf(rs.getInt("total"))));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sumOrder;
	}

	public Vector getSellingItemDateM(int customerNum) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		Vector data = new Vector();

		try {
			PreparedStatement ps = c.prepareStatement("select orderitem_menu_name, sum(orderitem_quantity) as total "
					+ "from orderitem a inner join orderinfo b "
					+ "on a.orderitem_orderinfo_num = b.orderinfo_num "
					+ "inner join customer c "
					+ "on b.orderinfo_customer_num = c.customer_num "
					+ "where c.customer_num = ? and (select to_date(to_char(sysdate, 'yyyymmdd')) - to_date(to_char(b.orderinfo_date, 'yyyymmdd')) from dual)<=30 "
					+ "group by orderitem_menu_name order by total desc");
			ps.setInt(1, customerNum);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("orderItem_Menu_Name"));
				row.add(rs.getInt("total"));
				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public Vector getSellingItemDate3D(int customerNum) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		Vector data = new Vector();

		try {
			PreparedStatement ps = c.prepareStatement("select orderitem_menu_name, sum(orderitem_quantity) as total "
					+ "from orderitem a inner join orderinfo b "
					+ "on a.orderitem_orderinfo_num = b.orderinfo_num "
					+ "inner join customer c "
					+ "on b.orderinfo_customer_num = c.customer_num "
					+ "where c.customer_num = ? and (select to_date(to_char(sysdate, 'yyyymmdd')) - to_date(to_char(b.orderinfo_date, 'yyyymmdd')) from dual)<=3 "
					+ "group by orderitem_menu_name order by total desc");
			ps.setInt(1, customerNum);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("orderItem_Menu_Name"));
				row.add(rs.getInt("total"));
				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
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

	//수정 필요
	public int sumOrderItemNum(String orderInfoName) throws ClassNotFoundException, SQLException {

		Connection c = connectionMaker.makeConnection();
		//OrderInfoDto orderInfoDto = new OrderInfoDto();
		int sum = 0;

		PreparedStatement ps = c.prepareStatement("select * from orderitem where orderitem_menu_Name=?", ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ps.setString(1, orderInfoName);
		ResultSet rs = ps.executeQuery();
		rs.last();
		sum=rs.getRow();
		rs.beforeFirst();

		return sum;
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
		ps.setString(13, orderInfoDto.getOrderInfoUserInfoId());
		System.out.println("정상입력3");
		ps.executeUpdate();
		System.out.println("정상입력4");
		ps.close();
		c.close();

	}

	// orderinfo_num를 파라미터로 받아  관련된 OrderItem 모든 항목을 지우는 메소드
	public void deleteOrderItem(int orderInfoNum) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement("delete orderitem where orderitem_orderinfo_num = ?");
		ps.setInt(1, orderInfoNum);
		ps.executeUpdate();
		ps.close();
		c.close();
	}

}

