package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	BufferedImage img = null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton jButton1;

	public LoginView() {
		this.setTitle("로그인 페이지");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1600,900);
		this.setResizable(true);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
		this.setVisible(true);
		// 레이아웃 설정
		setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1600, 900);
		layeredPane.setLayout(null);

		// 레이아웃에 이미지를 설정하는 패널 
		try{
			img = ImageIO.read(new File("img/login.png"));
		}catch (IOException e){
			System.out.println("이미지 불러오기 실패");
		}

		MyPanel panel = new MyPanel();

		panel.setBounds(0, 0, 1600, 900);

		// 로그인 필드
		loginTextField = new JTextField(15);
		loginTextField.setBounds(731, 399, 280, 30);
		layeredPane.add(loginTextField);
		loginTextField.setOpaque(false);
		loginTextField.setForeground(Color.green);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		// 패스워드
		passwordField = new JPasswordField(15);
		passwordField.setBounds(731, 529, 280, 30);
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.green);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(passwordField);

		// 로그인버튼 추가
		jButton1 = new JButton(new ImageIcon("img/btLogin_hud.png"));
		jButton1.setBounds(755, 689, 104, 48);

		// 버튼 투명처리
		jButton1.setBorderPainted(false);
		jButton1.setFocusPainted(false);
		jButton1.setContentAreaFilled(false);

		layeredPane.add(jButton1);

		// 마지막 추가들
		layeredPane.add(panel);
		add(layeredPane);
	}

	class MyPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

}
