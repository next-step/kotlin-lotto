package lotto.domain

data class LottoTickets(
    val lottoTickets: List<LottoTicket>
) {
    fun match(winningNumbers: WinningNumber): Map<WinningInfo, Int> {
        return lottoTickets
            .map { lottoTicket -> lottoTicket.count(winningNumbers) }
            .groupingBy { count -> WinningInfo.findBy(count) }
            .eachCount()
    }
}
