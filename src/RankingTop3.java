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
	// ���Ͽ��� �ҷ��� �� ����
	String nameArr[] = new String[3]; // �̸� ���� �迭
	int[] scoreArr = new int[3]; // ���� ���� �迭
	// ���� �񱳿� �迭 
	String nameArrRank[] = new String[4]; // �̸� ���� �迭
	int[] scoreArrRank = new int[4]; // ���� ���� �迭
	
	int nowScore = MoleCatchingGame_Score.moleTotalScore; 
	// �� ���� �ִ� �� ��ƿȡڡڡڡڿ����� ���� �̸� �ٲٸ� �˴ϴ�!!
	String nowName = MoleCatchingGame_Intro.userName; 
	// ���� �̸� ��ƿ� �ڡڡڡڿ����� ���� �̸� �ٲٸ� �˴ϴ�!!
	boolean doit = true;
	
	File f = new File("MoleRanking.txt");
	// �̸� ���� ����� �ؽ�Ʈ ���� �ڡڡڡڿ����� ���� �̸� �ٲٸ� �˴ϴ�!!
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
			// �ڡڡڡڿ����� ���� �̸� �ٲٸ� �˴ϴ�!!
			 nowName = MoleCatchingGame_Intro.userName;
			// �ڡڡڡڿ����� ���� �̸� �ٲٸ� �˴ϴ�!!
//////////////////
			// ��ŷ ����ϱ�
			takeRanking(); // ���� ��ŷ ���� �������
			/////////////////
			// Arr�� �� �� ����
			for (int i = 0; i < nameArrRank.length; i++) {
				if (i<=2) {
					nameArrRank[i] = nameArr[i];
				scoreArrRank[i] = scoreArr[i];
				}else if (i==3) {
					nameArrRank[i] = nowName;
					scoreArrRank[i] = nowScore;
				}
			}
			// ArrRank�� 4���� �����͵� �������
			// ������������ ���� �غ�
			Map<String, Integer> testMap = new HashMap<String, Integer>();

			// Map�� ������ �߰�
			for (int i = 0; i < nameArrRank.length; i++) {
				testMap.put(nameArrRank[i], scoreArrRank[i]);

			}
			// Map.Entry ����Ʈ �ۼ�
			List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(testMap.entrySet());

			// ���Լ� Comparator�� ����Ͽ� ���� �������� ����
			Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
				// compare�� ���� ��
				public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
					// ���� �������� ����
					return obj2.getValue().compareTo(obj1.getValue());
				}
			});

			System.out.println("���� ���� ����");
			// ��� ���
			int i = 0;

			for (Entry<String, Integer> entry : list_entries) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
				// ��� �ٽ� �迭�� ������Ʈ
				nameArrRank[i] = entry.getKey();
				scoreArrRank[i] = entry.getValue();
				System.out.println("������Ʈ�� �� : " + nameArrRank[i] + "=" + scoreArrRank[i]);
				i++;

			}
			
			//���� 3� �ʿ��ϴϱ� ������ ����
			for (int j = 0; j < nameArr.length; j++) {
				nameArr[j] = nameArrRank[j];
				scoreArr[j] = scoreArrRank[j];
			}
			
			/////////////////
			/*
			// ���� �Ͱ� ���ؼ� ��� ���ؾ� ��.
			int changeIndex = 0;
			for (int j = 0; j < nameArr.length; j++) {
				if (nowScore > scoreArr[j]) {
					// �� �ڸ��� ã���� �� �ڸ��� �ε����� ������ ��
					changeIndex = j;
					break;
				}
			}
			// ������ �ڸ��� �˾����� ���� �����ϰ� �ڷ� �Ѱ���� ��
			String temps[] = new String[3];
			int tempi[] = new int[3];
			int temp = 0;
			for (int j = 0; j < nameArr.length; j++) {
				if (changeIndex == j) {
					// �����ؾ� �ϴ� ��ġ�� �������� �������
					temps[j] = nowName;
					tempi[j] = nowScore;
				} else {
					// �����ؾ��ϴ� ���� �ƴϸ� ���ĵǾ� �ִ� ū ������ �������
					temps[j] = nameArr[temp];
					tempi[j] = scoreArr[temp];
					temp++; // temp�� Arr�� ��� �ε���
				}
			}
			for (int j = 0; j < nameArr.length; j++) {
				nameArr[j] = temps[j];
				scoreArr[j] = tempi[j];
				// ������ ���� �ٽ� ����־ �ؽ�Ʈ���Ͽ� �� �غ� ��
			}
			*/
			///////
			clearFile(); // ������ �ִ� ���� ���� ����� ������ ����
			for (int j = 0; j < nameArr.length; j++) {
				insert(nameArr[j], scoreArr[j]);
				System.out.println("insert" + nameArr[j] + "=" + scoreArr[j]);

			}
//////////////////////////
			one.setText("1��: " + nameArr[0] + " - " + scoreArr[0] + "��");
			two.setText("2��: " + nameArr[1] + " - " + scoreArr[1] + "��");
			three.setText("3��: " + nameArr[2] + " - " + scoreArr[2] + "��");
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
			// �ڡڡڡڿ����� ���� �̸� �ٲٸ� �˴ϴ�!!
			w.close();
		} catch (IOException ie) {
			System.err.println("���� �Է� ����!!Ŭ��������");
		}
	}

	public void insert(String nameArr, int scoreArr) {
		try {
			w = new BufferedWriter(new FileWriter("MoleRanking.txt", true));
			// �ڡڡڡڿ����� ���� �̸� �ٲٸ� �˴ϴ�!!
			w.write(nameArr + " ");

			w.write(scoreArr + "\r\n");
			w.close();
		} catch (IOException ie) {
			System.err.println("���� �Է� ����!!�μ�Ʈ");
		}
	}

	public void takeRanking() {
		// ���� ��ŷ�� ������ ��
		String s;
		String[] sArray;
		int i = 0;
		try {
			r = new BufferedReader(new FileReader("MoleRanking.txt"));
			// �ڡڡڡڿ����� ���� �̸� �ٲٸ� �˴ϴ�!!
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
				System.out.println("�̸� : " + name + "\t - ����: " + map.get(name));
				System.out.println(nameArr[i] + " - " + scoreArr[i]);
				i++;
			}
			r.close();
		} catch (IOException ie) {
			System.err.println("���� ����!!����ũ��ŷ");
		}
	}
}
