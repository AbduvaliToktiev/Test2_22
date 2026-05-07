package politeh.thirdcourse.spring.trpo;

// WordWriter.java
import org.apache.poi.xwpf.usermodel.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordWriter extends JFrame {
    private JTextField txtText;
    private JTextArea txtOutput;

    public WordWriter() {
        setTitle("Лабораторная работа №4 - Работа с Word");
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createTitledBorder("Текст для вставки"));
        txtText = new JTextField(30);
        inputPanel.add(txtText);

        JButton btnWriteWord = new JButton("Создать Word документ");
        btnWriteWord.addActionListener(e -> writeToWord());

        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtOutput);
        scroll.setBorder(BorderFactory.createTitledBorder("Результат"));

        add(inputPanel, BorderLayout.NORTH);
        add(btnWriteWord, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void writeToWord() {
        String text = txtText.getText();
        if (text.isEmpty()) text = "Привет мир! Это документ из Java программы.";

        try (XWPFDocument document = new XWPFDocument()) {
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(text);
            run.setFontSize(17);
            run.setBold(true);

            FileOutputStream out = new FileOutputStream("output.docx");
            document.write(out);
            out.close();

            txtOutput.setText("Документ Word успешно создан: output.docx\n");
            txtOutput.append("Содержимое: " + text);

        } catch (IOException ex) {
            txtOutput.setText("Ошибка: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new WordWriter();
    }
}