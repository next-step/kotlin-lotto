package lotto.view

import lotto.domain.Award
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.TicketStore

object ResultView {

    fun printTickets(tickets: LottoTickets) {
        println("${tickets.count()} 개를 구매했습니다.")

        tickets.items.forEach {
            println(ticketNumberToString(it))
        }
    }

    fun printResults(tickets: LottoTickets, winningNumber: LottoTicket) {
        println("당첨 통계")
        println("---------")

        val awardCount = tickets.getResult(winningNumber)

        Award.values()
            .filter { it != Award.NON_PLACE }
            .forEach {
                println("${it.matchCount}개 일치 (${it.prize}원)- ${awardCount[it] ?: 0}개")
            }


        print("총 수익률은 ${TicketStore.profitability(tickets, winningNumber)}입니다.")
    }

    private fun ticketNumberToString(it: LottoTicket) = it.numbers.joinToString(prefix = "[", postfix = "]") { number -> number.value.toString() }
}
