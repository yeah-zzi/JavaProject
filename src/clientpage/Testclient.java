package clientpage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;

public class Testclient extends JFrame implements ItemListener {
	
	Container ct;

	Font ft = new Font("",Font.BOLD,18);
	LineBorder bl = new LineBorder(Color.DARK_GRAY, 2, true);
	
	// 체크인, 체크아웃 레이블 패널 
	JPanel checkInoutP = new JPanel(); 
	
	//콤보박스 날짜 선택 패널 
	JPanel selectCheckP = new JPanel();           // 날짜 지정 콤보박스 패널 
		JLabel ckInL = new JLabel("    체크인");
		JLabel ckOutL = new JLabel("    체크아웃");//4
	
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
	
	//룸 타입 별 정보 띄우는 패널 
	JPanel roomTypeP = new JPanel();
	JPanel rm[];
	JPanel txt[];
	
		ImageIcon rmimg[];
		JButton rimg[];
		String roomname[] = {"Standard", "Deluxe", "sweet", "family"};  // 룸타입 이름 
		String srcimg[] = {"images/standard.jpg", "images/deluxe.jpg", "images/suite.jpg", "images/family.jpg"}; // 룸 사진 따와서 수정.
		
		int roomfee[] = {129000, 159000, 259000, 209000};  // 룸 타입별 가격 
		int basic[] = {2, 2, 3, 4}; // 기본 이용인원 수 
		int max[] = {4, 4, 6, 8};   // 최대 이용인원 수 
		int able[] = {2, 0, 1, 2}; // 잔여객실 수 (DB연동해서 값 가져오기)
		
		JLabel rmName[];  // 룸이름 레이블 
		JLabel rmFee[];  // 룸가격 레이블 
		JLabel line[];  // 구분선 레이블 
		JLabel basicP[]; // 이용인원 
		JLabel maxP[];   // 최대인원 
		String bp = "이용인원 "; String mp = "/최대 "; 
		JButton rBtn[]; // 예약버튼 
		
	// 룸 타입별 상세정보 띄우는 패널
	JPanel detailP = new JPanel();
	
	// 룸 타입별 상세 이미지들 
	JPanel detailImg[];
	
		JLabel deimg = new JLabel();
		ImageIcon dimgI[][];
		String srcDrimg[][] = { {"images/standard.jpg", "images/deluxe.jpg", "images/suite.jpg", "images/family.jpg" },
			{"images/manager.png", "images/deluxe.jpg", "images/suite.jpg", "images/family.jpg"},
			{"images/client.png", "images/deluxe.jpg", "images/suite.jpg", "images/family.jpg"},
			{"images/selectedManager.jpeg", "images/deluxe.jpg", "images/suite.jpg", "images/family.jpg"} };// 룸 상세사진 따와서 수정.
		
		JLabel preL = new JLabel("◀");	JLabel nextL = new JLabel("▶");
	
	// 룸 타입별 상세 정보들 
	JPanel detailInfo[];
	
	
	public Testclient() {
		ct = getContentPane();
		ct.setLayout(null);
		
		selectCheckP.setBorder(new TitledBorder(bl," [예약 날짜] "));
		
		date = Calendar.getInstance(); //현재 캘린더정보 변수에 받아와 저장.
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH)+1;
		day = date.get(Calendar.DATE);
		
		selectCheckP.setLayout(new GridLayout(2,7,-25,0));
		
		selectCheckP.add(ckInL);
		selectCheckP.add(inYearCombo);	selectCheckP.add(inYearL);
		selectCheckP.add(inMonthCombo); selectCheckP.add(inMonthL);
		selectCheckP.add(inDayCombo);  selectCheckP.add(inDayL);
		
		selectCheckP.add(ckOutL);
		selectCheckP.add(outYearCombo);  selectCheckP.add(outYearL);
		selectCheckP.add(outMonthCombo); selectCheckP.add(outMonthL);
		selectCheckP.add(outDayCombo);  selectCheckP.add(outDayL);
		

		checkInoutP.setBounds(40,50,500,95);
		checkInoutP.add(selectCheckP);
		ct.add(checkInoutP);
		
		
		setYear(); setMonth(); setDay();
		
		inYearCombo.addItemListener(this); inMonthCombo.addItemListener(this); inDayCombo.addItemListener(this);
		outYearCombo.addItemListener(this); outMonthCombo.addItemListener(this); outDayCombo.addItemListener(this);
		
		rm = new JPanel[roomname.length];  //배열의 크기 = 방의 종류개수로 맞춤.
		txt = new JPanel[roomname.length];
		rmimg = new ImageIcon[roomname.length];
		rimg = new JButton[roomname.length];
		rmName = new JLabel[roomname.length];
		rmFee = new JLabel[roomname.length];
		line = new JLabel[roomname.length];
		basicP = new JLabel[roomname.length];
		maxP = new JLabel[roomname.length];
		rBtn = new JButton[roomname.length];
		
		
		//룸 타입별 이미지 생성 
		for(int i=0; i<srcimg.length; i++) {
			rimg[i] = new JButton();
			rmimg[i] = new ImageIcon(srcimg[i]);
			rimg[i].setIcon(changeImgSize(rmimg[i], 220, 140)); //이미지 사이즈 변경 메소드사용 (리턴값 이미지아이콘)
		}
		//룸 정보 배열저장 
		for(int i=0; i<roomname.length; i++) {
			rmName[i] = new JLabel(roomname[i]);	rmName[i].setFont(ft);
			rmFee[i] = new JLabel(Integer.toString(roomfee[i])+"원"); //int형으로 저장된 가격을 문자열로 변환하여 레이블로 저장.
			line[i] = new JLabel("---------------------------------------------------------");
			basicP[i] = new JLabel(bp+Integer.toString(basic[i])+"명");  // "이용인원 n명" 으로 저장 
			maxP[i] = new JLabel(mp+Integer.toString(max[i])+"명");      // "/최대 n명" 으로 저장 
			rBtn[i] = new JButton("예약하기");	
			
			
			if(able[i]==0) { //남은 방이 0이면 예약 버튼 비활성화 
				rBtn[i].setEnabled(false);
			} 
			else { // 아니면 예약버튼 이벤트요청
				rBtn[i].addActionListener(new RbtnListener());
			}
		}
		
	
		roomTypeP.setLayout(new FlowLayout()); // 룸타입별 정보 패널 레이아웃 설정 
		for(int i=0; i<rm.length; i++) {
			rm[i] = new JPanel(new BorderLayout(30,0));
			txt[i] = new JPanel(new GridLayout(4,0, 0,-20));
			
			txt[i].add(rmName[i]);
			txt[i].add(rmFee[i]);
			txt[i].add(basicP[i]);
			txt[i].add(maxP[i]);
			
			rm[i].add(rimg[i], BorderLayout.WEST);
			rm[i].add(txt[i], BorderLayout.CENTER);
			rm[i].add(rBtn[i], BorderLayout.EAST);
			rm[i].add(line[i], BorderLayout.SOUTH);
			
			roomTypeP.add(rm[i]);
			
			rimg[i].addActionListener(new ImgListener());
		}
		roomTypeP.setBounds(30, 135, 520, 690);
		
		ct.add(roomTypeP);
		
		
		//상세페이지 이미지 패널 구현 (윈도우 add는 이벤트 처리에서)
		detailP.setBorder(new TitledBorder(bl," [상세 정보] "));
		
		detailImg = new JPanel[rimg.length];
		detailInfo = new JPanel[rimg.length];
		
		//dimgI = 여러개의 이미지 icon, deimg= 1개의 label (사진 중 하나 골라서 띄워줌)
		for(int i=0; i<rimg.length; i++) { //룸타입별 (i, 4) 상세사진 (j, 4) 개수 
			detailImg[i] = new JPanel();
			detailInfo[i] = new JPanel();
			
			dimgI = new ImageIcon[rimg.length][srcDrimg[i].length];
			
			for(int j=0; j<srcDrimg[i].length; j++) {
				
				dimgI[i][j] = new ImageIcon(srcDrimg[i][j]);
				dimgI[i][j] = changeImgSize(dimgI[i][j], 350, 190);
				
				deimg.setIcon(dimgI[i][0]); // 룸 상세이미지의 초기값 = 첫번째 사진.
			}
			detailImg[i].add(preL, FlowLayout.LEFT);
			detailImg[i].add(deimg, FlowLayout.CENTER);
			detailImg[i].add(nextL, FlowLayout.RIGHT);
			detailImg[i].setVisible(false);
			
			detailP.add(detailImg[i], BorderLayout.NORTH);
		}
		detailP.setBounds(590, 50, 450, 500);
		ct.add(detailP);
		
		preL.addMouseListener(new ImgListener());
		nextL.addMouseListener(new ImgListener());
			
			//
			//	deimg[j] = new JLabel();
			//	deimg[j].setIcon(changeImgSize(dimgI[i], 350, 190));
			//	dimgI[j] = new ImageIcon(srcdimg[i][j]); //detail 사진들을 아이콘으로 받기
			//}
		//	detailimg.add(preL);
	//	}
	//	detailimg.add(preL, BorderLayout.WEST);
	//	detailimg.add(nextL, BorderLayout.EAST);
		
		
		
		//changeImgsize(350,190) 상세페이지 사진 메소
		//datailP.setBounds(x,y, 460,400)
		//detailimg.setVisiable(false);
		//ct.detail
		
		
		
		
	}// 생성자
	
	public ImageIcon changeImgSize (ImageIcon i, int w, int h) { //이미지 사이즈 조절 메소드 
		Image img = i.getImage();
		Image changeimg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
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
		inDayCombo.setSelectedItem(day); //
		outDayCombo.setSelectedItem(day+1); //체크아웃 기본값 날짜는 체크인보다 하루 뒤.
	}

	@Override // 아이템 이벤트 값 다시 설정.
	public void itemStateChanged(ItemEvent ie) {
		int inY, outY, inM, outM, inD, outD;
		inY = (int)inYearCombo.getSelectedItem(); //형변환한것을볼수 있으며 yearCombo바뀌었을때 yearCombo의 값을 getSelected 가져와서 찾는것을 볼수 있다.
		inM = (int)inMonthCombo.getSelectedItem();
		inD = (int)inDayCombo.getSelectedItem();
		//Calender inDate = 
		
		if (month<inM || month==inM && day<inD)
			JOptionPane.showMessageDialog(this, "체크인 날짜를 오늘 이후로 선택해주세요!", "체크인 날짜 정정 알림창", JOptionPane.ERROR_MESSAGE);
		
		
	}
	class RbtnListener implements ActionListener  {	
		public void actionPerformed(ActionEvent ae) {
			// 예약버튼 누르면 예약화면으로 넘어가는 이벤트 추가 
			
		}
	}
	class ImgListener extends MouseAdapter implements ActionListener  {	
		//int clicked;
		
		public void actionPerformed(ActionEvent ae) {
			//System.out.println(ae.getSource());
			for(int i=0; i<rimg.length; i++) {
				
				if(rimg[i] == ae.getSource()) { 
					System.out.println(rimg[i]);
					detailImg[i].setVisible(true);
					detailInfo[i].setVisible(true);
					//clicked = i;
				} 
				else {
					detailImg[i].setVisible(false);
					detailInfo[i].setVisible(false);
				}
			}
					
		}// actionEvent	
			
		public void mouseClicked(MouseEvent me) {
			int n=0;
		
			System.out.println(detailImg.length);
			for(int i=0; i<detailImg.length; i++) {

				if(nextL == me.getSource()) { 
					if(n<dimgI[i].length)
						n++;
					else if(n==dimgI[i].length-1)
						n=0;	
						
					deimg.setIcon(dimgI[i][n]); // 액션이벤트에서 클릭된 룸의 상세 이미지를 띄운다. 
				} // ▶ 다음버튼 누르면 다음 사진으로 넘어가는 조건문
				
				else if(preL == me.getSource()) {
					if(n==0)
						n=(dimgI[i].length)-1;
					else if(n>0)
						n--;
					
					deimg.setIcon(dimgI[i][n]);
				} // ◀ 이전버튼 누르면 이전사진으로 넘어가는 조건문
				
			}
		}
		
	}	




	public static void main(String[] args) {
		Testclient win = new Testclient();
		win.setTitle("Client Page");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(1100, 1000);
		win.setLocation(350, 20);
		win.setVisible(true);

	}

}
