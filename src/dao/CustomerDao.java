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

		try{
			PreparedStatement ps = c.prepareStatement("insert into customer values (seq_customer_num.nextval,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, customerDto.getCustomerRegDate());
			ps.setString(2, customerDto.getCustomerPhoneNum());
			ps.setString(3, customerDto.getCustomerAddState());
			ps.setString(4, customerDto.getCustomerAddCity());
			ps.setString(5, customerDto.getCustomerAddStreet());
			ps.setString(6, customerDto.getCustomerAddRest());
			ps.setInt(7, customerDto.getCustomerAgePredict());
			ps.setInt(8, customerDto.getCustomerGender());
			ps.setString(9, customerDto.getCustomerNoteInfo());
			ps.setString(10, customerDto.getCustomerGradeName());

			ps.executeUpdate();
			ps.close();
			c.close();
			JOptionPane.showMessageDialog(null, "고객정보 등록 성공");
		}catch(Exception e) {
			c.close();
			JOptionPane.showMessageDialog(null, "고객정보 등록 실패 (쿼리)");
		}
	}

	public void deleteOneCustomer(int customerNum) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		
		try{
			PreparedStatement ps = c.prepareStatement("delete from customer where customer_num = ?");

			ps.setInt(1, customerNum);

			ps.executeUpdate();

			ps.close();
			c.close();
			JOptionPane.showMessageDialog(null, "고객정보 삭제 성공!");
		}catch(Exception e){
			c.close();
			JOptionPane.showMessageDialog(null, "고객정보 삭제 실패!");
		}
	}
	
	public void updateCustomer(CustomerDto customerDto) throws ClassNotFoundException, SQLException { 

		Connection c = connectionMaker.makeConnection();

		try{
			PreparedStatement ps = c.prepareStatement("update customer set customer_reg_date = ?, customer_phone_num = ?, customer_add_state = ?,"
					+ "customer_add_city = ?, customer_add_street = ?, customer_add_rest = ?, customer_frequent = ?,"
					+ "customer_gender = ?, customer_grade_name = ?"
					+ "where customer_num = ?");

			ps.setString(1, customerDto.getCustomerRegDate());
			ps.setString(2, customerDto.getCustomerPhoneNum());
			ps.setString(3, customerDto.getCustomerAddState());
			ps.setString(4, customerDto.getCustomerAddCity());
			ps.setString(5, customerDto.getCustomerAddStreet());
			ps.setString(6, customerDto.getCustomerAddRest());
			ps.setInt(7, customerDto.getCustomerAgePredict());
			ps.setInt(8, customerDto.getCustomerGender());
			ps.setString(9, customerDto.getCustomerNoteInfo());
			ps.setString(10, customerDto.getCustomerGradeName());
			ps.setInt(11, customerDto.getCustomerNum());
			ps.executeUpdate();

			ps.close();
			c.close();
			JOptionPane.showMessageDialog(null, "고객정보 변경 성공!");
		}catch(Exception e){
			c.close();
			JOptionPane.showMessageDialog(null, "고객정보 변경 실패!");
		}
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
		customerDto.setCustomerAgePredict(rs.getInt("customer_Age_Predict"));
		customerDto.setCustomerGender(rs.getInt("customer_Gender"));
		customerDto.setCustomerNoteInfo(rs.getString("customer_NoteInfo"));
		customerDto.setCustomerGradeName(rs.getString("customer_Grade_Name"));
		
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
		customerDto.setCustomerAgePredict(rs.getInt("customerAgePredict"));
		customerDto.setCustomerGender(rs.getInt("customer_Gender"));
		customerDto.setCustomerNoteInfo(rs.getString("customer_NoteInfo"));
		customerDto.setCustomerGradeName(rs.getString("customer_Grade_Name"));

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

	public int sumCustomerLoc(String str) throws ClassNotFoundException, SQLException {

		Connection c = connectionMaker.makeConnection();
		
		//int sum = 0;
		int cnt=0;
		try {
			  
			PreparedStatement ps = c.prepareStatement(
					"select customer_add_street from customer where customer_add_street=?"
					,ResultSet.TYPE_SCROLL_INSENSITIVE, 
		             ResultSet.CONCUR_UPDATABLE);
			//last 쓰기위한 추가구문
			ps.setString(1,str);
			
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
			PreparedStatement ps = c.prepareStatement("select * from customer where customer_num = ?");
			ps.setInt(1,customerNum);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				customerDto.setCustomerNum(rs.getInt("customer_Num"));
				customerDto.setCustomerRegDate(rs.getString("customer_Reg_Date"));
				customerDto.setCustomerPhoneNum(rs.getString("customer_Phone_Num"));
				customerDto.setCustomerAddState(rs.getString("customer_Add_State"));
				customerDto.setCustomerAddCity(rs.getString("customer_Add_City"));
				customerDto.setCustomerAddStreet(rs.getString("customer_Add_Street"));
				customerDto.setCustomerAddRest(rs.getString("customer_Add_Rest"));
				customerDto.setCustomerAgePredict(rs.getInt("customer_Age_Predict"));
				customerDto.setCustomerGender(rs.getInt("customer_Gender"));
				customerDto.setCustomerNoteInfo(rs.getString("customer_NoteInfo"));
				customerDto.setCustomerGradeName(rs.getString("customer_Grade_Name"));
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
			PreparedStatement ps = c.prepareStatement("select * from customer where customer_phone_num like ?"); // 
			ps.setString(1, "%"+customerSearchPhoneNum+"%");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Vector row = new Vector();
				row.add(rs.getInt("customer_Num"));
				row.add(rs.getString("customer_Phone_Num"));
				row.add(rs.getString("customer_Add_Street"));
				row.add(rs.getString("customer_Add_Rest"));
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
				row.add(rs.getString("customer_Phone_Num"));
				row.add(rs.getString("customer_Add_Street"));
				row.add(rs.getString("customer_Add_Rest"));

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
			PreparedStatement ps = c.prepareStatement("select * from customer order by customer_num"); // 
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Vector row = new Vector();
				row.add(rs.getInt("customer_Num"));
				row.add(rs.getString("customer_Phone_Num"));
				row.add(rs.getString("customer_Add_Street"));
				row.add(rs.getString("customer_Add_Rest"));

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
			customerDto.setCustomerAgePredict(rs.getInt("customer_Age_Predict"));
			customerDto.setCustomerGender(rs.getInt("customer_Gender"));
			customerDto.setCustomerNoteInfo(rs.getString("customer_NoteInfo"));
			customerDto.setCustomerGradeName(rs.getString("customer_Grade_Name"));

		}else{
			JOptionPane.showMessageDialog(null, "고객의 주소가 존재하지 않습니다");
		}
		rs.close();
		ps.close();
		c.close();

		return customerDto;
	}
}
