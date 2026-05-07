package politeh.thirdcourse.spring.trpo;// LinearAlgorithm.java

import javax.swing.*;
import java.awt.*;

public class LinearAlgorithm extends JFrame {
    private JTextField txtA;
    private JTextField txtB;
    private JTextField txtC;
    private JTextField txtD;
    private JLabel lblResult;
    private JTextArea txtOutput;

    public LinearAlgorithm() {
        setTitle("Лабораторная работа №2 - Линейный алгоритм");
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Панель ввода
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Входные данные"));

        inputPanel.add(new JLabel("A (10^-2):"));
        txtA = new JTextField("-0.01");
        inputPanel.add(txtA);

        inputPanel.add(new JLabel("B (-1.5):"));
        txtB = new JTextField("-1.5");
        inputPanel.add(txtB);

        inputPanel.add(new JLabel("C (4.1):"));
        txtC = new JTextField("4.1");
        inputPanel.add(txtC);

        inputPanel.add(new JLabel("D (-3):"));
        txtD = new JTextField("-3");
        inputPanel.add(txtD);

        // Кнопка
        JButton btnCalc = new JButton("Вычислить");
        btnCalc.addActionListener(e -> calculate());

        // Область результата
        txtOutput = new JTextArea(10, 40);
        txtOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Результат"));

        // Сборка
        add(inputPanel, BorderLayout.NORTH);
        add(btnCalc, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Значения по умолчанию
        txtA.setText("-0.01");   // 10^-2
        txtB.setText("-1.5");
        txtC.setText("4.1");
        txtD.setText("-3");

        setVisible(true);
    }

    private void calculate() {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());
            double d = Double.parseDouble(txtD.getText());

            // Формула для варианта 14: A·(?D+9B+10C) / (2?D^?)
            double pi = Math.PI;

            // Вычисление по шагам
            double numerator = a * (pi * d + 9 * b + 10 * c);
            double denominator = 2 * pi * Math.pow(d, pi);
            double result = numerator / denominator;

            // Вывод в консоль
            txtOutput.setText("");
            txtOutput.append("=== Результаты ===\n\n");
            txtOutput.append("A = " + a + "\n");
            txtOutput.append("B = " + b + "\n");
            txtOutput.append("C = " + c + "\n");
            txtOutput.append("D = " + d + "\n\n");
            txtOutput.append("Числитель = " + numerator + "\n");
            txtOutput.append("Знаменатель = " + denominator + "\n\n");
            txtOutput.append("РЕЗУЛЬТАТ U = " + String.format("%.5e", result) + "\n\n");
            txtOutput.append("Ожидаемый результат: -1.61778E-2\n");
            txtOutput.append("Погрешность: " + Math.abs(result + 0.0161778));

        } catch (NumberFormatException ex) {
            txtOutput.setText("Ошибка: введите корректные числа!");
        }
    }

    public static void main(String[] args) {
        new LinearAlgorithm();
    }
}