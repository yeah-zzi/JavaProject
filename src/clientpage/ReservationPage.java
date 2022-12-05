package clientpage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


class ReservationPage extends JFrame {//implements ActionListener, ItemListener {

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
	
	
	
	 ReservationPage() {
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
		
		JLabel img[] = new JLabel[4];
		ImageIcon s = new ImageIcon("images/standard.jpg");
		Image i1 = s.getImage();
		Image si = i1.getScaledInstance(280,160, Image.SCALE_SMOOTH);
		ImageIcon sI = new ImageIcon(si);
		img[0].setIcon(sI);
		//JLabel standardImg = new JLabel(sI);
			
		ImageIcon d = new ImageIcon("images/deluxe.jpg");
		Image i2 = d.getImage();
		Image di = i2.getScaledInstance(280,160, Image.SCALE_SMOOTH);
		ImageIcon dI = new ImageIcon(di);
		img[1].setIcon(dI);
		//JLabel deluxeImg = new JLabel(dI);
		
		ImageIcon sw = new ImageIcon("images/suite.jpg");
		Image i3 = sw.getImage();
		Image sui = i3.getScaledInstance(280,160, Image.SCALE_SMOOTH);
		ImageIcon suI = new ImageIcon(sui);
		img[2].setIcon(suI);
		//JLabel suiteImg = new JLabel(suI);
		
		ImageIcon f = new ImageIcon("images/family.jpg");
		Image i4 = f.getImage();
		Image fi = i4.getScaledInstance(280,160, Image.SCALE_SMOOTH);
		ImageIcon fI = new ImageIcon(fi);
		img[3].setIcon(fI);
		//JLabel familyImg = new JLabel(fI);
		
		
		
		JLabel rmName[] = new JLabel[4];  // 룸이름 레이블 
		JLabel rmFee[] = new JLabel[4];  // 룸가격 레이블 
		JLabel line[] = new JLabel[4];  // 구분선 레이블 
		JLabel basicP[] = new JLabel[4]; // 이용인원 
		JLabel maxP[] = new JLabel[4];   // 최대인원 
		String bp = "이용인원 "; String mp = "/최대 "; 
		JButton rBtn[] = new JButton[4];
		//JLabel subroom[] = new JLable
		//잔여객실 수는 DB 연동시 불러오
		
		
		
		for(int i=0; i<=roomname.length; i++) { // 룸 별로 가격이 1:1이기 때문에 같은 배열 길이 사용.
			rmName[i].setText(roomname[i]);
			rmFee[i].setText(Integer.toString(roomfee[i])); //int형으로 저장된 가격을 문자열로 변환하여 레이블로 저장.
			line[i].setText("--------------------------------");
			basicP[i].setText(bp+Integer.toString(basic[i])+"명");  // "이용인원 n명" 으로 저장 
			maxP[i].setText(mp+Integer.toString(max[i])+"명");      // "/최대 n명" 으로 저장 
			rBtn[i].setText("예약하기");
		}
		
		
		
		JPanel rm[] = new JPanel[4];
		for(int i=0; i<=rm.length; i++) {
			rm[i].setSize(500, 200);
			
			rm[i].add(img[i]);
			rm[i].add(rmName[i]);
			rm[i].add(rmFee[i]);
			rm[i].add(basicP[i]);
			rm[i].add(maxP[i]);
			rm[i].add(rBtn[i]);
			rm[i].add(line[i]);
			
			int j=0;
			img[i].setBounds(170, 200+j, 240, 140);
			rmName[i].setBounds(470, 230+j,100, 35);
			rmFee[i].setBounds(470, 280+j, 100, 30);
			basicP[i].setBounds(470, 300+j, 50, 20);
			maxP[i].setBounds(500, 300+j, 50, 20);
			rBtn[i].setBounds(600, 230+j, 125, 125);
			line[i].setBounds(170, 330+j, 5, 480);
			
			j+=140;
			
			roomType.add(rm[i]);
		}
		
		roomPane.add(checkdate, BorderLayout.NORTH);
		roomPane.add(roomType, BorderLayout.CENTER);
		
		mainPane.add(roomPane);
		//roomPane.setBounds(0, y, width, height);
		
		add(mainPane);
		
		
		
	}
	public static void main(String[] args) {
		ReservationPage win = new ReservationPage();
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(1100, 900);
		win.setLocation(350, 80);
		win.show();
		
	}
	
}
