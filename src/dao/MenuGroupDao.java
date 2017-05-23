package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	//매개로 총 로우의 개수를 반환하는 메소드 필요
	//모든 그룹이름과 그룹넘버를 벡터로 반환하는 메소드 필요
	
	// 벡터의 0번째 항에 총 길이에 대한 정보를 넣음
	// 나머지 벡터의 공간에 실제 데이터 넣음
}
