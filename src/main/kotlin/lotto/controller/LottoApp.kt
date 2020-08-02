package lotto.controller

import lotto.model.Buyer
import lotto.model.Store
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val price = InputView.requestPrice()
    val buyer = Buyer().apply { buyLotto(price) }
    val store = Store(buyer)
    ResultView.printPurchasedLottoNumbers(buyer.purchasedLottos)

    val lastWeekLottoNumber = InputView.requestLastWeekLottoNumber()
    val lottoResults = store.drawLottoNumber(lastWeekLottoNumber)
    ResultView.printWinnerStatistics(lottoResults)

    val rateOfReturn = store.getRateOfReturn(price, lottoResults)
    ResultView.printRateOfReturn(rateOfReturn)
}
