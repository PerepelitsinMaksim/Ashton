public class Cat extends Animal {
    protected boolean satiety;
    protected int appetite;
    private static int catCount;

    public Cat(String name, int appetite) {
        super(name, 200, 0);
        this.appetite = appetite;
        satiety = false;
        catCount++;
/*
        Cat[] catsArray = new Cat[5];
        catsArray[0] = new Cat("Kitty1", 10);
        catsArray[1] = new Cat("Kitty2", 10);
        catsArray[2] = new Cat("SmallCat", 20);
        catsArray[3] = new Cat("BigCat", 500);
        catsArray[4] = new Cat("glutton", 10);
        int food = 20;

        for (Cat cat : catsArray) {
            if (cat.appetite < food) {
                cat.satiety = true;
                food = food - cat.appetite;
            }
            System.out.println(name + cat.satiety);
        }

 */
    }

        public void countC () {
            System.out.println("Всего кошек: " + catCount);
        }
    public void eat(Plate p) {
        p.decreaseFood(appetite);
    }
    }


