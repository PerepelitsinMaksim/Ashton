public class Animal {
    private String name;
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
}
