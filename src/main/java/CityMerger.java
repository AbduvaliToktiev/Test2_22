import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CityMerger {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "города_KZ_на_русском.txt"; // Path to your input file
        String outputFilePath = "output.txt"; // Path for the output file (optional)

        try {
            // Read all lines from the file
            BufferedReader reader = Files.newBufferedReader(Paths.get(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

            String line;
            while ((line = reader.readLine()) != null) {
                // Split each line into words
                String[] words = line.split("\\s+");

                // Convert the first letter of each word to uppercase
                for (int i = 0; i < words.length; i++) {
                    if (words[i].length() > 0) {
                        words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
                    }
                }

                // Join the words back into a line
                String resultLine = String.join(" ", words);

                // Write the result to the output file
                writer.write(resultLine);
                writer.newLine(); // Move to the next line in the output file
            }

            // Close the readers and writers
            reader.close();
            writer.close();

            System.out.println("Processing complete. Output saved to: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred while reading or writing the file: " + e.getMessage());
        }
    }
}