package view;


import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import service.Exam02;
import service.Exam03;
import service.Exam04;
import service.Exam05;


public class CRM_MainLayout {
	public static void main(String[] ar) throws ClassNotFoundException, SQLException{
		CRM_MainLayout_sub ex = new CRM_MainLayout_sub();
	}
}

class CRM_MainLayout_sub extends JFrame implements ActionListener {
	private Container con;
	private List<Integer> score;
	private JButton btn1 = new JButton("A통계");
	private JButton btn2 = new JButton("B통계");
	private JButton btn3 = new JButton("C통계");
	private JButton btn4 = new JButton("D통계");
	
	//public class Exam01 extends JPanel {

		private int width = 800;
		private int heigth = 400;
		private int padding = 25;
		private int labelPadding = 25;
		private Color lineColor = new Color(44, 102, 230, 180);
		private Color pointColor = new Color(100, 100, 100, 180);
		private Color gridColor = new Color(200, 200, 200, 200);
		private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
		private int pointWidth = 5;
		private int numberYDivisions = 10;
		//private List<Double> scores;

		//public  Exam01(List<Double> scores) {
			this.scores = scores;
			
			
//----------------------------------			
			
	
	
	public CRM_MainLayout_sub() throws ClassNotFoundException, SQLException{
		super();
		this.init();
		this.start();
		this.setSize(700,500);
		this.setVisible(true);
		
	}
	

	private void init() throws ClassNotFoundException, SQLException {
		
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
		
		Panel p1 = new Panel(new GridLayout(4,1));
		p1.add(btn1);
		p1.add(btn2);
		p1.add(btn3);
		p1.add(btn4);
		this.add("West",p1);
		//jsp.setWheelScrollingEnabled(true);
		//this.add("Center", jsp);
		JPanel p2 = new JPanel(new CardLayout());

		this.add("Center",p2);
		
	}
	
	public void start(){
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn1){
			try {
				Exam02 ex02= new Exam02();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==btn2){
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					Exam03 ex03= new Exam03(score);
					try {
						ex03.createAndShowGui();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}else if(e.getSource()==btn3){
			try {
				Exam04 ex04 = new Exam04();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==btn4){
			Exam05 ex = new Exam05();
		}
		
	}
	
}
		
