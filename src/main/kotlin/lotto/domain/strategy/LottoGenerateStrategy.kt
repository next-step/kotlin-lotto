package lotto.domain.strategy

import lotto.domain.LottoNumber
import lotto.domain.LottoNumberSelector
import lotto.domain.LottoTicket

interface LottoGenerateStrategy {
    val ticketGenerateType: TicketGenerateType
    fun generate(): LottoTicket
}

class LottoAutoGenerateStrategy : LottoGenerateStrategy {
    override val ticketGenerateType = TicketGenerateType.AUTO
    override fun generate(): LottoTicket {
        return LottoTicket(LottoNumberSelector.select())
    }
}

class LottoManualGenerateStrategy : LottoGenerateStrategy {
    override val ticketGenerateType = TicketGenerateType.MANUAL
    override fun generate(): LottoTicket {
        val manualLottoNumberStr = readln()
        val manualLottoNumber = manualLottoNumberStr.split(", ").map { LottoNumber(it.toInt()) }.toSet()

        return LottoTicket(manualLottoNumber)
    }
}
