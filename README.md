# kotlin-lotto

## 문자열 덧셈 계산기

### 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 `RuntimeException` 예외를 throw 한다.

### 기능 상세 목록


- [x] 문자열을 받아 구분자를 기준으로 분리한 숫자의 합을 반환한다.
- [x] 구분자는 쉼표(,) 또는 콜론(:)이 기본적으로 적용된다.
- [x] 빈 문자열 또는 null을 입력할 경우 0을 반환한다.
- [x] 숫자 하나는 그대로 반환한다.
- [x] 커스텀 구분자를 지정할 수 있다.
- [x] 커스텀 구분자는 문자열 앞 부분에 "//"와 "\n" 사이에 있는 문자를 커스텀 구분자로 사용한다. 
- [x] 숫자 이외의 값 또는 음수를 전달 받으면 RuntimeException 이 발생한다.

### 프로그래밍 요구 사항

- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.

## 로또

### 기능 요구 사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 기능 상세 목록

- [x] 구입 금액을 입력 받는다.
- [x] 구입 개수를 출력한다.
- [x] 입력 받은 구입 금액에 따라 로또를 발급한다.
- [x] 로또 숫자는 1부터 45까지의 숫자다.
- [x] 로또 1장은 모두 다른 6개의 로또 숫자로 구성된다.
- [x] 로또 1장의 가격은 1000원이다
- [x] 로또 등수에 따른 당첨 금액을 설정할 수 있다.
- [x] 구매한 로또 번호를 출력한다.
- [x] 지난 주 당첨 번호를 입력 받는다.
- [x] 당첨 번호 입력이 잘못된 경우 IllegalArgumentException 이 발생한다.
- [ ] 구매한 로또에 대한 당첨 통계를 계산한다.
- [ ] 총 수익률을 계산한다. 
- [ ] 당첨 통계와 총 수익률을 출력한다.

### 프로그래밍 요구 사항

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
