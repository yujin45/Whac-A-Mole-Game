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
		// 이름 적어두기

		while (MoleCatchingGame_TimeLimit.timeOK) {
			player = MoleCatchingGame_Intro.userName;
			playerL.setText(player);
			// 총 점수, 두더지 출현 횟수, 놓친 횟수 계산하거나 String으로 바꿔둠
			totalScore = Integer.toString(MoleCatchingGame_Score.moleTotalScore);
			totalUp = Integer.toString(MoleCatchingGame_Score.moleTotalUp);
			totalLoseNum = MoleCatchingGame_Score.moleTotalUp - (MoleCatchingGame_Score.moleTotalScore / 10);
			totalLose = Integer.toString(totalLoseNum);
			totalScoreL.setText(totalScore);
			totalUpL.setText(totalUp);
			totalLoseL.setText(totalLose);

			try {
				System.out.println("++++++점수 변화중" + MoleCatchingGame_Score.moleTotalScore);
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
