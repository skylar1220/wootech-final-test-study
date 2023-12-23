package mission.view.printer;

public interface Printer {
    void printLine(String message);

    void printLine(int number);

    void printLine(String format, Object... args);

    void printEmptyLine();
}
