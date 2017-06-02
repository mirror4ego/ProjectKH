package view2;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import service.Exam02;
import service.Exam03;
import service.Exam04;
import service.Exam05;
import service.Exam06;
import setting.SetLookAndFeel;
import setting.SetUiFont;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CRM_MainView extends JFrame implements MouseListener,ActionListener{

	private SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
	private SetUiFont setUiFont = new SetUiFont();

	private JPanel panel_7 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JLabel lblNewLabel_4 = new JLabel("데이터리스트");
	private JLabel label_1 = new JLabel("고객정보를 입력하고 데이터을 조회합니다");

	private JTable jTable2 = new JTable();

	private JButton button = new JButton("선택된 데이터 삭제");
	private JLabel label_9 = new JLabel("검색결과 :");
	private JTextField textField = new JTextField();
	private JLabel label_10 = new JLabel("개");

	private JTextArea textArea = new JTextArea();



	private JPanel panel_1 = new JPanel();
	private JPanel panel_3 = new JPanel();

	private JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);

	///*
	//private JLabel label_2 = new JLabel("소계");
	//private JLabel label_3 = nw JLabel("합계");
	//private JLabel label_4 = new JLabel("할인");

	private JPanel panel_A = new JPanel();
	private JPanel panel_B = new JPanel();
	private JPanel panel_C = new JPanel();
	private JPanel panel_D = new JPanel();
	private JPanel panel_E = new JPanel();
	//*/
	private JPanel panel_10 = new JPanel();
	
	
	private JTextArea JTextArea_A = new JTextArea(
			"치킨 종류별 주문량 그래프입니다 \n"
			+ "치킨의 종류별로 총량 대비양을 퍼센트로 표시합니다.\n"
			+ "각 퍼센트를 차지하는 원 그래프를 그리며 글씨 색과 동일합니다\n"
			+ "인기 순 상위 8개 종류만 분석합니다.\n" 
			,5,40);
	private JTextArea JTextArea_B = new JTextArea(
			"월별 주문량 누적 그래프입니다 \n"
			+ "월별 인기 순 3위이내로 주문되는 치킨의 누적 개수를 그래프로 표시합니다\n"
			+ "개업한지 얼마 되지않아 데이터가 모자랍니다. \n ",5,40);
	private JTextArea JTextArea_C = new JTextArea(
			"세대별 주문량 그래프입니다 \n"
			+ "총 주문 횟수가 아닌 고객별 주문 횟수를 카운트 합니다.\n"
			+ "첫번째 그래프는 20-30대 청년층,\n "
			+ "두번째 그래프는 40-50대 중년층,\n"
			+ "세번째 그래프는 60-70대 장년층입니다.\n"
			+ "붉은색은 여성고객, 파란색은 남성고객을 나타냅니다.",5,40);
	private JTextArea JTextArea_D = new JTextArea(
			"고객 재방문률 그래프입니다.\n"
			+ "누적된 고객의 방문 횟수를 퍼센트로 표현합니다.\n"
			+ "예를들어 5를 입력하고 확인을 클릭하시면\n"
			+ "5회 이상주문한 고객의 퍼센트를 이상-이하로 표시하여 나타냅니다\n"
			+ "2를 입력하시면 최소 한번이상 재방문한 고객의 비율을 나타내며\n"
			+ "이하는 재방문 하지 않은 고객의 비율을 나타낸다는점 참고해주시기 바랍니다\n",5,40);
	private JTextArea JTextArea_E = new JTextArea(
			"주문지역별 주문량을 나타내는 그래프입니다.\n"
			+ "고객의 주소를 분석해 주문량을 가시적으로 표현합니다.\n"
			+ "칭찬스티커 아닙니다.",5,40);
	
	private JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
	private JButton button_A = new JButton("치킨 종류별 주문량 그래프");
	private JButton button_B = new JButton("월별 주문량 누적 그래프");
	private JButton button_C = new JButton("세대별 주문량 그래프");
	private JButton button_D = new JButton("재방문률");
	private JButton button_E = new JButton("주문지역별 주문량");
	 ImageIcon imageA,imageB,imageC,imageD,imageE;
	 JLabel lb_A,lb_B,lb_C,lb_D,lb_E;
	
	/*
	private JLabel label_28 = new JLabel("현금");
	private JTextField textField_7 = new JTextField();
	private JTextField textField_8 = new JTextField();
	private JLabel label_29 = new JLabel("카드");
	private JTextField textField_9 = new JTextField();
	private JLabel label_30 = new JLabel("미수금");
	
*/	
	private JButton button_2 = new JButton("닫기");
	private JPanel panel_11 = new JPanel();

	
	private JPanel panel_12 = new JPanel();
	private JLabel label_7 = new JLabel("데이터 관리");
	private JLabel label_8 = new JLabel("데이터를 관리(검색, 삭제) 하는 곳입니다.");
	private final JLabel label_32 = new JLabel();

	public CRM_MainView() {
		super("데이터분석");
		SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
		SetUiFont setUiFont = new SetUiFont();
		this.init();
		this.start();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(710,720);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
	}
	void init() {
		
		
		jTable2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));

		jTable2.setBounds(12, 172, 347, 367);
		panel_2.add(jTable2);
		button.setBounds(101, 550, 146, 31);

		panel_2.add(button);
		label_9.setBounds(12, 141, 57, 15);

		panel_2.add(label_9);
		textField.setColumns(10);
		textField.setBounds(76, 139, 42, 19);

		panel_2.add(textField);
		label_10.setBounds(126, 141, 57, 15);

		panel_2.add(label_10);
		textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(12, 10, 347, 114);

		panel_2.add(textArea);

		panel_7.setBackground(Color.YELLOW);
		panel_7.setBounds(-2, 0, 1280, 55);

		panel_7.setLayout(null);

		lblNewLabel_4.setBounds(88, 6, 133, 20);
		panel_7.add(lblNewLabel_4);

		label_1.setBounds(88, 28, 297, 20);
		panel_7.add(label_1);

		panel_12.setLayout(null);
		panel_12.setBackground(Color.RED);
		panel_12.setBounds(0, 0, 1280, 55);
		getContentPane().add(panel_12);


		label_7.setForeground(Color.WHITE);
		label_7.setBounds(88, 6, 133, 20);
		panel_12.add(label_7);


		label_8.setForeground(Color.LIGHT_GRAY);//주문서를 관리(검색, 삭제) 하는 곳입니다.
		label_8.setBounds(88, 28, 297, 20);
		panel_12.add(label_8);
		label_32.setBounds(35, 12, 32, 32);
		label_32.setIcon(new ImageIcon("img/computer.png"));
		
		panel_12.add(label_32);
		panel_1.setLayout(null);
		panel_1.setBounds(0, 62, 506, 620);

		getContentPane().add(panel_1);
		panel_3.setBounds(0, 6, 263, 25);
///////////////
		
		tabbedPane_2.setBounds(10, 6, 484, 610);

		panel_1.add(tabbedPane_2);
		

		
		tabbedPane_2.addTab("ㅇ종류별", null,panel_A, null);//a통계
		panel_A.add(JTextArea_A);
		//ImageIcon객체를 생성
		ImageIcon originIcon = new ImageIcon("img/1.png");  
		//ImageIcon에서 Image를 추출
		Image originImg = originIcon.getImage(); 
		//추출된 Image의 크기를 조절하여 새로운 Image객체 생성
		Image changedImg= originImg.getScaledInstance(500, 500, Image.SCALE_SMOOTH );
		//새로운 Image로 ImageIcon객체를 생성
		ImageIcon Icon = new ImageIcon(changedImg);
		  lb_A = new JLabel(Icon,JLabel.CENTER);
		  panel_A.add(lb_A);
		
		tabbedPane_2.addTab("ㅇ 월별", null, panel_B, null);//b통계
		panel_B.add(JTextArea_B);
		originIcon = new ImageIcon("img/2.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(500, 500, Image.SCALE_SMOOTH );
		Icon = new ImageIcon(changedImg);
		  lb_B = new JLabel(Icon,JLabel.CENTER);
		  panel_B.add(lb_B);
		  
		tabbedPane_2.addTab("ㅇ 세대별", null, panel_C, null);//c통계
		panel_C.add(JTextArea_C);
		originIcon = new ImageIcon("img/3.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(500, 500, Image.SCALE_SMOOTH );
		Icon = new ImageIcon(changedImg);
		  lb_C = new JLabel(Icon,JLabel.CENTER);
		  panel_C.add(lb_C);
		  
		tabbedPane_2.addTab("ㅇ 재방문률", null, panel_D, null);//d통계
		panel_D.add(JTextArea_D);
		
		originIcon = new ImageIcon("img/4.png");  
		
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(500, 500, Image.SCALE_SMOOTH );
		Icon = new ImageIcon(changedImg);
		  lb_D = new JLabel(Icon,JLabel.CENTER);
		  panel_D.add(lb_D);
		  
		tabbedPane_2.addTab("ㅇ주문지역별", null, panel_E, null);//e통계
		panel_E.add(JTextArea_E);
		originIcon = new ImageIcon("img/5.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(500, 500, Image.SCALE_SMOOTH );
		Icon = new ImageIcon(changedImg);
		  lb_E = new JLabel(Icon,JLabel.CENTER);
		  panel_E.add(lb_E);
		  
		  
		  
		/*
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_26.setBackground(Color.GRAY);
		label_26.setAlignmentX(0.5f);
		label_26.setBounds(12, 10, 67, 25);

		panel_9.add(label_26);
*/
		
	//////데이터 버튼부분
		//tabbedPane_4.setBounds(912, 169, 180, 241);
		tabbedPane_4.setBounds(510, 62, 180, 400);
		getContentPane().add(tabbedPane_4);//////데이터 버튼부분
		tabbedPane_4.addTab("ㅇ데이터분석", null, panel_10, null);
		panel_10.setLayout(null);
		panel_10.setLayout(new GridLayout(5, 1, 2, 2));
		panel_10.add(button_A);
		panel_10.add(button_B);
		panel_10.add(button_C);
		panel_10.add(button_D);
		panel_10.add(button_E);
		
		//출력,삭제,닫기 부분 버튼
		panel_11.setBounds(510, 588, 180, 90);
		getContentPane().add(panel_11);
		panel_11.setLayout(new GridLayout(1,1));
		panel_11.add(button_2);
	}
	void start() {
		button_2.addMouseListener(this);
		button_A.addActionListener(this);
		button_B.addActionListener(this);
		button_C.addActionListener(this);
		button_D.addActionListener(this);
		button_E.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==button_2){
			this.dispose();
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button_A){
			try {
				Exam02 ex02= new Exam02();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==button_B){
			javafx.application.Application.launch(Exam03.class);
		}else if(e.getSource()==button_C){
			try {
				Exam04 ex04 = new Exam04();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==button_E){
			Exam05 ex = new Exam05();
		}else if(e.getSource()==button_D){
			try {
				Exam06 ex = new Exam06();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}


