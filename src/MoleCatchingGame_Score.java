import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoleCatchingGame_Score extends JPanel {
	MoleScore score;
	public static int moleTotalScore = 0; // �δ��� ���� ����
	public static int moleTotalUp = 0; // �δ����� ��� Ƣ��Դ���
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
		lfont = new Font("����", Font.BOLD, 20);
		
		playert= new JLabel("Palyer");
		playert.setFont(lfont);
		playert.setHorizontalAlignment(JLabel.CENTER);
		totalScoret= new JLabel("�� ����");
		totalScoret.setFont(lfont);
		totalScoret.setHorizontalAlignment(JLabel.CENTER);
		totalUpt= new JLabel("�δ��� ���� Ƚ��");
		totalUpt.setFont(lfont);
		totalUpt.setHorizontalAlignment(JLabel.CENTER);
		totalLoset= new JLabel("��ģ Ƚ��");
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

		// �гε� ����
		playerP = new JPanel(new GridLayout(2, 1));
		playerP.setBackground(Color.orange);
		totalScoreP = new JPanel(new GridLayout(2, 1));
		totalScoreP.setBackground(Color.yellow);
		totalUpP = new JPanel(new GridLayout(2, 1));
		totalUpP.setBackground(Color.orange);
		totalLoseP = new JPanel(new GridLayout(2, 1));
		totalLoseP.setBackground(Color.yellow);
		//�гο� ���̱�
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
		// thread���ھ� ����
		moleScore = new MoleScore(playerL, totalScoreL, totalUpL, totalLoseL);
		moleScore.start();
	}

}
