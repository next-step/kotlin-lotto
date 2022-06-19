package game.domain.result

import game.domain.lotto.Lotto
import game.domain.lotto.LottoTicket

class WinningNumber(private val _value: LottoTicket) {
    val numbers
        get() = _value.numbers

    fun match(lottoTicket: LottoTicket): LottoTicketMatchResult {
        val matchCount = lottoTicket.numbers.count { numbers.contains(it) }
        return LottoTicketMatchResult(matchCount)
    }

    fun match(lotto: Lotto): LottoResult {
        val ticketResults = lotto.tickets.map { match(it) }
        return LottoResult(ticketResults)
    }
}
