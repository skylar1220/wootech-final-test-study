package view;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import christmas.common.ErrorMessage;
import christmas.mock.FakePrinter;
import christmas.mock.FakeReader;
import christmas.util.validator.StringValidator;
import christmas.view.printer.Printer;
import christmas.view.reader.Reader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    private Printer printer = new FakePrinter();

    @DisplayName("정상적이지 않은 에 대해서 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "2two", "2147483648", "-2147483649"})
    void inputDay(String input) {
        // given
        Reader reader = new FakeReader(input);
        InputView inputView = InputView.of(reader, printer);

        // when & then
    }
}
