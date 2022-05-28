package lotto

@JvmInline
value class Money(val amount: Int) {
    init {
        require(amount >= MONEY_MIN_AMOUNT)
    }

    companion object {
        private const val MONEY_MIN_AMOUNT = 1000
    }
}
