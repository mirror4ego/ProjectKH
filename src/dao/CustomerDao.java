package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import domain.CustomerDto;
import resources.ConnectionMaker;
import resources.ConnectionMakerKH;
import view.CustomerSearchView;

public class CustomerDao {
	//private ConnectionMaker connectionMaker;
	ConnectionMaker connectionMaker = new ConnectionMakerKH();
	public CustomerDao() {
		connectionMaker = new ConnectionMakerKH();
	}

	public void add(CustomerDto customerDto) throws ClassNotFoundException, SQLException { // 고객을 추가하는 메소드, 매개변수는  Customer클래스의 객체
		Connection c = connectionMaker.makeConnection(); // data소스에 저장된 커넥션 정보를 c에 저장 

		PreparedStatement ps = c.prepareStatement("insert into customer values (seq_customer_num.nextval,?,?,?,?,?,?,?,?)");
		// c 객체의 메소드인 prepareaStatement를 이용해서 db에 쿼리를 날림
		// 각 칼럼값에 집어넣을 low값을 ?로 설정

		// 각 물음표 값에 들어갈 값을 지정하고 set
		ps.setString(1, customerDto.getCustomerRegDate());
		ps.setString(2, customerDto.getCustomerPhoneNum());
		ps.setString(3, customerDto.getCustomerAddState());
		ps.setString(4, customerDto.getCustomerAddCity());
		ps.setString(5, customerDto.getCustomerAddStreet());
		ps.setString(6, customerDto.getCustomerAddRest());
		ps.setInt(7, customerDto.getCustomerFrequent());
		ps.setInt(8, customerDto.getCustomerAgePredict());

		ps.executeUpdate(); // 쿼리 날리기... executeUpdate를 사용한 이유는 insert into라는 sql문은
		// 결과값을 받아올 필요가 없기 때문이다. 쿼리문을 날리고 결과 값을 받아올 필요가 있을때는(ex : select문)
		// executeQuery 메소드를 사용해야 한다.

		ps.close(); // 사용한 ps객체 닫기
		c.close(); // 사용한 c객체 닫기
		// 공유 자원이기 때문에 닫아주지않으면 연결 세션을 계속 점유 하고 있게 된다.
	}


	public CustomerDto get(int customerNum) throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection(); // DB로의 커넥션 객체 생성

		PreparedStatement ps = c.prepareStatement("select * from customer where customer_num = ?");
		// preparestatement메소드를 통해서 쿼리문을 날릴 준비를 함
		ps.setInt(1, customerNum);
		// ? 에 매개변수로 받아온 id를 입력해서 쿼리문 완성

		ResultSet rs = ps.executeQuery();
		// 쿼리문을 실행 executeQuery를 통해서 쿼리를 실행한 결과 값을 받아와서 ResultSet의 객체참조주소 rs에 저장
		rs.next(); // 쿼리문을 통해 받아온 값은 start를 가르키는 위치가 있기 때문에 진짜 값이 시작되는 곳을 찾으려면 이 메소드를 꼭 한번 실행해야 한다
		CustomerDto customerDto = new CustomerDto(); // 고객정보 클래스의 객체를 생성

		customerDto.setCustomerNum(rs.getInt("customer_Num"));
		customerDto.setCustomerRegDate(rs.getString("customer_Reg_Date"));
		customerDto.setCustomerPhoneNum(rs.getString("customer_Phone_Num"));
		customerDto.setCustomerAddState(rs.getString("customer_Add_State"));
		customerDto.setCustomerAddCity(rs.getString("customer_Add_City"));
		customerDto.setCustomerAddStreet(rs.getString("customer_Add_Street"));
		customerDto.setCustomerAddRest(rs.getString("customer_Add_Rest"));
		customerDto.setCustomerFrequent(rs.getInt("customer_Frequent"));
		customerDto.setCustomerAgePredict(rs.getInt("customer_Age_Predict"));

		// DB사용이 끝났으므로 모든 커넥션을 순서대로 닫아준다
		rs.close();
		ps.close();
		c.close();

		return customerDto; // 최종적으로 불러온 유저 정보에 관련한 객체를 리턴
	}
	
	public CustomerDto searchCustomerRegDate() throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement("select sum customerFrequent from customer where customer_reg_date");
		ResultSet rs = ps.executeQuery();

		rs.next();
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerNum(rs.getInt("customerNum"));
		customerDto.setCustomerRegDate(rs.getString("customerRegDate"));
		customerDto.setCustomerPhoneNum(rs.getString("customerPhoneNum"));
		customerDto.setCustomerAddState(rs.getString("customerAddState"));
		customerDto.setCustomerAddCity(rs.getString("customerAddCity"));
		customerDto.setCustomerAddStreet(rs.getString("customerAddStreet"));
		customerDto.setCustomerAddRest(rs.getString("customerAddRest"));
		customerDto.setCustomerFrequent(rs.getInt("customerFrequent"));
		customerDto.setCustomerAgePredict(rs.getInt("customerAgePredict"));

		rs.close();
		ps.close();
		c.close();

		return customerDto;
	}

	public void deleteAll() throws ClassNotFoundException, SQLException { // DB에 저장된 데이터를 전부 삭제하는 메소드
		Connection c = connectionMaker.makeConnection();; // DB로의 커넥션 생성

		PreparedStatement ps = c.prepareStatement("truncate table customer");
		// preparestatement메소드를 통해서 쿼리문을 날릴 준비를 함

		ps.executeUpdate(); // 쿼리문 실행

		// 커넥션 close
		ps.close();
		c.close();
	}

		//뭔지모르겠어서 일단 주석
		//Connection c = connectionMaker.makeConnection();
		//PreparedStatement ps = c.prepareStatement("select * from customer where customer_reg_date = ?");
		//ps.setString(1, customerRegDate);
		//ResultSet rs = ps.executeQuery();
	
//날짜미완
	/*
	public int sumCustomerNum(int customerDate) throws ClassNotFoundException, SQLException{

		int sum=0;
		Connection c = connectionMaker.makeConnection();

		try{
			PreparedStatement ps = c.prepareStatement("select * orderby customer_reg_date from customer");
			//ps.setInt(1,customerDate);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				sum+=rs.getInt("customer_frequent");
			}else{
				JOptionPane.showMessageDialog(null, "고객번호가 존재하지 않습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sum;    
	}
	*/
	
	public int sumCustomerAge(int CusAge,int CusAge2) throws ClassNotFoundException, SQLException {

		Connection c = connectionMaker.makeConnection();
		
		//int sum = 0;
		int cnt=0;
		try {
			  
			PreparedStatement ps = c.prepareStatement(
					"select customer_age_predict from customer where (customer_age_predict>? and customer_age_predict<?)"
					,ResultSet.TYPE_SCROLL_INSENSITIVE, 
		             ResultSet.CONCUR_UPDATABLE);
			//last 쓰기위한 추가구문
			ps.setInt(1,CusAge);
			ps.setInt(2,CusAge2);
			
			ResultSet rs = ps.executeQuery();
			
			rs.last();
			cnt=rs.getRow();
			rs.beforeFirst();
			// 레코드개수를 구하기위함.

			rs.close();
		ps.close();
		c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	//고객 한명의 정보를 가져오는 메소드 (고객번호를 기준으로)
	public CustomerDto searchCustomerNum(int customerNum) throws ClassNotFoundException, SQLException{


		Connection c = connectionMaker.makeConnection();
		CustomerDto customerDto = new CustomerDto();

		try{
			PreparedStatement ps = c.prepareStatement("select * from customer where customer_num=?");
			ps.setInt(1, customerNum);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				customerDto.setCustomerNum(rs.getInt("customer_Num"));
				customerDto.setCustomerRegDate(rs.getString("customer_Reg_Date"));
				customerDto.setCustomerPhoneNum(rs.getString("customer_Phone_Num"));
				customerDto.setCustomerAddState(rs.getString("customer_Add_State"));
				customerDto.setCustomerAddCity(rs.getString("customer_Add_City"));
				customerDto.setCustomerAddStreet(rs.getString("customer_Add_Street"));
				customerDto.setCustomerAddRest(rs.getString("customer_Add_Rest"));
				customerDto.setCustomerFrequent(rs.getInt("customer_Frequent"));
				customerDto.setCustomerAgePredict(rs.getInt("customer_Age_Predict"));
				CustomerSearchView customerSearchView = new CustomerSearchView();
				customerSearchView.jTextField1.setText(String.valueOf(customerDto.getCustomerNum()));
				customerSearchView.jTextField2.setText(customerDto.getCustomerRegDate());
				customerSearchView.jTextField3.setText(customerDto.getCustomerPhoneNum());
				customerSearchView.jTextField4.setText(customerDto.getCustomerAddState());
				customerSearchView.jTextField7.setText(customerDto.getCustomerAddCity());
				customerSearchView.jTextField8.setText(customerDto.getCustomerAddStreet());
				customerSearchView.jTextField9.setText(customerDto.getCustomerAddRest());
				customerSearchView.jTextField5.setText(String.valueOf(customerDto.getCustomerFrequent()));
				customerSearchView.jTextField6.setText(String.valueOf(customerDto.getCustomerAgePredict()));
			}else{
				JOptionPane.showMessageDialog(null, "고객번호가 존재하지 않습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerDto;    
	}

	public Vector searchCustomerPhoneNum(String customerSearchPhoneNum) throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();
		CustomerDto customerDto = new CustomerDto();
		Vector data = new Vector();
		try{
			PreparedStatement ps = c.prepareStatement("select * from customer where customer_phone_num = ?"); // 
			ps.setString(1, customerSearchPhoneNum);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				int customerNum = rs.getInt("customer_Num");
				String customerRegDate = rs.getString("customer_Reg_Date");
				String customerPhoneNum = rs.getString("customer_Phone_Num");
				String customerAddState = rs.getString("customer_Add_State");
				String customerAddCity = rs.getString("customer_Add_City");
				String customerAddStreet = rs.getString("customer_Add_Street");
				String customerAddRest = rs.getString("customer_Add_Rest");
				int customerFrequent = rs.getInt("customer_Frequent");
				int customerAgePredict = rs.getInt("customer_Age_Predict");

				Vector row = new Vector();
				row.add(customerNum);
				row.add(customerRegDate);
				row.add(customerPhoneNum);
				row.add(customerAddState);
				row.add(customerAddCity);
				row.add(customerAddStreet);
				row.add(customerAddRest);
				row.add(customerFrequent);
				row.add(customerAgePredict);

				data.add(row); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public CustomerDto searchCustomerAddress(String customerAddress) throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();
		CustomerDto customerDto = new CustomerDto();

		PreparedStatement ps = c.prepareStatement("select * from customer where customer_Add_Rest = ?");
		ps.setString(1, customerAddress);
		ResultSet rs = ps.executeQuery();

		if(rs.next()){

			customerDto.setCustomerNum(rs.getInt("customer_Num"));
			customerDto.setCustomerRegDate(rs.getString("customer_Reg_Date"));
			customerDto.setCustomerPhoneNum(rs.getString("customer_Phone_Num"));
			customerDto.setCustomerAddState(rs.getString("customer_Add_State"));
			customerDto.setCustomerAddCity(rs.getString("customer_Add_City"));
			customerDto.setCustomerAddStreet(rs.getString("customer_Add_Street"));
			customerDto.setCustomerAddRest(rs.getString("customer_Add_Rest"));
			customerDto.setCustomerFrequent(rs.getInt("customer_Frequent"));
			customerDto.setCustomerAgePredict(rs.getInt("customer_Age_Predict"));

		}else{
			JOptionPane.showMessageDialog(null, "고객의 주소가 존재하지 않습니다");
		}
		rs.close();
		ps.close();
		c.close();

		return customerDto;
	}
}
