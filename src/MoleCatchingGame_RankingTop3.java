import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoleCatchingGame_RankingTop3 extends JPanel implements ActionListener{
	// 랭킹 3위 들면 출력해주는 부분
	//JPanel rangkingTop3Panel;
	static JLabel rankLabel[] = new JLabel[3];
	JLabel scoreTitle;
	JButton backToGameIntro;
	Font titleFont, rankFont;
	static RankingTop3 rankTop3;
	public MoleCatchingGame_RankingTop3(){
		setLayout(new GridLayout(5, 1));
		setBackground(new Color(219, 247, 255));
	
		//붙이는 부분
		titleFont= new Font("굴림", Font.BOLD, 30); 
		rankFont = new Font("굴림", Font.BOLD, 20);
		scoreTitle = new JLabel("랭킹");
		scoreTitle.setFont(titleFont);
		scoreTitle.setHorizontalAlignment(JLabel.CENTER);
		////
		backToGameIntro = new JButton("다시 시작하기");
		backToGameIntro.setFont(rankFont);
		backToGameIntro.setBackground(new Color(255, 238, 254));
		backToGameIntro.addActionListener(this);
		
		
		///
		add(scoreTitle);
		for (int j = 0; j < rankLabel.length; j++) {
			rankLabel[j] = new JLabel("");
			rankLabel[j].setFont(rankFont);
			rankLabel[j].setHorizontalAlignment(JLabel.CENTER);
			add(rankLabel[j]);
		}
		
		
		add(backToGameIntro);
		
	}
	
	public static void startRankingTop3() {
			rankTop3 = new RankingTop3(rankLabel[0], rankLabel[1], rankLabel[2]);
		rankTop3.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backToGameIntro) {
			// ★★★★영선님 여기 원하는대로 바꾸시면 됩니다!!
			// ★★★★저는 우선 여기 순위 패널을 지우고 인트로 패널을 붙였어요!
			MoleCatchingGame_Frame.center.remove(MoleCatchingGame_Frame.rank);
			MoleCatchingGame_Frame.center.add(MoleCatchingGame_Frame.intro);
			MoleCatchingGame_Frame.center.updateUI();
			// ★★★★ 그리고 아래는 스레드 flag 다시 초기화 하고 값들도 초기화 했어요
			// 다시 값들을 다 초기화해줘야 함
			 MoleCatchingGame_TimeLimit.timeOK = true;
			 // 사람 이름, 두더지 횟수, 놓친 횟수, 잡은 횟수, 총 점수 초기화
			 MoleCatchingGame_Intro.userName ="두더지"; //초기화
			 MoleCatchingGame_Score.moleTotalScore=0;
			 MoleCatchingGame_Score.moleTotalUp=0;
			 
			 // 각 스레드 다시 작동하게 함
			 // ★★스레드는 각 스레드별로 객체만들어서 시작하는 함수 만들어둬서 여기에는 추가 안했어요
		}
		
	}
	
}
