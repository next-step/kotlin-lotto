package lotto

@JvmInline
value class Amount(val value: Int) {
    init {
        require(value >= 0)
    }

    fun divide(divisor: Int): Int {
        return value.div(divisor)
    }
}
