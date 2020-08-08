package lotto.controller

import lotto.model.Buyer
import lotto.model.Store
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val price = InputView.requestByMode(InputView.Mode.PRICE)
    val manualLotto = InputView.requestByMode(InputView.Mode.MANUALLY_BUY_NUMBER).let {
        if (it > 0) {
            InputView.requestLottoNumberByType(type = InputView.LottoNumberType.MANUAL, repeatCount = it)
        } else {
            emptyList()
        }
    }

    val buyer = Buyer(price).apply {
        setupManualLotto(manualLotto)
        buyLotto()
    }
    val store = Store(buyer)
    ResultView.printPurchasedLottoNumbers(buyer.lotto)

    val (winningLotto, bonusBall) =
        InputView.requestLottoNumberByType(InputView.LottoNumberType.WINNING).first() to
            InputView.requestByMode(InputView.Mode.BONUS_BALL)

    val lottoResults = store.drawLottoNumber(winningLotto, bonusBall)
    ResultView.printWinnerStatistics(lottoResults)

    val rateOfReturn = store.getRateOfReturn(price, lottoResults)
    ResultView.printRateOfReturn(rateOfReturn)
}
