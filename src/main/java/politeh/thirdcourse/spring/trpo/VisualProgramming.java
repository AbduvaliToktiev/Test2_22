package politeh.thirdcourse.spring.trpo;

import javax.swing.*;
import java.awt.*;

public class VisualProgramming extends JFrame {
    private JTextField txtArgument;
    private JLabel lblArgument;
    private JLabel lblResult;
    private JPanel imagePanel;
    private JPanel[] formulaCards = new JPanel[4];  // Массив для хранения панелей формул

    public VisualProgramming() {
        setTitle("Лабораторная работа №3 - Визуальное программирование");
        setSize(600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Создание меню
        JMenuBar menuBar = new JMenuBar();

        JMenu menuMain = new JMenu("Меню");
        JMenuItem menuHello = new JMenuItem("Привет!");
        JMenuItem menuArgument = new JMenuItem("Аргумент");
        JMenuItem menuExit = new JMenuItem("Выход");

        menuMain.add(menuHello);
        menuMain.add(menuArgument);
        menuMain.addSeparator();
        menuMain.add(menuExit);

        // Меню "Функция"
        JMenu menuFunction = new JMenu("Функция");
        JMenuItem menuCos = new JMenuItem("Cos(x)");
        JMenuItem menuSin = new JMenuItem("Sin(x)");
        JMenuItem menuTg = new JMenuItem("tg(x)");
        JMenuItem menuCtg = new JMenuItem("ctg(x)");

        menuFunction.add(menuCos);
        menuFunction.add(menuSin);
        menuFunction.add(menuTg);
        menuFunction.add(menuCtg);

        // Меню "Обратная функция"
        JMenu menuArc = new JMenu("Обратная функция");
        JCheckBoxMenuItem menuArccos = new JCheckBoxMenuItem("arccos(x)");
        JCheckBoxMenuItem menuArcsin = new JCheckBoxMenuItem("arcsin(x)");
        JCheckBoxMenuItem menuArctg = new JCheckBoxMenuItem("arctg(x)");
        JCheckBoxMenuItem menuArcctg = new JCheckBoxMenuItem("arcctg(x)");

        menuArc.add(menuArccos);
        menuArc.add(menuArcsin);
        menuArc.add(menuArctg);
        menuArc.add(menuArcctg);

        menuBar.add(menuMain);
        menuBar.add(menuFunction);
        menuBar.add(menuArc);
        setJMenuBar(menuBar);

        // Основная панель
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Панель для аргумента
        JPanel argPanel = new JPanel(new FlowLayout());
        argPanel.setBorder(BorderFactory.createTitledBorder("Ввод аргумента"));
        lblArgument = new JLabel("Аргумент не введён");
        txtArgument = new JTextField(15);
        txtArgument.setVisible(false);
        argPanel.add(lblArgument);
        argPanel.add(txtArgument);

        // Панель для результата
        JPanel resultPanel = new JPanel();
        resultPanel.setBorder(BorderFactory.createTitledBorder("Результат"));
        lblResult = new JLabel("Результат появится здесь");
        resultPanel.add(lblResult);

        // Панель для формул
        imagePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        imagePanel.setBorder(BorderFactory.createTitledBorder("Обратные функции"));

        String[] formulaNames = {"arccos(x)", "arcsin(x)", "arctg(x)", "arcctg(x)"};

        for (int i = 0; i < 4; i++) {
            JPanel card = new JPanel();
            card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            card.setBackground(Color.WHITE);
            card.setPreferredSize(new Dimension(200, 80));

            JLabel formula = new JLabel(formulaNames[i], SwingConstants.CENTER);
            formula.setFont(new Font("Arial", Font.BOLD, 14));
            card.add(formula);

            card.setVisible(false);
            formulaCards[i] = card;  // Сохраняем в массив
            imagePanel.add(card);
        }
        imagePanel.setVisible(false);

        mainPanel.add(argPanel, BorderLayout.NORTH);
        mainPanel.add(resultPanel, BorderLayout.CENTER);
        mainPanel.add(imagePanel, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);

        // Обработчики меню
        menuHello.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Привет мир, Windows и пользователь!\nЭто мы из Java!")
        );

        menuArgument.addActionListener(e -> {
            lblArgument.setText("Введите значение x:");
            txtArgument.setVisible(true);
            txtArgument.requestFocus();
        });

        menuExit.addActionListener(e -> System.exit(0));

        // Обработчики функций
        menuCos.addActionListener(e -> calculateFunction("cos"));
        menuSin.addActionListener(e -> calculateFunction("sin"));
        menuTg.addActionListener(e -> calculateFunction("tg"));
        menuCtg.addActionListener(e -> calculateFunction("ctg"));

        // Обработчики обратных функций
        menuArccos.addItemListener(e -> toggleFormula(0, menuArccos.getState()));
        menuArcsin.addItemListener(e -> toggleFormula(1, menuArcsin.getState()));
        menuArctg.addItemListener(e -> toggleFormula(2, menuArctg.getState()));
        menuArcctg.addItemListener(e -> toggleFormula(3, menuArcctg.getState()));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculateFunction(String func) {
        try {
            double x = Double.parseDouble(txtArgument.getText());
            double result;
            String formula;

            switch (func) {
                case "cos":
                    result = Math.cos(x);
                    formula = "Cos(x) = ";
                    break;
                case "sin":
                    result = Math.sin(x);
                    formula = "Sin(x) = ";
                    break;
                case "tg":
                    result = Math.tan(x);
                    formula = "tg(x) = ";
                    break;
                case "ctg":
                    result = 1.0 / Math.tan(x);
                    formula = "Ctg(x) = ";
                    break;
                default:
                    return;
            }

            lblResult.setText(formula + String.format("%.4f", result));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Сначала введите аргумент через меню 'Аргумент'");
        }
    }

    private void toggleFormula(int index, boolean isSelected) {
        imagePanel.setVisible(true);
        if (index >= 0 && index < formulaCards.length) {
            formulaCards[index].setVisible(isSelected);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VisualProgramming());
    }
}