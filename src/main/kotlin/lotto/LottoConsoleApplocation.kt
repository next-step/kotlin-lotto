package lotto

fun main() {
    val lottoPurchaseAmount = Money(LottoInputView.inputPurchaseLottoAmount())
    LottoOutputView.outputPurchaseLottoTicketCount(lottoPurchaseAmount)

    val lottoTickets: LottoTickets = LottoFactory.auto(lottoPurchaseAmount.lottoTicketCount())
    LottoOutputView.outputPurchaseLottoTickerInfos(lottoTickets)

    val inputWinningLottoNumbers = LottoInputView.inputWinningLottoNumbers()
    val inputBonusNumber = LottoInputView.inputBonusNumber()
    val winningNumbers = WinningNumbers(
        numbers = LottoTicket(inputWinningLottoNumbers.map { LottoNumber.of(it) }.toSet()),
        bonusNumber = LottoNumber.of(inputBonusNumber)
    )

    val lottoPrizes: LottoResults = LottoManager.winningConfirmation(lottoTickets, winningNumbers)
    LottoOutputView.outputLottoResults(lottoPrizes, lottoPurchaseAmount)
}
