import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JLabel;

import java.util.Map.Entry;

public class RankingTop3 extends Thread {
	// 파일에서 불러온 값 저장
	String nameArr[] = new String[3]; // 이름 저장 배열
	int[] scoreArr = new int[3]; // 점수 저장 배열
	// 순위 비교용 배열 
	String nameArrRank[] = new String[4]; // 이름 저장 배열
	int[] scoreArrRank = new int[4]; // 점수 저장 배열
	
	int nowScore = MoleCatchingGame_Score.moleTotalScore; 
	// 총 점수 있는 것 담아옴★★★★영선님 여기 이름 바꾸면 됩니다!!
	String nowName = MoleCatchingGame_Intro.userName; 
	// 유저 이름 담아옴 ★★★★영선님 여기 이름 바꾸면 됩니다!!
	boolean doit = true;
	
	File f = new File("MoleRanking.txt");
	// 이름 점수 저장될 텍스트 파일 ★★★★영선님 여기 이름 바꾸면 됩니다!!
	static BufferedWriter w = null;
	static BufferedReader r = null;
	HashMap<String, String> map = new HashMap<String, String>();

	JLabel one, two, three;
	public RankingTop3(JLabel one, JLabel two, JLabel three) {
		this.one = one;
		this.two = two;
		this.three = three;
	}

	public void run() {
		while (doit) {
			 nowScore = MoleCatchingGame_Score.moleTotalScore;
			// ★★★★영선님 여기 이름 바꾸면 됩니다!!
			 nowName = MoleCatchingGame_Intro.userName;
			// ★★★★영선님 여기 이름 바꾸면 됩니다!!
//////////////////
			// 랭킹 계산하기
			takeRanking(); // 이전 랭킹 값을 가지고옴
			/////////////////
			// Arr에 값 들어간 상태
			for (int i = 0; i < nameArrRank.length; i++) {
				if (i<=2) {
					nameArrRank[i] = nameArr[i];
				scoreArrRank[i] = scoreArr[i];
				}else if (i==3) {
					nameArrRank[i] = nowName;
					scoreArrRank[i] = nowScore;
				}
			}
			// ArrRank에 4개의 데이터들 들어있음
			// 내림차순으로 정렬 준비
			Map<String, Integer> testMap = new HashMap<String, Integer>();

			// Map에 데이터 추가
			for (int i = 0; i < nameArrRank.length; i++) {
				testMap.put(nameArrRank[i], scoreArrRank[i]);

			}
			// Map.Entry 리스트 작성
			List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(testMap.entrySet());

			// 비교함수 Comparator를 사용하여 내림 차순으로 정렬
			Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
				// compare로 값을 비교
				public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
					// 내림 차순으로 정렬
					return obj2.getValue().compareTo(obj1.getValue());
				}
			});

			System.out.println("내림 차순 정렬");
			// 결과 출력
			int i = 0;

			for (Entry<String, Integer> entry : list_entries) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
				// 결과 다시 배열에 업데이트
				nameArrRank[i] = entry.getKey();
				scoreArrRank[i] = entry.getValue();
				System.out.println("업데이트된 값 : " + nameArrRank[i] + "=" + scoreArrRank[i]);
				i++;

			}
			
			//이제 3등만 필요하니까 나머지 버림
			for (int j = 0; j < nameArr.length; j++) {
				nameArr[j] = nameArrRank[j];
				scoreArr[j] = scoreArrRank[j];
			}
			
			/////////////////
			/*
			// 현재 것과 비교해서 등수 정해야 함.
			int changeIndex = 0;
			for (int j = 0; j < nameArr.length; j++) {
				if (nowScore > scoreArr[j]) {
					// 들어갈 자리를 찾으면 그 자리의 인덱스를 가지고 옴
					changeIndex = j;
					break;
				}
			}
			// 삽입할 자리를 알았으니 이제 삽입하고 뒤로 넘겨줘야 함
			String temps[] = new String[3];
			int tempi[] = new int[3];
			int temp = 0;
			for (int j = 0; j < nameArr.length; j++) {
				if (changeIndex == j) {
					// 삽입해야 하는 위치가 나왔으면 집어넣음
					temps[j] = nowName;
					tempi[j] = nowScore;
				} else {
					// 삽입해야하는 때가 아니면 정렬되어 있는 큰 수부터 집어넣음
					temps[j] = nameArr[temp];
					tempi[j] = scoreArr[temp];
					temp++; // temp는 Arr들 담당 인덱스
				}
			}
			for (int j = 0; j < nameArr.length; j++) {
				nameArr[j] = temps[j];
				scoreArr[j] = tempi[j];
				// 정렬한 것을 다시 집어넣어서 텍스트파일에 쓸 준비를 함
			}
			*/
			///////
			clearFile(); // 이전에 있던 파일 내용 지우고 삽입할 것임
			for (int j = 0; j < nameArr.length; j++) {
				insert(nameArr[j], scoreArr[j]);
				System.out.println("insert" + nameArr[j] + "=" + scoreArr[j]);

			}
//////////////////////////
			one.setText("1등: " + nameArr[0] + " - " + scoreArr[0] + "점");
			two.setText("2등: " + nameArr[1] + " - " + scoreArr[1] + "점");
			three.setText("3등: " + nameArr[2] + " - " + scoreArr[2] + "점");
			//////////
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doit=false;
		}

	}

	public void clearFile() {
		try {
			w = new BufferedWriter(new FileWriter("MoleRanking.txt"));
			// ★★★★영선님 여기 이름 바꾸면 됩니다!!
			w.close();
		} catch (IOException ie) {
			System.err.println("파일 입력 오류!!클리어파일");
		}
	}

	public void insert(String nameArr, int scoreArr) {
		try {
			w = new BufferedWriter(new FileWriter("MoleRanking.txt", true));
			// ★★★★영선님 여기 이름 바꾸면 됩니다!!
			w.write(nameArr + " ");

			w.write(scoreArr + "\r\n");
			w.close();
		} catch (IOException ie) {
			System.err.println("파일 입력 오류!!인서트");
		}
	}

	public void takeRanking() {
		// 이전 랭킹을 가지고 옴
		String s;
		String[] sArray;
		int i = 0;
		try {
			r = new BufferedReader(new FileReader("MoleRanking.txt"));
			// ★★★★영선님 여기 이름 바꾸면 됩니다!!
			while ((s = r.readLine()) != null) {
				sArray = s.split(" ");
				map.put(sArray[0], sArray[1]);
				System.out.println(sArray[0]);
			}
			Set<String> keylist = map.keySet();
			Iterator<String> itr = keylist.iterator();

			while (itr.hasNext()) {
				String name = itr.next();
				nameArr[i] = name;
				scoreArr[i] = Integer.parseInt(map.get(name));
				System.out.println("이름 : " + name + "\t - 점수: " + map.get(name));
				System.out.println(nameArr[i] + " - " + scoreArr[i]);
				i++;
			}
			r.close();
		} catch (IOException ie) {
			System.err.println("파일 오류!!테이크랭킹");
		}
	}
}
