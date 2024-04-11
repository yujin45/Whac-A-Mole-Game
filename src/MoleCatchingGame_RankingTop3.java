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
	// ��ŷ 3�� ��� ������ִ� �κ�
	//JPanel rangkingTop3Panel;
	static JLabel rankLabel[] = new JLabel[3];
	JLabel scoreTitle;
	JButton backToGameIntro;
	Font titleFont, rankFont;
	static RankingTop3 rankTop3;
	public MoleCatchingGame_RankingTop3(){
		setLayout(new GridLayout(5, 1));
		setBackground(new Color(219, 247, 255));
	
		//���̴� �κ�
		titleFont= new Font("����", Font.BOLD, 30); 
		rankFont = new Font("����", Font.BOLD, 20);
		scoreTitle = new JLabel("��ŷ");
		scoreTitle.setFont(titleFont);
		scoreTitle.setHorizontalAlignment(JLabel.CENTER);
		////
		backToGameIntro = new JButton("�ٽ� �����ϱ�");
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
			// �ڡڡڡڿ����� ���� ���ϴ´�� �ٲٽø� �˴ϴ�!!
			// �ڡڡڡ����� �켱 ���� ���� �г��� ����� ��Ʈ�� �г��� �ٿ����!
			MoleCatchingGame_Frame.center.remove(MoleCatchingGame_Frame.rank);
			MoleCatchingGame_Frame.center.add(MoleCatchingGame_Frame.intro);
			MoleCatchingGame_Frame.center.updateUI();
			// �ڡڡڡ� �׸��� �Ʒ��� ������ flag �ٽ� �ʱ�ȭ �ϰ� ���鵵 �ʱ�ȭ �߾��
			// �ٽ� ������ �� �ʱ�ȭ����� ��
			 MoleCatchingGame_TimeLimit.timeOK = true;
			 // ��� �̸�, �δ��� Ƚ��, ��ģ Ƚ��, ���� Ƚ��, �� ���� �ʱ�ȭ
			 MoleCatchingGame_Intro.userName ="�δ���"; //�ʱ�ȭ
			 MoleCatchingGame_Score.moleTotalScore=0;
			 MoleCatchingGame_Score.moleTotalUp=0;
			 
			 // �� ������ �ٽ� �۵��ϰ� ��
			 // �ڡڽ������ �� �����庰�� ��ü���� �����ϴ� �Լ� �����ּ� ���⿡�� �߰� ���߾��
		}
		
	}
	
}
