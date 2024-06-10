import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем размер массива у пользователя
        int n = getPositiveInteger(scanner, "Введите размер массива (положительное целое число): ");

        // Запрашиваем пороговое значение у пользователя
        int x = getInteger(scanner, "Введите пороговое значение: ");

        // Генерируем массив из n случайных чисел в диапазоне от 0 до 100
        int[] randomArray = generateRandomArray(n);

        // Определяем индексы элементов, значения которых превосходят порог x
        ArrayList<Integer> indicesAboveThreshold = getIndicesAboveThreshold(randomArray, x);

        // Выводим результаты
        System.out.print("Сгенерированный массив: ");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Индексы элементов, значения которых превышают порог " + x + ": ");
        for (int index : indicesAboveThreshold) {
            System.out.print(index + " ");
        }
        System.out.println();
    }

    // Функция для получения положительного целого числа от пользователя
    private static int getPositiveInteger(Scanner scanner, String prompt) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Пожалуйста, введите положительное целое число.");
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
                scanner.next(); // очистка некорректного ввода
            }
        }
        return value;
    }

    // Функция для получения целого числа от пользователя
    private static int getInteger(Scanner scanner, String prompt) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                break;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
                scanner.next(); // очистка некорректного ввода
            }
        }
        return value;
    }

    // Функция для генерации массива случайных чисел
    private static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(101); // случайное число от 0 до 100 включительно
        }
        return array;
    }

    // Функция для получения индексов элементов, значения которых превосходят порог x
    private static ArrayList<Integer> getIndicesAboveThreshold(int[] array, int x) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > x) {
                indices.add(i);
            }
        }
        return indices;
    }
}