package view;

import java.awt.BorderLayout;
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
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.CustomerDao;
import dao.DaoFactory;
import dao.OrderInfoDao;
import domain.CustomerDto;
import domain.OrderInfoDto;
import service.CRM_MainLayout;


@SuppressWarnings("serial")
public class MainView extends JFrame implements ActionListener, KeyListener, FocusListener, MouseListener {

	//주문내역리스크창 
	Vector vector1;  
	Vector vector2;
	Vector vector3 = new Vector();
	DefaultTableModel defaultTableModel1 = new DefaultTableModel(vector1, vector2);
	JTable jTable1 = new JTable(defaultTableModel1);//주문내역 리스크창
	JScrollPane jScrollPane1 = new JScrollPane(jTable1);
	JPanel jPanel = new JPanel(); 
	OrderInfoDao dao = new OrderInfoDao();
	OrderInfoDao orderInfoDao = new OrderInfoDao();

	//컨테이너
	private Container con;

	//버튼 객체 생성
	private JButton jButton3 = new JButton(" 직원 관리");
	private JButton jButton4 = new JButton(" 데이터 분석");
	private JButton jButton5 = new JButton("주문리스트"); // 주문리스트
	private JButton jButton6 = new JButton("등록");
	private JButton jButton7 = new JButton("수정");
	private JButton jButton8 = new JButton("삭제");
	private JButton jButton9 = new JButton("Clear");
	private JButton jButton10 = new JButton("검색"); // 회원번호 검색 버튼
	private JButton jButton11 = new JButton("검색"); // 전화번호 검색 버튼
	private JButton jButton12 = new JButton("검색"); // 주소 검색 버튼
	private JButton jButton13 = new JButton("고객정보등록"); // 고객 정보 필드 등록 버튼
	private JButton jButton14 = new JButton("고객정보수정"); // 고객 정보 필드 수정 버튼
	private JButton jButton15 = new JButton("고객리스트"); // 고객리스트
	private JButton jButton16 = new JButton("주문정보 등록"); // 주문정보 등록
	private JButton jButton17 = new JButton("주문정보 수정"); // 주문정보 수정

	//라벨 객체 생성
	private JLabel jLabel1 = new JLabel("회원번호 : ", JLabel.LEFT);
	private JLabel jLabel2 = new JLabel("회원가입 날짜 : ", JLabel.LEFT);
	private JLabel jLabel3 = new JLabel("전화번호 : ", JLabel.LEFT);
	private JLabel jLabel4 = new JLabel("주소 : ", JLabel.LEFT);

	private JLabel jLabel8 = new JLabel("고객 누적 주문 횟수 : ", JLabel.LEFT);
	private JLabel jLabel9 = new JLabel("고객 나이 예측 : ", JLabel.LEFT);

	private JLabel jLabel12 = new JLabel("주문번호 : ", JLabel.LEFT);
	private JLabel jLabel13 = new JLabel("주문고객번호 : ", JLabel.LEFT);
	private JLabel jLabel14 = new JLabel("주문일자 : ", JLabel.LEFT);
	private JLabel jLabel15 = new JLabel("주문가능여부(지역) : ", JLabel.LEFT);
	private JLabel jLabel16 = new JLabel("주문가능여부(주문량) : ", JLabel.LEFT);
	private JLabel jLabel17 = new JLabel("메뉴고유값 : ", JLabel.LEFT);
	private JLabel jLabel18 = new JLabel("주문메뉴양 : ", JLabel.LEFT);
	private JLabel jLabel19 = new JLabel("주문요청사항 : ", JLabel.LEFT);
	private JLabel jLabel20 = new JLabel("채널고유값 : ", JLabel.LEFT);
	private JLabel jLabel21 = new JLabel("배달요청시간 : ", JLabel.LEFT);
	private JLabel jLabel22 = new JLabel("주문 프로세스(포장) 완료 여부 : ", JLabel.LEFT);
	private JLabel jLabel23 = new JLabel("주문 프로세스(배달) 완료 여부 : ", JLabel.LEFT);
	private JLabel jLabel24 = new JLabel("주문 프로세스 완료 여부 : ", JLabel.LEFT);
	private JLabel jLabel25 = new JLabel("수금 여부 : ", JLabel.LEFT);
	private JLabel jLabel26 = new JLabel("배달 예측시간 : ", JLabel.LEFT);

	//텍스트필드 객체 생성
	private JTextField jTextField1 = new JTextField("999", 10);//회원번호 입력창
	private JTextField jTextField2 = new JTextField("20170517", 10);//회원가입날짜 입력창
	private JTextField jTextField3 = new JTextField("01039324832", 10);//전화번호 입력창
	private JTextField jTextField4 = new JTextField("1", 10);//주소(특별시,광역시,도)의 입력창
	private JTextField jTextField5 = new JTextField("2", 10);//주소(시군구)의 입력창
	private JTextField jTextField6 = new JTextField("3", 10);//주소(동면읍리)의 입력창
	private JTextField jTextField7 = new JTextField("4", 10);//주소(나머지)의 입력창
	private JTextField jTextField8 = new JTextField("5", 10);//고객 누적 주문 횟수의 입력창
	private JTextField jTextField9 = new JTextField("6", 10);//고객 누적 주문 횟수의 입력창

	private JTextField jTextField10 = new JTextField("1", 10);//주문번호 입력창
	private JTextField jTextField11 = new JTextField("2", 10);//고객번호 입력창
	private JTextField jTextField12 = new JTextField("20170304", 10);//주문일자 입력창
	private JTextField jTextField13 = new JTextField("1", 10);// 주문가능여부(지역)
	private JTextField jTextField14 = new JTextField("2", 10);// 주문가능여부(주문량)
	private JTextField jTextField15 = new JTextField("3", 10);// 메뉴고유값
	private JTextField jTextField16 = new JTextField("4", 10);// 주문메뉴양
	private JTextField jTextField17 = new JTextField("5", 10);// 주문요청사항
	private JTextField jTextField18 = new JTextField("6", 10);// 채널고유값
	private JTextField jTextField19 = new JTextField("20170304", 10);// 배달요청시간
	private JTextField jTextField20 = new JTextField("1", 10); // 주문프로세스1
	private JTextField jTextField21 = new JTextField("2", 10); // 주문프로세스2
	private JTextField jTextField22 = new JTextField("3", 10); // 주문프로세스3
	private JTextField jTextField23 = new JTextField("4", 10); // 수금여부
	private JTextField jTextField24 = new JTextField("20170304", 10); // 배달예측시간


	//초이스 객체 생성

	//패널 객체 생성
	private JPanel jPanel1 = new JPanel(new GridLayout(1,4)); //메인의 맨 위쪽 메뉴 패널
	private JPanel jPanel2 = new JPanel(new BorderLayout(3, 3)); //
	private JPanel jPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel jPanel4 = new JPanel(new GridLayout(1, 4, 3, 3));
	private JPanel jPanel5 = new JPanel(new BorderLayout());
	private JPanel jPanel6 = new JPanel(new GridLayout(7, 1)); // 고객정보 메인 패널
	private JPanel jPanel7 = new JPanel(new GridLayout(1, 2)); // 고객정보 등록, 수정 버튼 패널
	private JPanel jPanel8 = new JPanel(new GridLayout(16, 2)); // 오더정보 메인 패널
	private JPanel jPanel11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel jPanel12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel jPanel13 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel jPanel14 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel jPanel15 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel jPanel16 = new JPanel(new FlowLayout(FlowLayout.LEFT));

	//그밖의 구성 객체 생성
	//private JList jList1 = new JList(); // 주문내역 상세 내역이 들어가는 텍스트에리아
	//private JScrollPane jScrollPane1 = new JScrollPane(jList1); //텍스트에리아1 창의 길이를 넘어서 데이터가 있을때 스크롤 할수 있는 객체 
	private Font font1 = new Font("맑은 고딕", Font.BOLD, 15); // 메뉴에 설정될 폰트

	public MainView () throws ClassNotFoundException, SQLException {
		super("매장관리");
		//주문내역리스크창

		jTableRefresh();
		vector1 = orderInfoDao.getOrderList();
		System.out.println("v=" + vector1);
		vector2 = getColumn();

		this.add(jScrollPane1);

		//jPanel1.add(jButton1);
		//this.add(jPanel1,BorderLayout.NORTH);


		jTable1.addMouseListener(this); //리스너 등록
		//jButton1.addActionListener(this); //회원가입버튼 리스너 등록
		this.init();
		this.start();
		this.setSize(1600,900);
		this.setResizable(true);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
		this.setVisible(true);
	}

	public Vector getColumn(){
		vector3.add("주문번호");
		vector3.add("주문일자");
		vector3.add("메뉴고유값");
		vector3.add("주문 메뉴양");
		return vector3;
	}

	public void jTableRefresh() throws ClassNotFoundException, SQLException{
		DefaultTableModel model= new DefaultTableModel(dao.getOrderList(), getColumn());
		jTable1.setModel(model);
	}

	public void start() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//액션리스너 관리
		jButton3.addActionListener(this); 
		jButton4.addActionListener(this); 
		jButton5.addActionListener(this);
		jButton6.addActionListener(this); //등록
		jButton7.addActionListener(this); //수정
		jButton8.addActionListener(this); //삭제
		jButton9.addActionListener(this); //Clear
		jButton10.addActionListener(this);
		jButton11.addActionListener(this);
		jButton12.addActionListener(this);
		jButton13.addActionListener(this);
		jButton14.addActionListener(this);
		jButton15.addActionListener(this);
		jButton16.addActionListener(this);
		jButton17.addActionListener(this);
	}

	void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout(5, 5));

		//메인 보더레이아웃의 north영역 설정 시작
		//메인 보더레이아웃의 north영역 설정 끝

		//메인 보더레이아웃의 east영역 설정 시작
		jPanel3.add(jButton5);
		jPanel3.add(jButton15);
		jPanel2.add("North", jPanel3);

		jPanel2.add("Center", jScrollPane1);

		//jPanel4.add(jButton6);
		//jPanel4.add(jButton7);
		//jPanel4.add(jButton8);
		//jPanel4.add(jButton9);
		//jPanel2.add("South", jPanel4);

		jButton5.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton6.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton7.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton8.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton9.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton10.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton11.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton12.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton13.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton14.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton15.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton5.setEnabled(true);
		jButton6.setEnabled(true);
		jButton7.setEnabled(true);
		jButton8.setEnabled(true);
		jButton9.setEnabled(true);
		jButton10.setEnabled(true);
		jButton11.setEnabled(true);
		jButton12.setEnabled(true);
		jButton13.setEnabled(true);
		jButton14.setEnabled(true);
		jButton15.setEnabled(true);

		jPanel2.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "고객 및 주문리스트"));
		con.add("Center", jPanel2);
		//메인 보더레이아웃의 east영역 설정 끝

		//메인 보더레이아웃의 west영역 설정 시작
		//고객 관리 패널 구성 시작
		jPanel13.add(jLabel1);  //회원번호 라벨
		jPanel13.add(jTextField1);	//회원번호 입력창
		jPanel13.add(jButton10);
		jPanel6.add(jPanel13);

		jPanel14.add(jLabel2);  //회원가입날짜 라벨
		jPanel14.add(jTextField2);	//회원가입날짜 입력 필드
		jPanel6.add(jPanel14);

		jPanel11.add(jLabel3); //전화번호 라벨
		jPanel11.add(jTextField3); //전화번호 입력창
		jPanel11.add(jButton11); //전화번호 검색버튼
		jPanel6.add(jPanel11);

		jPanel12.add(jLabel4);  // 주소 라벨

		jPanel12.add(jTextField4);	//주소(특별시,광역시,도)의 입력창 
		jPanel12.add(jTextField5);	//주소(시군구)의 입력창
		jPanel12.add(jTextField6);	//주소(동면읍리)의 입력창
		jPanel12.add(jTextField7);	//주소(나머지)의 입력창
		jPanel12.add(jButton12); //검색버튼 추가
		jPanel6.add(jPanel12);


		jPanel15.add(jLabel8);  //고객 누적 주문 횟수라벨
		jPanel15.add(jTextField8);	//고객 누적 주문 횟수의 입력창
		jPanel6.add(jPanel15);


		jPanel16.add(jLabel9);  //고객 나이 예측라벨
		jPanel16.add(jTextField9);	//고객 누적 주문 횟수의 입력창
		jPanel6.add(jPanel16);

		jPanel7.add(jButton13); // 고객정보 등록 버튼을 패널에 추가
		jPanel7.add(jButton14); // 고객정보 수정 버튼을 패널에 추가
		jPanel6.add(jPanel7); // 만들어진 패널 메인 패널에 추가

		jPanel6.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "고객정보"));
		//고객 관리 패널 구성 끝	

		//주문 관리 패널 구성 시작

		jPanel8.add(jLabel12);
		jPanel8.add(jTextField10);
		jPanel8.add(jLabel13);
		jPanel8.add(jTextField11);
		jPanel8.add(jLabel14);
		jPanel8.add(jTextField12);
		jPanel8.add(jLabel15);
		jPanel8.add(jTextField13);
		jPanel8.add(jLabel16);
		jPanel8.add(jTextField14);
		jPanel8.add(jLabel17);
		jPanel8.add(jTextField15);
		jPanel8.add(jLabel18);
		jPanel8.add(jTextField16);
		jPanel8.add(jLabel19);
		jPanel8.add(jTextField17);
		jPanel8.add(jLabel20);
		jPanel8.add(jTextField18);
		jPanel8.add(jLabel21);
		jPanel8.add(jTextField19);
		jPanel8.add(jLabel22);
		jPanel8.add(jTextField20);
		jPanel8.add(jLabel23);
		jPanel8.add(jTextField21);
		jPanel8.add(jLabel24);
		jPanel8.add(jTextField22);
		jPanel8.add(jLabel25);
		jPanel8.add(jTextField23);
		jPanel8.add(jLabel26);
		jPanel8.add(jTextField24);
		jPanel8.add(jButton16);
		jPanel8.add(jButton17);

		jPanel8.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "주문정보"));
		//주문 관리 패널 구성 끝

		//
		jButton3.setIcon(new ImageIcon("img/employee.png"));
		jButton4.setIcon(new ImageIcon("img/data.png"));

		jButton3.setFont(font1);
		jButton4.setFont(font1);

		jButton3.setBorder(new BevelBorder(BevelBorder.RAISED));
		jButton4.setBorder(new BevelBorder(BevelBorder.RAISED));

		jPanel1.add("North", jButton3);
		jPanel1.add("North", jButton4);
		//

		jPanel5.add("North", jPanel1);
		jPanel5.add("Center", jPanel6);
		jPanel5.add("South", jPanel8);

		con.add("West", jPanel5);
		jTable1.setEnabled(true);

		//jList1.setDisabledTextColor(Color.black);
		//메인 보더레이아웃의 west영역 설정 끝
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 데이터 분석 버튼
		if(e.getSource()==jButton4){
			CRM_MainLayout crm = new CRM_MainLayout();
		}

		// 고객정보 등록 버튼
		if(e.getSource()==jButton13){
			int customerNum = Integer.parseInt(jTextField1.getText().trim()); //회원번호 입력창
			String customerRegDate = jTextField2.getText().trim(); //고객 등록날짜 입력창
			String customerPhoneNum = jTextField3.getText().trim(); //전화번호 입력창
			String customerAddState = jTextField4.getText().trim(); //주소(특별시,광역시,도)의 입력창
			String customerAddCity = jTextField5.getText().trim(); //주소(시군구)의 입력창
			String customerAddStreet = jTextField6.getText().trim(); //주소(동면읍리)의 입력창
			String customerAddRest = jTextField7.getText().trim(); //주소(나머지)의 입력창
			int customerFrequent = Integer.parseInt(jTextField8.getText().trim()); //고객 누적 주문 횟수의 입력창
			int customerAgePredict = Integer.parseInt(jTextField9.getText().trim()); //고객 누적 주문 횟수의 입력창

			//CustomerDao
			CustomerDao customerDao = new DaoFactory().customerDao();
			CustomerDto customer = new CustomerDto(customerNum, customerRegDate, customerPhoneNum, customerAddState,
					customerAddCity, customerAddStreet, customerAddRest, customerFrequent, customerAgePredict);
			try{
				customerDao.add(customer);
				System.out.println("등록완료");
			}catch(Exception e1){System.out.println("등록 이상동작 발생");};
		}else{}

		// 주문정보 등록 버튼
		if(e.getSource()==jButton16){
			int orderInfoNum = Integer.parseInt(jTextField10.getText().trim());
			int orderInfoCustomerNum = Integer.parseInt(jTextField11.getText().trim());
			String orderInfoDate = jTextField12.getText().trim();
			String orderInfoLocPossiblity = jTextField13.getText().trim();
			String orderInfoOrderPossiblity = jTextField14.getText().trim();
			int orderInfoMenuNum = Integer.parseInt(jTextField15.getText().trim());
			int orderInfoMenuAmount = Integer.parseInt(jTextField16.getText().trim());
			String orderInfoRequestInfo = jTextField17.getText().trim();
			int orderInfoChannelNum = Integer.parseInt(jTextField18.getText().trim());
			String orderInfoRequestDelivery = jTextField19.getText().trim();
			String orderInfoPackCompletion = jTextField20.getText().trim();
			String orderInfoDeliveryCompletion = jTextField21.getText().trim();
			String orderInfoOrderCompletion = jTextField22.getText().trim();
			String orderInfoMoneyCollection = jTextField23.getText().trim();
			String orderInfoDeliveryPredict = jTextField24.getText().trim();
			//OrderInfoDao 
			OrderInfoDao orderInfoDao = new DaoFactory().orderInfoDao();
			OrderInfoDto orderInfo = new OrderInfoDto(orderInfoNum, orderInfoDate, orderInfoLocPossiblity, orderInfoOrderPossiblity,
					orderInfoMenuNum, orderInfoMenuAmount, orderInfoRequestInfo, orderInfoChannelNum,
					orderInfoRequestDelivery, orderInfoPackCompletion, orderInfoDeliveryCompletion,
					orderInfoOrderCompletion, orderInfoMoneyCollection, orderInfoDeliveryPredict, 
					orderInfoCustomerNum);
			try{
				orderInfoDao.add(orderInfo);
				System.out.println("등록완료");
			}catch(Exception e1){System.out.println("등록 이상동작 발생");};
		}else{}

		// 고객리스트 보기 버튼
		if(e.getSource()==jButton15){
			CustomerDao customerDao = new DaoFactory().customerDao();
			try{
				int a = 1;
				customerDao.get(a);
				System.out.println("등록완료");
			}catch(Exception e1){System.out.println("등록 이상동작 발생");};
		}else{}

		// 주문리스트 보기 버튼 
		if(e.getSource()==jButton5){
			OrderInfoDao a = new OrderInfoDao();
			try {
				Vector ab = a.getOrderList();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		/*	OrderInfoDao orderInfoDao = new DaoFactory().orderInfoDao();
			OrderInfoDto orderInfo = new OrderInfoDto();
			try{
				int a = 1;
				orderInfoDao.get(a);
				System.out.println("등록완료");
			}catch(Exception e1){System.out.println("등록 이상동작 발생");};
		}else{}
		 */

		//File dir = new File("C://data");
		//adlgvc.clear();
		//String[] files = dir.list();
		//for(int i = 0; i < files.length; i++){
		//File file = new File(dir, files[i]);
		//try{
		//FileInputStream fi = new FileInputStream(file);
		//BufferedInputStream bi = new BufferedInputStream(fi);
		//ObjectInputStream ois = new ObjectInputStream(bi);
		//OrderView_sub ess = (OrderView_sub)ois.readObject();
		//ois.close();
		//bi.close();
		//fi.close();
		//String imsi = "";
		//imsi += files[i].substring(0, files[i].indexOf("."));
		//imsi += " : ";
		//imsi += ess.getTitle();
		//imsi += " : ";
		//imsi += ess.getName();
		//imsi += " : ";
		//imsi += ess.getDate();
		///imsi += " : ";
		//imsi += ess.getSearchnum();
		//adlgvc.add(imsi);

		// 직원관리 버튼
		if(e.getSource()==jButton3){
			System.out.println("직원관리");
			UserSelectView userSelectView = new UserSelectView();
		}

		// 고객정보 수정 버튼
		if(e.getSource()==jButton14){
			System.out.println("고객정보 수정");
		}

		// 주문정보 수정 버튼
		if(e.getSource()==jButton17){
			System.out.println("주문정보 수정");
		}

		// 고객번호 검색
		if(e.getSource()==jButton10){
			System.out.println("고객번호 검색");
			int customerNum = Integer.parseInt(jTextField1.getText().trim());
			try {
				CustomerDto customerDto = (new CustomerDao()).searchCustomerNum(customerNum);
				jTextField1.setText(String.valueOf(customerDto.getCustomerNum()));
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		// 전화번호 검색
		if(e.getSource()==jButton11){
			System.out.println("전화번호 검색");
			String customerPhoneNum = jTextField1.getText().trim();
			try {
				Vector customerDto = (new CustomerDao()).searchCustomerPhoneNum(customerPhoneNum);
				//만약 검색결과가 있으면 서치뷰를 띄움
				CustomerSearchListView CustomerSearchListView = new CustomerSearchListView(customerDto);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		// 주소 검색
		if(e.getSource()==jButton12){
			System.out.println("주소 검색");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {//주문내역리스크 버튼
		if(e.getSource()==jButton5) {
			int r = jTable1.getSelectedRow();
			String orderInfoNum = (String) jTable1.getValueAt(r, 0);
			try {
				OrderRegView mem = new OrderRegView(orderInfoNum, this); //선택한 주문내역 상세보기
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