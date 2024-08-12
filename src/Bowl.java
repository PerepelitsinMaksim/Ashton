class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int amount) {
        if (amount <= 0) {
            System.out.println("Количество еды должно быть > 0");
            return false;
        }
        if (food >= amount) {
            food -= amount;
            return true;
        }
        System.out.println("Недостаточно еды в миске. Осталось: " + food);
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Добавлено " + amount + " еды в миску");
        } else if (amount == 0) {
            System.out.println("Вы ничего не положили");
        }
        else System.out.println("Не забирайте еду у котов!");
    }

    public int getFood() {
        return food;
    }
}