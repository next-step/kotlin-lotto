package lotto.domain.value

class Price(
    val value: Long
) {
    constructor(request: String) : this(request.toLong())

    init {
        require(value >= 0) { "지불 금액은 0보다 작을 수 없습니다. value: $value" }
    }

    fun rate(price: Price): Double {
        return (value.toDouble() / price.value)
    }

    operator fun div(value: Long): Long {
        return this.value / value
    }

    operator fun minus(price: Price): Price {
        return Price(this.value - price.value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Price

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
