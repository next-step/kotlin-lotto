package lotto.domain.value

class Price(
    val value: Long
) {
    constructor(request: String) : this(request.toLong())

    init {
        if (value < 0) {
            throw IllegalArgumentException("지불 금액은 0보다 작을 수 없습니다. value: $value")
        }
    }

    fun calculateRate(price: Price): Double {
        return (value.toDouble() / price.value) + (value.toDouble() % price.value)
    }

    operator fun div(value: Long): Long {
        return this.value / value
    }
}
