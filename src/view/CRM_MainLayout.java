package view;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import service.Exam01;
import service.Exam02;
import service.Exam03;
import service.Exam04;
import service.Exam05;
public class CRM_MainLayout extends JFrame implements FocusListener, ActionListener, ItemListener{
	private FlowLayout flow = new FlowLayout();
	private Choice choice = new Choice();
	private List<Integer> score;
	private List<Double> scores;
	private int num=0;

	public CRM_MainLayout(){
		super("");
		this.init();
		this.start();
		this.setSize(200,100);
		this.setVisible(true);
	}
	private void init(){
		this.setLayout(flow);
		choice.add("A");
		choice.add("B");
		choice.add("C");
		choice.add("D");
		choice.add("E");
		this.add(choice);
	}
	private void start(){
		choice.addItemListener(this);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void itemStateChanged(ItemEvent e){
		if(e.getSource()==choice){
			int index =choice.getSelectedIndex();
			switch(index){
			case 0:
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						Exam01 ex= new Exam01(scores);
						Exam01.createAndShowGui();
					}
				});
				break;
			case 1:
				try {
					Exam02 ex2= new Exam02();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
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
				break;
			case 3:
				try {
					Exam04 ex04 = new Exam04();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 4:
				Exam05 ex = new Exam05();
				break;
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {

	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}