package lotto.view

import lotto.domain.dto.DrawNumberEnum
import lotto.domain.LottoDrawResult

object ResultView {
    fun getReport(lottoDrawResult: LottoDrawResult) {
        println("당첨 통계")
        println("---------")
        printResult(DrawNumberEnum.THREE, lottoDrawResult.getThree)
        printResult(DrawNumberEnum.FOUR, lottoDrawResult.getFour)
        printResult(DrawNumberEnum.FIVE, lottoDrawResult.getFive)
        printResult(DrawNumberEnum.SIX, lottoDrawResult.getSix)
    }

    fun getResult(lottoDrawResult: LottoDrawResult, insertAmount: Int) {
        println("총 수익률은 ${getResultRate(lottoDrawResult, insertAmount)} 입니다. ")
    }

    private fun printResult(drawNumberEnum: DrawNumberEnum, matchCount: Int) {
        println("${drawNumberEnum.count}개 일치 (${drawNumberEnum.amount}원) - ${matchCount}개")
    }

    private fun getResultRate(lottoDrawResult: LottoDrawResult, insertAmount: Int): String {
        val result = lottoDrawResult.getResult.toDouble() / insertAmount.toDouble()
        return String.format("%.2f", result)
    }
}
