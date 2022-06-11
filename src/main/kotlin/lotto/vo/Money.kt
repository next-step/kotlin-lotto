package lotto.vo

data class Money(private val value: Int) {

    init {
        require(0 < value) { "금액은 0 또는 음수를 가질 수 없다." }
    }

    operator fun minus(other: Money): Money {
        return Money(value - other.value)
    }
}
