package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	MemberDAO dao = new MemberDAO();
	UserInfoDao userInfoDao = new UserInfoDao();
	
	public UserListView(){
		super("사용자 목록");

		vector1 = userInfoDao.getMemberList();
		System.out.println("v=" + vector1);
		vector2 = getColumn();

		this.add(jScrollPane1);

		jPanel1.add(jButton1);
		this.add(jPanel1,BorderLayout.NORTH);


		jTable1.addMouseListener(this); //리스너 등록
		jButton1.addActionListener(this); //회원가입버튼 리스너 등록

		setSize(600,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Vector getColumn(){
		vector3.add("아이디");
		vector3.add("비밀번호");
		vector3.add("이름");
		vector3.add("전화");
		vector3.add("주소");
		vector3.add("생일");
		vector3.add("직업");
		vector3.add("성별");
		vector3.add("이메일");
		vector3.add("자기소개");
		return vector3;
	}

	public void jTableRefresh(){
		DefaultTableModel model= new DefaultTableModel(dao.getMemberList(), getColumn());
		jTable1.setModel(model);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = jTable1.getSelectedRow();
		String id = (String) jTable1.getValueAt(r, 0);
		MemberProc mem = new MemberProc(id,this); //아이디를 매개변수로 수정창 생성
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jButton1){
			new MemberProc(this);
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
