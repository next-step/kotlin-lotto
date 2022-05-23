package lotto.domain

object LottoMarket {
    private const val lottoPrice = 1_000

    fun lottoAmount(price: Int): Int {
        return price / lottoPrice
    }
}
