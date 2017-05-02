package projectKH;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class MainView extends JFrame implements ActionListener, MouseListener, KeyListener, FocusListener{
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


	MainView (String viewTitle) {
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
		
		button1.addMouseListener(this);
		button2.addMouseListener(this);
		button3.addMouseListener(this);
		button4.addMouseListener(this);
		button5.addMouseListener(this);
		

		
		JLabel jLabel1 = new JLabel("고객 번호");
		JLabel jLabel2 = new JLabel("고객 등록일");
		JLabel jLabel3 = new JLabel("고객 전화번호");
		JLabel jLabel4 = new JLabel("주소(특별시,광역시,도)");
		JLabel jLabel5 = new JLabel("주소(시군구)");
		JLabel jLabel6 = new JLabel("주소(동면읍리)");
		JLabel jLabel7 = new JLabel("주소(나머지)");
		JLabel jLabel8 = new JLabel("고객 누적 주문 횟수");
		JLabel jLabel9 = new JLabel("고객 나이 예측");
		
		JPanel jPanel1 = new JPanel(new GridLayout(1,4));
		JPanel jPanel2 = new JPanel(new GridLayout(9,2));
		JPanel jPanel3 = new JPanel(new GridLayout(1,4));
		JPanel jPanel4 = new JPanel(new GridLayout(1,4));
		jPanel1.add("North", button1);
		jPanel1.add("North", button2);
		jPanel1.add("North", button3);
		jPanel1.add("North", button4);
				
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


		con.add("North", jPanel1);
		
		//메인 보더레이아웃의 south영역 설정
		con.add("South", button5);
		
		//메인 보더레이아웃의 center영역 설정
		con.add("Center", jPanel2);
		
		//메인 보더레이아웃의 west영역 설정
		//con.add("West", textArea2);
		
		//메인 보더레이아웃의 east영역 설정
		con.add("East", textArea3);
		
	}

	void start() {

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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==button5){
			System.out.println("회원 등록 버튼 클릭");
			int customerNum = Integer.parseInt(jTextField1.getText().trim());
			String customerRegDate = jTextField2.getText().trim();
			String customerPhoneNum = jTextField3.getText().trim();
			String customerAddState = jTextField4.getText().trim();
			String customerAddCity = jTextField5.getText().trim();
			String customerAddStreet = jTextField6.getText().trim();
			String customerAddRest = jTextField7.getText().trim();
			int customerFrequent = Integer.parseInt(jTextField8.getText().trim());
			int customerAgePredict = Integer.parseInt(jTextField9.getText().trim());

			CustomerDao customerDao = new DaoFactory().customerDao();
			Customer customer01= new Customer(customerNum, customerRegDate, customerPhoneNum, customerAddState,
					customerAddCity, customerAddStreet, customerAddRest, customerFrequent, customerAgePredict);
			try{
				customerDao.add(customer01);
				System.out.println("등록완료");
			}catch(Exception e1){System.out.println("이상동작 발생");};

		}else{
			System.out.println("이상동작 발생");
		
	}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}