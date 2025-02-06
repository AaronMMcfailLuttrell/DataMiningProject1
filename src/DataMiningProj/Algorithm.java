package DataMiningProj;

public class Algorithm {
	//placeholder

	 // Compute the Jaccard Coefficient
    private static double jaccardCoefficient(double[] a, double[] b) {
        int intersection = 0, union = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == 1 || b[i] == 1) union++;
            if (a[i] == 1 && b[i] == 1) intersection++;
        }
        return union == 0 ? 0.0 : ((double) intersection / union); // Jaccard Coefficient
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
