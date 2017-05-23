package domain;

public class MenuDto {
	private int menuNum;
	private String menuName;
	private int menuPrice;
	private int menuGroupNum;
	
	public MenuDto(){}
	
	public MenuDto(int menuNum, String menuName, int menuPrice, int menuGroupNum) {
		this.menuNum = menuNum;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuGroupNum = menuGroupNum;
	}

	public int getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(int menuNum) {
		this.menuNum = menuNum;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public int getMenuGroupNum() {
		return menuGroupNum;
	}

	public void setMenuGroupNum(int menuGroupNum) {
		this.menuGroupNum = menuGroupNum;
	}
	
	
}
