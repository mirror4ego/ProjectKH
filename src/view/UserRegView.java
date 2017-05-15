package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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

import dao.UserInfoDao;
import domain.UserInfoDto;

public class UserRegView extends JFrame implements ActionListener {


	JPanel jPanel1;
	JTextField jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7; //전화
	JTextField jTextArea8, jTextArea9, jTextArea10; //생년월일
	JTextArea jTextArea1;
	JComboBox jComboBox1; //직업
	JPasswordField jPasswordField1; //비밀번호   
	JRadioButton jRadioButton1, jRadioButton2; //남, 여
	JButton jButton1, jButton2, jButton3, jButton4; //가입, 취소, 수정 , 탈퇴 버튼

	GridBagLayout gridBagLayout1;
	GridBagConstraints gridBagConstraints1;
	UserListView userListView;

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

	public UserRegView(String id, UserListView userListView) throws ClassNotFoundException, SQLException{ //수정/삭제용 생성자
		createUI();
		jButton1.setEnabled(false);
		jButton1.setVisible(false);
		this.userListView = userListView;

		System.out.println("id="+id);

		UserInfoDao dao = new UserInfoDao();
		UserInfoDto vMem = dao.getOneUser(id);
		viewData(vMem);
	} //id를 가지고 생성

	//UserInfoDto 의 회원 정보를 가지고 화면에 셋팅해주는 메소드
	private void viewData(UserInfoDto vMem){

		String id = vMem.getUserInfoId();
		String pwd = vMem.getUserInfoPassword();
		String name = vMem.getUserInfoName();
		int tel = vMem.getUserInfoPhone();
		String addr = vMem.getUserInfoAddress();
		//String birth = vMem.getBirth();
		//String job = vMem.getJob();
		//String gender = vMem.getGender();
		String email= vMem.getUserInfoEmail();
		//String intro = vMem.getIntro();    

		//화면에 세팅
		jTextField4.setText(id);
		jTextField4.setEditable(false); //편집 안되게
		jPasswordField1.setText(""); //비밀번호는 안보여준다.
		jTextField5.setText(name);
		//String[] tels = tel.split("-");
		//jTextField1.setText(tels[0]);
		//jTextField2.setText(tels[1]);
		//jTextField3.setText(tels[2]);
		jTextField6.setText(addr);

		//jTextArea8.setText(birth.substring(0, 4));
		//jTextArea9.setText(birth.substring(4, 6));
		//jTextArea10.setText(birth.substring(6, 8));

		//jComboBox1.setSelectedItem(job);

		/*if(gender.equals("M")){
			jRadioButton2.setSelected(true);
		}else if(gender.equals("W")){
			jRadioButton1.setSelected(true);
		}
*/
		jTextField7.setText(email);
		//jTextArea1.setText(intro);
	}//viewData

	private void createUI(){
		this.setTitle("회원정보");
		gridBagLayout1 = new GridBagLayout();
		setLayout(gridBagLayout1);
		gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.weighty = 1.0;

		//아이디
		JLabel bId = new JLabel("아이디 : ");
		jTextField4 = new JTextField(20);     
		//그리드백에 붙이기
		gbAdd(bId, 0, 0, 1, 1);
		gbAdd(jTextField4, 1, 0, 3, 1);

		//비밀번호
		JLabel bPwd = new JLabel("비밀번호 : ");
		jPasswordField1 = new JPasswordField(20);
		gbAdd(bPwd, 0, 1, 1, 1);
		gbAdd(jPasswordField1, 1, 1, 3, 1);

		//이름
		JLabel bName = new JLabel("이름 :");
		jTextField5 = new JTextField(20);
		gbAdd(bName,0,2,1,1);
		gbAdd(jTextField5,1,2,3,1);

		//전화
		JLabel bTel = new JLabel("전화 :");
		JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jTextField1 = new JTextField(6);    
		jTextField2 = new JTextField(6);    
		jTextField3 = new JTextField(6);
		pTel.add(jTextField1);
		pTel.add(new JLabel(" - "));
		pTel.add(jTextField2);
		pTel.add(new JLabel(" - "));
		pTel.add(jTextField3);
		gbAdd(bTel, 0, 3, 1,1);
		gbAdd(pTel, 1, 3, 3,1);

		//주소
		JLabel bAddr = new JLabel("주소: ");
		jTextField6 = new JTextField(20);
		gbAdd(bAddr, 0,4,1,1);
		gbAdd(jTextField6, 1, 4, 3,1);

		//생일
		JLabel bBirth= new JLabel("생일: ");
		jTextArea8 = new JTextField(6);
		jTextArea9 = new JTextField(6);
		jTextArea10 = new JTextField(6);
		JPanel pBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pBirth.add(jTextArea8);
		pBirth.add(new JLabel("/"));
		pBirth.add(jTextArea9);
		pBirth.add(new JLabel("/"));
		pBirth.add(jTextArea10);
		gbAdd(bBirth, 0,5,1,1);
		gbAdd(pBirth, 1, 5, 3,1);

		//직업       
		JLabel bJob = new JLabel("직업 : ");
		String[] arrJob = {"---", "학생", "직장인", "주부"};
		jComboBox1 = new JComboBox(arrJob);
		JPanel pJob = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pJob.add(jComboBox1);       
		gbAdd(bJob, 0,6,1,1);
		gbAdd(pJob,1,6,3,1);

		//성별
		JLabel bGender = new JLabel("성별 : ");
		JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jRadioButton2 = new JRadioButton("남",true);
		jRadioButton1 = new JRadioButton("여",true);
		ButtonGroup group = new ButtonGroup();
		group.add(jRadioButton2);
		group.add(jRadioButton1);
		pGender.add(jRadioButton2);
		pGender.add(jRadioButton1);      
		gbAdd(bGender, 0,7,1,1);
		gbAdd(pGender,1,7,3,1);

		//이메일
		JLabel bEmail = new JLabel("이메일 : ");
		jTextField7 = new JTextField(20);
		gbAdd(bEmail, 0,8,1,1);
		gbAdd(jTextField7,1,8,3,1);

		//자기소개
		JLabel bIntro = new JLabel("자기 소개: ");
		jTextArea1 = new JTextArea(5, 20); //행 : 열
		JScrollPane pane = new JScrollPane(jTextArea1);
		gbAdd(bIntro,0,9,1,1);
		gbAdd(pane,1,9,3,1);

		//버튼
		JPanel pButton = new JPanel();
		jButton1 = new JButton("가입");
		jButton3 = new JButton("수정"); 
		jButton4 = new JButton("탈퇴");
		jButton2 = new JButton("취소");     
		pButton.add(jButton1);
		pButton.add(jButton3);
		pButton.add(jButton4);
		pButton.add(jButton2);    
		gbAdd(pButton, 0, 10, 4, 1);

		//버튼에 감지기를 붙이자
		jButton1.addActionListener(this);
		jButton3.addActionListener(this);
		jButton2.addActionListener(this);
		jButton4.addActionListener(this);

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
		if(ae.getSource() == jButton1){
			insertMember();
			System.out.println("insertMember() 호출 종료");
		}else if(ae.getSource() == jButton2){
			this.dispose(); //창닫기 (현재창만 닫힘)
			//system.exit(0)=> 내가 띄운 모든 창이 다 닫힘          
		}else if(ae.getSource() == jButton3){
			UpdateMember();            
		}else if(ae.getSource() == jButton4){
			//int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?");
			int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);

			if (x == JOptionPane.OK_OPTION){
				deleteMember();
			}else{
				JOptionPane.showMessageDialog(this, "삭제를 취소하였습니다.");
			}
		}

		//jTable내용 갱신 메소드 호출
/*		try {
			userListView.jTableRefresh();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}//actionPerformed 


	private void deleteMember() {
		String id = jTextField4.getText();
		String pwd = jPasswordField1.getText();
		if(pwd.length()==0){ //길이가 0이면

			JOptionPane.showMessageDialog(this, "비밀번호를 꼭 입력하세요!");
			return; //메소드 끝
		}
		//System.out.println(userListView);
		UserInfoDao dao = new UserInfoDao();
		boolean ok = dao.deleteMember(id, pwd);

		if(ok){
			JOptionPane.showMessageDialog(this, "삭제완료");
			dispose();         

		}else{
			JOptionPane.showMessageDialog(this, "삭제실패");

		}          

	}//deleteMember

	private void UpdateMember() {

		//1. 화면의 정보를 얻는다.
		UserInfoDto dto = getViewData();     
		//2. 그정보로 DB를 수정
		UserInfoDao dao = new UserInfoDao();
		boolean ok = dao.updateMember(dto);

		if(ok){
			JOptionPane.showMessageDialog(this, "수정되었습니다.");
			this.dispose();
		}else{
			JOptionPane.showMessageDialog(this, "수정실패: 값을 확인하세요");   
		}
	}

	private void insertMember(){

		//화면에서 사용자가 입력한 내용을 얻는다.
		UserInfoDto dto = getViewData();
		UserInfoDao dao = new UserInfoDao();       
		boolean ok = dao.insertMember(dto);

		if(ok){

			JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");
			dispose();

		}else{

			JOptionPane.showMessageDialog(this, "가입이 정상적으로 처리되지 않았습니다.");
		}



	}//insertMember

	public UserInfoDto getViewData(){

		//화면에서 사용자가 입력한 내용을 얻는다.
		UserInfoDto dto = new UserInfoDto();
		String id = jTextField4.getText();
		String pwd = jPasswordField1.getText();
		String name = jTextField5.getText();
		String tel1 = jTextField1.getText();
		String tel2 = jTextField2.getText();
		String tel3 = jTextField3.getText();
		String tel = tel1+"-"+tel2+"-"+tel3;
		String addr = jTextField6.getText();
		String birth1 = jTextArea8.getText();
		String birth2 = jTextArea9.getText();
		String birth3 = jTextArea10.getText();
		//String birth = birth1+"/"+birth2+"/"+birth3;
		String birth = birth1+birth2+birth3;
		String job = (String)jComboBox1.getSelectedItem();
		String gender = "";
		if(jRadioButton2.isSelected()){
			gender = "M";
		}else if(jRadioButton1.isSelected()){
			gender = "W";
		}

		String email = jTextField7.getText();
		String intro = jTextArea1.getText();

		//dto에 담는다.
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddr(addr);
		dto.setBirth(birth);
		dto.setJob(job);
		dto.setGender(gender);
		dto.setEmail(email);
		dto.setIntro(intro);

		return dto;
	}
}