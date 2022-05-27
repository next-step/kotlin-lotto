package lotto.domain

class LottoTickets(val lottoTickets: List<LottoTicket>) {
    fun win(checker: Checker): List<MatchState> {
        return lottoTickets.map {
            val (matchCount, isBonus) = checker.match(it)
            MatchState.of(matchCount, isBonus)
        }
    }
}
