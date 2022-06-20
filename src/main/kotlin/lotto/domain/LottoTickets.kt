package lotto.domain

data class LottoTickets(
    val lottoTickets: List<LottoTicket>
) {
    fun match(winningNumbers: WinningNumber): Map<Rank, Int> {
        return lottoTickets
            .map { lottoTicket -> lottoTicket.count(winningNumbers) }
            .groupingBy { count -> Rank.findBy(count) }
            .eachCount()
    }
}
