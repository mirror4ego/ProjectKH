package view;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class UserSelectView {
	private Dimension dimen1, dimen2;
	private int xpos, ypos;

	Frame f = new Frame(); // 프레임 생성
	Button btn1 = new Button("버튼1"); // 버튼 객체 생성 및 초기화
	Button btn2 = new Button("버튼2"); // 버튼 객체 생성 및 초기화
	Label lb1 = new Label("라벨 : 라벨 센터",Label.CENTER); // 라벨 객체 생성 및 초기화

	public UserSelectView(){
		//super("");
		this.init(); // 이 클래스에 있는 init메소드 실행
		this.start(); // 이 클래스에 있는 start메소드 실행
		f.setSize(300, 200); // 프레임의 사이즈 설정
		dimen1 = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈 얻어옴
		dimen2 = f.getSize(); // 프레임 사이즈 얻어옴

		xpos = (int)(dimen1.getWidth() / 2 - dimen2.getWidth()/2); // x위치값 계산
		ypos = (int)(dimen1.getHeight() / 2 - dimen2.getHeight()/2); // y위치값 계산

		f.setLocation(xpos, ypos); // 프레임의 위치 설정
		f.setVisible(true); // 프레임을 보이게 함
	}
	private void init() {
		BorderLayout border = new BorderLayout(); // 보더레이아웃 객체 생성
		f.setLayout(border); // 프레임에 보더 레이아웃 설정
		f.add("North", lb1); // 프레임에 라벨1을 보더레이아웃 북쪽에 붙여넣음
		Panel p = new Panel(new FlowLayout(FlowLayout.CENTER)); //플로우레이아웃을 넣은 패널 객체 생성
		p.add(btn1); // 패널에 버튼 붙여넣음
		p.add(btn2); // 패널에 버튼 붙여넣음
		f.add("Center", p); // 프레임에 패널객체 p를 가운데에 집어넣음



	}
	private void start() {
		ActionDefine ad = new ActionDefine();
		btn1.addActionListener(ad); //ad객체에서 액션리스너 인터페이스를 임플리먼트했으므로 사용가능 
		btn2.addActionListener(ad); //

	}
}

class ActionDefine implements ActionListener{ //액션리스너 인터페이스를 임플리먼트함
	//Exam02 ex = new Exam02();
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand()=="버튼1"){ // 버튼을 눌렀을때 버튼 객체의 출력된 매개변수 값과 비교
			System.out.println("출력 : 버튼1을 누르셨습니다");
			try {
				UserListView userListView = new UserListView();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return;
		}else if(e.getActionCommand()=="버튼2"){
			System.out.println("출력 : 버튼2를 누르셨습니다");
			
				AttendanceView attendanceView = new AttendanceView();
				
			return;
		}

		System.out.println(e.getActionCommand()=="버튼1");
		return;
	}

}

