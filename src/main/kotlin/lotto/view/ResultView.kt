package lotto.view

import lotto.domain.Lotto

object ResultView {
    fun displayLottoTicketCount(ticketCount: Int) {
        println("${ticketCount}개를 구매했습니다.")
    }

    fun printAutoGenerateLotto(lottos: List<Lotto>) {
        val lottoResults = lottos.joinToString(separator = "\n") { lottoString(it) }
        println(lottoResults)
    }

    private fun lottoString(lotto: Lotto) =
        lotto.numbers.joinToString(separator = ", ", prefix = "[", postfix = "]") {
            it.value.toString()
                .padStart(2, ' ')
        }
}
