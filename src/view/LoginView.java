package view;

import java.awt.Color;
import java.awt.Cursor;
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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import service.LoginSevice;
import setting.SetLookAndFeel;
import setting.SetUiFont;
import view2.CRM_MainView2;
import view2.CustomerMainView;
import view2.MenuManageView;
import view2.OrderMainView;

// 현재시간을 보여줌
// 공지사항 작성


@SuppressWarnings("serial")
public class LoginView extends JFrame implements MouseListener, FocusListener {

	//변수 선언부 시작
	//패널 선언
	SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
	SetUiFont setUiFont = new SetUiFont();
	private JPanel jPanel1 = new JPanel() {
		public void paintComponent(Graphics g) {
			g.drawImage(imageIcon1.getImage(), 0, 0, null);
			setOpaque(false); //그림을 표시하게 설정,투명하게 조절
			super.paintComponent(g);}};
			private JPanel jPanel2 = new JPanel(new GridLayout(4,1));
			private JPanel jPanel3 = new JPanel(new GridLayout(2,2));
			private JPanel jPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT,23,17));
			private JPanel jPanel5 = new JPanel(new FlowLayout(FlowLayout.LEFT,23,17));
			private JPanel jPanel6 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,13));
			private JPanel jPanel7 = new JPanel(new GridLayout(1,2));
			private JPanel jPanel8 = new JPanel();

			//버튼
			private JButton jButton1 = new JButton("로그인", new ImageIcon("img/btLogin_hud.png"));
			private JButton jButton2 = new JButton("사용자관리", new ImageIcon("img/btLogin_hud.png"));
			private JButton jButton3 = new JButton("주문관리");
			private JButton jButton4 = new JButton("출퇴근관리");
			private JButton jButton5 = new JButton("데이터분석");
			private JButton jButton6 = new JButton("고객관리");
			private JButton button = new JButton("메뉴관리");

			//라벨
			private JLabel jLabel1 = new JLabel("User Login");
			private JLabel jLabel2 = new JLabel(); // 로그인 이미지
			private JLabel jLabel3 = new JLabel(); // 비밀번호 이미지
			private JLabel jLabel4 = new JLabel((new SimpleDateFormat("yyyy년MM월dd일")).format(new Date())); // 현재시간 라벨
			private JLabel jLabel5 = new JLabel(); // 선 긋는 용도의 라벨
			private JLabel jLabel6 = new JLabel();
			private JLabel jLabel7 = new JLabel();
			private JLabel jLabel8 = new JLabel("Welcome");
			private JLabel jLabel9 = new JLabel();

			//폰트
			private Font font1 = new Font("맑은 고딕", Font.BOLD, 25);
			private Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
			//그밖에
			private JLayeredPane jLayeredPane1 = new JLayeredPane();
			private JTextField jLoginTextField1 = new JTextField("아이디 입력", 15);
			private JTextArea jTextField1 = new JTextArea();
			private JPasswordField jPasswordField1 = new JPasswordField("비번 입력", 15);
			private ImageIcon imageIcon1 = new ImageIcon("img/login_background.jpg");
			//변수 선언부 끝

			//생성자
			public LoginView() {
				// 기본 컨테이너 설정
				this.setTitle("로그인 페이지");
				jPanel8.add(jButton6);
				jButton6.setOpaque(false);
				jButton6.setVisible(false);

				jButton3.setOpaque(false);
				jButton3.setVisible(false);
				jButton4.setOpaque(false);
				jButton4.setVisible(false);
				jButton5.setOpaque(false);
				jButton5.setVisible(false);
				jButton6.setEnabled(false);
				jButton3.setEnabled(false);
				jButton4.setEnabled(false);
				jButton5.setEnabled(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				getContentPane().setLayout(null);
				this.setSize(1600,900);
				this.setResizable(false);
				init();
				start();
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Dimension dimension1 = toolkit.getScreenSize();
				Dimension dimension2 = this.getSize();
				this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
						(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
				getContentPane().add(jLayeredPane1);
				this.setVisible(true);
				realTime();
			}

			public void init() {
				// 라벨
				jLabel1.setFont(font1);
				jLabel1.setForeground(Color.GRAY);
				jLabel2.setBounds(0, 0, 10, 10);
				jLabel2.setIcon(new ImageIcon("img/icon_user.png"));
				jLabel3.setIcon(new ImageIcon("img/icon_pw.png"));
				jLabel9.setForeground(Color.GRAY);
				jLabel9.setFont(new Font("맑은 고딕", Font.BOLD, 18));
				jLabel9.setBounds(313, 139, 301, 37);
				jLoginTextField1.setCaretColor(Color.CYAN);
				jLoginTextField1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

				// 로그인 필드
				jLoginTextField1.setOpaque(false);
				jLoginTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				jLoginTextField1.setFont(font2);
				jLoginTextField1.setForeground(Color.CYAN);
				jPasswordField1.setCaretColor(Color.CYAN);

				// 패스워드
				jPasswordField1.setOpaque(false);
				jPasswordField1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				jPasswordField1.setFont(font2);
				jPasswordField1.setForeground(Color.CYAN);

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
				jPanel2.setBounds(650, 150, 300, 260);
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
				jPanel7.setBackground(Color.DARK_GRAY);
				jPanel7.add(jButton1);

				// 로그인 버튼
				jButton1.setBorderPainted(true);
				jButton1.setFocusPainted(false);
				jButton1.setContentAreaFilled(false);
				jButton1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				jButton1.setForeground(Color.cyan);
				jPanel1.setLayout(null);

				// 레이아웃 설정
				jLayeredPane1.setBounds(0, 0, 1600, 900);
				jLayeredPane1.setLayout(null);
				jLayeredPane1.add(jPanel2);
				jLayeredPane1.add(jPanel1);
				jPanel1.add(jLabel9);
				jTextField1.setEditable(false);
				jTextField1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
				jTextField1.setForeground(Color.GRAY);
				jTextField1.setText("공지사항\r\n\r\n - 출퇴근 시 꼭 카드 찍기\r\n\r\n - 프로그램 사용 방법 숙지");
				jTextField1.setBounds(133, 264, 421, 246);
				jTextField1.setOpaque(false);
				jPanel1.add(jTextField1);
				jPanel8.setBounds(346, 580, 908, 116);
				jPanel8.setLayout(new GridLayout(1, 4, 0, 0));
				jPanel8.setOpaque(false);
				jPanel1.add(jPanel8);
				jButton6.setForeground(Color.GRAY);
				jButton6.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				jButton6.setFocusPainted(false);
				jButton6.setContentAreaFilled(false);
				jButton6.setBorderPainted(true);
				jPanel8.add(jButton3);
				jButton3.setForeground(Color.GRAY);
				jButton3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				jButton3.setFocusPainted(false);
				jButton3.setContentAreaFilled(false);
				jButton3.setBorderPainted(true);
				jPanel8.add(jButton4);
				jButton4.setForeground(Color.GRAY);
				jButton4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				jButton4.setFocusPainted(false);
				jButton4.setContentAreaFilled(false);
				jButton4.setBorderPainted(true);
				jPanel8.add(jButton5);
				jButton5.setForeground(Color.GRAY);
				jButton5.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				jButton5.setFocusPainted(false);
				jButton5.setContentAreaFilled(false);
				jButton5.setBorderPainted(true);
				jLabel5.setForeground(Color.LIGHT_GRAY);
				jLabel5.setBounds(133, 171, 335, 15);
				jLabel5.setOpaque(false);
				jLabel5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
				jPanel1.add(jLabel5);
				jLabel6.setOpaque(false);
				jLabel6.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY));
				jLabel6.setBounds(250, 147, 48, 24);
				jPanel1.add(jLabel6);
				jLabel7.setForeground(Color.GRAY);
				jLabel7.setFont(new Font("맑은 고딕", Font.BOLD, 18));
				jLabel7.setBounds(142, 139, 202, 37);
				jPanel1.add(jLabel7);
				jLabel8.setForeground(Color.GRAY);
				jLabel8.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 40));
				jLabel8.setBounds(133, 199, 224, 37);
				jPanel1.add(jLabel8);
				jButton2.setBounds(799, 408, 150, 60);
				jPanel1.add(jButton2);
				jButton2.setBorderPainted(true);
				jButton2.setFocusPainted(false);
				jButton2.setContentAreaFilled(false);
				jButton2.setFont(font2);
				jButton2.setForeground(Color.gray);
				button.setBounds(651, 408, 150, 60);
				jPanel1.add(button);
				button.setForeground(Color.GRAY);
				button.setFont(new Font("맑은 고딕", Font.BOLD, 15));
				button.setFocusPainted(false);
				button.setContentAreaFilled(false);
				button.setBorderPainted(true);
			}

			public void start() {
				jLoginTextField1.addMouseListener(this);
				jPasswordField1.addMouseListener(this);
				jPasswordField1.addFocusListener(this);
				jButton1.addMouseListener(this);
				jButton2.addMouseListener(this);
				jButton3.addMouseListener(this);
				jButton4.addMouseListener(this);
				jButton5.addMouseListener(this);
				jButton6.addMouseListener(this);
				button.addMouseListener(this);

			}

			public void realTime() {
				while(true){
					Calendar cal = Calendar.getInstance();
					String ampm;
					if(cal.get(Calendar.AM_PM)==0){
						ampm= "AM";
					}else{
						ampm= "PM";
					}
					String nowTime =
							ampm + " " +
									cal.get(Calendar.HOUR)+"시 "+
									cal.get(Calendar.MINUTE)+"분 "+
									cal.get(Calendar.SECOND)+"초 ";
					jLabel9.setText(nowTime);
					String nowDate =
							cal.get(Calendar.YEAR)+"년 "+
									(cal.get(Calendar.MONTH)+1)+"월 "+
									cal.get(Calendar.DATE)+"일 ";
					jLabel7.setText(nowDate);
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource()==jButton6) {
					try {
						CustomerMainView customerMainView = new CustomerMainView();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
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
							jButton6.setVisible(true);
							jButton3.setVisible(true);
							jButton4.setVisible(true);
							jButton5.setVisible(true);
							jButton6.setEnabled(true);
							jButton3.setEnabled(true);
							jButton4.setEnabled(true);
							jButton5.setEnabled(true);
						}else{
							JOptionPane.showMessageDialog(null, "로그인 실패");
							jButton6.setVisible(false);
							jButton3.setVisible(false);
							jButton4.setVisible(false);
							jButton5.setVisible(false);
							jButton6.setEnabled(false);
							jButton3.setEnabled(false);
							jButton4.setEnabled(false);
							jButton5.setEnabled(false);
						}

					}
					password = null;
				}

				if(e.getSource()==jButton2) {
					//사용자 관리 뷰를 띄움
					System.out.println("로그인 처리 로직");
					String id = jLoginTextField1.getText().trim();
					char[] pass = jPasswordField1.getPassword();
					String password = new String(pass);
					jLoginTextField1.setText("아이디 입력");
					jPasswordField1.setText("비밀번호 입력");
					if(id.equals("admin") && password.equals("1234")) {
						try {
							JOptionPane.showMessageDialog(null, "관리자 계정으로 접속하셨습니다");
							UserListView userListView = new UserListView();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "관리자 계정 접속 실패");
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "관리자 계정 접속 실패");
							e1.printStackTrace();
						}

					}else{JOptionPane.showMessageDialog(null, "관리자 계정 ID 또는 비밀번호가 일치하지 않음");}

				}else{}

				if(e.getSource()==button) {
					//사용자 관리 뷰를 띄움
					System.out.println("로그인 처리 로직");
					String id = jLoginTextField1.getText().trim();
					char[] pass = jPasswordField1.getPassword();
					String password = new String(pass);
					jLoginTextField1.setText("아이디 입력");
					jPasswordField1.setText("비밀번호 입력");
					if(id.equals("admin") && password.equals("1234")) {


						try {
							JOptionPane.showMessageDialog(null, "관리자 계정으로 메뉴관리 페이지에 접속하셨습니다");
							MenuManageView menuManageView = new MenuManageView();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "관리자 계정 접속 실패");
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "관리자 계정 접속 실패");
							e1.printStackTrace();
						}
					}else{JOptionPane.showMessageDialog(null, "관리자 계정 ID 또는 비밀번호가 일치하지 않음");}


				}else{}

				if(e.getSource()==jButton3) {
					OrderMainView orderMainView = new OrderMainView();
				}else{}
				
				if(e.getSource()==jButton5) {
					CRM_MainView2 cRm_MainView2 = new CRM_MainView2();
				}else{}
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
