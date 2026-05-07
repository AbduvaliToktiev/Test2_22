package politeh.thirdcourse.spring.trpo;

// HelloApplication.java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Кнопка "Say Hello"
        Button btnHello = new Button("Say Hello");
        btnHello.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Сообщение");
            alert.setHeaderText(null);
            alert.setContentText("Say Hello");
            alert.showAndWait();
        });

        // Кнопка "Exit"
        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> primaryStage.close());

        // Настройка стилей
        btnHello.setStyle("-fx-font-size: 14px; -fx-padding: 10px;");
        btnExit.setStyle("-fx-font-size: 14px; -fx-padding: 10px;");

        // Компановка
        VBox root = new VBox(20, btnHello, btnExit);
        root.setStyle("-fx-padding: 30px; -fx-alignment: center;");

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Лабораторная работа №5 - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
