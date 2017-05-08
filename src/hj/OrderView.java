package hj;

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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;




class OrderView_sub extends JFrame
implements ActionListener, KeyListener, FocusListener
{
	private Container con; // 컨테이너
	private BorderLayout mainBorderLayout = new BorderLayout(5, 5);

	private JButton button1 = new JButton(" 고객 관리");
	private JButton button2 = new JButton(" 주문 관리");
	private JButton button3 = new JButton(" 직원 관리");
	private JButton button4 = new JButton(" 데이터 분석");
	
	private JButton button5 = new JButton("고객 등록");
	
	private JTextArea textArea1 = new JTextArea("textArea1");
	private JTextArea textArea2 = new JTextArea("textArea2");
	private JTextArea textArea3 = new JTextArea("textArea3");
	private JTextArea textArea4 = new JTextArea("textArea4");
	
	private JTextField jTextField1 = new JTextField("");
	private JTextField jTextField2 = new JTextField("");
	private JTextField jTextField3 = new JTextField("");
	private JTextField jTextField4 = new JTextField("");
	private JTextField jTextField5 = new JTextField("");
	private JTextField jTextField6 = new JTextField("");
	private JTextField jTextField7 = new JTextField("");
	private JTextField jTextField8 = new JTextField("");
	private JTextField jTextField9 = new JTextField("");

	
	//오른쪽 화면구성 요소
	private Container con1;
	private BorderLayout bl = new BorderLayout(5, 5);
	private JLabel jlb = new JLabel("<== 이것을 누르면 주문내용보기가 됩니다.");
	private JButton jbt = new JButton("주문내역");
	private JTextArea jta = new JTextArea(15, 40);
	private JScrollPane jsp = new JScrollPane(jta);

	//오른쪽 하단 버튼 변수 지정
	private JButton jbt1 = new JButton("등록");
	private JButton jbt2 = new JButton("수정");
	private JButton jbt3 = new JButton("삭제");
	private JButton jbt4 = new JButton("Clear");
	private JButton jbt5 = new JButton("저장");
	private JButton jbt6 = new JButton("로드");
	private JButton jbt7 = new JButton("종료");
	//왼쪽 상단 화면구성-라벨
	private JLabel lb = new JLabel("회원번호 : ", JLabel.RIGHT);
	private JLabel lb2 = new JLabel("전화번호 : ", JLabel.RIGHT);
	private JLabel lb3 = new JLabel("주소 : ", JLabel.RIGHT);
	private JLabel lb4 = new JLabel("주요 메뉴 : ", JLabel.RIGHT);  //choice추가
	private JLabel lb5 = new JLabel("음료 메뉴: ", JLabel.RIGHT);  //choice추가
	//왼쪽 상단 화면구성-텍스트 입력창
	private JTextField tf = new JTextField(14);
	private JTextField tf3 = new JTextField(14);
	private JTextField tf4 = new JTextField(14);
	//왼쪽 상단 화면구성-choice
	private Choice Kmenu=new Choice();//주요메뉴 선택 choice
	private Choice Bmenu=new Choice();//음료메뉴 선택 choice
	private Choice qty=new Choice();//주요메뉴 수량(quantity의 약자) 선택 choice
	private Choice qty2=new Choice();//음료 수량(quantity의 약자) 선택 choice
	//왼쪽 하단 화면구성-라벨
	private JLabel alb = new JLabel("검색 : ", JLabel.RIGHT);
	//왼쪽 하단 화면구성-텍스트 입력창
	private JTextField atf = new JTextField(14);//기존의 주민번호 검색에서  회원번호 검색
	//왼쪽 하단 화면구성-버튼
	private JButton abt = new JButton("검색");
	//왼쪽 하단 화면구성-검색조회창
	private JTextArea ata = new JTextArea(5, 20);
	private JScrollPane ajsp = new JScrollPane(ata);
	//왼쪽 하단 화면구성-버튼
	private JButton abt1 = new JButton("<<");
	private JButton abt2 = new JButton(">>");

	//작성글 목록
	private JDialog adlg = new JDialog(this, "리스트목록", true);
	private Container adlgcon;
	private JLabel adlglb = new JLabel("리스트목록", JLabel.CENTER);
	private Vector adlgvc = new Vector();
	private JList adlgli = new JList();
	private JScrollPane adlgjsp = new JScrollPane(adlgli);
	private JButton adlgbt = new JButton("선택항목보기");
	private JButton adlgbt1 = new JButton("닫기");

	/*
//삭제 버튼을 눌렀을 경우-변수
private JDialog jdlg = new JDialog(this, "삭제", true);
private Container condlg;
private JLabel lbdlg = new JLabel("이름 : ", JLabel.RIGHT);
private JLabel lbdlg1 = new JLabel("주민번호 : ", JLabel.RIGHT);
private JTextField tfdlg = new JTextField(15);
private JTextField tfdlg1 = new JTextField(7);
private JTextField tfdlg2 = new JTextField(7);
private JButton btdlg = new JButton("삭제");
private JButton btdlg1 = new JButton("취소");
//수정 버튼을 눌렀을 경우-변수
private JDialog ajdlg = new JDialog(this, "수정", true);
private Container acondlg;
private JLabel albdlg = new JLabel("이름 : ", JLabel.RIGHT);
private JLabel albdlg1 = new JLabel("주민번호 : ", JLabel.RIGHT);
private JTextField atfdlg = new JTextField(15);
private JTextField atfdlg1 = new JTextField(7);
private JTextField atfdlg2 = new JTextField(7);
private JButton abtdlg = new JButton("수정");
private JButton abtdlg1 = new JButton("취소");

private JDialog bjdlg = new JDialog(this, "수정", true);
private Container bcondlg;
private JLabel blbdlg = new JLabel("이름 : ", JLabel.RIGHT);
private JLabel blbdlg1 = new JLabel("주민번호 : ", JLabel.RIGHT);
private JLabel blbdlg2 = new JLabel("전화번호 : ", JLabel.RIGHT);
private JLabel blbdlg3 = new JLabel("주소 : ", JLabel.RIGHT);
private JLabel btfdlg = new JLabel();
private JLabel btfdlg1 = new JLabel();
private JTextField btfdlg2 = new JTextField(15);
private JTextField btfdlg3 = new JTextField(15);
private JButton bbtdlg = new JButton("수정");
private JButton bbtdlg1 = new JButton("취소");
	 */
	
	OrderView_sub (String viewTitle) {
		super(viewTitle);
		this.init();
		this.start();
		this.setSize(1000,600);
		this.setResizable(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int)(di.getWidth() / 2 - di1.getWidth() / 2), 
				(int)(di.getHeight() / 2 - di1.getHeight() / 2));
		this.setVisible(true);
	}


	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbt7.addActionListener(this); //종료 버튼
		tf.addKeyListener(this); //이름 필드
		tf3.addFocusListener(this); //전화번호 필드
		tf3.addKeyListener(this);
		tf4.addFocusListener(this); //주소 필드
		tf4.addKeyListener(this);
		atf.addKeyListener(this);

		jbt1.addActionListener(this); //등록
		jbt4.addActionListener(this); //Clear
		jbt.addActionListener(this); //전체보기
		abt.addActionListener(this); //검색
		abt1.addActionListener(this); //이전
		abt2.addActionListener(this); //다음
		jbt5.addActionListener(this); //저장
		jbt6.addActionListener(this); //로드

		jbt2.addActionListener(this); //수정
		//atfdlg1.addKeyListener(this); //수정 다이얼로그의 주민 필드1
		//atfdlg2.addKeyListener(this); //수정 다이얼로그의 주민 필드2
		//abtdlg1.addActionListener(this); //수정 다이얼로그의 취소버튼
		//abtdlg.addActionListener(this); //수정 다이얼로그의 수정버튼

		//bbtdlg.addActionListener(this); //수정 다이얼로그2의 수정버튼
		//bbtdlg1.addActionListener(this); //수정 다이얼로그2의 취소버튼

		jbt3.addActionListener(this); //삭제
		//tfdlg1.addKeyListener(this); //삭제 다이얼로그 주민필드1
		//tfdlg2.addKeyListener(this); //삭제 다이얼로그 주민필드2
		//btdlg1.addActionListener(this); //삭제 다이얼로그의 취소
		//btdlg.addActionListener(this); //삭제 다이얼로그의 삭제
		// F:\work\Day22\src\kr\or\iei\homework

	}
	void init() {
		con = this.getContentPane();
		con.setLayout(mainBorderLayout);

		//메인 보더레이아웃의 north영역 설정
		button1.setIcon(new ImageIcon("customer.png"));
		button2.setIcon(new ImageIcon("order.png"));
		button3.setIcon(new ImageIcon("employee.png"));
		button4.setIcon(new ImageIcon("data.png"));
		
		Font menuFont = new Font("맑은 고딕", Font.BOLD, 15);
		button1.setFont(menuFont);
		button2.setFont(menuFont);
		button3.setFont(menuFont);
		button4.setFont(menuFont);
		
		button1.setBorder(new BevelBorder(BevelBorder.RAISED));
		button2.setBorder(new BevelBorder(BevelBorder.RAISED));
		button3.setBorder(new BevelBorder(BevelBorder.RAISED));
		button4.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		//button1.addMouseListener(this);
		//button2.addMouseListener(this);
		//button3.addMouseListener(this);
		//button4.addMouseListener(this);
		//button5.addMouseListener(this);
		

		/*
		JLabel jLabel1 = new JLabel("고객 번호");
		JLabel jLabel2 = new JLabel("고객 등록일");
		JLabel jLabel3 = new JLabel("고객 전화번호");
		JLabel jLabel4 = new JLabel("주소(특별시,광역시,도)");
		JLabel jLabel5 = new JLabel("주소(시군구)");
		JLabel jLabel6 = new JLabel("주소(동면읍리)");
		JLabel jLabel7 = new JLabel("주소(나머지)");
		JLabel jLabel8 = new JLabel("고객 누적 주문 횟수");
		JLabel jLabel9 = new JLabel("고객 나이 예측");
		*/
		JPanel jPanel1 = new JPanel(new GridLayout(1,4));
		//JPanel jPanel2 = new JPanel(new GridLayout(9,2));
		//JPanel jPanel3 = new JPanel(new GridLayout(1,4));
		//JPanel jPanel4 = new JPanel(new GridLayout(1,4));
		jPanel1.add("North", button1);
		jPanel1.add("North", button2);
		jPanel1.add("North", button3);
		jPanel1.add("North", button4);
		/*		
		jPanel2.add(jLabel1);
		jPanel2.add(jTextField1);
		jPanel2.add(jLabel2);
		jPanel2.add(jTextField2);
		jPanel2.add(jLabel3);
		jPanel2.add(jTextField3);
		jPanel2.add(jLabel4);
		jPanel2.add(jTextField4);
		jPanel2.add(jLabel5);
		jPanel2.add(jTextField5);
		jPanel2.add(jLabel6);
		jPanel2.add(jTextField6);
		jPanel2.add(jLabel7);
		jPanel2.add(jTextField7);
		jPanel2.add(jLabel8);
		jPanel2.add(jTextField8);
		jPanel2.add(jLabel9);
		jPanel2.add(jTextField9);
*/

		con.add("North", jPanel1);
		
		//메인 보더레이아웃의 south영역 설정
		//con.add("South", button5);
		
		//메인 보더레이아웃의 center영역 설정
		//con.add("Center", jPanel2);
		
		//메인 보더레이아웃의 west영역 설정
		//con.add("West", textArea2);
		
		//메인 보더레이아웃의 east영역 설정
		//con.add("East", textArea3);
	/*	
	}
	public void init(){//레이아웃 구성부분
		this.setTitle("주문관리");
		con1 = this.getContentPane();
		con1.setLayout(bl);
		*/
		//오른쪽 화면구성
		JPanel jp = new JPanel(new BorderLayout(3, 3));
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp1.add(jbt);
		jp1.add(jlb);		
		jp.add("North", jp1);
		//jp.add("Center", adlg);
		jp.add("Center", jsp);
		JPanel jp2 = new JPanel(new GridLayout(1, 7, 3, 3));
		jp2.add(jbt1);
		jp2.add(jbt2);
		jp2.add(jbt3);
		jp2.add(jbt4);
		jp2.add(jbt5);
		jp2.add(jbt6);
		jp2.add(jbt7);
		jp.add("South", jp2);
		jbt.setBorder(new BevelBorder(BevelBorder.RAISED));
		jbt1.setBorder(new BevelBorder(BevelBorder.RAISED));
		jbt2.setBorder(new BevelBorder(BevelBorder.RAISED));
		jbt3.setBorder(new BevelBorder(BevelBorder.RAISED));
		jbt4.setBorder(new BevelBorder(BevelBorder.RAISED));
		jbt5.setBorder(new BevelBorder(BevelBorder.RAISED));
		jbt6.setBorder(new BevelBorder(BevelBorder.RAISED));
		jbt7.setBorder(new BevelBorder(BevelBorder.RAISED));
		jbt.setEnabled(true);
		jbt1.setEnabled(true);
		jbt2.setEnabled(true);
		jbt3.setEnabled(true);
		jbt4.setEnabled(true);
		jbt5.setEnabled(true);
		jp.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "주문내역확인"));
		con.add("Center", jp);
		//왼쪽 상단부 화면구성
		JPanel jp3 = new JPanel(new GridLayout(2, 1, 3, 3));
		JPanel jp4 = new JPanel(new BorderLayout());
		JPanel jp5 = new JPanel(new GridLayout(5, 1));//주민번호 자리 제외
		jp5.add(lb);  //회원번호 라벨
		jp5.add(lb4);  //주요메뉴 라벨
		jp5.add(lb5);  //음료 메뉴 라벨
		jp5.add(lb2); //전화번호 라벨
		jp5.add(lb3);  //주소라벨
		jp4.add("West", jp5);
		JPanel jp6 = new JPanel(new GridLayout(5, 1));
		jp6.add(tf);
		JPanel jp7 = new JPanel(new GridLayout(1, 2)); //주요메뉴 choice 레이아웃
		jp7.add(Kmenu); //주요메뉴 choice
		Kmenu.add("프라이드 치킨"); //주요메뉴choice에 들어가는 선택지
		Kmenu.add("양념 치킨");
		Kmenu.add("마늘 치킨");
		Kmenu.add("간장 치킨");
		Kmenu.add("양파 치킨");
		jp7.add(qty);   //수량 choice
		for(int i=1;i<101;i++)
			qty.add(i+"개");//수량choice에 들어가는 선택지

		JPanel jp88 = new JPanel(new GridLayout(1, 2)); //음료메뉴 choice 레이아웃
		jp88.add(Bmenu); //음료메뉴 choice
		Bmenu.add("사이다");//음료메뉴choice에 들어가는 선택지
		Bmenu.add("콜라");
		Bmenu.add("맥주");
		Bmenu.add("소주");
		jp88.add(qty2);   //수량2 choice
		for(int i=1;i<101;i++)
			qty2.add(i+"개");//수량2choice에 들어가는 선택지
		jp6.add(jp7);
		jp6.add(jp88);
		jp6.add(tf3);
		jp6.add(tf4);
		jp4.add("Center", jp6);
		jp4.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "주문정보"));
		jp3.add(jp4);//상단부

		//왼쪽 하단부 화면부성
		JPanel jp8 = new JPanel(new BorderLayout());
		JPanel jp9 = new JPanel(new BorderLayout());
		jp9.add("West", alb);  //검색라벨
		JPanel jp10 = new JPanel(new GridLayout(1, 2, 4, 4));
		jp10.add(atf);  //검색입력창
		jp9.add("Center", jp10);
		jp9.add("East", abt);
		JPanel jp11 = new JPanel(new FlowLayout());
		jp11.add(abt1);  //<<버튼
		jp11.add(abt2);  //>>버튼
		jp8.add("North", jp9);
		jp8.add("Center", ajsp);  //정보조회창
		jp8.add("South", jp11);
		abt.setBorder(new BevelBorder(BevelBorder.RAISED));
		abt1.setBorder(new BevelBorder(BevelBorder.RAISED));
		abt2.setBorder(new BevelBorder(BevelBorder.RAISED));
		abt.setEnabled(true);
		abt1.setEnabled(true);
		abt2.setEnabled(true);
		jp8.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "주문내역 검색"));
		jp3.add(jp8);//하단부
		con.add("West", jp3);
		jta.setEnabled(true);
		ata.setEnabled(true);
		jta.setDisabledTextColor(Color.black);
		ata.setDisabledTextColor(Color.black);
	
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
			if(e.getSource()==jbt){
				System.out.println("회원 등록 버튼 클릭");
				int customerNum = Integer.parseInt(tf.getText().trim());
				//String customerRegDate = jTextField2.getText().trim();
				String customerPhoneNum = tf3.getText().trim();
				String customerAddState = jTextField4.getText().trim();
				String customerAddCity = jTextField5.getText().trim();
				String customerAddStreet = jTextField6.getText().trim();
				String customerAddRest = jTextField7.getText().trim();
				int customerFrequent = Integer.parseInt(jTextField8.getText().trim());
				int customerAgePredict = Integer.parseInt(jTextField9.getText().trim());
				OrderInfoDao 
				CustomerDao customerDao = new DaoFactory().customerDao();
				Customer customer01= new Customer(customerNum, customerRegDate, customerPhoneNum, customerAddState,
						customerAddCity, customerAddStreet, customerAddRest, customerFrequent, customerAgePredict);
				try{
					customerDao.add(customer01);
					System.out.println("등록완료");
				}catch(Exception e1){System.out.println("이상동작 발생");};

			}else{
				System.out.println("이상동작 발생");
			}*/
		}
}


public class OrderView {
	public static void main(String[] ar){
		OrderView_sub ex = new OrderView_sub(null); 
	}
}
