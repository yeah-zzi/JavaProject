package signup;
// 아무거나

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ClientSignup extends JFrame implements ActionListener {

	JTextField id, pwans, name, birth, tel_num1, tel_num2, email_id;
	JPasswordField pw;
	String pwhint[] = { "�궡媛� 媛��옣 議닿꼍�븯�뒗 �씤臾쇱�?", "�궡媛� �깭�뼱�궃 怨녹�?", "�궡 �뼱由댁쟻 蹂꾨챸��?", "�궡媛� �궎�슦�뜕 �븷�셿�룞臾쇱쓽 �씠由꾩�?", "�궡媛� 媛��옣 醫뗭븘�븯�뒗 媛꾩떇��?",
			"�궡媛� �떕�뼱�븯�뒗 �쓬�떇��?", "�궡媛� 醫뗭븘�븯�뒗 罹먮┃�꽣�뒗?", "�굹�� 媛��옣 移쒗븳 移쒓뎄�쓽 �씠由꾩�?", "�옄�떊�쓽 蹂대Ъ 1�샇�뒗?", "�궡媛� �떎�땶 珥덈벑�븰援� �씠由꾩�?" };
	String telcode[] = { "010", "011", "017", "070", "02", "031", "032", "033", "041" };
	String emcode[] = { "naver.com", "gmail.com", "nate.com", "daum.net", "korea.kr" };
	JComboBox hint, tel, email;
	JButton ok, cancel, check;

	ClientSignup(String title) {
		setTitle(title);

		Container ct = getContentPane();
		ct.setLayout(new BorderLayout(0, 20));

		JPanel main = new JPanel();
		main.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		ImageIcon client = new ImageIcon("images/client.png");
		// imageicon �겕湲� 議곗젙�쓣 �쐞�빐 image 媛앹껜濡� 蹂�寃쏀븯�뿬 �겕湲� 議곗젙 �썑, �떎�떆 imageicon�솕 �븿.
		Image clientImg = client.getImage();
		Image ImgClient = clientImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon ClientIcon = new ImageIcon(ImgClient);
		JLabel photo = new JLabel(ClientIcon);
		main.add(photo);
		ct.add(main, BorderLayout.NORTH);

		JPanel top = new JPanel();
		top.setLayout(new GridLayout(14,1));

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l1 = new JLabel("�븘�씠�뵒");
		p1.add(l1);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		id = new JTextField("6�옄由� (�쁺�냼臾몄옄&�닽�옄)", 15);
		check = new JButton("以묐났 �솗�씤");
		check.addActionListener(this);
		p2.add(id);
		p2.add(check);

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l2 = new JLabel("鍮꾨�踰덊샇");
		p3.add(l2);

		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		pw = new JPasswordField(15);
		p4.add(pw);

		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l3 = new JLabel("鍮꾨�踰덊샇 �엺�듃");
		p5.add(l3);

		JPanel p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.LEFT));
		hint = new JComboBox(pwhint);
		p6.add(hint);

		JPanel p7 = new JPanel();
		p7.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l4 = new JLabel("鍮꾨�踰덊샇 �엺�듃 �떟");
		p7.add(l4);

		JPanel p8 = new JPanel();
		p8.setLayout(new FlowLayout(FlowLayout.LEFT));
		pwans = new JTextField(15);
		p8.add(pwans);

		JPanel p9 = new JPanel();
		p9.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l5 = new JLabel("�씠由�                      ");
		JLabel l6 = new JLabel("�깮�뀈�썡�씪              ");
		p9.add(l5);
		p9.add(l6);

		JPanel p10 = new JPanel();
		p10.setLayout(new FlowLayout(FlowLayout.LEFT));
		name = new JTextField(8);
		birth = new JTextField("EX> 990101", 10);
		p10.add(name);
		p10.add(birth);

		JPanel p11 = new JPanel();
		p11.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l7 = new JLabel("�뿰�씫泥�");
		p11.add(l7);

		JPanel p12 = new JPanel();
		p12.setLayout(new FlowLayout(FlowLayout.LEFT));
		tel = new JComboBox(telcode);
		tel_num1 = new JTextField(8);
		tel_num2 = new JTextField(8);
		p12.add(tel);
		p12.add(tel_num1);
		p12.add(tel_num2);

		JPanel p13 = new JPanel();
		p13.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l8 = new JLabel("�씠硫붿씪");
		p13.add(l8);

		JPanel p14 = new JPanel();
		p14.setLayout(new FlowLayout(FlowLayout.LEFT));
		email_id = new JTextField(10);
		JLabel l9 = new JLabel("@");
		email = new JComboBox(emcode);
		p14.add(email_id);
		p14.add(l9);
		p14.add(email);

		top.add(p1); top.add(p2); top.add(p3); top.add(p4); top.add(p5); top.add(p6); top.add(p7);
		top.add(p8); top.add(p9); top.add(p10); top.add(p11); top.add(p12); top.add(p13); top.add(p14);
		ct.add(top, BorderLayout.CENTER);

		JPanel bottom = new JPanel();
		ok = new JButton("�솗�씤");
		cancel = new JButton("痍⑥냼");
		cancel.addActionListener(this);
		bottom.add(ok);
		bottom.add(cancel);
		ct.add(bottom, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		if (s.equals("痍⑥냼")) {
			id.setText("");
			pw.setText("");
			pwans.setText("");
			name.setText("");
			birth.setText("");
			tel_num1.setText("");
			tel_num2.setText("");
			email_id.setText("");
			hint.setSelectedItem((Object) pwhint[0]);
			tel.setSelectedItem((Object) telcode[0]);
			email.setSelectedItem((Object) emcode[0]);
		} // 痍⑥냼 踰꾪듉 �늻瑜대㈃ 紐⑤뱺 �엯�젰媛� 珥덇린�솕
		else if (s.equals("�솗�씤")) {
		} // �솗�씤 踰꾪듉 �늻瑜대㈃ DB�뿰�룞 ���옣
		else {

		} // �븘�씠�뵒 以묐났�솗�씤 DB濡� �솗�씤 �썑, �궗�슜媛��뒫�뿬遺� 李� �쓣�슦湲�(JDiglog)
	}

	public static void main(String[] args) {
		ClientSignup win = new ClientSignup("怨좉컼 �쉶�썝媛��엯");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(700, 800);
		win.setLocation(350, 80);
		win.show();

	}

}
