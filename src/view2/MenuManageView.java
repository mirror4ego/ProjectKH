package view2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import dao.MenuDao;
import dao.MenuGroupDao;
import domain.MenuDto;
import setting.SetLookAndFeel;
import setting.SetUiFont;

public class MenuManageView extends JFrame implements MouseListener, TreeSelectionListener{

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
	private JTextField textField_5;

	private JButton button = new JButton("신규");
	private JButton button_1 = new JButton("저장");
	private JButton button_2 = new JButton("삭제");
	private JButton button_3 = new JButton("닫기");
	private JButton button_6 = new JButton("전체");
	private JButton button_7 = new JButton("∧");
	private JButton button_9 = new JButton("∨");
	private JButton btnNewButton_2 = new JButton("분류추가");
	private JButton button_4 = new JButton("분류삭제");
	private JButton button_5 = new JButton("수정");

	private JLabel label_6 = new JLabel("분류명");
	private JLabel label_7 = new JLabel("메뉴분류");
	private JLabel label_2 = new JLabel("메뉴분류");
	private JLabel label_4 = new JLabel("메뉴이름");
	private JLabel label_5 = new JLabel("가격");
	private JLabel lblNewLabel = new JLabel("원");
	private JLabel lblNewLabel_1 = new JLabel();
	private JLabel label = new JLabel("메뉴관리");
	private JLabel label_1 = new JLabel("상품을 메뉴하는 곳입니다");

	private JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	private JTable table;

	private JScrollPane scrollPane = new JScrollPane(table);
	Vector vector1 = new Vector();
	Vector menuGroupName = (new MenuGroupDao()).getAllMenuGroupName();
	DefaultMutableTreeNode node_1;

	private JTree tree;

	private final JButton button_8 = new JButton("메뉴");
	private final JButton button_12 = new JButton("새로고침");
	//변수 선언부 끝

	public MenuManageView() throws ClassNotFoundException, SQLException {
		super("메뉴 관리");
		init();
		jTreeRefresh();
		start();

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
		this.getColumn();
		this.jTableRefresh(new MenuDao().menuAllPart());
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

		panel_3.setBounds(12, 539, 309, 39);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 3, 3));

		panel_3.add(button_12);

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
		scrollPane.setBackground(Color.WHITE);

		scrollPane.setBounds(12, 45, 434, 411);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setBounds(0, 0, 532, 588);
		scrollPane.setViewportView(table);

		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label_2.setBackground(Color.GRAY);
		label_2.setAlignmentX(0.5f);
		label_2.setBounds(12, 10, 67, 25);
		panel_2.add(label_2);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(91, 10, 355, 25);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

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
		textField_2.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_2.setColumns(10);
		textField_2.setBounds(79, 501, 200, 25);
		panel_2.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(79, 466, 367, 25);
		panel_2.add(textField_3);

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

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(8, 159, 57, 51);
		panel_4.add(panel_5);
		panel_5.setLayout(new CardLayout(0, 0));
		button_8.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		panel_5.add(button_8, "name_47512106817689");

		JButton button_10 = new JButton("가격");
		button_10.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		panel_5.add(button_10, "name_47576162690891");

		JButton button_11 = new JButton("분류");
		button_11.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		panel_5.add(button_11, "name_47578212542697");

		button_6.setBounds(8, 0, 57, 50);
		panel_4.add(button_6);

		button_7.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_7.setBounds(8, 109, 57, 50);
		panel_4.add(button_7);

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
		tree.addTreeSelectionListener(this);
		button_3.addMouseListener(this);
		button_1.addMouseListener(this);
		button_2.addMouseListener(this);
		button.addMouseListener(this);
		button_4.addMouseListener(this); // 분류삭제
		button_5.addMouseListener(this); // 분류수정
		btnNewButton_2.addMouseListener(this); // 분류추가
		button_12.addMouseListener(this);
		button_6.addMouseListener(this);
	}

	public Vector getColumn(){
		vector1.add("메뉴이름");
		vector1.add("메뉴가격");
		vector1.add("메뉴분류");
		return vector1;
	}

	public void jTableRefresh(Vector menuDto) throws ClassNotFoundException, SQLException{
		DefaultTableModel model = new DefaultTableModel();
		System.out.println(vector1);
		model.setDataVector(menuDto, vector1);
		table.setModel(model);
	}

	/*	public void addTextFieldValue() {
		DefaultMutableTreeNode newNode=new DefaultMutableTreeNode("나");
		TreePath selectionPath=tree.getSelectionPath();
		DefaultMutableTreeNode selectedNode=
				(DefaultMutableTreeNode)selectionPath.getLastPathComponent();
		((DefaultTreeModel)tree.getModel())
		.insertNodeInto(newNode,selectedNode,selectedNode.getChildCount());
	}

	public void removeSelectedNode() {
		TreePath selectionPath=tree.getSelectionPath();
		DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)selectionPath.getLastPathComponent();

		((DefaultTreeModel)tree.getModel()).removeNodeFromParent(selectedNode);

	}*/

	public void jTreeRefresh() throws ClassNotFoundException, SQLException {
		node_1 = new DefaultMutableTreeNode("메뉴분류");
		tree = new JTree(node_1);

		System.out.println(menuGroupName);
		for(int i=0;i<menuGroupName.size();i++){
			Vector menuName = (new MenuDao()).getPartMenuName((String)(menuGroupName.get(i)));
			System.out.println(menuGroupName.get(i));
			DefaultMutableTreeNode parent = new DefaultMutableTreeNode(menuGroupName.get(i));

			node_1.add(parent);
			for(int j=0;j<menuName.size();j++){
				parent.add(new DefaultMutableTreeNode(menuName.get(j)));
				System.out.println(menuName.get(j));
			}

		}

		tree.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tree.setBounds(12, 34, 309, 460);
		//tree.expandPath(path);;
		panel_1.add(tree);
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==tree){
			String selectTree = String.valueOf(tree.getLastSelectedPathComponent());
			System.out.println(selectTree);
			textField_3.setText("");
			textField_2.setText("");
			textField_1.setText("");
			textField.setText("");
			try {
				if((new MenuDao()).searchMenu(selectTree)){
					MenuDto menuDto = new MenuDto();
					menuDto.setMenuName(selectTree);
					MenuDao menuDao = new MenuDao();
					jTableRefresh(menuDao.getOneMenu(selectTree));
					textField_3.setText((menuDao.get(menuDto)).getMenuName());
					textField_2.setText(String.valueOf((menuDao.get(menuDto)).getMenuPrice()));
					textField_1.setText(tree.getSelectionPath().getParentPath().getLastPathComponent().toString());
				}else if((new MenuGroupDao()).searchMenuGroup(selectTree)){
					textField_1.setText(selectTree);
					jTableRefresh(new MenuDao().menuAllGroupPart(selectTree));
					System.out.println(selectTree);
					textField.setText(selectTree);
				}else{
					System.out.println("등록되어 있지 않은 메뉴");
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if(e.getSource()==button_3){
			this.dispose();
		}

		if(e.getSource()==button){

			textField_3.setText("");
			textField_2.setText("");
		}
		if(e.getSource()==button_12) {
			try {
				this.jTreeRefresh();
				System.out.println("리플래시 완료");
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==button_2){
			try {
				(new MenuDao()).deleteOneMenu(textField_3.getText().trim());
			} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};
		}

		if(e.getSource()==button_6){
			try {
				this.jTableRefresh(new MenuDao().menuAllPart());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if(e.getSource()==button_1){ // 저장
			MenuDto menuDto = new MenuDto();
			System.out.println(menuDto.toString());
			if(!(textField_3.getText().trim().equals(""))){
				try {
					if((new MenuDao()).searchMenu(textField_3.getText().trim())){
						menuDto.setMenuName(textField_3.getText().trim());	// 상품이름
						menuDto.setMenuPrice(Integer.parseInt(textField_2.getText().trim())); // 가격
						menuDto.setMenuGroupName(textField_1.getText().trim()); // 상품분류
						try {
							new MenuDao().updateMenu(menuDto);
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else{
						menuDto.setMenuName(textField_3.getText().trim());
						menuDto.setMenuPrice(Integer.parseInt(textField_2.getText().trim())); // 가격
						menuDto.setMenuGroupName(textField_1.getText().trim()); // 상품분류
						try {
							new MenuDao().insertMenu(menuDto);
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "상품 대분류를 입력하세요");
			}
		}
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub

	}
	DefaultMutableTreeNode getTreeNode(TreePath path){
		return ( DefaultMutableTreeNode) (path.getLastPathComponent());
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
