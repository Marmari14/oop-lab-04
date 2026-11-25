import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class StreamTasks {
    private StreamTasks() {
    }

    public static OptionalDouble average(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    public static List<String> uppercaseWithPrefix(List<String> words) {
        return words.stream()
                .map(word -> "_new_" + word.toUpperCase(Locale.ROOT))
                .toList();
    }

    public static List<Long> uniqueSquares(List<Integer> numbers) {
        Map<Integer, Long> counts = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return numbers.stream()
                .filter(number -> counts.get(number) == 1L)
                .map(number -> (long) number * number)
                .toList();
    }

    public static <T> T lastElement(Collection<T> elements) {
        return elements.stream()
                .map(Optional::ofNullable)
                .reduce((earlier, later) -> later)
                .orElseThrow(() -> new NoSuchElementException("Коллекция пуста."))
                .orElse(null);
    }

    public static long sumOfEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(number -> number % 2 == 0)
                .asLongStream()
                .sum();
    }

    public static Map<Character, String> splitByFirstCharacter(List<String> words) {
        return words.stream()
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toMap(
                        word -> word.charAt(0),
                        word -> word.substring(1),
                        (earlier, later) -> later,
                        LinkedHashMap::new
                ));
    }
}
