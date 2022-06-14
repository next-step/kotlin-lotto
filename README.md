# kotlin-lotto

### step1 - 문자열 덧셈 계산기

* [x] 구분자를 기준으로 문자열을 숫자로 변환한다. ( 기본 구분자는 쉼표(,) 와 콜론(:) )
* [x] 숫자의 합을 계산한다.
* [x] 음수가 들어오면 RuntimeException 예외가 발생한다.
* [x] 숫자 이외의 값이 들어오면 RuntimeException 예외가 발생한다.
* [x] 문자열 앞부분에서 "//" 와 "\n"의 사이의 값을 커스텀 구분자로 지정할 수 있다.
* [x] null 이나 비어있는 문자열이 오면 0을 반환한다.

### step2 - 로또(자동)

* [x] 구매 금액을 입력받을 수 있다.
* [x] 로또 번호는 1~45 사이의 수를 가진다.
* [x] 로또는 중복되지 않는 6개의 번호를 가진다.
* [x] 당첨번호는 중복되지 않는 6개의 번호를 가진다.
* [x] 구매 금액 만큼 로또를 발급한다. ( 1장 가격은 1000원 이다. )
* [x] 로또에 존재하는 당첨번호 개수를 계산한다.
* [x] 구매한 로또를 출력한다.
* [x] 당첨 번호를 입력받을 수 있다.
* [x] 당첨통계를 계산한다.
* [x] 당첨통계를 출력한다.
* [x] 총 수익률을 출력한다.

### step3 - 로또(2등)

* [x] 보너스 볼을 입력받을 수 있다.
* [x] 5개 + 보너스 볼이 일치할 경우 2등으로 한다.
* [x] 2등 정보를 출력한다.

### step3 - 로또(수동)

* [x] 수동 구매 개수를 입력받을 수 있다.
* [x] 수동 구매 번호를 입력받을 수 있다.
* [x] 수동 구매가 가능하다.
* [x] 수동 구매를 제외한 나머지 금액은 자동으로 구매한다.
* [x] 구매 금액이 수동 구매에 필요한 금액보다 작을 경우 실패를 알려준다.
