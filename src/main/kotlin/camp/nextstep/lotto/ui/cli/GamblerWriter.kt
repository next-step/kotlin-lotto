package camp.nextstep.lotto.ui.cli

import camp.nextstep.lotto.ticket.LottoTicket
import camp.nextstep.lotto.user.Gambler

object GamblerWriter {

    fun write(gambler: Gambler) {
        println("${gambler.tickets.size}개를 구매했습니다.")
        writeTickets(gambler.tickets)
    }

    private fun writeTickets(tickets: List<LottoTicket>) {
        for (ticket in tickets) {
            println(ticket.numbers)
        }
    }
}
