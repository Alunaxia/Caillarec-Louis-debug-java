package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructor
	 * @param reader
	 * @param writer
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * List all symptoms from the file symptoms.txt
	 * @return
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 *
	 * @param symptoms Count symptoms.
	 * @return
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		Map<String, Integer> result = new TreeMap<>();

		for (String symptom : symptoms) {

			if (symptom != null) {
				symptom = symptom.trim().toLowerCase();

				result.put(symptom, result.getOrDefault(symptom, 0) + 1);
			}
		}

		return result;
	}

	/**
	 *
	 * @param symptoms Ordering symptoms if they weren't (They already should be).
	 * @return
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	/**
	 *
	 * @param symptoms writings Symptoms in result.out
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

	/**
	 *
	 * @param args Main Function redone.
	 */
	public static void main(String[] args) {

		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

		AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

		List<String> symptoms = analytics.getSymptoms();
		Map<String, Integer> counted = analytics.countSymptoms(symptoms);
		Map<String, Integer> sorted = analytics.sortSymptoms(counted);

		analytics.writeSymptoms(sorted);
	}
}