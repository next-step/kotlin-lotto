package lotto.domain

data class LottoTickets(val lottoTicketList: List<LottoTicket>) {

    fun getRankResult(winningNumber: WinningNumber): RankResult {
        val result = lottoTicketList.groupingBy {
            it.getRank(winningNumber)
        }.eachCount()

        return RankResult(result)
    }
}
