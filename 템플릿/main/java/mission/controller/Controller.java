package mission.controller;

import java.util.function.Supplier;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private <T> T readWithRetry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readWithRetry(supplier);
        }
    }

    private <T, R> R readWithRetry(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readWithRetry(function, input);
        }
    }
}
