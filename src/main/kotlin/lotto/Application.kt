package lotto

import lotto.domain.LottoCollection
import lotto.domain.LottoWonNumbers
import lotto.view.Input
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView: InputView = InputView()
    val input: Input = inputView.input()

    val lottoCollection = LottoCollection(input.lottoCount)

    val resultView: ResultView = ResultView(lottoCollection)

    resultView.printLotto()

    val wonNumbers: LottoWonNumbers = inputView.inputWonNumber()

    resultView.printWon(wonNumbers)
    resultView.printRate(wonNumbers)
}
