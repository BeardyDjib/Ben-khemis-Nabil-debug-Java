package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

	}

	public List<String> getSymptoms	() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCount = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			if (symptomCount.containsKey(symptom)) {
				symptomCount.put(symptom, symptomCount.get(symptom) + 1);
			} else {
				symptomCount.put(symptom, 1);
			}
		}
		return symptomCount;
	}
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){
		return new TreeMap<>(symptoms);
	}
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
