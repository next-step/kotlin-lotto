package lotto.ui

import lotto.domain.Lotto
import lotto.domain.WinningStatistics

object Output {
    private const val BUY_COUNT_MESSAGE = "개를 구매했습니다."
    private const val WINNING_STATISTICS_MESSAGE = "당첨 통계\n---------\n"
    private const val MATCH_COUNT_MESSAGE = "%d개 일치 (%d원)- %d개\n"
    private const val PROFIT_MESSAGE = "총 수익률은 %.2f입니다."
    private const val PROFIT_GOOD_MESSAGE = "(기준이 1이기 때문에 결과적으로 이득라는 의미임)"
    private const val PROFIT_BAD_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"

    fun printBuyCount(buyCount: Long) {
        println("$buyCount" + BUY_COUNT_MESSAGE)
    }

    fun printLottos(lottoList: List<Lotto>) {
        for (lotto in lottoList) {
            println(lotto.numbers)
        }
    }

    fun printWinningStatistics(winningStatistics: WinningStatistics) {
        println()
        val sb = StringBuilder()
        sb.append(WINNING_STATISTICS_MESSAGE)

        (3..6).forEach { matchCount ->
            sb.append(
                MATCH_COUNT_MESSAGE.format(
                    matchCount,
                    winningStatistics.prizeOfMatchCount(matchCount),
                    winningStatistics.countOfMatchCount(matchCount)
                )
            )
        }

        sb.append(PROFIT_MESSAGE.format(winningStatistics.profit))
        sb.append(if(winningStatistics.profit > 1) PROFIT_GOOD_MESSAGE else PROFIT_BAD_MESSAGE )

        println(sb.toString())
    }
}
