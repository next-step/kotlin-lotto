package lotto

fun main() {
    val lottoPurchaseAmount = Money(LottoInputView.inputPurchaseLottoAmount())
    LottoOutputView.outputPurchaseLottoTicketCount(lottoPurchaseAmount)

    val lottoTickets: LottoTickets = LottoFactory.auto(lottoPurchaseAmount.lottoTicketCount())
    LottoOutputView.outputPurchaseLottoTickerInfos(lottoTickets)

    val inputWinningLottoNumbers = LottoInputView.inputWinningLottoNumbers()
    val winningTicket = LottoTicket(inputWinningLottoNumbers.map { LottoNumber.of(it) }.toSet())

    val lottoPrizes: LottoResults = LottoManager.winningConfirmation(lottoTickets, winningTicket)
    LottoOutputView.outputLottoResults(lottoPrizes, lottoPurchaseAmount)
}
