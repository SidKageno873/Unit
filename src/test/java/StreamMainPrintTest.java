import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StreamMainPrintTest {
    @Test
    public void printResult_shouldPrintCorrectFormat() {
        // given
        List<Integer> input = Arrays.asList(2, 4, 6);
        String expected = "Результат с Stream API:" + System.lineSeparator() +
                "2 4 6 " + System.lineSeparator();

        // Сохраняем стандартный вывод
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            // when
            StreamMain.printResult(input);

            // then
            assertEquals(expected, bos.toString());
        } finally {
            // Возвращаем стандартный вывод в любом случае
            System.setOut(originalOut);
        }
    }
}