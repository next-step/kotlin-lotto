package lotto

object LottoIssuer {
    private const val MIN_PRICE = 1_000

    private val lottoNumbers = mutableListOf<LottoNumbers>()

    fun buy(price: Price): List<LottoNumbers> {
        var currentPrice = price
        while (currentPrice.isMoreThan(MIN_PRICE)) {
            currentPrice = currentPrice.subtract(MIN_PRICE)
            lottoNumbers.add(LottoNumbers.generate())
        }
        return lottoNumbers
    }
}
