import java.util.Arrays;

public class Main {
    // массив сотрудников, привязан к классу, сквозное значение для всех методов
    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
//заполняем массив 10 сотрудниками
        employees[0] = new Employee("Нулевой", "Ноль", "Нуллович", 1, 50_000);
        employees[1] = new Employee("Первый", "Ван", "Единичевич", 2, 41_000);
        employees[2] = new Employee("Второй", "Ту", "Двоевич", 3, 42_000);
        employees[3] = new Employee("Третий", "Фри", "Троевич", 4, 43_000);
        employees[4] = new Employee("Четвертый", "Фо", "Четверович", 5, 44_000);
        employees[5] = new Employee("Пятый", "Файф", "Пятькович", 1, 45_000);
        employees[6] = new Employee("Шестой", "Сикс", "Шестович", 2, 46_000);
        employees[7] = new Employee("Седьмой", "Севен", "Семивич", 3, 47_000);
        employees[8] = new Employee("Восьмой", "Эйт", "Восьмивич", 4, 48_000);
        employees[9] = new Employee("Девятый", "Найн", "Девятович", 5, 49_000);

        int quantity = Employee.getCounter(); // из СТАТИЧНОЙ переменной
        System.out.println("Количество сотрудников: " + quantity + " человек.");

        System.out.println();
        System.out.println("Список сотрудников: ");
        for (int i = 0; i < quantity; i++) {
            System.out.println(employees[i]);
        }
        System.out.println();
        System.out.println("Бухгалтерские отчеты: ");
        System.out.println("1) Сумма затра на ЗП в месяц : " + theAmountSalaries() + " рублей.");
        System.out.print("2) Минимальная зп у сотрудника: ");
        MinSalary();
        System.out.print("3) Максимальная зп у сотрудника: ");
        MaxSalary();
        System.out.println("4) Среднее значение зарплат: " + AverageSalary() + " рублей.");
        System.out.println();
        System.out.println("ФИО всех сотрудников: ");
        printEmployeeFullName();
    }

    public static int theAmountSalaries() {
        int sum = 0;
        for (Employee element : employees) {
            sum += element.getSalary();// переменная типа сотрудник со свойствами (частности зп)
        }
        return sum;
    }

    public static void MinSalary() {
        // находим мин зп
        int min = employees[0].getSalary(); // инвариант, путь 1 зп будет мин
        for (int i = 0; i < employees.length; i++) {
            if (min > employees[i].getSalary()) {
                min = employees[i].getSalary();
            }
        }
        // находим сотрудника по этой зп
        for (int i = 0; i < employees.length; i++) {
            Employee employeeMin = employees[i];
            if (employeeMin.getSalary() == min) {
                System.out.println(employees[i]);
            }
        }
        return;
    }

    public static void MaxSalary() {
        // находим мax зп
        int max = employees[0].getSalary(); // инвариант, путь 1 зп будет мax
        for (int i = 0; i < employees.length; i++) {
            if (max < employees[i].getSalary()) {
                max = employees[i].getSalary();
            }
        }
        // находим сотрудника по этой зп
        for (int i = 0; i < employees.length; i++) {
            Employee employeeMin = employees[i];
            if (employeeMin.getSalary() == max) {
                System.out.println(employees[i]);
            }
        }
        return;
    }

    // среднее значение находим как деление суммы зп на количество созданных сотрудников
    public static double AverageSalary() {
        double averageSalary = theAmountSalaries() / Employee.getCounter();
        return averageSalary;
    }

    // метод на вывод ФИО всех сотрудников
    public static void printEmployeeFullName() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println((i + 1) + ") " +
                    employees[i].getSurname() + " " +
                    employees[i].getName() + " " +
                    employees[i].getPatronymic());
        }
        return;
    }
}