package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import service.LoginSevice;

// 현재시간을 보여줌
// 공지사항 작성


@SuppressWarnings("serial")
public class LoginView extends JFrame implements MouseListener, FocusListener {

	JTextField jLoginTextField1 = new JTextField("아이디 입력", 15);

	JPasswordField jPasswordField1 = new JPasswordField("비번 입력", 15);

	JButton jButton1 = new JButton("로그인", new ImageIcon("img/btLogin_hud.png"));
	JButton jButton2 = new JButton("사용자관리", new ImageIcon("img/btLogin_hud.png"));
	ImageIcon imageIcon1 = new ImageIcon("img/login_background.jpg");

	JPanel jPanel1 = new JPanel() {
		public void paintComponent(Graphics g) {
			g.drawImage(imageIcon1.getImage(), 0, 0, null);
			setOpaque(false); //그림을 표시하게 설정,투명하게 조절
			super.paintComponent(g);
		}
	};
	JPanel jPanel2 = new JPanel(new GridLayout(4,1));
	JPanel jPanel3 = new JPanel(new GridLayout(2,2));
	JPanel jPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT,23,17));
	JPanel jPanel5 = new JPanel(new FlowLayout(FlowLayout.LEFT,23,17));
	JPanel jPanel6 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,13));
	JPanel jPanel7 = new JPanel(new GridLayout(1,2));

	JLabel jLabel1 = new JLabel("User Login");
	JLabel jLabel2 = new JLabel(); // 로그인 이미지
	JLabel jLabel3 = new JLabel(); // 비밀번호 이미지
	JLabel jLabel4 = new JLabel((new SimpleDateFormat("yyyy년MM월dd일")).format(new Date())); // 현재시간 라벨

	private Font font1 = new Font("맑은 고딕", Font.BOLD, 25);
	private Font font2 = new Font("맑은 고딕", Font.BOLD, 15);


	JLayeredPane jLayeredPane1 = new JLayeredPane();


	public LoginView() {
		// 기본 컨테이너 설정
		this.setTitle("로그인 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(1600,900);
		this.setResizable(false);
		init();
		start();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
		this.add(jLayeredPane1);
		this.setVisible(true);
	}

	public void init() {

		// 이미지
		try {
			BufferedImage image1 = ImageIO.read(new File("img/login_background.jpg"));
			BufferedImage image2 = ImageIO.read(new File("img/employee.png")); //로그인 버튼 이미지
			BufferedImage image3 = ImageIO.read(new File("img/login_bkg_highlight_top.png")); //패널1의 위쪽 이미지
			BufferedImage image4 = ImageIO.read(new File("img/login_bkg_highlight_bottom.png")); //패널1의 아래쪽 이미지
			BufferedImage image5 = ImageIO.read(new File("img/icon_user.png")); //패널1의 로그인 아이콘 이미지
			BufferedImage image6 = ImageIO.read(new File("img/icon_pw.png")); //패널1의 비밀번호 아이콘 이미지
		} catch (IOException e) {e.printStackTrace();}

		// 라벨
		jLabel1.setFont(font1);

		jLabel1.setForeground(Color.GRAY);
		jLabel2.setBounds(0, 0, 10, 10);
		jLabel2.setIcon(new ImageIcon("img/icon_user.png"));
		jLabel3.setIcon(new ImageIcon("img/icon_pw.png"));

		// 로그인 필드
		jLoginTextField1.setOpaque(false);
		jLoginTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jLoginTextField1.setFont(font2);
		jLoginTextField1.setForeground(Color.GRAY);

		// 패스워드
		jPasswordField1.setOpaque(false);
		jPasswordField1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jPasswordField1.setFont(font2);
		jPasswordField1.setForeground(Color.GRAY);

		// 로그인 버튼
		jButton1.setBorderPainted(true);
		jButton1.setFocusPainted(false);
		jButton1.setContentAreaFilled(false);
		jButton1.setFont(font2);
		jButton1.setForeground(Color.cyan);
		jButton2.setBorderPainted(true);
		jButton2.setFocusPainted(false);
		jButton2.setContentAreaFilled(false);
		jButton2.setFont(font2);
		jButton2.setForeground(Color.gray);
		jPanel7.setBackground(Color.DARK_GRAY);


		// 패널 설정
		jPanel1.setBounds(0, 0, 1600, 900);
		jPanel1.setOpaque(true);
		jPanel4.add(jLabel2);
		jPanel4.add(jLoginTextField1);
		jPanel4.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.DARK_GRAY));
		jPanel5.add(jLabel3);
		jPanel5.add(jPasswordField1);
		jPanel5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
		jPanel3.setOpaque(false);
		jPanel6.add(jLabel1);
		jPanel7.add(jButton2);
		jPanel7.add(jButton1);
		jPanel2.setBounds(650, 320, 300, 260);
		jPanel2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		jPanel2.add(jPanel6);
		jPanel2.add(jPanel4);
		jPanel2.add(jPanel5);
		jPanel2.add(jPanel7);
		jPanel2.setBackground(Color.black);
		jPanel2.setOpaque(false); // false로 하면 패널 2 투명
		jPanel4.setOpaque(false);
		jPanel5.setOpaque(false);
		jPanel6.setOpaque(false);
		jPanel7.setOpaque(false);
		
		//jPanel2.add(jLabel4);

		// 레이아웃 설정
		jLayeredPane1.setBounds(0, 0, 1600, 900);
		jLayeredPane1.setLayout(null);

		jLayeredPane1.add(jPanel2);
		jLayeredPane1.add(jPanel1);
	}

	public void start() {
		jLoginTextField1.addMouseListener(this);
		jPasswordField1.addMouseListener(this);
		jPasswordField1.addFocusListener(this);
		jButton1.addMouseListener(this);
		jButton2.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==jLoginTextField1) {
			jLoginTextField1.setText("");
		}else{}

		if(e.getSource()==jPasswordField1) {
			jPasswordField1.setText("");
		}else{}

		if(e.getSource()==jButton1) {
			//로그인 처리 로직
			System.out.println("로그인 처리 로직");
			String id = jLoginTextField1.getText().trim();
			char[] pass = jPasswordField1.getPassword();
			String password = new String(pass);

			if(id.equals("") || pass.equals("")){
				//아이디 또는 패스워드 미입력 
				JOptionPane.showMessageDialog(null, "아이디 또는 패스워드 미입력");
			}else{
				boolean existLogin = false;
				try {
					existLogin = LoginSevice.login(id, password);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (existLogin) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					try {
						MainView mainView = new MainView();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					this.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}

			}
			password = null;
		}

		if(e.getSource()==jButton2) {
			//사용자 관리 뷰를 띄움
			System.out.println("사용자 관리 뷰 띄우기");
			try {
				UserListView userListView = new UserListView();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else{}
	}

	private void EXIT_ON_CLOSE() {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==jPasswordField1) {
			jPasswordField1.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}


}
