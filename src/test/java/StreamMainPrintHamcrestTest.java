import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StreamMainPrintHamcrestTest {

    @Test
    public void printResult_shouldPrintCorrectFormat() {
        // given
        List<Integer> input = Arrays.asList(2, 4, 6);
        String expectedLine1 = "Результат с Stream API:";
        String expectedLine2 = "2 4 6 ";

        // Сохраняем стандартный вывод
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            // when
            StreamMain.printResult(input);
            String output = bos.toString();

            // then
            assertThat(output, allOf(
                    containsString(expectedLine1),
                    containsString(expectedLine2),
                    endsWith(System.lineSeparator())
            ));
        } finally {
            // Возвращаем стандартный вывод
            System.setOut(originalOut);
        }
    }

    @Test
    public void printResult_shouldContainAllNumbersInOrder() {
        // given
        List<Integer> input = Arrays.asList(10, 20, 30);

        // Сохраняем стандартный вывод
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            // when
            StreamMain.printResult(input);
            String output = bos.toString();

            // then
            assertThat(output, stringContainsInOrder(
                    Arrays.asList("Результат", "Stream API", "10", "20", "30")
            ));
        } finally {
            // Возвращаем стандартный вывод
            System.setOut(originalOut);
        }
    }
}