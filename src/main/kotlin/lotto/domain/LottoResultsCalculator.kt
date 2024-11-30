package lotto.domain

object LottoResultsCalculator {
    fun purchasedLottoTicketsResult(
        purchasedLottoTickets: PurchasedLottoTickets,
        winnerNumbers: LottoWinnerNumbers,
    ): LottoResults {
        return LottoResults(
            threeNumberMatchCount = 1,
            fourNumberMatchCount = 1,
            fiveNumberMatchCount = 1,
            sixNumberMatchCount = 1,
            profitMargin = 1.toDouble(),
        )
    }

    private fun matchCountCalculator(
        lottoTicket: LottoTicket,
        winnerNumbers: LottoWinnerNumbers,
    ): Int {
        return lottoTicket.lottoNumbers.intersect(winnerNumbers.winnerNumbers).size
    }
}
