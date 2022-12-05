package ex;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Panel extends JPanel{
		JPanel p1 = new JPanel();
		JButton btn = new JButton("패널안에서 만든 버튼 ");
		
		
		
	Panel() {
		p1.setLayout(null);
		btn.setBounds(0, 260, 500, 700);
		p1.add(btn);
		add(p1);
	}
	
}
