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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;

public class OrderMainView extends JFrame implements MouseListener{

	private SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
	private SetUiFont setUiFont = new SetUiFont();

	private JPanel panel_7 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JLabel lblNewLabel_4 = new JLabel("주문리스트");
	private JLabel label_1 = new JLabel("고객정보를 입력하고 주문내역을 조회합니다");
	private JLabel jLabel1 = new JLabel("ㅇ회원정보");
	private JTable jTable2 = new JTable();
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
	private JButton button = new JButton("선택된 주문서 삭제");
	private JLabel label_9 = new JLabel("검색결과 :");
	private JTextField textField = new JTextField();
	private JLabel label_10 = new JLabel("개");
	private JPanel panel = new JPanel();
	private JTextArea textArea = new JTextArea();
	private JTextField textField_1 = new JTextField();
	private JComboBox comboBox = new JComboBox();
	private JLabel label = new JLabel("검색");
	private JButton button_1 = new JButton("검색");
	private JLabel label_11 = new JLabel("기준");
	private JTextField textField_2 = new JTextField();
	private JLabel label_12 = new JLabel("기간");
	private JTextField textField_3 = new JTextField();
	private JPanel panel_1 = new JPanel();
	private JPanel panel_3 = new JPanel();
	private JLabel button_3 = new JLabel("ex) 2015-09-03/04:30");
	private JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	private JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
	private JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
	private JPanel panel_4 = new JPanel();
	private JTextField textField_4 = new JTextField();
	private JTextField textField_5 = new JTextField();
	private JScrollPane scrollPane = new JScrollPane();
	private JTextField textField_6 = new JTextField();
	private JLabel label_2 = new JLabel("소계");
	private JLabel label_3 = new JLabel("합계");
	private JLabel label_4 = new JLabel("할인");
	private JPanel panel_5 = new JPanel();
	private JTextField txtEx_1 = new JTextField();
	private JTextField txtEx_5 = new JTextField();
	private JLabel label_5 = new JLabel("고객번호");
	private JLabel label_6 = new JLabel("주소");
	private JLabel label_13 = new JLabel("전화번호");
	private JTextField txtEx_3 = new JTextField();
	private JLabel label_14 = new JLabel("채널");
	private JComboBox comboBox_1 = new JComboBox();
	private JLabel label_15 = new JLabel("등급");
	private JTextField textField_10 = new JTextField();
	private JButton button_4 = new JButton("검색");
	private JPanel panel_6 = new JPanel();
	private JLabel label_16 = new JLabel("고객번호");
	private JLabel label_17 = new JLabel("전화번호");
	private JLabel label_18 = new JLabel("배송주소");
	private JLabel label_19 = new JLabel("주문시간");
	private JLabel label_20 = new JLabel("담당자");
	private JLabel label_21 = new JLabel("대기시간");
	private JTextField txtEx = new JTextField();
	private JTextField textField_12 = new JTextField();
	private JTextField textField_13 = new JTextField();
	private JTextField txtEx_2 = new JTextField();
	private JTextField txtEx_4 = new JTextField();
	private JTextField textField_16 = new JTextField();
	private JButton button_5 = new JButton("검색");
	private JPanel panel_8 = new JPanel();
	private JTextArea textArea_1 = new JTextArea();
	private JLabel label_22 = new JLabel("배달");
	private JLabel label_23 = new JLabel("요청시간");
	private JLabel label_24 = new JLabel("주문");
	private JLabel label_25 = new JLabel("요청사항");
	private JTextField textField_17 = new JTextField();
	private JPanel panel_9 = new JPanel();
	private JTextArea textArea_2 = new JTextArea();
	private JLabel label_26 = new JLabel("특이사항");
	private JLabel label_27 = new JLabel("접수일시");
	private JPanel panel_10 = new JPanel();
	private JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
	private JLabel label_28 = new JLabel("현금");
	private JTextField textField_7 = new JTextField();
	private JTextField textField_8 = new JTextField();
	private JLabel label_29 = new JLabel("카드");
	private JTextField textField_9 = new JTextField();
	private JLabel label_30 = new JLabel("미수금");
	private JButton button_2 = new JButton("닫기");
	private JPanel panel_11 = new JPanel();
	private JButton button_6 = new JButton("검색");
	private JButton button_7 = new JButton("검색");
	private JTextField textField_11 = new JTextField();
	private JPanel panel_12 = new JPanel();
	private JLabel label_7 = new JLabel("주문 관리");
	private JLabel label_8 = new JLabel("주문서를 관리(검색, 삭제) 하는 곳입니다.");

	public OrderMainView() {
		super("주문내역 관리");
		SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
		SetUiFont setUiFont = new SetUiFont();
		this.init();
		this.start();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1110,720);
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

		tabbedPane.addTab("ㅇ주문서검색", null, panel_2, null);
		panel_2.setLayout(null);
		panel.setBounds(12, 112, 347, -103);

		panel_2.add(panel);
		panel.setLayout(null);

		JLabel label_31 = new JLabel("~");
		label_31.setBounds(200, 24, 57, 15);
		panel_2.add(label_31);
		textField_1.setColumns(10);
		textField_1.setBounds(63, 89, 215, 25);

		panel_2.add(textField_1);
		comboBox.setOpaque(false);
		comboBox.setBounds(63, 54, 215, 25);

		panel_2.add(comboBox);
		textField_2.setColumns(10);
		textField_2.setBounds(63, 19, 130, 25);

		panel_2.add(textField_2);
		textField_3.setColumns(10);
		textField_3.setBounds(217, 19, 130, 25);

		panel_2.add(textField_3);
		label.setBounds(29, 68, 40, 15);

		panel_2.add(label);
		label_11.setBounds(29, 87, 40, 15);

		panel_2.add(label_11);
		label_12.setBounds(29, 24, 40, 15);

		panel_2.add(label_12);
		button_1.setBounds(290, 54, 57, 60);

		panel_2.add(button_1);
		jTable2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));

		jTable2.setBounds(12, 172, 347, 367);
		panel_2.add(jTable2);
		button.setBounds(101, 550, 146, 31);

		panel_2.add(button);
		label_9.setBounds(12, 141, 57, 15);

		panel_2.add(label_9);
		textField.setColumns(10);
		textField.setBounds(76, 139, 42, 19);

		panel_2.add(textField);
		label_10.setBounds(126, 141, 57, 15);

		panel_2.add(label_10);
		textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(12, 10, 347, 114);

		panel_2.add(textArea);

		panel_7.setBackground(Color.YELLOW);
		panel_7.setBounds(-2, 0, 1280, 55);

		panel_7.setLayout(null);

		lblNewLabel_4.setBounds(88, 6, 133, 20);
		panel_7.add(lblNewLabel_4);

		label_1.setBounds(88, 28, 297, 20);
		panel_7.add(label_1);

		panel_12.setLayout(null);
		panel_12.setBackground(Color.BLUE);
		panel_12.setBounds(0, 0, 1280, 55);
		getContentPane().add(panel_12);


		label_7.setForeground(Color.WHITE);
		label_7.setBounds(88, 6, 133, 20);
		panel_12.add(label_7);


		label_8.setForeground(Color.LIGHT_GRAY);
		label_8.setBounds(88, 28, 297, 20);
		panel_12.add(label_8);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(394, 62, 506, 620);

		getContentPane().add(panel_1);
		panel_3.setBounds(231, 6, 263, 25);

		panel_1.add(panel_3);
		panel_3.setLayout(null);
		button_3.setHorizontalAlignment(SwingConstants.CENTER);
		button_3.setBounds(67, 0, 196, 25);

		panel_3.add(button_3);
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_27.setBackground(Color.GRAY);
		label_27.setAlignmentX(0.5f);
		label_27.setBounds(0, 0, 67, 25);

		panel_3.add(label_27);
		tabbedPane_1.setBounds(12, 145, 484, 273);

		panel_1.add(tabbedPane_1);
		panel_4.setLayout(null);

		tabbedPane_1.addTab("ㅇ주문내역", null, panel_4, null);
		textField_4.setColumns(10);
		textField_4.setBounds(304, 200, 126, 25);

		panel_4.add(textField_4);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(79, 200, 171, 38);

		panel_4.add(textField_5);
		scrollPane.setBounds(12, 10, 455, 156);

		panel_4.add(scrollPane);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(79, 176, 171, 25);

		panel_4.add(textField_6);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_2.setBackground(Color.GRAY);
		label_2.setAlignmentX(0.5f);
		label_2.setBounds(12, 176, 67, 25);

		panel_4.add(label_2);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_3.setBackground(Color.GRAY);
		label_3.setAlignmentX(0.5f);
		label_3.setBounds(12, 201, 67, 37);

		panel_4.add(label_3);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_4.setBackground(Color.GRAY);
		label_4.setAlignmentX(0.5f);
		label_4.setBounds(304, 176, 67, 25);

		panel_4.add(label_4);
		tabbedPane_2.setBounds(12, 428, 484, 182);

		panel_1.add(tabbedPane_2);
		panel_6.setLayout(null);

		tabbedPane_2.addTab("ㅇ배송정보", null, panel_6, null);
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_16.setBackground(Color.GRAY);
		label_16.setAlignmentX(0.5f);
		label_16.setBounds(12, 10, 67, 25);

		panel_6.add(label_16);
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_17.setBackground(Color.GRAY);
		label_17.setAlignmentX(0.5f);
		label_17.setBounds(12, 46, 67, 25);

		panel_6.add(label_17);
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_18.setBackground(Color.GRAY);
		label_18.setAlignmentX(0.5f);
		label_18.setBounds(12, 82, 67, 25);

		panel_6.add(label_18);
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_19.setBackground(Color.GRAY);
		label_19.setAlignmentX(0.5f);
		label_19.setBounds(12, 118, 67, 25);

		panel_6.add(label_19);
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_20.setBackground(Color.GRAY);
		label_20.setAlignmentX(0.5f);
		label_20.setBounds(248, 10, 67, 25);

		panel_6.add(label_20);
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_21.setBackground(Color.GRAY);
		label_21.setAlignmentX(0.5f);
		label_21.setBounds(248, 46, 67, 25);

		panel_6.add(label_21);
		txtEx.setText("ex) 1199");
		txtEx.setHorizontalAlignment(SwingConstants.TRAILING);
		txtEx.setEditable(false);
		txtEx.setColumns(10);
		txtEx.setBounds(79, 10, 157, 25);

		panel_6.add(txtEx);
		textField_12.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_12.setColumns(10);
		textField_12.setBounds(315, 10, 152, 25);

		panel_6.add(textField_12);
		textField_13.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_13.setColumns(10);
		textField_13.setBounds(315, 46, 152, 25);

		panel_6.add(textField_13);
		txtEx_2.setText("ex) 01032883311");
		txtEx_2.setHorizontalAlignment(SwingConstants.TRAILING);
		txtEx_2.setEditable(false);
		txtEx_2.setColumns(10);
		txtEx_2.setBounds(79, 46, 157, 25);

		panel_6.add(txtEx_2);
		txtEx_4.setText("ex) 서울 강남구 삼성동 1933-31 2층");
		txtEx_4.setEditable(false);
		txtEx_4.setColumns(10);
		txtEx_4.setBounds(79, 82, 319, 25);

		panel_6.add(txtEx_4);
		textField_16.setText("ex)2017년 05월 22일 / 14시 17분");
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(79, 118, 319, 25);

		panel_6.add(textField_16);
		button_5.setBounds(410, 81, 57, 25);

		panel_6.add(button_5);
		panel_8.setLayout(null);

		tabbedPane_2.addTab("ㅇ요청사항", null, panel_8, null);
		textArea_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		textArea_1.setBounds(79, 69, 389, 74);

		panel_8.add(textArea_1);
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_22.setBackground(Color.GRAY);
		label_22.setAlignmentX(0.5f);
		label_22.setBounds(12, 10, 67, 25);

		panel_8.add(label_22);
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_23.setBackground(Color.GRAY);
		label_23.setAlignmentX(0.5f);
		label_23.setBounds(12, 34, 67, 25);

		panel_8.add(label_23);
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_24.setBackground(Color.GRAY);
		label_24.setAlignmentX(0.5f);
		label_24.setBounds(12, 69, 67, 25);

		panel_8.add(label_24);
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_25.setBackground(Color.GRAY);
		label_25.setAlignmentX(0.5f);
		label_25.setBounds(12, 93, 67, 25);

		panel_8.add(label_25);
		textField_17.setText("ex) 2017-05-04/18:30");
		textField_17.setColumns(10);
		textField_17.setBounds(79, 10, 389, 25);

		panel_8.add(textField_17);
		panel_9.setLayout(null);

		tabbedPane_2.addTab("ㅇ특이사항", null, panel_9, null);
		textArea_2.setBounds(78, 10, 389, 133);

		panel_9.add(textArea_2);
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_26.setBackground(Color.GRAY);
		label_26.setAlignmentX(0.5f);
		label_26.setBounds(12, 10, 67, 25);

		panel_9.add(label_26);
		tabbedPane_3.setBounds(12, 10, 484, 125);

		panel_1.add(tabbedPane_3);
		panel_5.setLayout(null);

		tabbedPane_3.addTab("ㅇ고객정보", null, panel_5, null);
		txtEx_1.setText("ex) 1199");
		txtEx_1.setHorizontalAlignment(SwingConstants.TRAILING);
		txtEx_1.setEditable(false);
		txtEx_1.setColumns(10);
		txtEx_1.setBounds(79, 5, 151, 25);

		panel_5.add(txtEx_1);
		txtEx_5.setText("ex) 서울 강남구 삼성동 1933-31 2층");
		txtEx_5.setEditable(false);
		txtEx_5.setColumns(10);
		txtEx_5.setBounds(79, 65, 314, 25);

		panel_5.add(txtEx_5);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_5.setBackground(Color.GRAY);
		label_5.setAlignmentX(0.5f);
		label_5.setBounds(12, 5, 67, 25);

		panel_5.add(label_5);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_6.setBackground(Color.GRAY);
		label_6.setAlignmentX(0.5f);
		label_6.setBounds(12, 65, 67, 25);

		panel_5.add(label_6);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_13.setBackground(Color.GRAY);
		label_13.setAlignmentX(0.5f);
		label_13.setBounds(12, 35, 67, 25);

		panel_5.add(label_13);
		txtEx_3.setText("ex) 01032883311");
		txtEx_3.setHorizontalAlignment(SwingConstants.TRAILING);
		txtEx_3.setEditable(false);
		txtEx_3.setColumns(10);
		txtEx_3.setBounds(79, 35, 151, 25);

		panel_5.add(txtEx_3);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_14.setBackground(Color.GRAY);
		label_14.setAlignmentX(0.5f);
		label_14.setBounds(246, 5, 67, 25);

		panel_5.add(label_14);
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(313, 5, 153, 25);

		panel_5.add(comboBox_1);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_15.setBackground(Color.GRAY);
		label_15.setAlignmentX(0.5f);
		label_15.setBounds(246, 35, 67, 25);

		panel_5.add(label_15);
		textField_10.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(313, 35, 153, 25);

		panel_5.add(textField_10);
		button_4.setBounds(409, 65, 57, 25);

		panel_5.add(button_4);
		tabbedPane_4.setBounds(912, 169, 180, 241);

		getContentPane().add(tabbedPane_4);
		tabbedPane_4.addTab("ㅇ주문결제", null, panel_10, null);
		panel_10.setLayout(null);
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_28.setBackground(Color.GRAY);
		label_28.setAlignmentX(0.5f);
		label_28.setBounds(12, 16, 67, 25);

		panel_10.add(label_28);
		textField_7.setColumns(10);
		textField_7.setBounds(12, 41, 151, 25);

		panel_10.add(textField_7);
		textField_8.setColumns(10);
		textField_8.setBounds(12, 101, 151, 25);

		panel_10.add(textField_8);
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_29.setBackground(Color.GRAY);
		label_29.setAlignmentX(0.5f);
		label_29.setBounds(12, 76, 67, 25);

		panel_10.add(label_29);
		textField_9.setColumns(10);
		textField_9.setBounds(12, 161, 151, 25);

		panel_10.add(textField_9);
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_30.setBackground(Color.GRAY);
		label_30.setAlignmentX(0.5f);
		label_30.setBounds(12, 136, 67, 25);

		panel_10.add(label_30);
		panel_11.setBounds(912, 498, 180, 180);

		getContentPane().add(panel_11);
		panel_11.setLayout(new GridLayout(2, 2, 2, 2));

		panel_11.add(button_7);

		panel_11.add(button_6);
		textField_11.setEditable(false);
		textField_11.setColumns(10);

		panel_11.add(textField_11);
		panel_11.add(button_2);
	}

	void start() {
		button_2.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==button_2){
			this.dispose();
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
