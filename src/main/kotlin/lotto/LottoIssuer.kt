package lotto

object LottoIssuer {
    private const val MIN_PRICE = 1_000

    fun issue(price: Price): Int {
        return price.value / MIN_PRICE
    }
}
