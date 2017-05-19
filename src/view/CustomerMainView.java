package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import setting.SetLookAndFeel;
import setting.SetUiFont;

public class CustomerMainView extends JFrame {
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JTextField jTextField4;
	private JTextField jTextField5;
	
	private JLabel jLabel1 = new JLabel("ㅇ회원정보");
	
	private JTable jTable1;
	private JTable jTable2;
	
	private Font font1 = new Font("맑은 고딕", Font.BOLD, 15);

	public CustomerMainView() {
		super("고객관리");
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
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 62, 376, 620);
		getContentPane().add(tabbedPane);

		Panel panel_2 = new Panel();
		panel_2.setFocusTraversalKeysEnabled(false);
		tabbedPane.addTab("ㅇ고객검색", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel label = new JLabel("에서");
		label.setBounds(294, 14, 57, 15);
		panel_2.add(label);

		JButton btnNewButton = new JButton("검색");
		btnNewButton.setBounds(294, 42, 65, 25);
		panel_2.add(btnNewButton);

		jTextField5 = new JTextField();
		jTextField5.setBounds(12, 42, 278, 25);
		panel_2.add(jTextField5);
		jTextField5.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "고객전체현황", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 489, 347, 92);
		panel_2.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(25, 30, 300, 50);
		panel_1.add(panel);
		panel.setLayout(new GridLayout(1, 2, 7, 7));

		JButton button_7 = new JButton("파일저장");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_7);

		JButton button_6 = new JButton("프린트");
		panel.add(button_6);

		jTable2 = new JTable();
		jTable2.setBounds(12, 75, 347, 404);
		panel_2.add(jTable2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 11, 278, 25);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"이름","전화번호","주소"}));
		panel_2.add(comboBox);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(398, 62, 864, 620);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("ㅇ고객정보");
				lblNewLabel.setBounds(28, 14, 87, 25);
				panel_3.add(lblNewLabel);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 10, 840, 33);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("등록일자");
		lblNewLabel_1.setBounds(594, 4, 57, 25);
		panel_4.add(lblNewLabel_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(663, 4, 165, 25);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"이름","전화번호","주소"})); // 날짜 콤보박스... 날짜별로 for문으로 수정
		panel_4.add(comboBox_1);
		

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(12, 544, 840, 66);
		panel_3.add(panel_8);
		panel_8.setLayout(null);
		
		JButton btnf_5 = new JButton("닫기(F12)");
		btnf_5.setBounds(738, 8, 90, 50);
		panel_8.add(btnf_5);
		
		JButton btnf_4 = new JButton("저장(F11)");
		btnf_4.setBounds(640, 8, 90, 50);
		panel_8.add(btnf_4);
		
		JButton btnf_2 = new JButton("출력(F7)");
		btnf_2.setBounds(445, 8, 90, 50);
		panel_8.add(btnf_2);
		
		JButton btnf_1 = new JButton("신규(F6)");
		btnf_1.setBounds(346, 8, 90, 50);
		panel_8.add(btnf_1);
		
		JButton btnf_3 = new JButton("삭제(F10)");
		btnf_3.setBounds(544, 8, 90, 50);
		panel_8.add(btnf_3);
		
		JButton btnf = new JButton("주문내역보기(F5)");
		btnf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnf.setBounds(10, 8, 220, 50);
		panel_8.add(btnf);
		
				JButton button_5 = new JButton("New button");
				button_5.setBounds(246, 8, 90, 50);
				panel_8.add(button_5);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(12, 373, 840, 160);
		panel_3.add(tabbedPane_1);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_1.addTab("ㅇ특이사항1", null, panel_9, null);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		tabbedPane_1.addTab("ㅇ특이사항2", null, panel_10, null);
		panel_10.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		tabbedPane_1.addTab("ㅇ특이사항3", null, panel_11, null);
		panel_11.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(12, 53, 840, 200);
		panel_3.add(panel_5);

		JLabel label_2 = new JLabel("이름");
		label_2.setBounds(12, 10, 57, 15);
		panel_5.add(label_2);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(12, 35, 57, 15);
		panel_5.add(lblNewLabel_5);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(12, 117, 57, 15);
		panel_5.add(label_4);
		
		jTextField2 = new JTextField();
		jTextField2.setBounds(81, 7, 116, 21);
		panel_5.add(jTextField2);
		jTextField2.setColumns(10);
		
		jTextField3 = new JTextField();
		jTextField3.setBounds(81, 32, 116, 21);
		panel_5.add(jTextField3);
		jTextField3.setColumns(10);
		
		jTextField4 = new JTextField();
		jTextField4.setBounds(81, 114, 116, 21);
		panel_5.add(jTextField4);
		jTextField4.setColumns(10);
		
		jTable1 = new JTable();
		jTable1.setBounds(81, 61, 116, 43);
		panel_5.add(jTable1);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(12, 263, 840, 100);
		panel_3.add(panel_6);

		JLabel label_3 = new JLabel("주소");
		label_3.setBounds(12, 10, 57, 15);
		panel_6.add(label_3);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(105, 7, 30, 21);
		panel_6.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(201, 7, 30, 21);
		panel_6.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(279, 7, 30, 21);
		panel_6.add(comboBox_4);
		
		jTextField1 = new JTextField();
		jTextField1.setBounds(179, 38, 116, 21);
		panel_6.add(jTextField1);
		jTextField1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(105, 75, 57, 15);
		panel_6.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(105, 41, 57, 15);
		panel_6.add(lblNewLabel_3);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.YELLOW);
		panel_7.setBounds(-2, 0, 1280, 55);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("회원관리");
		lblNewLabel_4.setBounds(88, 6, 133, 20);
		panel_7.add(lblNewLabel_4);

		JLabel label_1 = new JLabel("고객정보를 입력하고 주문내역을 조회합니다");
		label_1.setBounds(88, 28, 297, 20);
		panel_7.add(label_1);
	}

	void start() {

	}
}


