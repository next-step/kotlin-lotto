package lotto.domain

import lotto.dto.LottoResults

private const val TICKET_PRICE = 1000

private const val MINIMUM_PURCHASE_COUNT = 1

class LottoGame(
    val lottoTicketBulk: LottoTicketBulk,
    val winnerTicket: WinnerTicket
) {
    fun result(): LottoResults {
        return LottoResults(
            winnings = lottoTicketBulk.pickWinnerTickets(winnerTicket),
            purchaseCount = lottoTicketBulk.size()
        )
    }

    companion object {
        fun purchaseTicket(amount: Int): Int {
            val purchaseCount = amount / TICKET_PRICE
            require(purchaseCount >= MINIMUM_PURCHASE_COUNT) {"로또는 최소 1장 이상 구매할 수 있습니다."}
            return purchaseCount
        }
    }
}
