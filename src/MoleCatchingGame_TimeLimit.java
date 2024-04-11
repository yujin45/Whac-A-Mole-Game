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
		// �پ��� �ð� ǥ��
		timeLeft.setRect(150+moleTimeLimit.x, 25, 900-moleTimeLimit.x, 30); 
		if(moleTimeLimit.x >= 900) {
			// �̹� ����� ����
			MoleCatchingGame_RankingTop3.startRankingTop3();
			timeOK = false;
			MoleCatchingGame_Frame.center.remove(MoleCatchingGame_Frame.game);
			MoleCatchingGame_Frame.center.add(MoleCatchingGame_Frame.rank);
			MoleCatchingGame_Frame.center.updateUI();
			
			
		}
		gradient = new GradientPaint(moleTimeLimit.stx, moleTimeLimit.sty, startColor, moleTimeLimit.edx, moleTimeLimit.edy, endColor, true);
		// ���� �ð� ����
		g2.setFont(new Font("����", Font.BOLD, 20));
		g2.setStroke(new BasicStroke(5));
		g2.drawString("���� �ð�", 50, 50);
		g2.setStroke(new BasicStroke(0));
		// �ð� ���� �� üũ���ִ� ��
		g2.setColor(Color.gray);
		g2.draw(timeGone); // ������ �ð�
		g2.fill(timeGone);
		g2.setPaint(gradient);
		g2.draw(timeLeft); // ���� �ð�
		g2.fill(timeLeft);

	}

}
