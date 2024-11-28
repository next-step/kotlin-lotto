package lotto.step3.view

import lotto.step3.domain.Lotto
import lotto.step3.domain.Rank
import lotto.step3.domain.WinningStatistics

object OutputView {
    fun printPurchaseResult(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.numbers.joinToString(", ", "[", "]"))
        }
    }

    fun printStatistics(winningStatistics: WinningStatistics) {
        println("당첨 통계")
        println("---------")
        this.printMatchCount(rank = Rank.FIFTH, rankMap = winningStatistics.rankMap)
        this.printMatchCount(rank = Rank.FOURTH, rankMap = winningStatistics.rankMap)
        this.printMatchCount(rank = Rank.THIRD, rankMap = winningStatistics.rankMap)
        this.printMatchCount(rank = Rank.SECOND, rankMap = winningStatistics.rankMap)
        this.printMatchCount(rank = Rank.FIRST, rankMap = winningStatistics.rankMap)
        println("총 수익률은 ${winningStatistics.profit}입니다.")
    }

    private fun printMatchCount(
        rank: Rank,
        rankMap: Map<Rank, Int>,
    ) {
        if (rank.hasBonusNumber) {
            println("${rank.matchCount}개 일치, 보너스 볼 일치(${rank.winningAmount}원)- ${rankMap[rank] ?: 0}개")
        } else {
            println("${rank.matchCount}개 일치 (${rank.winningAmount}원)- ${rankMap[rank] ?: 0}개")
        }
    }
}
