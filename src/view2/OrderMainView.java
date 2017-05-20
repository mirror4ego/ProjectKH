package view2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import setting.SetLookAndFeel;
import setting.SetUiFont;

public class OrderMainView extends JFrame implements MouseListener{
	
	private JTextField jTextField1 = new JTextField();
	private JTextField jTextField2 = new JTextField();
	private JTextField jTextField3 = new JTextField();
	private JTextField jTextField4 = new JTextField();
	private JTextField jTextField5 = new JTextField();
		
	private JComboBox comboBox = new JComboBox();
	private JComboBox comboBox_1 = new JComboBox();
	private JComboBox comboBox_2 = new JComboBox();
	private JComboBox comboBox_3 = new JComboBox();
	private JComboBox comboBox_4 = new JComboBox();
	
	private JPanel panel_1 = new JPanel();
	private JPanel panel = new JPanel();
	private JPanel panel_3 = new JPanel();
	private JPanel panel_4 = new JPanel();
	private JPanel panel_7 = new JPanel();
	private JPanel panel_8 = new JPanel();
	private JPanel panel_9 = new JPanel();
	private JPanel panel_10 = new JPanel();
	private JPanel panel_11 = new JPanel();
	private JPanel panel_5 = new JPanel();
	private JPanel panel_6 = new JPanel();
	private JPanel panel_2 = new JPanel();
		
	private JLabel lblNewLabel_1 = new JLabel("등록일자");
	private JLabel lblNewLabel = new JLabel("ㅇ고객정보");
	private JLabel lblNewLabel_2 = new JLabel("New label");
	private JLabel lblNewLabel_3 = new JLabel("New label");
	private JLabel lblNewLabel_4 = new JLabel("주문리스트");
	private JLabel label_1 = new JLabel("고객정보를 입력하고 주문내역을 조회합니다");
	private JLabel label_2 = new JLabel("이름");
	private JLabel lblNewLabel_5 = new JLabel("New label");
	private JLabel label_4 = new JLabel("New label");
	private JLabel label_3 = new JLabel("주소");
	private JLabel label = new JLabel("에서");
	private JLabel jLabel1 = new JLabel("ㅇ회원정보");
	private JLabel lblNewLabel_8 = new JLabel("가족사항");
	private JLabel label_5 = new JLabel("가족사항");
	private JLabel label_6 = new JLabel("가족사항");
	
	private JButton btnNewButton = new JButton("검색");
	private JButton button_6 = new JButton("프린트");
	private JButton btnf_5 = new JButton("닫기(F12)");
	private JButton btnf_4 = new JButton("저장(F11)");
	private JButton btnf_2 = new JButton("출력(F7)");
	private JButton btnf = new JButton("주문내역보기(F5)");
	private JButton btnf_1 = new JButton("신규(F6)");
	private JButton btnf_3 = new JButton("삭제(F10)");
	private JButton button_5 = new JButton("New button");
	private JButton button_7 = new JButton("파일저장");

	private JTable jTable1 = new JTable();
	private JTable jTable2 = new JTable();

	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	
	private Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
	
	public OrderMainView() {
		super("주문내역 관리");
		SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
		SetUiFont setUiFont = new SetUiFont();
		this.init();
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
	}
	
	void init() {
		tabbedPane.setBounds(10, 62, 376, 620);
		getContentPane().add(tabbedPane);

		tabbedPane.addTab("ㅇ고객검색", null, panel_2, null);
		panel_2.setLayout(null);

		comboBox.setBounds(12, 10, 278, 25);
		panel_2.add(comboBox);
		comboBox.setOpaque(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"이름","전화번호","주소"}));

		label.setBounds(294, 14, 57, 15);
		panel_2.add(label);

		btnNewButton.setBounds(294, 42, 65, 25);
		panel_2.add(btnNewButton);

		jTextField5.setBounds(12, 42, 278, 25);
		panel_2.add(jTextField5);
		jTextField5.setColumns(10);

		panel_1.setBorder(new TitledBorder(null, "고객전체현황", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 489, 347, 92);
		panel_2.add(panel_1);
		panel_1.setLayout(null);

		panel.setBounds(25, 30, 300, 50);
		panel_1.add(panel);
		panel.setLayout(new GridLayout(1, 2, 7, 7));

		panel.add(button_7);
		panel.add(button_6);

		jTable2.setBounds(12, 75, 347, 404);
		panel_2.add(jTable2);

		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(398, 62, 864, 620);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		lblNewLabel.setBounds(28, 14, 87, 25);
		panel_3.add(lblNewLabel);

		panel_4.setBounds(12, 10, 840, 33);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		lblNewLabel_1.setBounds(594, 4, 57, 25);
		panel_4.add(lblNewLabel_1);

		comboBox_1.setBounds(663, 4, 165, 25);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"이름","전화번호","주소"})); // 날짜 콤보박스... 날짜별로 for문으로 수정
		panel_4.add(comboBox_1);
		
		panel_8.setBounds(12, 544, 840, 66);
		panel_3.add(panel_8);
		panel_8.setLayout(null);
		
		btnf_5.setBounds(738, 8, 90, 50);
		panel_8.add(btnf_5);
		
		btnf_4.setBounds(640, 8, 90, 50);
		panel_8.add(btnf_4);
		
		btnf_2.setBounds(445, 8, 90, 50);
		panel_8.add(btnf_2);
		
		btnf_1.setBounds(346, 8, 90, 50);
		panel_8.add(btnf_1);
		
		btnf_3.setBounds(544, 8, 90, 50);
		panel_8.add(btnf_3);
		
		btnf.setBounds(10, 8, 220, 50);
		panel_8.add(btnf);
		
				button_5.setBounds(246, 8, 90, 50);
				panel_8.add(button_5);

		tabbedPane_1.setBounds(12, 373, 840, 160);
		panel_3.add(tabbedPane_1);
		
		tabbedPane_1.addTab("ㅇ특이사항", null, panel_9, null);
		panel_9.setLayout(null);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_6.setBackground(Color.GRAY);
		label_6.setAlignmentX(0.5f);
		label_6.setBounds(12, 10, 67, 25);
		
		panel_9.add(label_6);
		
		tabbedPane_1.addTab("ㅇ기념일정보", null, panel_10, null);
		panel_10.setLayout(null);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_5.setBackground(Color.GRAY);
		label_5.setAlignmentX(0.5f);
		label_5.setBounds(12, 10, 67, 25);
		
		panel_10.add(label_5);
		
		tabbedPane_1.addTab("ㅇ가족사항", null, panel_11, null);
		panel_11.setLayout(null);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBackground(Color.GRAY);
		lblNewLabel_8.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNewLabel_8.setBounds(12, 10, 67, 25);
		
		panel_11.add(lblNewLabel_8);

		panel_5.setLayout(null);
		panel_5.setBounds(12, 53, 840, 200);
		panel_3.add(panel_5);

		label_2.setBounds(12, 10, 57, 15);
		panel_5.add(label_2);
		
		lblNewLabel_5.setBounds(12, 35, 57, 15);
		panel_5.add(lblNewLabel_5);
		
		label_4.setBounds(12, 117, 57, 15);
		panel_5.add(label_4);
		

		jTextField2.setBounds(81, 7, 116, 21);
		panel_5.add(jTextField2);
		jTextField2.setColumns(10);
		

		jTextField3.setBounds(81, 32, 116, 21);
		panel_5.add(jTextField3);
		jTextField3.setColumns(10);
		

		jTextField4.setBounds(81, 114, 116, 21);
		panel_5.add(jTextField4);
		jTextField4.setColumns(10);
		

		jTable1.setBounds(81, 61, 116, 43);
		panel_5.add(jTable1);

		panel_6.setLayout(null);
		panel_6.setBounds(12, 263, 840, 100);
		panel_3.add(panel_6);

		label_3.setBounds(12, 10, 57, 15);
		panel_6.add(label_3);
		
		comboBox_2.setBounds(105, 7, 30, 21);
		panel_6.add(comboBox_2);
		
		comboBox_3.setBounds(201, 7, 30, 21);
		panel_6.add(comboBox_3);
		
		comboBox_4.setBounds(279, 7, 30, 21);
		panel_6.add(comboBox_4);
		

		jTextField1.setBounds(179, 38, 116, 21);
		panel_6.add(jTextField1);
		jTextField1.setColumns(10);
		
		lblNewLabel_2.setBounds(105, 75, 57, 15);
		panel_6.add(lblNewLabel_2);
		
		lblNewLabel_3.setBounds(105, 41, 57, 15);
		panel_6.add(lblNewLabel_3);

		panel_7.setBackground(Color.YELLOW);
		panel_7.setBounds(-2, 0, 1280, 55);
		
		panel_7.setLayout(null);

		lblNewLabel_4.setBounds(88, 6, 133, 20);
		panel_7.add(lblNewLabel_4);

		label_1.setBounds(88, 28, 297, 20);
		panel_7.add(label_1);
	}
	
	void start() {
		btnf.addMouseListener(this);
		button_7.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
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
