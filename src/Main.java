import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int add;
        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Бобик");

        Cat cat1 = new Cat("Василий", 10);
        Cat cat2 = new Cat("Тишка", 20);
        Cat cat3 = new Cat("Яшка", 30);
        Cat cat4 = new Cat("Мурзик", 40);
        Cat cat5 = new Cat("Обжорка", 50);

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());

        dog1.run(501);
        dog2.swim(5);

        cat3.run(100);
        cat4.swim(10);

        Bowl bowl = new Bowl(100);
        Cat[] cats = {cat1, cat2, cat3, cat4, cat5};

        for (Cat cat : cats) {
            cat.eat(bowl, cat.appetite);
            System.out.println("Сытость кота " + cat.getName() + ": " + cat.isFull());
        }
        System.out.println("Остаток еды в миске: " + bowl.getFood());

        System.out.println("Сколько добавить в миску еды?");
        add = sc.nextInt();
        bowl.addFood(add);
        System.out.println("В миске: " + bowl.getFood());

        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl, cat.appetite);
                System.out.println("Сытость кота " + cat.getName() + ": " + cat.isFull());
            }
        }
        System.out.println("Остаток еды в миске: " + bowl.getFood());
    }
}