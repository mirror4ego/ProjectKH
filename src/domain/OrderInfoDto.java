package domain;

public class OrderInfoDto {

	private int orderInfoNum;
	private String orderInfoDate;
	private String orderInfoLocPossibility;
	private String orderInfoOrderPossibility;
	private String orderInfoRequestInfo;
	private String orderInfoChannelName;
	private String orderInfoRequestDelivery;
	private String orderInfoPackCompletion;
	private String orderInfoDeliveryCompletion;
	private String orderInfoOrderCompletion;
	private String orderInfoMoneyCollection;
	private String orderInfoDeliveryPredict;
	private int orderInfoCustomerNum;
	private String orderInfoUserInfoId;

	public OrderInfoDto() {}

	public OrderInfoDto(int orderInfoNum, String orderInfoDate, String orderInfoLocPossibility, String orderInfoOrderPossibility,
			String orderInfoRequestInfo, String orderInfoChannelName,
			String orderInfoRequestDelivery, String orderInfoPackCompletion, String orderInfoDeliveryCompletion,
			String orderInfoOrderCompletion, String orderInfoMoneyCollection, String orderInfoDeliveryPredict, 
			int orderInfoCustomerNum, String orderInfoUserInfoId) {
		this.orderInfoNum = orderInfoNum;
		this.orderInfoDate = orderInfoDate;
		this.orderInfoLocPossibility = orderInfoLocPossibility;
		this.orderInfoOrderPossibility = orderInfoOrderPossibility;
		this.orderInfoRequestInfo = orderInfoRequestInfo;
		this.orderInfoChannelName = orderInfoChannelName;
		this.orderInfoRequestDelivery = orderInfoRequestDelivery;
		this.orderInfoPackCompletion = orderInfoPackCompletion;
		this.orderInfoDeliveryCompletion = orderInfoDeliveryCompletion;
		this.orderInfoOrderCompletion = orderInfoOrderCompletion;
		this.orderInfoMoneyCollection = orderInfoMoneyCollection;
		this.orderInfoDeliveryPredict = orderInfoDeliveryPredict;
		this.orderInfoCustomerNum = orderInfoCustomerNum;
		this.orderInfoUserInfoId = orderInfoUserInfoId;
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
		return orderInfoLocPossibility;
	}

	public void setOrderInfoLocPossibility(String orderInfoLocPossibility) {
		this.orderInfoLocPossibility = orderInfoLocPossibility;
	}

	public String getOrderInfoOrderPossibility() {
		return orderInfoOrderPossibility;
	}

	public void setOrderInfoOrderPossibility(String orderInfoOrderPossiblity) {
		this.orderInfoOrderPossibility = orderInfoOrderPossiblity;
	}

	public String getOrderInfoRequestInfo() {
		return orderInfoRequestInfo;
	}

	public void setOrderInfoRequestInfo(String orderInfoRequestInfo) {
		this.orderInfoRequestInfo = orderInfoRequestInfo;
	}

	public String getOrderInfoChannelName() {
		return orderInfoChannelName;
	}

	public void setOrderInfoChannelName(String orderInfoChannelName) {
		this.orderInfoChannelName = orderInfoChannelName;
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

	public String getOrderInfoUserInfoId() {
		return orderInfoUserInfoId;
	}

	public void setOrderInfoUserInfoId(String orderInfoUserInfoId) {
		this.orderInfoUserInfoId = orderInfoUserInfoId;
	}

	@Override
	public String toString() {
		return "OrderInfoDto [orderInfoNum=" + orderInfoNum + ", orderInfoDate=" + orderInfoDate
				+ ", orderInfoLocPossibility=" + orderInfoLocPossibility + ", orderInfoOrderPossibility="
				+ orderInfoOrderPossibility + ", orderInfoRequestInfo=" + orderInfoRequestInfo
				+ ", orderInfoChannelName=" + orderInfoChannelName + ", orderInfoRequestDelivery="
				+ orderInfoRequestDelivery + ", orderInfoPackCompletion=" + orderInfoPackCompletion
				+ ", orderInfoDeliveryCompletion=" + orderInfoDeliveryCompletion + ", orderInfoOrderCompletion="
				+ orderInfoOrderCompletion + ", orderInfoMoneyCollection=" + orderInfoMoneyCollection
				+ ", orderInfoDeliveryPredict=" + orderInfoDeliveryPredict + ", orderInfoCustomerNum="
				+ orderInfoCustomerNum + ", orderInfoUserInfoId=" + orderInfoUserInfoId + "]";
	}

}