# step1
## 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 `RuntimeException` 예외를 throw 한다.
## 프로그래밍 요구 사항
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
## 기능 목록
- [x] 빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다. (예 : “” => 0, null => 0)
  ``` kotlin
  if (text.isNullOrEmpty())
  if (text.isNullOrBlank())
  ```
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
  ``` kotlin
  val number = text.toInt();
  ```
- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. (예 : “1,2”)
  ``` kotlin
  val numbers = text.split(",")
  ```
- [x] 숫자 두개를 콜론(:) 구분자로 입력할 경우 두 숫자의 합을 반환한다. (예 : “1:2”)
  ``` kotlin
  val numbers = text.split(":")
  ```
- [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
  ``` kotlin
  val tokens = text.split(",|:".toRegex())
  ```
- [x] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
  ``` kotlin
  val result = Regex("//(.)\n(.*)").find(text)
  result?.let {
      val customDelimiter = it.groupValues[1]
      val tokens = it.groupValues[2].split(customDelimiter)
      // ...
  }
  ```
- [x] 숫자 이외의 값을 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “kimdabomi”)
- [x] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
  ``` kotlin
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
  
# step2
## 기능 요구 사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
## 프로그래밍 요구 사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
## 기능 목록
- [x] 구매금액을 입력하면 몇 개를 구매했는지 반환해야 한다.
- [x] 구매금액은 1000원 단위로만 가능하다.
- [x] 구매한 개수만큼 로또를 발급해야 한다.
- [x] 구매한 로또 목록에서 당첨 번호와 일치하는 게 0개이면 낙첨이다. (0원)
- [x] 구매한 로또 목록에서 당첨 번호와 일치하는 게 3개이면 5등이다. (5,000원)
- [x] 구매한 로또 목록에서 당첨 번호와 일치하는 게 4개이면 4등이다. (50,000원)
- [x] 구매한 로또 목록에서 당첨 번호와 일치하는 게 5개이면 3등이다. (1,500,000원)
- [x] 구매한 로또 목록에서 당첨 번호와 일치하는 게 6개이면 1등이다. (2,000,000,000원)
- [x] 로또 번호는 6개, 1부터 45 사이의 숫자, 중복 불가여야 한다.
- [x] 수익률을 계산해야 한다. (당첨 금액 / 구매 금액 의 소수점 둘째자리까지 버림)
## 힌트
- 로또 자동 생성은 shuffled()을 활용한다.
- sorted()를 활용해 정렬 가능하다.
- contains()를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

# step3
## 기능 요구 사항
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.
## 프로그래밍 요구 사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- Enum 클래스를 적용해 프로그래밍을 구현한다.
- 일급 컬렉션을 쓴다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
## 기능 목록
- [x] 구매한 로또 목록에서 당첨 번호와 일치하는 게 5개이고, 남은 한 개의 번호가 보너스 번호와 일치하면 2등이다. (30,000,000원)

# step4
## 기능 요구 사항
- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.
## 프로그래밍 요구 사항
- 모든 원시값과 문자열을 포장한다.
- 예외 처리를 통해 에러가 발생하지 않도록 한다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- Enum 클래스를 적용해 프로그래밍을 구현한다.
- 일급 컬렉션을 쓴다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
## 기능 목록
- [x] 수동으로 로또 번호를 입력할 수 있다.
- [x] 구매한 개수 중에 수동으로 구매한 수량을 제외한 나머지 수량만큼 자동으로 로또를 생성한다.
- [x] 수동으로 입력한 로또 번호와 자동 생성한 로또 번호를 합쳐 로또 목록을 생성한다.