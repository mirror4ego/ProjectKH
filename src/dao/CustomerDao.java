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

		PreparedStatement ps = c.prepareStatement("insert into customer values (seq_customer_num.nextval,?,?,?,?,?,?,?,?)");

		ps.setString(1, customerDto.getCustomerRegDate());
		ps.setString(2, customerDto.getCustomerPhoneNum());
		ps.setString(3, customerDto.getCustomerAddState());
		ps.setString(4, customerDto.getCustomerAddCity());
		ps.setString(5, customerDto.getCustomerAddStreet());
		ps.setString(6, customerDto.getCustomerAddRest());
		ps.setInt(7, customerDto.getCustomerFrequent());
		ps.setInt(8, customerDto.getCustomerAgePredict());

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
