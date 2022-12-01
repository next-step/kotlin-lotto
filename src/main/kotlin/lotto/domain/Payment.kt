package lotto.domain

private const val MIN = 1000

@JvmInline
value class Payment(val value: Int) {
    init {
        require(value % MIN == 0)
    }

    fun toDouble(): Double {
        return value.toDouble()
    }
}
