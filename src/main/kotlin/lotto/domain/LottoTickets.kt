package lotto.domain

data class LottoTickets(
    val lottoTickets: List<LottoTicket>
) {
    fun match(winningNumbers: WinningNumber, bonusNumber: BonusNumber): Map<Rank, Count> {
        return lottoTickets
            .map { it.match(winningNumbers, bonusNumber) }
            .groupingBy { rank: Rank -> rank }
            .eachCount()
            .mapValues { Count(it.value) }
    }
}
