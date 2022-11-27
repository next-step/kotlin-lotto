package lotto.view

import lotto.domain.*

object ResultView {

    fun printTickets(tickets: LottoTickets) {
        println("${tickets.count()} 개를 구매했습니다.")

        tickets.items.forEach {
            println(ticketNumberToString(it))
        }
    }

    fun printResults(awardResults: AwardResults) {
        println("당첨 통계")
        println("---------")


        Award.values()
            .filter { it != Award.NON_PLACE }
            .forEach {
                println("${printPrefix(it)}- ${awardResults.matchCount(it)}개")
            }

        print("총 수익률은 ${TicketStore.profitability(awardResults)}입니다.")
    }

    private fun printPrefix(it: Award): String {
        if (it == Award.SECOND_PLACE) {
            return "${it.matchCount}개 일치, 보너스 볼 일치 (${it.prize}원)"
        }

        return "${it.matchCount}개 일치 (${it.prize}원)"
    }

    private fun ticketNumberToString(it: LottoTicket) = it.numbers.joinToString(prefix = "[", postfix = "]") { number -> number.value.toString() }
}
