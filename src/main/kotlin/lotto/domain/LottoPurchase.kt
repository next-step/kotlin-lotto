package lotto.domain

class LottoPurchase {
    private val lottoMaker = LottoMaker()

    fun purchaseAuto(amount: Int): List<Lotto> {
        val result = mutableListOf<Lotto>()
        repeat(amount) {
            result.add(lottoMaker.auto())
        }
        return result
    }

    companion object {
        const val DEFAULT_PRICE: Int = 1000

        fun affordableLottoCount(budget: Int): Int {
            return budget / DEFAULT_PRICE
        }
    }
}
