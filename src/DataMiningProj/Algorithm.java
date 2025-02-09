package DataMiningProj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Algorithm {
	//placeholder
	// Calculates Jaccard similarity between two sets of features.
	private static double jaccardSimilarity(double[] a, double[] b) {
	    int intersection = 0, union = 0; // Counts shared features (intersection) and total unique features (union).
	    for (int i = 0; i < a.length; i++) { // Loop through each feature, ignoring the last column (wine rating).
	        if (a[i] == 1 || b[i] == 1) union++; // Count total occurrences of a feature in either instance.
	        if (a[i] == 1 && b[i] == 1) intersection++; // Count features that appear in both instances.
	    }
	    return union == 0 ? 0.0 : ((double) intersection / union); // Compute Jaccard similarity; 1.0 = identical, 0.0 = no common features.
	}
	// Writes classification results to a file.
	private static void writeResultsToFile(List<String> results, String filename) throws IOException {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
	        for (String line : results) {
	            writer.write(line);
	            writer.newLine();
	        }
	        writer.close();
	}
	
	//Read file
	public static Map<String, List<Integer>> readCSV(String filePath) {
        String line;
        Map<String, List<Integer>> test = new LinkedHashMap();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        	br.readLine();
            while ((line = br.readLine()) != null) {
            	List<Integer> temporary = new ArrayList<Integer>();
                String[] values = line.split(","); // Splitting CSV by commas
                for (int i = 0; i < values.length; i++) {
                	if (i != 0 && i != 1) {
                		temporary.add(Integer.parseInt(values[i]));
                	}
                }
                test.put(values[0], temporary);
            }
            
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return test;
    }
	
	public static void main(String[] args) {
		Map<String, List<Integer>> dataSet = readCSV("Testing dataset.csv");
		/*
		for (Map.Entry<String, List<Integer>> entry : dataSet.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        */
		
		
		
	}

}
