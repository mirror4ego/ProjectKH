package projectKH;

public class OrderInfo { // 주문 정보를 관리하는 클래스, 주문정보를 set, get 함

	//주문정보에 필요한 변수 지정
	private int orderinfoNum;
	private String oderinfoPackCompletion;
	private String oderinfoDeliveryCompletion;
	private String oderinfoOrderCompletion;
	private String oderinfoMoneyCollection;
	private String oderinfoDeliveryPredict;
	private String oderinfoDate;
	private String oderinfoLocPossiblity;
	private String oderinfoOrderPossiblity;
	private String oderinfoMenuNum;
	private String oderinfoMenuAmount;
	private String oderinfoRequestInfo;
	private String oderinfoChannelNum;
	private String oderinfoRequestDelivery;

	public OrderInfo(int orderinfoNum, String oderinfoPackCompletion, String oderinfoDeliveryCompletion,
			String oderinfoOrderCompletion, String oderinfoMoneyCollection, String oderinfoDeliveryPredict,
			String oderinfoDate, String oderinfoLocPossiblity, String oderinfoOrderPossiblity, String oderinfoMenuNum,
			String oderinfoMenuAmount, String oderinfoRequestInfo, String oderinfoChannelNum, String oderinfoRequestDelivery) {

		this.orderinfoNum = orderinfoNum;
		this.oderinfoPackCompletion = oderinfoPackCompletion;
		this.oderinfoDeliveryCompletion = oderinfoDeliveryCompletion;
		this.oderinfoOrderCompletion = oderinfoOrderCompletion;
		this.oderinfoMoneyCollection = oderinfoMoneyCollection;
		this.oderinfoDeliveryPredict = oderinfoDeliveryPredict;
		this.oderinfoDate = oderinfoDate;
		this.oderinfoLocPossiblity = oderinfoLocPossiblity;
		this.oderinfoOrderPossiblity = oderinfoOrderPossiblity;
		this.oderinfoMenuNum = oderinfoMenuNum;
		this.oderinfoMenuAmount = oderinfoMenuAmount;
		this.oderinfoRequestInfo = oderinfoRequestInfo;
		this.oderinfoChannelNum = oderinfoChannelNum;
		this.oderinfoRequestDelivery = oderinfoRequestDelivery;
	}

	// 디폴트 생성자 명시적으로 생성
	public OrderInfo() {

	}

	//각 변수 get, set 메소드 시작 지점
	public int getOrderinfoNum() {
		return orderinfoNum;
	}

	public void setOrderinfoNum(int orderinfoNum) {
		this.orderinfoNum = orderinfoNum;
	}

	public String getOderinfoPackCompletion() {
		return oderinfoPackCompletion;
	}

	public void setOderinfoPackCompletion(String oderinfoPackCompletion) {
		this.oderinfoPackCompletion = oderinfoPackCompletion;
	}

	public String getOderinfoDeliveryCompletion() {
		return oderinfoDeliveryCompletion;
	}

	public void setOderinfoDeliveryCompletion(String oderinfoDeliveryCompletion) {
		this.oderinfoDeliveryCompletion = oderinfoDeliveryCompletion;
	}

	public String getOderinfoOrderCompletion() {
		return oderinfoOrderCompletion;
	}

	public void setOderinfoOrderCompletion(String oderinfoOrderCompletion) {
		this.oderinfoOrderCompletion = oderinfoOrderCompletion;
	}

	public String getOderinfoMoneyCollection() {
		return oderinfoMoneyCollection;
	}

	public void setOderinfoMoneyCollection(String oderinfoMoneyCollection) {
		this.oderinfoMoneyCollection = oderinfoMoneyCollection;
	}

	public String getOderinfoDeliveryPredict() {
		return oderinfoDeliveryPredict;
	}

	public void setOderinfoDeliveryPredict(String oderinfoDeliveryPredict) {
		this.oderinfoDeliveryPredict = oderinfoDeliveryPredict;
	}

	public String getOderinfoDate() {
		return oderinfoDate;
	}

	public void setOderinfoDate(String oderinfoDate) {
		this.oderinfoDate = oderinfoDate;
	}

	public String getOderinfoLocPossiblity() {
		return oderinfoLocPossiblity;
	}

	public void setOderinfoLocPossiblity(String oderinfoLocPossiblity) {
		this.oderinfoLocPossiblity = oderinfoLocPossiblity;
	}

	public String getOderinfoOrderPossiblity() {
		return oderinfoOrderPossiblity;
	}

	public void setOderinfoOrderPossiblity(String oderinfoOrderPossiblity) {
		this.oderinfoOrderPossiblity = oderinfoOrderPossiblity;
	}

	public String getOderinfoMenuNum() {
		return oderinfoMenuNum;
	}

	public void setOderinfoMenuNum(String oderinfoMenuNum) {
		this.oderinfoMenuNum = oderinfoMenuNum;
	}

	public String getOderinfoMenuAmount() {
		return oderinfoMenuAmount;
	}

	public void setOderinfoMenuAmount(String oderinfoMenuAmount) {
		this.oderinfoMenuAmount = oderinfoMenuAmount;
	}

	public String getOderinfoRequestInfo() {
		return oderinfoRequestInfo;
	}

	public void setOderinfoRequestInfo(String oderinfoRequestInfo) {
		this.oderinfoRequestInfo = oderinfoRequestInfo;
	}

	public String getOderinfoChannelNum() {
		return oderinfoChannelNum;
	}

	public void setOderinfoChannelNum(String oderinfoChannelNum) {
		this.oderinfoChannelNum = oderinfoChannelNum;
	}

	public String getOderinfoRequestDelivery() {
		return oderinfoRequestDelivery;
	}

	public void setOderinfoRequestDelivery(String oderinfoRequestDelivery) {
		this.oderinfoRequestDelivery = oderinfoRequestDelivery;
	}
	// 각 변수 get, set 메소드 종료 지점 

}