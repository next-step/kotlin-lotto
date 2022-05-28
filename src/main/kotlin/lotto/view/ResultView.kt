package lotto.view

import lotto.domain.dto.Rank
import lotto.domain.LottoDrawResult

object ResultView {
    fun getReport(lottoDrawResult: LottoDrawResult) {
        println("당첨 통계")
        println("---------")
        printResult(Rank.FIFTH, lottoDrawResult.three)
        printResult(Rank.FOURTH, lottoDrawResult.four)
        printResult(Rank.THIRD, lottoDrawResult.five)
        printRankSecondResult(Rank.SECOND, lottoDrawResult.fiveWithBonus)
        printResult(Rank.FIRST, lottoDrawResult.six)
    }

    fun getResult(lottoDrawResult: LottoDrawResult, insertAmount: Int) {
        println("총 수익률은 ${getResultRate(lottoDrawResult, insertAmount)} 입니다. ")
    }

    private fun printResult(rank: Rank, matchCount: Int) {
        println("${rank.count}개 일치 (${rank.amount}원) - ${matchCount}개")
    }

    private fun printRankSecondResult(rank: Rank, matchCount: Int) {
        println("${rank.count}개 일치, 보너스볼 일치 (${rank.amount}원) - ${matchCount}개")
    }

    private fun getResultRate(lottoDrawResult: LottoDrawResult, insertAmount: Int): String {
        val result = lottoDrawResult.result.toDouble() / insertAmount.toDouble()
        return String.format("%.2f", result)
    }
}
