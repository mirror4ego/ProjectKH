package service;

import java.sql.SQLException;

import dao.UserInfoDao;
import domain.UserInfoDto;

public class LoginSevice {
	public static boolean login(String id, String password) throws ClassNotFoundException, SQLException {
		boolean existUser = false;
		UserInfoDto userInfoDto = (new UserInfoDao()).get(id);
		String getPass = (userInfoDto.getUserInfoPassword()).trim();

		if(getPass.equals(password)){
			System.out.println("비번일치");
			existUser = true;
		}else{
			System.out.println("비번불일치");
			existUser = false;
		}
		System.out.println("로그인서비스끝");

		return existUser;
	}
}
