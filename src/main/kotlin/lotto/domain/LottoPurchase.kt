package lotto.domain

class LottoPurchase {
    fun purchaseAuto(budget: Int, priceOfLotto: Int): Lottos {
        val amount = affordableLottoCount(budget, priceOfLotto)

        val lottos = buildList {
            repeat(amount) {
                add(Lotto.autoCreate())
            }
        }
        return Lottos(lottos)
    }

    fun affordableLottoCount(budget: Int, priceOfLotto: Int): Int {
        return budget / priceOfLotto
    }

    companion object {
        const val DEFAULT_PRICE: Int = 1000
    }
}
