
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mole extends Thread implements MouseListener{
	// �δ�����
	int term, moleNum;
	JLabel moleL;
	ImageIcon up, mid, down;
	boolean midf; //false�� ������ down true�� ������ up
	public Mole(JLabel moleL, ImageIcon up,  ImageIcon down, ImageIcon mid, int moleNum) {
		this.moleL = moleL;
		this.up = up;
		this.down = down;
		this.mid = mid;
		this.moleNum = moleNum;
		moleL.addMouseListener(this);
		
	}

	public void run() {
		// run�������̵�
		while (MoleCatchingGame_TimeLimit.timeOK) {
			// ���߿� time �����Ǹ� flag���� ���߰ų� �� �Ұ���
			// + Ȩȭ������ ���� ������ �������� �ؾ���!!�ڡڡ�
			// ������ ���� �δ����� ������ Ÿ�̹��� term���� �����
			term = (int) (Math.random() * 50); // 0~4 ������ ��
			// ��ġ�� �� �ڸ� �״�ο��� �̹����� ���ϰ� ��
			if (moleL.getIcon() == up) {
				moleL.setIcon(mid);
				midf = false;
			
			}else if(moleL.getIcon() == mid) {
				if (midf) {
					moleL.setIcon(up);
					 MoleCatchingGame_Score.moleTotalUp +=1; //UP�Ǵ°� üũ
				}else {
					moleL.setIcon(down);
				}
				
			}else if(moleL.getIcon() == down) {
				midf = true;
				try {
					sleep(500*term);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				moleL.setIcon(mid);
			}
			// sleep���� �����ٰ� ��
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == moleL) {
			
			if (moleL.getIcon() != down) {
				System.out.println(moleNum+"Ŭ����");
				// ���� ���
				MoleCatchingGame_Score.moleTotalScore += 10;
				moleL.setIcon(down);
				midf = true; // down���� �ö󰡰� ��
				System.out.println(MoleCatchingGame_Score.moleTotalScore);
			
				
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
