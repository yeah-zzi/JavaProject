package signup;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ClientSignup extends JFrame implements ActionListener {

	JTextField id, pwans, name, birth, tel_num1, tel_num2, email_id;
	JPasswordField pw;
	String pwhint[] = { "내가 가장 존경하는 인물은?", "내가 태어난 곳은?", "내 어릴적 별명은?", "내가 키우던 애완동물의 이름은?", "내가 가장 좋아하는 간식은?",
			"내가 싫어하는 음식은?", "내가 좋아하는 캐릭터는?", "나와 가장 친한 친구의 이름은?", "자신의 보물 1호는?", "내가 다닌 초등학교 이름은?" };
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
		// imageicon 크기 조정을 위해 image 객체로 변경하여 크기 조정 후, 다시 imageicon화 함.
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
		JLabel l1 = new JLabel("아이디");
		p1.add(l1);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		id = new JTextField("6자리 (영소문자&숫자)", 15);
		check = new JButton("중복 확인");
		check.addActionListener(this);
		p2.add(id);
		p2.add(check);

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l2 = new JLabel("비밀번호");
		p3.add(l2);

		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		pw = new JPasswordField(15);
		p4.add(pw);

		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l3 = new JLabel("비밀번호 힌트");
		p5.add(l3);

		JPanel p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.LEFT));
		hint = new JComboBox(pwhint);
		p6.add(hint);

		JPanel p7 = new JPanel();
		p7.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l4 = new JLabel("비밀번호 힌트 답");
		p7.add(l4);

		JPanel p8 = new JPanel();
		p8.setLayout(new FlowLayout(FlowLayout.LEFT));
		pwans = new JTextField(15);
		p8.add(pwans);

		JPanel p9 = new JPanel();
		p9.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l5 = new JLabel("이름                      ");
		JLabel l6 = new JLabel("생년월일              ");
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
		JLabel l7 = new JLabel("연락처");
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
		JLabel l8 = new JLabel("이메일");
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
		ok = new JButton("확인");
		cancel = new JButton("취소");
		cancel.addActionListener(this);
		bottom.add(ok);
		bottom.add(cancel);
		ct.add(bottom, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		if (s.equals("취소")) {
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
		} // 취소 버튼 누르면 모든 입력값 초기화
		else if (s.equals("확인")) {
		} // 확인 버튼 누르면 DB연동 저장
		else {

		} // 아이디 중복확인 DB로 확인 후, 사용가능여부 창 띄우기(JDiglog)
	}

	public static void main(String[] args) {
		ClientSignup win = new ClientSignup("고객 회원가입");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(700, 800);
		win.setLocation(350, 80);
		win.show();

	}

}
