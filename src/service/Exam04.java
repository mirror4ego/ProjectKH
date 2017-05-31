package service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.CustomerDao;

public class Exam04 extends JFrame {

	int arr[] = new int[6]; // 학생 여,남 청년 여,남 중년 여,남
	int max = 0;
	private Font font = new Font("맑은 고딕", Font.BOLD, 15);

	

	public Exam04() throws ClassNotFoundException, SQLException {
		super();
		

		CustomerDao dao = new CustomerDao();
		arr[0] = dao.sumCustomerAge(20, 40,0);
		arr[1] = dao.sumCustomerAge(20, 40,1);
		arr[2] = dao.sumCustomerAge(41, 60,0);
		arr[3] = dao.sumCustomerAge(41, 60,1);
		arr[4] = dao.sumCustomerAge(61, 100,0);
		arr[5] = dao.sumCustomerAge(61, 100,1);
		this.init();
		this.start();
		//this.paint(null);
		this.setSize(600, 650);
		this.setVisible(true);

	}

	void init() {
		
		//p.add(lb1);
		//p.add(lb2);
		this.setLayout(new BorderLayout());
		Panel p = new Panel(new FlowLayout());
		this.add("North", p);

		
	}

	void start() throws ClassNotFoundException, SQLException {


		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				max = arr[i];
			}
			arr[i] *= 20;
		}
		arr[arr.length-1]*=20;
		//크기배율조정
	}

   
	public void paint(Graphics g) {
	     
		Dimension di = this.getSize();
		
		g.drawRect(100, 100, 100, 500);
		g.drawRect(250, 100, 100, 500);
		g.drawRect(400, 100, 100, 500);
		
		g.drawString("20-40", 130, 90);
		g.drawString("40-60", 280, 90);
		g.drawString("60-80", 430, 90);

		for (int i = 0; i <= arr[0] + arr[1]; i++) {
			g.drawLine(100, 600 - i, 200, 600 - i);
			if (i < arr[0])
				g.setColor(new Color(185,24,35));
			else if (i < arr[0] + arr[1])
				g.setColor(new Color(13,72,145));
			try {
				Thread.sleep(10);
			} catch (Exception ee) {
			}
		}
		for (int j = 0; j <= arr[2] + arr[3]; j++) {
			g.drawLine(250, 600 - j, 350, 600 - j);
			if (j < arr[2])
				g.setColor(new Color(185,24,35));
			else if (j < arr[2] + arr[3])
				g.setColor(new Color(13,72,145));
			try {
				Thread.sleep(10);
			} catch (Exception ee) {
			}
		}
		for (int k = 0; k <= arr[4] + arr[5]; k++) {
			g.drawLine(400, 600 - k, 500, 600 - k);
			if (k < arr[4])
				g.setColor(new Color(185,24,35));
			else if (k < arr[4] + arr[5])
				g.setColor(new Color(13,72,145));
			try {
				Thread.sleep(10);
			} catch (Exception ee) {
			}

		}

		
	}
}
