package view2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.CustomerDao;
import dao.DaoFactory;
import domain.CustomerDto;
import setting.SetLookAndFeel;
import setting.SetUiFont;
import javax.swing.border.MatteBorder;
import java.awt.Component;

public class CustomerMainView extends JFrame implements MouseListener {

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
	private JLabel lblNewLabel_2 = new JLabel("주소를 모두 정확히 입력해 주세요");
	private JLabel lblNewLabel_3 = new JLabel("나머지");
	private JLabel lblNewLabel_6 = new JLabel("누적주문");
	private JLabel lblNewLabel_7 = new JLabel("나이예측");
	private JLabel label_1 = new JLabel("고객정보를 입력하고 주문내역을 조회합니다");
	private JLabel label_5 = new JLabel("미수금");
	private JLabel label_6 = new JLabel("성별");
	private JLabel label_7 = new JLabel("특이사항");
	private JLabel label_9 = new JLabel("가족사항");
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
	
	private Vector vector3 = new Vector();
	private JTable table = new JTable();

	private Date today = new Date();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
	
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

		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"시도","서울","충남","경북"}));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"시군구","영등포구","동작구","서초구","강남구"}));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"읍면동","사당동","삼성동"}));
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

		tabbedPane_1.addTab("ㅇ가족사항", null, panel_9, null);
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

		jTextField1.setBounds(69, 45, 424, 25);
		panel_6.add(jTextField1);
		jTextField1.setColumns(10);

		lblNewLabel_2.setBounds(92, 79, 218, 25);
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
	}

	
	private void viewData(CustomerDto customerDto){

		int customerNum = customerDto.getCustomerNum();  //주문번호
		String customerRegDate = customerDto.getCustomerRegDate(); //주문일자
		String customerPhoneNum = customerDto.getCustomerPhoneNum(); //주문가능여부(주문량)
		String customerAddState = customerDto.getCustomerAddState(); //주문가능여부(주문량)
		String customerAddCity = customerDto.getCustomerAddCity(); //메뉴고유값
		String customerAddStreet = customerDto.getCustomerAddStreet(); //주문 메뉴양
		String customerAddRest = customerDto.getCustomerAddRest(); //주문요청사항
		int customerFrequent = customerDto.getCustomerFrequent();//채널고유값
		int customerAgePredict = customerDto.getCustomerAgePredict();//배달요청시간
		int customerReceivable = customerDto.getCustomerReceivable(); //주문 프로세스(포장)완료여부
		int customerGender = customerDto.getCustomerGender(); //주문 프로세스(배달)완료여부

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
		textField.setText(String.valueOf(customerFrequent));
		textField_1.setText(String.valueOf(customerAgePredict));
		textField_2.setText(String.valueOf(customerReceivable));
		if(customerGender==0){
			radioButton.setSelected(true);
		}else{
			rdbtnNewRadioButton.setSelected(true);
		}
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
			if(!(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals(""))){
				int customerNum = 1; //Integer.parseInt(jTextField2.getText().trim()); //회원번호 입력창
				//customerNum = Integer.parseInt(jTextField2.getText().trim());
				String customerRegDate = jTextField4.getText().trim(); //고객 등록날짜 입력창
				String customerPhoneNum = jTextField3.getText().trim(); //전화번호 입력창
				String customerAddState = comboBox_2.getItemAt(comboBox_2.getSelectedIndex()).toString().trim(); //주소(특별시,광역시,도)의 입력창
				String customerAddCity = comboBox_3.getItemAt(comboBox_3.getSelectedIndex()).toString().trim(); //주소(시군구)의 입력창
				String customerAddStreet = comboBox_4.getItemAt(comboBox_4.getSelectedIndex()).toString().trim(); //주소(동면읍리)의 입력창
				String customerAddRest = jTextField1.getText().trim(); //주소(나머지)의 입력창
				int customerFrequent = Integer.parseInt(textField.getText().trim()); //고객 누적 주문 횟수의 입력창
				int customerAgePredict = Integer.parseInt(textField_1.getText().trim());
				int customerReceivable = Integer.parseInt(textField_2.getText().trim());
				int customerGender = 99;
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
								customerAddCity, customerAddStreet, customerAddRest, customerFrequent, customerAgePredict,
								customerReceivable, customerGender);
						customerDao.add(customerDto);
					}catch(Exception e1){JOptionPane.showMessageDialog(null, "고객정보 등록 실패 (입력값 확인)");};
				}else{

					try {
						customerNum = Integer.parseInt(jTextField2.getText().trim());
						CustomerDto customerDto = new CustomerDto(customerNum, customerRegDate, customerPhoneNum, customerAddState,
								customerAddCity, customerAddStreet, customerAddRest, customerFrequent, customerAgePredict,
								customerReceivable, customerGender);
						customerDao.updateCustomer(customerDto);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "고객정보 변경 실패 (입력값 확인)");
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "필수 사항을 전부 입력하세요");
			}
			
			



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
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}


