package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.UserInfoDao;
import setting.SetLookAndFeel;
import setting.SetUiFont;


public class UserListView extends JFrame implements MouseListener,ActionListener{
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
	private final JLabel lblNewLabel_2 = new JLabel("주민번호");
	private final JLabel lblNewLabel_3 = new JLabel("연락처");
	private final JLabel lblNewLabel_4 = new JLabel("주소");
	private final JLabel lblNewLabel_6 = new JLabel("입사일");
	private final JLabel lblNewLabel_7 = new JLabel("고용형태");
	private final JLabel lblNewLabel_8 = new JLabel("주요업무");
	private final JLabel lblNewLabel_9 = new JLabel("출퇴근시간");
	private final JLabel lblNewLabel_10 = new JLabel("급여지급");
	private final JLabel lblNewLabel_11 = new JLabel("직원전체현황");
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
	private final JLabel lblNewLabel_12 = new JLabel("주소는 읍면동 단위까지 상세히 기입 해주시고 상세 주소까지 자세히 적어 주세요.");
	
	public UserListView() throws ClassNotFoundException, SQLException{
		super("사용자 관리");
		
		textField_6.setBounds(694, 402, 161, 21);
		textField_6.setColumns(10);
		textField.setBounds(114, 10, 116, 21);
		textField.setColumns(10);
		jTableRefresh();
		/*vector1 = userInfoDao.getUserList();
		System.out.println("v=" + vector1);
		vector2 = getColumn();*/
		getContentPane().setLayout(null);
		tabbedPane.setName("");
		tabbedPane.setBounds(12, 37, 301, 635);
		
		getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("직원 검색", null, panel, null);
		panel.setLayout(null);
		comboBox.setBounds(8, 10, 105, 21);
		
		panel.add(comboBox);
		
		panel.add(textField);
		btnNewButton.setBounds(232, 9, 57, 23);
		
		panel.add(btnNewButton);
		table.setBounds(8, 38, 281, 525);
		
		panel.add(table);
		lblNewLabel_11.setBounds(8, 573, 80, 23);
		
		panel.add(lblNewLabel_11);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"직원명","전화번호","핸드폰"}));
		
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"시/도","서울","부산","대구","인천","광주","대전","울산","세종",
				"경기","강원","충북","충남","전북","전남","경북","경남","제주"}));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군"}));
		/*(서울)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강남구","강동구","강북구","강서구","관악구","광진구","구로구",
		 "금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구",
		 "종로구","중구","중랑구"}));
		(부산)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강서구","금정구","기장군","남구","동구","동래구","부산진구",
		"북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구"}));
		(대구)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","남구","달서구","달성군","동구","북구","서구","수성구","중구"}));
		(인천)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강화군","계양구","남구","남동구","동구","부평구","서구",
		"연수구","옹진군","중구"}));
		(광주)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","광산구","남구","동구","북구","서구"}));
		(대전)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","대덕구","동구","서구","유성구","중구"}));
		(울산)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","남구","동구","북구","울주군","중구"}));
		(세종)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군"}));
		(경기)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","가평군","고양시 덕양구","고양시 일산동구","고양시 일산서구",
		"과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시 분당구","성남시 수정구","성남시 중원구","수원시 권선구",
		"수원시 영통구","수원시 장안구","수원시 팔달구","시흥시","안산시 단원구","안산시 상록구","안성시","안양시 동안구","안양시 만안구","양주시","양평군","여주시",
		"연천군","오산시","용인시 기흥구","용인시 수지구","용인시 처인구","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시"}));
		(강원)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강릉시","고성군","동해시","삼척시","속초시","양구군",
		"양양군","영월군","원주시","인제군","정선군","철원군","춘천시","태백시","평창군","홍천군","화천군","횡성군"}));
		(충북)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","괴산군","단양군","보은군","영동군","옥천군","음성군",
		"제천시","증평군","진천군","청주시 상당구","청주시 서원구","청주시 청원구","청주시 흥덕구","충주시"}));
		(충남)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","계룡시","공주시","금산군","논산시","당진시","보령시",
		"부여군","서산시","서천군","아산시","예산군","천안시 동남구","천안시 서북구","청양군","태안군","홍성군"}));
		(전북)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","고창군","군산시","김제시","남원시","무주군","부안군",
		"순창군","완주군","익산시","임실군","장수군","전주시 덕진구","전주시 완산구","정읍시","진안군"}));
		(전남)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","강진군","고흥군","곡성군","광양시","구례군","나주시",
		"담양군","목포시","무안군","보성군","순천시","신안군","여수시","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"}));
		(경북)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","경산시","경주시","고령군","구미시","군위군","김천시",
		"문경시","봉화군","상주시","성주군","안동시","영덕군","영양군","영주시","영천시","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군",
		"포항시 남구","포항시 북구"}));
		(경남)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","거제시","거창군","고성군","김해시","남해군","밀양시",
		"사천시","산청군","양산시","의령군","진주시","창녕군","창원시 마산합포구","창원시 마산회원구","창원시 성산구","창원시 의창구","창원시 진해구","통영시",
		"하동군","함안군","함양군","합천군"}));
		(제주)comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"구/군","서귀포시","제주시"}));*/
		
		
		JButton btnNewButton_1 =new JButton("엑셀로저장");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(85, 573, 93, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("프린터로 출력");
		btnNewButton_2.setBounds(179, 573, 110, 23);
		panel.add(btnNewButton_2);
		tabbedPane_1.setBounds(325, 37, 931, 564);
		
		getContentPane().add(tabbedPane_1);
		
		tabbedPane_1.addTab("직원 정보", null, panel_1, null);
		panel_1.setLayout(null);
		lblNewLabel_1.setBounds(22, 61, 57, 36);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_2.setBounds(22, 128, 57, 36);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_3.setBounds(22, 187, 57, 36);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_4.setBounds(22, 363, 57, 36);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_6.setBounds(479, 61, 67, 36);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_7.setBounds(479, 134, 67, 36);
		panel_1.add(lblNewLabel_7);
		lblNewLabel_8.setBounds(479, 212, 67, 36);
		panel_1.add(lblNewLabel_8);
		lblNewLabel_9.setBounds(479, 266, 67, 36);
		panel_1.add(lblNewLabel_9);
		lblNewLabel_10.setBounds(479, 321, 67, 36);
		panel_1.add(lblNewLabel_10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(104, 69, 189, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(104, 136, 250, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(22, 343, 46, 15);
		panel_1.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setBounds(104, 340, 250, 21);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(104, 402, 585, 21);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(297, 69, 57, 21);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(285, 195, 30, 21);
		panel_1.add(comboBox_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(104, 195, 177, 21);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("X");
		btnNewButton_8.setBounds(318, 194, 36, 23);
		panel_1.add(btnNewButton_8);
		list.setBounds(104, 222, 250, 108);
		
		panel_1.add(list);
		comboBox_3.setBounds(104, 371, 204, 21);
		
		panel_1.add(comboBox_3);
		comboBox_4.setBounds(313, 371, 217, 21);
		
		panel_1.add(comboBox_4);
		comboBox_5.setBounds(533, 371, 303, 21);
		
		panel_1.add(comboBox_5);
		
		panel_1.add(textField_6);
		comboBox_6.setBounds(552, 69, 284, 21);
		
		panel_1.add(comboBox_6);
		comboBox_7.setBounds(552, 142, 223, 21);
		
		panel_1.add(comboBox_7);
		comboBox_8.setBounds(552, 217, 223, 21);
		
		panel_1.add(comboBox_8);
		btnNewButton_9.setBounds(779, 141, 57, 23);
		
		panel_1.add(btnNewButton_9);
		button.setBounds(779, 215, 57, 23);
		
		panel_1.add(button);
		list_1.setBounds(552, 277, 126, 25);
		
		panel_1.add(list_1);
		list_2.setBounds(701, 276, 135, 25);
		
		panel_1.add(list_2);
		lblNewLabel_5.setBounds(679, 281, 21, 21);
		
		panel_1.add(lblNewLabel_5);
		comboBox_9.setBounds(552, 329, 284, 21);
		
		panel_1.add(comboBox_9);
		lblNewLabel_12.setBounds(138, 434, 551, 21);
		
		panel_1.add(lblNewLabel_12);
		lblNewLabel.setBounds(12, 10, 971, 26);
		getContentPane().add(lblNewLabel);
		btnNewButton_3.setBounds(325, 611, 148, 48);
		
		getContentPane().add(btnNewButton_3);
		btnNewButton_4.setBounds(864, 611, 97, 48);
		
		getContentPane().add(btnNewButton_4);
		btnNewButton_5.setBounds(961, 611, 97, 48);
		
		getContentPane().add(btnNewButton_5);
		btnNewButton_6.setBounds(1058, 611, 97, 48);
		
		getContentPane().add(btnNewButton_6);
		btnNewButton_7.setBounds(1155, 611, 97, 48);
		
		getContentPane().add(btnNewButton_7);
		
		
		setSize(1280,720);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public Vector getColumn(){
		vector3.add("아이디");
		vector3.add("비밀번호");
		vector3.add("이름");
		vector3.add("번호");
		vector3.add("주소");
		vector3.add("전화번호");
		vector3.add("이메일");
		return vector3;
	}

	public void jTableRefresh() throws ClassNotFoundException, SQLException{
		DefaultTableModel model= new DefaultTableModel(dao.getUserList(), getColumn());

	}	

	@Override
	public void mouseClicked(MouseEvent e) {
/*		int r = jTable1.getSelectedRow();
		String id = (String) jTable1.getValueAt(r, 0);
		try {
			UserRegView mem = new UserRegView(id, this);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
