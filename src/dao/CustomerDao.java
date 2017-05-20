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
	ConnectionMaker connectionMaker = new ConnectionMakerKH();
	public CustomerDao() {
		connectionMaker = new ConnectionMakerKH();
	}

	// 고객을 추가하는 메소드, 매개변수는  Customer클래스의 객체
	public void add(CustomerDto customerDto) throws ClassNotFoundException, SQLException { 

		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("insert into customer values (seq_customer_num.nextval,?,?,?,?,?,?,?,?,?,?)");

		ps.setString(1, customerDto.getCustomerRegDate());
		ps.setString(2, customerDto.getCustomerPhoneNum());
		ps.setString(3, customerDto.getCustomerAddState());
		ps.setString(4, customerDto.getCustomerAddCity());
		ps.setString(5, customerDto.getCustomerAddStreet());
		ps.setString(6, customerDto.getCustomerAddRest());
		ps.setInt(7, customerDto.getCustomerFrequent());
		ps.setInt(8, customerDto.getCustomerAgePredict());
		ps.setInt(9, customerDto.getCustomerReceivable());
		ps.setInt(10, customerDto.getCustomerGender());

		ps.executeUpdate();
		ps.close();
		c.close();
	}


	public CustomerDto get(int customerNum) throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("select * from customer where customer_num = ?");
		ps.setInt(1, customerNum);

		ResultSet rs = ps.executeQuery();

		rs.next();
		CustomerDto customerDto = new CustomerDto();

		customerDto.setCustomerNum(rs.getInt("customer_Num"));
		customerDto.setCustomerRegDate(rs.getString("customer_Reg_Date"));
		customerDto.setCustomerPhoneNum(rs.getString("customer_Phone_Num"));
		customerDto.setCustomerAddState(rs.getString("customer_Add_State"));
		customerDto.setCustomerAddCity(rs.getString("customer_Add_City"));
		customerDto.setCustomerAddStreet(rs.getString("customer_Add_Street"));
		customerDto.setCustomerAddRest(rs.getString("customer_Add_Rest"));
		customerDto.setCustomerFrequent(rs.getInt("customer_Frequent"));
		customerDto.setCustomerAgePredict(rs.getInt("customer_Age_Predict"));
		customerDto.setCustomerReceivable(rs.getInt("customer_Receivable"));
		customerDto.setCustomerGender(rs.getInt("customer_Gender"));

		rs.close();
		ps.close();
		c.close();

		return customerDto;
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
		customerDto.setCustomerReceivable(rs.getInt("customer_Receivable"));
		customerDto.setCustomerGender(rs.getInt("customer_Gender"));

		rs.close();
		ps.close();
		c.close();

		return customerDto;
	}

	public void deleteAll() throws ClassNotFoundException, SQLException { // DB에 저장된 데이터를 전부 삭제하는 메소드
		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("truncate table customer");

		ps.executeUpdate();

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
				customerDto.setCustomerReceivable(rs.getInt("customer_Receivable"));
				customerDto.setCustomerGender(rs.getInt("customer_Gender"));

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
				Vector row = new Vector();
				row.add(rs.getInt("customer_Num"));
				//row.add(rs.getString("customer_Reg_Date"));
				row.add(rs.getString("customer_Phone_Num"));
				//row.add(rs.getString("customer_Add_State"));
				//row.add(rs.getString("customer_Add_City"));
				row.add(rs.getString("customer_Add_Street"));
				row.add(rs.getString("customer_Add_Rest"));
				//row.add(rs.getInt("customer_Frequent"));
				//row.add(rs.getInt("customer_Age_Predict"));
				//row.add(rs.getInt("customer_Receivable"));
				//row.add(rs.getInt("customer_Gender"));

				data.add(row); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public Vector searchCustomerNum(String customerSearchNum) throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();
		CustomerDto customerDto = new CustomerDto();
		Vector data = new Vector();
		try{
			PreparedStatement ps = c.prepareStatement("select * from customer where customer_num = ?"); // 
			ps.setString(1, customerSearchNum);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Vector row = new Vector();
				row.add(rs.getInt("customer_Num"));
				//row.add(rs.getString("customer_Reg_Date"));
				row.add(rs.getString("customer_Phone_Num"));
				//row.add(rs.getString("customer_Add_State"));
				//row.add(rs.getString("customer_Add_City"));
				row.add(rs.getString("customer_Add_Street"));
				row.add(rs.getString("customer_Add_Rest"));
				//row.add(rs.getInt("customer_Frequent"));
				//row.add(rs.getInt("customer_Age_Predict"));
				//row.add(rs.getInt("customer_Receivable"));
				//row.add(rs.getInt("customer_Gender"));

				data.add(row); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public Vector customerAllPart() throws ClassNotFoundException, SQLException { // 

		Connection c = connectionMaker.makeConnection();
		CustomerDto customerDto = new CustomerDto();
		Vector data = new Vector();
		try{
			PreparedStatement ps = c.prepareStatement("select * from customer"); // 
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Vector row = new Vector();
				row.add(rs.getInt("customer_Num"));
				//row.add(rs.getString("customer_Reg_Date"));
				row.add(rs.getString("customer_Phone_Num"));
				//row.add(rs.getString("customer_Add_State"));
				//row.add(rs.getString("customer_Add_City"));
				row.add(rs.getString("customer_Add_Street"));
				row.add(rs.getString("customer_Add_Rest"));
				//row.add(rs.getInt("customer_Frequent"));
				//row.add(rs.getInt("customer_Age_Predict"));
				//row.add(rs.getInt("customer_Receivable"));
				//row.add(rs.getInt("customer_Gender"));

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
			customerDto.setCustomerReceivable(rs.getInt("customer_Receivable"));
			customerDto.setCustomerGender(rs.getInt("customer_Gender"));

		}else{
			JOptionPane.showMessageDialog(null, "고객의 주소가 존재하지 않습니다");
		}
		rs.close();
		ps.close();
		c.close();

		return customerDto;
	}
}
