# kotlin-lotto

## 1단계 - 문자열 덧셈 계산기

### 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.


--- 
## 2단계 - 로또(자동)

### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.



---
## 3단계 - 로또(2등)


### 기능 요구사항
- [x] 2등을 위해 추가 번호를 하나 더 추첨한다.
  - [x] 보너스 볼을 입력 받는다.
  - [x] 보너스 볼 숫자를 기반으로 등수를 다시 체크한다.
  - [x] 로또 통계의 보너스 볼 등급을 추가한다.
- [x] 당첨 통계에 2등도 추가해야 한다.



---
## 4단계 - 로또(수동)


### 기능 요구사항
- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

- [x] 수동 로또 개수를 입력 받는다.
- [x] 수동 번호를 입력 받는다. 
