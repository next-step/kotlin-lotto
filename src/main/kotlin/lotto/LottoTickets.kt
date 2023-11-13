package lotto

class LottoTickets {
    val values: List<LottoTicket>

    constructor(ticketQuantity: Int) {
        this.values = List(ticketQuantity) { LottoTicket.generate() }
    }

    constructor(lottoTickets: List<LottoTicket>) {
        this.values = lottoTickets
    }

    fun getAllLottoNumbers(): List<List<Int>> {
        return values.map { it.numbers }
    }
}
