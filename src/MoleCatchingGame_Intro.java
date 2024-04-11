import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoleCatchingGame_Intro extends JPanel implements ActionListener {
	// �ڡڡڡڡڡڡڡڡ� class�� = > ���Ӹ�_Intro

	ImageIcon gameIntroIC;
	Image gameIntro;
	JButton startBtn, okBtn;
	Font dfont;
	JDialog inputUserName;
	JPanel inputNameP;
	JLabel inputNameL;
	TextField tf;
	public static String userName;

	public MoleCatchingGame_Intro() {
		setBackground(Color.white);
		setLayout(null);
		// �ڡڡڡڡڡڡڡڡڡڡڿ�����! �Ʒ� 1�� ���� ������ �������ּ���ڡڡڡڡڡڡڡڡڡڡڡ�
		// ���� ������ �̹����� ���� ���Ӹ�IntroImg.png�������� �Ʒ��� ���� �ڡڡ�
		gameIntroIC = new ImageIcon("MoleCatchingGameIntroImg.png");
		
		gameIntro = gameIntroIC.getImage();

		startBtn = new JButton("�����ϱ�");
		startBtn.addActionListener(this);
		startBtn.setFont(new Font("����", Font.BOLD, 30));
		startBtn.setBackground(new Color(255, 245, 233)); // ��ư ��
		startBtn.setBounds(450, 550, 200, 100); // ��ư ��ġ, ũ��
		add(startBtn);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// ���� ��� �Ұ� �̹����� ������ �����ؼ� �׷���
		g2.drawImage(gameIntro, 0, 0, 1100, 750, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startBtn) {
			// ���� ��ư ������ �̸� �Է��ϰ� Ȯ�� ������ ���۵ǰ� ���̾�α� â �����
			inputUserName = new JDialog(); // �����
			inputUserName.setLayout(new GridLayout(1, 1));
			dfont = new Font("����", Font.BOLD, 20);
			inputNameP = new JPanel();
			inputNameP.setLayout(new GridLayout(3, 1));
			inputNameL = new JLabel("�г����� �Է����ּ���(�������)");
			inputNameL.setHorizontalAlignment(JLabel.CENTER);
			inputNameL.setFont(dfont);
			tf = new TextField(10); // 10���ڱ��� �Է� ����
			tf.addActionListener(this);
			
			// �ڡڡ�  �念������ ���� ������ �̷������� ������� �ٲ��ּ���!�ڡڡڡڡڡڡڡڡ�
			tf.setText("�δ���_������"); 
			tf.setFont(dfont);
			inputNameP.add(inputNameL);
			inputNameP.add(tf);
			inputNameP.setBackground(new Color(233, 255, 111));
			// inputUserName.add("Center", inputNameP);

			okBtn = new JButton("Ȯ��");
			okBtn.setFont(dfont);
			okBtn.setBackground(Color.pink);
			okBtn.addActionListener(this);
			// inputUserName.add("South", okBtn);
			inputNameP.add(okBtn);
			inputUserName.add(inputNameP);
			inputUserName.setTitle("�г��� �Է�");
			inputUserName.setSize(450, 150);
			inputUserName.setVisible(true);

		} else if (e.getSource() == okBtn) {
			// Ȯ�ι�ư ������ �г��� �Էµƴ��� Ȯ���ؾ���
			userName = tf.getText();
			if (userName.equals("")) {
				// �г��� ������ �ٽ� �Է��ش޶� �ϱ�
				System.out.println("�̸� �Է� ����");
				tf.setText("�г��� �ٽ� �Է����ּ���(�������)");
			} else {
				// �ڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�Frame�� �����ؼ� �г� �����ϰ� ���̰� ������Ʈ�ڿ�����class�̸����� �ٲ��ּ���ڡڡڡڡڡڡڡ�
				MoleCatchingGame_Frame.center.remove(MoleCatchingGame_Frame.intro);
				MoleCatchingGame_Frame.center.add(MoleCatchingGame_Frame.game);
				MoleCatchingGame_Frame.center.updateUI();
				System.out.println(userName);
				// ���� ȭ������ �г� ��ü�ϰ� ���̾�α� â �ݱ�
				inputUserName.setVisible(false); // ���̾�α� �� ���̰� ����
				
				// �ڡڡڡڡڡڡڡ� �� �κ��� ������ �����忡 �°� ���� �Ǵ� �κ�!�ڡڡڡڡڡڡڡڡ�
				// �̸� ������ ������� �����ϵ��� ��. 
				MoleCatchingGame_9Moles.start9Moles(); // 9x9 �δ����� ������
				MoleCatchingGame_Score.startMoleScore(); // score üũ ������
				MoleCatchingGame_TimeLimit.startTimeLimit(MoleCatchingGame_Game.timeLimitPanel);// �ð� ���� ������
			
			}

		}

	}
}
