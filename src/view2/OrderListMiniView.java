package view2;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.OrderInfoDao;
import setting.SetLookAndFeel;
import setting.SetUiFont;

public class OrderListMiniView extends JFrame implements MouseListener, ActionListener{

	private SetLookAndFeel setLookAndFeel = new SetLookAndFeel();
	private SetUiFont setUiFont = new SetUiFont();

	private JTextField textField = new JTextField();
	private JTextField textField_1 = new JTextField();

	private JLabel lblNewLabel = new JLabel("ㅇ주문내역");
	private JLabel lblNewLabel_1 = new JLabel("고객번호");
	private JLabel label = new JLabel("전화번호");
	
	private JPanel panel_2 = new JPanel();
	private JPanel panel = new JPanel();
	private JPanel panel_1 = new JPanel();
	
	private JButton btnNewButton = new JButton("회원정보보기");
	private JButton button = new JButton("파일");
	private JButton button_1 = new JButton("출력");
	private JButton button_2 = new JButton("닫기");
	
	private Vector vector3 = new Vector();
	private DefaultTableModel defaultTableModel1 = new DefaultTableModel();
	private JTable table = new JTable();
	private JScrollPane scrollPane = new JScrollPane(table);
	
	public OrderListMiniView(int customerNum, String customerPhoneNum) throws ClassNotFoundException, SQLException {
		super("미니주문내역");
		this.init();
		this.start();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(640,720);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();
		Dimension dimension2 = this.getSize();
		this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
				(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		this.getColumn();
		
		this.jTableRefresh(new OrderInfoDao().orderInfoOneCustomer(customerNum));
		textField.setText(String.valueOf(customerNum));
		textField_1.setText(String.valueOf(customerPhoneNum));
		
	}

	void init() {
		panel.setBounds(12, 10, 610, 671);
		getContentPane().add(panel);
		panel.setLayout(null);
		scrollPane.setBounds(12, 53, 586, 527);
		panel.add(scrollPane);

		table.setBounds(37, 47, 553, 556);

		panel_1.setBounds(12, 10, 586, 33);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel.setBounds(12, 10, 83, 15);
		panel_1.add(lblNewLabel);

		lblNewLabel_1.setBounds(307, 10, 57, 15);
		panel_1.add(lblNewLabel_1);

		textField.setBounds(369, 7, 46, 21);
		panel_1.add(textField);
		textField.setEditable(false);
		textField.setText("123123");
		textField.setColumns(10);
		
		textField_1.setText("123123");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(484, 7, 90, 21);
		panel_1.add(textField_1);
		
		label.setBounds(427, 10, 57, 15);
		panel_1.add(label);

		panel_2.setBounds(12, 590, 586, 81);
		panel.add(panel_2);
		panel_2.setLayout(null);

		btnNewButton.setBounds(12, 10, 154, 61);
		panel_2.add(btnNewButton);

		button.setBounds(370, 10, 60, 60);
		panel_2.add(button);

		button_1.setBounds(442, 10, 60, 60);
		panel_2.add(button_1);

		button_2.setBounds(514, 10, 60, 60);
		panel_2.add(button_2);
	}

	void start() {
		table.addMouseListener(this);
		btnNewButton.addActionListener(this);
		button.addActionListener(this);
		button_1.addActionListener(this);
		button_2.addActionListener(this);
	}

	public void jTableRefresh(Vector customerDto) throws ClassNotFoundException, SQLException{
		DefaultTableModel model = new DefaultTableModel();
		System.out.println(vector3);
		model.setDataVector(customerDto, vector3);
		table.setModel(model);

	}

	public Vector getColumn(){
		vector3.add("주문번호");
		vector3.add("주문일자");
		vector3.add("고객번호");
		vector3.add("직원ID");
		return vector3;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button_2){
			this.dispose();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
