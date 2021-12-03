# kotlin-lotto

## 문자열 덧셈 계산기

### 기능 요구 사항
* 쉼표(`,`) 또는 콜론(`:`)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
  * (예: `  ` => `0`, `1,2` => `3`, `1,2,3` => `6`, `1,2:3` => `6`)
* 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
  * 커스텀 구분자는 문자열 앞부분의 `//`와 `\n` 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  * 예를 들어 `//;\n1;2;3`과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(`;`)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 `RuntimeException` 예외를 `throw` 한다.

### 프로그래밍 요구 사항
* `indent`(인덴트, 들여쓰기) `depth`를 2를 넘지 않도록 구현한다.
  * 1까지만 허용한다.
  * 예를 들어 `while`문 안에 `if`문이 있으면 들여쓰기는 2이다.
* 힌트: `indent`(인덴트, 들여쓰기) `depth`를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
* 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.

### 힌트
* `빈 문자열` 또는 `null`을 입력할 경우 `0`을 반환해야 한다. (예 : ` ` => `0`, `null` => `0`)
  ~~~
  if (text.isNullOrEmpty())
  if (text.isNullOrBlank())
  ~~~
* 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
  ~~~
  val number = text.toInt();
  ~~~
* 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. (예 : “1,2”)
  ~~~
  val numbers = text.split(",")
  ~~~
* 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
  ~~~
  val tokens = text.split(",|:")
  ~~~
* "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
* 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
  ~~~
  class StringAddCalculatorTest {
      private lateinit var calculator: StringAddCalculator

      @BeforeEach
      void setUp() {
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
  ~~~

## 로또

### 1단계 기능 요구 사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 `1`장의 가격은 `1000`원이다.

### 2단계 기능 요구 사항
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

### 3단계 기능 요구 사항
* 현재 로또 생성기는 자동 생성 기능만 제공한다.
  * 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
* 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.
