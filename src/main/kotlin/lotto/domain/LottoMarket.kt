package lotto.domain

object LottoMarket {
    private const val lottoPrice = 1_000

    fun buy(price: Int): Lottos {
        return createLottos(lottoAmount(price))
    }

    fun lottoAmount(price: Int): Int {
        return price / lottoPrice
    }

    private fun createLottos(amount: Int): Lottos {
        println("${amount}개를 구매했습니다.")

        val lottos = mutableListOf<LottoTicket>()
        repeat(amount) {
            lottos.add(LottoTicket(LottoNumber()))
        }

        return Lottos(lottos.toList())
    }
}
