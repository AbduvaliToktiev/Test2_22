package politeh.thirdcourse.second;

class Timer {
    private int totalSeconds;
    private int initialSeconds;

    public Timer(int seconds) {
        this.totalSeconds = seconds;
        this.initialSeconds = seconds;
        System.out.println("Таймер создан: " + seconds + " секунд");
    }

    public Timer(String timeStr) {
        if (timeStr.contains(":")) {
            String[] parts = timeStr.split(":");
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            this.totalSeconds = minutes * 60 + seconds;
        } else {
            this.totalSeconds = Integer.parseInt(timeStr);
        }
        this.initialSeconds = this.totalSeconds;
        System.out.println("Таймер создан из строки: " + timeStr + " = " + this.totalSeconds + " секунд");
    }

    public Timer(int minutes, int seconds) {
        this.totalSeconds = minutes * 60 + seconds;
        this.initialSeconds = this.totalSeconds;
        System.out.println("Таймер создан: " + minutes + " минут " + seconds + " секунд = " + this.totalSeconds + " секунд");
    }

    public void run() {
        System.out.println("\nТаймер запущен! Обратный отсчет " + initialSeconds + " секунд...");

        long startTime = System.currentTimeMillis();

        while (totalSeconds > 0) {
            try {
                Thread.sleep(1000); // Задержка 1 секунда

                long currentTime = System.currentTimeMillis();
                long elapsedSeconds = (currentTime - startTime) / 1000;

                totalSeconds = initialSeconds - (int) elapsedSeconds;

                if (totalSeconds > 0) {
                    displayTime();
                }
            } catch (InterruptedException e) {
                System.out.println("Таймер прерван!");
                return;
            }
        }

        System.out.println("\n? БИП-БИП-БИП! Таймер завершен!");
        ringBell();
    }

    private void displayTime() {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        System.out.printf("Осталось: %02d:%02d\n", minutes, seconds);
    }

    private void ringBell() {
        System.out.println("? ЗВОНОК! Время вышло!");
        for (int i = 0; i < 3; i++) {
            System.out.print("БИП! ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public int getRemainingSeconds() {
        return totalSeconds;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Таймер " + initialSeconds + " секунд удаляется...");
        } finally {
            super.finalize();
        }
    }
}

public class TimerDemo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ ТАЙМЕРА ===");

        System.out.println("\n1. Создание таймера из целого числа (120 секунд):");
        Timer timer1 = new Timer(120);

        System.out.println("\n2. Создание таймера из строки (\"2:30\"):");
        Timer timer2 = new Timer("2:30");

        System.out.println("\n3. Создание таймера из двух целых чисел (1 мин 45 сек):");
        Timer timer3 = new Timer(1, 45);

        System.out.println("\n--- Запуск таймера на 5 секунд ---");
        Timer shortTimer = new Timer(5);
        shortTimer.run();

        System.out.println("\n--- Демонстрация очистки ---");
        timer1 = null;
        timer2 = null;
        timer3 = null;
        shortTimer = null;

        System.gc();
        try {
            Thread.sleep(1000); // Даем время на выполнение finalize
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nДемонстрация завершена!");
    }
}