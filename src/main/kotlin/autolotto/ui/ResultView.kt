package autolotto.ui

import autolotto.vo.AutoLotto
import autolotto.vo.WinningLotto
import autolotto.winningpoint.WinningRank
import autolotto.winningpoint.WinningStatistics

object ResultView {

    fun printWinningPoints(autoLotto: AutoLotto, winningLotto: WinningLotto) {
        val statistics = WinningStatistics.calculateStatistics(autoLotto, winningLotto)

        println("당첨 통계")
        println("---------")
        WinningRank.values().forEach { rank ->
            if (WinningRank.isWinningRank(rank)) {
                println("${rank.matchingCount}개 일치 (${rank.winningPrice}원) - ${statistics.getValue(rank)}개")
            }
        }
        val totalWinningPrice = winningLotto.calculateTotalWinningPrice(lottos = autoLotto.lottos)
        println("총 수익률은 ${autoLotto.getProfitRate(totalWinningPrice)}입니다.")
    }
}
