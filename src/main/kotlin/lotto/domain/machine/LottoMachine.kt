package lotto.domain.machine

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

interface LottoMachine {
    fun publish(): LottoTickets

    fun createTicket(numbers: List<Int>): LottoTicket {
        return LottoTicket(numbers.map { LottoNumber.of(it) }.toSet())
    }
}
