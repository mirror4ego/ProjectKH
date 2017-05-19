package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.UserInfoDao;
import setting.SetLookAndFeel;
import setting.SetUiFont;


public class UserListView extends JFrame implements MouseListener,ActionListener{
	//아래부터 임시 실행을 위한 메인 선언
	public static void main(String ar[]) throws ClassNotFoundException, SQLException{
		UserListView a = new UserListView(); //클래스 파일의 객체를 직접 생성 (실행을 위해)
	}
	//메인 종료
	SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
	SetUiFont setUiFont = new SetUiFont();
	Vector vector1;  
	Vector vector2;
	Vector vector3 = new Vector();
	DefaultTableModel defaultTableModel1 = new DefaultTableModel(vector1, vector2);
	UserInfoDao dao = new UserInfoDao();
	UserInfoDao userInfoDao = new UserInfoDao();
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panel = new JPanel();
	private final JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblNewLabel = new JLabel("New label");
	private final JComboBox comboBox = new JComboBox();
	private final JTextField textField = new JTextField();
	private final JButton btnNewButton = new JButton("New button");
	private final JTable table = new JTable();
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	private final JLabel lblNewLabel_2 = new JLabel("New label");
	private final JLabel lblNewLabel_3 = new JLabel("New label");
	private final JLabel lblNewLabel_4 = new JLabel("New label");
	private final JLabel lblNewLabel_5 = new JLabel("New label");
	private final JLabel lblNewLabel_6 = new JLabel("New label");
	private final JLabel lblNewLabel_7 = new JLabel("New label");
	private final JLabel lblNewLabel_8 = new JLabel("New label");
	private final JLabel lblNewLabel_9 = new JLabel("New label");
	private final JLabel lblNewLabel_10 = new JLabel("New label");
	
	public UserListView() throws ClassNotFoundException, SQLException{
		super("사용자 관리");

		
		textField.setBounds(121, 10, 125, 21);
		textField.setColumns(10);
		jTableRefresh();
		/*vector1 = userInfoDao.getUserList();
		System.out.println("v=" + vector1);
		vector2 = getColumn();*/
		getContentPane().setLayout(null);
		tabbedPane.setName("");
		tabbedPane.setBounds(12, 37, 301, 635);
		
		getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		comboBox.setBounds(8, 10, 105, 21);
		
		panel.add(comboBox);
		
		panel.add(textField);
		btnNewButton.setBounds(249, 9, 40, 23);
		
		panel.add(btnNewButton);
		table.setBounds(8, 38, 281, 558);
		
		panel.add(table);
		tabbedPane_1.setBounds(329, 37, 923, 635);
		
		getContentPane().add(tabbedPane_1);
		
		tabbedPane_1.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblNewLabel_1.setBounds(12, 15, 57, 36);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2.setBounds(12, 61, 57, 36);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3.setBounds(12, 107, 57, 36);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4.setBounds(12, 279, 57, 36);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5.setBounds(12, 463, 57, 36);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6.setBounds(438, 15, 57, 36);
		panel_1.add(lblNewLabel_6);

		lblNewLabel_7.setBounds(438, 82, 57, 36);
		panel_1.add(lblNewLabel_7);
		
		lblNewLabel_8.setBounds(438, 148, 57, 36);
		panel_1.add(lblNewLabel_8);
		
		lblNewLabel_9.setBounds(438, 212, 57, 36);
		panel_1.add(lblNewLabel_9);
		
		lblNewLabel_10.setBounds(438, 279, 57, 36);
		panel_1.add(lblNewLabel_10);
		lblNewLabel.setBounds(12, 10, 971, 26);
		getContentPane().add(lblNewLabel);
		
		
		setSize(1280,720);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public Vector getColumn(){
		vector3.add("아이디");
		vector3.add("비밀번호");
		vector3.add("이름");
		vector3.add("번호");
		vector3.add("주소");
		vector3.add("전화번호");
		vector3.add("이메일");
		return vector3;
	}

	public void jTableRefresh() throws ClassNotFoundException, SQLException{
		DefaultTableModel model= new DefaultTableModel(dao.getUserList(), getColumn());

	}	

	@Override
	public void mouseClicked(MouseEvent e) {
/*		int r = jTable1.getSelectedRow();
		String id = (String) jTable1.getValueAt(r, 0);
		try {
			UserRegView mem = new UserRegView(id, this);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
