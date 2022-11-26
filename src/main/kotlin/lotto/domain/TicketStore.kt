package lotto.domain

import lotto.domain.machine.LottoMachine

const val TICKET_PRICE = 1000

object TicketStore {

    fun buyTickets(machine: LottoMachine): LottoTickets {
        return machine.publish()
    }

    fun profitability(awardResults: AwardResults): Double {
        return awardResults.profitability(TICKET_PRICE)
    }

    fun createWinningTicket(numbers: List<Int>): LottoTicket {
        return LottoTicket(numbers.map { LottoNumber.of(it) })
    }

}
