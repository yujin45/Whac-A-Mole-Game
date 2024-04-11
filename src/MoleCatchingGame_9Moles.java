import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoleCatchingGame_9Moles extends JPanel {
	static Mole[] moles = new Mole[9];
	static JLabel[] moleL = new JLabel[9];
	int score = 0;
	static ImageIcon back, up, down, mid;

	public MoleCatchingGame_9Moles() {
		setSize(900, 750);
		setBackground(new Color(255, 214, 168));
		setLayout(new GridLayout(3, 3));

		up = new ImageIcon("MoleUp.png");
		down = new ImageIcon("hole.png");
		mid = new ImageIcon("MoleMid.png");
		////// 두더지 3x3만들기
		for (int i = 0; i < 9; i++) {
			moleL[i] = new JLabel(down); // 초기에는 다 down인 상태
			add(moleL[i]);
		}

	}

	public static void start9Moles() {

		////// 두더지 3x3만들기
		for (int i = 0; i < 9; i++) {
			moles[i] = new Mole(moleL[i], up, down, mid, i);
		}

		////// 두더지 3x3 thread 시작
		for (int i = 0; i < 9; i++) {
			moles[i].start();
		}

	}

}
