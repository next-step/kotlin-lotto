package lotto

object LottoIssuer {
    private const val MIN_PRICE = 1_000

    fun buy(price: Price): List<LottoNumbers> {
        val count = price.getPurchasableCount(MIN_PRICE)
        return List(count) { LottoNumbers.generate() }
    }
}
