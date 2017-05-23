package service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.sql.SQLException;

import javax.swing.JFrame;

import dao.CustomerDao;

public class Exam05 extends JFrame {
	CustomerDao dao = new CustomerDao();
	Font font = new Font("Times New Roman",Font.BOLD,18);
	int aDong[][] = new int[50][2];
	int bDong[][] = new int[50][2];
	int cDong[][] = new int[50][2];
	int dDong[][] = new int[50][2];
	private String alb = "사당동";
	private String blb = "금천동";
	private String clb = "삼성동";
	private String dlb = "읍면동";

	public Exam05() {
		super();
		this.init();
		this.start();
		this.setSize(500, 500);
		this.setVisible(true);
	}

	void init() {
		this.setLayout(new BorderLayout());
		Panel p = new Panel(new FlowLayout());

		this.add("North", p);
	}

	void start() {

		try {
			for (int i = 0; i < dao.sumCustomerLoc("사당동"); i++) {
				aDong[i][0] = randomRange(0, 250);
				aDong[i][1] = randomRange(0, 250);
			}
		
		for (int i = 0; i < dao.sumCustomerLoc("금천동"); i++) {
			bDong[i][0] = randomRange(250, 500);
			bDong[i][1] = randomRange(0, 250);
		}
		for (int i = 0; i < dao.sumCustomerLoc("삼성동"); i++) {
			cDong[i][0] = randomRange(0, 250);
			cDong[i][1] = randomRange(250, 500);
		}
		for (int i = 0; i < dao.sumCustomerLoc("읍면동"); i++) {
			dDong[i][0] = randomRange(250, 500);
			dDong[i][1] = randomRange(250, 500);
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int randomRange(int n1, int n2) {
		return (int) (Math.random() * (n2 - n1 + 1)) + n1;
	}

	public void paint(Graphics g) {
		g.drawLine(0, 250, 500, 250);// 시작좌표(왼쪽위),끝나는좌표(오른쪽아래)
		g.drawLine(250, 0, 250, 500);
		g.setFont(font);
		g.drawString("A", 125, 125);
		g.drawString("B", 375, 125);
		g.drawString("C", 125, 375);
		g.drawString("D", 375, 375);
		for (int i = 0; i < 50; i++) {
			g.setColor(Color.red);
			g.fillOval(aDong[i][0], aDong[i][1], 5, 5);
		}


		for (int i = 0; i < 50; i++) {
			g.setColor(Color.blue);
			g.fillOval(bDong[i][0], bDong[i][1], 5, 5);
		}
		for (int i = 0; i < 50; i++) {
			g.setColor(Color.green);
			g.fillOval(cDong[i][0], cDong[i][1], 5, 5);
		}
		for (int i = 0; i < 50; i++) {
			g.setColor(Color.pink);
			g.fillOval(dDong[i][0], dDong[i][1], 5, 5);
		}
	}
}
