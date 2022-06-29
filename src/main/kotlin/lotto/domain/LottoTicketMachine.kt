package lotto.domain

import lotto.domain.lottoticket.LottoNumber
import lotto.domain.lottoticket.LottoNumbers
import lotto.domain.lottoticket.LottoTicket
import lotto.domain.lottoticket.LottoTickets

class LottoTicketMachine {
    fun createManualTicket(manualNumbers: List<Int>): LottoTicket {
        val lottoNumberSet = manualNumbers.map { LottoNumber.from(it) }.toSet()
        val lottoNumbers = LottoNumbers.createWithSort(values = lottoNumberSet)
        return LottoTicket.manual(lottoNumbers)
    }

    fun createAutoTickets(count: Int): LottoTickets = LottoTickets(List(count) { createAutoTicket() })

    private fun createAutoTicket(): LottoTicket {
        val lottoNumbers = LottoNumber.cachedLottoNumbers()
            .asSequence()
            .shuffled()
            .take(LottoNumbers.NUMBERS_COUNT)
            .toSet()
        return LottoTicket.auto(lottoNumbers = LottoNumbers.createWithSort(lottoNumbers))
    }
}
