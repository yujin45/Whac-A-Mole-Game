import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class MoleCatchingGame_Frame extends JFrame implements ActionListener{
	JPanel top, bottom;
	public static JPanel center;
	// ★★★★intro에서 Frame에 접근해서 패널 제거하고 붙이고 업데이트하기 위한 public static★★★★★★★
	public static MoleCatchingGame_Intro intro;
	public static MoleCatchingGame_Game game;
	public static  MoleCatchingGame_RankingTop3 rank;
	JLabel titleImg, gameTitle, madeBy;
	String titleStr, madeByStr;
	ImageIcon gameTitleImg, homeImg;
	JButton homeBtn;
	
	public MoleCatchingGame_Frame(String title) {
		super(title);
		// 객체 생성할 때 Frame이름 부여
		setLayout(new BorderLayout());
		setSize(900, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X버튼 누르면 화면도 닫고 프로그램도 종료
		//위에 코드 아니면 아래 코드 넣어도 됨
		/*
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		*/
		// BorderLayout Frame에서
		// top(게임명), center(게임 실행창), bottom(홈버튼 등 부가 내용 넣을 곳)
		// Frame으로 만들면 홈버튼이 사실 의미가 있나 싶지만
		// 나중에 게임 선택창에서 어떤 게임 누르면 게임 선택창을 닫고(setVisible(false))
		// 게임 frame을 열고 홈버튼을 누르면 이 게임 frame을 닫고,
		// 다시 게임 선택창을 setVisible(true)로 하면 될듯.
		// 이러면 프레임 창이 많아지는 현상을 방지할 수 있다!!

		// top = 게임명, bottom = 홈버튼
		top = new JPanel(new GridLayout(1, 3));
		bottom = new JPanel();
		// center = 게임 방법 소개 패널, 게임 패널, 순위 패널이 들어감
		center = new JPanel(new GridLayout(1, 1));
		
		// 먼저 처음 상태는 게임 방법 소개 패널 => 게임명_Intro
		intro = new MoleCatchingGame_Intro();
		// Intro에서 여기에 접근해서 game을 켜줄거
		game = new MoleCatchingGame_Game();
		///
		rank = new  MoleCatchingGame_RankingTop3();
		
		////////////////////////////////////////////////////////
		// 패널 구역 확인용 색
		top.setBackground(Color.yellow);
		bottom.setBackground(Color.pink);
		
		// top 부분 
		titleStr = "두더지 게임"; // 게임 이름 적기 ★★★
		madeByStr= "(2012140 IT공학전공 정유진)";  //(학번 전공 이름) 적기 ★★★
		//▼ 이미지는 게임명TitleImg.png로 삽입 가로 100정도에 세로도 대충 100정도의 크기가 좋습니다! ★★★
		gameTitleImg = new ImageIcon("MoleCatchingGameTitleImg.png");
		
		titleImg = new JLabel(gameTitleImg);
		gameTitle = new JLabel(titleStr);
		gameTitle.setFont(new Font("굴림", Font.BOLD, 35));
		gameTitle.setHorizontalAlignment(JLabel.CENTER);
		madeBy = new JLabel(madeByStr);
		madeBy.setFont(new Font("굴림", Font.BOLD, 15));
		top.add(titleImg);
		top.add(gameTitle);
		top.add(madeBy);
		// bottom 부분
		homeImg = new ImageIcon("homeImg.png");
		homeBtn = new JButton(homeImg);
		homeBtn.setBackground(Color.pink);
		homeBtn.addActionListener(this);
		bottom.add(homeBtn);
		//////////////////////////////////////////////////
		center.add(intro);// center에 intro부분 붙이고
		// frame에 붙여줌
		add("North", top);
		add("Center", center);
		add("South", bottom);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==homeBtn) {
			// 게임 선택창 프레임을 보여주고 
			//▼ 영선님이 짠 게임 선택창 프레임으로 이름 바꾸고 주석 떼어내기
			// chooseGame_Frame.setVisible(true);
			// 여기 프레임은 닫음
			setVisible(false);
			// ▼ 이건 유진 필요 부분 삭제해도 됨!
			 MoleCatchingGame_Game.clip.stop();
			 //MoleCatchingGame_TimeLimit.moleTimeLimit.x = 10000; //종료 조건
			 MoleCatchingGame_TimeLimit.timeOK = false;
		}
		
	}
	
	

}
