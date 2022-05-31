package lotto.view

import lotto.domain.LottoDraw
import lotto.model.Rank

object ResultView {
    fun getReport(lottoDraw: LottoDraw) {
        val winningRank = lottoDraw.winningRanks
        println("당첨 통계")
        println("---------")
        printResult(Rank.FIFTH, winningRank.getRankCount(Rank.FIFTH))
        printResult(Rank.FOURTH, winningRank.getRankCount(Rank.FOURTH))
        printResult(Rank.THIRD, winningRank.getRankCount(Rank.THIRD))
        printRankSecondResult(Rank.SECOND, winningRank.getRankCount(Rank.SECOND))
        printResult(Rank.FIRST, winningRank.getRankCount(Rank.FIRST))
    }

    private fun List<Rank>.getRankCount(rank: Rank) = this.count { it == rank }

    fun getResult(lottoDraw: LottoDraw, insertAmount: Int) {
        println("총 수익률은 ${getResultRate(lottoDraw, insertAmount)} 입니다. ")
    }

    private fun printResult(rank: Rank, matchCount: Int) {
        println("${rank.count}개 일치 (${rank.amount}원) - ${matchCount}개")
    }

    private fun printRankSecondResult(rank: Rank, matchCount: Int) {
        println("${rank.count}개 일치, 보너스볼 일치 (${rank.amount}원) - ${matchCount}개")
    }

    private fun getResultRate(lottoDraw: LottoDraw, insertAmount: Int): String {
        val result = lottoDraw.winningRanks.sumOf { it.amount }.toDouble() / insertAmount.toDouble()
        return String.format("%.2f", result)
    }
}
