package lotto.domain

object LottoReferee {
    fun createResults(
        tickets: List<LottoTicket>,
        winningNumbers: WinningNumbers,
        minMatchedCountToGetPrize: Int,
    ): List<LottoResult> {
        val result = groupTicketByMatchedNumberCount(tickets, winningNumbers)
        val winningResult = filterWinningResult(result, minMatchedCountToGetPrize)
        return toLottoResult(winningResult)
    }

    private fun groupTicketByMatchedNumberCount(
        tickets: List<LottoTicket>,
        winningNumbers: WinningNumbers
    ): Map<Int, List<LottoTicket>> =
        tickets.groupBy { ticket -> ticket.countMatched(winningNumbers) }

    private fun filterWinningResult(result: Map<Int, List<LottoTicket>>, minMatchedNumberCountToGetPrize: Int) =
        result.filter { (matchedNumberCount, _) ->  minMatchedNumberCountToGetPrize <= matchedNumberCount }

    private fun toLottoResult(result: Map<Int, List<LottoTicket>>) = result.map { (matchedNumberCount, tickets) ->
        LottoResult(
            matchedNumberCount = matchedNumberCount,
            ticketCount = tickets.count()
        )
    }
}
