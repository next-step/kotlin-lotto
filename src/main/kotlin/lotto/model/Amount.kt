package lotto.model

@JvmInline
value class Amount private constructor(val value: Int) {

    companion object {
        operator fun invoke(value: Int): Amount = Amount(value.coerceAtLeast(0))
    }
}

operator fun Amount.div(price: Price): Int = this.value / price.value

operator fun Amount.compareTo(value: Int): Int = this.value.compareTo(value)
