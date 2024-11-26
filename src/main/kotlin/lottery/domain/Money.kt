package lottery.domain

@JvmInline
value class Money(private val amount: Int) {
    init {
        require(amount >= 0) { "금액은 0 이상이어야 합니다" }
    }

    fun isDivisibleBy(value: Int): Boolean {
        require(value != 0) { "0으로 나눌 수 없습니다" }
        return amount % value == 0
    }

    override fun toString(): String {
        return "${amount}원"
    }

    companion object {
        val ZERO = Money(0)
    }

    operator fun plus(other: Money): Money {
        return Money(amount + other.amount)
    }

    operator fun times(count: Int): Money {
        return Money(amount * count)
    }

    operator fun div(other: Money): Double {
        require(other.amount != 0) { "나누는 금액은 0 일 수 없습니다" }
        return amount.toDouble() / other.amount
    }

    operator fun compareTo(other: Money): Int {
        return amount.compareTo(other.amount)
    }
}
