public class Animal {
    protected String name;
    private int maxRun;
    private int maxSwim;
    private static int animalCount;

    public Animal(String name, int maxRun, int maxSwim) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        animalCount++;
    }
    public void countA() {
        System.out.println("Всего животных: " + animalCount);
    }
    public void run(int distanceR) {
        if (maxRun > distanceR) System.out.println(name + " пробежал " + distanceR + "м");
        else System.out.println(name + " столько не пробежит");
    }
    public void swim(int distanceS) {
        if (maxSwim > distanceS) System.out.println(name + " проплыл " + distanceS + "м");
        else System.out.println(name + " столько не плавает");
    }
}
