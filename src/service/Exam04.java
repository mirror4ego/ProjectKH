package service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.sql.SQLException;

import javax.swing.JFrame;
import dao.CustomerDao;

public class Exam04 extends JFrame {

	int arr[] = new int[6]; // 학생 여,남 청년 여,남 중년 여,남
	int max = 0;


	public Exam04() throws ClassNotFoundException, SQLException {
		super();

		CustomerDao dao = new CustomerDao();
		arr[0] = dao.sumCustomerAge(0, 20);
		arr[1] = dao.sumCustomerAge(0, 20);
		arr[2] = dao.sumCustomerAge(21, 50);
		arr[3] = dao.sumCustomerAge(21, 50);
		arr[4] = dao.sumCustomerAge(51, 100);
		arr[5] = dao.sumCustomerAge(51, 100);
		this.init();
		this.start();
		this.setSize(600, 700);
		this.setVisible(true);

	}

	void init() {
		this.setLayout(new BorderLayout());
		Panel p = new Panel(new FlowLayout());
		//p.add(lb1);
		//p.add(lb2);
		this.add("North", p);
	}

	void start() throws ClassNotFoundException, SQLException {


		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				max = arr[i];
			}
			arr[i] *= 5;
		}
		arr[arr.length-1]*=5;

	}

	public void paint(Graphics g) {

		Dimension di = this.getSize();

		g.drawRect(100, 100, 100, 500);
		g.drawRect(250, 100, 100, 500);
		g.drawRect(400, 100, 100, 500);


		for (int i = 0; i <= arr[0] + arr[1]; i++) {
			g.drawLine(100, 600 - i, 200, 600 - i);
			if (i < arr[0])
				g.setColor(Color.red);
			else if (i < arr[0] + arr[1])
				g.setColor(Color.BLUE);
			try {
				Thread.sleep(10);
			} catch (Exception ee) {
			}
		}
		for (int j = 0; j <= arr[2] + arr[3]; j++) {
			g.drawLine(250, 600 - j, 350, 600 - j);
			if (j < arr[2])
				g.setColor(Color.red);
			else if (j < arr[2] + arr[3])
				g.setColor(Color.BLUE);
			try {
				Thread.sleep(10);
			} catch (Exception ee) {
			}
		}
		for (int k = 0; k <= arr[4] + arr[5]; k++) {
			g.drawLine(400, 600 - k, 500, 600 - k);
			if (k < arr[4])
				g.setColor(Color.red);
			else if (k < arr[4] + arr[5])
				g.setColor(Color.BLUE);
			try {
				Thread.sleep(10);
			} catch (Exception ee) {
			}

		}

		try {
			Thread.sleep(20);
		} catch (Exception ee) {
		}


	}
}