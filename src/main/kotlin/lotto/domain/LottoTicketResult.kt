package lotto.domain

import lotto.supportdata.WinNumber

class LottoTicketResult(
    private val userLottoTicket: LottoTicket,
    private val winNumber: WinNumber
) {
    val lottoRank: LottoRank = findLottoRank()

    private fun findLottoRank(): LottoRank {
        val collectCount = userLottoTicket.getCollectCount(winNumber.winLottoTicket)
        return LottoRank.findRank(collectCount)
    }
}
