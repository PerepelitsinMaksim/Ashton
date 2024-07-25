public class Main {

    public static void main(String[] args) {

        System.out.println("Задание1: 3 слова в столбик");
        printThreeWords();

        System.out.println("Задание2: Проверка на положительную сумму");
        checkSumSign();

        System.out.println("Задание3: Определить цвет");
        printColor();

        System.out.println("Задание4: Сравнение");
        compareNumbers();

        System.out.println("Задание5: Сумма должна лежать в пределах от 10 до 20 (включительно)");
        System.out.println(enterTwoNumbers());

        System.out.println("Задание6: Проверка на положительность числа");
        pozChis();

        System.out.println("Задание7: Проверка на отрицательность числа");
        System.out.println(otrChis());

        System.out.println("Задание8: Вывод строк");
        str();

        System.out.println("Задание9: Проверка на високосный год");
        System.out.println(years());

        System.out.println("Задание10: Замена чисел в массиве");
        mass();

        System.out.println("Задание11: Заполнить массив по порядку");
        zapMass();

        System.out.println("Задание12: Числа в массиве < 6 умножить на 2");
        umnMass();

        System.out.println("Задание13: Заполнить диагонали квадратного массива единицами");
        diagMass();

        System.out.println("Задание14: Заполнить одномерный массив");
        vvodMass();
    }

    public static void printThreeWords() {
        String text = "Orange\nBanana\nApple";
        System.out.println(text);
    }

    public static void checkSumSign() {
        int a = 1;
        int b = -3;
        if ((a + b) >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value =-3;
        if (value <= 0) System.out.println("Красный");
        else if (value <= 100) System.out.println("Желтый");
        else System.out.println("Зеленый");
    }

    public static void compareNumbers() {
        int a = 1;
        int b = -3;
        if (a >= b) System.out.println("a>=b");
        else System.out.println("a<b");
    }

    public static boolean enterTwoNumbers() {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Введите первое целое слагаемое: ");
        int b = sc1.nextInt();
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Введите второе целое слагаемое: ");
        int c = sc2.nextInt();
        System.out.println("Cумма: " + (b + c));
        return ((b + c) >= 10) && ((b + c) <= 20);
    }

    public static void pozChis() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int a = sc.nextInt();
        if (a>=0) System.out.println("Положительное число");
        else System.out.println("Отрицательное число");
    }

    public static boolean otrChis (){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int a = sc.nextInt();
        return a < 0;
    }

    public static void str() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число строк: ");
        int a = sc.nextInt();
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String string = sc1.nextLine();
        for (int i = a; i > 0; i--) {
            System.out.println(string);
        }
    }

        public static boolean years() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите год: ");
            int year = sc.nextInt();
            boolean isLeap;
            if (year % 400 == 0) isLeap = true;
            else if (year % 100 == 0) isLeap = false;
            else if (year % 4 == 0) isLeap = true;
            else isLeap = false;
            return isLeap;
        }

    public static void mass() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void zapMass() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void umnMass() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void diagMass() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите размер квадратного массива: ");
        int a = sc.nextInt();
        int [][] table = new int [a][a];
        for (int i = 0; i < a ; i++) {
            for (int j = 0; j < a; j++) {
                if (i == j) table [i][j] = 1;
                else if (i + j == a - 1) table [i][j] = 1;
                else table [i][j] = 0;
                System.out.print(table [i] [j] + "  ");
            }
            System.out.println();
        }
    }

    public static void vvodMass() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Задайте длину массива: ");
        int len = sc.nextInt();
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Введите целое число для заполнения массива: ");
        int initialValue = sc1.nextInt();
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        System.out.println(Arrays.toString(arr));
    }
}


