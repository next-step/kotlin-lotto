package lotto.vo

data class Money(val money: Int) {
    init {
        require(money >= DEFAULT_MONEY) { "돈은 0보다 작을 수 없습니다." }
    }

    operator fun div(right: Money) = this.money / right.money

    companion object {
        private const val DEFAULT_MONEY = 0
        fun from(num: String): Money {
            return Money(
                num.toIntOrNull() ?: throw IllegalArgumentException("돈은 정수형만 가능합니다. Invalid argument : $num")
            )
        }
    }
}
