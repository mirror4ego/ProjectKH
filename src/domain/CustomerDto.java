package domain;

public class CustomerDto {

	private int customerNum;
	private String customerRegDate;
	private String customerPhoneNum;
	private String customerAddState;
	private String customerAddCity;
	private String customerAddStreet;
	private String customerAddRest;
	private int customerFrequent;
	private int customerAgePredict;
	private int customerReceivable;
	private int customerGender;

	public CustomerDto() {}

	public CustomerDto(int customerNum, String customerRegDate, String customerPhoneNum, String customerAddState,
			String customerAddCity, String customerAddStreet, String customerAddRest, int customerFrequent,
			int customerAgePredict, int customerReceivable, int customerGender) {
		this.customerNum = customerNum;
		this.customerRegDate = customerRegDate;
		this.customerPhoneNum = customerPhoneNum;
		this.customerAddState = customerAddState;
		this.customerAddCity = customerAddCity;
		this.customerAddStreet = customerAddStreet;
		this.customerAddRest = customerAddRest;
		this.customerFrequent = customerFrequent;
		this.customerAgePredict = customerAgePredict;
		this.customerReceivable = customerReceivable;
		this.customerGender = customerGender;
	}

	public int getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}

	public String getCustomerRegDate() {
		return customerRegDate;
	}

	public void setCustomerRegDate(String customerRegDate) {
		this.customerRegDate = customerRegDate;
	}

	public String getCustomerPhoneNum() {
		return customerPhoneNum;
	}

	public void setCustomerPhoneNum(String customerPhoneNum) {
		this.customerPhoneNum = customerPhoneNum;
	}

	public String getCustomerAddState() {
		return customerAddState;
	}

	public void setCustomerAddState(String customerAddState) {
		this.customerAddState = customerAddState;
	}

	public String getCustomerAddCity() {
		return customerAddCity;
	}

	public void setCustomerAddCity(String customerAddCity) {
		this.customerAddCity = customerAddCity;
	}

	public String getCustomerAddStreet() {
		return customerAddStreet;
	}

	public void setCustomerAddStreet(String customerAddStreet) {
		this.customerAddStreet = customerAddStreet;
	}

	public String getCustomerAddRest() {
		return customerAddRest;
	}

	public void setCustomerAddRest(String customerAddRest) {
		this.customerAddRest = customerAddRest;
	}

	public int getCustomerFrequent() {
		return customerFrequent;
	}

	public void setCustomerFrequent(int customerFrequent) {
		this.customerFrequent = customerFrequent;
	}

	public int getCustomerAgePredict() {
		return customerAgePredict;
	}

	public void setCustomerAgePredict(int customerAgePredict) {
		this.customerAgePredict = customerAgePredict;
	}
	
	public int getCustomerReceivable() {
		return customerReceivable;
	}

	public void setCustomerReceivable(int customerReceivable) {
		this.customerReceivable = customerReceivable;
	}

	public int getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(int customerGender) {
		this.customerGender = customerGender;
	}

	@Override
	public String toString() {
		return "CustomerDto [customerNum=" + customerNum + ", customerRegDate=" + customerRegDate
				+ ", customerPhoneNum=" + customerPhoneNum + ", customerAddState=" + customerAddState
				+ ", customerAddCity=" + customerAddCity + ", customerAddStreet=" + customerAddStreet
				+ ", customerAddRest=" + customerAddRest + ", customerFrequent=" + customerFrequent
				+ ", customerAgePredict=" + customerAgePredict + ", customerReceivable=" + customerReceivable
				+ ", customerGender=" + customerGender + "]";
	}



}