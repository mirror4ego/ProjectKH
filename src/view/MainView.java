package view;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import projectKH.Customer;
import projectKH.CustomerDao;
import projectKH.DaoFactory;

class MainView extends JFrame implements ActionListener, KeyListener, FocusListener, MouseListener {
	
	//컨테이너
	private Container con;

	//버튼 객체 생성
	private JButton jButton1 = new JButton(" 고객 관리");
	private JButton jButton2 = new JButton(" 주문 관리");
	private JButton jButton3 = new JButton(" 직원 관리");
	private JButton jButton4 = new JButton(" 데이터 분석");
	private JButton jButton5 = new JButton("주문내역");
	private JButton jButton6 = new JButton("등록");
	private JButton jButton7 = new JButton("수정");
	private JButton jButton8 = new JButton("삭제");
	private JButton jButton9 = new JButton("Clear");
	private JButton jButton10 = new JButton("검색"); // 회원번호 검색 버튼
	private JButton jButton11 = new JButton("검색"); // 전화번호 검색 버튼
	private JButton jButton12 = new JButton("검색"); // 주소 검색 버튼
	
	//라벨 객체 생성
	private JLabel jLabel1 = new JLabel("회원번호 : ", JLabel.RIGHT);
	private JLabel jLabel2 = new JLabel("회원가입 날짜 : ", JLabel.RIGHT);
	private JLabel jLabel3 = new JLabel("전화번호 : ", JLabel.RIGHT);
	private JLabel jLabel4 = new JLabel("주소(특별시,광역시,도): ", JLabel.RIGHT);
	private JLabel jLabel5 = new JLabel("주소(시군구) : ", JLabel.RIGHT);
	private JLabel jLabel6 = new JLabel("주소(동면읍리) : ", JLabel.RIGHT);
	private JLabel jLabel7 = new JLabel("주소(나머지) : ", JLabel.RIGHT);
	private JLabel jLabel8 = new JLabel("고객 누적 주문 횟수 : ", JLabel.RIGHT);
	private JLabel jLabel9 = new JLabel("고객 나이 예측 : ", JLabel.RIGHT);
	private JLabel jLabel10 = new JLabel("주요 메뉴 : ", JLabel.RIGHT);  //choice추가
	private JLabel jLabel11 = new JLabel("음료 메뉴: ", JLabel.RIGHT);  //choice추가
	
	//텍스트필드 객체 생성
	private JTextField jTextField1 = new JTextField(14);//회원번호 입력창
	private JTextField jTextField2 = new JTextField(14);//회원가입날짜 입력창
	private JTextField jTextField3 = new JTextField(14);//전화번호 입력창
	private JTextField jTextField4 = new JTextField(14);//주소(특별시,광역시,도)의 입력창
	private JTextField jTextField5 = new JTextField(14);//주소(시군구)의 입력창
	private JTextField jTextField6 = new JTextField(14);//주소(동면읍리)의 입력창
	private JTextField jTextField7 = new JTextField(14);//주소(나머지)의 입력창
	private JTextField jTextField8 = new JTextField(14);//고객 누적 주문 횟수의 입력창
	private JTextField jTextField9 = new JTextField(14);//고객 누적 주문 횟수의 입력창

	//초이스 객체 생성
	private Choice choice1=new Choice();//주요메뉴 선택 choice
	private Choice choice2=new Choice();//음료메뉴 선택 choice
	private Choice choice3=new Choice();//주요메뉴 수량(quantity의 약자) 선택 choice
	private Choice choice4=new Choice();//음료 수량(quantity의 약자) 선택 choice

	//패널 객체 생성
	private JPanel jPanel1 = new JPanel(new GridLayout(1,4)); //메인의 맨 위쪽 메뉴 패널
	private JPanel jPanel2 = new JPanel(new BorderLayout(3, 3)); //
	private JPanel jPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel jPanel4 = new JPanel(new GridLayout(1, 4, 3, 3));
	private JPanel jPanel5 = new JPanel(new BorderLayout());
	private JPanel jPanel6 = new JPanel(new GridLayout(9, 2));
	private JPanel jPanel7 = new JPanel(new GridLayout(9, 1));
	private JPanel jPanel8 = new JPanel(new GridLayout(11, 1));
	private JPanel jPanel9 = new JPanel(new GridLayout(1, 2)); //주요메뉴 choice 패널
	private JPanel jPanel10 = new JPanel(new GridLayout(1, 2)); //음료메뉴 choice 패널

	//그밖의 구성 객체 생성
	private JTextArea jTextArea1 = new JTextArea(15, 40); // 주문내역 상세 내역이 들어가는 텍스트에리아
	private JScrollPane jScrollPane1 = new JScrollPane(jTextArea1); //텍스트에리아1 창의 길이를 넘어서 데이터가 있을때 스크롤 할수 있는 객체 
	private Font font1 = new Font("맑은 고딕", Font.BOLD, 15); // 메뉴에 설정될 폰트
	
	MainView (String viewTitle) {
		super(viewTitle);
		this.init();
		this.start();
		this.setSize(1000,600);
		this.setResizable(true);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
		this.setVisible(true);
	}


	public void start() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//마우스클릭 리스너 관리
		jButton1.addMouseListener(this); //주문내역 보기
		jButton2.addMouseListener(this); //주문내역 보기
		jButton3.addMouseListener(this); //주문내역 보기
		jButton4.addMouseListener(this); //주문내역 보기
		
		//액션리스너 관리
		jButton5.addActionListener(this); //주문내역 보기
		jButton6.addActionListener(this); //등록
		jButton7.addActionListener(this); //수정
		jButton8.addActionListener(this); //삭제
		jButton9.addActionListener(this); //Clear
	}
	
	void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout(5, 5));

		//메인 보더레이아웃의 north영역 설정 시작
		jButton1.setIcon(new ImageIcon("customer.png"));
		jButton2.setIcon(new ImageIcon("order.png"));
		jButton3.setIcon(new ImageIcon("employee.png"));
		jButton4.setIcon(new ImageIcon("data.png"));

		jButton1.setFont(font1);
		jButton2.setFont(font1);
		jButton3.setFont(font1);
		jButton4.setFont(font1);

		jButton1.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton2.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton3.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton4.setBorder(new BevelBorder(BevelBorder.RAISED));

		jPanel1.add("North", jButton1);
		jPanel1.add("North", jButton2);
		jPanel1.add("North", jButton3);
		jPanel1.add("North", jButton4);

		con.add("North", jPanel1);
		//메인 보더레이아웃의 north영역 설정 끝

		//메인 보더레이아웃의 east영역 설정 시작
		jPanel3.add(jButton5);
		jPanel2.add("North", jPanel3);
		
		jPanel2.add("Center", jScrollPane1);
		
		jPanel4.add(jButton6);
		jPanel4.add(jButton7);
		jPanel4.add(jButton8);
		jPanel4.add(jButton9);
		jPanel2.add("South", jPanel4);
		
		jButton5.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton6.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton7.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton8.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton9.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton5.setEnabled(true);
		jButton6.setEnabled(true);
		jButton7.setEnabled(true);
		jButton8.setEnabled(true);
		jButton9.setEnabled(true);
		
		jPanel2.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "주문내역확인"));
		con.add("Center", jPanel2);
		//메인 보더레이아웃의 east영역 설정 끝
		
		//메인 보더레이아웃의 west영역 설정 시작
		//고객 관리 패널 구성 시작
		jPanel6.add(jLabel1);  //회원번호 라벨
		jPanel6.add(jTextField1);	//회원번호 입력창
		jPanel6.add(jLabel2);  //회원가입날짜 라벨
		jPanel6.add(jTextField2);	//주문날짜 입력창
		jPanel6.add(jLabel3); //전화번호 라벨
		jPanel6.add(jTextField3);	//전화번호 입력창
		jPanel6.add(jLabel4);  //주소(특별시,광역시,도)라벨
		jPanel6.add(jTextField4);	//주소(특별시,광역시,도)의 입력창 
		jPanel6.add(jLabel5);  //주소(시군구)라벨
		jPanel6.add(jTextField5);	//주소(시군구)의 입력창
		jPanel6.add(jLabel6);  //주소(동면읍리)라벨
		jPanel6.add(jTextField6);	//주소(동면읍리)의 입력창
		jPanel6.add(jLabel7);  //주소(나머지)라벨
		jPanel6.add(jTextField7);	//주소(나머지)의 입력창
		jPanel6.add(jLabel8);  //고객 누적 주문 횟수라벨
		jPanel6.add(jTextField8);	//고객 누적 주문 횟수의 입력창
		jPanel6.add(jLabel9);  //고객 나이 예측라벨
		jPanel6.add(jTextField9);	//고객 누적 주문 횟수의 입력창
		
		jPanel6.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "고객정보"));
		//고객 관리 패널 구성 끝	

		//주문 관리 패널 구성 시작
		jPanel9.add(jLabel10);  //주요메뉴 라벨
		jPanel10.add(jLabel11);  //음료 메뉴 라벨
		
		jPanel9.add(choice1);	//주요메뉴 choice
		choice1.add("후라이드 치킨");	//주요메뉴choice에 들어가는 선택지
		choice1.add("양념 치킨");
		choice1.add("마늘 치킨");
		choice1.add("간장 치킨");
		choice1.add("양파 치킨");
		jPanel9.add(choice3);	//수량 choice
		for(int i=1;i<101;i++) { choice3.add(i+"개"); }	//수량choice에 들어가는 선택지

		jPanel10.add(choice2);	//음료메뉴 choice
		choice2.add("사이다");	//음료메뉴choice에 들어가는 선택지
		choice2.add("콜라");
		choice2.add("맥주");
		choice2.add("소주");
		jPanel10.add(choice4);	//수량2 choice
		for(int i=1;i<101;i++) { choice4.add(i+"개"); }	//수량2choice에 들어가는 선택지
		
		jPanel8.add(jPanel9);
		jPanel8.add(jPanel10);
	
		jPanel8.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "주문정보"));
		//주문 관리 패널 구성 끝
		

		jPanel5.add("Center", jPanel6);
		jPanel5.add("South", jPanel8);
		
		con.add("West", jPanel5);
		jTextArea1.setEnabled(true);

		jTextArea1.setDisabledTextColor(Color.black);
		//메인 보더레이아웃의 west영역 설정 끝
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jButton6){
			System.out.println("등록 버튼 클릭");
			int customerNum = Integer.parseInt(jTextField1.getText().trim()); //회원번호 입력창
			String customerRegDate = jTextField2.getText().trim(); //고객 등록날짜 입력창
			String customerPhoneNum = jTextField3.getText().trim(); //전화번호 입력창
			String customerAddState = jTextField4.getText().trim(); //주소(특별시,광역시,도)의 입력창
			String customerAddCity = jTextField5.getText().trim(); //주소(시군구)의 입력창
			String customerAddStreet = jTextField6.getText().trim(); //주소(동면읍리)의 입력창
			String customerAddRest = jTextField7.getText().trim(); //주소(나머지)의 입력창
			int customerFrequent = Integer.parseInt(jTextField8.getText().trim()); //고객 누적 주문 횟수의 입력창
			int customerAgePredict = Integer.parseInt(jTextField9.getText().trim()); //고객 누적 주문 횟수의 입력창
			//OrderInfoDao 
			CustomerDao customerDao = new DaoFactory().customerDao();
			Customer customer01= new Customer(customerNum, customerRegDate, customerPhoneNum, customerAddState,
					customerAddCity, customerAddStreet, customerAddRest, customerFrequent, customerAgePredict);
			try{
				customerDao.add(customer01);
				System.out.println("등록완료");
			}catch(Exception e1){System.out.println("등록 이상동작 발생");};

		}else{
			System.out.println("버튼 이상동작 발생");
		}
	}
	
	@Override
	public void focusGained(FocusEvent e) {}
	@Override
	public void focusLost(FocusEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}