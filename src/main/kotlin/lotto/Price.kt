package lotto

@JvmInline
value class Price(val amount: Int) {
    init {
        require(amount > MIN_PRICE)
    }

    companion object {
        private const val MIN_PRICE = 0
    }
}
