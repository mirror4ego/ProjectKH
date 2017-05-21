package test;

import java.io.IOException;
import java.sql.SQLException;

import dao.OrderInfoDao;
import domain.OrderInfoDto;
import view.LoginView;
import view2.OrderListMiniView;

public class TestJY {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		
		//CustomerSearchView customerSearchView = new CustomerSearchView();
		LoginView loginView = new LoginView();
		//MainView mainView = new MainView();
		//UsserInfoDao userInfoDao = new UserInfoDao();
		//userInfoDao.selectAll();
		//Login login = new Login();
		//boolean test = login.login("mirror4ego", "1234");
		//UserSelectView userSelectView = new UserSelectView();
		//DaoFactory DaoFactory = new DaoFactory();
		//DaoFactory.customerDao();
		//CustomerMainView customerMainView = new CustomerMainView();
		//OrderSheetView orderSheetView = new OrderSheetView();
		//OrderListView orderRegView = new OrderListView();
		(new OrderInfoDao()).add(new OrderInfoDto(1, "19840903", "1", "1", "빠르게 배달", 3, "19850904", "1", "1", "1", "1", "19440301", 1100));
	}
}
