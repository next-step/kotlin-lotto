package lotto.view

import lotto.domain.LottoDraw
import lotto.domain.dto.Rank

object ResultView {
    fun getReport(lottoDraw: LottoDraw) {
        println("당첨 통계")
        println("---------")
        printResult(Rank.FIFTH, lottoDraw.three)
        printResult(Rank.FOURTH, lottoDraw.four)
        printResult(Rank.THIRD, lottoDraw.five)
        printRankSecondResult(Rank.SECOND, lottoDraw.fiveWithBonus)
        printResult(Rank.FIRST, lottoDraw.six)
    }

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
        val result = lottoDraw.winAmount.toDouble() / insertAmount.toDouble()
        return String.format("%.2f", result)
    }
}
