package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.CustomerDto;
import domain.MenuDto;
import resources.ConnectionMaker;
import resources.ConnectionMakerKH;

public class MenuDao {
	ConnectionMaker connectionMaker;
	public MenuDao() {
		connectionMaker = new ConnectionMakerKH();
	}
	
	public MenuDto get(int menuNum) throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("select * from menu where menu_num = ?");
		ps.setInt(1, menuNum);

		ResultSet rs = ps.executeQuery();

		rs.next();
		MenuDto menuDto = new MenuDto();
		menuDto.setMenuNum(rs.getInt("menu_num"));
		menuDto.setMenuName(rs.getString("menu_name"));
		menuDto.setMenuPrice(rs.getInt("menu_price"));
		menuDto.setMenuGroupNum(rs.getInt("menugroup_num"));

		rs.close();
		ps.close();
		c.close();

		return menuDto;
	}
	
	
	
}
