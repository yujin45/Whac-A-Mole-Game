import javax.swing.JLabel;

public class MoleScore extends Thread {
	int totalLoseNum = 0;
	String player, totalScore, totalUp, totalLose;
	JLabel playerL, totalScoreL, totalUpL, totalLoseL;

	public MoleScore(JLabel playerL, JLabel totalScoreL, JLabel totalUpL, JLabel totalLoseL) {
		this.playerL = playerL;
		this.totalScoreL = totalScoreL;
		this.totalUpL = totalUpL;
		this.totalLoseL = totalLoseL;

	}

	public void run() {
		// �̸� ����α�

		while (MoleCatchingGame_TimeLimit.timeOK) {
			player = MoleCatchingGame_Intro.userName;
			playerL.setText(player);
			// �� ����, �δ��� ���� Ƚ��, ��ģ Ƚ�� ����ϰų� String���� �ٲ��
			totalScore = Integer.toString(MoleCatchingGame_Score.moleTotalScore);
			totalUp = Integer.toString(MoleCatchingGame_Score.moleTotalUp);
			totalLoseNum = MoleCatchingGame_Score.moleTotalUp - (MoleCatchingGame_Score.moleTotalScore / 10);
			totalLose = Integer.toString(totalLoseNum);
			totalScoreL.setText(totalScore);
			totalUpL.setText(totalUp);
			totalLoseL.setText(totalLose);

			try {
				System.out.println("++++++���� ��ȭ��" + MoleCatchingGame_Score.moleTotalScore);
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
