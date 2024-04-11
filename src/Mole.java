
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mole extends Thread implements MouseListener{
	// 두더지들
	int term, moleNum;
	JLabel moleL;
	ImageIcon up, mid, down;
	boolean midf; //false면 다음이 down true면 다음이 up
	public Mole(JLabel moleL, ImageIcon up,  ImageIcon down, ImageIcon mid, int moleNum) {
		this.moleL = moleL;
		this.up = up;
		this.down = down;
		this.mid = mid;
		this.moleNum = moleNum;
		moleL.addMouseListener(this);
		
	}

	public void run() {
		// run오버라이딩
		while (MoleCatchingGame_TimeLimit.timeOK) {
			// 나중에 time 오버되면 flag따라 멈추거나 등 할거임
			// + 홈화면으로 가도 스레드 끝나도록 해야함!!★★★
			// 임의의 수로 두더지가 나오는 타이밍의 term값을 잡아줌
			term = (int) (Math.random() * 50); // 0~4 임의의 수
			// 위치는 그 자리 그대로에서 이미지만 변하게 함
			if (moleL.getIcon() == up) {
				moleL.setIcon(mid);
				midf = false;
			
			}else if(moleL.getIcon() == mid) {
				if (midf) {
					moleL.setIcon(up);
					 MoleCatchingGame_Score.moleTotalUp +=1; //UP되는것 체크
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
			// sleep으로 쉬었다가 함
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
				System.out.println(moleNum+"클릭됨");
				// 점수 얻기
				MoleCatchingGame_Score.moleTotalScore += 10;
				moleL.setIcon(down);
				midf = true; // down다음 올라가게 함
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
