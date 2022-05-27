package lotto.domain

import lotto.generator.NumbersGenerator

object LottoMarket {
    private const val lottoPrice = 1_000

    fun buy(price: Int): List<LottoTicket> {
        return createLottos(lottoAmount(price))
    }

    fun lottoAmount(price: Int): Int {
        return price / lottoPrice
    }

    private fun createLottos(amount: Int): List<LottoTicket> {
        println("${amount}개를 구매했습니다.")

        val lottos = mutableListOf<LottoTicket>()
        repeat(amount) {
            lottos.add(LottoTicket(NumbersGenerator.create()))
        }

        return lottos
    }
}
