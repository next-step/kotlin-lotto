package lotto.model

@JvmInline
value class Size private constructor(val value: Int) {

    companion object {
        fun valueOf(value: Int): Size = Size(value.coerceAtLeast(0))
    }
}
