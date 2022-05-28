package lotto.domain

class LottoSeller(
    private val lottoGenerator: LottoGenerator = RandomLottoGenerator
) {
    fun sellAutoLotto(receivedMoney: Money): LottoBundle {
        require(receivedMoney >= 0) { "금액이 입금되지 않았습니다" }
        val numberOfLotto = getAvailableAmountOfLotto(receivedMoney)

        val bundle = List(numberOfLotto) {
            lottoGenerator.generate()
        }

        return LottoBundle(bundle)
    }

    fun sellManualLotto(receivedMoney: Money, coupons: List<LottoCoupon>): LottoBundle {
        val amountOfPurchase = coupons.size * PRICE_OF_LOTTO
        require(receivedMoney.amount >= amountOfPurchase) { "로또를 구매하기 부족한 금액입니다" }

        val bundle = coupons.map { it.toLotto() }

        return LottoBundle(bundle)
    }

    fun getPayment(amountOfLotto: Int): Money {
        return Money(amountOfLotto * PRICE_OF_LOTTO)
    }

    fun getAvailableAmountOfLotto(money: Money): Int = money.amount / PRICE_OF_LOTTO

    companion object {
        private const val PRICE_OF_LOTTO = 1000
    }
}
