package lotto.business

class LottoTicketManager(private val _tickets: MutableList<LottoTicket> = mutableListOf()) {
    val tickets: List<LottoTicket>
        get() = _tickets

    fun add(ticket: LottoTicket) {
        _tickets.add(ticket)
    }

    fun addAll(tickets: List<LottoTicket>) {
        this._tickets.addAll(tickets)
    }

    fun calculateResults(winningNumbers: LottoWinningNumbers): Map<LotteryPrize, Int> {
        return _tickets.map { it.matchCount(winningNumbers.lottoNumbers) }
            .map { LotteryPrize.getPrize(it) }
            .groupBy { it }
            .mapValues { it.value.size }
    }
}
