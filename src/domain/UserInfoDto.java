package domain;

public class UserInfoDto {

	//사용자정보 필요한 변수 지정
	private String userInfoName;
	private String userInfoId;
	private String userInfoPassword;

	public UserInfoDto() {}
	// 사용자정보객체를 만들때 필요한 매개변수를 받아서 초기화 시키는 생성자
	public UserInfoDto(String userInfoId, String userInfoPassword, String userInfoName) {
		this.userInfoId = userInfoId;
		this.userInfoPassword = userInfoPassword;
		this.userInfoName = userInfoName;
	}
	
	public String getUserInfoName() {
		return userInfoName;
	}
	public void setUserInfoName(String userInfoName) {
		this.userInfoName = userInfoName;
	}
	public String getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}
	public String getUserInfoPassword() {
		return userInfoPassword;
	}
	public void setUserInfoPassword(String userInfoPassword) {
		this.userInfoPassword = userInfoPassword;
	}
	

}
