# 기능 구현 사전 계획

## 프로그래밍 요구 사항
- 들여쓰기 깊이는 2를 넘지 않도록 한다. (1까지만 허용한다.)
  - 예를 들어 while문 안에 if문이 있다면 들여쓰기는 2가 된다. -> while을 사용했다면 내부에 if는 사용할 수 없다.
- 함수의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수가 한 가지 일만 잘 하도록 구현한다.

## 문자열 덧셈 계산기

- [x] 문자열은 쉼표(,) 또는 콜론(:)을 구분자로 가져야 한다.
- [x] 구분자를 기준으로 숫자를 분리해야 한다.
- [x] 분리된 숫자들의 합을 계산해야 한다.
  - [x] ""은 0이다.
  - [x] "1,2"는 3이다.
  - [x] "1,2,3"은 6이다.
  - [x] 숫자 하나를 문자열로 입력하면 해당 숫자를 반환한다.
  - [x] "1,2:3"은 6이다.
- [x] 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
  - [x] 단, 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치해야 한다.
- [ ] "//;\n1;2;3"의 커스텀 구분자는 세미콜론(;)이어야 하며, 결과는 6이어야 한다.
- [ ] 숫자 이외의 값이나 음수를 전달하면 `RuntimeException` 예외를 throw 한다.
  - [ ] "-1,2,3"은 `RuntimeException` 예외를 발생시킨다.

## 테스트 코드

```kotlin
class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator();
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(text: String) {
        assertThat(calculator.add(text)).isZero();
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun oneNumber(text: String) {
        assertThat(calculator.add(text)).isSameAs(Integer.parseInt(text));
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun twoNumbers(text: String) {
        assertThat(calculator.add(text)).isSameAs(3);
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun colons(text: String) {
        assertThat(calculator.add(text)).isSameAs(6);
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(text: String) {
        assertThat(calculator.add(text)).isSameAs(6);
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    fun negative() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy(() -> calculator.add("-1"));
    }
}
```

