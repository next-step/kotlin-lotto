package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank

class OutputView {
    fun printResult(lottoRankList: List<LottoRank>, returnOnInvestment: Double) {
        println()
        println("당첨 통계")
        printDownToDashLine()

        LottoRank.values().filter { it != LottoRank.MISS }.reversed().forEach {
            printMatchCount(it.matchCount, it.winningMoney, lottoRankList.count { lottoRank -> lottoRank == it })
        }

        println("총 수익률은 $returnOnInvestment%입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n")
    }

    fun printLottoNumberList(lottoList: List<Lotto>) {
        lottoList.forEach { println(it.getLottoNumberList()) }
        println()
    }

    private fun printMatchCount(matchCount: Int, winningMoney: Int, count: Int) {
        println(MATCH_COUNT.format(matchCount, winningMoney, count))
    }

    fun printDownToDashLine(vararg messages: String) {
        println(DASH_LINE)
        messages.forEach(::println)
    }

    companion object {
        private const val DASH_LINE = "---------"
        private const val WINNING_STATISTICS = "당첨 통계"
        private const val RETURN_ON_INVESTMENT = "총 수익률은 %s입니다."
        private const val MATCH_COUNT = "%d개 일치 (%d원)- %d개"
    }
}
