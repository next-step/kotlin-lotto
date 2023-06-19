package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val price = InputView.purchaseAmount()
    val lottoNumbers = AutoLotto().generateNumbers(price)
    ResultView.printLotto(lottoNumbers)

    val lastWeekLottoNumber = InputView.lastWeekLottoNumber()
    val lottoReturn = LottoResult.from(lottoNumbers, lastWeekLottoNumber)
    ResultView.printReturn(lottoReturn)
}
