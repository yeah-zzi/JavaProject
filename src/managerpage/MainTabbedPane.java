package managerpage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;



public class MainTabbedPane extends JFrame {
	
	public MainTabbedPane() {
		JTabbedPane main = new JTabbedPane();
		CalendarSwing cal = new CalendarSwing();
		
		main.addTab("방 예약", cal);
		main.addTab("시설 예약", new JButton("예시입니다"));
		main.addTab("고객 관리", new JButton("예시입니다"));
		main.addTab("직원 관리", new JButton("예시입니"));
		
		Container ct = getContentPane();
		ct.add(main);
	}

	public static void main(String[] args) {
		MainTabbedPane win = new MainTabbedPane();
		win.setTitle("관리자 페이지");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(500, 700);
		win.setVisible(true);
		

	}

}
