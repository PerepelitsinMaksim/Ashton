public class Main {

    public static void main(String[] args) {
        Animal animal = new Cat("bigCat", 50);
        Cat cat = new Cat("smalCat", 20);
        Dog dog = new Dog("собакен");
        animal.countA();
        cat.countC();
        dog.countD();
        dog.run(150);
        cat.run(250);
        dog.swim(5);
        animal.swim(1);
    }
}
