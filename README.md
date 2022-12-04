# kotlin-lotto

## 1단계 - 문자열 덧셈 계산기

### 기능목록

- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
- [x] 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.
- [x] 구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.
- [x] //와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.
- [x] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.
- [x] 숫자 이외의 값 또는 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.

### 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 `RuntimeException` 예외를 throw 한다.

## 2단계 - 로또(자동)

### 기능목록

 - [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 개수만큼 로또를 발급해야 한다.
 - [x] 로또 구입 금액은 1000원 이상이어야 한다.
 - [x] 로또 번호는 자리당 1 부터 45 까지의 숫자로 구성된다.
 - [x] 로또 번호는 6개로 구성되며, 중복된 번호가 존재하면 안된다.
 - [x] 로또 번호는 오름차순으로 정렬되어야 한다.
 - [x] 당첨 번호 입력 시 구분자는 쉼표공백(, )으로 한다.
 - [x] 당첨 번호와 로또 번호가 일치하는 개수를 구할 수 있다.
 - [x] 당첨 번호와 로또 번호가 일치하는 개수에 따라 당첨 금액을 계산할 수 있다.
 - [x] 수익률을 계산할 수 있다.

### 기능 요구 사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

## 3단계 - 로또(2등)

### 기능목록
 - [x] 보너스 볼을 입력할 수 있다.
 - [x] 보너스 볼은 1 부터 45 까지의 숫자로 구성된다.
 - [x] 당첨 번호와 보너스 번호는 중복되서는 안된다.
 - [ ] 보너스 볼과 로또 번호가 일치하는 개수를 구할 수 있다. (2등)
 - [ ] 당첨 번호와 보너스 볼, 로또 번호가 일치하는 개수에 따라 당첨 금액을 계산할 수 있다.
 - [ ] 2등 결과 추가에 따른, 수익률을 계산할 수 있다.

### 기능 요구 사항
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.
