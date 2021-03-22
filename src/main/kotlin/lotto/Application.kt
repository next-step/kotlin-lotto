package lotto

import lotto.domain.LottoTickets
import lotto.domain.LottoWonNumbers
import lotto.view.Input
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView: InputView = InputView()
    val input: Input = inputView.input()

    val lottoCollection = LottoTickets(input.lottoCount)

    val resultView: ResultView = ResultView(lottoCollection)

    resultView.printLotto()

    val inputWonNumber = inputView.inputWonNumber()

    val wonNumbers: LottoWonNumbers = LottoWonNumbers(inputWonNumber.wonNumber, inputWonNumber.bonusNumber)

    resultView.printWon(wonNumbers)
    resultView.printRate(wonNumbers)
}
