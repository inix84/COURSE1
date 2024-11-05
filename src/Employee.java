import java.util.Objects;

public class Employee { // класс Сотрудник

    private String surname;  // Фамилия, может меняться
    private final String name;    // Имя
    private final String patronymic; // Отчество
    private int department; //отдел (от 1 до 5), может меняться
    private int salary; // зарплата, может меняться
    // счетчик обращений к конструктору, привязан к классу (статичный) сквозное значение всех методов
    private static int counter = 0;

    private final int id; // номер сотрудника

    public Employee(String surname, String name, String patronymic, int department, int salary) {
        // метод Сотрудник, определяются поля для класса
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        this.id = counter++; // увеличивается при каждом обращении (создании сотрудников)
    }

    // считывать фамилию, имя, отчество, отдел, зарплату, счетчик, номер ИД
    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return (id + 1);
    }

    // менять фамилию, отдел, зарплату
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // сравнивать все поля
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department &&
                salary == employee.salary && id == employee.id &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(name, employee.name)
                && Objects.equals(patronymic, employee.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, department, salary, id);
    }

    // выводить все поля кроме счетчика
    @Override
    public String toString() {
        return "№ " + getId() + " " +
                getSurname() + " " +
                getName() + " " +
                getPatronymic() + ", отдел " +
                getDepartment() + ", зарплата " +
                getSalary() + " рублей.";
    }
}