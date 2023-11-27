# ✏️📚전체 모음zip
# 1. Enum
## enum의 선언 순서 의존 해결!
![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/ba158d59-0e25-49b1-8abf-5d10a5a66b96)

## from으로 받아서 일치 안하면 오류던지기
[사용자가 입력한 옵션 Enum.md](https://github.com/skylar1220/wootech-final-test-study/blob/main/%E1%84%90%E1%85%A6%E1%86%B7%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%86%BA/%E1%84%8E%E1%85%AC%E1%84%8C%E1%85%A9%E1%86%BC%E1%84%8F%E1%85%A9%E1%84%90%E1%85%A6/%E1%84%89%E1%85%A1%E1%84%8B%E1%85%AD%E1%86%BC%E1%84%8C%E1%85%A1%E1%84%80%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%B8%E1%84%85%E1%85%A7%E1%86%A8%E1%84%92%E1%85%A1%E1%86%AB%20%E1%84%8B%E1%85%A9%E1%86%B8%E1%84%89%E1%85%A7%E1%86%AB%20Enum.md)

# 2. 사용자가 입력한 옵션 Enum.md
## Enum 클래스 관리
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
