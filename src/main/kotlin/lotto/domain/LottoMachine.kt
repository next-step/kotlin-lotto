package lotto.domain

import lotto.supportdata.PurchaseInfo

class LottoMachine(private val purchaseInfo: PurchaseInfo) {

    fun makeLottoTickets(): List<LottoTicket> =
        List(purchaseInfo.autoTicketNumber) { makeRandomLottoTickets() } + purchaseInfo.manualTicket

    private fun makeRandomLottoTickets(): LottoTicket {
        val lottoNumbers = LottoNumber.baseLottoNumbers
            .shuffled()
            .take(LottoTicket.LOTTO_NUMBER_SIZE)
            .toSet()
        return LottoTicket(lottoNumbers)
    }
}
