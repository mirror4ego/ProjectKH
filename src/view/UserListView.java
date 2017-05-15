package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.UserInfoDao;


public class UserListView extends JFrame implements MouseListener,ActionListener{

	Vector vector1;  
	Vector vector2;
	Vector vector3 = new Vector();
	DefaultTableModel defaultTableModel1 = new DefaultTableModel(vector1, vector2);
	JTable jTable1 = new JTable(defaultTableModel1);
	JScrollPane jScrollPane1 = new JScrollPane(jTable1);
	JPanel jPanel1 = new JPanel();
	JButton jButton1 = new JButton("회원가입");
	UserInfoDao dao = new UserInfoDao();
	UserInfoDao userInfoDao = new UserInfoDao();
	
	public UserListView() throws ClassNotFoundException, SQLException{
		super("사용자 관리");
		jTableRefresh();
		vector1 = userInfoDao.getUserList();
		System.out.println("v=" + vector1);
		vector2 = getColumn();

		this.add(jScrollPane1);

		jPanel1.add(jButton1);
		this.add(jPanel1,BorderLayout.NORTH);


		jTable1.addMouseListener(this); //리스너 등록
		jButton1.addActionListener(this); //회원가입버튼 리스너 등록
		setSize(600,200);
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
		jTable1.setModel(model);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = jTable1.getSelectedRow();
		String id = (String) jTable1.getValueAt(r, 0);
		try {
			UserRegView mem = new UserRegView(id, this);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jButton1){
			new UserRegView(this);
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
