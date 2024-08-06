public class Cat extends Animal{
    private static int catCount;
    public Cat(String name){
        super(name, 200, 0);
        catCount++;
    }
    public void countC() {
        System.out.println("Всего кошек: " + catCount);
    }
}