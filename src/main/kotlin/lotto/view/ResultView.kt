package lotto.view

import lotto.domain.Lotties
import lotto.domain.LottoRank
import lotto.domain.WinningStatistics

object ResultView {

    fun printPurchaseLotties(lotties: Lotties) {
        println(
            buildString {
                append("수동으로 ${lotties.manualLotties.size}장, 자동으로 ${lotties.autoLotties.size}장을 구매했습니다.\n")
                lotties.manualLotties.forEach { append("${it.numbers}\n") }
                lotties.autoLotties.forEach { append("${it.numbers}\n") }
            }
        )
    }

    fun printStatistics(statistics: WinningStatistics) {
        println(
            buildString {
                append("당첨통계\n")
                append("---------\n")
                statistics.statistics.filterKeys { it != LottoRank.NONE }.forEach { (rank, count) ->
                    append("${rank.matchCount}개 일치")
                    append(if (rank == LottoRank.SECOND) ", 보너스 볼 일치" else "")
                    append("(${rank.winningAmount}원)")
                    append(" - ")
                    append("${count}개\n")
                }
                append("총 수익률은 ${statistics.returnRate}입니다.\n")
            }
        )
    }

}
