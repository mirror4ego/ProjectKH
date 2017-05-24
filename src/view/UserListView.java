package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.CustomerDao;
import dao.UserInfoDao;
import setting.SetLookAndFeel;
import setting.SetUiFont;


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
	private final JLabel lblNewLabel = new JLabel("설명 및 안내");
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
	private final JComboBox comboBox_6 = new JComboBox();
	private final JComboBox comboBox_7 = new JComboBox();
	private final JComboBox comboBox_8 = new JComboBox();
	private final JButton btnNewButton_9 = new JButton("설정");
	private final JButton button = new JButton("설정");
	private final JList list_1 = new JList();
	private final JList list_2 = new JList();
	private final JLabel lblNewLabel_5 = new JLabel(" ~");
	private final JComboBox comboBox_9 = new JComboBox();
	private final JLabel lblNewLabel_12 = new JLabel("주소는 읍면동 단위까지 상세히 기입 해주세요.");
	private final JPanel panel_2 = new JPanel();
	private JTextField textField_7;
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
	
	public UserListView() throws ClassNotFoundException, SQLException{
		super("사용자 관리");

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
		scrollPane.setColumnHeaderView(table);
		tabbedPane_1.setBounds(285, 62, 687, 201);
		
		getContentPane().add(tabbedPane_1);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setForeground(Color.WHITE);
		
		tabbedPane_1.addTab("직원 정보", null, panel_1, null);
		panel_1.setLayout(null);
		lblNewLabel_2.setBounds(12, 10, 57, 36);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(334, 10, 54, 36);
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
		comboBox_6.setBounds(395, 19, 269, 21);
		panel_1.add(comboBox_6);
		comboBox_6.setForeground(Color.BLACK);
		comboBox_7.setBounds(395, 59, 187, 21);
		panel_1.add(comboBox_7);
		comboBox_7.setForeground(Color.BLACK);
		btnNewButton_9.setBounds(594, 60, 69, 23);
		panel_1.add(btnNewButton_9);
		btnNewButton_9.setForeground(Color.BLACK);
		label.setBounds(12, 59, 57, 15);
		panel_1.add(label);
		

		label.setForeground(Color.WHITE);
		
		textField_7 = new JTextField();
		textField_7.setBounds(72, 56, 250, 21);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		comboBox_8.setBounds(395, 98, 187, 21);
		panel_1.add(comboBox_8);
		comboBox_8.setForeground(Color.BLACK);
		button.setBounds(594, 96, 69, 23);
		panel_1.add(button);
		button.setForeground(Color.BLACK);
		lblNewLabel_8.setBounds(334, 92, 54, 36);
		panel_1.add(lblNewLabel_8);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(12, 92, 46, 36);
		panel_1.add(lblNewLabel_9);
		lblNewLabel_9.setForeground(Color.WHITE);
		list_1.setBounds(73, 98, 110, 21);
		panel_1.add(list_1);
		list_1.setForeground(Color.BLACK);
		list_2.setBounds(210, 98, 112, 21);
		panel_1.add(list_2);
		list_2.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(188, 98, 21, 21);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(Color.WHITE);
		comboBox_9.setBounds(395, 134, 269, 21);
		panel_1.add(comboBox_9);
		comboBox_9.setForeground(Color.BLACK);
		lblNewLabel_10.setBounds(334, 126, 57, 36);
		panel_1.add(lblNewLabel_10);
		lblNewLabel_10.setForeground(Color.WHITE);
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
		panel_2.setBounds(0, 0, 1264, 39);
		panel_2.setBackground(Color.BLACK);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		lblNewLabel.setBounds(12, 10, 960, 26);
		panel_2.add(lblNewLabel);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setForeground(Color.WHITE);
		tabbedPane_2.setBounds(285, 273, 687, 318);
		
		getContentPane().add(tabbedPane_2);
		panel_3.setBackground(Color.DARK_GRAY);
		
		tabbedPane_2.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 26, 187, 21);
		panel_3.add(textField_1);
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		comboBox_1.setBounds(265, 26, 57, 21);
		panel_3.add(comboBox_1);
		comboBox_1.setForeground(Color.BLACK);
		comboBox_2.setBounds(584, 26, 30, 21);
		panel_3.add(comboBox_2);
		comboBox_2.setForeground(Color.BLACK);
		
		textField_5 = new JTextField();
		textField_5.setBounds(399, 27, 179, 21);
		panel_3.add(textField_5);
		textField_5.setForeground(Color.BLACK);
		textField_5.setColumns(10);
		btnNewButton_8.setBounds(621, 26, 41, 21);
		panel_3.add(btnNewButton_8);
		btnNewButton_8.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(12, 18, 46, 36);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(341, 18, 46, 36);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblEmail.setBounds(12, 79, 46, 15);
		panel_3.add(lblEmail);
		lblEmail.setForeground(Color.WHITE);
		
		textField_3 = new JTextField();
		textField_3.setBounds(72, 76, 250, 21);
		panel_3.add(textField_3);
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		list.setBounds(399, 78, 263, 108);
		panel_3.add(list);
		list.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(12, 212, 46, 29);
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.WHITE);
		comboBox_3.setBounds(72, 212, 200, 21);
		panel_3.add(comboBox_3);
		comboBox_3.setForeground(Color.BLACK);
		
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"시/도","서울","부산","대구","인천","광주","대전","울산","세종",
				"경기","강원","충북","충남","전북","전남","경북","경남","제주"}));
		comboBox_4.setBounds(279, 212, 214, 21);
		panel_3.add(comboBox_4);
		comboBox_4.setForeground(Color.BLACK);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"시/군/구"}));
		comboBox_5.setBounds(501, 212, 161, 21);
		panel_3.add(comboBox_5);
		comboBox_5.setForeground(Color.BLACK);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"읍/면/동"}));
		
		textField_4 = new JTextField();
		textField_4.setBounds(69, 251, 424, 21);
		panel_3.add(textField_4);
		textField_4.setForeground(Color.BLACK);
		textField_4.setColumns(10);
		textField_6.setBounds(501, 251, 161, 21);
		panel_3.add(textField_6);
		textField_6.setForeground(Color.BLACK);
		textField_6.setColumns(10);
		lblNewLabel_12.setBounds(99, 173, 273, 21);
		panel_3.add(lblNewLabel_12);
		lblNewLabel_12.setForeground(Color.WHITE);
		
		

	}
	
	void start(){
		comboBox_3.addItemListener(this);
		btnNewButton.addMouseListener(this);
		btnNewButton_7.addMouseListener(this);
		btnNewButton_1.addMouseListener(this);
	}

	/*void viewDefault(){
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
	}*/
	
	
	
	
	
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
		
		/*if(e.getSource()==btnf_1){
			viewDefault();
		}
		
		
*/

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
		if(e.getStateChange()==ItemEvent.SELECTED){
			String a = comboBox_3.getSelectedItem().toString();
			System.out.println(a);

			if(a.equals("서울")){
				 comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강남구","강동구","강북구","강서구","관악구","광진구","구로구",
						 "금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구",
						 "종로구","중구","중랑구"}));
			}
			
			if(a.equals("부산")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강서구","금정구","기장군","남구","동구","동래구","부산진구",
						"북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구"}));
			}
			if(a.equals("대구")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","남구","달서구","달성군","동구","북구","서구","수성구","중구"}));
			}
			if(a.equals("인천")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강화군","계양구","남구","남동구","동구","부평구","서구",
						"연수구","옹진군","중구"}));
			}
			if(a.equals("광주")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","광산구","남구","동구","북구","서구"}));
			}
			if(a.equals("대전")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","대덕구","동구","서구","유성구","중구"}));
			}
			if(a.equals("울산")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","남구","동구","북구","울주군","중구"}));
			}
			if(a.equals("세종")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군"}));
			}
			if(a.equals("경기")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","가평군","고양시 덕양구","고양시 일산동구","고양시 일산서구",
						"과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시 분당구","성남시 수정구","성남시 중원구","수원시 권선구",
						"수원시 영통구","수원시 장안구","수원시 팔달구","시흥시","안산시 단원구","안산시 상록구","안성시","안양시 동안구","안양시 만안구","양주시","양평군","여주시",
						"연천군","오산시","용인시 기흥구","용인시 수지구","용인시 처인구","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시"}));
			}
			if(a.equals("강원")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강릉시","고성군","동해시","삼척시","속초시","양구군",
						"양양군","영월군","원주시","인제군","정선군","철원군","춘천시","태백시","평창군","홍천군","화천군","횡성군"}));
			}
			
			if(a.equals("충북")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","괴산군","단양군","보은군","영동군","옥천군","음성군",
						"제천시","증평군","진천군","청주시 상당구","청주시 서원구","청주시 청원구","청주시 흥덕구","충주시"}));
				
			}
			if(a.equals("충남")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","계룡시","공주시","금산군","논산시","당진시","보령시",
						"부여군","서산시","서천군","아산시","예산군","천안시 동남구","천안시 서북구","청양군","태안군","홍성군"}));
			
			}
			if(a.equals("전북")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","고창군","군산시","김제시","남원시","무주군","부안군",
						"순창군","완주군","익산시","임실군","장수군","전주시 덕진구","전주시 완산구","정읍시","진안군"}));
					
			}
			if(a.equals("전남")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강진군","고흥군","곡성군","광양시","구례군","나주시",
						"담양군","목포시","무안군","보성군","순천시","신안군","여수시","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"}));
					
			}
			if(a.equals("경북")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","경산시","경주시","고령군","구미시","군위군","김천시",
						"문경시","봉화군","상주시","성주군","안동시","영덕군","영양군","영주시","영천시","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군",
						"포항시 남구","포항시 북구"}));
			}
			if(a.equals("경남")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","거제시","거창군","고성군","김해시","남해군","밀양시",
						"사천시","산청군","양산시","의령군","진주시","창녕군","창원시 마산합포구","창원시 마산회원구","창원시 성산구","창원시 의창구","창원시 진해구","통영시",
						"하동군","함안군","함양군","합천군"}));
						 
			}
			if(a.equals("제주")){
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","서귀포시","제주시"}));	 
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
