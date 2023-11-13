package lotto.domain

data class WinResult(
    val lottoTickets: LottoTickets,
    val winningNumber: WinningNumber,
) {
    private val winResult: Map<Rank, Int> get() {
        val result = mutableMapOf<Rank, Int>()

        lottoTickets.lottoTicketList.forEach { lottoTicket ->
            val rank = winningNumber.getRank(lottoTicket)
            result[rank] = (result[rank] ?: 0) + 1
        }
        return result
    }

    val totalPrizeWon: Long get() = winResult.map { it.key.prize * it.value }.sum()
}
