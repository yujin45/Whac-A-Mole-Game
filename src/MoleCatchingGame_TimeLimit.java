import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class MoleCatchingGame_TimeLimit extends JPanel {
	public static boolean timeOK = true;
	 static MoleTimeLimit moleTimeLimit;
	Rectangle2D.Double timeGone;
	static Rectangle2D.Double timeLeft;
	GradientPaint gradient;
	Color startColor = Color.cyan, endColor = Color.magenta;
	static int x =0, stx = 5, sty =5, edx=200, edy=200;
	
	public MoleCatchingGame_TimeLimit() {
		setLayout(null);
		setBackground(new Color(219, 255, 251));
			gradient = new GradientPaint(stx, sty, startColor, edx, edy, endColor, true);
timeGone = new Rectangle2D.Double(150, 25, 900, 30);
		
		
	}
	
	public static void startTimeLimit(MoleCatchingGame_TimeLimit timeLimitPnael) {
	
		
		timeLeft = new Rectangle2D.Double(150, 25, 900, 30);
		moleTimeLimit = new MoleTimeLimit(timeLimitPnael, x, stx, sty, edx, edy);
		moleTimeLimit.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//timeGone.setRect(150, 25, 900, 30);
		// 줄어드는 시간 표현
		timeLeft.setRect(150+moleTimeLimit.x, 25, 900-moleTimeLimit.x, 30); 
		if(moleTimeLimit.x >= 900) {
			// 이미 종료된 시점
			MoleCatchingGame_RankingTop3.startRankingTop3();
			timeOK = false;
			MoleCatchingGame_Frame.center.remove(MoleCatchingGame_Frame.game);
			MoleCatchingGame_Frame.center.add(MoleCatchingGame_Frame.rank);
			MoleCatchingGame_Frame.center.updateUI();
			
			
		}
		gradient = new GradientPaint(moleTimeLimit.stx, moleTimeLimit.sty, startColor, moleTimeLimit.edx, moleTimeLimit.edy, endColor, true);
		// 남은 시간 글자
		g2.setFont(new Font("굴림", Font.BOLD, 20));
		g2.setStroke(new BasicStroke(5));
		g2.drawString("남은 시간", 50, 50);
		g2.setStroke(new BasicStroke(0));
		// 시간 남은 것 체크해주는 바
		g2.setColor(Color.gray);
		g2.draw(timeGone); // 지나간 시간
		g2.fill(timeGone);
		g2.setPaint(gradient);
		g2.draw(timeLeft); // 남은 시간
		g2.fill(timeLeft);

	}

}
