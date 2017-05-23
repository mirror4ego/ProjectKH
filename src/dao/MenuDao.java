package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import domain.MenuDto;
import resources.ConnectionMaker;
import resources.ConnectionMakerKH;

public class MenuDao {
	ConnectionMaker connectionMaker;
	public MenuDao() {
		connectionMaker = new ConnectionMakerKH();
	}

	public MenuDto get(MenuDto menuDto) throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("select * from menu where menu_name = ?");
		ps.setString(1, menuDto.getMenuName());

		ResultSet rs = ps.executeQuery();

		rs.next();
		menuDto.setMenuName(rs.getString("menu_name"));
		menuDto.setMenuPrice(rs.getInt("menu_price"));
		menuDto.setMenuGroupName(rs.getString("menugroup_name"));

		rs.close();
		ps.close();
		c.close();

		return menuDto;
	}

	public void deleteOneMenu(String menuName) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		try{
			PreparedStatement ps = c.prepareStatement("delete from menu where menu_name = ?");
			ps.setString(1, menuName);
			ps.executeUpdate();
			ps.close();
			c.close();
			JOptionPane.showMessageDialog(null, "메뉴정보 삭제 성공!");
		}catch(Exception e){
			c.close();
			JOptionPane.showMessageDialog(null, "메뉴정보 삭제 실패!");
		}
	}

	public void insertMenu(MenuDto menuDto) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		try{
			System.out.println("1");
			PreparedStatement ps = c.prepareStatement("insert into menu values (?, ?, ?)");
			//ps.setInt(1, menuDto.getMenuNum());
			ps.setString(1, menuDto.getMenuName());
			ps.setInt(2, menuDto.getMenuPrice());
			ps.setString(3, menuDto.getMenuGroupName());
			ps.executeUpdate();
			System.out.println("2");
			ps.close();
			System.out.println("3");
			c.close();
			JOptionPane.showMessageDialog(null, "새메뉴 입력 성공!");
		}catch(Exception e){
			c.close();
			JOptionPane.showMessageDialog(null, "새메뉴 입력 실패!");
		}
	}

	public void updateMenu(MenuDto menuDto) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();

		try{

			PreparedStatement ps = c.prepareStatement("update menu set Menu_Price = ?, MenuGroup_Name = ? where Menu_name = ?");

			ps.setInt(1, menuDto.getMenuPrice());
			ps.setString(2, menuDto.getMenuGroupName());
			ps.setString(3, menuDto.getMenuName());
			
			ps.executeUpdate();
			ps.close();
			c.close();
			JOptionPane.showMessageDialog(null, "메뉴정보 변경 성공!");
		}catch(Exception e){
			c.close();
			JOptionPane.showMessageDialog(null, "메뉴정보 변경 실패!");
		}
	}
	
	public boolean searchMenu(String searchItem) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		boolean searchResult = false;
		try{
			PreparedStatement ps = c.prepareStatement("select * from menu where menu_name = ?");

			ps.setString(1, searchItem);
			System.out.println(searchItem);
			ResultSet rs = ps.executeQuery();
			searchResult = (rs.next());
			System.out.println(searchResult);
			ps.executeUpdate();
			ps.close();
			c.close();
		}catch(Exception e){
			c.close();
			JOptionPane.showMessageDialog(null, "메뉴 검색 오류");
		}
		return searchResult;
	}

	
}
