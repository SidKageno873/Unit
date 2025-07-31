import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        List<Integer> result = filterAndSortNumbers(intList);
        printResult(result);
    }

    public static List<Integer> filterAndSortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x > 0)           // Положительные числа
                .filter(x -> x % 2 == 0)      // Четные числа
                .sorted(Comparator.naturalOrder())  // Сортировка по возрастанию
                .collect(Collectors.toList());
    }

    public static void printResult(List<Integer> numbers) {
        System.out.println("Результат с Stream API:");
        numbers.forEach(x -> System.out.print(x + " "));
        System.out.println(); // Добавляем перевод строки в конце
    }
}