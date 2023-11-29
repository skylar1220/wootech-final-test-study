package mission;

public class Application {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();
        InputView inputView = InputView.of(reader, printer);

        OutputFomatter outputFomatter = new OutputFomatter();
        OutputView outputView = new OutputView(printer, outputFomatter);

        Controller controller = new Controller(inputView, outputView);
        controller.run();
    }
}
