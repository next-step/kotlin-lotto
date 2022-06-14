package lotto.domain.model

@JvmInline
value class Money private constructor(val value: Int) {
    operator fun minus(other: Money): Money {
        return from(value - other.value)
    }

    companion object {
        fun from(value: Int): Money {
            return Money(value.coerceAtLeast(0))
        }

        fun of(purchaseCount: PurchaseCount, price: Money): Money {
            return Money(purchaseCount.value * price.value)
        }
    }
}
