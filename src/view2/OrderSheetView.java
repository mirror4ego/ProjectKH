package view2;

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
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import setting.SetLookAndFeel;
import setting.SetUiFont;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class OrderSheetView extends JFrame {
	private SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
	private SetUiFont setUiFont = new SetUiFont();

	private JLabel jLabel1 = new JLabel("ㅇ회원정보");
	private JLabel lblNewLabel_4 = new JLabel("주문서 관리");
	private JLabel label_1 = new JLabel("주문서를 관리(검색, 삭제) 하는 곳입니다.");
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

	private JScrollPane scrollPane = new JScrollPane();

	private Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
	private JTable table = new JTable();
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panel_2 = new JPanel();
	private final JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JPanel panel_10 = new JPanel();
	private final JButton btnNewButton = new JButton("닫기");
	private final JButton button = new JButton("저장");
	private final JButton button_1 = new JButton("출력");
	private final JPanel panel_11 = new JPanel();
	private final JPanel panel_12 = new JPanel();
	private final JLabel lblNewLabel_2 = new JLabel("소계");
	private final JTextField textField = new JTextField();
	private final JLabel label = new JLabel("합계");
	private final JTextField textField_1 = new JTextField();
	private final JLabel lblNewLabel_3 = new JLabel("New label");
	private final JLabel label_2 = new JLabel("New label");
	private final JLabel label_3 = new JLabel("New label");
	private final JLabel label_4 = new JLabel("New label");
	private final JLabel label_5 = new JLabel("New label");
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JTextField textField_4 = new JTextField();
	private final JTextField textField_5 = new JTextField();
	private final JTextField textField_6 = new JTextField();
	private final JLabel label_6 = new JLabel("할인");
	private final JTextField textField_7 = new JTextField();
	private final JTable table_1 = new JTable();
	private final JButton button_2 = new JButton("신규입력");
	private final JButton btnNewButton_1 = new JButton("동일주문서");

	public OrderSheetView() {
		super("주문서 관리");
		textField_2.setBounds(81, 7, 147, 21);
		textField_2.setColumns(10);
		textField.setBounds(85, 124, 171, 18);
		textField.setColumns(10);
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
		this.setVisible(true);
	}

	void init() {
		getContentPane().setLayout(null);
		panel_3.setBounds(345, 62, 574, 620);

		panel_3.setBackground(Color.WHITE);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		tabbedPane_2.setBounds(12, 171, 551, 218);
		panel_3.add(tabbedPane_2);

		tabbedPane_2.addTab("ㅇ주문내역", null, panel_5, null);
		panel_5.setLayout(null);
		lblNewLabel_2.setBounds(12, 127, 57, 15);
		
		panel_5.add(lblNewLabel_2);
		
		panel_5.add(textField);
		label.setBounds(12, 162, 57, 15);
		
		panel_5.add(label);
		textField_1.setColumns(10);
		textField_1.setBounds(85, 159, 171, 18);
		
		panel_5.add(textField_1);
		label_6.setBounds(297, 134, 57, 15);
		
		panel_5.add(label_6);
		textField_7.setColumns(10);
		textField_7.setBounds(297, 159, 171, 18);
		
		panel_5.add(textField_7);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 10, 453, 101);
		panel_5.add(scrollPane_3);
		
		scrollPane_3.setColumnHeaderView(table_1);

		tabbedPane_3.setBounds(12, 399, 551, 211);
		panel_3.add(tabbedPane_3);

		tabbedPane_3.addTab("ㅇ배송정보", null, panel, null);
		panel.setLayout(null);
		
		tabbedPane_3.addTab("New tab", null, panel_11, null);


		tabbedPane_3.addTab("ㅇ특이사항", null, panel_4, null);

		panel_8.setBounds(368, 8, 195, 27);
		panel_3.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_8.add(button_2);
		
		panel_8.add(btnNewButton_1);

		tabbedPane_1.setBounds(12, 10, 551, 140);
		panel_3.add(tabbedPane_1);

		tabbedPane_1.addTab("ㅇ고객정보", null, panel_6, null);
		panel_6.setLayout(null);
		lblNewLabel_3.setBounds(12, 10, 57, 15);
		
		panel_6.add(lblNewLabel_3);
		label_2.setBounds(12, 35, 57, 15);
		
		panel_6.add(label_2);
		label_3.setBounds(12, 60, 57, 15);
		
		panel_6.add(label_3);
		label_4.setBounds(248, 10, 57, 15);
		
		panel_6.add(label_4);
		label_5.setBounds(248, 35, 57, 15);
		
		panel_6.add(label_5);
		
		panel_6.add(textField_2);
		textField_3.setColumns(10);
		textField_3.setBounds(81, 32, 147, 21);
		
		panel_6.add(textField_3);
		textField_4.setColumns(10);
		textField_4.setBounds(81, 57, 383, 21);
		
		panel_6.add(textField_4);
		textField_5.setColumns(10);
		textField_5.setBounds(317, 7, 147, 21);
		
		panel_6.add(textField_5);
		textField_6.setColumns(10);
		textField_6.setBounds(81, 80, 383, 21);
		
		panel_6.add(textField_6);
		panel_7.setBounds(-2, 0, 1280, 55);

		panel_7.setBackground(Color.BLUE);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);

		lblNewLabel_4.setBounds(88, 6, 133, 20);
		panel_7.add(lblNewLabel_4);


		label_1.setBounds(88, 28, 297, 20);
		panel_7.add(label_1);

		panel.setBounds(1046, 111, 216, 149);

		panel.setLayout(null);
		
		tabbedPane_3.addTab("New tab", null, panel_12, null);
		panel_1.setBounds(12, 62, 321, 619);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		scrollPane.setBounds(12, 53, 296, 556);
		panel_1.add(scrollPane);

		scrollPane.setColumnHeaderView(table);
		panel_9.setBounds(12, 10, 296, 33);
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		tabbedPane.setBounds(997, 62, 265, 524);
		
		getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("ㅇ구매정보", null, panel_2, null);
		panel_2.setLayout(null);
		tabbedPane_4.setBounds(12, 262, 236, 223);
		
		panel_2.add(tabbedPane_4);
		
		tabbedPane_4.addTab("3일간 주문상품", null, scrollPane_1, null);
		
		tabbedPane_4.addTab("한달간 주문상품", null, scrollPane_2, null);
		panel_10.setBounds(997, 596, 254, 85);
		
		getContentPane().add(panel_10);
		panel_10.setLayout(null);
		btnNewButton.setBounds(177, 10, 65, 65);
		
		panel_10.add(btnNewButton);
		button.setBounds(96, 10, 65, 65);
		
		panel_10.add(button);
		button_1.setBounds(12, 10, 65, 65);
		
		panel_10.add(button_1);
	}

	void start() {

	}
}
