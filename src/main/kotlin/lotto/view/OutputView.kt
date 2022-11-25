package lotto.view

import lotto.domain.Money
import lotto.domain.Reward
import lotto.domain.Ticket

object OutputView {

    fun printTicketPurchaseCount(count: Int) = println("${count}개를 구매했습니다.")

    fun printTicketsInfo(tickets: List<Ticket>) = tickets.forEach { ticket ->
        println("[${ticket.getNumbers().joinToString(",")}]")
    }

    fun printStatistics(rewardCount: Map<Reward, Int>) {
        println()
        println("당첨 통계")
        println("---------")
        rewardCount.forEach {
            println("${it.key.count}개 일치 (${it.key.name}원) - ${it.value}개")
        }
    }

    fun printRevenueRate(money: Money) {
        println("총 수익률은 ${money.getRevenueRate()}입니다.")
    }
}
