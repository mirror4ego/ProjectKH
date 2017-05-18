package service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.OrderInfoDao;


public class Exam02 extends JFrame {
	Container contentPane; // 컨테이너 생성
	int[] data = new int[4];// {250,150,100,200}; // 차트의 값 저장배열 ,DB에서 누적된 값가져오기.
	int[] arcAngle = new int[4]; // 비율을계산,각으로변환

	Color[] color = { Color.RED, Color.BLUE, // 색상
			Color.MAGENTA, Color.ORANGE };

	String[] itemName = { "양념", "후라이드", // 비교대상, DB_name
			"간장", "크림" };

	JTextField[] tf = new JTextField[4]; // 텍스트필드
	ChartPanel chartPanel = new ChartPanel(); // 차트패널

	public Exam02() throws ClassNotFoundException, SQLException { // 생성자
		setTitle("치킨 주문 비율");
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = getContentPane(); // 컨테이너 갯
		// contentPane.add(new InputPanel(), BorderLayout.NORTH);
		contentPane.add(chartPanel, BorderLayout.CENTER);

		OrderInfoDao dao = new OrderInfoDao();
		data[0] = dao.sumOrderMenu(1);
		data[1] = dao.sumOrderMenu(2);
		data[2] = dao.sumOrderMenu(3);
		data[3] = dao.sumOrderMenu(4);
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
