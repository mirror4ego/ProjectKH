package SW;

import java.util.Scanner;
import java.util.Vector;

import Person.*;

public class UserTable {
	public static Vector<Employee> User = new Vector<Employee>(30);
	
	public static String departTable[][] = {
		{ "비서실", null },
		{ "총무팀", null },
		{ "인사팀", null },
		{ "개발1팀", null },
		{ "개발2팀", null },
		{ "개발3팀", null }
	};	// 저장 형태는 {부서명, 이름}
	
	public static void addUser(Object obj[]) {
		Employee temp = null;
		if(obj[3].equals("Staff"))
			temp = new Staff(obj[0].toString(), obj[1].toString(), obj[2].toString());
		else if(obj[3].equals("SW Developer"))
			temp = new SW_Developer(obj[0].toString(), obj[1].toString(), obj[2].toString());
		else if(obj[3].equals("SW Tester"))
			temp = new SW_Tester(obj[0].toString(), obj[1].toString(), obj[2].toString());
		User.addElement(temp);
		GUI.MainFrame.addUser(temp);
	}
	
	public static boolean checkId(String id) {
		for(int i = 0; i < User.size(); i++)
			if(User.elementAt(i).getId().equals(id))
				return false;				// 중복 있음.
		return true;						// 중복 없음.
	}
	
	public static boolean checkDepart(String depart) {
		if(depart.equals("비서실") || depart.equals("총무팀") || depart.equals("인사팀"))
			return false;				// 개발 지원팀은 false
		return true;					// 개발팀은 true
	}
	
	public static String checkManager(String name) {		// 인자:매니저명, 반환:그 매니저의 부서
		for(int i = 0; i < departTable.length; i++) 
			if(departTable[i][1].equals(name))
				return departTable[i][0];
		
		return null;
	}
	
	public static void setDepartTable(String depart, String name) {
		for(int i = 0; i < departTable.length; i++)
			if(departTable[i][0].equals(depart))
				departTable[i][1] = name;
	}
	
	public static void searchById(String str) {
		for(int i = 0; i < User.size(); i++)
			if(User.elementAt(i).getId().equals(str)) {
				GUI.MainFrame.addSearchedUser(User.elementAt(i));
			}
	}
	
	public static void searchByName(String str) {
		for(int i = 0; i < User.size(); i++)
			if(User.elementAt(i).getName().equals(str)) {
				GUI.MainFrame.addSearchedUser(User.elementAt(i));
			}
	}
	
	public static void searchByDepart(String str) {
		for(int i = 0; i < User.size(); i++)
			if(User.elementAt(i).getDepart().equals(str)) {
				GUI.MainFrame.addSearchedUser(User.elementAt(i));
			}
	}
	
	public static void searchByManager(String str) {
		str = checkManager(str);
		for(int i = 0; i < User.size(); i++)
			if(User.elementAt(i).getDepart().equals(str)) {
				GUI.MainFrame.addSearchedUser(User.elementAt(i));
			}
	}
	
	public static void deleteUser(String id) {
		for(int i = 0; i < User.size(); i++)
			if(User.elementAt(i).getId().equals(id))
				User.removeElementAt(i);
	}
	
	public static void correctUser(Object obj[]) {
		
		for(int i = 0; i < User.size(); i++)
			if(User.elementAt(i).getId().equals(obj[0])) {
				User.get(i).setName(obj[1].toString());
				User.get(i).setDepart(obj[2].toString());
				User.get(i).setType(obj[3].toString());
			}
	}
	
	public static void addAllUser() {
		for(int i = 0; i < User.size(); i++)
				GUI.MainFrame.addSearchedUser(User.elementAt(i));
	}
}