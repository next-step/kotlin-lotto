package lotto.domain

import lotto.math.getProfit
import lotto.math.roundTo
import lotto.supportdata.PurchaseInfo
import lotto.supportdata.WinLottoInfo

class LottoMachineResult(
    userLottoTickets: List<LottoTicket>,
    private val winLottoInfo: WinLottoInfo
) {
    private val lottoTicketResults: List<LottoTicketResult> =
        userLottoTickets.map { LottoTicketResult(userLottoTicket = it, winLottoInfo = winLottoInfo) }

    fun getLottoRankCount(lottoRank: LottoRank): Int {
        return lottoTicketResults.count { it.lottoRank == lottoRank }
    }

    fun calculateProfit(purchaseInfo: PurchaseInfo): Double {
        val purchaseMoney: Int = purchaseInfo.money
        val winningMoney: Int = lottoTicketResults
            .map { it.lottoRank.price }
            .sum()
        return getProfit(purchaseMoney, winningMoney).roundTo(2)
    }
}
