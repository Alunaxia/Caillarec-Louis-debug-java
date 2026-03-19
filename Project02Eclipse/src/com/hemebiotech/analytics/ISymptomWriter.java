package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data to a destination
 */
public interface ISymptomWriter {

    /**
     * Write the symptoms and their occurrences
     *
     * @param symptoms a map of symptoms with their counts
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}