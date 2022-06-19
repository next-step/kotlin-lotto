package lotto.domain.result

import lotto.domain.number.LottoTicket

class WinningNumber(private val _value: LottoTicket) {
    val numbers
        get() = _value.numbers

    fun match(lottoTicket: LottoTicket): LottoTicketMatchResult {
        val matchCount = lottoTicket.numbers.count { numbers.contains(it) }
        return LottoTicketMatchResult(matchCount)
    }
}
