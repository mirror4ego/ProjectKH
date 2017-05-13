package domain;

public class EmployeeInfoDto {

	//고객정보에 필요한 변수 지정
	private int employeeInfoNum;
	private String employeeInfoName;

	public EmployeeInfoDto() {}
	// 유저정보객체를 만들때 필요한 매개변수를 받아서 초기화 시키는 생성자
	public EmployeeInfoDto(int employeeInfoNum, String employeeInfoName) {
		this.employeeInfoNum = employeeInfoNum;
		this.employeeInfoName = employeeInfoName;
	}


	public int getEmployeeInfoNum() {
		return employeeInfoNum;
	}


	public void setEmployeeInfoNum(int employeeInfoNum) {
		this.employeeInfoNum = employeeInfoNum;
	}


	public String getEmployeeInfoName() {
		return employeeInfoName;
	}


	public void setEmployeeInfoName(String employeeInfoName) {
		this.employeeInfoName = employeeInfoName;
	}
	
	
}
