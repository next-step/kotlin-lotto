package lottery.view

import lottery.domain.Lottery
import lottery.domain.Ticket

object ResultView {
    fun printTicketCount(tickets: List<Ticket>) {
        println("${tickets.size}개를 구매했습니다.")
    }

    fun printLotteries(lotteries: List<Lottery>) {
        lotteries.forEach {
            println(it)
        }
    }
}