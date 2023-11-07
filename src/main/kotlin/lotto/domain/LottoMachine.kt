package lotto.domain

class LottoMachine(private val ticketPrice: Int) {

    fun generateTicket(): LottoTicket {
        val numbers = (NUMBER_RANGE_START..NUMBER_RANGE_END).shuffled().take(NUMBERS_PER_TICKET).sorted()
        return LottoTicket(numbers)
    }

    fun generateTickets(amount: Int): List<LottoTicket> {
        val ticketCount = amount / ticketPrice
        return List(ticketCount) { generateTicket() }
    }

    companion object {
        const val NUMBER_RANGE_START = 1
        const val NUMBER_RANGE_END = 45
        const val NUMBERS_PER_TICKET = 6
    }
}
