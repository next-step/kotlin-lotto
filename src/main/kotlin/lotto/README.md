# 기능 요구사항 - Step2

* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

# 기능 요구사항 구현 체크리스트 - Step2

* Lotto

- [x] 구입 금액이 1000원 미만이면 IllegalArgumentException을 throw한다.
- [x] 입력받은 구입 금액을 로또 개당 가격으로 나눈 숫자만큼 티켓을 구매한다.
- [x] 입력받은 구입 금액에 맞게 로또를 구매한다.
- [x] 로또 구매갯수가 음수나 0이면 IllegalArgumentException을 throw한다.

* LotteryPapers

- [x] 1부터 45까지 숫자중 6개의 숫자를 무작위로 로또 번호를 생성한다.
- [x] 로또 용지에 중복이 생기면 IllegalArgumentException을 throw한다.

* LottoNumbers

- [x] 생성된 로또 번호는 중복이 없다.

* LotteryPaperValidator

- [x] 새로 생성한 로또 용지가 이미 존재하면 IllegalArgumentException을 throw한다.
- [x] 당첨 번호가 1부터 45 사이의 값이 아니면 IllegalArgumentException을 throw한다.

* LottoNumberComparator

- [x] 두 개의 로또 번호를 입력받아서 로또 번호가 몇개가 같은지 검증한다.

* PrizeLevel

- [x] 로또 번호가 맞은 갯수를 가지고 등수를 계산한다.
- [x] 로또 등수 리스트를 입력받아서 통계를 낸다.

* LottoMatcher

- [x] 로또 번호와 당첨 번호를 가지고 당첨 통계를 낸다.

* YieldCalculator

- [x] 당첨 통계를 가지고 수익률을 계산한다.

# 기능 요구사항 - Step3

* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

1등 - 6개 번호 모두 일치
2등 - 5개 번호 일치 + 나머지 1개가 2등 보너스볼 번호 일치
3등 - 5개 번호 일치
4등 - 4개 번호 일치
5등 - 3개 번호 일치

# 기능 요구사항 구현 체크리스트 - Step3

* WinningNumber

- [x] 당첨 번호를 입력받아서 당첨번호를 생성한다.
    - [x] 당첨 번호는 중복이 있으면 안된다.
- [x] LottoNumber 타입인 보너스 넘버를 가진다.
- [x] 보너스 넘버는 생성할 때 1부터 45사이의 숫자를 값으로 가진다.
- [x] 보너스 넘버는 당첨 번호와 중복되지 않는다.


* PrizeLevel

- [x] 3등일때 남은 숫자가 보너스 넘버와 같은지 체크한다.
- [x] 3등이 아니면 체크하지않는다.

# 기능 요구사항 - Step4

