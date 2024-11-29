package lotto

import lotto.domain.Order

class LottoShop(private val lottoCreator: LottoCreator) {
    fun makeOrder(amount: Int): Order {
        validateAmountIsPositive(amount)
        val lottoCounts = calculateLottoCounts(amount)
        return Order(amount, lottoCreator.createLottos(lottoCounts))
    }

    private fun validateAmountIsPositive(amount: Int) {
        require(amount > 0) { "로또 구매 금액은 음수이거나 0원일 수 없습니다. (현재 입력 금액: $amount)" }
    }

    private fun calculateLottoCounts(amount: Int): Int {
        require(amount % UNIT_OF_AMOUNT == 0) { "로또 구매 금액은 1000원 단위로 입력되어야 합니다. (현재 입력 금액: $amount)" }
        return amount / UNIT_OF_AMOUNT
    }

    companion object {
        const val UNIT_OF_AMOUNT = 1000
    }
}
