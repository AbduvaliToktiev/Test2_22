package politeh.thirdcourse.first;

import java.util.*;

class Student {
    private String surname;
    private String firstName;
    private String birthDate;
    private String phoneNumber;
    private String group;
    
    public Student(String surname, String firstName, String birthDate, 
                  String phoneNumber, String group) {
        this.surname = surname;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.group = group;
    }
    
    public String getSurname() { return surname; }
    public String getFirstName() { return firstName; }
    public String getBirthDate() { return birthDate; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getGroup() { return group; }
    
    public void printInfo() {
        System.out.printf("%-15s %-15s %-12s %-15s %-10s\n",
                surname, firstName, birthDate, phoneNumber, group);
    }
}

class StudentGroup {
    private List<Student> students;
    
    public StudentGroup() {
        students = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Студент добавлен!");
    }
    
    public void removeStudent(String surname) {
        boolean removed = students.removeIf(s -> s.getSurname().equalsIgnoreCase(surname));
        if (removed) {
            System.out.println("Студент удален!");
        } else {
            System.out.println("Студент не найден!");
        }
    }
    
    public Student findStudentBySurname(String surname) {
        return students.stream()
                .filter(s -> s.getSurname().equalsIgnoreCase(surname))
                .findFirst()
                .orElse(null);
    }
    
    public Student findStudentByPhone(String phone) {
        return students.stream()
                .filter(s -> s.getPhoneNumber().equals(phone))
                .findFirst()
                .orElse(null);
    }
    
    public void sortBySurname() {
        students.sort(Comparator.comparing(Student::getSurname));
    }
    
    public void sortByBirthDate() {
        students.sort(Comparator.comparing(Student::getBirthDate));
    }
    
    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Студентов нет!");
            return;
        }
        
        System.out.println("\nСписок студентов:");
        System.out.printf("%-15s %-15s %-12s %-15s %-10s\n",
                "Фамилия", "Имя", "Дата рожд.", "Телефон", "Группа");
        System.out.println("-".repeat(70));
        for (Student s : students) {
            s.printInfo();
        }
    }
    
    public int getSize() {
        return students.size();
    }
}

public class StudentGroupDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGroup group = new StudentGroup();
        
        while (true) {
            System.out.println("\n=== МЕНЮ СТУДЕНЧЕСКОЙ ГРУППЫ ===");
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента (по фамилии)");
            System.out.println("3. Найти студента по фамилии");
            System.out.println("4. Найти студента по телефону");
            System.out.println("5. Сортировать по фамилии");
            System.out.println("6. Сортировать по дате рождения");
            System.out.println("7. Показать всех студентов");
            System.out.println("8. Количество студентов");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Фамилия: ");
                    String surname = scanner.nextLine();
                    System.out.print("Имя: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Дата рождения (ДД.ММ.ГГГГ): ");
                    String birthDate = scanner.nextLine();
                    System.out.print("Телефон: ");
                    String phone = scanner.nextLine();
                    System.out.print("Группа: ");
                    String groupName = scanner.nextLine();
                    
                    group.addStudent(new Student(surname, firstName, birthDate, phone, groupName));
                    break;
                    
                case 2:
                    System.out.print("Введите фамилию для удаления: ");
                    String delSurname = scanner.nextLine();
                    group.removeStudent(delSurname);
                    break;
                    
                case 3:
                    System.out.print("Введите фамилию для поиска: ");
                    String findSurname = scanner.nextLine();
                    Student found = group.findStudentBySurname(findSurname);
                    if (found != null) {
                        System.out.println("Найден студент:");
                        found.printInfo();
                    } else {
                        System.out.println("Студент не найден!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Введите телефон для поиска: ");
                    String findPhone = scanner.nextLine();
                    Student foundByPhone = group.findStudentByPhone(findPhone);
                    if (foundByPhone != null) {
                        System.out.println("Найден студент:");
                        foundByPhone.printInfo();
                    } else {
                        System.out.println("Студент не найден!");
                    }
                    break;
                    
                case 5:
                    group.sortBySurname();
                    System.out.println("Сортировка по фамилии выполнена!");
                    break;
                    
                case 6:
                    group.sortByBirthDate();
                    System.out.println("Сортировка по дате рождения выполнена!");
                    break;
                    
                case 7:
                    group.printAllStudents();
                    break;
                    
                case 8:
                    System.out.println("Количество студентов: " + group.getSize());
                    break;
                    
                case 0:
                    System.out.println("Выход из программы!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}