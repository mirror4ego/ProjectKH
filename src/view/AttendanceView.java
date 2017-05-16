package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

class AttendanceView extends JFrame{
String name; //이름
int numberOfClass; //수업일수
int absence; //결석
int late; //지각
int eLeave; //조퇴



public AttendanceView(){
	
	super("고객정보검색");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setSize(750,200);
	this.setResizable(false);

	init();
	start();
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension dimension1 = toolkit.getScreenSize();
	Dimension dimension2 = this.getSize();
	this.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
			(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
	this.setVisible(true);

}



public AttendanceView(String name, int numberOfClass, int absence, int late, int eLeave){
	
	super();

	this.name = name; 
	this.numberOfClass = numberOfClass; 
	this.absence = absence; //출근
	this.late = late; //지각
	this.eLeave = eLeave; //조퇴
}

public void plusAbsence(){
	++absence;
	}	

public void plusLate(){
	++late;
	}
public void plusELeave(){
	++eLeave;
}

public void init(){
	
}

public void start(){
	
}


public int getAbsence(){
	//지각이나 	조퇴 3번은 1번의 결석
	absence = absence + (late/3)+(eLeave/3);
	return absence;
}

public void getAttendanceView(){
	//수료 = 수업 80% 출석
	if((float)((numberOfClass - absence)) /(float)(numberOfClass) *  100 >= 80){
		System.out.println(name + ":" + "수료");
	}else{
		System.out.println(name + ":" + "미수료");
		
		}
	}

}
