package lotto.vo

@JvmInline
value class Money(private val value: Int) {

    init {
        require(0 <= value) { "금액은 음수를 가질 수 없다." }
    }

    operator fun minus(other: Money) = Money(value - other.value)

    fun isGreaterOrEqualThan(money: Money) = value >= money.value
}
