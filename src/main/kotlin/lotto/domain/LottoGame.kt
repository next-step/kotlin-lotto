package lotto.domain

import lotto.dto.LottoResults

private const val TICKET_PRICE = 1000

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
            require(purchaseCount > 0)
            return purchaseCount
        }
    }
}