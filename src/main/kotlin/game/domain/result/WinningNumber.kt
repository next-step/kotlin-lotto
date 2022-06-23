package game.domain.result

import game.domain.lotto.Lotto
import game.domain.lotto.LottoNumber
import game.domain.lotto.LottoTicket

class WinningNumber(private val _value: LottoTicket, val bonusNumber: LottoNumber) {
    init {
        require(!_value.numbers.contains(bonusNumber)) { "당첨번호와 보너스 볼은 중복될 수 없습니다." }
    }
    val numbers
        get() = _value.numbers

    private fun match(lottoTicket: LottoTicket): LottoTicketMatchResult {
        val matchCount = lottoTicket.numbers.count { numbers.contains(it) }
        val matchBonusBall = lottoTicket.numbers.contains(bonusNumber)
        return LottoTicketMatchResult(matchCount, matchBonusBall)
    }

    fun match(lotto: Lotto): LottoResult {
        val ticketResults = lotto.tickets.map { match(it) }
        return LottoResult(ticketResults)
    }
}
