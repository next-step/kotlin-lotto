package lotto.view

import lotto.model.Lottos
import lotto.model.WinningRank
import lotto.model.WinningStatistics

object ConsoleResultView : ResultView {

    override fun printPurchasedLottoCount(lottoCount: Int) = println("${lottoCount}개를 구매했습니다.")

    override fun printPurchasedLottos(lottos: Lottos) {
        lottos.lottos.forEach { println(it) }
        println()
    }

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
        println("총 수익률은 ${earningRatio}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
}
