package lotto

object LottoManager {
    fun winningConfirmation(purchaseLottoTickets: LottoTickets, winningNumbers: WinningNumbers): LottoResults {
        val matchingResult: List<LottoMatchResult> = purchaseLottoTickets.matchNumbers(winningNumbers)
        val prizes = LottoPrizes(matchingResult.map { LottoPrize.of(it) })
        return LottoResults.of(prizes)
    }
}
