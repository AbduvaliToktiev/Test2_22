import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws IOException {
        String message = "User already exists";
        Path path = Paths.get("message.txt");

        Files.writeString(path, message, StandardCharsets.ISO_8859_1);
        System.out.println("???? ??????? ? ISO-8859-1");
    }
}
