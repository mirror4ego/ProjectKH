package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.CustomerDao;
import domain.CustomerDto;
import setting.SetLookAndFeel;
import setting.SetUiFont;


public class CustomerSearchView extends JFrame implements ActionListener, MouseListener {

	//변수 선언부 시작
	//패널
	JPanel jPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 17));
	JPanel jPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 17));
	JPanel jPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 17));
	JPanel jPanel5 = new JPanel(new GridLayout(1,4));

	//라벨
	JLabel jLabel2 = new JLabel("고객번호");
	JLabel jLabel3 = new JLabel("/   가입날짜");
	JLabel jLabel4 = new JLabel("/   전화번호");
	JLabel jLabel5 = new JLabel("주         소");
	JLabel jLabel6 = new JLabel("/   누적주문");
	JLabel jLabel7 = new JLabel("/   고객나이");

	//텍스트필드
	public JTextField jTextField1 = new JTextField(5);
	public JTextField jTextField2 = new JTextField(6);
	public JTextField jTextField3 = new JTextField(8);
	public JTextField jTextField4 = new JTextField(7); // 주소1
	public JTextField jTextField5 = new JTextField(4);
	public JTextField jTextField6 = new JTextField(3);
	public JTextField jTextField7 = new JTextField(7); // 주소2
	public JTextField jTextField8 = new JTextField(7); // 주소3
	public JTextField jTextField9 = new JTextField(15); // 주소4

	//버튼
	JButton jButton1 = new JButton("입력");
	JButton jButton2 = new JButton("수정");
	JButton jButton3 = new JButton("삭제");
	JButton jButton4 = new JButton("취소");

	//폰트
	private Font font1 = new Font("맑은 고딕", Font.BOLD, 15);

	CustomerSearchListView customerSearchListView;
	//변수 선언부 끝

	//생성자 시작
	public CustomerSearchView() {
		super("고객정보검색");
		init();
	}

	public CustomerSearchView(int customerNum, CustomerSearchListView customerSearchListView) throws ClassNotFoundException, SQLException{ //수정/삭제용 생성자
		super("고객정보검색");
		SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
		SetUiFont setUiFont = new SetUiFont();
		init();
		//this.customerSearchListView = customerSearchListView;

		System.out.println("검색 매개변수 = " + customerNum);

		CustomerDao customerDao = new CustomerDao();
		CustomerDto customerDto = customerDao.searchCustomerNum(customerNum);
		
		viewData(customerDto);
	} //id를 가지고 생성
	//생성자 끝


	//메소드 시작
	void init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(3,1));
		this.setSize(750,200);
		this.setResizable(false);

		start();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
		this.setVisible(true);
		//텍스트1 필드 비활성화 설정
		jTextField1.setEnabled(false);

		//폰트 설정
		jLabel2.setFont(font1);
		jLabel3.setFont(font1);
		jLabel4.setFont(font1);
		jLabel5.setFont(font1);
		jLabel6.setFont(font1);
		jLabel7.setFont(font1);
		jButton1.setFont(font1);
		jButton2.setFont(font1);
		jButton3.setFont(font1);
		jButton4.setFont(font1);
		jTextField1.setFont(font1);
		jTextField2.setFont(font1);
		jTextField3.setFont(font1);
		jTextField4.setFont(font1);
		jTextField5.setFont(font1);
		jTextField6.setFont(font1);
		jTextField7.setFont(font1);
		jTextField8.setFont(font1);
		jTextField9.setFont(font1);

		//패널들 구성
		jPanel2.add(jLabel2);
		jPanel2.add(jTextField1);
		jPanel2.add(jLabel3);
		jPanel2.add(jTextField2);
		jPanel2.add(jLabel4);
		jPanel2.add(jTextField3);
		jPanel2.add(jLabel6);
		jPanel2.add(jTextField5);
		jPanel2.add(jLabel7);
		jPanel2.add(jTextField6);

		jPanel3.add(jLabel5);
		jPanel3.add(jTextField4);
		jPanel3.add(jTextField7);
		jPanel3.add(jTextField8);
		jPanel3.add(jTextField9);

		jPanel5.add(jButton1);
		jPanel5.add(jButton2);
		jPanel5.add(jButton3);
		jPanel5.add(jButton4);

		//프레임에 패널 붙여넣음
		this.add(jPanel2);
		this.add(jPanel3);
		this.add(jPanel5);

	}

	void start() {
		jButton1.addMouseListener(this);
		jButton2.addMouseListener(this);
		jButton3.addMouseListener(this);
		jButton4.addMouseListener(this);
	}

	private void viewData(CustomerDto customerDto){
		//화면에 세팅
		jTextField1.setText(String.valueOf(customerDto.getCustomerNum()));
		jTextField2.setText(String.valueOf(customerDto.getCustomerRegDate()).substring(0,10));  // 문자열 앞에서 10개만 가져와서 디스플레이
		jTextField3.setText(customerDto.getCustomerPhoneNum());
		jTextField4.setText(customerDto.getCustomerAddState());
		jTextField6.setText(String.valueOf(customerDto.getCustomerAgePredict()));
		jTextField7.setText(customerDto.getCustomerAddCity());
		jTextField8.setText(customerDto.getCustomerAddStreet());
		jTextField9.setText(customerDto.getCustomerAddRest());
	}//viewData

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==jButton1){ // 메인뷰의 고객정보창에 입력
			System.out.println("입력");
		}

		if(e.getSource()==jButton2){ // 검색된 해당 고객정보를 고객번호 기준으로 수정
			System.out.println("수정");
		}

		if(e.getSource()==jButton3){ // 검색된 해당 고객정보를 고객번호 기준으로 삭제
			System.out.println("삭제");
		}

		if(e.getSource()==jButton4){ // 종료 버튼 동작
			this.dispose();
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
	//메소드 끝
}