package lotto

class LottoTickets(ticketQuantity: Int) {
    val numbers: List<LottoTicket> = List(ticketQuantity) { LottoTicket.generate() }

    fun getAllLottoNumbers(): List<List<Int>> {
        return numbers.map { it.numbers }
    }
}
