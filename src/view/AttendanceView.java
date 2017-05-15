package view;


class AttendanceView {
String name; //이름
int numberOfClass; //수업일수
int absence; //결석
int late; //지각
int eLeave; //조퇴

public AttendanceView(String name, int numberOfClass, int absence, int late, int eLeave){
	super();
	this.name = name;
	this.numberOfClass = numberOfClass;
	this.absence = absence;
	this.late = late;
	this.eLeave = eLeave;
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


