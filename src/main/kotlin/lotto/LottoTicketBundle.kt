package lotto

class LottoTicketBundle(private val tickets: List<LottoTicket>) {
    fun match(winningNumber: WinningNumber) {
        this.tickets.forEach { it.match(winningNumber = winningNumber) }
    }

    fun getTickets(): List<LottoTicket> = this.tickets

    fun getWinningTickets(): List<WinningTicket> {
        return this.tickets
            .filter { it.status.isWinStatus() }
            .map { WinningTicket.from(lottoTicket = it) }
    }

    fun getWinningMoney(): Int {
        return this.getWinningTickets()
            .map { it.lottoRank }
            .fold(0) { winningMoney, rank ->
                winningMoney + rank.money
            }
    }

    companion object {
        fun purchase(payment: Int): LottoTicketBundle {
            val amount = payment / LottoTicket.LOTTO_TICKET_PRICE
            val tickets = (1..amount)
                .map { LottoTicket.purchase(payment = LottoTicket.LOTTO_TICKET_PRICE) }
            return LottoTicketBundle(tickets = tickets)
        }

        fun purchase(payment: Int, manualNumbers: List<LottoNumber>): LottoTicketBundle {
            val totalAmount = payment / LottoTicket.LOTTO_TICKET_PRICE
            val autoAmount = totalAmount - manualNumbers.size

            val manualTickets = manualNumbers
                .map {
                    LottoTicket.purchase(
                        payment = LottoTicket.LOTTO_TICKET_PRICE,
                        manualNumber = it,
                    )
                }
            val autoTickets = (1..autoAmount)
                .map { LottoTicket.purchase(payment = LottoTicket.LOTTO_TICKET_PRICE) }

            return LottoTicketBundle(tickets = manualTickets.plus(autoTickets))
        }
    }
}
