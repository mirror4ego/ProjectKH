package view2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import dao.MenuDao;
import dao.OrderInfoDao;
import dao.OrderItemDao;
import dao.UserInfoDao;
import domain.CustomerDto;
import domain.OrderInfoDto;
import domain.OrderItemDto;
import setting.SetLookAndFeel;
import setting.SetUiFont;

public class OrderSheetView extends JFrame implements ActionListener, MouseListener {
	SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
	SetUiFont setUiFont = new SetUiFont();
	private JLabel lblNewLabel_4 = new JLabel("주문서 작성");
	private JLabel label_1 = new JLabel("주문사항을 입력하는 곳입니다.");
	private JPanel panel_9 = new JPanel();
	private JPanel panel_3 = new JPanel();
	private JPanel panel_5 = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel panel = new JPanel();
	private JPanel panel_4 = new JPanel();
	private JPanel panel_8 = new JPanel();
	private JPanel panel_6 = new JPanel();
	private JPanel panel_7 = new JPanel();
	private JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);	
	private JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
	private JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
	Vector vector1 = new Vector();
	private JScrollPane scrollPane = new JScrollPane();
	JButton button_6 = new JButton("삭제");
	private Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
	private JTable table = new JTable();
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JPanel panel_2 = new JPanel();
	private JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
	private JScrollPane scrollPane_1 = new JScrollPane();
	private JScrollPane scrollPane_2 = new JScrollPane();
	private JPanel panel_10 = new JPanel();
	private JButton btnNewButton = new JButton("닫기");
	private JButton button = new JButton("저장");
	private JButton button_1 = new JButton("출력");
	private JPanel panel_11 = new JPanel();
	private JTextField textField_1 = new JTextField(); 
	private JTextField textField_3 = new JTextField(); // 고객번호
	private JTextField textField_6 = new JTextField(); // 주소
	private JTextField textField_7 = new JTextField(); 
	private JTable table_1 = new JTable();
	private JButton btnNewButton_1 = new JButton("동일주문서");
	private JTable table_2;
	private JTable table_3;
	private JPanel panel_12 = new JPanel();
	private JLabel label_10 = new JLabel("미수금");
	private JLabel label_12 = new JLabel("총주문");
	private JLabel label_13 = new JLabel("최다주문메뉴");
	private JTable table_4;
	private JTextField textField_13 = new JTextField();
	private JTextField textField_14 = new JTextField();
	private JTextField textField = new JTextField();
	private JButton button_2 = new JButton("신규입력");
	private JLabel label_14 = new JLabel("고객번호");
	private JLabel label_2 = new JLabel("주소");
	private JLabel label_3 = new JLabel("전화번호");
	private JLabel label = new JLabel("소계");
	private JLabel label_6 = new JLabel("합계");
	private JLabel label_15 = new JLabel("할인");
	private JLabel label_4 = new JLabel("고객번호");
	private JLabel label_16 = new JLabel("전화번호");
	private JLabel label_17 = new JLabel("배송주소");
	private JLabel label_18 = new JLabel("주문시간");
	private JLabel label_5 = new JLabel("담당자");
	private JLabel label_7 = new JLabel("대기시간");
	private JTextField textField_4 = new JTextField();
	private JComboBox textField_5 = new JComboBox();
	private JTextField textField_8 = new JTextField();
	private JTextField textField_9 = new JTextField();
	private JTextField textField_10 = new JTextField();
	private JTextField textField_11 = new JTextField();
	private JLabel lblNewLabel_1 = new JLabel("회");
	private JTextField textField_2 = new JTextField(); // 전화번호
	private JLabel label_9 = new JLabel("원");
	private JTextField textField_12 = new JTextField();
	private JLabel label_11 = new JLabel("원");
	private JLabel label_19 = new JLabel("채널");
	private JComboBox textField_15 = new JComboBox();
	private JLabel label_20 = new JLabel("등급");
	private JComboBox textField_16 = new JComboBox();
	private JButton button_3 = new JButton("검색");
	private JButton button_4 = new JButton("검색");
	private JLabel lblNewLabel = new JLabel();
	private JLabel label_21 = new JLabel("접수일시");
	private JLabel label_22 = new JLabel("배달");
	private JLabel label_23 = new JLabel("특이사항");
	private JButton button_5 = new JButton("입력");
	private JLabel label_24 = new JLabel("요청시간");
	private JLabel label_25 = new JLabel("주문");
	private JLabel label_26 = new JLabel("요청사항");
	private JTextField txtEx = new JTextField();
	JScrollPane scrollPane_3 = new JScrollPane(table_1);
	JTextArea txtrAa = new JTextArea();
	JTextArea textArea = new JTextArea();
	JComboBox comboBox = new JComboBox();
	JButton btnNewButton_2 = new JButton("검색");
	JLabel label_8 = new JLabel("ㅇ분류");
	Date today = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 / HH시 mm분");
	JScrollPane scrollPane_4 = new JScrollPane();
	private JLabel label_27 = new JLabel();
	private JLabel lblNewLabel_2 = new JLabel("분");
	DefaultTableModel model = new DefaultTableModel();
	Vector vector11 = new Vector();
	Vector vector2 = new Vector();
	Vector menuAllSelectedVector = new Vector();
	String nowTime;
	Calendar cal;
	DefaultTableModel model1 = new DefaultTableModel();
	Calendar cal1 = Calendar.getInstance();
	DefaultTableModel model4 = new DefaultTableModel();
	DefaultTableModel model5 = new DefaultTableModel();
	DefaultTableModel model6 = new DefaultTableModel();
	Vector vector4 = new Vector();
	public OrderSheetView(CustomerDto customerDto) throws ClassNotFoundException, SQLException {
		super("주문서");
		this.init();
		realTime();
		getColumn1();
		viewData(customerDto);
		getColumn();
		getColumn4();
		jTableRefresh(new MenuDao().menuAllPart());
		jTableRefresh4(new OrderItemDao().getBestSellingItem(Integer.parseInt(textField_3.getText().trim())));
		jTableRefresh5(new OrderItemDao().getSellingItemDate3D(Integer.parseInt(textField_3.getText().trim())));
		jTableRefresh6(new OrderItemDao().getSellingItemDateM(Integer.parseInt(textField_3.getText().trim())));

		
		this.start();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1150,720);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
		this.setResizable(false);
		this.setVisible(true);

	}

	void init() {
		textField_2.setBounds(81, 7, 147, 21);
		textField_2.setColumns(10);
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		textField.setEditable(false);
		textField.setBounds(85, 124, 171, 18);
		textField.setColumns(10);
		getContentPane().setLayout(null);
		panel_3.setBounds(345, 62, 509, 620);

		panel_3.setBackground(Color.WHITE);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		panel_8.setBounds(305, 6, 189, 25);
		panel_3.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 2, 0, 0));
		panel_8.add(button_2);

		panel_8.add(btnNewButton_1);

		tabbedPane_2.setBounds(12, 145, 484, 273);
		panel_3.add(tabbedPane_2);

		tabbedPane_2.addTab("ㅇ주문내역", null, panel_5, null);
		panel_5.setLayout(null);
		textField_7.setEditable(false);
		textField_7.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_7.setText("0");
		textField_7.setBounds(282, 206, 107, 25);
		textField_7.setColumns(10);

		panel_5.add(textField_7);
		textField_1.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_1.setForeground(Color.RED);
		textField_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		textField_1.setEditable(false);
		textField_1.setBounds(79, 200, 171, 38);
		textField_1.setColumns(10);

		panel_5.add(textField_1);


		scrollPane_3.setBounds(12, 10, 455, 156);
		panel_5.add(scrollPane_3);

		scrollPane_3.setViewportView(table_1);
		textField.setColumns(10);
		textField.setBounds(79, 176, 171, 25);

		panel_5.add(textField);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label.setBackground(Color.GRAY);
		label.setAlignmentX(0.5f);
		label.setBounds(12, 176, 67, 25);

		panel_5.add(label);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_6.setBackground(Color.GRAY);
		label_6.setAlignmentX(0.5f);
		label_6.setBounds(12, 201, 67, 37);

		panel_5.add(label_6);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_15.setBackground(Color.GRAY);
		label_15.setAlignmentX(0.5f);
		label_15.setBounds(282, 182, 67, 25);

		panel_5.add(label_15);
		

		button_6.setBounds(410, 176, 57, 25);
		panel_5.add(button_6);

		tabbedPane_3.setBounds(12, 428, 484, 182);
		panel_3.add(tabbedPane_3);

		tabbedPane_3.addTab("ㅇ배송정보", null, panel, null);
		panel.setLayout(null);

		tabbedPane_3.addTab("ㅇ요청사항", null, panel_11, null);
		panel_11.setLayout(null);


		txtrAa.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		txtrAa.setBounds(79, 69, 389, 74);
		panel_11.add(txtrAa);
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_22.setBackground(Color.GRAY);
		label_22.setAlignmentX(0.5f);
		label_22.setBounds(12, 10, 67, 25);

		panel_11.add(label_22);
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_24.setBackground(Color.GRAY);
		label_24.setAlignmentX(0.5f);
		label_24.setBounds(12, 34, 67, 25);

		panel_11.add(label_24);
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_25.setBackground(Color.GRAY);
		label_25.setAlignmentX(0.5f);
		label_25.setBounds(12, 69, 67, 25);

		panel_11.add(label_25);
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_26.setBackground(Color.GRAY);
		label_26.setAlignmentX(0.5f);
		label_26.setBounds(12, 93, 67, 25);

		panel_11.add(label_26);
		
		cal1.add(Calendar.MINUTE, 40);
	
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String predictTime = format.format(cal1.getTime());
		txtEx.setText(predictTime);
		
		txtEx.setColumns(10);
		txtEx.setBounds(79, 10, 389, 25);

		panel_11.add(txtEx);


		tabbedPane_3.addTab("ㅇ특이사항", null, panel_4, null);
		panel_4.setLayout(null);


		textArea.setBounds(78, 10, 389, 133);
		panel_4.add(textArea);
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_23.setBackground(Color.GRAY);
		label_23.setAlignmentX(0.5f);
		label_23.setBounds(12, 10, 67, 25);

		panel_4.add(label_23);

		tabbedPane_1.setBounds(12, 10, 484, 125);
		panel_3.add(tabbedPane_1);

		tabbedPane_1.addTab("ㅇ고객정보", null, panel_6, null);
		panel_6.setLayout(null);
		textField_3.setColumns(10);
		textField_3.setBounds(79, 5, 151, 25);

		panel_6.add(textField_3);
		textField_6.setColumns(10);
		textField_6.setBounds(79, 65, 314, 25);

		panel_6.add(textField_6);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_14.setBackground(Color.GRAY);
		label_14.setAlignmentX(0.5f);
		label_14.setBounds(12, 5, 67, 25);

		panel_6.add(label_14);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_2.setBackground(Color.GRAY);
		label_2.setAlignmentX(0.5f);
		label_2.setBounds(12, 65, 67, 25);

		panel_6.add(label_2);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_3.setBackground(Color.GRAY);
		label_3.setAlignmentX(0.5f);
		label_3.setBounds(12, 35, 67, 25);

		panel_6.add(label_3);
		textField_2.setColumns(10);
		textField_2.setBounds(79, 35, 151, 25);

		panel_6.add(textField_2);
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_19.setBackground(Color.GRAY);
		label_19.setAlignmentX(0.5f);
		label_19.setBounds(246, 5, 67, 25);

		panel_6.add(label_19);
		textField_15.setBounds(313, 5, 153, 25);
		textField_15.setModel(new DefaultComboBoxModel(new String[] {"채널선택", "전화", "어플", "문자", "ARS", "웹페이지"}));

		panel_6.add(textField_15);
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_20.setBackground(Color.GRAY);
		label_20.setAlignmentX(0.5f);
		label_20.setBounds(246, 35, 67, 25);

		panel_6.add(label_20);
		textField_16.setEnabled(false);
		textField_16.setModel(new DefaultComboBoxModel(new String[] {"등급선택", "신규고객", "일반고객", "단골고객", "VIP고객"}));
		textField_16.setBounds(313, 35, 153, 25);

		panel_6.add(textField_16);
		button_3.setBounds(409, 65, 57, 25);

		panel_6.add(button_3);
		panel_7.setBounds(-2, 0, 1150, 55);

		panel_7.setBackground(Color.RED);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(Color.WHITE);

		lblNewLabel_4.setBounds(88, 6, 133, 20);
		panel_7.add(lblNewLabel_4);
		label_1.setFont(new Font("굴림", Font.PLAIN, 12));
		label_1.setForeground(Color.LIGHT_GRAY);


		label_1.setBounds(88, 28, 297, 20);
		panel_7.add(label_1);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(478, 16, 272, 25);

		panel_7.add(lblNewLabel);
		label_21.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label_21.setForeground(Color.WHITE);
		label_21.setBounds(392, 16, 74, 25);

		panel_7.add(label_21);

		panel.setBounds(1046, 111, 216, 149);

		panel.setLayout(null);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_4.setBackground(Color.GRAY);
		label_4.setAlignmentX(0.5f);
		label_4.setBounds(12, 10, 67, 25);

		panel.add(label_4);
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_16.setBackground(Color.GRAY);
		label_16.setAlignmentX(0.5f);
		label_16.setBounds(12, 46, 67, 25);

		panel.add(label_16);
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_17.setBackground(Color.GRAY);
		label_17.setAlignmentX(0.5f);
		label_17.setBounds(12, 82, 67, 25);

		panel.add(label_17);
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_18.setBackground(Color.GRAY);
		label_18.setAlignmentX(0.5f);
		label_18.setBounds(12, 118, 67, 25);

		panel.add(label_18);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_5.setBackground(Color.GRAY);
		label_5.setAlignmentX(0.5f);
		label_5.setBounds(248, 10, 67, 25);

		panel.add(label_5);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_7.setBackground(Color.GRAY);
		label_7.setAlignmentX(0.5f);
		label_7.setBounds(248, 46, 67, 25);

		panel.add(label_7);
		textField_4.setColumns(10);
		textField_4.setBounds(79, 10, 157, 25);

		panel.add(textField_4);
		textField_5.setBounds(315, 10, 152, 25);

		panel.add(textField_5);
		textField_8.setText("40");
		textField_8.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_8.setColumns(10);
		textField_8.setBounds(315, 46, 122, 25);

		panel.add(textField_8);
		textField_9.setColumns(10);
		textField_9.setBounds(79, 46, 157, 25);

		panel.add(textField_9);
		textField_10.setColumns(10);
		textField_10.setBounds(79, 82, 319, 25);

		panel.add(textField_10);
		textField_11.setColumns(10);
		textField_11.setBounds(79, 118, 319, 25);

		panel.add(textField_11);
		button_4.setBounds(410, 81, 57, 25);

		panel.add(button_4);
		panel_1.setBounds(12, 62, 321, 619);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		scrollPane.setBounds(12, 56, 296, 553);
		panel_1.add(scrollPane);

		scrollPane.setViewportView(table);
		panel_9.setBounds(12, 10, 296, 35);
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"전체보기", "치킨류", "사이드류", "음료류"}));


		comboBox.setEditable(true);
		comboBox.setBounds(78, 6, 149, 25);
		panel_9.add(comboBox);


		btnNewButton_2.setBounds(238, 6, 57, 25);
		panel_9.add(btnNewButton_2);


		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_8.setBackground(Color.GRAY);
		label_8.setAlignmentX(0.5f);
		label_8.setBounds(1, 5, 67, 25);
		panel_9.add(label_8);
		tabbedPane.setBounds(866, 63, 265, 524);

		getContentPane().add(tabbedPane);

		tabbedPane.addTab("ㅇ구매정보", null, panel_2, null);
		panel_2.setLayout(null);
		panel_12.setBounds(12, 242, 236, -230);

		panel_2.add(panel_12);
		panel_12.setLayout(null);
		tabbedPane_4.setBounds(12, 227, 236, 258);

		panel_2.add(tabbedPane_4);

		tabbedPane_4.addTab("3일간 주문메뉴", null, scrollPane_1, null);

		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);

		tabbedPane_4.addTab("한달간 주문메뉴", null, scrollPane_2, null);

		table_3 = new JTable();
		scrollPane_2.setViewportView(table_3);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_10.setBackground(Color.GRAY);
		label_10.setAlignmentX(0.5f);
		label_10.setBounds(12, 10, 67, 25);

		panel_2.add(label_10);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_12.setBackground(Color.GRAY);
		label_12.setAlignmentX(0.5f);
		label_12.setBounds(12, 45, 67, 25);

		panel_2.add(label_12);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_13.setBackground(Color.GRAY);
		label_13.setAlignmentX(0.5f);
		label_13.setBounds(12, 79, 90, 25);

		panel_2.add(label_13);


		scrollPane_4.setBounds(12, 103, 236, 114);
		panel_2.add(scrollPane_4);

		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);
		textField_13.setText("0");
		textField_13.setColumns(10);
		textField_13.setBounds(79, 10, 90, 25);

		panel_2.add(textField_13);
		textField_14.setColumns(10);
		textField_14.setBounds(79, 45, 42, 25);

		panel_2.add(textField_14);
		lblNewLabel_1.setBounds(127, 50, 25, 15);

		panel_2.add(lblNewLabel_1);
		label_9.setBounds(174, 15, 25, 15);

		panel_2.add(label_9);
		textField_12.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(146, 45, 82, 25);

		panel_2.add(textField_12);
		label_11.setBounds(235, 50, 25, 15);

		panel_2.add(label_11);
		panel_10.setBounds(866, 597, 265, 85);

		getContentPane().add(panel_10);
		panel_10.setLayout(null);
		btnNewButton.setBounds(183, 10, 70, 65);

		panel_10.add(btnNewButton);
		button.setBounds(99, 10, 70, 65);

		panel_10.add(button);
		button_1.setBounds(12, 10, 70, 65);

		panel_10.add(button_1);
		
		textField_11.setEditable(false);
		lblNewLabel_2.setBounds(446, 46, 33, 25);

		panel.add(lblNewLabel_2);
		lblNewLabel.setText(format.format(today));
		label_27.setBounds(35, 12, 32, 32);
		label_27.setIcon(new ImageIcon("img/paste.png"));

		panel_7.add(label_27);
		textField_14.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_14.setEditable(false);
		textField_13.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_13.setEditable(false);
		button_5.setBounds(192, 10, 56, 25);
		panel_2.add(button_5);
	}

	void start() {
		btnNewButton.addActionListener(this);
		table.addMouseListener(this);
		table_1.addMouseListener(this);
		button_6.addActionListener(this);
		button.addActionListener(this);
		btnNewButton_2.addActionListener(this);
	}

	public Vector getColumn(){
		vector1.add("메뉴이름");
		vector1.add("메뉴가격");
		vector1.add("메뉴분류");
		return vector1;
	}

	public Vector getColumn1(){
		vector2.add("메뉴이름");
		vector2.add("메뉴가격");
		vector2.add("메뉴분류");
		vector2.add("메뉴수량");
		return vector2;
	}
	
	public Vector getColumn4(){
		vector4.add("메뉴이름");
		vector4.add("구매수량");
		return vector4;
	}

	public void jTableRefresh(Vector menuDto) throws ClassNotFoundException, SQLException{

		model.setDataVector(menuDto, vector1);
		table.setModel(model);
	}

	public void jTableRefresh1(Vector menuDto) throws ClassNotFoundException, SQLException{

		model1.setDataVector(menuDto, vector2);
		table_1.setModel(model1);

		//table_1.setBackground(Color.getColor("F0F0F0"));
		//TableColumn column4 = table_1.getColumnModel().getColumn(4);
	}
	public void jTableRefresh4(Vector menuDto) throws ClassNotFoundException, SQLException{

		model4.setDataVector(menuDto, vector4);
		table_4.setModel(model4);

		//table_1.setBackground(Color.getColor("F0F0F0"));
		//TableColumn column4 = table_1.getColumnModel().getColumn(4);
	}
	
	public void jTableRefresh5(Vector menuDto) throws ClassNotFoundException, SQLException{

		model5.setDataVector(menuDto, vector4);
		table_2.setModel(model5);

		//table_1.setBackground(Color.getColor("F0F0F0"));
		//TableColumn column4 = table_1.getColumnModel().getColumn(4);
	}
	
	public void jTableRefresh6(Vector menuDto) throws ClassNotFoundException, SQLException{

		model6.setDataVector(menuDto, vector4);
		table_3.setModel(model6);

		//table_1.setBackground(Color.getColor("F0F0F0"));
		//TableColumn column4 = table_1.getColumnModel().getColumn(4);
	}
	
	private void viewData(CustomerDto customerDto) throws ClassNotFoundException, SQLException{
	

		
		int customerNum = customerDto.getCustomerNum();
		String a = customerDto.getCustomerAddState();
		String b = customerDto.getCustomerAddCity();
		String c = customerDto.getCustomerAddStreet();
		String d = customerDto.getCustomerAddRest();
		String address = (a + " " + b + " " + c + " " + d);
		int customerAgePredict = customerDto.getCustomerAgePredict();
		int customerGender = customerDto.getCustomerGender();
		String customerPhoneNum = customerDto.getCustomerPhoneNum();
		String customerRegDate = customerDto.getCustomerRegDate();
		String customerNoteInfo = customerDto.getCustomerNoteInfo();
		String customerGradeName = customerDto.getCustomerGradeName();
		
		textField_16.setSelectedItem(customerGradeName);
		textField_3.setEditable(false);
		textField_3.setHorizontalAlignment(SwingConstants.TRAILING);

		textField_3.setText(String.valueOf(customerNum));
		textField_4.setEditable(false);
		textField_4.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_4.setText(String.valueOf(customerNum));
		textField_6.setEditable(false);
		textField_6.setText(address);
		textField_10.setEditable(false);
		textField_10.setText(address);
		textField_2.setEditable(false);
		textField_2.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_2.setText(customerPhoneNum);
		textField_9.setEditable(false);
		textField_9.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_9.setText(customerPhoneNum);

		System.out.println(new OrderItemDao().getBestSellingItem(1));
		Vector allUserIdList = new UserInfoDao().getAllUserIdList();
		for(int i = 0;i<allUserIdList.size();i++){
			textField_5.addItem(allUserIdList.get(i));;
		}
		
		OrderInfoDao orderInfoDao = new OrderInfoDao();
		int orderInfoCount = orderInfoDao.getOneCustomerOrderFrequency(customerNum);
		textField_14.setText(String.valueOf(orderInfoCount));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int sumOrder = new OrderItemDao().getBestSellingItemSum(customerNum);
		String time = format.format(cal.getTime());
		textField_11.setText(time);
		textArea.setText(customerNoteInfo);
		textField_12.setText(String.valueOf(sumOrder));
		
		
	}

	public void realTime() {

		cal = Calendar.getInstance();

		String ampm;
		if(cal.get(Calendar.AM_PM)==0){
			ampm= "AM";
		}else{
			ampm= "PM";
		}
		nowTime = cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH)+1) + "월 " + cal.get(Calendar.DATE) + "일 " +
				ampm + " " + cal.get(Calendar.HOUR) + "시 " + cal.get(Calendar.MINUTE) + "분 " + cal.get(Calendar.SECOND) + "초 ";

		lblNewLabel.setText(nowTime);

	}

	public void getAllFieldData() {
		//고객 테이블에 들어가야할 내용

		//주문정보 테이블에 들어가야할 내용

		//주문아이템 테이블에 들어가야할 내용
		//
	}
	
	private void fireEditingStopped() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource()==btnNewButton_2){
			if(comboBox.getSelectedItem().equals("전체보기")){
				Vector menuAllPart;
				try {
					menuAllPart = new MenuDao().menuAllPart();
					jTableRefresh(menuAllPart);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else{
				
				try {
					Vector menuAllGroupPart = new MenuDao().menuAllGroupPart(comboBox.getSelectedItem().toString());
					jTableRefresh(menuAllGroupPart);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
		if(e.getSource()==btnNewButton){
			this.dispose();
		}
		
		if(e.getSource()==button_6){
			model1.removeRow(table_1.getSelectedRow());
			System.out.println("테이블에 리스너 작동");

			System.out.println(table_1.getRowCount());
			int sum = 0;
			int discount = Integer.parseInt(textField_7.getText());
			//sum = sum-discount;
			for(int i = 0;i<table_1.getRowCount();i++){
				System.out.println((table_1.getValueAt(i, 1)));
				int price = Integer.parseInt((table_1.getValueAt(i, 1)).toString());
				int num = Integer.parseInt((table_1.getValueAt(i, 3)).toString());
				int subSum = (price * num);

				sum += subSum;

				textField.setText(String.valueOf(sum));
				textField_1.setText(String.valueOf(sum-discount));
				

			
			}
			
			
		}
		
		if(e.getSource()==button){
			boolean a = false;
			System.out.println("저장 버튼 누름");
			cal.add(Calendar.MINUTE, Integer.parseInt(textField_8.getText().toString()));
			try{
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String predictTime = format.format(cal.getTime());
				System.out.println(predictTime);
				OrderInfoDto orderInfoDto = new OrderInfoDto();

				orderInfoDto.setOrderInfoDate(textField_11.getText().toString());
				orderInfoDto.setOrderInfoLocPossibility("1");
				orderInfoDto.setOrderInfoOrderPossibility("1");
				orderInfoDto.setOrderInfoRequestInfo(txtrAa.getText().trim().toString());
				orderInfoDto.setOrderInfoChannelName(textField_15.getSelectedItem().toString());
				orderInfoDto.setOrderInfoRequestDelivery(txtEx.getText().trim().toString());
				orderInfoDto.setOrderInfoPackCompletion("0");
				orderInfoDto.setOrderInfoDeliveryCompletion("0");
				orderInfoDto.setOrderInfoOrderCompletion("0");
				orderInfoDto.setOrderInfoMoneyCollection("0");
				orderInfoDto.setOrderInfoDeliveryPredict(predictTime);
				orderInfoDto.setOrderInfoCustomerNum(Integer.parseInt(textField_3.getText().trim()));
				orderInfoDto.setOrderInfoUserInfoId(textField_5.getSelectedItem().toString());
				System.out.println(orderInfoDto.toString());
				System.out.println("입력3");
				OrderInfoDao orderInfoDao = new OrderInfoDao();
				orderInfoDao.addOrderSheet(orderInfoDto);
				a = true;
			}catch(Exception e1){

			}
			System.out.println(a);
			if(a){
				//가장 마지막에 생성된 주문번호를 매개변수로 찾아야함
				OrderInfoDao orderInfoDao = new OrderInfoDao();
				try {
					System.out.println(orderInfoDao.getLastOrderNum());
				} catch (ClassNotFoundException | SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				for(int i = 0;i<table_1.getRowCount();i++){
					OrderItemDto orderItemDto = new OrderItemDto();
					try {
						orderItemDto.setOrderItemOrderInfoNum(orderInfoDao.getLastOrderNum().getOrderInfoNum());
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					orderItemDto.setOrderItemMenuName(table_1.getValueAt(i, 0).toString());
					orderItemDto.setOrderItemQuantity(Integer.parseInt(table_1.getValueAt(i, 3).toString()));

					OrderItemDao orderItemDao = new OrderItemDao();
					try {
						orderItemDao.addOneOrderItem(orderItemDto);
						
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "주문서가 저장되었습니다");
				this.dispose();
				try {
					OrderMainView orderMainView = new OrderMainView();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "주문서가 제대로 작성되지 않았습니다");
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==table){
			int r = table.getSelectedRow();
			String menuName = String.valueOf(table.getValueAt(r, 0));
			int menuPrice = Integer.parseInt(String.valueOf(table.getValueAt(r, 1)));
			String menuGroupName = String.valueOf(table.getValueAt(r, 2));
			//현재 선택한 열의 값으로 table_1에서 한줄씩 검색으로 해서 존재하지 않을때만 추가
			int a = 0;
			for(int i = 0;i<table_1.getRowCount();i++){
				if(!(table_1.getValueAt(i, 0).equals(menuName))){
					a = a;
				}else{
					a = a + 1;
				}
			}

			if(a==0){
				Vector menuSelectedVector = new Vector();
				menuSelectedVector.add(menuName);
				menuSelectedVector.add(menuPrice);
				menuSelectedVector.add(menuGroupName);
				menuSelectedVector.add(1);
				menuSelectedVector.add("-");
				menuAllSelectedVector.add(menuSelectedVector);


				try {
					jTableRefresh1(menuAllSelectedVector);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(table_1.getRowCount());
				int sum = 0;
				int discount = Integer.parseInt(textField_7.getText());
				//sum = sum-discount;
				for(int i = 0;i<table_1.getRowCount();i++){
					System.out.println((table_1.getValueAt(i, 1)));
					int price = Integer.parseInt((table_1.getValueAt(i, 1)).toString());
					int num = Integer.parseInt((table_1.getValueAt(i, 3)).toString());
					int subSum = (price * num);

					sum += subSum;

					textField.setText(String.valueOf(sum));
					textField_1.setText(String.valueOf(sum-discount));
				}
			}else{
				System.out.println("이미 존재하는 메뉴이름");
			}
		}
		
		if(e.getSource()==table_1){
			if(e.getSource()==table_1){
				System.out.println("테이블에 리스너 작동");

				System.out.println(table_1.getRowCount());
				int sum = 0;
				int discount = Integer.parseInt(textField_7.getText());
				//sum = sum-discount;
				for(int i = 0;i<table_1.getRowCount();i++){
					System.out.println((table_1.getValueAt(i, 1)));
					int price = Integer.parseInt((table_1.getValueAt(i, 1)).toString());
					int num = Integer.parseInt((table_1.getValueAt(i, 3)).toString());
					int subSum = (price * num);

					sum += subSum;

					textField.setText(String.valueOf(sum));
					textField_1.setText(String.valueOf(sum-discount));
					

				
				}
			}else{
				System.out.println("이미 존재하는 메뉴이름");
			}
			
			Point point = e.getPoint();
			System.out.println("작동");
			if (table_1.columnAtPoint(point) == 4) {
				fireEditingStopped();
				int row = table.rowAtPoint(point);
				if (row >= 0) {
					model1.removeRow(row);
				}

			}

			table.repaint();
		}
		
		if(e.getSource()==table_1){
			System.out.println("테이블에 리스너 작동");

			System.out.println(table_1.getRowCount());
			int sum = 0;
			int discount = Integer.parseInt(textField_7.getText());
			//sum = sum-discount;
			for(int i = 0;i<table_1.getRowCount();i++){
				System.out.println((table_1.getValueAt(i, 1)));
				int price = Integer.parseInt((table_1.getValueAt(i, 1)).toString());
				int num = Integer.parseInt((table_1.getValueAt(i, 3)).toString());
				int subSum = (price * num);

				sum += subSum;

				textField.setText(String.valueOf(sum));
				textField_1.setText(String.valueOf(sum-discount));
			}
		}else{
			System.out.println("이미 존재하는 메뉴이름");
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
