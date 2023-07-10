package lotto.view

import lotto.domain.Lottos
import lotto.domain.Rank
import lotto.domain.WinningStatistics

object ResultView {
    fun printPurchaseLottoNum(lottos: Lottos) {
        println("${lottos.size}개를 구매했습니다.")
    }

    fun printLottos(lottos: Lottos) {
        lottos.lottos.forEach {
            println(it)
        }
        println()
    }

    fun printWinningStatistics(winningStatistics: WinningStatistics) {
        println("당첨 통계")
        println("---------")

        listOf(
            Rank.FIFTH,
            Rank.FOURTH,
            Rank.THIRD,
            Rank.SECOND,
            Rank.FIRST,
        ).forEach {
            val prize = it.winningMoney
            val matchCount = winningStatistics.winningCountByRank[it]
            val bonusMessage = if (it == Rank.SECOND) ", 보너스 볼 일치" else " "
            println("${it.countOfMatch}개 일치$bonusMessage(${prize}원)- ${matchCount}개")
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
