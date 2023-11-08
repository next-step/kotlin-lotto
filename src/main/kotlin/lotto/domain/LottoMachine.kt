package lotto.domain

class LottoMachine(private val ticketPrice: Int) {

    fun generateTicket(): LottoTicket {
        val numbers = (LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END).shuffled().take(LottoConstants.NUMBERS_PER_TICKET).sorted()
        return LottoTicket(numbers)
    }

    fun generateTickets(amount: Int): List<LottoTicket> {
        val ticketCount = amount / ticketPrice
        return List(ticketCount) { generateTicket() }
    }
}
