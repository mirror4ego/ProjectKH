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
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import setting.SetLookAndFeel;
import setting.SetUiFont;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class OrderSheetView extends JFrame {
	
	private JLabel jLabel1 = new JLabel("ㅇ회원정보");
	
	private Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
	
	public OrderSheetView() {
		super("주문서 관리");
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
		tabbedPane.addTab("ㅇ주문서 검색", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(394, 62, 640, 620);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(12, 138, 616, 251);
		panel_3.add(tabbedPane_2);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_2.addTab("ㅇ주문내역", null, panel_5, null);
		panel_5.setLayout(null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBounds(12, 399, 616, 211);
		panel_3.add(tabbedPane_3);
		
		JPanel panel = new JPanel();
		tabbedPane_3.addTab("ㅇ배송정보", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_3.addTab("ㅇ요청사항", null, panel_1, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_3.addTab("ㅇ특이사항", null, panel_4, null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(241, 10, 387, 27);
		panel_3.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("접수일시");
		panel_8.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("123123123123123123");
		lblNewLabel_1.setSize(new Dimension(100, 0));
		panel_8.add(lblNewLabel_1);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(12, 10, 616, 119);
		panel_3.add(tabbedPane_1);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("ㅇ고객정보", null, panel_6, null);
		panel_6.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.BLUE);
		panel_7.setBounds(-2, 0, 1280, 55);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("주문서 관리");
		lblNewLabel_4.setBounds(88, 6, 133, 20);
		panel_7.add(lblNewLabel_4);

		JLabel label_1 = new JLabel("주문서를 관리(검색, 삭제) 하는 곳입니다.");
		label_1.setBounds(88, 28, 297, 20);
		panel_7.add(label_1);
	}
	
	void start() {
		
	}
}
