import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 7, 2, -3, 10, 6);
        List<String> animals = List.of("кот", "Сова", "лиса");
        int[] array = {3, 4, -6, 9, 12};
        List<String> months = List.of("Март", "Июль", "Май");

        System.out.println("1. Среднее " + numbers + " = "
                + StreamTasks.average(numbers).orElseThrow());
        System.out.println("2. Верхний регистр с префиксом " + animals + " -> "
                + StreamTasks.uppercaseWithPrefix(animals));
        System.out.println("3. Квадраты чисел, встречающихся один раз " + numbers + " -> "
                + StreamTasks.uniqueSquares(numbers));
        System.out.println("4. Последний элемент " + animals + " -> "
                + StreamTasks.lastElement(animals));
        System.out.println("5. Сумма чётных в " + Arrays.toString(array) + " = "
                + StreamTasks.sumOfEvenNumbers(array));
        System.out.println("6. Первый символ и остаток строки " + months + " -> "
                + StreamTasks.splitByFirstCharacter(months));
    }
}
