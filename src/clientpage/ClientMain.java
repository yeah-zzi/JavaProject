package clientpage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;

class MainPage extends JPanel implements ItemListener {
	
	JPanel roomPane = new JPanel(); // 룸 타입별 예약 구역 (왼쪽)
	
	JPanel checkInoutP = new JPanel(); 
	
	// 체크인, 체크아웃 레이블 패널 
	JPanel selectCheckP = new JPanel();           // 날짜 지정 콤보박스 패널 
		JLabel ckInL = new JLabel("    체크인");
		JLabel ckOutL = new JLabel("    체크아웃");//4
		LineBorder bl = new LineBorder(Color.DARK_GRAY, 2, true);
	
		JComboBox<Integer> inYearCombo = new JComboBox<Integer>();  //체크인 년 콤보박스
		JComboBox<Integer> inMonthCombo = new JComboBox<Integer>();  //체크인 월 콤보박스
		JComboBox<Integer> inDayCombo = new JComboBox<Integer>(); //체크인 일 콤보박스 
		JLabel inYearL = new JLabel("        년");
		JLabel inMonthL = new JLabel("        월");
		JLabel inDayL = new JLabel("        일");
		
		JComboBox<Integer> outYearCombo = new JComboBox<Integer>();  //체크아웃 년 콤보박스
		JComboBox<Integer> outMonthCombo = new JComboBox<Integer>();  //체크아웃 월 콤보박스
		JComboBox<Integer> outDayCombo = new JComboBox<Integer>(); //체크아웃 일 콤보박스
		JLabel outYearL = new JLabel("        년");
		JLabel outMonthL = new JLabel("        월");
		JLabel outDayL = new JLabel("        일");//8

	Calendar date; //Calendar 클래스 객체 선언
	int year;  //현재 년도와 월을 저장할 변수 선언 
	int month;
	int day;
		
	
	JPanel roomTypeP = new JPanel();
	JPanel rm[];
	
		ImageIcon rmimg[];
		JLabel img[];
		String roomname[] = {"Standard", "Deluxe", "sweet", "family"};  // 룸타입 이름 
		String srcimg[] = {"images/standard.jpg", "images/deluxe.jpg", "images/suite.jpg", "images/family.jpg"};
		
		int roomfee[] = {129000, 159000, 259000, 209000};  // 룸 타입별 가격 
		int basic[] = {2, 2, 3, 4}; // 기본 이용인원 수 
		int max[] = {4, 4, 6, 8};   // 최대 이용인원 수 
		
		JLabel rmName[];  // 룸이름 레이블 
		JLabel rmFee[];  // 룸가격 레이블 
		JLabel line[];  // 구분선 레이블 
		JLabel basicP[]; // 이용인원 
		JLabel maxP[];   // 최대인원 
		String bp = "이용인원 "; String mp = "/최대 "; 
		JButton rBtn[]; // 예약버튼 
	
	public MainPage() {
		
		checkInoutP.setBorder(bl); selectCheckP.setBorder(new TitledBorder(bl," [예약 날짜] "));
		
		date = Calendar.getInstance(); //현재 캘린더정보 변수에 받아와 저장.
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH);
		day = date.get(Calendar.DATE);
		
		//selectCheckP.setBorder(bl); selectCheckP.setBorder(new TitledBorder(bl," [예약 날짜] "));
		selectCheckP.setLayout(new GridLayout(2,7,-25,0));
		
		selectCheckP.add(ckInL);
		selectCheckP.add(inYearCombo);	selectCheckP.add(inYearL);
		selectCheckP.add(inMonthCombo); selectCheckP.add(inMonthL);
		selectCheckP.add(inDayCombo);  selectCheckP.add(inDayL);
		
		selectCheckP.add(ckOutL);
		selectCheckP.add(outYearCombo);  selectCheckP.add(outYearL);
		selectCheckP.add(outMonthCombo); selectCheckP.add(outMonthL);
		selectCheckP.add(outDayCombo);  selectCheckP.add(outDayL);
		
		//checkInoutP.setLayout(null);
		checkInoutP.add(selectCheckP);
		//checkInoutP.setBounds(40,70,470,95);
		roomPane.add(checkInoutP);
		
		setYear(); setMonth(); setDay();
		
		inYearCombo.addItemListener(this); inMonthCombo.addItemListener(this); inDayCombo.addItemListener(this);
		outYearCombo.addItemListener(this); outMonthCombo.addItemListener(this); outDayCombo.addItemListener(this);
		
		rm = new JPanel[4];
		rmimg = new ImageIcon[4];
		img = new JLabel[4];
		rmName = new JLabel[4];
		rmFee = new JLabel[4];
		line = new JLabel[4];
		basicP = new JLabel[4];
		maxP = new JLabel[4];
		rBtn = new JButton[4];
		
		//룸 타입별 이미지 생성 
		for(int i=0; i<srcimg.length; i++) {
			img[i] = new JLabel();
			rmimg[i] = new ImageIcon(srcimg[i]);
			img[i].setIcon(changeImgSize(rmimg[i])); //이미지 사이즈 변경 메소드사용 (리턴값 이미지아이콘)
		}
		//룸 정보 배열저장 
		for(int i=0; i<roomname.length; i++) {
			rmName[i] = new JLabel(roomname[i]);
			rmFee[i] = new JLabel(Integer.toString(roomfee[i])); //int형으로 저장된 가격을 문자열로 변환하여 레이블로 저장.
			line[i] = new JLabel("--------------------------------");
			basicP[i] = new JLabel(bp+Integer.toString(basic[i])+"명");  // "이용인원 n명" 으로 저장 
			maxP[i] = new JLabel(mp+Integer.toString(max[i])+"명");      // "/최대 n명" 으로 저장 
			rBtn[i] = new JButton("예약하기");	
		}
		
		for(int i=0; i<rm.length; i++) {
			rm[i] = new JPanel();
			rm[i].setLayout(null);
			
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
			
			roomPane.add(rm[i]);
		}
		add(roomPane);
		
	}// 생성자
	
	public ImageIcon changeImgSize (ImageIcon i) { //이미지 사이즈 조절 메소드 
		Image img = i.getImage();
		Image changeimg = img.getScaledInstance(280, 160, Image.SCALE_SMOOTH);
		ImageIcon ii = new ImageIcon(changeimg);
		
		return ii;
	}
		
	public void setYear() {   // 콤보박스 년도 삽입 
		for(int i = year; i<=year+1; i++) {
			inYearCombo.addItem(i);
			outYearCombo.addItem(i);
		}
		inYearCombo.setSelectedItem(year);
		outYearCombo.setSelectedItem(year);
	}
	public void setMonth() {  // 콤보박스 월 삽입
		for(int i=1; i<=12; i++) {
			inMonthCombo.addItem(i);
			outMonthCombo.addItem(i);
		}
		inMonthCombo.setSelectedItem(month);
		outMonthCombo.setSelectedItem(month);
	}
	public void setDay() {   // 콤보박스 일 삽입 
		int lastDay = date.getActualMaximum(Calendar.DATE);
		for(int i=1; i<=lastDay; i++) {
			inDayCombo.addItem(i);
			outDayCombo.addItem(i);
		}
		inDayCombo.setSelectedItem(date);
		outDayCombo.setSelectedItem(date);
	}

	@Override // 아이템 이벤트 값 다시 설정.
	public void itemStateChanged(ItemEvent e) {
		year = (int)inYearCombo.getSelectedItem(); //형변환한것을볼수 있으며 yearCombo바뀌었을때 yearCombo의 값을 getSelected 가져와서 찾는것을 볼수 있다.
		month = (int)inMonthCombo.getSelectedItem();
		
	}
	
}



public class ClientMain extends JFrame {

	public ClientMain() {
		JTabbedPane main = new JTabbedPane();
		MainPage m = new MainPage();
		
		main.addTab("Main Page", m.roomPane);
		main.addTab("My Page", new JButton("ex"));
		
		Container ct = getContentPane();
		ct.add(main);
	}
	public static void main(String[] args) {
		ClientMain win = new ClientMain();
		win.setTitle("Client Page");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(1100, 800);
		win.setVisible(true);

	}

}
