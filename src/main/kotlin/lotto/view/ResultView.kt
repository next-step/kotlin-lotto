package lotto.view

import lotto.domain.Lotto
import lotto.domain.Prize.FIRST
import lotto.domain.Prize.SECOND
import lotto.domain.Prize.THIRD
import lotto.domain.Prize.FOURTH
import lotto.domain.Prize.FIFTH
import lotto.domain.WinningStats

class ResultView {
    fun showLottoNums(lottoNums: MutableList<Lotto>) {
        println(LOTTO_COUNT_MSG.format(lottoNums.size))
        lottoNums.forEach { println(it.nums) }
        println()
    }

    fun showWinningStats(stats: WinningStats) {
        println(WINNING_STATS_MSG)
        PRIZES.forEach {
            if (it == SECOND) {
                println(SECOND_MATCH_COUNT_MSG.format(it.matchCount, it.money, stats.getWinningCountByPrize(it)))
            } else {
                println(MATCH_COUNT_MSG.format(it.matchCount, it.money, stats.getWinningCountByPrize(it)))
            }
        }
        println(PROFIT_RATE_MSG.format(stats.getProfitRate()))
    }

    companion object {
        private const val LOTTO_COUNT_MSG = "%d개를 구매했습니다."
        private const val WINNING_STATS_MSG = "\n당첨 통계\n---------"
        private const val MATCH_COUNT_MSG = "%d개 일치 (%d원)- %d개"
        private const val SECOND_MATCH_COUNT_MSG = "%d개 일치, 보너스 볼 일치(%d원)- %d개"
        private const val PROFIT_RATE_MSG = "총 수익률은 %.2f입니다."
        private val PRIZES = listOf(FIFTH, FOURTH, THIRD, SECOND, FIRST)
    }
}
