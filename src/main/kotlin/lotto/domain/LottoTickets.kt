package lotto.domain

data class LottoTickets(
    val lottoTickets: List<LottoTicket>
) {
    fun match(winningNumbers: WinningLotto, bonusNumber: BonusNumber): MatchResult =
        MatchResult(
            lottoTickets
                .map { it.match(winningNumbers, bonusNumber) }
                .groupingBy { rank: Rank -> rank }
                .eachCount()
                .mapValues { Count(it.value) }
        )
}
