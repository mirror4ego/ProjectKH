package projectKH;

import java.sql.SQLException;

import dao.CustomerDao;
import dao.DaoFactory;
import dao.OrderInfoDao;
import dao.UserInfoDao;
import domain.CustomerDto;
import domain.OrderInfoDto;
import domain.UserInfoDto;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {



		CustomerDao customerDao = new DaoFactory().customerDao();
		OrderInfoDao orderInfoDao = new DaoFactory().orderInfoDao();
		UserInfoDao userInfoDao = new DaoFactory().userInfoDao();

		//메인뷰 생성 테스트
		//MainView ex = new MainView("매장관리"); 
		OrderView_sub a = new OrderView_sub("1");
		System.out.println("메인 뷰 생성 완료");

		CustomerDto customerDto01 = new CustomerDto(8, "19990904",	"01023303333", "서울", "금천구", "금천동", "162-33 9층 202호", 2, 44);
		CustomerDto customerDto02 = new CustomerDto(2, "20770913",	"01088482339", "충남", "공주시", "공주동", "45-33 7층 404호", 8, 23);
		CustomerDto customerDto03 = new CustomerDto(3, "20180814",	"01018239583", "서울", "동작구", "사당동", "45-83 001호", 3, 99);
		CustomerDto customerDto04 = new CustomerDto(4, "19880227",	"01041378569", "경기도", "광명시", "광명동", "97-91 554호", 20, 27);

		OrderInfoDto orderInfoDto01 = new OrderInfoDto(7, "20170501", "1", "1", 2, 10, "없음", 3, "20180303", "1", "1", "1", "1", "20170501" , 1);
		OrderInfoDto orderInfoDto02 = new OrderInfoDto(2, "20170501", "0", "1", 2, 10, "빨리 배달", 3, "20170403", "1", "0", "1", "1", "20170523", 1);
		OrderInfoDto orderInfoDto03 = new OrderInfoDto(3, "20170430", "0", "1", 2, 2, "오늘 10시까지 배달", 3, "20170403", "1", "1", "1", "1", "20170403", 1);
		OrderInfoDto orderInfoDto04 = new OrderInfoDto(4, "20170420", "1", "1", 2, 9, "오는 길에 콜라", 3, "20170403", "1", "1", "0", "0", "20170502", 1);		


		UserInfoDto userInfoDto01 = new UserInfoDto("4", "1", "길동", 1, "333", 333, "12");
		//테이블 데이터 삭제 테스트
		//customerDao.deleteAll();
		//System.out.println("Customer 테이블 Truncate 완료");
		//orderInfoDao.deleteAll();
		//System.out.println("OrderInfo 테이블 Truncate 완료");

		//테이블에 데이터 삽입 테스트
		customerDao.add(customerDto01);
		customerDao.add(customerDto02);
		customerDao.add(customerDto03);
		customerDao.add(customerDto04);

		orderInfoDao.add(orderInfoDto01);
		orderInfoDao.add(orderInfoDto02);
		orderInfoDao.add(orderInfoDto03);
		orderInfoDao.add(orderInfoDto04);

		userInfoDao.add(userInfoDto01);		

		System.out.println(customerDto01.getCustomerNum() + "번 고객 등록 성공");
		System.out.println(customerDto02.getCustomerNum() + "번 고객 등록 성공");
		System.out.println(customerDto03.getCustomerNum() + "번 고객 등록 성공");
		System.out.println(customerDto04.getCustomerNum() + "번 고객 등록 성공");
		System.out.println(orderInfoDto01.getOrderInfoNum() + "번 주문 등록 성공");
		System.out.println(orderInfoDto02.getOrderInfoNum() + "번 주문 등록 성공");
		System.out.println(orderInfoDto03.getOrderInfoNum() + "번 주문 등록 성공");
		System.out.println(orderInfoDto04.getOrderInfoNum() + "번 주문 등록 성공");

	}
}

