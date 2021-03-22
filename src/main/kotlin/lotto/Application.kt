package lotto

import lotto.domain.LottoTickets
import lotto.domain.LottoWonNumbers
import lotto.view.input.AmountInput
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView: InputView = InputView()
    val amountInput: AmountInput = inputView.input()

    val lottoCollection = LottoTickets(amountInput.lottoCount)

    val resultView: ResultView = ResultView(lottoCollection)

    resultView.printLotto()

    val wonNumbers = inputView.inputWonNumber()
    val bonusNumber = inputView.inputBonusNumber()

    val lottoWonNumber: LottoWonNumbers = LottoWonNumbers(wonNumbers.wonNumber, bonusNumber.bonusNumber)

    resultView.printWon(lottoWonNumber)
    resultView.printRate(lottoWonNumber)
}
