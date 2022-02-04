package homework;
//Ctrl + Shift + F

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] absoluteFilePath) throws IOException {

		int c;  //����� ���� �������
		int s;  //������ ���� �������
		double u = 0;  
		double a = 0;
		ArrayList<String> CrossRim = new ArrayList<>(); //������ � ������ �������
		ArrayList<String> AB = new ArrayList<>();  //������ � �������� �������
		ArrayList<String> YesNo = new ArrayList<>();  //������ � "�������������" �������
		ArrayList<Double> percent = new ArrayList<>(); //������ � ����. ������ � �� ������ ��������
		ArrayList<Double> entrop = new ArrayList<>(); //������ � ��������� �� ������� ������ � ����

		
		//������, ����� ������� ������� ����
		StringTokenizer st1 = new StringTokenizer(readreadFile(absoluteFilePath), ";");
		String k = st1.nextToken();
		String n = st1.nextToken();

		c = Integer.parseInt(n);
		s = Integer.parseInt(k);

		int cs = c * s;  //��� ��������� ��� ����� �� ��� ������, ����� �� �� ����� ���������������� ����
		                 //� ��� ���������� �������� ���� ������� � ���������� cs � ���������� ����������
		                 //��. ���������� � �������

		List<String> list1 = Arrays.asList(readFile(absoluteFilePath, cs).split(";")); //������ �� ����� �������

		System.out.println(c);
		System.out.println(s);
        
		//��������� ������ �� ����� ������� �� ����� ������
		
		for (int d = 0; d < list1.size(); d = d + 3) {

			CrossRim.add((String) list1.get(d));
			AB.add((String) list1.get(d + 1));
			YesNo.add((String) list1.get(d + 2));
		}

		// System.out.println(list3);
		// System.out.println(list2);
		// System.out.println(list4);

		Agent.agents = new Agent[c][s];

		//"��������" �������
		
		int g = 0;
		for (int i = 0; i < Agent.agents.length; i++) {
			for (int j = 0; j < Agent.agents[i].length; j++) {
				if (CrossRim.get(g).equals("Cross")) {
					Agent.agents[i][j] = new Cross((String) YesNo.get(g), (String) AB.get(g), i, j);

				}
				if (CrossRim.get(g).equals("Rim")) {
					Agent.agents[i][j] = new Rim((String) YesNo.get(g), (String) AB.get(g), i, j);

				}
				if (CrossRim.get(g).equals("Whole")) {
					Agent.agents[i][j] = new Whole((String) YesNo.get(g), (String) AB.get(g), i, j);

				}
				if (CrossRim.get(g).equals("Stubborn")) {
					Agent.agents[i][j] = new Stubborn((String) YesNo.get(g), (String) AB.get(g), i, j);

				}
				g++;
			}
		}

		
		// ��������� �� 20 ���
		for (int y = 0; y < 20; y++) {

			// �� ������ ���� ����������: ����� ������� ������ � � ���� ����
			// � ������� �������� � ������ percent
			for (int i = 0; i < Agent.agents.length; i++) {
				for (int j = 0; j < Agent.agents[i].length; j++) {
					if (Agent.agents[i][j].getOpinion().equals("A")) {
						a = a + 1;
					}

				}
			}

			u = (a / (c * s)) * 100;
			percent.add(u);

			a = 0;
			u = 0;

			// ���������� �������, ������� �� ������ � ����������� ���� ������� ������
			for (int i = 0; i < Agent.agents.length; i++) {
				for (int j = 0; j < Agent.agents[i].length; j++) {
					Agent.agents[i][j].polling_neighbors();
				}

			}
			
			
			// ������� ������� � ������ �������, ������� ���������� � ����������� ���� ������� ������
			for (int i = 0; i < Agent.agents.length; i++) {
				for (int j = 0; j < Agent.agents[i].length; j++) {
					Agent.agents[i][j].count_neighbors();
				}

			}
			
			// �������� ������ 
			for (int i = 0; i < Agent.agents.length; i++) {
				for (int j = 0; j < Agent.agents[i].length; j++) {

					Agent.agents[i][j].change_opinion();
				}
			}
			
	

		}

		
		// ����� ���� ��� ������� ��������, � ������� �������� � ���� ������� ������
		for (int i = 0; i < Agent.agents.length; i++) {
			for (int j = 0; j < Agent.agents[i].length; j++) {
				Agent.agents[i][j].entr();
			}
		}
		
		// ������� ���� ������� � ���������� �� �������� � ������ entrop
		for (int i = 0; i < Agent.agents.length; i++) {
			for (int j = 0; j < Agent.agents[i].length; j++) {

				entrop.add(Agent.agents[i][j].getEntropia());
			}
		}
		
		System.out.println(percent);
		System.out.println(entrop);

		writeFile(percent, entrop);

	}

	static String readFile(String[] absoluteFilePath, int cs) throws IOException {

		// String aut = "";
		try (BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath[0]))) {
			StringBuilder content = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				if (line.startsWith("K")) {
					String con = line.substring(2, line.length());
					content.append(con);

				}
			}

			return content.toString();
		} catch (FileNotFoundException e) {

			System.out.println("���� �� ������!");
			String rand = "";

			for (int i = 0; i < cs; i++) {
				int min = 1;
				int max = 4;
				int CrossRim = (int) (Math.random() * (max - min + 1) + min);
				if (CrossRim == 1) {
					rand += "Cross;";
				}
				if (CrossRim == 2) {
					rand += "Rim;";
				}
				if (CrossRim == 3) {
					rand += "Whole;";
				}
				if (CrossRim == 4) {
					rand += "Stubborn;";
				}

				int min1 = 1;
				int max1 = 2;
				int YesNo = (int) (Math.random() * (max1 - min1 + 1) + min1);
				if (YesNo == 1) {
					rand += "Yes;";
				}
				if (YesNo == 2) {
					rand += "No;";
				}

				int min2 = 1;
				int max2 = 2;
				int AB = (int) (Math.random() * (max1 - min1 + 1) + min1);
				if (AB == 1) {
					rand += "A;";
				}
				if (AB == 2) {
					rand += "B;";
				}

			}

			return (rand);
		}

	}

	static String readreadFile(String[] absoluteFilePath) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath[0]))) {
			StringBuilder content = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				if (line.startsWith("S")) {
					String con = line.substring(2, line.length());
					content.append(con);

				}
			}

			return (content.toString());
		}

		catch (FileNotFoundException e) {
			int min = 3;
			int max = 6;
			int c = (int) (Math.random() * (max - min + 1) + min);
			int s = (int) (Math.random() * (max - min + 1) + min);

			String cc = String.valueOf(c);
			String ss = String.valueOf(s);
			System.out.println("���� �� ������!");
			return (cc + ";" + ss);
		}

	}

	static void writeFile(ArrayList<Double> percent, ArrayList<Double> entrop) throws IOException {

		String listString = "";
		List<String> strings = new ArrayList<String>();
		for (Double d : percent) {
			// Apply formatting to the string if necessary
			strings.add(d.toString());
		}

		for (String o : strings) {
			listString += o + "\t";
		}

		String listlistString = "";
		List<String> stringss = new ArrayList<String>();
		for (Double d : entrop) {
			// Apply formatting to the string if necessary
			stringss.add(d.toString());

		}

		for (String o : stringss) {
			if (o.equals("NaN")) {
				listlistString += "0" + "\t";
			} else {
				listlistString += o + "\t";
			}
		}

		try (FileWriter writer = new FileWriter("notes3.txt", false)) {
			// ������ ���� ������

			writer.write(listString);
			writer.write("\n");
			writer.write(listlistString);

			writer.flush();
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}

}
