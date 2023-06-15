package lottery.domain

@JvmInline
value class Money(
    val value: Int
) {
    init {
        require(value >= 0) { "돈은 음수가 입력될 수 없다" }
    }

    fun times(count: Int) = Money(value.times(count))

    operator fun minus(money: Money) = Money(value.minus(money.value))

    operator fun div(money: Money) = value.div(money.value)
}
