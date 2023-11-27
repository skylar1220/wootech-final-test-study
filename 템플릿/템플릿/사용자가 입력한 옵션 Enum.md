# Enum 클래스 관리
## Command 관리 (사용자가 입력한 옵션)


```java
public enum UserCommand {
    Optioni1("1"),
    Optioni2("2")

    private final String command;

    UserCommand(String command) {
        this.command = command;
    }

    public static UserCommand from(String command) {
        return Arrays.stream(MainOption.values())
                .filter(option -> option.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("입력은 으로 해야합니다."));
    }
}
```
