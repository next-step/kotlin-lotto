package lotto.domain

import lotto.supportdata.WinLottoInfo

class LottoTicketResult(
    private val userLottoTicket: LottoTicket,
    private val winLottoInfo: WinLottoInfo
) {
    val lottoRank: LottoRank = findLottoRank()

    private fun findLottoRank(): LottoRank {
        val matchCount = userLottoTicket.getMatchCount(winLottoInfo.winLottoTicket)
        val isBonusNumber = winLottoInfo.bonusNumber in userLottoTicket
        return LottoRank.findRank(matchCount = matchCount, isBonusNumber = isBonusNumber)
    }
}
