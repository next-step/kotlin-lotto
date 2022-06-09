package lotto.domain.model

@JvmInline
value class PurchaseCount private constructor(val value: Int) {
    fun coerceAtMost(maximumValue: PurchaseCount): PurchaseCount {
        return PurchaseCount(value.coerceAtMost(maximumValue.value))
    }

    companion object {
        fun from(value: Int): PurchaseCount {
            return PurchaseCount(value.coerceAtLeast(0))
        }

        fun of(purchaseAmount: Money, price: Money): PurchaseCount {
            return PurchaseCount((purchaseAmount.value / price.value).coerceAtLeast(0))
        }
    }
}
