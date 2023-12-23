package mission.view;


import camp.nextstep.edu.missionutils.Console;

public class VerInputView {
    // InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
    private final Printer printer;
    private final InputValidator validator;

    private InputView(Printer printer, InputValidator validator) {
        this.printer = printer;
        this.validator = validator;
    }

    public static VerInputView of(Printer printer) {
        return new VerInputView(printer, InputValidator.getInstance());
    }

//    public Template inputTemplate() {
//        printer.printLine("");
//        String template = readLine();
//        validator.validate(template, "템플릿");
//        return new Template();
//    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
