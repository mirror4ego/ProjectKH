package hj;
import java.awt.Rectangle;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class JdbcJtableTest01 extends JPanel{
	//DB에서 스윙 화면으로 테이블 값 가져오기(select),저장하기(insert),삭제하기(delete)
	private static final serialVersionUID=1L;
	private JButton jBtnAddRow=null; //테이블 한줄 추가 버튼
	private JButton jBtnSaveRow=null; //테이블 한줄 저장 버튼
	private JButton jBtnEditRow=null; //테이블 한줄 수정 버튼
	private JButton jBtnDelRow=null; 
	private JTable table;
	private JScrollPane scrollPane;//테이블 스크롤바 자동으로 생성되게 하기
	
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@111.222.111.222:1111:XE";//@호스트IP:포트:SID
	private String colNames[]={"아이디","이름","성별","섯다점수","최근 접속날짜"};//테이블 컬럼 값들
	private DefaultTableModel model=new DefaultTableModel(colNames,0);//테이블 데이터 모델 객체 생성
	
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;//리턴 받아 사용할 객체 생성(select에서 보여줄 때 필요)
	
	public JdbcJtableTest01(){
		setLayout(null);//레이아웃 배치관리자 삭제
		table.addMouseListener(new JTableMouseListener());//테이블에 마우스이스너 연결
		scrollPane=new JScrollPane(table);//테이블에 스크롤 생기게 하기
		scrollPane.setSize(500,200);
		add(scrollPane);
		initialize();
		select();
	}
	
	private class JTavleMouseListener implements MouseListener{//마우스로 눌려진값 확인하기
		
		
		//http://m.blog.naver.com/battledocho/220014094399
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

public class Exam01 {

}
