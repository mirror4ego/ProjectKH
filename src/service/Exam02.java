package service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.OrderItemDao;


public class Exam02 extends JFrame {
	Container con; // 컨테이너 생성
	Font font = new Font("맑은 고딕", Font.BOLD, 16);

	Color[] color = { new Color(33,182,168), new Color(23,127,117), // 색상
			new Color(182,33,45), new Color(127,23,31),new Color(247,141,63), new Color(225,179,120), // 색상
			new Color(68,114,148), new Color(21,52,80) };

	String[] itemName = { "반반스틱치킨","반반윙치킨","레드윙치킨","레드콤보치킨","살살치킨","양념치킨","소이살살치킨","반반콤보치킨" };
	
	int[] data = new int[itemName.length];// {250,150,100,200}; // 차트의 값 저장배열 ,DB에서 누적된 값가져오기.
	int[] arcAngle = new int[itemName.length]; // 비율을계산,각으로변환
	JTextField[] tf = new JTextField[4]; // 텍스트필드
	ChartPanel chartPanel = new ChartPanel(); // 차트패널

	public Exam02() throws ClassNotFoundException, SQLException { // 생성자
		System.out.print(itemName.length);
		con = this.getContentPane(); // 컨테이너 갯
		setTitle("치킨 주문 비율");
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// contentPane.add(new InputPanel(), BorderLayout.NORTH);
		con.add(chartPanel, BorderLayout.CENTER);

		OrderItemDao dao = new OrderItemDao();
		for(int i=0;i<itemName.length;i++){
			data[i] = dao.sumOrderItemNum(itemName[i]);
		}

		setSize(700, 500);
		setVisible(true);
		drawChart(); // 차트 메소드 호출
	}

	void drawChart() { // 차트를 그린다
		int sum = 0; // 초기값 0
		for (int i = 0; i < data.length; i++) { // 데이터 값만큼 루프
			// data[i] = Integer.parseInt(tf[i].getText());
			sum += data[i];
		}
		if (sum == 0)
			return;

		for (int i = 0; i < data.length; i++) {
			arcAngle[i] = (int) Math.round((double) data[i] / (double) sum * 360);

			chartPanel.repaint(); // 차트패널의 PAINT호출
		}
	}

	class ChartPanel extends JPanel { // 차트 표시 패널

		public void paintComponent(Graphics g) {

			super.paintComponent(g);// 부모 패인트호출

			int startAngle = 0;
			int y=70;
			int j=0;
			for (int i = 0; i < data.length; i++) {
				g.setColor(color[i]);
				g.setFont(font);
				g.drawString(itemName[i] + "" + Math.round(arcAngle[i] * 100 / 360) + "%", 50 +(150*j++), y);
				if(i%4==3){
					j=0;
					y=y+30;
				}
			}
			y=y-10;
			for (int i = 0; i < data.length; i++) {
				g.setColor(color[i]);
				g.fillArc(180, y+50, 230, 230, startAngle, arcAngle[i]);
				startAngle = startAngle + arcAngle[i];
			}
		}
	}

}
