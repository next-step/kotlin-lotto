package step2.lotto.domain

class PurchaseItem private constructor(buyAmount: BuyAmount, val lottos: Lottos) {
    val buyAmount: Int = buyAmount.value
    val tryCount: Int = buyAmount.tryCount

    companion object {
        fun of(buyAmount: BuyAmount, lottos: Lottos): PurchaseItem =
            PurchaseItem(buyAmount, lottos)
    }
}
