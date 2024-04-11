import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoleCatchingGame_Intro extends JPanel implements ActionListener {
	// ★★★★★★★★▲ class명 = > 게임명_Intro

	ImageIcon gameIntroIC;
	Image gameIntro;
	JButton startBtn, okBtn;
	Font dfont;
	JDialog inputUserName;
	JPanel inputNameP;
	JLabel inputNameL;
	TextField tf;
	public static String userName;

	public MoleCatchingGame_Intro() {
		setBackground(Color.white);
		setLayout(null);
		// ★★★★★★★★★★★영선님! 아래 1개 본인 것으로 수정해주세요★★★★★★★★★★★★
		// 게임 설명은 이미지로 만들어서 게임명IntroImg.png형식으로 아래에 삽입 ★★★
		gameIntroIC = new ImageIcon("MoleCatchingGameIntroImg.png");
		
		gameIntro = gameIntroIC.getImage();

		startBtn = new JButton("시작하기");
		startBtn.addActionListener(this);
		startBtn.setFont(new Font("굴림", Font.BOLD, 30));
		startBtn.setBackground(new Color(255, 245, 233)); // 버튼 색
		startBtn.setBounds(450, 550, 200, 100); // 버튼 위치, 크기
		add(startBtn);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// 게임 방법 소개 이미지를 사이즈 조절해서 그려줌
		g2.drawImage(gameIntro, 0, 0, 1100, 750, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startBtn) {
			// 시작 버튼 누르면 이름 입력하고 확인 눌러야 시작되게 다이어로그 창 만들기
			inputUserName = new JDialog(); // 만들고
			inputUserName.setLayout(new GridLayout(1, 1));
			dfont = new Font("굴림", Font.BOLD, 20);
			inputNameP = new JPanel();
			inputNameP.setLayout(new GridLayout(3, 1));
			inputNameL = new JLabel("닉네임을 입력해주세요(공백없이)");
			inputNameL.setHorizontalAlignment(JLabel.CENTER);
			inputNameL.setFont(dfont);
			tf = new TextField(10); // 10글자까지 입력 가능
			tf.addActionListener(this);
			
			// ★★★  ▼영선님은 슈팅 마스터 이런식으로 마음대로 바꿔주세요!★★★★★★★★★
			tf.setText("두더지_마스터"); 
			tf.setFont(dfont);
			inputNameP.add(inputNameL);
			inputNameP.add(tf);
			inputNameP.setBackground(new Color(233, 255, 111));
			// inputUserName.add("Center", inputNameP);

			okBtn = new JButton("확인");
			okBtn.setFont(dfont);
			okBtn.setBackground(Color.pink);
			okBtn.addActionListener(this);
			// inputUserName.add("South", okBtn);
			inputNameP.add(okBtn);
			inputUserName.add(inputNameP);
			inputUserName.setTitle("닉네임 입력");
			inputUserName.setSize(450, 150);
			inputUserName.setVisible(true);

		} else if (e.getSource() == okBtn) {
			// 확인버튼 들어오면 닉네임 입력됐는지 확인해야함
			userName = tf.getText();
			if (userName.equals("")) {
				// 닉네임 없으면 다시 입력해달라 하기
				System.out.println("이름 입력 없음");
				tf.setText("닉네임 다시 입력해주세요(공백없이)");
			} else {
				// ★★★★★★★★★★★★★★★Frame에 접근해서 패널 제거하고 붙이고 업데이트★영선님class이름으로 바꿔주세요★★★★★★★★
				MoleCatchingGame_Frame.center.remove(MoleCatchingGame_Frame.intro);
				MoleCatchingGame_Frame.center.add(MoleCatchingGame_Frame.game);
				MoleCatchingGame_Frame.center.updateUI();
				System.out.println(userName);
				// 게임 화면으로 패널 교체하고 다이어로그 창 닫기
				inputUserName.setVisible(false); // 다이어로그 안 보이게 닫음
				
				// ★★★★★★★▼ 이 부분은 영선님 스레드에 맞게 빼도 되는 부분!★★★★★★★★★
				// 이름 적으면 스레드들 시작하도록 함. 
				MoleCatchingGame_9Moles.start9Moles(); // 9x9 두더지들 스레드
				MoleCatchingGame_Score.startMoleScore(); // score 체크 스레드
				MoleCatchingGame_TimeLimit.startTimeLimit(MoleCatchingGame_Game.timeLimitPanel);// 시간 제한 스레드
			
			}

		}

	}
}
