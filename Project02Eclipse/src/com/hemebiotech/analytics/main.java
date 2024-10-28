package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("C:\\Users\\Nabil\\IdeaProjects\\Ben-khemis-Nabil-debug-Java\\Project02Eclipse\\symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);
        analyticsCounter.writeSymptoms(sortedSymptoms);
    }
}
