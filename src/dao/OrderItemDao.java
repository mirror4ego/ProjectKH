package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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

	
}

