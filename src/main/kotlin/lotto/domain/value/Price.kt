package lotto.domain.value

class Price(
    val value: Long
) {
    constructor(request: String) : this(request.toLong())

    init {
        require(value >= 0) { "지불 금액은 0보다 작을 수 없습니다. value: $value" }
    }

    fun calculateRate(price: Price): Double {
        return (value.toDouble() / price.value) + (value.toDouble() % price.value)
    }

    operator fun div(value: Long): Long {
        return this.value / value
    }

    operator fun minus(price: Price): Price {
        return Price(this.value - price.value)
    }
}
