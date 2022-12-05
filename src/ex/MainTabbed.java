package ex;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import signup.SignUp;

public class MainTabbed extends JFrame {
	
	public MainTabbed() {
		JTabbedPane main = new JTabbedPane();
		Panel p = new Panel();
		
		
		main.addTab("Main page", p);
		main.addTab("My Page", new JButton("ex"));
		
		
		Container ct = getContentPane();
		ct.add(main);
	}

	public static void main(String[] args) {
		MainTabbed win = new MainTabbed();
		win.setTitle("관리자 페이지");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(1000, 1000);
		win.setVisible(true);

	}

}
