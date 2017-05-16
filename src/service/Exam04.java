package service;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exam04 extends JFrame {

	int arr[] = { 10, 20, 25, 10, 10, 30 }; // 20여 20남 30여 30남 40여 40남
	int max = 0;

	public Exam04() {
		super();
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

	void start() {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				max = arr[i];
			}
			arr[i] *= 10;
		}
		arr[arr.length-1]*=10;

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