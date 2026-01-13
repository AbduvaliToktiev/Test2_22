package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("Using Path.readsLines()");
        try {
            List<String> fileData = Files.readAllLines(Paths.get("Токио.txt"));

            System.out.println("Input: ");
            fileData.forEach(System.out::println);

            System.out.println("Output: ");
            fileData.stream()
                    .mapToLong(
                            s -> Arrays.stream(s.split(","))
                                    .mapToLong(Long::parseLong).max()
                                    .getAsLong()).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
