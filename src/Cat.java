public class Cat extends Animal{
    private boolean satiety;
    private int appetite;
    private static int catCount;
    public Cat(String name, int appetite){
        super(name, 200, 0);
        this.appetite = appetite;
        satiety = false;
        catCount++;
    }
    public void countC() {
        System.out.println("Всего кошек: " + catCount);
    }
    public void eat(int corm) {
        for (Cat.catCount = 1; true; Cat.catCount++) {
            if (corm >= appetite) {
                satiety = true;
                corm = corm - appetite;
            }
        }
    }
}