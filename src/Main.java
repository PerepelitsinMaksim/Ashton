import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        System.out.println("Повторения слов:");
        countArray();

        System.out.println("\nЗадание 2");
        System.out.println("Телефонная книга. Поиск по фамилии:");
        Phonebook phonebook = new Phonebook();

        phonebook.putInfo("Ivanov", "+795955318531");
        phonebook.putInfo("Petrov", "+797619465154");
        phonebook.putInfo("Sidorov", "+799754645324");
        phonebook.putInfo("Egorov", "+797954616545");
        phonebook.putInfo("Petrov", "+797959461644");
        phonebook.putInfo("Milovanova", "+79979451446");
        phonebook.putInfo("Vinogradov", "+79975916416");
        phonebook.putInfo("Ivanov", "+7979594641495");
        phonebook.putInfo("Gatalskiy", "+7995796264757");
        phonebook.putInfo("Petrov", "+799752464645");
        phonebook.putInfo("Mischenko", "+7997594666421");
        phonebook.putInfo("Nevzorova", "+7995794216476");

        phonebook.getInfo("Vinogradov");
        phonebook.getInfo("Petrov");
    }
    private static void countArray() {
        ArrayList<String> array = new ArrayList<>();
        array.add("Orange");
        array.add("banana");
        array.add("kiwi");
        array.add("kiwi");
        array.add("tangerine");
        array.add("Orange");
        array.add("pineapple");
        array.add("tangerine");
        array.add("apple");
        array.add("banana");
        array.add("banana");
        array.add("banana");
        array.add("lemon");
        array.add("Orange");
        array.add("banana");
        array.add("pineapple");
        array.add("kiwi");
        array.add("Orange");
        array.add("banana");
        array.add("apple");

        HashSet<String> arrayUnique = new HashSet<>(array);
        ArrayList<String> arrayCount = new ArrayList<>(arrayUnique);

        for (int i = 0; i < arrayUnique.size(); i++) {
            System.out.println("Количество " + arrayCount.get(i) + ": " + Collections.frequency(array, arrayCount.get(i)));
        }
    }
}