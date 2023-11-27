# 📚전체 모음zip
# 먼저!!!
> 1. 깃허브: Fork하기 => Clone하기 (깃허브 desktop) => skylar 브랜치 만들기 => initial commit 하고 확인 꼭!!! (Pull Request 보내지는지도!!)
> 2. 2. 꼭!!!!! Application, ApplicationTest 둘 다 돌아가는지 부터 확인!!!
> 3. 설계에 공들이자, 계속 고치는 대공사보다 설계에 공들이는게 더 빠르다
> 4. 라이브러리는 알려준 고대로 쓰자! List을 shuffle하라 했으면 그모양 그대로
> 5. 너무 강박적으로 하지 말자!!!

# 목차

- [스피드](#스피드)
- [1. Enum](#Enum)

# 스피드
## start


# Enum
## 1. enum의 선언 순서 의존 해결!
![image](https://github.com/skylar1220/wootech-final-test-study/assets/110809927/ba158d59-0e25-49b1-8abf-5d10a5a66b96)

## 2. 사용자가 입력한 옵션 Enum.md
 from으로 받아서 일치 안하면 오류던지기
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
