# 📚전체 모음zip
# 들어가기전 체크할 것
- [ ] java 버전 17 확인

<br>

# 마지막 체크할 것
- [ ] 🚨 과제 제출 전 체크 리스트 - 0점 방지
- [ ] 📮 미션 제출 방법


<br>

# 시작 전 기억!!!  
> 1. 설계에 공들이자, 계속 고치는 대공사보다 설계에 공들이는게 더 빠르다
> 2. 라이브러리, 파일은 알려준 고대로 쓰자! 패키지 변경도 보수적으로 해석하기! -> 코드 변경과 같음
> 3. 메소드 분리, 원시값 포장, 테스트 코드 작성, 상수화 다 나중에하자! 일단 구현하기!!

<br>

# 목차

- [스피드](#스피드)
- [Enum](#Enum)

<br>

# 스피드
## 1. start (~00:05)
1. 깃허브: Fork하기 → Clone하기 → skylar 브랜치 만들기 → initial commit 하고 확인 꼭!!! (Pull Request 보내지는지도!!)
2. 꼭!!!!! Application, ApplicationTest 둘 다 돌아가는지 부터 확인!!!
3. setting, project structure java17 설정
4. setting - editor - general - fly import

<br>

## 2. 요구사항 읽기 (~00:10)
1. 기능요구사항 전: 🔍 진행 방식, 📮 미션 제출 방법, 🚨 제출 전 체크리스트, ✏️ 과제 진행 요구 사항 읽어보고 →  특이점 docs 체크할 점에 적어두기
2. 🚀 기능 요구 사항 쭉 훑어서 느낌 이해하기: 적지 말고
3. 🎯 프로그래밍 요구 사항: docs 리팩토링 목록에 반영
4. 제공+제한한 클래스는 `참고노트`에 캡쳐해놓기

<br>

## 3. 구상 전, 기능구현목록 작성 (~00:20)
1. README에 입력, 출력, 예외처리 작성
2. 동작 흐름 작성해보기
3. 기능 구현 목록 작성해보기

<br>

## 4. 구상 (1시간)
> 구상하면서 입, 출력 흐름도 따로 그려보기 (`흐름노트`에)

<br>

## 5. 구현


<br>

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
