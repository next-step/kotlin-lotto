package lotto

@JvmInline
value class Price(val amount: Int) {
    init {
        require(amount >= LOTTO_PRICE)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
