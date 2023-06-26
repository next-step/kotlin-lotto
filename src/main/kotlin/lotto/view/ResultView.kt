package lotto.view

import lotto.domain.Lottos
import lotto.domain.WinningStatistics
import lotto.service.LottoCalculator

class ResultView {
    companion object {
        fun printPurchaseLottoNum(lottos: Lottos) {
            println("${lottos.size}개를 구매했습니다.")
        }

        fun printLottos(lottos: Lottos) {
            lottos.lottos.forEach {
                println(it)
            }
        }

        fun printStatisticsTitle() {
            println("당첨 통계")
            println("---------")
        }

        fun printWinningStatistics(winningStatistics: WinningStatistics) {
            (3..6).forEach {
                val prize = LottoCalculator.calculatePrizeMoney(it)
                val matchCount = winningStatistics.winningStatistics[it] ?: 0
                println("${it}개 일치 (${prize}원)- ${matchCount}개")
            }
        }

        fun printProfitRate(profitRate: Double) {
            val result = when {
                profitRate < 1.0 -> "손해"
                profitRate == 1.0 -> "본전"
                else -> "이익"
            }
            println("총 수익률은 ${profitRate}입니다.(기준이 1이기 때문에 결과적으로 ${result}라는 의미임)")
        }
    }
}
