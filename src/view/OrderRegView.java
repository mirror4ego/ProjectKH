package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import dao.OrderInfoDao;
import domain.OrderInfoDto;

public class OrderRegView extends JFrame implements ActionListener {


	JPanel jPanel1;
	//라벨 객체 생성
	private JLabel jLabel12 = new JLabel("주문번호 : ", JLabel.LEFT);
	private JLabel jLabel13 = new JLabel("주문고객번호 : ", JLabel.LEFT);
	private JLabel jLabel14 = new JLabel("주문일자 : ", JLabel.LEFT);
	private JLabel jLabel15 = new JLabel("주문가능여부(지역) : ", JLabel.LEFT);
	private JLabel jLabel16 = new JLabel("주문가능여부(주문량) : ", JLabel.LEFT);
	private JLabel jLabel17 = new JLabel("메뉴고유값 : ", JLabel.LEFT);
	private JLabel jLabel18 = new JLabel("주문메뉴양 : ", JLabel.LEFT);
	private JLabel jLabel19 = new JLabel("주문요청사항 : ", JLabel.LEFT);
	private JLabel jLabel20 = new JLabel("채널고유값 : ", JLabel.LEFT);
	private JLabel jLabel21 = new JLabel("배달요청시간 : ", JLabel.LEFT);
	private JLabel jLabel22 = new JLabel("주문 프로세스(포장) 완료 여부 : ", JLabel.LEFT);
	private JLabel jLabel23 = new JLabel("주문 프로세스(배달) 완료 여부 : ", JLabel.LEFT);
	private JLabel jLabel24 = new JLabel("주문 프로세스 완료 여부 : ", JLabel.LEFT);
	private JLabel jLabel25 = new JLabel("수금 여부 : ", JLabel.LEFT);
	private JLabel jLabel26 = new JLabel("배달 예측시간 : ", JLabel.LEFT);
	
	JButton jButton1, jButton2, jButton3, jButton4; //가입, 취소, 수정 , 탈퇴 버튼
	
	//텍스트필드 객체 생성
	private JTextField jTextField10 = new JTextField("1", 10);//주문번호 입력창
	//private JTextField jTextField11 = new JTextField("2", 10);//고객번호 입력창
	private JTextField jTextField12 = new JTextField("20170304", 10);//주문일자 입력창
	private JTextField jTextField13 = new JTextField("1", 10);// 주문가능여부(지역)
	private JTextField jTextField14 = new JTextField("2", 10);// 주문가능여부(주문량)
	private JTextField jTextField15 = new JTextField("3", 10);// 메뉴고유값
	private JTextField jTextField16 = new JTextField("4", 10);// 주문메뉴양
	private JTextField jTextField17 = new JTextField("5", 10);// 주문요청사항
	private JTextField jTextField18 = new JTextField("6", 10);// 채널고유값
	private JTextField jTextField19 = new JTextField("20170304", 10);// 배달요청시간
	private JTextField jTextField20 = new JTextField("1", 10); // 주문프로세스1
	private JTextField jTextField21 = new JTextField("2", 10); // 주문프로세스2
	private JTextField jTextField22 = new JTextField("3", 10); // 주문프로세스3
	private JTextField jTextField23 = new JTextField("4", 10); // 수금여부
	private JTextField jTextField24 = new JTextField("20170304", 10); // 배달예측시간
	//패널 객체 생성
	private JPanel jPanel8 = new JPanel(new GridLayout(16, 2)); // 오더정보 메인 패널
	
	GridBagLayout gridBagLayout1;
	GridBagConstraints gridBagConstraints1;
	

/*
	public UserRegView(){ //가입용 생성자
		createUI(); //UI작성해주는 메소드
		jButton3.setEnabled(false);
		jButton3.setVisible(false);
		jButton4.setEnabled(false);
		jButton4.setVisible(false);
	}

	public UserRegView(UserListView userListView){ //가입용 생성자
		createUI(); //UI작성해주는 메소드
		jButton3.setEnabled(false);
		jButton3.setVisible(false);
		jButton4.setEnabled(false);
		jButton4.setVisible(false);
		this.userListView = userListView;  
	}
    */
	//수정/삭제용 생성자
	public OrderRegView(getUserList getUserList1) throws ClassNotFoundException, SQLException{ 
		createUI();
		//jButton1.setEnabled(false);
		//jButton1.setVisible(false);
		this.userListView = userListView;

		System.out.println("orderInfoNum="+orderInfoNum);

		OrderInfoDao dao = new OrderInfoDao();
		OrderInfoDto vMem = dao.getOneOrder(orderInfoNum);
		viewData(vMem);
	} //orderInfoNum를 가지고 생성

	//UserInfoDto 의 회원 정보를 가지고 화면에 셋팅해주는 메소드
	private void viewData(OrderInfoDto vMem){
   
		int orderInfoNum=vMem.getOrderInfoNum();  //주문번호
		String orderInfoDate=vMem.getOrderInfoDate(); //주문일자
		String orderInfoOrderPossiblity=vMem.getOrderInfoOrderPossiblity(); //주문가능여부(주문량)
		int orderInfoMenuNum=vMem.getOrderInfoMenuNum(); //메뉴고유값
		int orderInfoMenuAmount=vMem.getOrderInfoMenuAmount(); //주문 메뉴양
		String orderInfoRequestInfo=vMem.getOrderInfoRequestInfo(); //주문요청사항
		int orderInfoChannelNum=vMem.getOrderInfoChannelNum();//채널고유값
		String orderInfoRequestDelivery=vMem.getOrderInfoRequestDelivery();//배달요청시간
		String orderInfoPackCompletion=vMem.getOrderInfoPackCompletion(); //주문 프로세스(포장)완료여부
		String orderInfoDeliveryCompletion=vMem.getOrderInfoDeliveryCompletion(); //주문 프로세스(배달)완료여부
		String orderInfoOrderCompletion=vMem.getOrderInfoOrderCompletion(); //주문 프로세스완료여부
		String orderInfoMoneyCollection=vMem.getOrderInfoMoneyCollection(); //수금여부
		String orderInfoDeliveryPredict=vMem.getOrderInfoDeliveryPredict();//배달예측시간

		
		
		//화면에 세팅
		jTextField10.setText(String.valueOf(orderInfoNum));
		jTextField10.setEditable(false); //편집 안되게
		jTextField12.setText(orderInfoDate);
		jTextField13.setText(orderInfoLocPossiblity);
		jTextField14.setText(orderInfoOrderPossiblity);
		jTextField15.setText(String.valueOf(orderInfoMenuNum));
		jTextField16.setText(String.valueOf(orderInfoMenuAmount));
		jTextField17.setText(orderInfoRequestInfo);
		jTextField18.setText(String.valueOf(orderInfoChannelNum));
		jTextField19.setText(orderInfoRequestDelivery);
		jTextField20.setText(orderInfoPackCompletion);
		jTextField21.setText(orderInfoDeliveryCompletion);
		jTextField22.setText(orderInfoOrderCompletion);
		jTextField23.setText(orderInfoMoneyCollection);
		jTextField24.setText(orderInfoDeliveryPredict);
		

		/*if(gender.equals("M")){
			jRadioButton2.setSelected(true);
		}else if(gender.equals("W")){
			jRadioButton1.setSelected(true);
		}
*/
		//jTextField7.setText(email);
		//jTextArea1.setText(intro);
	}//viewData

	private void createUI(){   //화면 구성뷰
		this.setTitle("회원정보");
		gridBagLayout1 = new GridBagLayout();
		setLayout(gridBagLayout1);
		gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.weighty = 1.0;

		//주문 관리 패널 구성 시작

				jPanel8.add(jLabel12);
				jPanel8.add(jTextField10);
				jPanel8.add(jLabel13);
				//jPanel8.add(jTextField11);
				jPanel8.add(jLabel14);
				jPanel8.add(jTextField12);
				jPanel8.add(jLabel15);
				jPanel8.add(jTextField13);
				jPanel8.add(jLabel16);
				jPanel8.add(jTextField14);
				jPanel8.add(jLabel17);
				jPanel8.add(jTextField15);
				jPanel8.add(jLabel18);
				jPanel8.add(jTextField16);
				jPanel8.add(jLabel19);
				jPanel8.add(jTextField17);
				jPanel8.add(jLabel20);
				jPanel8.add(jTextField18);
				jPanel8.add(jLabel21);
				jPanel8.add(jTextField19);
				jPanel8.add(jLabel22);
				jPanel8.add(jTextField20);
				jPanel8.add(jLabel23);
				jPanel8.add(jTextField21);
				jPanel8.add(jLabel24);
				jPanel8.add(jTextField22);
				jPanel8.add(jLabel25);
				jPanel8.add(jTextField23);
				jPanel8.add(jLabel26);
				jPanel8.add(jTextField24);
				  jPanel8.add(jButton3);
				  jPanel8.add(jButton2);
				  jPanel8.add(jButton4);

				jPanel8.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "주문정보"));
				//주문 관리 패널 구성 끝

		//버튼에 감지기를 붙이자
		  //jButton1.addActionListener(this);
	      jButton3.addActionListener(this);  //수정버튼
		  jButton2.addActionListener(this);  //삭제버튼
		  jButton4.addActionListener(this);  //취소버튼

		setSize(350,500);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //프로그램종료
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
	}//createUI

	//그리드백레이아웃에 붙이는 메소드
	private void gbAdd(JComponent c, int x, int y, int w, int h){
		gridBagConstraints1.gridx = x;
		gridBagConstraints1.gridy = y;
		gridBagConstraints1.gridwidth = w;
		gridBagConstraints1.gridheight = h;
		gridBagLayout1.setConstraints(c, gridBagConstraints1);
		gridBagConstraints1.insets = new Insets(2, 2, 2, 2);
		add(c, gridBagConstraints1);
	}//gbAdd

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		 if(ae.getSource() == jButton2){  //취소버튼을 누르면
			this.dispose(); //창닫기 (현재창만 닫힘)
			//system.exit(0)=> 내가 띄운 모든 창이 다 닫힘          
		}else if(ae.getSource() == jButton3){//수정버튼을 누르면
			UpdateOrder();            
		}else if(ae.getSource() == jButton4){ //삭제버튼을 누르면
			//int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?");
			int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);

			if (x == JOptionPane.OK_OPTION){
				// 텍스트 필드에 입력된 주문번호를 읽어서 변수에 저장
				int orderInfoNum = jTextField10.getText();
				deleteOrder(orderInfoNum);
			}else{
				JOptionPane.showMessageDialog(this, "삭제를 취소하였습니다.");
			}
		}

		//jTable내용 갱신 메소드 호출
		try {
			MainView mv = new MainView();
			mv.jTableRefresh();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//actionPerformed 


	private void deleteOrder(int orderInfoNum) throws SQLException {
		
		//System.out.println(userListView);
		OrderInfoDao dao = new OrderInfoDao();
		boolean ok;
		ok = dao.deleteOrder(orderInfoNum);

		if(ok){
			JOptionPane.showMessageDialog(this, "삭제완료");
			dispose();         

		}else{
			JOptionPane.showMessageDialog(this, "삭제실패");

		}          

	}//deleteMember

	private void UpdateOrder() {

		//1. 화면의 정보를 얻는다.
		OrderInfoDto dto = getViewData();     
		//2. 그정보로 DB를 수정
		OrderInfoDao dao = new OrderInfoDao();
		boolean ok = dao.updateOrder(dto);

		if(ok){
			JOptionPane.showMessageDialog(this, "수정되었습니다.");
			this.dispose();
		}else{
			JOptionPane.showMessageDialog(this, "수정실패: 값을 확인하세요");   
		}
	}
/*
	private void insertOrder(){

		//화면에서 사용자가 입력한 내용을 얻는다.
		OrderInfoDto dto = getViewData();
		OrderInfoDao dao = new OrderInfoDao();       
		boolean ok = dao.insertOrder(dto);

		if(ok){

			JOptionPane.showMessageDialog(this, "수정이 완료되었습니다.");
			dispose();

		}else{

			JOptionPane.showMessageDialog(this, "수정이 정상적으로 처리되지 않았습니다.");
		}



	}//inserOrder
	*/

	public OrderInfoDto getViewData(){

		//화면에서 사용자가 입력한 내용을 얻는다.
		OrderInfoDto dto = new OrderInfoDto();
		String.valueOf(orderInfoNum)= jTextField10.getText();
		String orderInfoDate = jTextField12.getText();
		String orderInfoLocPossiblity = jTextField13.getText();
		String orderInfoOrderPossiblity = jTextField14.getText();
		int orderInfoMenuNum = jTextField15.getText();
		int orderInfoMenuAmount = jTextField16.getText();
		String orderInfoRequestInfo = jTextField17.getText();
		int orderInfoChannelNum = jTextField18.getText();
		String orderInfoRequestDelivery = jTextField19.getText();
		String orderInfoPackCompletion = jTextField20.getText();
		String orderInfoDeliveryCompletion = jTextField21.getText();
		String orderInfoOrderCompletion = jTextField22.getText();
		String orderInfoMoneyCollection = jTextField23.getText();
		String orderInfoDeliveryPredict = jTextField24.getText();

		//dto에 담는다.
		dto.setOrderInfoNum(orderInfoNum);
		dto.setOrderInfoDate(orderInfoDate);
		dto.setOrderInfoLocPossiblity(orderInfoLocPossiblity);
		dto.setOrderInfoOrderPossiblity(orderInfoOrderPossiblity);
		dto.setOrderInfoMenuNum(orderInfoMenuNum);
		dto.setOrderInfoMenuAmount(orderInfoMenuAmount);
		dto.setOrderInfoRequestInfo(orderInfoRequestInfo);
		dto.setOrderInfoChannelNum(orderInfoChannelNum);
		dto.setOrderInfoRequestDelivery(orderInfoRequestDelivery);
		dto.setOrderInfoPackCompletion(orderInfoPackCompletion);
		dto.setOrderInfoDeliveryCompletion(orderInfoDeliveryCompletion);
		dto.setOrderInfoOrderCompletion(orderInfoOrderCompletion);
		dto.setOrderInfoMoneyCollection(orderInfoMoneyCollection);
		dto.setOrderInfoDeliveryPredict(orderInfoDeliveryPredict);

		return dto;
	}
}