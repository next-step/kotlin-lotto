package lotto

import lotto.domain.LottoTickets
import lotto.domain.LottoWonNumbers
import lotto.view.input.AmountInput
import lotto.view.InputView
import lotto.view.ResultView
import lotto.view.input.ManualCountInput
import lotto.view.input.ManualLottoInputs

fun main() {
    val inputView: InputView = InputView()
    val resultView: ResultView = ResultView()

    val amountInput: AmountInput = inputView.input()
    val manualCountInput: ManualCountInput = inputView.inputManualCount()
    val manualLottoInput: ManualLottoInputs = inputView.inputManualLottoTickets(manualCountInput)

    val lottoCollection = LottoTickets(amountInput.lottoCount, manualLottoInput.lottoTickets)
    resultView.printEachTypeCount(amountInput, manualCountInput)
    resultView.printLotto(lottoCollection)

    val wonNumbers = inputView.inputWonNumber()
    val bonusNumber = inputView.inputBonusNumber()

    val lottoWonNumber: LottoWonNumbers = LottoWonNumbers(wonNumbers, bonusNumber.bonusNumber)

    resultView.printWon(lottoCollection, lottoWonNumber)
    resultView.printRate(lottoCollection, lottoWonNumber)
}
