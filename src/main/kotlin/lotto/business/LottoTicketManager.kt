package lotto.business

class LottoTicketManager(
    tickets: List<LottoTicket> = mutableListOf(),
    private val ticketBookingSystem: TicketBookingSystem = TicketBookingSystem(LottoTicketGenerator())
) {
    private val _tickets: MutableList<LottoTicket> = tickets.toMutableList()

    val tickets: List<LottoTicket>
        get() = _tickets.toList()

    fun addAll(tickets: List<LottoTicket>) {
        this._tickets.addAll(tickets)
    }

    fun compilePrizeResults(winningNumbers: LottoWinningNumbers): PrizeResults {
        return _tickets.map { it.matchCount(winningNumbers.lottoNumbers) }
            .map { LotteryPrize.getPrize(it) }
            .groupBy { it }
            .mapValues { it.value.size }
            .let { PrizeResults(it) }
    }

    fun buyLotto(receivedAmount: ReceivedAmount): List<LottoTicket> {
        addAll(ticketBookingSystem.buyLotto(receivedAmount))
        return tickets
    }
}
