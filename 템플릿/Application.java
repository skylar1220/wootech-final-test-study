package bridge;

import bridge.controller.BridgeController;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.formatter.OutputFomatter;
import bridge.view.printer.ConsolePrinter;
import bridge.view.printer.Printer;
import bridge.view.reader.ConsoleReader;
import bridge.view.reader.Reader;

public class Application {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();
        InputView inputView = InputView.of(reader, printer);

        OutputFomatter outputFomatter = new OutputFomatter();
        OutputView outputView = new OutputView(printer, outputFomatter);

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeController bridgeController = new BridgeController(inputView, outputView, bridgeNumberGenerator);
        bridgeController.run();
    }
}
