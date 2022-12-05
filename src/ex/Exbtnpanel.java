package ex;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Exbtnpanel extends JFrame {
	
	JButton btn[]; // 1> 배열 컴포넌트 만들면 
	JPanel p[] ;
	
	Exbtnpanel() {
		JPanel main = new JPanel();
		main.setLayout(new FlowLayout());
		p = new JPanel[3]; // 2> 배열 크기 지정하고 
		btn = new JButton[3];
		
		for(int i=0; i<p.length; i++) {
			btn[i] = new JButton();  // 3> 다시 각 배열마다 선언해주고 
			p[i] = new JPanel();
			
			btn[i].setText("hi"); // 4> 마지막에 값 넣어서 사용가능.
			p[i].add(btn[i]);
			main.add(p[i]);   		// 이 과정 없으면 NullpointerException 뜸!
		}
		
		Container ct = getContentPane();
		ct.add(main);
	}
	
	public static void main(String[] args) {
		Exbtnpanel win = new Exbtnpanel();
		win.setTitle("Client Page");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(1100, 1000);
		win.setLocation(350, 20);
		win.setVisible(true);

	}

}
