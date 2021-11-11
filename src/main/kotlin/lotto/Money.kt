package lotto

@JvmInline
value class Money private constructor(val value: Int) {
    companion object {
        fun of (value: String): Money {
            TODO()
        }
    }
}
