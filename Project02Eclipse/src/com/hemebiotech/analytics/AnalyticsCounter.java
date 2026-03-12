package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader(
				new FileReader("./symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;

				headacheCount++; // Correction : incrémentation de la valeur
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rash")) { // Correction d'une faute de frappe rush pour rash
				rashCount++;
			}
			else if (line.equals("pupils")) { // Correction de contains en le remplaçant par equals plus adapté et correspondant aux autres conditions
				pupilCount++;
			}

			line = reader.readLine();
		}

		reader.close();

		FileWriter writer = new FileWriter("./result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
