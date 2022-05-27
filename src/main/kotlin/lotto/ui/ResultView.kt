package lotto.ui

import lotto.domain.LottoTickets
import lotto.domain.Receipt
import lotto.domain.StatResults

class ResultView {
    fun result(
        receipt: Receipt,
        lottoTickets: LottoTickets,
        statResults: StatResults,
        yields: Double
    ) {
        buyCount(receipt.lottoCount)
        lottoNumbers(lottoTickets)
        stat(statResults)
        yields(yields)
    }

    private fun buyCount(count: Int) {
        println("$count" + BUY_COUNT_TEXT)
    }

    private fun lottoNumbers(lottoTickets: LottoTickets) {
        lottoTickets.lottoTickets.forEach { println(it.toText()) }
    }

    private fun stat(statResults: StatResults) {
        println(WINING_STAT_TEXT)
        statResults.statResults.forEach {
            println(
                WINING_RESULT_TEXT.format(
                    it.matchState.matchCount,
                    it.matchState.profit,
                    it.count
                )
            )
        }
    }

    fun yields(yields: Double) {
        println(TRY_COUNT_TEXT.format(yields))
    }

    companion object {
        private const val BUY_COUNT_TEXT = "개를 구매했습니다."
        private const val WINING_STAT_TEXT = "\n당첨 통계\n---------"
        private const val WINING_RESULT_TEXT = "%s개 일치 (%s원)- %s개"
        private const val TRY_COUNT_TEXT = "총 수익률은 %s입니다."
    }
}
