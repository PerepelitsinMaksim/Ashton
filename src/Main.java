import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int add;
        Cat[] catsArray = new Cat[5];
        catsArray[0] = new Cat("Тишка", 10);
        catsArray[1] = new Cat("Васька", 10);
        catsArray[2] = new Cat("Мурзик", 20);
        catsArray[3] = new Cat("Яшка", 50);
        catsArray[4] = new Cat("Обжора", 10);
        Plate plate = new Plate(50);
        plate.info();
        for (Cat allCat : catsArray) {
            if (allCat.satiety == false && allCat.appetite < plate.food) {
                allCat.eat(plate);
                allCat.satiety = true;
                System.out.println("Сытость кота " + allCat.name + " = " + allCat.satiety);
            } else {
                System.out.println("Сытость кота " + allCat.name + " = " + allCat.satiety + " - добавьте ему еды!");
            }
        }
        plate.info();
        System.out.println("Сколько добавить в миску еды?");
        add = sc.nextInt();
        plate.increaseFood(add);
        plate.info();
    }
}