# kotlin-lotto

# 문자열 계산기
## 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 기능 목록
### 문자열 계산기
- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
- [x] 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.
- [x] 구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.
- [x] //와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.

### 문자열 계산기 숫자
- [x] 문자열로 음수가 아닌 숫자를 전달하는 경우 숫자로 변환할 수 있다.
- [x] 문자열로 숫자 이외의 값을 전달하는 경우 RuntimeException 예외 처리를 한다.
- [x] 문자열로 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.

### 문자열 계산 변환기
- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한다.
- [x] //와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.
- [x] //와 \\n 문자 사이에 커스텀 구분자로 가지는 문자열을 전달하는 경우 커스텀 구분자를 기준으로 분리한다.

# 로또
## 기능 요구 사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

## 기능 목록
### 로또 LottoTest
- [x] 로또의 숫자 개수가 6이면 로또를 생성한다.
- [x] 로또의 숫자 개수가 6이 아니면 IllegalArgumentException 예외를 던진다.
- [x] 로또 숫자가 중복된 경우 IllegalArgumentException 예외를 던진다.
- [x] 자동으로 생성한 로또 번호의 수는 6이다.

### 로또 구입 금액 LottoCashTest
- [x] 로또 구입 금액을 전달하는 경우 숫자로 변환할 수 있다.
- [x] 로또 구입 금액으로 음수를 전달하는 경우 IllegalArgumentException 예외를 던진다.

### 로또 판매점 LottoStoreTest
- [x] 로또를 구매할 수 있는 구입 금액이 주어지면 로또를 구매할 수 있다.
- [x] 로또를 구매할 수 없는 구입 금액이 주어지면 로또를 구매할 수 없다.
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- [x] 로또 1장의 가격은 1000원이다.
- [x] 로또 번호와 지난주 당첨 번호가 주어지면 당첨 통계를 확인할 수 있다.

### 로또 숫자 LottoNumberTest
- [x] 로또 숫자 범위 내의 값을 전달하는 경우 숫자로 변환할 수 있다.
- [x] 로또 숫자의 범위를 벗어난 경우 IllegalArgumentException 예외를 던진다.

### 지난주 로또 당첨 번호 LastWeekMatchLottoTest
- [x] 지난주 로또 당첨 번호는 6개 번호가 있다.
- [x] 지난주 로또 당첨 번호는 보너스 번호가 있다.

### 로또 등수 RankTest
- [x] 로또 번호가 3개 이상 일치하면 상금이 있다.
- [x] 로또 번호가 3개 미만으로 일치하면 상금이 없다.
- [x] 로또 번호가 5개 일치하고 보너스 볼이 일치하지 않으면 3등이다.
- [x] 로또 번호가 5개 일치하고 보너스 볼이 일치하면 2등이다.
- [x] 로또 번호가 6개 일치하면 1등이다.
- [x] 로또 번호가 7개 일치하면 IllegalArgumentException 예외가 발생한다.

### 로또 당첨 통계 LottoMatchResultTest
- [x] 로또 구매 금액과 당첨 통계가 주어지면 당첨 결과와 수익률을 확인할 수 있다.
