package lotto.domain

class LottoPurchase {
    fun purchaseAuto(budget: Int, priceOfLotto: Int): List<Lotto> {
        val amount = affordableLottoCount(budget, priceOfLotto)

        val result = mutableListOf<Lotto>()
        repeat(amount) {
            result.add(Lotto.auto())
        }
        return result
    }

    fun affordableLottoCount(budget: Int, priceOfLotto: Int): Int {
        return budget / priceOfLotto
    }

    companion object {
        const val DEFAULT_PRICE: Int = 1000
    }
}
