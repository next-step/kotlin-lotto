package lotto.domain

class LottoTickets(val lottoTickets: List<LottoTicket>) {
    fun win(checker: Checker): List<MatchState> {
        return lottoTickets.map { MatchState.of(checker.match(it)) }
    }
}
