package politeh.thirdcourse.spring.trpo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter extends JFrame {
    private JTextField txtData;
    private JTextField txtCell;
    private JTextArea txtOutput;

    public ExcelWriter() {
        setTitle("Лабораторная работа №4 - Работа с Excel");
        setSize(550, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Данные для записи"));

        inputPanel.add(new JLabel("Значение:"));
        txtData = new JTextField("Тестовые данные");
        inputPanel.add(txtData);

        inputPanel.add(new JLabel("Номер строки (0-999):"));
        JTextField txtRow = new JTextField("0");
        inputPanel.add(txtRow);

        inputPanel.add(new JLabel("Номер столбца (0-999):"));
        JTextField txtCol = new JTextField("0");
        inputPanel.add(txtCol);

        JButton btnWriteExcel = new JButton("Записать в Excel");
        btnWriteExcel.addActionListener(e -> {
            try {
                int row = Integer.parseInt(txtRow.getText());
                int col = Integer.parseInt(txtCol.getText());
                writeToExcel(row, col);
            } catch (NumberFormatException ex) {
                txtOutput.setText("Ошибка: номер строки и столбца должны быть числами!");
            }
        });

        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtOutput);
        scroll.setBorder(BorderFactory.createTitledBorder("Результат"));

        add(inputPanel, BorderLayout.NORTH);
        add(btnWriteExcel, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void writeToExcel(int rowNum, int colNum) {
        String data = txtData.getText();
        if (data.isEmpty()) data = "Тестовые данные";

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Данные");

            // Создаём строку, если её нет
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }

            // Создаём ячейку и записываем данные
            Cell cell = row.createCell(colNum);
            cell.setCellValue(data);

            // Стиль для ячейки (фон)
            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cell.setCellStyle(style);

            // Автоширина столбца
            sheet.autoSizeColumn(colNum);

            // Запись в файл
            String fileName = "output_" + System.currentTimeMillis() + ".xlsx";
            try (FileOutputStream out = new FileOutputStream(fileName)) {
                workbook.write(out);
            }

            txtOutput.setText("Данные успешно записаны в файл: " + fileName + "\n");
            txtOutput.append("Значение: '" + data + "' записано в ячейку [строка " + rowNum + ", столбец " + colNum + "]\n");
            txtOutput.append("Файл сохранён в папке проекта");

        } catch (IOException ex) {
            txtOutput.setText("Ошибка: " + ex.getMessage() + "\n");
            txtOutput.append("Проверьте права на запись в папку проекта");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ExcelWriter::new);
    }
}