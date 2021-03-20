package lotto.domain

import lotto.supportdata.PurchaseInfo

class LottoMachine(private val purchaseInfo: PurchaseInfo) {
    fun makeAutoLottoTickets(): List<LottoTicket> = List(purchaseInfo.autoTicketNumber) { makeRandomLottoTickets() }

    private fun makeRandomLottoTickets(): LottoTicket {
        val lottoNumbers = LottoNumber.baseLottoNumbers
            .shuffled()
            .take(LottoTicket.LOTTO_NUMBER_SIZE)
            .toSet()
        return LottoTicket(lottoNumbers)
    }
}
