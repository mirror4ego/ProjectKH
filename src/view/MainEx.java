package view;

public class MainEx {
	public static void main(String[] ar){
		
		AttendanceView ad = new AttendanceView("홍길동", 60,6,10,9);
		
		int numberOfClass = ad.numberOfClass; //수업일수
		System.out.println("수업일수: "+numberOfClass);
		int absence = ad.absence; //결석
		System.out.println("결석: "+ absence);
		int late = ad.late; //지각
		System.out.println("지각: "+late);
		int eLeave = ad.eLeave; //조퇴
		System.out.println("조퇴: "+eLeave);
		
		int totalAbsence = ad.getAbsence();
		System.out.println("총 결석일수: "+totalAbsence);
		
		ad.getAttendanceView();
		
	}
}
