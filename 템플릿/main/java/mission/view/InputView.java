package mission.view;


import mission.common.Symbol;

public class InputView {
//    public static final String SEPARATOR = Symbol.COMMA;
    private final Reader reader;
    private final Printer printer;
    private final InputValidator validator;

    private InputView(Reader reader, Printer printer, InputValidator validator) {
        this.reader = reader;
        this.printer = printer;
        this.validator = validator;
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer, InputValidator.getInstance());
    }

//    public Template inputTemplate() {
//        printer.printLine("");
//        String template = reader.readLine();
//        validator.validate(template, "템플릿");
//        return new Template();
//    }
}
