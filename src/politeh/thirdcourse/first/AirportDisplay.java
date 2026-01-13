package politeh.thirdcourse.first;

import java.util.*;

class Aeroflot {
    private String flightNumber;
    private String departurePoint;
    private String destinationPoint;
    private String arrivalTime;
    private String departureTime;
    private String registrationSection;

    public Aeroflot(String flightNumber, String departurePoint, String destinationPoint,
                    String arrivalTime, String departureTime, String registrationSection) {
        this.flightNumber = flightNumber;
        this.departurePoint = departurePoint;
        this.destinationPoint = destinationPoint;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.registrationSection = registrationSection;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public static void printTableHeader() {
        System.out.println("+------------+------------------+------------------+------------+------------+-----------------+");
        System.out.println("| Рейс       | Отправление      | Назначение       | Время вылета| Время прилета| Регистрация     |");
        System.out.println("+------------+------------------+------------------+------------+------------+-----------------+");
    }

    public void printFlightInfo() {
        System.out.printf("| %-10s | %-16s | %-16s | %-10s | %-10s | %-15s |\n",
                flightNumber, departurePoint, destinationPoint,
                departureTime, arrivalTime, registrationSection);
        System.out.println("+------------+------------------+------------------+------------+------------+-----------------+");
    }
}

public class AirportDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aeroflot> flights = new ArrayList<>();

        System.out.println("Введите количество рейсов: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nРейс " + (i + 1) + ":");
            System.out.print("Номер рейса: ");
            String flightNumber = scanner.nextLine();

            System.out.print("Пункт отправления: ");
            String departure = scanner.nextLine();

            System.out.print("Пункт назначения: ");
            String destination = scanner.nextLine();

            System.out.print("Время отправления: ");
            String departureTime = scanner.nextLine();

            System.out.print("Время прибытия: ");
            String arrivalTime = scanner.nextLine();

            System.out.print("Место регистрации: ");
            String registration = scanner.nextLine();

            flights.add(new Aeroflot(flightNumber, departure, destination,
                    arrivalTime, departureTime, registration));
        }

        if (flights.isEmpty()) {
            System.out.println("Рейсов нет!");
        } else {
            flights.sort(Comparator.comparing(Aeroflot::getDestinationPoint));

            System.out.println("\n=== ТАБЛИЦА РЕЙСОВ (отсортирована по пункту назначения) ===");
            Aeroflot.printTableHeader();
            for (Aeroflot flight : flights) {
                flight.printFlightInfo();
            }
        }

        scanner.close();
    }
}