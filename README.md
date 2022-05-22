## 로또 - 코틀린 API,TDD

## 문자열 덧셈 계산기

### 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 프로그래밍 요구 사항
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.

### 도메인 모델

- `문자열 덧셈 계산기(StringAddCalculator)`
  - [X] null 을 입력할 경우 0을 반환해야 한다
  - [X] 빈 문자열을 입력할 경우 0을 반환해야 한다
  - [X] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다
  - [X] 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다
  - [X] 구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다
  - [X] //와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다
  - [X] 문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다
  
- `계산기 숫자(CalculatorNumber)`
  - [X] 양수인 경우 숫자를 생성한다
  - [X] 0인 경우 숫자를 생성한다
  - [X] 음수인 경우 IllegalArgumentException 예외 처리를 한다
  - [X] 숫자를 더할 수 있다
  - [X] 문자열을 받아 숫자를 생성한다

## 로또

### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 도메인 모델
- `로또 번호(LottoNumber)`
  - 로또 번호는 1~45의 숫자이다.
  - [X] 로또 번호 이외의 숫자가 주어지면 IllegalArgumentException 예외가 발생한다.
  - [X] 로또 번호를 비교할 수 있다.
  
- `로또 티켓(LottoTicket)`
  - 6개의 `로또 번호(LottoNumber)`를 가진다
  - [X] 6개가 아닌 번호들이 주어졌을 경우 IllegalArgumentException 예외가 발생한다.
  - [X] 로또 번호가 주어졌을 때 포함하는지 확인할 수 있다
  - [X] 두 로또 티켓을 비교하여 일치하는 로또 번호의 수를 반환한다

- `로또 티켓들(LottoTickets)`
  - [X] 당첨 번호가 주어졌을 때 들의 당첨 등수들을 확인한다.

- `로또 일치 개수(LottoMatchCount)`
  - [X] 0 ~ 6 사이의 숫자를 가진다

- `당첨결과(LottoRank)`
  - 당첨 결과와 당첨 금액을 가지고 있다 
  - [X] 일치하는 로또 번호의 수가 주어졌을 때 로또 당첨 등수를 반환한다

- `당첨결과들(LottoRanks)`
  - [X] 당첨 결과별 수를 구할 수 있다
  - [X] 수익률을 구할 수 있다

- `로또 발급 기계(LottoMachine)`
  - 로또를 발급한다

- `로또 가게(LottoShop)`
  - `로또 발급 기계(LottoMachine)`를 가진다
  - [X] 로또 구입 금액이 주졌을 때 구입 금액에 해당하는 개수의 로또 티켓을 발급해야 한다

- `금액(Money)`
  - [X] 금액을 더할 수 있다
  - [X] 금액을 나눌 수 있다
  - [X] 금액을 곱할 수 있다
