package lotto.ui

import lotto.domain.LottoTickets
import lotto.domain.MatchState
import lotto.domain.Receipt
import lotto.domain.StatResults

class ResultView {
    fun result(
        receipt: Receipt,
        statResults: StatResults,
        yields: Double
    ) {
        buyCount(receipt.lottoCount)
        stat(statResults)
        yields(yields)
    }

    private fun buyCount(count: Int) {
        println("$count" + BUY_COUNT_TEXT)
    }

    fun lottoNumbers(lottoTickets: LottoTickets) {
        lottoTickets.lottoTickets.forEach { println(it.toText()) }
    }

    private fun stat(statResults: StatResults) {
        println(WINING_STAT_TEXT)
        statResults.statResults.forEach {
            println(
                getStatText(it.matchState).format(
                    it.matchState.matchCount,
                    it.matchState.profit,
                    it.count
                )
            )
        }
    }

    private fun getStatText(matchState: MatchState): String {
        return if (matchState == MatchState.MATCH_5_BONUS) WINING_BONUS_TEXT else WINING_RESULT_TEXT
    }

    private fun yields(yields: Double) {
        println(TRY_COUNT_TEXT.format(yields))
    }

    companion object {
        private const val BUY_COUNT_TEXT = "개를 구매했습니다."
        private const val WINING_STAT_TEXT = "\n당첨 통계\n---------"
        private const val WINING_RESULT_TEXT = "%s개 일치 (%s원)- %s개"
        private const val WINING_BONUS_TEXT = "%s개 일치, 보너스 볼 일치(%s원) - %s개"
        private const val TRY_COUNT_TEXT = "총 수익률은 %s입니다."
    }
}
