package mission.view.printer;

public class ConsolePrinter implements Printer {
    @Override
    public void printLine(String message) {
        System.out.println(message);
    }
    @Override
    public void printLine(int number) {
        System.out.println(number);
    }

    @Override
    public void printLine(String format, Object... args) {
        System.out.printf(format, args);
        printEmptyLine();
    }

    @Override
    public void printEmptyLine() {
        System.out.println();
    }
}
