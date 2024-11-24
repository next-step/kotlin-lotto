package lotto

object LottoIssuer {
    private const val MIN_PRICE = 1_000

    fun buy(price: Price): List<LottoNumbers> {
        var currentPrice = price
        val lottoNumbers = mutableListOf<LottoNumbers>()
        while (currentPrice.isMoreThan(MIN_PRICE)) {
            currentPrice = currentPrice.subtract(MIN_PRICE)
            lottoNumbers.add(LottoNumbers.generate())
        }
        return lottoNumbers
    }
}
