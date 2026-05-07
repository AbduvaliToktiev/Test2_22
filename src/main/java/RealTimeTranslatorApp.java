import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class RealTimeTranslatorApp {
    private static final String TRANSLATE_API_URL =
            "https://translate.googleapis.com/translate_a/single?client=gtx&sl=ru&tl=kk&dt=t&q=";

    public static void main(String[] args) {
        String inputFilePath = "cityNameEn.txt";  // Input file with Russian city names
        String outputFilePath = "cities_kk.txt"; // Output file for Kazakh city names

        translateCitiesFromFile(inputFilePath, outputFilePath);
    }

    public static void translateCitiesFromFile(String inputFilePath, String outputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String cityNameRu;
            while ((cityNameRu = reader.readLine()) != null) {
                // Translate each city name
                String translatedName = translateCityName(cityNameRu);
                if (translatedName != null) {
                    // Write the translated name to the output file
                    writer.write(translatedName);
                } else {
                    // Handle translation failure (write the original name or a placeholder)
                    writer.write("Translation failed for: " + cityNameRu);
                }
                writer.newLine(); // Move to the next line
            }

            System.out.println("Translation completed. Output saved to " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Error reading/writing files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String translateCityName(String cityNameRu) {
        try {
            // URL encode the city name
            String encodedCityName = URLEncoder.encode(cityNameRu, StandardCharsets.UTF_8);
            String apiUrl = TRANSLATE_API_URL + encodedCityName;

            // Create a connection to the API
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Read the response
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                // Parse the response to extract the translated text
                return parseTranslationResponse(response.toString());
            }

        } catch (Exception e) {
            System.err.println("Failed to translate city: " + cityNameRu);
            e.printStackTrace();
            return null;
        }
    }

    private static String parseTranslationResponse(String response) {
        try {
            // The response is a JSON-like array, extract the translated text
            int startIndex = response.indexOf("\"") + 1;
            int endIndex = response.indexOf("\"", startIndex);
            return response.substring(startIndex, endIndex);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
