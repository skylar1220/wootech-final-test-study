package mission.view.validator;

import mission.common.Symbol;

public class InputValidator {
    public static final String TEMPLATE_SEPARATOR = Symbol.COMMA;
    private static InputValidator inputValidator;

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        if (inputValidator == null) {
            return new InputValidator();
        }
        return inputValidator;
    }

    public void validateTemplate(String template, String target) {
        StringValidator.validateBlank(template, target);
        StringValidator.validateNumeric(template, target);
        StringValidator.validateIntegerRange(template, target);
    }
}
