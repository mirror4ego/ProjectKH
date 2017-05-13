package dao;

//import javax.sql.DataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;

	
// 각 클래스 간의 의존관계를 빈설정 정보를 바탕으로 컨테이너가 자동으로 연결해 주는 것
// 이 클래스가 정확히 어떤 의미를 갖고 있는지를 잘 모르겠다
// 다시한번 보자
//@Configuration // dependency injection 을 위한 설정 파일 이라는 것을 알려주는 어노테이션
public class DaoFactory { // 클래스를 생성
	
	
//	@Bean // 설정 파일 DI/ XML을 이용하지 않는 방법
	public CustomerDao customerDao() { // CustomerDao 생성
		CustomerDao customerDao = new CustomerDao(); // userDao 클래스의 객체 생성
		//customerDao.setDataSource(dataSource()); // dataSource메소드 반환값을 매개변수로 이용해 데이터 소스를 set하고 userDao 
		return customerDao; // 리턴
	}
	
//	@Bean // 설정 파일 DI/ XML을 이용하지 않는 방법
	public OrderInfoDao orderInfoDao() { // OrderDao 생성
		OrderInfoDao orderInfoDao = new OrderInfoDao(); // userDao 클래스의 객체 생성
		//customerDao.setDataSource(dataSource()); // dataSource메소드 반환값을 매개변수로 이용해 데이터 소스를 set하고 userDao 
		return orderInfoDao; // 리턴
	}
	
//	@Bean // 설정 파일 DI/ XML을 이용하지 않는 방법
	public UserInfoDao userInfoDao() { // OrderDao 생성
		UserInfoDao userInfoDao = new UserInfoDao(); // userDao 클래스의 객체 생성
		//customerDao.setDataSource(dataSource()); // dataSource메소드 반환값을 매개변수로 이용해 데이터 소스를 set하고 userDao 
		return userInfoDao; // 리턴
	}

	
/*	@Bean
	public UserDao userDao() {
		return new UserDao(connectionMaker());	
	}*/

/*	@Bean
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}*/

/*	@Bean // 설정 파일 DI/ XML을 이용하지 않는 방법
	public DataSource dataSource() { // 데이터 소스 
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource(); // 커넥션 연결 
		
		dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class); // DB에 대한 드라이버 설정 
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl"); // URL정보 설정
		dataSource.setUsername("scott"); // 연결 id 설정
		dataSource.setPassword("tiger"); // 연결 패스워드 설정
		
		return dataSource; // 설정된 db 연결 정보를 리턴
	}*/
	
/*	@Bean // 개발용 ConnectionMaker 생성 코드
	public ConnectionMaker connectionMaker() {
		return new LocalDBConnectionMaker();
	}*/
	
/*	@Bean // 운영용 ConnectionMaker 생성 코드
	public ConnectionMaker connectionMaker() {
		return new ProductionDBConnectionMaker();
	}*/
	

}

