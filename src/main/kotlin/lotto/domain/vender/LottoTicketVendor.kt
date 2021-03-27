package lotto.domain.vender

import lotto.domain.ticket.LottoTicket
import lotto.domain.ticket.LottoTicketCreateDto
import lotto.domain.value.Price

class LottoTicketVendor(
    private val dto: LottoTicketCreateDto
) : TicketVendor() {

    override fun buyTickets(): List<LottoTicket> {
        val tickets = mutableListOf<LottoTicket>()
        tickets.addAll(autoTickets())
        tickets.addAll(manualTickets())

        return tickets.toList()
    }

    private fun autoTickets(): MutableList<LottoTicket.AutomaticLottoTicket> {
        val autoPrice = dto.price - Price(dto.manualAmount.times(TICKET_PRICE))
        val autoAmount = autoPrice / TICKET_PRICE

        return (0 until autoAmount).map {
            LottoTicket.create()
        }.toMutableList()
    }

    private fun manualTickets(): List<LottoTicket.ManualLottoTicket> {
        return dto.manualRequest.map {
            LottoTicket.ManualLottoTicket(it.split(","))
        }
    }
}
