package lotto.domain

class LottoTickets(
    val tickets: List<LottoTicket>,
) {
    fun determinePrize(
        winningNumbers: WinningNumbers,
        minMatchedCountToGetPrize: Int = LottoSpec.getMinCountToGetPrize(),
    ): LottoResults {
        val result = groupTicketByMatchedNumberCount(winningNumbers)
        val winningResult = filterWinningResult(result, minMatchedCountToGetPrize)
        return toLottoResults(winningResult)
    }

    fun calculatePrice(ticketPrice: Amount) = ticketPrice * tickets.size

    fun count(): Int = tickets.size

    private fun groupTicketByMatchedNumberCount(
        winningNumbers: WinningNumbers
    ): Map<Int, List<LottoTicket>> =
        tickets.groupBy { ticket -> ticket.countMatched(winningNumbers) }

    private fun filterWinningResult(result: Map<Int, List<LottoTicket>>, minMatchedNumberCountToGetPrize: Int) =
        result.filter { (matchedNumberCount, _) -> minMatchedNumberCountToGetPrize <= matchedNumberCount }

    private fun toLottoResults(result: Map<Int, List<LottoTicket>>) = result.map { (matchedNumberCount, tickets) ->
        LottoResult(
            matchedNumberCount = matchedNumberCount,
            ticketCount = tickets.count()
        )
    }.let(::LottoResults)
}
