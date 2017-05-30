package service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.OrderItemDao;


public class Exam02 extends JFrame {
	Container con; // 컨테이너 생성
	int[] data = new int[4];// {250,150,100,200}; // 차트의 값 저장배열 ,DB에서 누적된 값가져오기.
	int[] arcAngle = new int[4]; // 비율을계산,각으로변환

	Color[] color = { Color.RED, Color.BLUE, // 색상
			Color.MAGENTA, Color.ORANGE };

	String[] itemName = { "양념치킨", "후라이드", // 비교대상, DB_name
			"간장치킨", "크림치킨" };

	JTextField[] tf = new JTextField[4]; // 텍스트필드
	ChartPanel chartPanel = new ChartPanel(); // 차트패널

	public Exam02() throws ClassNotFoundException, SQLException { // 생성자
		con = this.getContentPane(); // 컨테이너 갯
		setTitle("치킨 주문 비율");
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// contentPane.add(new InputPanel(), BorderLayout.NORTH);
		con.add(chartPanel, BorderLayout.CENTER);

		OrderItemDao dao = new OrderItemDao();
		data[0] = dao.sumOrderItemNum("양념치킨");
		data[1] = dao.sumOrderItemNum("후라이드");
		data[2] = dao.sumOrderItemNum("간장치킨");
		data[3] = dao.sumOrderItemNum("크림치킨");
		setSize(500, 350);
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

			for (int i = 0; i < data.length; i++) {
				g.setColor(color[i]);
				g.drawString(itemName[i] + "" + Math.round(arcAngle[i] * 100 / 360) + "%", 50 + i * 100, 20);
			}

			for (int i = 0; i < data.length; i++) {
				g.setColor(color[i]);
				g.fillArc(150, 50, 200, 200, startAngle, arcAngle[i]);
				startAngle = startAngle + arcAngle[i];
			}
		}
	}

}
