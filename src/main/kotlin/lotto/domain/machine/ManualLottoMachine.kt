package lotto.domain.machine

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

class ManualLottoMachine(
    private val input: List<List<Int>>
) : LottoMachine {

    override fun publish(): LottoTickets {
        return LottoTickets(
            input.map {
                LottoTicket(*it.toIntArray())
            }
        )
    }
}
