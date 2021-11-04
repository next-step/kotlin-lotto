package lotto.model

@JvmInline
value class Price private constructor(val value: Int) {

    companion object {
        operator fun invoke(value: Int): Price = Price(value.coerceAtLeast(0))
    }
}

operator fun Int.div(price: Price): Int = this / price.value
