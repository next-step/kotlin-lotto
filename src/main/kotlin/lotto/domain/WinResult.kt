package lotto.domain

data class WinResult(
    val lottoTickets: LottoTickets,
    val winningNumber: WinningNumber,
) {
    private fun rankResult(): RankResult {
        val result = mutableMapOf<Rank, Int>()

        lottoTickets.lottoTicketList.forEach { lottoTicket ->
            val rank = Rank.getRank(lottoTicket, winningNumber)
            result[rank] = (result[rank] ?: 0) + 1
        }
        return RankResult(result)
    }

    val totalPrizeWon: Long get() = rankResult().value.map { it.key.prize * it.value }.sum()
}
