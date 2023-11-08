package lotto

@JvmInline
value class Amount(val value: Int) {
    init {
        require(value >= 0)
        require(value % UNIT_AMOUNT == 0)
    }

    companion object {
        private const val UNIT_AMOUNT = 1000
    }

    fun divide(divisor: Int): Int {
        return value.div(divisor)
    }
}
