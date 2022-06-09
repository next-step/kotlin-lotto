package lotto.domain.model

@JvmInline
value class Cash private constructor(val value: Int) {
    companion object {
        fun from(value: Int): Cash {
            return Cash(value.coerceAtLeast(0))
        }
    }
}
