import java.awt.Color;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

public class MoleCatchingGame_Game extends JPanel{
	// 두더지 게임할 수 있는 패널

	MoleCatchingGame_9Moles molesPanel;
	MoleCatchingGame_Score scorePanel;
	static MoleCatchingGame_TimeLimit timeLimitPanel;
	File bgmFile;
	AudioInputStream audioStream;
	public static Clip clip;
	public MoleCatchingGame_Game() {
		setBackground(new Color(227, 245, 173));
		setLayout(null);
		molesPanel = new MoleCatchingGame_9Moles();
		molesPanel.setBounds(0, 80, 850,670);
		add(molesPanel);
		
		scorePanel = new MoleCatchingGame_Score();
		scorePanel.setBounds(885, 80, 200, 670);
		add(scorePanel);
		
		timeLimitPanel = new MoleCatchingGame_TimeLimit();
		timeLimitPanel.setBounds(0, 0, 1200, 80);
		add(timeLimitPanel);
		
		//오디오파일 열어서 실행하도록 학ㅁ
		bgmFile = new File("MoleBGM.wav");
		  try {
	            
			  audioStream = AudioSystem.getAudioInputStream(bgmFile);
	            clip = AudioSystem.getClip();
	            clip.open(audioStream);
	            clip.start();
	            
	        } catch(Exception e) {
	            
	            e.printStackTrace();
	        }
		
	}

}
