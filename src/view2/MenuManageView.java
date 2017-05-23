package view2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import setting.SetLookAndFeel;
import setting.SetUiFont;

public class MenuManageView extends JFrame implements MouseListener{

	//변수 선언부 시작
	private SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
	private SetUiFont setUiFont = new SetUiFont();

	private JPanel panel_2 = new JPanel();
	private JPanel panel = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel panel_3 = new JPanel();
	private JPanel panel_4 = new JPanel();

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	private JButton button = new JButton("신규");
	private JButton button_1 = new JButton("저장");
	private JButton button_2 = new JButton("삭제");
	private JButton button_3 = new JButton("닫기");
	private JButton button_6 = new JButton("정렬");
	private JButton button_7 = new JButton("∧");
	private JButton button_8 = new JButton("저장");
	private JButton button_9 = new JButton("∨");
	private JButton btnNewButton_2 = new JButton("분류추가");
	private JButton button_4 = new JButton("분류삭제");
	private JButton button_5 = new JButton("수정");

	private JLabel label_6 = new JLabel("분류명");
	private JLabel label_7 = new JLabel("상품분류");
	private JLabel label_2 = new JLabel("상품분류");
	private JLabel label_3 = new JLabel("상품코드");
	private JLabel label_4 = new JLabel("상품이름");
	private JLabel label_5 = new JLabel("가격");
	private JLabel lblNewLabel = new JLabel("원");
	private JLabel lblNewLabel_1 = new JLabel();
	private JLabel label = new JLabel("상품관리");
	private JLabel label_1 = new JLabel("상품을 등록하는 곳입니다");

	private JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	private JTable table;

	private JScrollPane scrollPane = new JScrollPane();

	private JTree tree = new JTree();
	//변수 선언부 끝

	public MenuManageView() throws ClassNotFoundException, SQLException {
		super("메뉴 관리");
		init();
		start();
		menuCreation();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(915,720);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
	}

	void init(){
		panel.setLayout(null);
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1150, 55);
		getContentPane().add(panel);

		label.setForeground(Color.BLACK);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label.setBounds(88, 6, 133, 20);
		panel.add(label);

		label_1.setForeground(Color.DARK_GRAY);
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_1.setBounds(88, 28, 297, 20);
		panel.add(label_1);
		lblNewLabel_1.setIcon(new ImageIcon("img/fried-chicken1.png"));

		lblNewLabel_1.setBounds(35, 12, 32, 32);

		panel.add(lblNewLabel_1);

		tabbedPane.setBounds(10, 65, 338, 617);
		getContentPane().add(tabbedPane);

		tabbedPane.addTab("ㅇ메뉴분류", null, panel_1, null);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setBounds(91, 504, 161, 25);
		panel_1.add(textField);
		textField.setColumns(10);

		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_6.setBackground(Color.GRAY);
		label_6.setAlignmentX(0.5f);
		label_6.setBounds(12, 504, 67, 25);
		panel_1.add(label_6);

		panel_3.setBounds(56, 539, 222, 39);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 3, 3));

		panel_3.add(btnNewButton_2);

		panel_3.add(button_4);

		button_5.setBounds(264, 504, 57, 25);
		panel_1.add(button_5);

		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_7.setBackground(Color.GRAY);
		label_7.setAlignmentX(0.5f);
		label_7.setBounds(11, 10, 310, 25);
		panel_1.add(label_7);

		tabbedPane_1.setBounds(360, 65, 537, 617);
		getContentPane().add(tabbedPane_1);

		tabbedPane_1.addTab("ㅇ세부상품", null, panel_2, null);
		panel_2.setLayout(null);

		scrollPane.setBounds(12, 45, 434, 376);
		panel_2.add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);

		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_2.setBackground(Color.GRAY);
		label_2.setAlignmentX(0.5f);
		label_2.setBounds(12, 10, 67, 25);
		panel_2.add(label_2);

		textField_1 = new JTextField();
		textField_1.setBounds(91, 10, 355, 25);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_3.setBackground(Color.GRAY);
		label_3.setAlignmentX(0.5f);
		label_3.setBounds(12, 431, 67, 25);
		panel_2.add(label_3);

		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_4.setBackground(Color.GRAY);
		label_4.setAlignmentX(0.5f);
		label_4.setBounds(12, 466, 67, 25);
		panel_2.add(label_4);

		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_5.setBackground(Color.GRAY);
		label_5.setAlignmentX(0.5f);
		label_5.setBounds(12, 501, 67, 25);
		panel_2.add(label_5);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(79, 501, 200, 25);
		panel_2.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(79, 466, 367, 25);
		panel_2.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(79, 431, 367, 25);
		panel_2.add(textField_4);

		button.setBounds(12, 536, 81, 42);
		panel_2.add(button);

		button_1.setBounds(105, 536, 81, 43);
		panel_2.add(button_1);

		button_2.setBounds(198, 536, 81, 43);
		panel_2.add(button_2);

		button_3.setBounds(365, 502, 81, 76);
		panel_2.add(button_3);

		panel_4.setBounds(453, 45, 72, 278);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		button_6.setBounds(8, 0, 57, 50);
		panel_4.add(button_6);

		button_7.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_7.setBounds(8, 109, 57, 50);
		panel_4.add(button_7);

		button_8.setBounds(8, 159, 57, 50);
		panel_4.add(button_8);

		button_9.setVerticalAlignment(SwingConstants.BOTTOM);
		button_9.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_9.setBounds(8, 209, 57, 50);
		panel_4.add(button_9);
		
				textField_5 = new JTextField();
				textField_5.setBackground(Color.LIGHT_GRAY);
				textField_5.setEnabled(false);
				textField_5.setEditable(false);
				textField_5.setColumns(10);
				textField_5.setBounds(4, 98, 65, 170);
				panel_4.add(textField_5);

		lblNewLabel.setBounds(287, 501, 57, 25);
		panel_2.add(lblNewLabel);
	}

	void start(){
		tree.addMouseListener(this);
	}
	/**
	 * 로직
	  
	 * db menugroup에서 칼럼 총 데이터행 개수를 확인함 (ex : 3) -> getrow();
	 * 그 데이터 행을 매개변수로 행 갯수만큼 그룹 데이터를 불러와서(dao에 메소드-> 그룹 데이터를 불러옴)
	 * 벡터로 불러와서 반환
	 * 
	 * db menu에서 각 그룹마다의 데이터행 개수를 확인함 (ex : 7) -> getrow();
	 * 그 데이터 행을 매개변수로 행 갯수만큼 item 데이터를 불러와서 (jTree의 대분류마다 세팅함)
	 * 벡터로 불러와서 반환
	 * 
	 * jtree의 대분류로 세팅함
	 *  대분류용 for문{
	 *  아이템용 for문
	 *  }
	 *  
	 *  
	 */
	
	void menuCreation() {
		tree.setModel(new DefaultTreeModel(
				new DefaultMutableTreeNode("상품분류") {
					{
				/*		Vector vectorMG = new Vector();
						Vector vectorM = new Vector();
						DefaultMutableTreeNode node_1;
						for(int i = 0;i<vectorMG.size();i++){
							node_1 = new DefaultMutableTreeNode(vectorMG.elementAt(i));
							for(int j = 0;j<vectorM.size();j++){//vectorMG분류의 i번째에 해당 하는 vectorM의 사이즈를 불러와야함
								
								//메뉴 대분류 그룹에 해당하는 것들만 불러와서 vector에 차례대로 저장
								node_1.add(new DefaultMutableTreeNode(vectorM.elementAt(j)));
							}
							add(node_1);
						}*/
											
						DefaultMutableTreeNode node_1;
						node_1 = new DefaultMutableTreeNode("치킨류");
						node_1.add(new DefaultMutableTreeNode("후라이드"));
						node_1.add(new DefaultMutableTreeNode("양념치킨"));
						node_1.add(new DefaultMutableTreeNode("윙치킨"));
						node_1.add(new DefaultMutableTreeNode("반반치킨"));
						node_1.add(new DefaultMutableTreeNode("레드오리지날"));
						node_1.add(new DefaultMutableTreeNode("순살치킨"));
						node_1.add(new DefaultMutableTreeNode("갈릭플러스치킨"));
						node_1.add(new DefaultMutableTreeNode("갈릭반핫양념반"));
						add(node_1);
						node_1 = new DefaultMutableTreeNode("사이드류");
						node_1.add(new DefaultMutableTreeNode("웨지감자"));
						node_1.add(new DefaultMutableTreeNode("샐러드"));
						node_1.add(new DefaultMutableTreeNode("치즈스틱"));
						node_1.add(new DefaultMutableTreeNode("치킨샐러드"));
						node_1.add(new DefaultMutableTreeNode("치킨소시지"));
						add(node_1);
						node_1 = new DefaultMutableTreeNode("음료");
						node_1.add(new DefaultMutableTreeNode("콜라"));
						node_1.add(new DefaultMutableTreeNode("사이다"));
						node_1.add(new DefaultMutableTreeNode("탄산수"));
						node_1.add(new DefaultMutableTreeNode("스프라이트"));
						add(node_1);
					}
				}
				));
		tree.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tree.setBounds(12, 34, 309, 460);
		panel_1.add(tree);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==tree){
			tree.getLastSelectedPathComponent();
			System.out.println(tree.getLastSelectedPathComponent());
			
			//대분류를 클릭하면 DB(MENUGroup)에서 검색
			//존재하면 그 분류 이름을 매개변수로 MENU에서 검색해서 객체로 반환하고
			//그 정보를 테이블에 상품분류 테이블 아래에 디스플레이
			//and 그 분류명을 아래에 텍스트 필드에 입력됨
			//그리고 그 정보를 가지고 대분류 수정, 삭제
			
			//분류 추가를 누르면 
			
			//테이블에 로우를 클릭하면 아래에 상품코드와 상품이름, 가격에 디스플레이
			//그 정보를 가지고 수정, 삭제
			
			//상품분류가 성공적으로 로드되었으며 각 상품정보칼럼이 비어 있을경우
			
			//정렬
			
			
			//마지막 객체로 검색해서 데이터가 있으면
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
