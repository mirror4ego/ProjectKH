package domain;

public class MenuGroupDto {
	private int menuGroupNum;
	private String menuGroupName;
	
	public MenuGroupDto(){}
	
	public MenuGroupDto(int menuGroupNum, String menuGroupName) {
		this.menuGroupNum = menuGroupNum;
		this.menuGroupName = menuGroupName;
	}

	public int getMenuGroupNum() {
		return menuGroupNum;
	}

	public void setMenuGroupNum(int menuGroupNum) {
		this.menuGroupNum = menuGroupNum;
	}

	public String getMenuGroupName() {
		return menuGroupName;
	}

	public void setMenuGroupName(String menuGroupName) {
		this.menuGroupName = menuGroupName;
	}

	
	
}
