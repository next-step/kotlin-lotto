package lotto.model

@JvmInline
value class Amount private constructor(val value: Int) {

    companion object {
        fun valueOf(value: Int): Amount = Amount(value.coerceAtLeast(0))
    }
}

operator fun Amount.div(price: Price): Int = this.value / price
