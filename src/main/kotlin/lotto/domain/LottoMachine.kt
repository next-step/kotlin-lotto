package lotto.domain

import lotto.supportdata.PurchaseInfo

class LottoMachine(private val purchaseInfo: PurchaseInfo) {

    fun makeLottoTickets(): List<LottoTicket> = List(purchaseInfo.ticketNumber) { makeRandomLottoTickets() }

    private fun makeRandomLottoTickets(): LottoTicket {
        val subList = LottoNumber.baseLottoNumbers.shuffled().subList(0, LottoTicket.LOTTO_NUMBER_SIZE)
        return LottoTicket(subList.toSet())
    }
}
