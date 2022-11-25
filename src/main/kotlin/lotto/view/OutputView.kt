package lotto.view

import lotto.domain.Reward
import lotto.domain.Ticket

class OutputView {

    fun printTicketPurchaseCount(count: Int) = println("${count}개를 구매했습니다.")

    fun printTicketsInfo(tickets: List<Ticket>) = tickets.forEach { ticket ->
        print("[")
        print(ticket.getNumbers().joinToString(", "))
        println("]")
    }

    fun printWinner() {
        println()
        println("지난 주 당첨 번호를 입력해 주세요.")
    }

    fun printStatistics(rewardCount: Map<Reward, Int>) {
        println()
        println("당첨 통계")
        println("---------")
        rewardCount.forEach {
            println("${it.key.count}개 일치 (${it.key.name}원) - ${it.value}개")
        }
    }
}
