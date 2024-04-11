import java.awt.Color;

import javax.swing.JPanel;

public class MoleTimeLimit extends Thread {
	int x, stx, sty, edx, edy;
	JPanel app;
	public MoleTimeLimit(JPanel app, int x, int stx, int sty, int edx, int edy) {
		this.app = app;
		this.x =x;
		this.stx = stx;
		this.sty = sty;
		this.edx = edx;
		this.edy = edy;
	}

	public void run() {
		while (x<=700) {
			stx += 50;
			sty += 50;
			edx += 50;
			edy += 50;
			x += 10;
			app.repaint();
			
			try {
				sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
