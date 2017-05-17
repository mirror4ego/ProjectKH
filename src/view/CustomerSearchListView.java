package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.UserInfoDao;

public class CustomerSearchListView extends JFrame implements MouseListener,ActionListener{

	Vector vector1;  
	Vector vector2;
	Vector vector3 = new Vector();
	DefaultTableModel defaultTableModel1 = new DefaultTableModel(vector1, vector2);
	JTable jTable1 = new JTable(defaultTableModel1);
	JScrollPane jScrollPane1 = new JScrollPane(jTable1);
	UserInfoDao userInfoDao = new UserInfoDao();

	public CustomerSearchListView(Vector customerDto) throws ClassNotFoundException, SQLException{
		super("검색된 고객정보 리스트");
		this.add(jScrollPane1);
		setSize(600,200);
		start();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jTableRefresh(customerDto);
	}
	
	public void init() {
		
	}
	
	public void start() {
		jTable1.addMouseListener(this); //리스너 등록
	}

	public Vector getColumn(){
		vector3.add("고객번호");
		vector3.add("가입날짜");
		vector3.add("전화번호");
		vector3.add("주소1");
		vector3.add("주소2");
		vector3.add("주소3");
		vector3.add("주소4");
		vector3.add("주문횟수");
		vector3.add("고객나이");
		return vector3;
	}

	public void jTableRefresh(Vector customerDto) throws ClassNotFoundException, SQLException{
		//테이블 내용을 먼저 초기화 하고 리플래시를 해야함
		//테이블 내용을 초기화 하는 로직이 들어가야 하는 곳
		jTable1.removeAll();
		DefaultTableModel model= new DefaultTableModel(customerDto, getColumn());

		jTable1.setModel(model);
	}	

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = jTable1.getSelectedRow();
		int customerNum = (int)(jTable1.getValueAt(r, 0));
		try {
			CustomerSearchView customerSearchView = new CustomerSearchView(customerNum, this);

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
