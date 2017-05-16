package domain;

public class OrderInfoDto { // 주문 정보를 관리하는 클래스, 주문정보를 set, get 함

	//주문정보에 필요한 변수 지정
	private int orderInfoNum;
	private String orderInfoDate;
	private String orderInfoLocPossiblity;
	private String orderInfoOrderPossiblity;
	private int orderInfoMenuNum;
	private int orderInfoMenuAmount;
	private String orderInfoRequestInfo;
	private int orderInfoChannelNum;
	private String orderInfoRequestDelivery;
	private String orderInfoPackCompletion;
	private String orderInfoDeliveryCompletion;
	private String orderInfoOrderCompletion;
	private String orderInfoMoneyCollection;
	private String orderInfoDeliveryPredict;
	private int orderInfoCustomerNum;

	public OrderInfoDto(int orderInfoNum, String orderInfoDate, String orderInfoLocPossiblity, String orderInfoOrderPossiblity,
			int orderInfoMenuNum, int orderInfoMenuAmount, String orderInfoRequestInfo, int orderInfoChannelNum,
			String orderInfoRequestDelivery, String orderInfoPackCompletion, String orderInfoDeliveryCompletion,
			String orderInfoOrderCompletion, String orderInfoMoneyCollection, String orderInfoDeliveryPredict, 
			int orderInfoCustomerNum) {


		this.orderInfoNum = orderInfoNum;
		this.orderInfoDate = orderInfoDate;
		this.orderInfoLocPossiblity = orderInfoLocPossiblity;
		this.orderInfoOrderPossiblity = orderInfoOrderPossiblity;
		this.orderInfoMenuNum = orderInfoMenuNum;
		this.orderInfoMenuAmount = orderInfoMenuAmount;
		this.orderInfoRequestInfo = orderInfoRequestInfo;
		this.orderInfoChannelNum = orderInfoChannelNum;
		this.orderInfoRequestDelivery = orderInfoRequestDelivery;
		this.orderInfoPackCompletion = orderInfoPackCompletion;
		this.orderInfoDeliveryCompletion = orderInfoDeliveryCompletion;
		this.orderInfoOrderCompletion = orderInfoOrderCompletion;
		this.orderInfoMoneyCollection = orderInfoMoneyCollection;
		this.orderInfoDeliveryPredict = orderInfoDeliveryPredict;
		this.orderInfoCustomerNum = orderInfoCustomerNum;

	}

	// 디폴트 생성자 명시적으로 생성
	public OrderInfoDto() {

	}

	public int getOrderInfoNum() {
		return orderInfoNum;
	}

	public void setOrderInfoNum(int orderInfoNum) {
		this.orderInfoNum = orderInfoNum;
	}

	public String getOrderInfoDate() {
		return orderInfoDate;
	}

	public void setOrderInfoDate(String orderInfoDate) {
		this.orderInfoDate = orderInfoDate;
	}

	public String getOrderInfoLocPossibility() {
		return orderInfoLocPossiblity;
	}

	public void setOrderInfoLocPossiblity(String orderInfoLocPossiblity) {
		this.orderInfoLocPossiblity = orderInfoLocPossiblity;
	}

	public String getOrderInfoOrderPossiblity() {
		return orderInfoOrderPossiblity;
	}

	public void setOrderInfoOrderPossiblity(String orderInfoOrderPossiblity) {
		this.orderInfoOrderPossiblity = orderInfoOrderPossiblity;
	}

	public int getOrderInfoMenuNum() {
		return orderInfoMenuNum;
	}

	public void setOrderInfoMenuNum(int orderInfoMenuNum) {
		this.orderInfoMenuNum = orderInfoMenuNum;
	}

	public int getOrderInfoMenuAmount() {
		return orderInfoMenuAmount;
	}

	public void setOrderInfoMenuAmount(int orderInfoMenuAmount) {
		this.orderInfoMenuAmount = orderInfoMenuAmount;
	}

	public String getOrderInfoRequestInfo() {
		return orderInfoRequestInfo;
	}

	public void setOrderInfoRequestInfo(String orderInfoRequestInfo) {
		this.orderInfoRequestInfo = orderInfoRequestInfo;
	}

	public int getOrderInfoChannelNum() {
		return orderInfoChannelNum;
	}

	public void setOrderInfoChannelNum(int orderInfoChannelNum) {
		this.orderInfoChannelNum = orderInfoChannelNum;
	}

	public String getOrderInfoRequestDelivery() {
		return orderInfoRequestDelivery;
	}

	public void setOrderInfoRequestDelivery(String orderInfoRequestDelivery) {
		this.orderInfoRequestDelivery = orderInfoRequestDelivery;
	}

	public String getOrderInfoPackCompletion() {
		return orderInfoPackCompletion;
	}

	public void setOrderInfoPackCompletion(String orderInfoPackCompletion) {
		this.orderInfoPackCompletion = orderInfoPackCompletion;
	}

	public String getOrderInfoDeliveryCompletion() {
		return orderInfoDeliveryCompletion;
	}

	public void setOrderInfoDeliveryCompletion(String orderInfoDeliveryCompletion) {
		this.orderInfoDeliveryCompletion = orderInfoDeliveryCompletion;
	}

	public String getOrderInfoOrderCompletion() {
		return orderInfoOrderCompletion;
	}

	public void setOrderInfoOrderCompletion(String orderInfoOrderCompletion) {
		this.orderInfoOrderCompletion = orderInfoOrderCompletion;
	}

	public String getOrderInfoMoneyCollection() {
		return orderInfoMoneyCollection;
	}

	public void setOrderInfoMoneyCollection(String orderInfoMoneyCollection) {
		this.orderInfoMoneyCollection = orderInfoMoneyCollection;
	}

	public String getOrderInfoDeliveryPredict() {
		return orderInfoDeliveryPredict;
	}

	public void setOrderInfoDeliveryPredict(String orderInfoDeliveryPredict) {
		this.orderInfoDeliveryPredict = orderInfoDeliveryPredict;
	}

	public int getOrderInfoCustomerNum() {
		return orderInfoCustomerNum;
	}

	public void setOrderInfoCustomerNum(int orderInfoCustomerNum) {
		this.orderInfoCustomerNum = orderInfoCustomerNum;
	}

	@Override
	public String toString() {
		return "OrderInfoDto [orderInfoNum=" + orderInfoNum + ", orderInfoDate=" + orderInfoDate
				+ ", orderInfoLocPossiblity=" + orderInfoLocPossiblity + ", orderInfoOrderPossiblity="
				+ orderInfoOrderPossiblity + ", orderInfoMenuNum=" + orderInfoMenuNum + ", orderInfoMenuAmount="
				+ orderInfoMenuAmount + ", orderInfoRequestInfo=" + orderInfoRequestInfo + ", orderInfoChannelNum="
				+ orderInfoChannelNum + ", orderInfoRequestDelivery=" + orderInfoRequestDelivery
				+ ", orderInfoPackCompletion=" + orderInfoPackCompletion + ", orderInfoDeliveryCompletion="
				+ orderInfoDeliveryCompletion + ", orderInfoOrderCompletion=" + orderInfoOrderCompletion
				+ ", orderInfoMoneyCollection=" + orderInfoMoneyCollection + ", orderInfoDeliveryPredict="
				+ orderInfoDeliveryPredict + ", orderInfoCustomerNum=" + orderInfoCustomerNum + "]";
	}
}