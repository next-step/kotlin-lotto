package lotto.domain

import lotto.dto.LottoResults

private const val TICKET_PRICE = 1000

private const val MINIMUM_PURCHASE_COUNT = 1

class LottoGame(
    val lottoTickets: List<LottoTicket>,
    val winnerTicket: WinnerTicket
) {
    fun pickWinnerTickets(): LottoResults {
        return LottoResults(
            winnings = lottoTickets.map { winnerTicket.drawResult(it) }
                .filter { it.isWinning() },
            purchaseCount = lottoTickets.size
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
