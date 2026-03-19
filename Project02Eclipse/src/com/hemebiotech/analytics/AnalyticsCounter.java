package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String args[]) {

		Map<String, Integer> symptoms = new TreeMap<>();

		try (
				FileWriter writer = new FileWriter("./result.out");
				BufferedReader reader = new BufferedReader(new FileReader("./symptoms.txt"));
				/**
				 * Try with ressources here to handle the case if the exception happens and to still be able to close it.
				 */
				){
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println("symptom from file: " + line);
				symptoms.put(line, symptoms.getOrDefault(line, 0) + 1);
				/**
				 * Reading results from symptoms.txt
				 */
			}
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
				/**
				 * Writing results in the file
				 */
			}
		} catch (Exception e) {
			System.out.println("Erreur lors du traitement du fichier : " + e.getMessage());
			/**
			 * Exception handled by this try / catch
			 */
		}
	}
}
