package lotto.domain

class Money(private val budget: Int) {
    fun requestLottoPurchaseCount(): Int {
        return budget / LOTTO_DEFAULT_PRICE
    }

    fun requestBuyLotto(count: Int): List<Lotto> {
        val lotto = mutableListOf<Lotto>()
        repeat(count) {
            lotto.add(Lotto())
        }
        return lotto
    }

    companion object {
        private const val LOTTO_DEFAULT_PRICE = 1000
    }
}
