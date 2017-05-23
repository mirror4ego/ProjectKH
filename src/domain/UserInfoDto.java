package domain;

public class UserInfoDto {

	private String userInfoId;
	private String userInfoPassword;
	private String userInfoName;
	private int userInfoNum;
	private String userInfoAddress;
	private int userInfoPhone;
	private String userInfoEmail;
	private String userInfoHireDate;

	public UserInfoDto() {}

	public UserInfoDto(String userInfoId, String userInfoPassword, String userInfoName, int userInfoNum, String userInfoAddress,
			int userInfoPhone, String userInfoEmail, String userInfoHireDate) {
		this.userInfoId = userInfoId;
		this.userInfoPassword = userInfoPassword;
		this.userInfoName = userInfoName;
		this.userInfoNum = userInfoNum;
		this.userInfoAddress = userInfoAddress;
		this.userInfoPhone = userInfoPhone;
		this.userInfoEmail = userInfoEmail;
		this.userInfoHireDate = userInfoHireDate;
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
	public String getUserInfoName() {
		return userInfoName;
	}
	public void setUserInfoName(String userInfoName) {
		this.userInfoName = userInfoName;
	}
	public int getUserInfoNum() {
		return userInfoNum;
	}
	public void setUserInfoNum(int userInfoNum) {
		this.userInfoNum = userInfoNum;
	}
	public String getUserInfoAddress() {
		return userInfoAddress;
	}
	public void setUserInfoAddress(String userInfoAddress) {
		this.userInfoAddress = userInfoAddress;
	}
	public int getUserInfoPhone() {
		return userInfoPhone;
	}
	public void setUserInfoPhone(int userInfoPhone) {
		this.userInfoPhone = userInfoPhone;
	}
	public String getUserInfoEmail() {
		return userInfoEmail;
	}
	public void setUserInfoEmail(String userInfoEmail) {
		this.userInfoEmail = userInfoEmail;
	}

	public String getUserInfoHireDate() {
		return userInfoHireDate;
	}

	public void setUserInfoHireDate(String userInfoHireDate) {
		this.userInfoHireDate = userInfoHireDate;
	}

	@Override
	public String toString() {
		return "UserInfoDto [userInfoId=" + userInfoId + ", userInfoPassword=" + userInfoPassword + ", userInfoName="
				+ userInfoName + ", userInfoNum=" + userInfoNum + ", userInfoAddress=" + userInfoAddress
				+ ", userInfoPhone=" + userInfoPhone + ", userInfoEmail=" + userInfoEmail + ", userInfoHireDate="
				+ userInfoHireDate + "]";
	}


}
