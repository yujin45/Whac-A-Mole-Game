import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class MoleCatchingGame_Frame extends JFrame implements ActionListener{
	JPanel top, bottom;
	public static JPanel center;
	// �ڡڡڡ�intro���� Frame�� �����ؼ� �г� �����ϰ� ���̰� ������Ʈ�ϱ� ���� public static�ڡڡڡڡڡڡ�
	public static MoleCatchingGame_Intro intro;
	public static MoleCatchingGame_Game game;
	public static  MoleCatchingGame_RankingTop3 rank;
	JLabel titleImg, gameTitle, madeBy;
	String titleStr, madeByStr;
	ImageIcon gameTitleImg, homeImg;
	JButton homeBtn;
	
	public MoleCatchingGame_Frame(String title) {
		super(title);
		// ��ü ������ �� Frame�̸� �ο�
		setLayout(new BorderLayout());
		setSize(900, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X��ư ������ ȭ�鵵 �ݰ� ���α׷��� ����
		//���� �ڵ� �ƴϸ� �Ʒ� �ڵ� �־ ��
		/*
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		*/
		// BorderLayout Frame����
		// top(���Ӹ�), center(���� ����â), bottom(Ȩ��ư �� �ΰ� ���� ���� ��)
		// Frame���� ����� Ȩ��ư�� ��� �ǹ̰� �ֳ� ������
		// ���߿� ���� ����â���� � ���� ������ ���� ����â�� �ݰ�(setVisible(false))
		// ���� frame�� ���� Ȩ��ư�� ������ �� ���� frame�� �ݰ�,
		// �ٽ� ���� ����â�� setVisible(true)�� �ϸ� �ɵ�.
		// �̷��� ������ â�� �������� ������ ������ �� �ִ�!!

		// top = ���Ӹ�, bottom = Ȩ��ư
		top = new JPanel(new GridLayout(1, 3));
		bottom = new JPanel();
		// center = ���� ��� �Ұ� �г�, ���� �г�, ���� �г��� ��
		center = new JPanel(new GridLayout(1, 1));
		
		// ���� ó�� ���´� ���� ��� �Ұ� �г� => ���Ӹ�_Intro
		intro = new MoleCatchingGame_Intro();
		// Intro���� ���⿡ �����ؼ� game�� ���ٰ�
		game = new MoleCatchingGame_Game();
		///
		rank = new  MoleCatchingGame_RankingTop3();
		
		////////////////////////////////////////////////////////
		// �г� ���� Ȯ�ο� ��
		top.setBackground(Color.yellow);
		bottom.setBackground(Color.pink);
		
		// top �κ� 
		titleStr = "�δ��� ����"; // ���� �̸� ���� �ڡڡ�
		madeByStr= "(2012140 IT�������� ������)";  //(�й� ���� �̸�) ���� �ڡڡ�
		//�� �̹����� ���Ӹ�TitleImg.png�� ���� ���� 100������ ���ε� ���� 100������ ũ�Ⱑ �����ϴ�! �ڡڡ�
		gameTitleImg = new ImageIcon("MoleCatchingGameTitleImg.png");
		
		titleImg = new JLabel(gameTitleImg);
		gameTitle = new JLabel(titleStr);
		gameTitle.setFont(new Font("����", Font.BOLD, 35));
		gameTitle.setHorizontalAlignment(JLabel.CENTER);
		madeBy = new JLabel(madeByStr);
		madeBy.setFont(new Font("����", Font.BOLD, 15));
		top.add(titleImg);
		top.add(gameTitle);
		top.add(madeBy);
		// bottom �κ�
		homeImg = new ImageIcon("homeImg.png");
		homeBtn = new JButton(homeImg);
		homeBtn.setBackground(Color.pink);
		homeBtn.addActionListener(this);
		bottom.add(homeBtn);
		//////////////////////////////////////////////////
		center.add(intro);// center�� intro�κ� ���̰�
		// frame�� �ٿ���
		add("North", top);
		add("Center", center);
		add("South", bottom);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==homeBtn) {
			// ���� ����â �������� �����ְ� 
			//�� �������� § ���� ����â ���������� �̸� �ٲٰ� �ּ� �����
			// chooseGame_Frame.setVisible(true);
			// ���� �������� ����
			setVisible(false);
			// �� �̰� ���� �ʿ� �κ� �����ص� ��!
			 MoleCatchingGame_Game.clip.stop();
			 //MoleCatchingGame_TimeLimit.moleTimeLimit.x = 10000; //���� ����
			 MoleCatchingGame_TimeLimit.timeOK = false;
		}
		
	}
	
	

}
