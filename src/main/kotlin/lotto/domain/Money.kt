package lotto.domain


@JvmInline
value class Money private constructor(val value: Int) {
    operator fun times(number: Int): Money {
        return Money(value * number)
    }

    operator fun plus(other: Money): Money {
        return Money((value + other.value))
    }

    companion object {

        fun of(value: String?): Money {
            require(!value.isNullOrBlank()) { "지불 금액은 비어있거나 null일 수 없습니다." }
            require(value.toInt() >= 0) { "지불 금액은 0보다 작을 수 없습니다." }
            return Money(value.toInt())
        }

        fun of(value: Int) = Money(value)
    }
}
