package lotto.domain

import lotto.supportdata.WinNumber

class LottoMachineResult(
    private val userLottoTickets: List<LottoTicket>,
    private val winNumber: WinNumber
) {
    private val lottoTicketResults: List<LottoTicketResult> =
        userLottoTickets.map { LottoTicketResult(userLottoTicket = it, winNumber = winNumber) }

    fun getLottoRankCount(lottoRank: LottoRank): Int {
        return lottoTicketResults.filter { it.lottoRank == lottoRank }.count()
    }
}
