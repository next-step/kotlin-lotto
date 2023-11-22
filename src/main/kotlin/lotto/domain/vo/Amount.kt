package lotto.domain.vo

@JvmInline
value class Amount private constructor(val value: Int) {
    init {
        require(value >= 0) { "0 이상의 값을 다룰 수 있습니다." }
    }

    fun toDouble(): Double =
        value.toDouble()

    operator fun times(other: Int): Amount =
        Amount(value * other)

    operator fun div(other: Amount): Amount =
        Amount(value / other.value)

    companion object {
        fun of(value: Int) = Amount(value)
    }
}
