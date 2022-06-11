package lotto

object LottoManager {
    fun winningConfirmation(purchaseLottoTickets: LottoTickets, winningNumbersTicket: LottoTicket): LottoResults {
        val matchNumbersInfo = purchaseLottoTickets.matchNumbers(winningNumbersTicket)
        val prizes = LottoPrizes(matchNumbersInfo.map { LottoPrize.of(it) })
        return LottoResults.of(prizes)
    }
}
