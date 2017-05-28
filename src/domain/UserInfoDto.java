package domain;

public class UserInfoDto {

	private String userInfoId;
	private String userInfoPassword;
	private String userInfoName;
	private int userInfoNum;
	private String userInfoTask;
	private int userInfoPhone;
	private String userInfoEmail;
	private String userInfoAttendanceTime;
	private String userInfoQuittingTime;
	private String userInfoEmployStatus;
	private String userInfoAddState;
	private String userInfoAddCity;
	private String userInfoAddStreet;
	private String userInfoAddRest;
	private String userInfoGender;
	
	
	public UserInfoDto() {}

	public UserInfoDto(String userInfoId, String userInfoPassword, String userInfoName, int userInfoNum, String userInfoTask,
			int userInfoPhone, String userInfoEmail, String userInfoAttendanceTime, String userInfoQuittingTime,
			String userInfoEmployStatus, String userInfoAddState, String userInfoAddCity, String userInfoAddStreet,
			String userInfoAddRest, String userInfoGender) {
		this.userInfoId = userInfoId;
		this.userInfoPassword = userInfoPassword;
		this.userInfoName = userInfoName;
		this.userInfoNum = userInfoNum;
		this.userInfoTask = userInfoTask;
		this.userInfoPhone = userInfoPhone;
		this.userInfoEmail = userInfoEmail;
		this.userInfoAttendanceTime = userInfoAttendanceTime;
		this.userInfoQuittingTime = userInfoQuittingTime;
		this.userInfoEmployStatus = userInfoEmployStatus;
		this.userInfoAddState = userInfoAddState;
		this.userInfoAddCity = userInfoAddCity;
		this.userInfoAddStreet = userInfoAddStreet;
		this.userInfoAddRest = userInfoAddRest;
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

	public String getUserInfoTask() {
		return userInfoTask;
	}

	public void setUserInfoTask(String userInfoTask) {
		this.userInfoTask = userInfoTask;
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

	public String getUserInfoAttendanceTime() {
		return userInfoAttendanceTime;
	}

	public void setUserInfoAttendanceTime(String userInfoAttendanceTime) {
		this.userInfoAttendanceTime = userInfoAttendanceTime;
	}

	public String getUserInfoQuittingTime() {
		return userInfoQuittingTime;
	}

	public void setUserInfoQuittingTime(String userInfoQuittingTime) {
		this.userInfoQuittingTime = userInfoQuittingTime;
	}

	public String getUserInfoEmployStatus() {
		return userInfoEmployStatus;
	}

	public void setUserInfoEmployStatus(String userInfoEmployStatus) {
		this.userInfoEmployStatus = userInfoEmployStatus;
	}

	public String getUserInfoAddState() {
		return userInfoAddState;
	}

	public void setUserInfoAddState(String userInfoAddState) {
		this.userInfoAddState = userInfoAddState;
	}

	public String getUserInfoAddCity() {
		return userInfoAddCity;
	}

	public void setUserInfoAddCity(String userInfoAddCity) {
		this.userInfoAddCity = userInfoAddCity;
	}

	public String getUserInfoAddStreet() {
		return userInfoAddStreet;
	}

	public void setUserInfoAddStreet(String userInfoAddStreet) {
		this.userInfoAddStreet = userInfoAddStreet;
	}

	public String getUserInfoAddRest() {
		return userInfoAddRest;
	}

	public void setUserInfoAddRest(String userInfoAddRest) {
		this.userInfoAddRest = userInfoAddRest;
	}

	public String getUserInfoGender() {
		return userInfoGender;
	}

	public void setUserInfoGender(String userInfoGender) {
		this.userInfoGender = userInfoGender;
	}

	@Override
	public String toString() {
		return "UserInfoDto [userInfoId=" + userInfoId + ", userInfoPassword=" + userInfoPassword + ", userInfoName="
				+ userInfoName + ", userInfoNum=" + userInfoNum + ", userInfoTask=" + userInfoTask + ", userInfoPhone="
				+ userInfoPhone + ", userInfoEmail=" + userInfoEmail 
				+ ", userInfoAttendanceTime=" + userInfoAttendanceTime + ", userInfoQuittingTime="
				+ userInfoQuittingTime + ", userInfoEmployStatus=" + userInfoEmployStatus + ", userInfoAddState="
				+ userInfoAddState + ", userInfoAddCity=" + userInfoAddCity + ", userInfoAddStreet=" + userInfoAddStreet
				+ ", userInfoAddRest=" + userInfoAddRest + ", userInfoGender=" + userInfoGender + "]";
	}
}
