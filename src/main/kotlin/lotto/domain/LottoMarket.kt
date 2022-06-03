package lotto.domain

object LottoMarket {
    private const val lottoPrice = 1_000

    fun buy(price: Int): Lottos {
        return Lottos.of(lottoAmount(price))
    }

    private fun lottoAmount(price: Int): Int {
        val amount = price / lottoPrice
        println("${amount}개를 구매했습니다.")
        return amount
    }
}
