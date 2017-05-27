package domain;

public class OrderItemDto {
	private int orderItemNum;
	private int orderItemOrderInfoNum;
	private String orderItemMenuName;
	private int orderItemQuantity;
	
	public OrderItemDto(){
		
	}
	
	OrderItemDto(int orderItemNum, int orderItemOrderInfoNum, String orderItemMenuName, int orderItemQuantity) {
		this.orderItemNum = orderItemNum;
		this.orderItemOrderInfoNum = orderItemOrderInfoNum;
		this.orderItemMenuName = orderItemMenuName;
		this.orderItemQuantity = orderItemQuantity;
	}

	public int getOrderItemNum() {
		return orderItemNum;
	}

	public void setOrderItemNum(int orderItemNum) {
		this.orderItemNum = orderItemNum;
	}

	public int getOrderItemOrderInfoNum() {
		return orderItemOrderInfoNum;
	}

	public void setOrderItemOrderInfoNum(int orderItemOrderInfoNum) {
		this.orderItemOrderInfoNum = orderItemOrderInfoNum;
	}

	public String getOrderItemMenuName() {
		return orderItemMenuName;
	}

	public void setOrderItemMenuName(String orderItemMenuName) {
		this.orderItemMenuName = orderItemMenuName;
	}

	public int getOrderItemQuantity() {
		return orderItemQuantity;
	}

	public void setOrderItemQuantity(int orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}
	
	
}
