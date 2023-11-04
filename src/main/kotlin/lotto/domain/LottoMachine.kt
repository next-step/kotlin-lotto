package lotto.domain

class LottoMachine(private val ticketPrice: Int) {
    fun generateTicket(): LottoTicket {
        val numbers = (1..45).shuffled().take(6).sorted()
        return LottoTicket(numbers)
    }

    fun generateTickets(amount: Int): List<LottoTicket> {
        val ticketCount = amount / ticketPrice
        return List(ticketCount) { generateTicket() }
    }
}
