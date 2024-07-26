public class Person {
    private String name;
    private String position;
    private String email;
    private long phoneNumber;
    private int salary;
    private int age;

    public Person(String name, String position, String email, long phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Иванов Иван", "Инженер", "ivivan@mailbox.com", 898765432, 30000, 30);
        persArray[1] = new Person("Петров Петр", "Программист", "petpetrov@mailbox.com", 812345678, 45000, 56);
        persArray[2] = new Person("Сидоров Сидр", "ЗавХоз", "sidsidor@mailbox.com", 898666432, 22000, 21);
        persArray[3] = new Person("Кириллов Кирилл", "Дантист", "kirkirillov@mailbox.com", 898777432, 500000, 35);
        persArray[4] = new Person("Зинаидова Зинаида", "ГлавБух", "ZinZina@mailbox.com", 898888432, 34500, 30);
    }

    public void info() {
        System.out.println("ФИО: " + name + ", Должность: " + position + ", email: " + email + ", Телефон: " + phoneNumber + ", Зарплата: " + salary + ", Возраст: " + age);
    }
}