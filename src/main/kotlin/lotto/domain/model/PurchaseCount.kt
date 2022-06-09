package lotto.domain.model

@JvmInline
value class PurchaseCount private constructor(val value: Int) {
    companion object {
        fun of(purchaseAmount: Money, price: Money): PurchaseCount {
            return PurchaseCount(purchaseAmount.value / price.value)
        }
    }
}
