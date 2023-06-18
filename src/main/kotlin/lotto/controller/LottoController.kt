package lotto.controller

import lotto.domain.LottoReturnCalculator
import lotto.domain.LottoVendingMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoList = LottoVendingMachine()
        .purchase(InputView.getPurchaseAmount())
    ResultView.printLotto(lottoList)
    val lottoNumbersOfLastWeek = InputView.getLottoNumbersOfLastWeek()
    val lottoReturn = LottoReturnCalculator(lottoList).calculate(lottoNumbersOfLastWeek)
    ResultView.printReturn(lottoReturn)
}
