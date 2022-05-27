## 도메인 클래스의 역할과 책임

- Lotto - 로또 번호와 당첨 번호를 비교해주는 역할과 책임
- LottoSeller - 구매 금액만큼 로또를 생성해서 판매하는 역할과 책임 (LottoNumberFactory, CashRegister 을 활용, LottoSellerResultDto 활용(거스름돈, 구매한 로또들))
- CashRegister - 판매 로또 갯수와 초과한 금액을 계산해주는 역할과 책임 (CashRegisterResultDto 필요)
- LottoNumberFactory - 로또 번호를 자동으로 생성해주는 역할과 책임 (CashRegister 에서 받아온 로또 갯수만큼 발행)
- LottoWinningNumbers - 구매한 로또들의 Rank 와 수익률을 알려주는 역할과 책임 (Lotto, LottoProfit 을 활용)
- LottoProfit - 수익률을 계산해주는 역할과 책임
- LottoRank - 등수에 따른 맞춰야 되는 숫자 갯수와 당첨 금액을 지니고 있는 역할과 책임

## 도메인 클래스별 기능 명세

Lotto
- [x] 로또 번호와 당첨 번호를 비교해서 일치하는 Rank 를 알려준다.
- [x] 로또 번호가 1 - 44 까지 범위를 가지지 않으면 오류를 발생시킨다.
- [x] 로또 번호 중에 중복된 번호가 있다면 오류를 발생시킨다.

LottoSeller
- [x] 구매 금액만큼 로또를 생성해서 판매한다.
- [ ] 구매 금액이 초과하면 거스름돈을 반환한다.

CashRegister
- [ ] 거스름돈과 로또 구매 갯수를 계산한다.
- [ ] 구매 금액이 부족하면 오류를 발생시킨다.

LottoNumberFactory
- [x] 1 - 44 까지 범위의 중복되지 않는 6개의 랜덤한 숫자를 가진 로또를 만든다. <- 테스트 코드 X

LottoWinningNumbers
- [ ] 구매한 로또들의 Rank 와 수익률을 알려준다.

LottoProfit
- [ ] 수익률을 계산해서 수익률과 손해/이익 인지를 알려준다.

