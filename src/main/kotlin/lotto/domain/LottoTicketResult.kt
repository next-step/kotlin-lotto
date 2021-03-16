package lotto.domain

import lotto.supportdata.WinNumber

class LottoTicketResult(
    private val userLottoTicket: LottoTicket,
    private val winNumber: WinNumber
) {
    val lottoRank: LottoRank = findLottoRank()

    private fun findLottoRank(): LottoRank {
        val matchCount = userLottoTicket.getMatchCount(winNumber.winLottoTicket)
        return LottoRank.findRank(matchCount)
    }
}
