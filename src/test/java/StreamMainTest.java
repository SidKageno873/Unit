import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StreamMainTest {
    @Test
    public void filterAndSortNumbers_shouldFilterPositiveEvenNumbersAndSort() {
        // given
        List<Integer> input = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> expected = Arrays.asList(2, 4, 8, 16, 32);

        // when
        List<Integer> result = StreamMain.filterAndSortNumbers(input);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void filterAndSortNumbers_withEmptyList_shouldReturnEmptyList() {
        // given
        List<Integer> input = List.of();
        List<Integer> expected = List.of();

        // when
        List<Integer> result = StreamMain.filterAndSortNumbers(input);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void filterAndSortNumbers_withNoPositiveNumbers_shouldReturnEmptyList() {
        // given
        List<Integer> input = Arrays.asList(-5, -3, -10, -2);
        List<Integer> expected = List.of();

        // when
        List<Integer> result = StreamMain.filterAndSortNumbers(input);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void filterAndSortNumbers_withNoEvenNumbers_shouldReturnEmptyList() {
        // given
        List<Integer> input = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> expected = List.of();

        // when
        List<Integer> result = StreamMain.filterAndSortNumbers(input);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void filterAndSortNumbers_withMixedNumbers_shouldReturnCorrectResult() {
        // given
        List<Integer> input = Arrays.asList(10, -4, 7, 0, 3, 12, -8, 5);
        List<Integer> expected = Arrays.asList(10, 12);

        // when
        List<Integer> result = StreamMain.filterAndSortNumbers(input);

        // then
        assertEquals(expected, result);
    }
}