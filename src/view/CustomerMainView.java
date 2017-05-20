package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.CustomerDao;
import domain.CustomerDto;
import setting.SetLookAndFeel;
import setting.SetUiFont;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class CustomerMainView extends JFrame implements MouseListener {

	// 변수 선언부
	private SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
	private SetUiFont setUiFont = new SetUiFont();

	private JTextField jTextField1 = new JTextField();
	private JTextField jTextField2 = new JTextField();
	private JTextField jTextField3 = new JTextField();
	private JTextField jTextField4 = new JTextField();
	private JTextField jTextField5 = new JTextField("01039324832");
	private JTextField textField = new JTextField();
	private JTextField textField_1 = new JTextField();
	private JTextField textField_2 = new JTextField();
	private JTextField textField_3 = new JTextField();

	private JLabel jLabel1 = new JLabel("ㅇ회원정보");
	private JLabel lblNewLabel_1 = new JLabel("고객등록일자");
	private JLabel lblNewLabel = new JLabel("ㅇ고객정보");
	private JLabel label_2 = new JLabel("고객번호");
	private JLabel lblNewLabel_5 = new JLabel("전화번호");
	private JLabel label_4 = new JLabel("가입날짜");
	private JLabel label_3 = new JLabel("주소");
	private JLabel lblNewLabel_4 = new JLabel("회원관리");
	private JLabel label = new JLabel("에서");
	private JLabel lblNewLabel_2 = new JLabel("주소를 입력하세요");
	private JLabel lblNewLabel_3 = new JLabel("나머지");
	private JLabel lblNewLabel_6 = new JLabel("누적주문");
	private JLabel lblNewLabel_7 = new JLabel("나이예측");
	private JLabel label_1 = new JLabel("고객정보를 입력하고 주문내역을 조회합니다");
	JLabel label_5 = new JLabel("미수금");
	JLabel label_6 = new JLabel("성별");

	private JButton button_7 = new JButton("파일저장");
	private JButton button_6 = new JButton("프린트");
	private JButton btnf_5 = new JButton("닫기(F12)");
	private JButton btnf_4 = new JButton("저장(F11)");
	private JButton btnf_2 = new JButton("출력(F7)");
	private JButton btnf_1 = new JButton("신규(F6)");
	private JButton btnf_3 = new JButton("삭제(F10)");
	private JButton btnNewButton = new JButton("검색");
	private JButton btnf = new JButton("주문내역보기(F5)");

	private JPanel panel_3 = new JPanel();
	private JPanel panel_4 = new JPanel();
	private JPanel panel_8 = new JPanel();
	private JPanel panel_9 = new JPanel();
	private JPanel panel_10 = new JPanel();
	private JPanel panel_11 = new JPanel();
	private JPanel panel_5 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel panel = new JPanel();
	private JPanel panel_6 = new JPanel();
	private JPanel panel_7 = new JPanel();

	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);

	private JComboBox comboBox = new JComboBox();
	private JComboBox comboBox_1 = new JComboBox();
	private JComboBox comboBox_4 = new JComboBox();
	private JComboBox comboBox_3 = new JComboBox();
	private JComboBox comboBox_2 = new JComboBox();


	private Font font1 = new Font("맑은 고딕", Font.BOLD, 15);

	JScrollPane jScrollPane1 = new JScrollPane();

	private Vector vector3 = new Vector();

	private JTable jTable1 = new JTable();
	private JTable table = new JTable();
	private final JLabel label_7 = new JLabel("특이사항");
	private final JLabel label_8 = new JLabel("기념일관리");
	private final JLabel label_9 = new JLabel("가족사항");
	private final JTextArea textArea = new JTextArea();


	public CustomerMainView() throws ClassNotFoundException, SQLException {
		super("고객관리");

		this.init();
		this.start();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1280,720);
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
		tabbedPane.setBounds(10, 62, 600, 620);
		getContentPane().add(tabbedPane);


		panel_2.setFocusTraversalKeysEnabled(false);
		tabbedPane.addTab("ㅇ고객검색", null, panel_2, null);
		panel_2.setLayout(null);



		label.setBounds(233, 14, 57, 15);
		panel_2.add(label);


		btnNewButton.setBounds(234, 42, 65, 25);
		panel_2.add(btnNewButton);


		jTextField5.setBounds(12, 42, 214, 25);
		panel_2.add(jTextField5);
		jTextField5.setColumns(10);


		panel_1.setBorder(new TitledBorder(null, "고객전체현황", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 489, 287, 92);
		panel_2.add(panel_1);
		panel_1.setLayout(null);


		panel.setBounds(19, 27, 250, 50);
		panel_1.add(panel);
		panel.setLayout(new GridLayout(1, 2, 7, 7));




		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"서울","충남","경북"}));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"영등포구","1","2"}));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"사당동","삼성동","1"}));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"고객번호", "전화번호", "주소"}));

		panel.add(button_6);

		panel.add(button_7);


		comboBox.setBounds(12, 11, 214, 25);
		panel_2.add(comboBox);
		jScrollPane1.setBounds(new Rectangle(12, 79, 579, 400));
		panel_2.add(jScrollPane1);
		jScrollPane1.setViewportView(table);


		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(630, 62, 630, 620);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);


		lblNewLabel.setBounds(28, 14, 87, 25);
		panel_3.add(lblNewLabel);


		panel_4.setBounds(12, 10, 606, 33);
		panel_3.add(panel_4);
		panel_4.setLayout(null);


		lblNewLabel_1.setBounds(337, 4, 79, 25);
		panel_4.add(lblNewLabel_1);


		comboBox_1.setBounds(429, 4, 165, 25);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"이름","전화번호","주소"})); // 날짜 콤보박스... 날짜별로 for문으로 수정
		panel_4.add(comboBox_1);



		panel_8.setBounds(12, 544, 606, 66);
		panel_3.add(panel_8);
		panel_8.setLayout(null);


		btnf_5.setBounds(524, 8, 70, 50);
		panel_8.add(btnf_5);

		btnf_4.setBounds(442, 8, 70, 50);
		panel_8.add(btnf_4);


		btnf_2.setBounds(278, 8, 70, 50);
		panel_8.add(btnf_2);


		btnf_1.setBounds(196, 8, 70, 50);
		panel_8.add(btnf_1);


		btnf_3.setBounds(360, 8, 70, 50);
		panel_8.add(btnf_3);



		btnf.setBounds(10, 8, 174, 50);
		panel_8.add(btnf);


		tabbedPane_1.setBounds(12, 373, 606, 160);
		panel_3.add(tabbedPane_1);


		tabbedPane_1.addTab("ㅇ특이사항", null, panel_10, null);
		panel_10.setLayout(null);
		label_7.setBounds(12, 10, 67, 25);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_7.setBackground(Color.GRAY);
		label_7.setAlignmentX(0.5f);
		
		panel_10.add(label_7);
		textArea.setBounds(91, 11, 498, 110);
		
		panel_10.add(textArea);


		tabbedPane_1.addTab("ㅇ기념일관리", null, panel_11, null);
		panel_11.setLayout(null);
		label_8.setBounds(12, 10, 67, 25);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_8.setBackground(Color.GRAY);
		label_8.setAlignmentX(0.5f);
		
		panel_11.add(label_8);


		tabbedPane_1.addTab("ㅇ가족사항", null, panel_9, null);
		panel_9.setLayout(null);
		label_9.setBounds(12, 10, 67, 25);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_9.setBackground(Color.GRAY);
		label_9.setAlignmentX(0.5f);
		
		panel_9.add(label_9);


		panel_5.setLayout(null);
		panel_5.setBounds(12, 53, 606, 200);
		panel_3.add(panel_5);


		label_2.setBounds(12, 10, 57, 15);
		panel_5.add(label_2);


		lblNewLabel_5.setBounds(12, 35, 57, 15);
		panel_5.add(lblNewLabel_5);


		label_4.setBounds(12, 160, 86, 15);
		panel_5.add(label_4);


		jTextField2.setBounds(81, 7, 116, 21);
		panel_5.add(jTextField2);
		jTextField2.setColumns(10);


		jTextField3.setBounds(81, 32, 116, 21);
		panel_5.add(jTextField3);
		jTextField3.setColumns(10);


		jTextField4.setBounds(81, 157, 116, 21);
		panel_5.add(jTextField4);
		jTextField4.setColumns(10);


		jTable1.setBounds(81, 64, 116, 86);
		panel_5.add(jTable1);


		lblNewLabel_6.setBounds(222, 10, 57, 15);
		panel_5.add(lblNewLabel_6);


		lblNewLabel_7.setBounds(222, 35, 63, 15);
		panel_5.add(lblNewLabel_7);


		textField.setBounds(291, 7, 116, 21);
		panel_5.add(textField);
		textField.setColumns(10);


		textField_1.setBounds(291, 32, 116, 21);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		

		label_5.setBounds(222, 67, 63, 15);
		panel_5.add(label_5);
		
		textField_2.setColumns(10);
		textField_2.setBounds(291, 64, 116, 21);
		panel_5.add(textField_2);
		

		label_6.setBounds(222, 102, 63, 15);
		panel_5.add(label_6);
		
		textField_3.setColumns(10);
		textField_3.setBounds(291, 99, 116, 21);
		panel_5.add(textField_3);


		panel_6.setLayout(null);
		panel_6.setBounds(12, 263, 606, 100);
		panel_3.add(panel_6);


		label_3.setBounds(12, 10, 57, 15);
		panel_6.add(label_3);


		comboBox_2.setBounds(92, 7, 70, 21);
		panel_6.add(comboBox_2);


		comboBox_3.setBounds(174, 7, 70, 21);
		panel_6.add(comboBox_3);


		comboBox_4.setBounds(256, 7, 341, 21);
		panel_6.add(comboBox_4);


		jTextField1.setBounds(139, 38, 458, 21);
		panel_6.add(jTextField1);
		jTextField1.setColumns(10);


		lblNewLabel_2.setBounds(92, 75, 505, 15);
		panel_6.add(lblNewLabel_2);


		lblNewLabel_3.setBounds(92, 41, 57, 15);
		panel_6.add(lblNewLabel_3);


		panel_7.setBackground(Color.YELLOW);
		panel_7.setBounds(-2, 0, 1280, 55);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);


		lblNewLabel_4.setBounds(88, 6, 133, 20);
		panel_7.add(lblNewLabel_4);


		label_1.setBounds(88, 28, 297, 20);
		panel_7.add(label_1);
	}

	void start() {
		btnf.addMouseListener(this);
		btnf_5.addMouseListener(this);
		btnNewButton.addMouseListener(this);
		button_7.addMouseListener(this);
		table.addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==btnf) {
			System.out.println("주문서 생성");
			try {
				OrderListMiniView orderListMiniView = new OrderListMiniView();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
		
		if(e.getSource()==table){
			int r = table.getSelectedRow();
			int customerNum = (int) table.getValueAt(r, 0);
			try {
				System.out.println("테이블 클릭"+ " " + customerNum + " " + r);
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, "테이블 선택 오류");
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


