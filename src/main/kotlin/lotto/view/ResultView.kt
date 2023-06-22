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
    }
}
