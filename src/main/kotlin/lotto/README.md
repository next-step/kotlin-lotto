# 기능 요구 사항

* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

# 기능 요구 사항 구현 리스트

- [x] 구입 금액이 1000원 미만이면 IllegalArgumentException을 throw한다. -> Lotto
- [x] 입력받은 구입 금액을 로또 개당 가격으로 나눈 숫자만큼 티켓을 구매한다. -> Lotto
- [x] 입력받은 구입 금액에 맞게 로또를 구매한다. -> Lotto
- [x] 1부터 45까지 숫자중 6개의 숫자를 무작위로 로또 번호를 생성한다. -> LottoNumbers
    - [x] 생성된 로또 번호는 중복이 없다. -> LottoNumbers
- [x] 로또 구매갯수가 음수나 0이면 IllegalArgumentException을 throw한다. -> Lotto
- [x] 당첨 번호를 입력받아서 당첨번호를 생성한다. -> WinningNumber
    - [x] 당첨 번호가 1부터 45 사이의 값이 아니면 IllegalArgumentException을 throw한다. -> WinningNumber(LottoNumber의 메서드 호출)
    - [x] 당첨 번호는 중복이 있으면 안된다. -> WinningNumber(LottoNumber의 메서드 호출)
- [x] 두 개의 로또 번호를 입력받아서 로또 번호가 몇개가 같은지 검증한다. -> LottoNumberComparator
- [x] 로또 번호가 맞은 갯수를 가지고 등수를 계산한다. -> PrizeLevel
- [x] 로또 등수 리스트를 입력받아서 통계를 낸다. -> PrizeLevel
- [ ] 당첨 통계를 가지고 수익률을 계산한다. -> YieldCalculator