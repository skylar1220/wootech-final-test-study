# Enum 클래스 관리
## enum의 선언 순서 의존 해결!
![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/ba158d59-0e25-49b1-8abf-5d10a5a66b96)

## Command 관리 (사용자가 입력한 옵션)
- from으로 받아서 일치 안하면 오류던지기

```java
public enum UserCommand {
    Optioni1("1"),
    Optioni2("2")

    private final String command;

    UserCommand(String command) {
        this.command = command;
    }

    public static UserCommand from(String command) {
        return Arrays.stream(values())
                .filter(option -> option.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("입력은 으로 해야합니다."));
    }
}


---
    public static RetryCommand from(String retryCommand) {
        return Arrays.stream(values())
                .filter(option -> option.userCommand.equals(retryCommand))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("입력은 %s, %s로 해야합니다.", RETRY.userCommand, QUIT.userCommand)));
    }
```
