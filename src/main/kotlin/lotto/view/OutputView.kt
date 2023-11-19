package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.view.enum.Message

class OutputView {

    private final val messageView: MessageView = MessageView()

    fun printResult(lottoRankList: List<LottoRank>, returnOnInvestment: Double) {
        println()
        println(WINNING_STATISTICS)
        printDownToDashLine()

        LottoRank.values().filter { it != LottoRank.MISS }.reversed().forEach {
            printMatchCount(it.matchCount, it.winningMoney, lottoRankList.count { lottoRank -> lottoRank == it }, it == LottoRank.SECOND_WITH_BONUS)
        }

        println(RETURN_ON_INVESTMENT.format(returnOnInvestment.toString()))
    }

    fun nextLinePrint(message: Message, vararg variables: String) {
        println()
        println(messageView.getMessage(message, *variables))
    }

    fun printBuySummary(manualBuyCount: Int, autoBuyCount: Int) = nextLinePrint(Message.SUMMARY_BUYING_LOTTO, manualBuyCount.toString(), autoBuyCount.toString())

    fun printLottoNumberList(lottoList: List<Lotto>) {
        lottoList.forEach { println(it.numberList) }
        println()
    }

    private fun printMatchCount(matchCount: Int, winningMoney: Int, count: Int, isBonus: Boolean = false) {
        println(MATCH_COUNT.format(matchCount, if (isBonus) BONUS_ADD_MESSAGE else "", winningMoney, count))
    }

    fun printDownToDashLine(vararg messages: String) {
        println(DASH_LINE)
        messages.forEach(::println)
    }

    companion object {
        private const val DASH_LINE = "---------"
        private const val WINNING_STATISTICS = "당첨 통계"
        private const val RETURN_ON_INVESTMENT = "총 수익률은 %s입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        private const val BONUS_ADD_MESSAGE = ", 보너스 볼 일치"
        private const val MATCH_COUNT = "%d개 일치%s(%d원)- %d개"
    }
}
