package lottery.domain

data class Money(val amount: Int) {
    init {
        require(amount >= 0) { "금액은 0 이상이어야 합니다" }
    }

    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount)
    }

    operator fun times(count: Int): Money {
        return Money(this.amount * count)
    }

    fun divideBy(other: Money): Double {
        require(other.amount != 0) { "나누는 금액은 0 일 수 없습니다" }
        return this.amount.toDouble() / other.amount
    }
}
