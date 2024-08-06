public class Dog extends Animal{
    private static int dogCount;
    public Dog(String name){
        super(name, 500, 10);
        dogCount++;
    }
    public void countD() {
        System.out.println("Всего собак: " + dogCount);
    }
}
