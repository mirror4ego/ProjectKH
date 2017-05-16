package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UserSelectView extends JFrame implements ActionListener {
	JScrollPane scrollPane;
	ImageIcon icon;
	JButton button1 = new JButton("직원 목록");
	JButton button2 = new JButton("출결 관리");

	public UserSelectView() {
		super("배경 사진");
		icon = new ImageIcon("img/gubook.jpg");
		start();
		//배경 Panel 생성후 컨텐츠페인으로 지정      
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(icon.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				// Dimension d = getSize();
				// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); //그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};


		background.add(button1);
		background.add(button2);
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);
		setSize(200,200);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		

	}

	void start() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==button1){
			System.out.println("직원 목록");
			 // 버튼을 눌렀을때 버튼 객체의 출력된 매개변수 값과 비교

				try {
					UserListView userListView = new UserListView();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			return;
		}
		if(e.getSource()==button2){
			System.out.println("출결 관리");
			System.out.println("출력 : 버튼2를 누르셨습니다");

			AttendanceView attendanceView = new AttendanceView();

			return;
		}
	}

	public static void main(String[] args) {
		UserSelectView frame = new UserSelectView();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}

