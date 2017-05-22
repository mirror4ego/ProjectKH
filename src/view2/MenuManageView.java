package view2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

import dao.CustomerDao;

public class MenuManageView extends JFrame{
	public MenuManageView() throws ClassNotFoundException, SQLException {
		super("메뉴 관리");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1000,720);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
	}
}
