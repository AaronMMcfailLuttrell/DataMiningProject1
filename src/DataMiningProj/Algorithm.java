package DataMiningProj;

public class Algorithm {
	//placeholder
// Calculates Jaccard similarity between two sets of features.
private static double jaccardSimilarity(double[] a, double[] b) {
    int intersection = 0, union = 0; // Counts shared features (intersection) and total unique features (union).
    for (int i = 0; i < a.length - 1; i++) { // Loop through each feature, ignoring the last column (wine rating).
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

}
