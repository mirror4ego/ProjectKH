package service;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exam04 extends JPanel {
	private int[] values;
	private int[] values2;
	private String[] names;
	private String title;

	public Exam04(String title) {
		this.setSize(400, 300);
		int[] values = new int[3];
		String[] names = new String[3];
		int[] values2 = new int[3];

		values[0] = 15;
		values2[0] = 10;
		names[0] = "20대";

		values[1] = 20;
		values2[1] = 15;
		names[1] = "30대";

		values[2] = 20;
		values2[2] = 5;
		names[2] = "40대"; // values에 연령별 총계 입력. 학생 청년 중년
		this.title = title;
		this.values = values;
		this.values2 = values2;
		this.names = names;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (values == null || values.length == 0)
			return;
		double minValue = 0;
		double maxValue = 0;
		for (int i = 0; i < values.length; i++) {
			if (minValue > values[i])
				minValue = values[i];
			if (maxValue < values[i])
				maxValue = values[i];
		}

		Dimension d = getSize();
		int clientWidth = d.width;
		int clientHeight = d.height;
		int barWidth = clientWidth / values.length;

		Font titleFont = new Font("SansSerif", Font.BOLD, 20);
		FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
		Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
		FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

		int titleWidth = titleFontMetrics.stringWidth(title);
		int y = titleFontMetrics.getAscent();
		int x = (clientWidth - titleWidth) / 2;
		g.setFont(titleFont);
		g.drawString(title, x, y);

		int top = titleFontMetrics.getHeight();
		int bottom = labelFontMetrics.getHeight();
		if (maxValue == minValue)
			return;
		double scale = (clientHeight - top - bottom) / (maxValue - minValue);
		y = clientHeight - labelFontMetrics.getDescent();
		g.setFont(labelFont);

		for (int i = 0; i < values.length; i++) {

			int valueX = i * barWidth + 1;
			int valueY = top;

			int height = (int) (values[i] * scale);
			if (values[i] >= 0)
				valueY += (int) ((maxValue - values[i]) * scale);

			g.setColor(Color.red);
			g.fillRect(valueX + 40, valueY - values2[i], barWidth - 80, height - values2[i]);
			g.setColor(Color.black);
			g.drawRect(valueX + 40, valueY - values2[i], barWidth - 80, height);

			g.setColor(Color.blue);
			g.fillRect(valueX + 40, valueY + values2[i], barWidth - 80, height - values2[i]);
			g.setColor(Color.black);
			g.drawRect(valueX + 40, valueY + values2[i], barWidth - 80, height - values2[i]);

			int labelWidth = labelFontMetrics.stringWidth(names[i]);
			x = i * barWidth + (barWidth - labelWidth) / 2;
			g.drawString(names[i], x, y);
		}
	}

}