class Cat extends Animal {
    private static final int maxRun = 200;
    private static int catCount = 0;
    private boolean satiety;
    protected int appetite;

    public Cat(String name, int appetite) {
        super(name);
        catCount++;
        this.satiety = false;
        this.appetite = appetite;
    }

    public void run(int distance) {
        if (distance <= maxRun) {
            System.out.println(name + " пробежал " + distance + "м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + "м.");
        }
    }

    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            this.satiety = true;
        } else {
            System.out.println(name + " голодный. Ему не хватило еды");
        }
    }

    public boolean isFull() {
        return satiety;
    }

    public static int getCatCount() {
        return catCount;
    }
}