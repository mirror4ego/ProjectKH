package projectKH;

import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		CustomerDao dao = new DaoFactory().customerDao();
		Customer customer = new Customer(1, "19990904",	"01023303333", "서울", "금천구", "금천동", "162-33 9층 202호", 2, 44);

		//MainView 테스트
		MainView mainView = new MainView("매장 관리");
		System.out.println("메인뷰 생성 완료");		
		
		//고객 테이블 데이터 삭제 테스트
		dao.deleteAll();
		System.out.println("Customer 테이블 Truncate 완료");
		
		//고객 테이블에  데이터 삽입 테스트
		dao.add(customer);
		System.out.println(customer.getCustomerNum() + "번 고객 등록 성공");

	}
}

