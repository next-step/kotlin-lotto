package lotto.view.request

import lotto.domain.ticket.LottoTicket
import lotto.domain.ticket.LottoTickets

data class ManualNumberRequest(val numbers: List<String>) {
    fun toTickets(): LottoTickets {
        return LottoTickets(numbers.map { LottoTicket(it.split(",")) })
    }
}
