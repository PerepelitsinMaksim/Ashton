class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        super.maxRun = 500;
        super.maxSwim = 10;
        dogCount++;
    }

    public void run(int distance) {
        if (distance <= maxRun) {
            System.out.println(name + " пробежал " + distance + "м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + "м.");
        }
    }

    public void swim(int distance) {
        if (distance <= maxSwim) {
            System.out.println(name + " проплыл " + distance + "м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + "м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}