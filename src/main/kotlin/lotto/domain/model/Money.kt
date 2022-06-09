package lotto.domain.model

@JvmInline
value class Money private constructor(val value: Int) {
    companion object {
        fun from(value: Int): Money {
            return Money(value.coerceAtLeast(0))
        }
    }
}
