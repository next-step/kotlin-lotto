package lotto.domain

object LottoMachine {
    private const val LOTTO_COST = 1000

    fun buy(money: Int): LottoList {
        validation(money)
        val count = calculateCount(money)
        return LottoList(List(count) { LottoNumbers.random() })
    }

    private fun calculateCount(money: Int): Int {
        return money / LOTTO_COST
    }

    private fun validation(money: Int) {
        require(money >= 0) { "구매금액은 0 이상이여야 한다." }
    }
}
