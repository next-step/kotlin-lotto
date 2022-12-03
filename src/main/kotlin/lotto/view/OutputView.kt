package lotto.view

import lotto.domain.Money
import lotto.domain.Reward
import lotto.domain.Ticket

object OutputView {

    fun printTicketPurchaseCountAndTicketsInfo(count: Int, tickets: List<Ticket>) {
        printTicketPurchaseCount(count)
        printTicketsInfo(tickets)
    }

    private fun printTicketPurchaseCount(count: Int) = println("${count}개를 구매했습니다.")

    private fun printTicketsInfo(tickets: List<Ticket>) = tickets.forEach { ticket ->
        println("[${ticket.getNumbers().joinToString(",")}]")
    }

    fun printStatisticsAndRevenueRate(rewardCount: Map<Reward, Int>, money: Money, matchInfo: Map<Reward, Int>) {
        printStatistics(rewardCount)
        printRevenueRate(money, matchInfo)
    }

    private fun printStatistics(rewardCount: Map<Reward, Int>) {
        println()
        println("당첨 통계")
        println("---------")
        rewardCount.forEach {
            println("${it.key.match}개 일치 (${it.key.reward}원) - ${it.value}개")
        }
    }

    private fun printRevenueRate(money: Money, matchInfo: Map<Reward, Int>) {
        println("총 수익률은 ${money.getRevenueRate(matchInfo)}입니다.")
    }
}
