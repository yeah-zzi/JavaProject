package clientpage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

class ReservationPage extends JPanel {
	
	JPanel mainPane = new JPanel(); //JTabbedPane에 올릴 메인 페널
	
	JPanel roomPane = new JPanel();    // 룸 타입별 예약 구역 패널 
	JPanel detailPane = new JPanel();  // 룸 상세보기 구역 패널 
	JPanel facilityPane = new JPanel();  // 이용시설 구역 패널 
	
	Calendar calendar = Calendar.getInstance();
	int date = calendar.get(Calendar.DAY_OF_MONTH);
	int month = calendar.get(Calendar.MONTH)+1;
	int year = calendar.get(Calendar.YEAR);
	
	ArrayList<String> checkinDate = new ArrayList<String>();
	ArrayList<String> checkoutDate = new ArrayList<String>();
	
	JComboBox<String> selectCheckIn, selectCheckout;
	
	String roomname[] = {"Standard", "Deluxe", "sweet", "family"};  // 룸타입 이름 
	int roomfee[] = {129000, 159000, 259000, 209000};  // 룸 타입별 가격 
	int basic[] = {2, 2, 3, 4}; // 기본 이용인원 수 
	int max[] = {4, 4, 6, 8};   // 최대 이용인원 수 
	
	public ReservationPage() {
		mainPane.setLayout(null);  // null값으로 컴포넌트 좌표값 지정하여 레이아웃 배치 (AbsoluteXYLayout)
		
		JPanel checkdate = new JPanel(new GridLayout(2,2,0,10));
		
		JLabel checkIn = new JLabel("Check-IN");
		JLabel checkOut = new JLabel("Check-OUT");
		
		//체크인,체크아웃 날짜지정 콤보박스 생성. (미완성)
		//for(int i=month; i<=month+3; i++) {
			//for(int j=1; j<=31; j++) {
				//selectCheckIn = new JComboBox()
			//}
		//}
		
		checkdate.add(checkIn); checkdate.add(checkOut);
		roomPane.add(checkdate);
		
		JPanel roomType = new JPanel(new GridLayout(4,0,0,10));
		
		ImageIcon s = new ImageIcon("images/standard.png");
		Image i1 = s.getImage();
		Image si = i1.getScaledInstance(280,160, Image.SCALE_SMOOTH);
		ImageIcon standardImg = new ImageIcon(si);
			
		ImageIcon d = new ImageIcon("images/deluxe.png");
		Image i2 = d.getImage();
		Image di = i2.getScaledInstance(280,160, Image.SCALE_SMOOTH);
		ImageIcon deluxeImg = new ImageIcon(di);
		
		ImageIcon sw = new ImageIcon("images/suite.png");
		Image i3 = sw.getImage();
		Image swi = i3.getScaledInstance(280,160, Image.SCALE_SMOOTH);
		ImageIcon suiteImg = new ImageIcon(swi);
		
		ImageIcon f = new ImageIcon("images/standard.png");
		Image i4 = f.getImage();
		Image fi = i4.getScaledInstance(280,160, Image.SCALE_SMOOTH);
		ImageIcon familyImg = new ImageIcon(fi);
		
		JLabel rmName[] = new JLabel[4];  // 룸이름 레이블 
		JLabel rmFee[] = new JLabel[4];  // 룸가격 레이블 
		JLabel line[] = new JLabel[4];  // 구분선 레이블 
		JLabel basicP[] = new JLabel[4]; // 이용인원 
		JLabel maxP[] = new JLabel[4];   // 최대인원 
		String bp = "이용인원 "; String mp = "/최대 "; 
		JButton rBtn[] = new JButton[4];
		JLabel subroom[] = new JLabel[4];
		String sub = "잔여 객실 ";
		//잔여객실 수는 DB 연동시 불러오
		
		
		
		for(int i=0; i<=roomname.length; i++) { // 룸 별로 가격이 1:1이기 때문에 같은 배열 길이 사용.
			rmName[i].setText(roomname[i]);
			rmFee[i].setText(Integer.toString(roomfee[i])); //int형으로 저장된 가격을 문자열로 변환하여 레이블로 저장.
			line[i].setText("--------------------------------");
			basicP[i].setText(bp+Integer.toString(basic[i])+"명");  // "이용인원 n명" 으로 저장 
			maxP[i].setText(mp+Integer.toString(max[i])+"명");      // "/최대 n명" 으로 저장 
			rBtn[i].setText("예약하기");
		}
		
		
	}
	
}

public class Clientmain extends JFrame  {

	public Clientmain() {
		JTabbedPane main = new JTabbedPane();
		ReservationPage rPage = new ReservationPage();
		// 고객화면에 들어갈 예약, 마이페이지 패널 클래스 넣기.
		
		main.addTab("Reservation", rPage);
		main.addTab("My Page", new Button("ex"));
		
		Container ct = getContentPane();
		ct.add(main);
	}
	public static void main(String[] args) {
		Clientmain win = new Clientmain();
		win.setTitle("고객 페이지");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(1100,900);
		win.setVisible(true);
		

	}

}
