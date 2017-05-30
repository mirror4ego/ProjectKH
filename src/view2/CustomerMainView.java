package view2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.CustomerDao;
import dao.DaoFactory;
import dao.OrderInfoDao;
import dao.OrderItemDao;
import domain.CustomerDto;
import setting.SetLookAndFeel;
import setting.SetUiFont;
import view.UserSelectView;

public class CustomerMainView extends JFrame implements MouseListener, ItemListener {
	public static void main(String ar[]) throws ClassNotFoundException, SQLException{
		CustomerMainView a = new CustomerMainView(); //클래스 파일의 객체를 직접 생성 (실행을 위해)

	}
	// 변수 선언부
	private SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
	private SetUiFont setUiFont = new SetUiFont();

	private JTextField jTextField1 = new JTextField("");
	private JTextField jTextField2 = new JTextField("");
	private JTextField jTextField3 = new JTextField("");
	private JTextField jTextField4 = new JTextField("");
	private JTextField jTextField5 = new JTextField("");
	private JTextField textField = new JTextField("");
	private JTextField textField_1 = new JTextField("");
	private JTextField textField_2 = new JTextField("");

	private JLabel jLabel1 = new JLabel("ㅇ회원정보");
	private JLabel lblNewLabel_1 = new JLabel("현재날짜");
	private JLabel lblNewLabel = new JLabel("ㅇ고객정보");
	private JLabel label_2 = new JLabel("고객번호");
	private JLabel lblNewLabel_5 = new JLabel("전화번호");
	private JLabel label_4 = new JLabel("가입날짜");
	private JLabel label_3 = new JLabel("주소");
	private JLabel lblNewLabel_4 = new JLabel("회원관리");
	private JLabel label = new JLabel("에서");
	private JLabel lblNewLabel_2 = new JLabel("  주소를 모두 정확히 입력해 주세요");
	private JLabel lblNewLabel_3 = new JLabel("나머지");
	private JLabel lblNewLabel_6 = new JLabel("누적주문");
	private JLabel lblNewLabel_7 = new JLabel("나이예측");
	private JLabel label_1 = new JLabel("고객정보를 입력하고 주문내역을 조회합니다");
	private JLabel label_5 = new JLabel("미수금");
	private JLabel label_6 = new JLabel("성별");
	private JLabel label_7 = new JLabel("특이사항");
	private JLabel label_9 = new JLabel("특이사항");
	private JLabel comboBox_1 = new JLabel();

	private JButton button_7 = new JButton("파일저장");
	private JButton button_6 = new JButton("프린트");
	private JButton btnf_5 = new JButton("닫기");
	private JButton btnf_4 = new JButton("저장");
	private JButton btnf_1 = new JButton("신규");
	private JButton btnf_3 = new JButton("삭제");
	private JButton btnNewButton = new JButton("검색");
	private JButton btnf = new JButton("주문내역");
	private JButton btnNewButton_1 = new JButton("전체리스트");
	private JButton button = new JButton("주문서");

	private JPanel panel_3 = new JPanel();
	private JPanel panel_4 = new JPanel();
	private JPanel panel_8 = new JPanel();
	private JPanel panel_9 = new JPanel();
	private JPanel panel_10 = new JPanel();
	private JPanel panel_5 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel panel = new JPanel();
	private JPanel panel_6 = new JPanel();
	private JPanel panel_7 = new JPanel();

	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);

	private JComboBox comboBox = new JComboBox();
	private JComboBox comboBox_4 = new JComboBox();
	private JComboBox comboBox_3 = new JComboBox();
	private JComboBox comboBox_2 = new JComboBox();

	private Font font1 = new Font("맑은 고딕", Font.BOLD, 15);

	private JScrollPane jScrollPane1 = new JScrollPane();

	private JTextArea textArea = new JTextArea();
	private JTextArea textArea_2 = new JTextArea();

	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnNewRadioButton = new JRadioButton("여성");
	private JRadioButton radioButton = new JRadioButton("남성");
	JLabel label_10 = new JLabel("등급");
	JComboBox comboBox_5 = new JComboBox();
	private Vector vector3 = new Vector();
	private JTable table = new JTable();

	private Date today = new Date();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
	private final JLabel label_8 = new JLabel();

	public CustomerMainView() throws ClassNotFoundException, SQLException {
		super("고객관리");
		this.init();
		this.start();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(945,720);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		this.getColumn();
		this.jTableRefresh(new CustomerDao().customerAllPart());
	}

	void init() {
		jTextField5.getFocusListeners();
		tabbedPane.setBounds(10, 62, 375, 620);
		getContentPane().add(tabbedPane);

		panel_2.setFocusTraversalKeysEnabled(false);
		tabbedPane.addTab("ㅇ고객검색", null, panel_2, null);
		panel_2.setLayout(null);

		label.setBounds(279, 16, 57, 15);
		panel_2.add(label);

		btnNewButton.setBounds(279, 42, 65, 25);
		panel_2.add(btnNewButton);

		jTextField5.setBounds(12, 42, 255, 25);
		panel_2.add(jTextField5);
		jTextField5.setColumns(10);

		panel_1.setBorder(new TitledBorder(null, "고객전체현황", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 489, 346, 92);
		panel_2.add(panel_1);
		panel_1.setLayout(null);

		panel.setBounds(19, 27, 315, 50);
		panel_1.add(panel);
		panel.setLayout(new GridLayout(1, 2, 7, 7));

		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"시/도"}));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"시/군/구"}));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동"}));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"전화번호", "고객번호", "주소"}));



		panel.add(btnNewButton_1);

		panel.add(button_6);

		panel.add(button_7);

		comboBox.setBounds(12, 11, 255, 25);
		panel_2.add(comboBox);
		jScrollPane1.setBounds(new Rectangle(12, 79, 346, 400));
		panel_2.add(jScrollPane1);
		jScrollPane1.setViewportView(table);

		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(397, 62, 529, 620);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		lblNewLabel.setBounds(28, 14, 87, 25);
		panel_3.add(lblNewLabel);

		panel_4.setBounds(12, 10, 504, 33);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		lblNewLabel_1.setBounds(309, 4, 56, 25);
		panel_4.add(lblNewLabel_1);
		comboBox_1.setText("1");

		comboBox_1.setBounds(377, 4, 115, 25);
		panel_4.add(comboBox_1);

		panel_8.setBounds(12, 544, 506, 66);
		panel_3.add(panel_8);
		panel_8.setLayout(null);

		btnf_5.setBounds(428, 8, 70, 50);
		panel_8.add(btnf_5);

		btnf_4.setBounds(264, 8, 70, 50);
		panel_8.add(btnf_4);

		btnf_1.setBounds(182, 8, 70, 50);
		panel_8.add(btnf_1);

		btnf_3.setBounds(346, 8, 70, 50);
		panel_8.add(btnf_3);

		btnf.setBounds(10, 8, 80, 50);
		panel_8.add(btnf);

		button.setBounds(100, 8, 70, 50);
		panel_8.add(button);

		tabbedPane_1.setBounds(12, 340, 505, 193);
		panel_3.add(tabbedPane_1);


		//comboBox.getSelectedIndex();
		System.out.println(comboBox.getSelectedIndex());
		if(comboBox.getSelectedIndex()==1)

			tabbedPane_1.addTab("ㅇ특이사항", null, panel_10, null);
		panel_10.setLayout(null);
		label_7.setBounds(12, 10, 67, 25);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_7.setBackground(Color.GRAY);
		label_7.setAlignmentX(0.5f);

		panel_10.add(label_7);
		textArea.setBounds(91, 11, 402, 143);

		panel_10.add(textArea);

		tabbedPane_1.addTab("ㅇ특이사항", null, panel_9, null);
		panel_9.setLayout(null);
		label_9.setBounds(12, 10, 67, 25);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_9.setBackground(Color.GRAY);
		label_9.setAlignmentX(0.5f);

		panel_9.add(label_9);
		textArea_2.setBounds(86, 11, 402, 143);

		panel_9.add(textArea_2);

		panel_5.setLayout(null);
		panel_5.setBounds(12, 53, 505, 152);
		panel_3.add(panel_5);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		label_2.setBounds(12, 10, 57, 25);
		panel_5.add(label_2);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		lblNewLabel_5.setBounds(12, 45, 57, 25);
		panel_5.add(lblNewLabel_5);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		label_4.setBounds(12, 80, 57, 25);
		panel_5.add(label_4);
		jTextField2.setHorizontalAlignment(SwingConstants.RIGHT);
		jTextField2.setEditable(false);

		jTextField2.setBounds(69, 10, 170, 25);
		panel_5.add(jTextField2);
		jTextField2.setColumns(10);
		jTextField3.setHorizontalAlignment(SwingConstants.RIGHT);

		jTextField3.setBounds(69, 45, 170, 25);
		panel_5.add(jTextField3);
		jTextField3.setColumns(10);
		jTextField4.setHorizontalAlignment(SwingConstants.RIGHT);

		jTextField4.setBounds(69, 80, 170, 25);
		panel_5.add(jTextField4);
		jTextField4.setColumns(10);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		lblNewLabel_6.setBounds(264, 10, 57, 25);
		panel_5.add(lblNewLabel_6);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		lblNewLabel_7.setBounds(264, 45, 57, 25);
		panel_5.add(lblNewLabel_7);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);

		textField.setBounds(321, 10, 170, 25);
		panel_5.add(textField);
		textField.setColumns(10);
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);

		textField_1.setBounds(321, 45, 170, 25);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		label_5.setBounds(264, 80, 57, 25);
		panel_5.add(label_5);
		textField_2.setEditable(false);
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);

		textField_2.setColumns(10);
		textField_2.setBounds(321, 80, 170, 25);
		panel_5.add(textField_2);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		label_6.setBounds(264, 115, 57, 25);
		panel_5.add(label_6);


		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(341, 115, 57, 25);
		panel_5.add(rdbtnNewRadioButton);


		buttonGroup.add(radioButton);
		radioButton.setBounds(410, 115, 57, 25);
		panel_5.add(radioButton);


		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		label_10.setBounds(12, 115, 57, 25);
		panel_5.add(label_10);


		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"등급선택", "신규고객", "일반고객", "단골고객", "VIP고객"}));
		comboBox_5.setBounds(69, 115, 170, 25);
		panel_5.add(comboBox_5);

		panel_6.setLayout(null);
		panel_6.setBounds(12, 215, 505, 115);
		panel_3.add(panel_6);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		label_3.setBounds(12, 10, 57, 25);
		panel_6.add(label_3);

		comboBox_2.setBounds(81, 10, 78, 25);
		panel_6.add(comboBox_2);

		comboBox_3.setBounds(171, 10, 92, 25);
		panel_6.add(comboBox_3);

		comboBox_4.setBounds(275, 10, 218, 25);
		panel_6.add(comboBox_4);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"시/도","서울시","부산시","대구시","인천시","광주시","대전시","울산시","세종시",
				"경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"}));

		jTextField1.setBounds(69, 45, 424, 25);
		panel_6.add(jTextField1);
		jTextField1.setColumns(10);
		lblNewLabel_2.setIcon(new ImageIcon(CustomerMainView.class.getResource("/com/sun/deploy/uitoolkit/impl/fx/ui/resources/image/graybox_error.png")));

		lblNewLabel_2.setBounds(92, 79, 255, 25);
		panel_6.add(lblNewLabel_2);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		lblNewLabel_3.setBounds(12, 45, 57, 25);
		panel_6.add(lblNewLabel_3);

		panel_7.setBackground(Color.YELLOW);
		panel_7.setBounds(-2, 0, 1280, 55);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);

		lblNewLabel_4.setBounds(88, 6, 133, 20);
		panel_7.add(lblNewLabel_4);

		label_1.setBounds(88, 28, 297, 20);
		panel_7.add(label_1);
		label_8.setBounds(35, 12, 32, 32);
		label_8.setIcon(new ImageIcon("img/employees.png"));

		panel_7.add(label_8);
		comboBox_1.setText(format.format(today));
	}

	void start() {
		btnf.addMouseListener(this);
		btnf_5.addMouseListener(this);
		btnNewButton.addMouseListener(this);
		button_7.addMouseListener(this);
		table.addMouseListener(this);
		btnf_4.addMouseListener(this);
		btnNewButton_1.addMouseListener(this);
		btnf_1.addMouseListener(this);
		btnf_3.addMouseListener(this);
		button.addMouseListener(this);
		comboBox_2.addItemListener(this);
		comboBox_3.addItemListener(this);
	}

	public Vector getColumn(){
		vector3.add("고객번호");
		vector3.add("전화번호");
		vector3.add("주소(동면읍)");
		vector3.add("주소(나머지)");
		return vector3;
	}


	public void jTableRefresh(Vector customerDto) throws ClassNotFoundException, SQLException{
		DefaultTableModel model = new DefaultTableModel();
		System.out.println(vector3);
		model.setDataVector(customerDto, vector3);
		table.setModel(model);
	}

	void viewDefault(){
		jTextField2.setText("");
		jTextField4.setText("");
		jTextField3.setText("");
		comboBox_2.setSelectedIndex(0);
		comboBox_3.setSelectedIndex(0);
		comboBox_4.setSelectedIndex(0);
		jTextField1.setText("");
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		radioButton.setSelected(false);
		rdbtnNewRadioButton.setSelected(false);
		comboBox_5.setSelectedIndex(0);
		textArea_2.setText("");
		
	}

	private void viewData(CustomerDto customerDto) throws ClassNotFoundException, SQLException{

		int customerNum = customerDto.getCustomerNum();  //주문번호
		String customerRegDate = customerDto.getCustomerRegDate(); //주문일자
		String customerPhoneNum = customerDto.getCustomerPhoneNum(); //주문가능여부(주문량)
		String customerAddState = customerDto.getCustomerAddState(); //주문가능여부(주문량)
		String customerAddCity = customerDto.getCustomerAddCity(); //메뉴고유값
		String customerAddStreet = customerDto.getCustomerAddStreet(); //주문 메뉴양
		String customerAddRest = customerDto.getCustomerAddRest(); //주문요청사항
		int customerAgePredict = customerDto.getCustomerAgePredict();//배달요청시간
		int customerGender = customerDto.getCustomerGender(); //주문 프로세스(배달)완료여부
		String customerGradeName = customerDto.getCustomerGradeName();
		String customerNoteInfo = customerDto.getCustomerNoteInfo();
		//화면에 세팅
		
		viewDefault();

		jTextField2.setText(String.valueOf(customerNum));
		jTextField4.setText(customerRegDate.substring(0,10));
		jTextField3.setText(customerPhoneNum);
		for(int i=0;i<comboBox_2.getItemCount();i++){
			if(customerAddState.equals(comboBox_2.getItemAt(i).toString())){
				comboBox_2.setSelectedIndex(i);
			}
		}
		for(int i=0;i<comboBox_3.getItemCount();i++){
			if(customerAddCity.equals(comboBox_3.getItemAt(i).toString())){
				comboBox_3.setSelectedIndex(i);
			}
		}
		for(int i=0;i<comboBox_4.getItemCount();i++){
			if(customerAddStreet.equals(comboBox_4.getItemAt(i).toString())){
				comboBox_4.setSelectedIndex(i);
			}
		}
		jTextField1.setText(customerAddRest);
		textField_1.setText(String.valueOf(customerAgePredict));
		if(customerGender==0){
			radioButton.setSelected(true);
		}else{
			rdbtnNewRadioButton.setSelected(true);
		}
		for(int i=0;i<comboBox_5.getItemCount();i++){
			if(customerGradeName.equals(comboBox_5.getItemAt(i).toString())){
				comboBox_5.setSelectedIndex(i);
			}
		}
		textArea_2.setText(customerNoteInfo);
		//누적 주문
		OrderInfoDao orderInfoDao = new OrderInfoDao();
		int orderInfoCount = orderInfoDao.getOneCustomerOrderFrequency(customerNum);
		textField.setText(String.valueOf(orderInfoCount));
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==btnf) {
			if(!(jTextField2.getText().trim()).equals("")){
				try {

					new OrderListMiniView(Integer.parseInt(jTextField2.getText().trim()), jTextField3.getText().trim());

				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "주문내역을 확인할 고객 정보를 선택하세요");
			}
		}

		if(e.getSource()==btnNewButton) {
			System.out.println("검색");
			String searchElement = jTextField5.getText().trim();
			String searchSort = comboBox.getSelectedItem().toString();
			System.out.println(searchSort + " / " + searchElement);
			if(searchSort.equals("고객번호")){
				try {
					Vector customerDto = (new CustomerDao()).searchCustomerNum(searchElement);
					this.jTableRefresh(customerDto);
					System.out.println("고객번호 정상 검색");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(searchSort.equals("전화번호")){
				try {
					Vector customerDto = (new CustomerDao()).searchCustomerPhoneNum(searchElement);
					this.jTableRefresh(customerDto);
					System.out.println("전화번호 정상 검색");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(searchSort.equals("주소")){
				System.out.println("789");
			}else{
				JOptionPane.showMessageDialog(null, "검색 오류");
			}
		}

		if(e.getSource()==btnf_5){
			System.out.println("종료 버튼");
			this.dispose();
		}

		if(e.getSource()==btnf_4){
			int customerNum = 1; //Integer.parseInt(jTextField2.getText().trim()); //회원번호 입력창
			//customerNum = Integer.parseInt(jTextField2.getText().trim());
			String customerRegDate = jTextField4.getText().trim(); //고객 등록날짜 입력창
			String customerPhoneNum = jTextField3.getText().trim(); //전화번호 입력창
			String customerAddState = comboBox_2.getItemAt(comboBox_2.getSelectedIndex()).toString().trim(); //주소(특별시,광역시,도)의 입력창
			String customerAddCity = comboBox_3.getItemAt(comboBox_3.getSelectedIndex()).toString().trim(); //주소(시군구)의 입력창
			String customerAddStreet = comboBox_4.getItemAt(comboBox_4.getSelectedIndex()).toString().trim(); //주소(동면읍리)의 입력창
			String customerAddRest = jTextField1.getText().trim(); //주소(나머지)의 입력창
			int customerAgePredict = Integer.parseInt(textField_1.getText().trim());
			int customerGender = 99;
			String customerNoteInfo = textArea_2.getText().toString();
			String customerGradeName = String.valueOf(comboBox_5.getSelectedItem());
			System.out.println(customerGradeName);
			if(radioButton.isSelected()){
				customerGender = 0;
			}else if(rdbtnNewRadioButton.isSelected()){
				customerGender = 1;
			}else{
				JOptionPane.showMessageDialog(null, "성별 선택 오류");
			}
			CustomerDao customerDao = new DaoFactory().customerDao();
			if((jTextField2.getText().trim()).equals("")){

				try{
					CustomerDto customerDto = new CustomerDto(customerNum, customerRegDate, customerPhoneNum, customerAddState,
							customerAddCity, customerAddStreet, customerAddRest, customerAgePredict,customerGender, customerNoteInfo,
							customerGradeName);
					customerDao.add(customerDto);

				}catch(Exception e1){JOptionPane.showMessageDialog(null, "고객정보 등록 실패 (입력값 확인)");};
			}else{

				try {
					customerNum = Integer.parseInt(jTextField2.getText().trim());
					CustomerDto customerDto = new CustomerDto(customerNum, customerRegDate, customerPhoneNum, customerAddState,
							customerAddCity, customerAddStreet, customerAddRest, customerAgePredict,customerGender, customerNoteInfo,
							customerGradeName);
					customerDao.updateCustomer(customerDto);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "고객정보 변경 실패 (입력값 확인)");
				}
			}
			try {
				this.jTableRefresh(new CustomerDao().customerAllPart());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} //여기까지 버튼 4
		}else{}

		if(e.getSource()==table){
			int r = table.getSelectedRow();
			int customerNum = (int) table.getValueAt(r, 0);
			try {
				viewData((new CustomerDao()).get(customerNum));
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, "테이블 선택 오류");
			}
		}

		if(e.getSource()==btnNewButton_1){
			try {
				this.jTableRefresh(new CustomerDao().customerAllPart());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if(e.getSource()==btnf_1){
			viewDefault();
		}

		if(e.getSource()==btnf_3){

			if(!(jTextField2.getText().trim()).equals("")){
				try {
					int result = JOptionPane.showConfirmDialog(null, "고객정보를 삭제하시겠습니까?");
					if(result==0){
						OrderItemDao orderItemDao = new OrderItemDao();
						OrderInfoDao orderInfoDao = new OrderInfoDao();
						//OrderItem 목록 삭제 (고객번호로 검색한 하위 orderinfo_num들의 아래에 있는 결과들)

						Vector vector3 = orderInfoDao.getOrderListNum(Integer.parseInt(jTextField2.getText().trim()));
						for(int i = 0;i<vector3.size();i++){
							orderItemDao.deleteOrderItem(Integer.parseInt(vector3.get(i).toString()));
						}
						//OrderInfo 목록 삭제 (고객번호로 검색되어 나온 결과들)
						orderInfoDao.delteOrderInfo(Integer.parseInt(jTextField2.getText().trim()));
						(new CustomerDao()).deleteOneCustomer(Integer.parseInt(jTextField2.getText().trim()));
					}else{
						JOptionPane.showMessageDialog(null, "삭제를 취소 하셨습니다");
					}
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "삭제할 고객 정보를 선택하세요");
			}
			
			try {
				this.jTableRefresh(new CustomerDao().customerAllPart());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if(e.getSource()==button){
			if(!(jTextField2.getText().trim()).equals("")){
				try {
					new OrderSheetView((new CustomerDao()).searchCustomerNum(Integer.parseInt(jTextField2.getText().trim())));

				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "먼저 고객 정보를 선택하세요");
			}
		}	
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==comboBox_2){
			if(e.getStateChange()==ItemEvent.SELECTED){
				String a = comboBox_2.getSelectedItem().toString();
				System.out.println(a);

				if(a.equals("서울시")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","강남구","강동구","강북구","강서구","관악구","광진구","구로구",
							"금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구",
							"종로구","중구","중랑구"}));
				}

				if(a.equals("부산시")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","강서구","금정구","기장군","남구","동구","동래구","부산진구",
							"북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구"}));
				}
				if(a.equals("대구시")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","남구","달서구","달성군","동구","북구","서구","수성구","중구"}));
				}
				if(a.equals("인천시")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","강화군","계양구","남구","남동구","동구","부평구","서구",
							"연수구","옹진군","중구"}));
				}
				if(a.equals("광주시")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","광산구","남구","동구","북구","서구"}));
				}
				if(a.equals("대전시")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","대덕구","동구","서구","유성구","중구"}));
				}
				if(a.equals("울산시")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","남구","동구","북구","울주군","중구"}));
				}
				if(a.equals("세종시")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군"}));
				}
				if(a.equals("경기도")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","가평군","고양시 덕양구","고양시 일산동구","고양시 일산서구",
							"과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시 분당구","성남시 수정구","성남시 중원구","수원시 권선구",
							"수원시 영통구","수원시 장안구","수원시 팔달구","시흥시","안산시 단원구","안산시 상록구","안성시","안양시 동안구","안양시 만안구","양주시","양평군","여주시",
							"연천군","오산시","용인시 기흥구","용인시 수지구","용인시 처인구","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시"}));
				}
				if(a.equals("강원도")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","강릉시","고성군","동해시","삼척시","속초시","양구군",
							"양양군","영월군","원주시","인제군","정선군","철원군","춘천시","태백시","평창군","홍천군","화천군","횡성군"}));
				}

				if(a.equals("충청북도")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","괴산군","단양군","보은군","영동군","옥천군","음성군",
							"제천시","증평군","진천군","청주시 상당구","청주시 서원구","청주시 청원구","청주시 흥덕구","충주시"}));

				}
				if(a.equals("충청남도")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","계룡시","공주시","금산군","논산시","당진시","보령시",
							"부여군","서산시","서천군","아산시","예산군","천안시 동남구","천안시 서북구","청양군","태안군","홍성군"}));

				}
				if(a.equals("전라북도")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","고창군","군산시","김제시","남원시","무주군","부안군",
							"순창군","완주군","익산시","임실군","장수군","전주시 덕진구","전주시 완산구","정읍시","진안군"}));

				}
				if(a.equals("전라남도")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","강진군","고흥군","곡성군","광양시","구례군","나주시",
							"담양군","목포시","무안군","보성군","순천시","신안군","여수시","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"}));

				}
				if(a.equals("경상북도")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","경산시","경주시","고령군","구미시","군위군","김천시",
							"문경시","봉화군","상주시","성주군","안동시","영덕군","영양군","영주시","영천시","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군",
							"포항시 남구","포항시 북구"}));
				}
				if(a.equals("경상남도")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","거제시","거창군","고성군","김해시","남해군","밀양시",
							"사천시","산청군","양산시","의령군","진주시","창녕군","창원시 마산합포구","창원시 마산회원구","창원시 성산구","창원시 의창구","창원시 진해구","통영시",
							"하동군","함안군","함양군","합천군"}));

				}
				if(a.equals("제주도")){
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"구/군","서귀포시","제주시"}));	 
				}
			}
		}

		if(e.getStateChange()==ItemEvent.SELECTED){
			String b = comboBox_3.getSelectedItem().toString();
			System.out.println(b);

			if(b.equals("강남구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","개포동","논현동","대치동","도곡동","삼성동","세곡동","수서동",
						"신사동","압구정동","역삼동","율현동","일원동","자곡동","청담동"}));
			}
			if(b.equals("강동구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","강일동","고덕동","길동","둔촌동","명일동","상일동","성내동","암사동","천호동"}));
			}
			if(b.equals("강북구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","미아동","번동","삼각산동","삼양동","송중동","송천동","수유동","우이동","인수동"}));
			}
			if(b.equals("강서구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","가양동","개화동","공항동","과해동","내발산동","등촌동","마곡동","방화동","염창동","오곡동","오쇠동","외발산동","우장산동","화곡동"}));
			}
			if(b.equals("관악구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","낙성대동","난곡동","난향동","남현동","대학동","미성동","보라매동","봉천동","삼성동","서림동","서원동","성현동","신림동","신사동","신원동",
						"은천동","인헌동","조원동","중앙동","청룡동","청림동","행운동"}));
			}
			if(b.equals("광진구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","광장동","구의동","군자동","능동","자양동","중곡동","화양동"}));
			}
			if(b.equals("구로구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","가리봉동","개봉동","고척동","구로동","궁동","신도림동","오류동","온수동","천왕동","항동"}));
			}
			if(b.equals("금천구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","가산동","독산동","시흥동"}));
			}
			if(b.equals("노원구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","공릉동","상계동","상계동","월계동","중계동","하계동"}));
			}
			if(b.equals("도봉구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","도봉동","방학동","쌍문동","창동"}));
			}
			if(b.equals("동대문구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","답십리동","신설동","용두동","이문동","장안동","전농동","제기동","청량리동","회기동","휘경동"}));
			}
			if(b.equals("동작구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","노량진동","대방동","동작동","본동","사당동","상도동","신대방동","흑석동"}));
			}
			if(b.equals("마포구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","공덕동","구수동","노고산동","당인동","대흥동","도화동","동교동","마포동","망원동","상수동","상암동","서교동","성산동","신공덕동",
						"신수동","신정동","아현동","연남동","염리동","용강동","중동","창전동","토정동","하중동","합정동","현석동"}));
			}
			if(b.equals("서대문구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","남가좌동","냉천동","대신동","대현동","미근동","봉원동","북가좌동","북아현동","신촌동","연희동","영천동","옥천동","창천동","천연동",
						"충정로","합동","현저동","홍은동","홍제동"}));
			}
			if(b.equals("서초구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","내곡동","반포동","반포본동","방배동","방배본동","서초동","신원동","양재동","염곡동","우면동","원지동","잠원동"}));
			}
			if(b.equals("성동구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","금호동","도선동","마장동","사근동","상왕십리동","성수동","송정동","옥수동","왕십리동","용답동","응봉동","하왕십리동","행당동","홍익동"}));
			}
			if(b.equals("성북구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","길음동","돈암동","동선동","동소문동","보문동","삼선동","상월곡동","석관동","성북동","안암동","월곡동","장위동","정릉동","종암동","하월곡동"}));
			}
			if(b.equals("송파구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","가락동","가락본동","거여동","마천동","문정동","방이동","삼전동","석촌동","송파동","신천동","오금동","오륜동","잠실동","잠실본동","장지동",
				"풍납동"}));
			}
			if(b.equals("양천구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","목동","신월동","신정동"}));
			}
			if(b.equals("영등포구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","당산동","대림동","도림동","문래동","신길동","양평동","양화동","여의도동","영등포동","영등포본동"}));
			}	
			if(b.equals("용산구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","갈월동","남영동","도원동","동빙고동","동자동","문배동","보광동","산천동","서계동","서빙고동","신계동","신창동","용문동","용산동","원효로",
						"이촌동","이태원동","주성동","청암동","청파동","한강로","한남동","효창동","후암동"}));
			}		
			if(b.equals("은평구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","갈현동","구산동","녹번동","대조동","불광동","수색동","신사동","역촌동","응암동","증산동","진관동"}));
			}
			if(b.equals("종로구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","가회동","견지동","경운동","계동","공평동","관수동","관철동","관훈동","교남동","교북동","구기동","관수동","관철동","관훈동","교남동","교북동",
						"구기동","궁정동","권농동","낙원동","내수동","내자동","누상동","누하동","당주동","도렴동","돈의동","동숭동","명륜동","묘동","무악동","봉익동",
						"부암동","사간동","사직동","삼청동","서린동","세종로","소격동","송월동","송현동","수송동","숭인동","신교동","신문로","신영동","안국동","연건동",
						"연지동","예지동","옥인동","와룡동","운니동","원남동","원서동","이화동","익선동","인사동","인의동","장사동","재동","적선동","종로1가","종로2가",
						"종로3가","종로4가","종로5가","종로6가","중학동","창성동","창신동","청운동","청진동","체부동","충신동","통의동","통인동","팔판동","평동",
						"평창동","필운동","행촌동","혜화동","홍지동","홍파동","화동","효자동","효제동","훈정동"}));
			}	
			if(b.equals("중구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","광희동","남대문로","남산동","남창동","남학동","다동","만리동","명동","무교동","무학동","묵정동","방산동","봉래동","북창동","산림동","삼각동",
						"서소문동","소공동","수표동","수하동","순화동","신당동","쌍림동","예관동","예장동","오장동","을지로","의주로","인현동","입정동","장교동",
						"장충동","저동","정동","주교동","주자동","중림동","초동","충무로","충정로","태평로","필동","황학동","회현동","흥인동"}));
			}
			if(b.equals("중랑구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","망우동","망우본동","면목동","면목본동","묵동","상봉동","신내동","중화동"}));
			}		
			if(b.equals("서귀포시")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","강정동","남원읍","대정읍","대포동","도순동","동홍동","법환동","보목동","상예동","상효동","색달동","서귀동","서호동","서홍동","성산읍","송산동",
						"신효동","안덕면","영남동","용흥동","월평동","정방동","중문동","중앙동","천지동","토평동","표선면","하예동","하원동","하효동","호근동","회수동"}));
			}							
			if(b.equals("제주시")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","건입동","구좌읍","내도동","노형동","도남동","도두동","도련동","도평동","봉개동","삼도동","삼양동","아라동","애월읍","연동","영평동","오등동","오라동",
						"외도동","용강동","용담동","우도면","월평동","이도동","이호동","일도동","조천읍","추자면","한경면","한림읍","해안동","화북동","회천동"}));
			}
		}
	}



	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}


