package domain;

public class UserInfoDto {

	private String userInfoId;
	private String userInfoPassword;
	private String userInfoName;
	private int userInfoNum;
	private String userInfotask;
	private int userInfoPhone;
	private String userInfoEmail;
	private String userInfoHireDate;
	private String userInfogoto;
	private String userInfoleave;
	private String userInfoemploystatus;
	private String empadd;
	private String empadd1;
	private String empadd2;
	private String empadd3;
	private String userInfoGender;
	
	
	public UserInfoDto() {}

	public UserInfoDto(String userInfoId, String userInfoPassword, String userInfoName, int userInfoNum, String userInfoAddress,
			int userInfoPhone, String userInfoEmail, String userInfoHireDate) {
		this.userInfoId = userInfoId;
		this.userInfoPassword = userInfoPassword;
		this.userInfoName = userInfoName;
		this.userInfoNum = userInfoNum;
		this.userInfotask = userInfotask;
		this.userInfoPhone = userInfoPhone;
		this.userInfoEmail = userInfoEmail;
		this.userInfoHireDate = userInfoHireDate;
		this.userInfogoto = userInfogoto;
		this.userInfoleave = userInfoleave;
		this.userInfoemploystatus = userInfoemploystatus;
		this.empadd = empadd;
		this.empadd1 = empadd1;
		this.empadd2 = empadd2;
		this.empadd3 = empadd3;
		this.userInfoGender = userInfoGender;
		
	}

	
	public String getUserInfotask() {
		return userInfotask;
	}

	public void setUserInfotask(String userInfotask) {
		this.userInfotask = userInfotask;
	}

	public String getUserInfogoto() {
		return userInfogoto;
	}

	public void setUserInfogoto(String userInfogoto) {
		this.userInfogoto = userInfogoto;
	}

	public String getUserInfoleave() {
		return userInfoleave;
	}

	public void setUserInfoleave(String userInfoleave) {
		this.userInfoleave = userInfoleave;
	}

	public String getUserInfoemploystatus() {
		return userInfoemploystatus;
	}

	public void setUserInfoemploystatus(String userInfoemploystatus) {
		this.userInfoemploystatus = userInfoemploystatus;
	}

	public String getEmpadd() {
		return empadd;
	}

	public void setEmpadd(String empadd) {
		this.empadd = empadd;
	}

	public String getEmpadd1() {
		return empadd1;
	}

	public void setEmpadd1(String empadd1) {
		this.empadd1 = empadd1;
	}

	public String getEmpadd2() {
		return empadd2;
	}

	public void setEmpadd2(String empadd2) {
		this.empadd2 = empadd2;
	}

	public String getEmpadd3() {
		return empadd3;
	}

	public void setEmpadd3(String empadd3) {
		this.empadd3 = empadd3;
	}

	public String getUserInfoGender() {
		return userInfoGender;
	}

	public void setUserInfoGender(String userInfoGender) {
		this.userInfoGender = userInfoGender;
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
				+ userInfoName + ", userInfoNum=" + userInfoNum + ", userInfoAddress=" +
				+ userInfoPhone + ", userInfoEmail=" + userInfoEmail + ", userInfoHireDate="
				+ userInfoHireDate + "]";
	}


}
