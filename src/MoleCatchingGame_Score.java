import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoleCatchingGame_Score extends JPanel {
	MoleScore score;
	public static int moleTotalScore = 0; // 두더지 잡은 점수
	public static int moleTotalUp = 0; // 두더지가 몇번 튀어나왔는지
	JLabel playert, totalScoret, totalUpt, totalLoset;
	static JLabel playerL;
	static JLabel totalScoreL;
	static JLabel totalUpL;
	static JLabel totalLoseL;
	JPanel playerP, totalScoreP, totalUpP, totalLoseP;
	static MoleScore moleScore;
	Font lfont;

	public MoleCatchingGame_Score() {
		setLayout(new GridLayout(4, 1));
		setBackground(Color.orange);
		lfont = new Font("굴림", Font.BOLD, 20);
		
		playert= new JLabel("Palyer");
		playert.setFont(lfont);
		playert.setHorizontalAlignment(JLabel.CENTER);
		totalScoret= new JLabel("총 점수");
		totalScoret.setFont(lfont);
		totalScoret.setHorizontalAlignment(JLabel.CENTER);
		totalUpt= new JLabel("두더지 출현 횟수");
		totalUpt.setFont(lfont);
		totalUpt.setHorizontalAlignment(JLabel.CENTER);
		totalLoset= new JLabel("놓친 횟수");
		totalLoset.setFont(lfont);
		totalLoset.setHorizontalAlignment(JLabel.CENTER);
		
		
		playerL = new JLabel();
		playerL.setFont(lfont);
		playerL.setHorizontalAlignment(JLabel.CENTER);
		totalScoreL = new JLabel();
		totalScoreL.setFont(lfont);
		totalScoreL.setHorizontalAlignment(JLabel.CENTER);
		totalUpL = new JLabel();
		totalUpL.setFont(lfont);
		totalUpL.setHorizontalAlignment(JLabel.CENTER);
		totalLoseL = new JLabel();
		totalLoseL.setFont(lfont);
		totalLoseL.setHorizontalAlignment(JLabel.CENTER);

		// 패널들 생성
		playerP = new JPanel(new GridLayout(2, 1));
		playerP.setBackground(Color.orange);
		totalScoreP = new JPanel(new GridLayout(2, 1));
		totalScoreP.setBackground(Color.yellow);
		totalUpP = new JPanel(new GridLayout(2, 1));
		totalUpP.setBackground(Color.orange);
		totalLoseP = new JPanel(new GridLayout(2, 1));
		totalLoseP.setBackground(Color.yellow);
		//패널에 붙이기
		playerP.add(playert);
		playerP.add(playerL);
		totalScoreP.add(totalScoret);
		totalScoreP.add(totalScoreL);
		totalUpP.add(totalUpt);
		totalUpP.add(totalUpL);
		totalLoseP.add(totalLoset);
		totalLoseP.add(totalLoseL);
		
		add(playerP);
		add(totalScoreP);
		add(totalUpP);
		add(totalLoseP);
		
		

	}

	public static void startMoleScore() {
		// thread스코어 생성
		moleScore = new MoleScore(playerL, totalScoreL, totalUpL, totalLoseL);
		moleScore.start();
	}

}
