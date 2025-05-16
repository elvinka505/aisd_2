package aisd.sem01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // создаем файл с данными
        Writer.write();

        // читаем файл и сортируем
        try (Scanner scanner = new Scanner(new File("data.txt"))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                int[] array = Arrays.stream(row.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                StoogeSort.stoogeSort(array);
                System.out.println(Arrays.toString(array));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл data.txt не найден. Проверьте путь или права доступа.");
            e.printStackTrace();
        }
    }
}