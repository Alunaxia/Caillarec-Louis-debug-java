package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String args[]) {
		try (
				FileWriter writer = new FileWriter("./result.out");
				BufferedReader reader = new BufferedReader(new FileReader("./symptoms.txt"));
				/**
				 * Try with ressources here to handle the case if the exception happens and to still be able to close it.
				 */
				){
			String line = reader.readLine();
			while (line != null) {
				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					/**
					 * Correction to add an incrementation on the variable used to write on the file. Remove the other variable useless here.
					 */
				} else if (line.equals("rash")) {
					/**
					 * Correction of rush by rash that explains why nothing was found.
					 */
					rashCount++;
				} else if (line.contains("pupils")) {
					pupilCount++;
				}

				line = reader.readLine();
			}
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
		} catch (Exception e) {
			System.out.println("Erreur lors du traitement du fichier : " + e.getMessage());
			/**
			 * Exception handled by this try / catch
			 */
		}
	}
}
