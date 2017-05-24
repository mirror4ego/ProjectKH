package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import domain.MenuGroupDto;
import resources.ConnectionMaker;
import resources.ConnectionMakerKH;

public class MenuGroupDao {
	ConnectionMaker connectionMaker;
	public MenuGroupDao() {
		connectionMaker = new ConnectionMakerKH();
	}
	
	public MenuGroupDto get(int menuGroupNum) throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("select * from menugroup where menugroup_num = ?");
		ps.setInt(1, menuGroupNum);

		ResultSet rs = ps.executeQuery();

		rs.next();
		MenuGroupDto menuGroupDto = new MenuGroupDto();
		menuGroupDto.setMenuGroupNum(rs.getInt("menugroup_num"));
		menuGroupDto.setMenuGroupName(rs.getString("menugroup_name"));

		rs.close();
		ps.close();
		c.close();

		return menuGroupDto;
	}
	
	public boolean searchMenuGroup(String searchItem) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		boolean searchResult = false;
		try{
			PreparedStatement ps = c.prepareStatement("select * from menugroup where menugroup_name = ?");

			ps.setString(1, searchItem);
			
			ResultSet rs = ps.executeQuery();

			searchResult = (rs.next());
			
			ps.executeUpdate();
			ps.close();
			c.close();
		}catch(Exception e){
			c.close();
			JOptionPane.showMessageDialog(null, "메뉴그룹 검색 오류");
		}
		return searchResult;
	}
	public Vector getAllMenuGroupName() throws ClassNotFoundException, SQLException {
		Vector vector1 = new Vector();
		Connection c = connectionMaker.makeConnection();
		try{
			PreparedStatement ps = c.prepareStatement("select * from menugroup order by menugroup_name");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				vector1.add(rs.getString("menugroup_name"));	
			}

			ps.executeUpdate();
			ps.close();
			c.close();
		}catch(Exception e){
			c.close();
			JOptionPane.showMessageDialog(null, "메뉴그룹 검색 오류");
		}
		
		return vector1;
	}
	
	
	//매개로 총 로우의 개수를 반환하는 메소드 필요
	//모든 그룹이름과 그룹넘버를 벡터로 반환하는 메소드 필요
	
	// 벡터의 0번째 항에 총 길이에 대한 정보를 넣음
	// 나머지 벡터의 공간에 실제 데이터 넣음
}
