package test;

import java.io.IOException;
import java.sql.SQLException;

<<<<<<< HEAD
import service.CRM_MainLayout;
import view.LoginView;
=======
import view.CustomerSearchView;
import view.MainView;
import service.CRM_MainLayout;
import view.LoginView;

>>>>>>> dd3f7aac5dba0b9b6e75c8d44d383c921c853d39

import view.MainView;

public class Test {
	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

<<<<<<< HEAD
		 //LoginView loginView = new LoginView();
		// MainView mainView = new MainView();
		// UserInfoDao userInfoDao = new UserInfoDao();
		// userInfoDao.selectAll();
		// Login login = new Login();
		// boolean test = login.login("mirror4ego", "1234");
=======
		//CustomerSearchView customerSearchView = new CustomerSearchView();
		//LoginView loginView = new LoginView();
		MainView mainView = new MainView();


		//LoginView loginView = new LoginView();
		//MainView mainView = new MainView();

		//UserInfoDao userInfoDao = new UserInfoDao();
		//userInfoDao.selectAll();
		//Login login = new Login();
		//boolean test = login.login("mirror4ego", "1234");

		//UserSelectView userSelectView = new UserSelectView();
		
		

>>>>>>> dd3f7aac5dba0b9b6e75c8d44d383c921c853d39
		CRM_MainLayout crm = new CRM_MainLayout();

	}
}