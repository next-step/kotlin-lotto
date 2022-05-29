# kotlin-lotto

## 문자열 덧셈 계산기

### 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
(예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 요구 사항
- [X] 빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다. (예 : “” => 0, null => 0)
- [X] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
- [X] 숫자 두 개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. (예 : “1,2 => 3”)
- [X] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
- [X] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
- [X] 음수나 숫자 이외의 값을 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”, "a,2,3")
- [X] 커스텀 구분자에 숫자를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : "//6\n162")


<br/><br/><br/>

## 로또(자동)

### 기능 요구 사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 요구 사항
- [X] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- [X] 로또 번호는 1에서 45번까지 숫자 6개로 이루어져있다.
- [X] 당첨 번호 입력은 컴마(,)로 구분한다.
- [X] 일치 갯수에 따라 당첨 금액을 계산한다.
  - [X] 3개 일치하면 5,000원
  - [X] 4개 일치하면 50,000원
  - [X] 5개 일치하면 1,500,000원
  - [X] 6개 일치하면 2,000,000,000원
- [X] 당첨 금액별 당첨 갯수를 계산한다.
- [X] 총 수익률을 계산한다(총 당첨 금액 / 구매 금액).
  - [ ] 로또는 번호의 오름차순으로 출력한다.
- [X] 구입 금액이 1000원 미만이면 RuntimeException 예외가 발생한다.
- [X] 당첨 번호에 1~45숫자 이외의 값을 전달하는 경우 RuntimeException 예외가 발생한다.
- [X] 당첨 번호에 6개의 숫자를 전달하지 않는 경우 RuntimeException 예외가 발생한다.