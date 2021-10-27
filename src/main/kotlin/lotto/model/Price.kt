package lotto.model

data class Price(
    val price: Int?
) {
    init {
        require(price != null && price >= MIN_PRICE) { EXCEPTION_PRICE_NULL }
        require(price % MIN_PRICE == 0) { EXCEPTION_PRICE_FORMAT }
    }

    companion object {
        private const val MIN_PRICE = 1000
        const val EXCEPTION_PRICE_NULL = ""
        const val EXCEPTION_PRICE_FORMAT = ""
    }
}
