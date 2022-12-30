package lotto.view

import lotto.domain.MatchInfo
import lotto.domain.Money
import lotto.domain.Ticket

object OutputView {

    fun printTicketPurchaseCountAndTicketsInfo(lottoCount: Int, manualCount: Int, tickets: List<Ticket>) {
        printTicketPurchaseCount(lottoCount, manualCount)
        printTicketsInfo(tickets)
    }

    private fun printTicketPurchaseCount(lottoCount: Int, manualCount: Int) =
        println("수동으로 ${manualCount}장, 자동으로 ${lottoCount - manualCount}개를 구매했습니다.")

    private fun printTicketsInfo(tickets: List<Ticket>) = tickets.forEach { ticket ->
        println("[${ticket.getIssueNumbers().joinToString(",")}]")
    }

    fun printStatisticsAndRevenueRate(matchInfo: MatchInfo, money: Money) {
        printStatistics(matchInfo)
        printRevenueRate(money, matchInfo)
    }

    private fun printStatistics(matchInfo: MatchInfo) {
        println()
        println("당첨 통계")
        println("---------")
        matchInfo.matchInfo.forEach {
            println("${it.key.match}개 일치 (${it.key.reward}원) - ${it.value}개")
        }
    }

    private fun printRevenueRate(money: Money, matchInfo: MatchInfo) {
        println("총 수익률은 ${matchInfo.getRevenueRate(money)}입니다.")
    }
}
