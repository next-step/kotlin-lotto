package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val price = InputView.purchaseAmount()
    val lottoNumbers = AutoLotto().generateNumbers(price)
    ResultView.printLotto(lottoNumbers)

    val lastWeekLotto = InputView.lastWeekLottoNumber()
    val lastWeekBonusNumber = InputView.lastWeekBonusNumber()
    val lottoReturn = LottoResult.from(
        lottos = lottoNumbers,
        lastWeekResultLotto = ResultLotto.from(
            lotto = lastWeekLotto,
            bonusNumber = lastWeekBonusNumber,
        ),
    )
    ResultView.printReturn(lottoReturn)
}
