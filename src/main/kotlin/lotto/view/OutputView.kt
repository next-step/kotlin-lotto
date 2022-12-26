package lotto.view

import lotto.domain.MatchInfo
import lotto.domain.Money
import lotto.domain.Ticket

object OutputView {

    fun printTicketPurchaseCountAndTicketsInfo(count: Int, tickets: List<Ticket>) {
        printTicketPurchaseCount(count)
        printTicketsInfo(tickets)
    }

    private fun printTicketPurchaseCount(count: Int) = println("${count}개를 구매했습니다.")

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
