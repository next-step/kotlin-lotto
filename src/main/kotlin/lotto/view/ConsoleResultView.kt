package lotto.view

import lotto.model.Lottos
import lotto.model.WinningRank
import lotto.model.WinningStatistics

object ConsoleResultView : ResultView {

    private const val principalRatio = 1

    override fun printLottoCount(customLottoCount: Int, randomLottoCount: Int) {
        println()
        println("수동으로 ${customLottoCount}장, 자동으로 ${randomLottoCount}개를 구매했습니다.")
    }

    override fun printTotalLottos(lottos: Lottos) = lottos.lottos.forEach { println(it) }

    override fun printWinningStatistics(paymentPrice: Int, statistics: WinningStatistics) {
        println()
        println("당첨 통계")
        println("---------")

        printWinningStatus(statistics)
        printEarningsRatio(statistics.calculateEarningRatio(paymentPrice))
    }

    private fun printWinningStatus(statistics: WinningStatistics) =
        statistics.winningStatistics.forEach { (winningRank, count) ->
            println("${winningRank.matchedNumberCount}개 일치${bonusBallMessage(winningRank)} (${winningRank.prizeMoney}원)- ${count}개")
        }

    private fun bonusBallMessage(winningRank: WinningRank): String {
        if (winningRank.isBonusNumberNecessary) {
            return ", 보너스 볼 일치"
        }
        return ""
    }

    private fun printEarningsRatio(earningRatio: Double) =
        println("총 수익률은 ${earningRatio}입니다.${lossMessage(earningRatio)}")

    private fun lossMessage(earningRatio: Double): String {
        if (earningRatio < principalRatio) {
            return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        }
        return ""
    }
}
