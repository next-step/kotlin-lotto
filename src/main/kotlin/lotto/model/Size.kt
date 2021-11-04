package lotto.model

@JvmInline
value class Size private constructor(val value: Int) {

    companion object {
        fun from(value: Int): Size = Size(value.coerceAtLeast(0))
    }
}
