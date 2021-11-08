package lotto.model

@JvmInline
value class Price private constructor(val value: Int) {

    fun isEmpty(): Boolean = value == 0

    companion object {
        fun valueOf(value: Int): Price = Price(value.coerceAtLeast(0))
    }
}

operator fun Int.div(price: Price): Int = if (price.isEmpty()) 0 else this / price.value
