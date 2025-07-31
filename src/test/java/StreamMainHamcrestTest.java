import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StreamMainHamcrestTest {

    @Test
    public void filterAndSortNumbers_shouldFilterPositiveEvenNumbersAndSort() {
        // given
        List<Integer> input = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        // when
        List<Integer> result = StreamMain.filterAndSortNumbers(input);

        // then
        assertThat(result, contains(2, 4, 8, 16, 32));
        assertThat(result, hasSize(5));
        assertThat(result, everyItem(greaterThan(0)));
        assertThat(result, everyItem(is(evenInteger())));
    }

    @Test
    public void filterAndSortNumbers_withEmptyList_shouldReturnEmptyList() {
        // given
        List<Integer> input = Collections.emptyList();

        // when
        List<Integer> result = StreamMain.filterAndSortNumbers(input);

        // then
        assertThat(result, is(empty()));
        assertThat(result, hasSize(0));
    }

    @Test
    public void filterAndSortNumbers_withNoPositiveNumbers_shouldReturnEmptyList() {
        // given
        List<Integer> input = Arrays.asList(-5, -3, -10, -2);

        // when
        List<Integer> result = StreamMain.filterAndSortNumbers(input);

        // then
        assertThat(result, is(emptyCollectionOf(Integer.class)));
    }

    @Test
    public void filterAndSortNumbers_withNoEvenNumbers_shouldReturnEmptyList() {
        // given
        List<Integer> input = Arrays.asList(1, 3, 5, 7, 9);

        // when
        List<Integer> result = StreamMain.filterAndSortNumbers(input);

        // then
        assertThat(result, is(empty()));
        assertThat(result, not(hasItem(greaterThan(0))));
    }

    @Test
    public void filterAndSortNumbers_withMixedNumbers_shouldReturnCorrectResult() {
        // given
        List<Integer> input = Arrays.asList(10, -4, 7, 0, 3, 12, -8, 5);

        // when
        List<Integer> result = StreamMain.filterAndSortNumbers(input);

        // then
        assertThat(result, contains(10, 12));
        assertThat(result, hasItems(10, 12));
        assertThat(result, not(hasItems(-4, 0, -8)));
    }

    // Новые тесты с дополнительными возможностями Hamcrest

    @Test
    public void filterAndSortNumbers_resultShouldBeStrictlyIncreasing() {
        // given
        List<Integer> input = Arrays.asList(5, 2, 10, 3, 8, 4, 7);

        // when
        List<Integer> result = StreamMain.filterAndSortNumbers(input);

        // then
        assertThat(result, is(strictlyIncreasing()));
    }

    @Test
    public void filterAndSortNumbers_shouldContainNumberInRange() {
        // given
        List<Integer> input = Arrays.asList(15, 3, 8, 20, 6);

        // when
        List<Integer> result = StreamMain.filterAndSortNumbers(input);

        // then
        assertThat(result, hasItem(both(greaterThanOrEqualTo(6)).and(lessThanOrEqualTo(20))));
    }

    // Кастомный матчер для проверки четных чисел
    private static org.hamcrest.Matcher<Integer> evenInteger() {
        return new org.hamcrest.TypeSafeMatcher<Integer>() {
            @Override
            protected boolean matchesSafely(Integer item) {
                return item % 2 == 0;
            }

            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("четное число");
            }
        };
    }

    // Кастомный матчер для проверки строго возрастающей последовательности
    private static org.hamcrest.Matcher<Iterable<Integer>> strictlyIncreasing() {
        return new org.hamcrest.TypeSafeMatcher<Iterable<Integer>>() {
            @Override
            protected boolean matchesSafely(Iterable<Integer> items) {
                int prev = Integer.MIN_VALUE;
                for (int current : items) {
                    if (current <= prev) {
                        return false;
                    }
                    prev = current;
                }
                return true;
            }

            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("строго возрастающая последовательность");
            }
        };
    }
}