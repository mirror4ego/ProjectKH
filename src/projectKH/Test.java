package projectKH;

import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		CustomerDao customerDao = new DaoFactory().customerDao();
		OrderInfoDao orderInfoDao = new DaoFactory().orderInfoDao();
		
		OrderView_sub ex = new OrderView_sub(null); 
		Customer customer01 = new Customer(8, "19990904",	"01023303333", "서울", "금천구", "금천동", "162-33 9층 202호", 2, 44);
		Customer customer02 = new Customer(2, "20770913",	"01088482339", "충남", "공주시", "공주동", "45-33 7층 404호", 8, 23);
		Customer customer03 = new Customer(3, "20180814",	"01018239583", "서울", "동작구", "사당동", "45-83 001호", 3, 99);
		Customer customer04 = new Customer(4, "19880227",	"01041378569", "경기도", "광명시", "광명동", "97-91 554호", 20, 27);
		
		OrderInfo orderInfo01 = new OrderInfo(7, "20170501", "1", "1", 2, 10, "없음", 3, "20180303", "1", "1", "1", "1", "20170501");
		OrderInfo orderInfo02 = new OrderInfo(2, "20170501", "0", "1", 2, 10, "빨리 배달", 3, "20170403", "1", "0", "1", "1", "20170523");
		OrderInfo orderInfo03 = new OrderInfo(3, "20170430", "0", "1", 2, 2, "오늘 10시까지 배달", 3, "20170403", "1", "1", "1", "1", "20170403");
		OrderInfo orderInfo04 = new OrderInfo(4, "20170420", "1", "1", 2, 9, "오는 길에 콜라", 3, "20170403", "1", "1", "0", "0", "20170502");
		
		//MainView 테스트
		//MainView mainView = new MainView("매장 관리");
		//System.out.println("메인뷰 생성 완료");		
		
		//테이블 데이터 삭제 테스트
		customerDao.deleteAll();
		System.out.println("Customer 테이블 Truncate 완료");
		orderInfoDao.deleteAll();
		System.out.println("OrderInfo 테이블 Truncate 완료");
		
		//테이블에 데이터 삽입 테스트
		customerDao.add(customer01);
		customerDao.add(customer02);
		customerDao.add(customer03);
		customerDao.add(customer04);
		
		orderInfoDao.add(orderInfo01);
		orderInfoDao.add(orderInfo02);
		orderInfoDao.add(orderInfo03);
		orderInfoDao.add(orderInfo04);
		
		System.out.println(customer01.getCustomerNum() + "번 고객 등록 성공");
		System.out.println(customer02.getCustomerNum() + "번 고객 등록 성공");
		System.out.println(customer03.getCustomerNum() + "번 고객 등록 성공");
		System.out.println(customer04.getCustomerNum() + "번 고객 등록 성공");
		System.out.println(orderInfo01.getOrderInfoNum() + "번 주문 등록 성공");
		System.out.println(orderInfo02.getOrderInfoNum() + "번 주문 등록 성공");
		System.out.println(orderInfo03.getOrderInfoNum() + "번 주문 등록 성공");
		System.out.println(orderInfo04.getOrderInfoNum() + "번 주문 등록 성공");

	}
}

