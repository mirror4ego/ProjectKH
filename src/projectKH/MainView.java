package projectKH;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class MainView extends JFrame implements ActionListener, MouseListener, KeyListener, FocusListener{
	private Container con; // 컨테이너
	private BorderLayout mainBorderLayout = new BorderLayout(5, 5);

	private JButton button1 = new JButton(" 고객 관리");
	private JButton button2 = new JButton(" 주문 관리");
	private JButton button3 = new JButton(" 직원 관리");
	private JButton button4 = new JButton(" 데이터 분석");
	
	private JTextArea textArea1 = new JTextArea("textArea1");
	private JTextArea textArea2 = new JTextArea("textArea2");
	private JTextArea textArea3 = new JTextArea("textArea3");
	private JTextArea textArea4 = new JTextArea("textArea4");


	MainView (String viewTitle) {
		super(viewTitle);
		this.init();
		this.start();
		this.setSize(1000,600);
		this.setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int)(di.getWidth() / 2 - di1.getWidth() / 2), 
				(int)(di.getHeight() / 2 - di1.getHeight() / 2));
		this.setVisible(true);
	}

	void init() {
		con = this.getContentPane();
		con.setLayout(mainBorderLayout);

		//메인 보더레이아웃의 north영역 설정
		button1.setIcon(new ImageIcon("customer.png"));
		button2.setIcon(new ImageIcon("order.png"));
		button3.setIcon(new ImageIcon("employee.png"));
		button4.setIcon(new ImageIcon("data.png"));
		
		Font menuFont = new Font("맑은 고딕", Font.BOLD, 15);
		button1.setFont(menuFont);
		button2.setFont(menuFont);
		button3.setFont(menuFont);
		button4.setFont(menuFont);
		
		button1.setBorder(new BevelBorder(BevelBorder.RAISED));
		button2.setBorder(new BevelBorder(BevelBorder.RAISED));
		button3.setBorder(new BevelBorder(BevelBorder.RAISED));
		button4.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		button1.addMouseListener(this);
		button2.addMouseListener(this);
		button3.addMouseListener(this);
		button4.addMouseListener(this);

		JPanel jPanel = new JPanel(new GridLayout(1,4));
		jPanel.add("North", button1);
		jPanel.add("North", button2);
		jPanel.add("North", button3);
		jPanel.add("North", button4);

		con.add("North", jPanel);
		
		//메인 보더레이아웃의 south영역 설정
		con.add("South", textArea1);
		
		//메인 보더레이아웃의 center영역 설정
		con.add("Center", textArea2);
		
		//메인 보더레이아웃의 west영역 설정
		con.add("West", textArea3);
		
		//메인 보더레이아웃의 east영역 설정
		con.add("East", textArea4);
		
	}

	void start() {

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1){
			System.out.println("1번 버튼 클릭");
		}else if(e.getSource()==button2){
			System.out.println("2번 버튼 클릭");
		}else if(e.getSource()==button3){
			System.out.println("3번 버튼 클릭");
		}else if(e.getSource()==button4){
			System.out.println("4번 버튼 클릭");
		}else{
			System.out.println("이상동작 발생");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}