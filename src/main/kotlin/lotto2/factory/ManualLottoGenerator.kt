package lotto2.factory

import lotto2.domain.LottoNumbers
import lotto2.domain.LottoTicket

class ManualLottoGenerator(private val manualTicketNumbers: List<LottoNumbers>) : LottoFactory {

    override fun generate(): List<LottoTicket> {
        return manualTicketNumbers.map { LottoTicket(it) }
            .toList()
    }
}
