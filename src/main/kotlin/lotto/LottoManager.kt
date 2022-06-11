package lotto

object LottoManager {
    fun winningConfirmation(purchaseLottoTicket: LottoTicket, winningNumbersTicket: LottoTicket): LottoPrize {
        val matchCount = purchaseLottoTicket.matchNumbers(winningNumbersTicket)
        return LottoPrize.of(matchCount)
    }
}
