package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import dao.UserInfoDao;
import setting.SetLookAndFeel;
import setting.SetUiFont;
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;


public class UserListView extends JFrame implements MouseListener,ItemListener{
	//아래부터 임시 실행을 위한 메인 선언
	public static void main(String ar[]) throws ClassNotFoundException, SQLException{
		UserListView a = new UserListView(); //클래스 파일의 객체를 직접 생성 (실행을 위해)

	}
	//메인 종료

	SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
	SetUiFont setUiFont = new SetUiFont();

	Vector vector1;  
	Vector vector2;
	Vector vector3 = new Vector();
	DefaultTableModel defaultTableModel1 = new DefaultTableModel(vector1, vector2);
	UserInfoDao dao = new UserInfoDao();
	UserInfoDao userInfoDao = new UserInfoDao();
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panel = new JPanel();
	private final JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblNewLabel = new JLabel("직원관리");
	private final JComboBox comboBox = new JComboBox();
	private final JTextField textField = new JTextField();
	private final JButton btnNewButton = new JButton("검색");
	private final JTable table = new JTable();
	private final JLabel lblNewLabel_1 = new JLabel("이름");
	private final JLabel lblNewLabel_2 = new JLabel("직원 ID");
	private final JLabel lblNewLabel_3 = new JLabel("  연락처");
	private final JLabel lblNewLabel_4 = new JLabel("주소");
	private final JLabel lblNewLabel_6 = new JLabel("입사일");
	private final JLabel lblNewLabel_7 = new JLabel("고용형태");
	private final JLabel lblNewLabel_8 = new JLabel("주요업무");
	private final JLabel lblNewLabel_9 = new JLabel("출퇴근");
	private final JLabel lblNewLabel_10 = new JLabel("급여지급");
	private final JButton btnNewButton_3 = new JButton("급여지급현황");
	private final JButton btnNewButton_4 = new JButton("신규");
	private final JButton btnNewButton_5 = new JButton("삭제");
	private final JButton btnNewButton_6 = new JButton("저장");
	private final JButton btnNewButton_7 = new JButton("닫기");

	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final JList list = new JList();
	private final JComboBox comboBox_3 = new JComboBox();
	private final JComboBox comboBox_4 = new JComboBox();
	private final JComboBox comboBox_5 = new JComboBox();
	private final JTextField textField_6 = new JTextField();
	private JSpinner jSpinner1 = new JSpinner();
	private final JComboBox comboBox_7 = new JComboBox();
	private final JComboBox comboBox_8 = new JComboBox();
	private final JButton btnNewButton_9 = new JButton("설정");
	private final JButton button = new JButton("설정");
	private final JList list_1 = new JList();
	private final JList list_2 = new JList();
	private final JLabel lblNewLabel_5 = new JLabel(" ~");
	private final JTextField comboBox_9 = new JTextField();
	private final JLabel lblNewLabel_12 = new JLabel("주소는 읍면동 단위까지 상세히 기입 해주세요.");
	private final JPanel panel_2 = new JPanel();
	private JPasswordField textField_7;
	JLabel label = new JLabel("비밀번호");
	JButton btnNewButton_8 = new JButton("X");
	JComboBox comboBox_2 = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	JLabel lblEmail = new JLabel("e-mail");
	JButton btnNewButton_1 =new JButton("전체리스트");
	JButton btnNewButton_2 = new JButton("프린터로 출력");
	JScrollPane scrollPane = new JScrollPane();
	private final JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panel_3 = new JPanel();
	private final JLabel lblNewLabel_13 = new JLabel("아이디는 영문, 숫자만 사용가능 한글 사용 불가");
	private final JLabel lblNewLabel_14 = new JLabel("비밀번호는 영문, 숫자 조합 8자 이상으로");
	private final JLabel lblNewLabel_15 = new JLabel("New label");
	private Date today = new Date();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");

	public UserListView() throws ClassNotFoundException, SQLException{
		super("사용자 관리");
		spinnerWork();
		init();
		start();
		setSize(1000,700);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getColumn();
		this.jTableRefresh(new UserInfoDao().userInfoAllPart());

	}

	void init() {

		getContentPane().setBackground(Color.GRAY);
		getContentPane().setLayout(null);
		textField.setBounds(90, 10, 98, 21);
		textField.setColumns(10);
		tabbedPane.setBounds(12, 62, 265, 593);
		tabbedPane.setName("");

		getContentPane().add(tabbedPane);
		panel.setBackground(Color.DARK_GRAY);

		tabbedPane.addTab("직원 검색", null, panel, null);
		panel.setLayout(null);
		comboBox.setBounds(8, 10, 74, 21);

		panel.add(comboBox);

		panel.add(textField);
		btnNewButton.setBounds(196, 9, 57, 23);

		panel.add(btnNewButton);

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"직원명","ID"}));




		btnNewButton_1.setBounds(8, 531, 115, 23);
		panel.add(btnNewButton_1);

		btnNewButton_2.setBounds(135, 531, 118, 23);
		panel.add(btnNewButton_2);

		scrollPane.setBounds(8, 37, 245, 484);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		tabbedPane_1.setBounds(285, 133, 687, 201);

		getContentPane().add(tabbedPane_1);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setForeground(Color.WHITE);

		tabbedPane_1.addTab("직원 정보", null, panel_1, null);
		panel_1.setLayout(null);
		lblNewLabel_2.setBounds(12, 10, 57, 36);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(334, 14, 54, 36);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(334, 50, 54, 36);
		panel_1.add(lblNewLabel_7);
		lblNewLabel_7.setForeground(Color.WHITE);

		textField_2 = new JTextField();
		textField_2.setBounds(72, 19, 250, 21);
		panel_1.add(textField_2);
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);

		jSpinner1.setBounds(395, 22, 268, 21);
		panel_1.add(jSpinner1);
		jSpinner1.setForeground(Color.BLACK);
		
<<<<<<< HEAD

		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"분류"}));

=======
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"분류"}));
>>>>>>> aa1f1cb4aacd0b07dea4e9a58fc7a3cd6eb5a770

		comboBox_7.setBounds(395, 59, 187, 21);
		panel_1.add(comboBox_7);
		comboBox_7.addItem("수습직");
		comboBox_7.addItem("파견직");		
		comboBox_7.addItem("아르바이트");
		comboBox_7.addItem("정직원");
		comboBox_7.addItem("매니저");
		comboBox_7.addItem("슈퍼바이저");
		comboBox_7.addItem("물류기사");
		
		comboBox_7.setForeground(Color.BLACK);
		
		comboBox_7.getRenderer();
		btnNewButton_9.setBounds(594, 60, 69, 23);
		panel_1.add(btnNewButton_9);
		btnNewButton_9.setForeground(Color.BLACK);
		label.setBounds(12, 78, 57, 15);
		panel_1.add(label);
		((JLabel)comboBox_7.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER); //콤보박스에 없는 정렬기능을 라벨에는 있는 정렬기능으로 형변환 시켜서 강제 중앙정렬
		label.setForeground(Color.WHITE);

		textField_7 = new JPasswordField();
		textField_7.setBounds(72, 75, 250, 21);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		comboBox_8.setBounds(395, 98, 187, 21);
		panel_1.add(comboBox_8);
		comboBox_8.addItem("분류");
		((JLabel)comboBox_8.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER); //콤보박스에 없는 정렬기능을 라벨에는 있는 정렬기능으로 형변환 시켜서 강제 중앙정렬
		comboBox_8.addItem("주문관리");
		comboBox_8.addItem("매장관리");
		comboBox_8.addItem("서빙");
		comboBox_8.addItem("조리");
		comboBox_8.setForeground(Color.BLACK);
		button.setBounds(594, 96, 69, 23);
		panel_1.add(button);
		button.setForeground(Color.BLACK);
		lblNewLabel_8.setBounds(334, 92, 54, 36);
		panel_1.add(lblNewLabel_8);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(12, 122, 46, 36);
		panel_1.add(lblNewLabel_9);
		lblNewLabel_9.setForeground(Color.WHITE);
		list_1.setBounds(73, 132, 110, 21);
		panel_1.add(list_1);
		list_1.setForeground(Color.BLACK);
		list_2.setBounds(210, 132, 112, 21);
		panel_1.add(list_2);
		list_2.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(188, 132, 21, 21);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(Color.WHITE);
		comboBox_9.setEditable(false);
		comboBox_9.setBounds(395, 134, 269, 21);
		panel_1.add(comboBox_9);
		comboBox_9.setForeground(Color.BLACK);
		lblNewLabel_10.setBounds(334, 126, 57, 36);
		panel_1.add(lblNewLabel_10);
		lblNewLabel_10.setForeground(Color.WHITE);

		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(394, 21, 57, 15);
		panel_1.add(lblNewLabel_11);
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setBounds(72, 50, 256, 15);

		panel_1.add(lblNewLabel_13);
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setBounds(72, 106, 256, 15);

		panel_1.add(lblNewLabel_14);
		btnNewButton_3.setBounds(289, 601, 148, 48);

		getContentPane().add(btnNewButton_3);
		btnNewButton_4.setBounds(584, 601, 97, 48);

		getContentPane().add(btnNewButton_4);
		btnNewButton_5.setBounds(681, 601, 97, 48);

		getContentPane().add(btnNewButton_5);
		btnNewButton_6.setBounds(778, 601, 97, 48);

		getContentPane().add(btnNewButton_6);
		btnNewButton_7.setBounds(875, 601, 97, 48);

		getContentPane().add(btnNewButton_7);
		panel_2.setBounds(0, 0, 1264, 52);
		panel_2.setBackground(Color.BLACK);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		lblNewLabel.setBounds(84, 0, 56, 26);
		panel_2.add(lblNewLabel);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setForeground(Color.WHITE);

		JLabel lblNewLabel_17 = new JLabel("매장 기존, 신규 직원들의 정보를 관리하는 곳입니다.");
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setBounds(84, 27, 305, 15);
		panel_2.add(lblNewLabel_17);
		tabbedPane_2.setBounds(285, 341, 687, 250);

		getContentPane().add(tabbedPane_2);
		panel_3.setBackground(Color.DARK_GRAY);

		tabbedPane_2.addTab("신상정보", null, panel_3, null);
		panel_3.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setBounds(72, 16, 187, 21);
		panel_3.add(textField_1);
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		comboBox_1.setBounds(265, 16, 57, 21);
		panel_3.add(comboBox_1);		
		comboBox_1.addItem("성별");
        comboBox_1.addItem("남성");
        comboBox_1.addItem("여성");
        textField.setColumns(20);
		comboBox_1.setForeground(Color.BLACK);
		
		
		comboBox_2.setBounds(584, 18, 30, 21);
		panel_3.add(comboBox_2);
		comboBox_2.setForeground(Color.BLACK);

		textField_5 = new JTextField();
		textField_5.setBounds(399, 19, 179, 21);
		panel_3.add(textField_5);
		textField_5.setForeground(Color.BLACK);
		textField_5.setColumns(10);
		btnNewButton_8.setBounds(621, 18, 41, 21);
		panel_3.add(btnNewButton_8);
		btnNewButton_8.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(12, 8, 46, 36);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(341, 10, 46, 36);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblEmail.setBounds(12, 60, 46, 15);
		panel_3.add(lblEmail);
		lblEmail.setForeground(Color.WHITE);

		textField_3 = new JTextField();
		textField_3.setBounds(72, 57, 250, 21);
		panel_3.add(textField_3);
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		list.setBounds(399, 53, 263, 76);
		panel_3.add(list);
		list.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(12, 146, 46, 29);
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.WHITE);
		comboBox_3.setBounds(72, 146, 200, 21);
		panel_3.add(comboBox_3);
		comboBox_3.setForeground(Color.BLACK);

		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"시/도","서울시","부산시","대구시","인천시","광주시","대전시","울산시","세종시",
				"경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"}));
		comboBox_4.setBounds(279, 146, 214, 21);
		panel_3.add(comboBox_4);
		comboBox_4.setForeground(Color.BLACK);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"시/군/구"}));
		comboBox_5.setBounds(501, 146, 161, 21);
		panel_3.add(comboBox_5);
		comboBox_5.setForeground(Color.BLACK);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동"}));

		textField_4 = new JTextField();
		textField_4.setBounds(69, 185, 424, 21);
		panel_3.add(textField_4);
		textField_4.setForeground(Color.BLACK);
		textField_4.setColumns(10);
		textField_6.setBounds(501, 185, 161, 21);
		panel_3.add(textField_6);
		textField_6.setForeground(Color.BLACK);
		textField_6.setColumns(10);
		lblNewLabel_12.setBounds(72, 106, 273, 21);
		panel_3.add(lblNewLabel_12);
		lblNewLabel_12.setForeground(Color.WHITE);

		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBounds(284, 62, 688, 64);
		getContentPane().add(tabbedPane_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		tabbedPane_3.addTab("공지사항", null, panel_4, null);
		panel_4.setLayout(null);
		lblNewLabel_15.setBounds(12, 10, 102, 15);
		lblNewLabel_15.setForeground(Color.WHITE);

		panel_4.add(lblNewLabel_15);
		lblNewLabel_15.setText(format.format(today));

		JLabel lblNewLabel_16 = new JLabel("복지, 고용보험, 산재보험 관련 문의는 고객센터로 문의 주세요.");
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setBounds(115, 10, 556, 15);
		panel_4.add(lblNewLabel_16);


	}

	void start(){
		comboBox_3.addItemListener(this);
		comboBox_4.addItemListener(this);
		comboBox_5.addItemListener(this);
		btnNewButton.addMouseListener(this);
		btnNewButton_7.addMouseListener(this);
		btnNewButton_1.addMouseListener(this);
	}

/*	void viewDefault(){
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
*/




	public void jTableRefresh(Vector userInfoDto) throws SQLException{

		DefaultTableModel model = new DefaultTableModel();
		System.out.println(userInfoDto);
		model.setDataVector(userInfoDto, vector3);
		table.setModel(model);
	}


	public Vector getColumn(){ //표시해주는 기능
		vector3.add("아이디");
		vector3.add("이름");
		vector3.add("번호");
		vector3.add("이메일");
		return vector3;
	}

	void spinnerWork(){
	Date now = new Date();
	final SpinnerDateModel model = new SpinnerDateModel(now, null, now, Calendar.DATE);
			jSpinner1 = new JSpinner(model);
	final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	JSpinner.DateEditor editor = new JSpinner.DateEditor(jSpinner1,"yyyy-MM-dd");
	JFormattedTextField ftf = editor.getTextField();
	ftf.setEditable(false);
	ftf.setHorizontalAlignment(JTextField.CENTER);

	ftf.setBackground(new Color(255,255,255));
	jSpinner1.setEditor(editor);
	jSpinner1.addChangeListener(new ChangeListener(){
		public void stateChanged(ChangeEvent e){
			Date value = (Date)model.getValue();
			Date next = (Date)model.getNextValue();
			if(value != null && next != null)
				System.out.println("value = "+df.format(value) + "\t" + "next = " + df.format(next));
		}
	});

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if(e.getSource()==btnNewButton) {
			System.out.println("검색");
			String searchElement = textField.getText().trim(); //입력 값
			String searchSort = comboBox.getSelectedItem().toString();
			System.out.println(searchSort + " / " + searchElement);
			if(searchSort.equals("직원명")){
				try {
					Vector userInfoDto = (new UserInfoDao()).searchUserInfoName(searchElement);
					this.jTableRefresh(userInfoDto);
					System.out.println("직원명 정상 검색");
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==btnNewButton_7) {
			this.dispose();
		}
	
	/*	if(e.getSource()==btnf_1){
			viewDefault();
		}*/


	

		if(e.getSource()==btnNewButton_1) {
			try {
				this.jTableRefresh(new UserInfoDao().userInfoAllPart());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==comboBox_3){
			if(e.getStateChange()==ItemEvent.SELECTED){
				String a = comboBox_3.getSelectedItem().toString();
				System.out.println(a);

				if(a.equals("서울시")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강남구","강동구","강북구","강서구","관악구","광진구","구로구",
							"금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구",
							"종로구","중구","중랑구"}));
				}

				if(a.equals("부산시")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강서구","금정구","기장군","남구","동구","동래구","부산진구",
							"북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구"}));
				}
				if(a.equals("대구시")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","남구","달서구","달성군","동구","북구","서구","수성구","중구"}));
				}
				if(a.equals("인천시")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강화군","계양구","남구","남동구","동구","부평구","서구",
							"연수구","옹진군","중구"}));
				}
				if(a.equals("광주시")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","광산구","남구","동구","북구","서구"}));
				}
				if(a.equals("대전시")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","대덕구","동구","서구","유성구","중구"}));
				}
				if(a.equals("울산시")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","남구","동구","북구","울주군","중구"}));
				}
				if(a.equals("세종시")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군"}));
				}
				if(a.equals("경기도")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","가평군","고양시 덕양구","고양시 일산동구","고양시 일산서구",
							"과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시 분당구","성남시 수정구","성남시 중원구","수원시 권선구",
							"수원시 영통구","수원시 장안구","수원시 팔달구","시흥시","안산시 단원구","안산시 상록구","안성시","안양시 동안구","안양시 만안구","양주시","양평군","여주시",
							"연천군","오산시","용인시 기흥구","용인시 수지구","용인시 처인구","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시"}));
				}
				if(a.equals("강원도")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강릉시","고성군","동해시","삼척시","속초시","양구군",
							"양양군","영월군","원주시","인제군","정선군","철원군","춘천시","태백시","평창군","홍천군","화천군","횡성군"}));
				}

				if(a.equals("충청북도")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","괴산군","단양군","보은군","영동군","옥천군","음성군",
							"제천시","증평군","진천군","청주시 상당구","청주시 서원구","청주시 청원구","청주시 흥덕구","충주시"}));

				}
				if(a.equals("충청남도")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","계룡시","공주시","금산군","논산시","당진시","보령시",
							"부여군","서산시","서천군","아산시","예산군","천안시 동남구","천안시 서북구","청양군","태안군","홍성군"}));

				}
				if(a.equals("전라북도")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","고창군","군산시","김제시","남원시","무주군","부안군",
							"순창군","완주군","익산시","임실군","장수군","전주시 덕진구","전주시 완산구","정읍시","진안군"}));

				}
				if(a.equals("전라남도")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강진군","고흥군","곡성군","광양시","구례군","나주시",
							"담양군","목포시","무안군","보성군","순천시","신안군","여수시","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"}));

				}
				if(a.equals("경상북도")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","경산시","경주시","고령군","구미시","군위군","김천시",
							"문경시","봉화군","상주시","성주군","안동시","영덕군","영양군","영주시","영천시","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군",
							"포항시 남구","포항시 북구"}));
				}
				if(a.equals("경상남도")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","거제시","거창군","고성군","김해시","남해군","밀양시",
							"사천시","산청군","양산시","의령군","진주시","창녕군","창원시 마산합포구","창원시 마산회원구","창원시 성산구","창원시 의창구","창원시 진해구","통영시",
							"하동군","함안군","함양군","합천군"}));

				}
				if(a.equals("제주도")){
					comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","서귀포시","제주시"}));	 
				}
			}else{

			}
		}else if (e.getSource()==comboBox_4){
			if(e.getStateChange()==ItemEvent.SELECTED){
			String b = comboBox_4.getSelectedItem().toString();
			System.out.println(b);

			if(b.equals("강남구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","개포동","논현동","대치동","도곡동","삼성동","세곡동","수서동",
						"신사동","압구정동","역삼동","율현동","일원동","자곡동","청담동"}));
			}
			if(b.equals("강동구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","강일동","고덕동","길동","둔촌동","명일동","상일동","성내동","암사동","천호동"}));
			}
			if(b.equals("강북구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","미아동","번동","삼각산동","삼양동","송중동","송천동","수유동","우이동","인수동"}));
			}
			if(b.equals("강서구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","가양동","개화동","공항동","과해동","내발산동","등촌동","마곡동","방화동","염창동","오곡동","오쇠동","외발산동","우장산동","화곡동"}));
			}
			if(b.equals("관악구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","낙성대동","난곡동","난향동","남현동","대학동","미성동","보라매동","봉천동","삼성동","서림동","서원동","성현동","신림동","신사동","신원동",
						"은천동","인헌동","조원동","중앙동","청룡동","청림동","행운동"}));
			}
			if(b.equals("광진구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","광장동","구의동","군자동","능동","자양동","중곡동","화양동"}));
			}
			if(b.equals("구로구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","가리봉동","개봉동","고척동","구로동","궁동","신도림동","오류동","온수동","천왕동","항동"}));
			}
			if(b.equals("금천구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","가산동","독산동","시흥동"}));
			}
			if(b.equals("노원구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","공릉동","상계동","월계동","중계동","하계동"}));
			}
			if(b.equals("도봉구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","도봉동","방학동","쌍문동","창동"}));
			}
			if(b.equals("동대문구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","답십리동","신설동","용두동","이문동","장안동","전농동","제기동","청량리동","회기동","휘경동"}));
			}
			if(b.equals("동작구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","노량진동","대방동","동작동","본동","사당동","상도동","신대방동","흑석동"}));
			}
			if(b.equals("마포구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","공덕동","구수동","노고산동","당인동","대흥동","도화동","동교동","마포동","망원동","상수동","상암동","서교동","성산동","신공덕동",
						"신수동","신정동","아현동","연남동","염리동","용강동","중동","창전동","토정동","하중동","합정동","현석동"}));
			}
			if(b.equals("서대문구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","남가좌동","냉천동","대신동","대현동","미근동","봉원동","북가좌동","북아현동","신촌동","연희동","영천동","옥천동","창천동","천연동",
						"충정로","합동","현저동","홍은동","홍제동"}));
			}
			if(b.equals("서초구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","내곡동","반포동","반포본동","방배동","방배본동","서초동","신원동","양재동","염곡동","우면동","원지동","잠원동"}));
			}
			if(b.equals("성동구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","금호동","도선동","마장동","사근동","상왕십리동","성수동","송정동","옥수동","왕십리동","용답동","응봉동","하왕십리동","행당동","홍익동"}));
			}
			if(b.equals("성북구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","길음동","돈암동","동선동","동소문동","보문동","삼선동","상월곡동","석관동","성북동","안암동","월곡동","장위동","정릉동","종암동","하월곡동"}));
			}
			if(b.equals("송파구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","가락동","가락본동","거여동","마천동","문정동","방이동","삼전동","석촌동","송파동","신천동","오금동","오륜동","잠실동","잠실본동","장지동",
				"풍납동"}));
			}
			if(b.equals("양천구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","목동","신월동","신정동"}));
			}
			if(b.equals("영등포구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","당산동","대림동","도림동","문래동","신길동","양평동","양화동","여의도동","영등포동","영등포본동"}));
			}	
			if(b.equals("용산구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","갈월동","남영동","도원동","동빙고동","동자동","문배동","보광동","산천동","서계동","서빙고동","신계동","신창동","용문동","용산동","원효로",
						"이촌동","이태원동","주성동","청암동","청파동","한강로","한남동","효창동","후암동"}));
			}		
			if(b.equals("은평구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","갈현동","구산동","녹번동","대조동","불광동","수색동","신사동","역촌동","응암동","증산동","진관동"}));
			}
			if(b.equals("종로구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","가회동","견지동","경운동","계동","공평동","관수동","관철동","관훈동","교남동","교북동","구기동","관수동","관철동","관훈동","교남동","교북동",
						"구기동","궁정동","권농동","낙원동","내수동","내자동","누상동","누하동","당주동","도렴동","돈의동","동숭동","명륜동","묘동","무악동","봉익동",
						"부암동","사간동","사직동","삼청동","서린동","세종로","소격동","송월동","송현동","수송동","숭인동","신교동","신문로","신영동","안국동","연건동",
						"연지동","예지동","옥인동","와룡동","운니동","원남동","원서동","이화동","익선동","인사동","인의동","장사동","재동","적선동","종로1가","종로2가",
						"종로3가","종로4가","종로5가","종로6가","중학동","창성동","창신동","청운동","청진동","체부동","충신동","통의동","통인동","팔판동","평동",
						"평창동","필운동","행촌동","혜화동","홍지동","홍파동","화동","효자동","효제동","훈정동"}));
			}	
			if(b.equals("중구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","광희동","남대문로","남산동","남창동","남학동","다동","만리동","명동","무교동","무학동","묵정동","방산동","봉래동","북창동","산림동","삼각동",
						"서소문동","소공동","수표동","수하동","순화동","신당동","쌍림동","예관동","예장동","오장동","을지로","의주로","인현동","입정동","장교동",
						"장충동","저동","정동","주교동","주자동","중림동","초동","충무로","충정로","태평로","필동","황학동","회현동","흥인동"}));
			}
			if(b.equals("중랑구")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","망우동","망우본동","면목동","면목본동","묵동","상봉동","신내동","중화동"}));
			}		
			if(b.equals("서귀포시")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","강정동","남원읍","대정읍","대포동","도순동","동홍동","법환동","보목동","상예동","상효동","색달동","서귀동","서호동","서홍동","성산읍","송산동",
						"신효동","안덕면","영남동","용흥동","월평동","정방동","중문동","중앙동","천지동","토평동","표선면","하예동","하원동","하효동","호근동","회수동"}));
			}							
			if(b.equals("제주시")){
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동","건입동","구좌읍","내도동","노형동","도남동","도두동","도련동","도평동","봉개동","삼도동","삼양동","아라동","애월읍","연동","영평동","오등동","오라동",
						"외도동","용강동","용담동","우도면","월평동","이도동","이호동","일도동","조천읍","추자면","한경면","한림읍","해안동","화북동","회천동"}));
			}
		}
		}




	}
	
	/*
	 * (서울 강남구)
	 * {"읍/면/동","개포동","논현동","대치동","도곡동","삼성동","세곡동","수서동","신사동","압구정동","역삼동","율현동","일원동","자곡동","청담동"}
	 * (서울 강동구)
	 * {"읍/면/동","강일동","고덕동","길동","둔촌동","명일동","상일동","성내동","암사동","천호동"}
	 * (서울 강북구)
	 * {"읍/면/동","미아동","번동","삼각산동","삼양동","송중동","송천동","수유동","우이동","인수동"}
	 * (서울 강서구)
	 * {"읍/면/동","가양동","개화동","공항동","과해동","내발산동","등촌동","마곡동","방화동","염창동","오곡동","오쇠동","외발산동","우장산동","화곡동"}
	 * (서울 관악구)
	 * {"읍/면/동","낙성대동","난곡동","난향동","남현동","대학동","미성동","보라매동","봉천동","삼성동","서림동","서원동","성현동","신림동","신사동","신원동",
	 * "은천동","인헌동","조원동","중앙동","청룡동","청림동","행운동"}
	 * (서울 광진구)
	 * {"읍/면/동","광장동","구의동","군자동","능동","자양동","중곡동","화양동"}
	 * (서울 구로구)
	 * {"읍/면/동","가리봉동","개봉동","고척동","구로동","궁동","신도림동","오류동","온수동","천왕동","항동"}
	 * (서울 금천구)
	 * {"읍/면/동","가산동","독산동","시흥동"}
	 * (서울 노원구)
	 * {"읍/면/동","공릉동","상계동","상계동","월계동","중계동","하계동"}
	 * (서울 도봉구)
	 * {"읍/면/동","도봉동","방학동","쌍문동","창동"}
	 * (서울 동대문구)
	 * {"읍/면/동","답십리동","신설동","용두동","이문동","장안동","전농동","제기동","청량리동","회기동","휘경동"}
	 * (서울 동작구)
	 * {"읍/면/동","노량진동","대방동","동작동","본동","사당동","상도동","신대방동","흑석동"}
	 * (서울 마포구)
	 * {"읍/면/동","공덕동","구수동","노고산동","당인동","대흥동","도화동","동교동","마포동","망원동","상수동","상암동","서교동","성산동","신공덕동",
	 * "신수동","신정동","아현동","연남동","염리동","용강동","중동","창전동","토정동","하중동","합정동","현석동"}
	 * (서울 서대문구)
	 * {"읍/면/동","남가좌동","냉천동","대신동","대현동","미근동","봉원동","북가좌동","북아현동","신촌동","연희동","영천동","옥천동","창천동","천연동",
	 * "충정로","합동","현저동","홍은동","홍제동"}
	 * (서울 서초구)
	 * {"읍/면/동","내곡동","반포동","반포본동","방배동","방배본동","서초동","신원동","양재동","염곡동","우면동","원지동","잠원동"}
	 * (서울 성동구)
	 * {"읍/면/동","금호동","도선동","마장동","사근동","상왕십리동","성수동","송정동","옥수동","왕십리동","용답동","응봉동","하왕십리동","행당동","홍익동"}
	 * (서울 성북구)
	 * {"읍/면/동","길음동","돈암동","동선동","동소문동","보문동","삼선동","상월곡동","석관동","성북동","안암동","월곡동","장위동","정릉동","종암동","하월곡동"}
	 * (서울 송파구)
	 * {"읍/면/동","가락동","가락본동","거여동","마천동","문정동","방이동","삼전동","석촌동","송파동","신천동","오금동","오륜동","잠실동","잠실본동","장지동",
	 * "풍납동"}
	 * (서울 양천구)
	 * {"읍/면/동","목동","신월동","신정동")
	 * (서울 영등포구)
	 * {"읍/면/동","당산동","대림동","도림동","문래동","신길동","양평동","양화동","여의도동","영등포동","영등포본동"}
	 * (서울 용산구)
	 * {"읍/면/동","갈월동","남영동","도원동","동빙고동","동자동","문배동","보광동","산천동","서계동","서빙고동","신계동","신창동","용문동","용산동","원효로",
	 * "이촌동","이태원동","주성동","청암동","청파동","한강로","한남동","효창동","후암동"}
	 * (서울 은평구)
	 * {"읍/면/동","갈현동","구산동","녹번동","대조동","불광동","수색동","신사동","역촌동","응암동","증산동","진관동"}
	 * (서울 종로구)
	 * {"읍/면/동","가회동","견지동","경운동","계동","공평동","관수동","관철동","관훈동","교남동","교북동","구기동","관수동","관철동","관훈동","교남동","교북동",
	 * "구기동","궁정동","권농동","낙원동","내수동","내자동","누상동","누하동","당주동","도렴동","돈의동","동숭동","명륜동","묘동","무악동","봉익동",
	 * "부암동","사간동","사직동","삼청동","서린동","세종로","소격동","송월동","송현동","수송동","숭인동","신교동","신문로","신영동","안국동","연건동",
	 * "연지동","예지동","옥인동","와룡동","운니동","원남동","원서동","이화동","익선동","인사동","인의동","장사동","재동","적선동","종로1가","종로2가",
	 * "종로3가","종로4가","종로5가","종로6가","중학동","창성동","창신동","청운동","청진동","체부동","충신동","통의동","통인동","팔판동","평동",
	 * "평창동","필운동","행촌동","혜화동","홍지동","홍파동","화동","효자동","효제동","훈정동"}
	 * (서울 중구)
	 * {"읍/면/동","광희동","남대문로","남산동","남창동","남학동","다동","만리동","명동","무교동","무학동","묵정동","방산동","봉래동","북창동","산림동","삼각동",
	 * "서소문동","소공동","수표동","수하동","순화동","신당동","쌍림동","예관동","예장동","오장동","을지로","의주로","인현동","입정동","장교동",
	 * "장충동","저동","정동","주교동","주자동","중림동","초동","충무로","충정로","태평로","필동","황학동","회현동","흥인동"}
	 * (서울 중랑구)
	 * {"읍/면/동","망우동","망우본동","면목동","면목본동","묵동","상봉동","신내동","중화동"}
	 * 
	 * (제주 서귀포시)
	 * {"읍/면/동","강정동","남원읍","대정읍","대포동","도순동","동홍동","법환동","보목동","상예동","상효동","색달동","서귀동","서호동","서홍동","성산읍","송산동",
	 * "신효동","안덕면","영남동","용흥동","월평동","정방동","중문동","중앙동","천지동","토평동","표선면","하예동","하원동","하효동","호근동","회수동"}
	 * (제주시)
	 * {"읍/면/동","건입동","구좌읍","내도동","노형동","도남동","도두동","도련동","도평동","봉개동","삼도동","삼양동","아라동","애월읍","연동","영평동","오등동","오라동",
	 * "외도동","용강동","용담동","우도면","월평동","이도동","이호동","일도동","조천읍","추자면","한경면","한림읍","해안동","화북동","회천동"}
	 * 
	 * */



	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
