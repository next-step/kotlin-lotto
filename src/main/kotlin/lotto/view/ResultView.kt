package lotto.view

import lotto.domain.Lotto
import lotto.domain.Prize.FIRST
import lotto.domain.Prize.SECOND
import lotto.domain.Prize.THIRD
import lotto.domain.Prize.FOURTH
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
            println(MATCH_COUNT_MSG.format(it.matchCount, it.money, stats.getWinningCountByPrize(it)))
        }
    }

    companion object {
        private const val LOTTO_COUNT_MSG = "%d개를 구매했습니다."
        private const val WINNING_STATS_MSG = "\n당첨 통계\n---------"
        private const val MATCH_COUNT_MSG = "%d개 일치 (%d원)- %d개"
        private val PRIZES = listOf(FOURTH, THIRD, SECOND, FIRST)
    }
}
