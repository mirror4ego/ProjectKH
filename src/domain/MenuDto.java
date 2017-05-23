package domain;

public class MenuDto {
	private String menuName;
	private int menuPrice;
	private String menuGroupName;
	
	public MenuDto(){}
	
	public MenuDto(String menuName, int menuPrice, String menuGroupName) {
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuGroupName = menuGroupName;
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

	public String getMenuGroupName() {
		return menuGroupName;
	}

	public void setMenuGroupName(String menuGroupName) {
		this.menuGroupName = menuGroupName;
	}

	@Override
	public String toString() {
		return "MenuDto [menuName=" + menuName + ", menuPrice=" + menuPrice + ", menuGroupName=" + menuGroupName + "]";
	}

}
