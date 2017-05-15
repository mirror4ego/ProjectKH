package view;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import javax.swing.JFrame;

class AttendanceView extends JFrame {
	private Dimension dimen1, dimen2;
	private int xpos, ypos;

	Frame f = new Frame(); // 프레임 생성
	Button btn1 = new Button("버튼1"); // 버튼 객체 생성 및 초기화
	Button btn2 = new Button("버튼2"); // 버튼 객체 생성 및 초기화
	Label lb1 = new Label("라벨 : 라벨 센터",Label.CENTER); // 라벨 객체 생성 및 초기화

	public AttendanceView(){
		super("출결 관리");
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

	}
	private void start() {

	}
}


