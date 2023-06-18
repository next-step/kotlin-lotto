# kotlin-lotto

## 1단계

### 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 
  - “” => 0
  - "1,2" => 3
  - "1,2,3" => 6
  - “1,2:3” => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 기능 구현 사항
- [x] 빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다.
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. (예 : “1,2”)
- [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
- [x] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
- [x] 0 또는 양수가 아닌 문자를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)

## 2단계

### 기능 요구 사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 기능 구현 사항
- [x] 로또 구입을 위한 구입 금액을 입력 받는다. 단, 부정확한 입력은 고려하지 않는다. (ex. 음수, 1000원으로 떨어지지 않는 수 등)
- [x] 구입 금액을 입력하면 구입 금액 만큼의 로또 게임 목록을 반환한다.
- [x] 한장의 로또 게임에 담긴 로또 번호 개수는 6개이다.
- [x] 로또 게임에 담긴 로또 번호 목록에는 중복이 없다.
- [x] 로또 게임에 담긴 로또 번호 목록은 오름차순 정렬이 되어있다.
- [x] 각 로또 번호의 범위는 1 이상 45 이하이다.
- [ ] 구매한 로또 게임 전체를 출력한다.
- [x] 구매한 로또 게임 개수를 출력한다.
- [ ] 지난 주 당첨 번호를 입력 받는다. 단, 부정확한 입력은 고려하지 않는다. (ex. 중복 존재, 당첨 번호 개수 부족 또는 초과, 로또 번호 범위 아님 등) 
- [ ] 로또 종이 목록과 당첨 번호를 입력하면 로또 번호 일치 결과를 반환한다.
- [ ] 로또 종이 목록과 당첨 번호를 입력하면 수익률을 반환한다.
- [ ] 로또 번호 일치 결과를 출력한다.
- [ ] 수익률을 출력한다.
