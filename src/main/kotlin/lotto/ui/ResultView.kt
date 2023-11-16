package lotto.ui

import lotto.vo.AutoLotto
import lotto.vo.WinningLotto
import lotto.winningpoint.WinningRank
import lotto.winningpoint.WinningStatistics

object ResultView {

    fun promptForAutoLotto(price: Long): AutoLotto {
        val autoLotto = AutoLotto(price)
        println("로또 ${autoLotto.count}개를 구매했습니다.")
        autoLotto.lottos.forEach { lotto ->
            println(lotto.numbers)
        }
        return autoLotto
    }

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
