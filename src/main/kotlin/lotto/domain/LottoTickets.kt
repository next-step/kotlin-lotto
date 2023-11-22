package lotto.domain

data class LottoTickets(val lottoTicketList: List<LottoTicket>) {

    fun getRankResult(winningNumber: WinningNumber): RankResult {
        val result = mutableMapOf<Rank, Int>()

        lottoTicketList.forEach { lottoTicket ->
            val rank = lottoTicket.getRank(winningNumber)
            result[rank] = (result[rank] ?: 0) + 1
        }
        return RankResult(result)
    }
}
