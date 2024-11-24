package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val boughtLotto = InputView().input()
    val lottoResult = boughtLotto.matchResult()
    OutputView().printResult(lottoResult)
}