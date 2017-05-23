package view2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import setting.SetLookAndFeel;
import setting.SetUiFont;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class CRM_MainView2 extends JFrame implements MouseListener{

	private SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
	private SetUiFont setUiFont = new SetUiFont();

	private JPanel panel_7 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JLabel lblNewLabel_4 = new JLabel("데이터리스트");
	private JLabel label_1 = new JLabel("고객정보를 입력하고 데이터을 조회합니다");
	private JLabel jLabel1 = new JLabel("ㅇ회원정보");
	private JTable jTable2 = new JTable();
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
	private JButton button = new JButton("선택된 데이터 삭제");
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
	/*
	//private JLabel label_2 = new JLabel("소계");
	//private JLabel label_3 = new JLabel("합계");
	//private JLabel label_4 = new JLabel("할인");
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
	private JLabel label_19 = new JLabel("배달시간");
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
	*/
	private JPanel panel_10 = new JPanel();
	
	private JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
	private JButton button_A = new JButton("A통계");
	private JButton button_B = new JButton("B통계");
	private JButton button_C = new JButton("C통계");
	private JButton button_D = new JButton("D통계");
	private JButton button_E = new JButton("E통계");
	
	/*
	private JLabel label_28 = new JLabel("현금");
	private JTextField textField_7 = new JTextField();
	private JTextField textField_8 = new JTextField();
	private JLabel label_29 = new JLabel("카드");
	private JTextField textField_9 = new JTextField();
	private JLabel label_30 = new JLabel("미수금");
	
*/	
	private JButton button_2 = new JButton("닫기");
	private JPanel panel_11 = new JPanel();
	private JButton button_6 = new JButton("삭제");
	private JButton button_7 = new JButton("출력");
	private JTextField textField_11 = new JTextField();
	
	private JPanel panel_12 = new JPanel();
	private JLabel label_7 = new JLabel("데이터 관리");
	private JLabel label_8 = new JLabel("데이터를 관리(검색, 삭제) 하는 곳입니다.");
	private final JLabel label_32 = new JLabel();

	public CRM_MainView2() {
		super("데이터분석");
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
		//tabbedPane.setBounds(10, 62, 376, 620);
		//getContentPane().add(tabbedPane);
        /*
		tabbedPane.addTab("ㅇ데이터검색", null, panel_2, null);
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
*/
		panel_12.setLayout(null);
		panel_12.setBackground(Color.RED);
		panel_12.setBounds(0, 0, 1280, 55);
		getContentPane().add(panel_12);

       
		label_7.setForeground(Color.WHITE);  //데이터관리
		label_7.setBounds(88, 6, 133, 20);
		panel_12.add(label_7);


		label_8.setForeground(Color.LIGHT_GRAY);//주문서를 관리(검색, 삭제) 하는 곳입니다.
		label_8.setBounds(88, 28, 297, 20);
		panel_12.add(label_8);
		label_32.setBounds(35, 12, 32, 32);
		label_32.setIcon(new ImageIcon("img/computer.png"));
		
		panel_12.add(label_32);
		/*
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(394, 62, 506, 620);

		getContentPane().add(panel_1);
		panel_3.setBounds(231, 6, 263, 25);
*/
	
	//////데이터 버튼부분
		//tabbedPane_4.setBounds(912, 169, 180, 241);
		tabbedPane_4.setBounds(10, 62, 180, 400);
		//tabbedPane_4.setBounds(912, 62, 180, 400);
		getContentPane().add(tabbedPane_4);//////데이터 버튼부분
		tabbedPane_4.addTab("ㅇ데이터분석", null, panel_10, null);
		panel_10.setLayout(null);
		panel_10.setLayout(new GridLayout(5, 1, 2, 2));
		panel_10.add(button_A);
		panel_10.add(button_B);
		panel_10.add(button_C);
		panel_10.add(button_D);
		panel_10.add(button_E);
		
		//출력,삭제,닫기 부분 버튼
		panel_11.setBounds(10, 498, 180, 180);
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

