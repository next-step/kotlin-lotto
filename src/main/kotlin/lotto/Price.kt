package lotto

@JvmInline
value class Price(val amount: Int) {
    init {
        require(amount >= LOTTO_PRICE)
    }
}
