package lotto.controller

import lotto.model.Buyer
import lotto.model.Lotto
import lotto.model.Store
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val price = InputView.requestPrice()
    val buyer = Buyer(price).apply { buyLotto() }
    val store = Store(buyer)
    ResultView.printPurchasedLottoNumbers(buyer.purchasedLottos)

    val (lastWeekLottoNumber, bonusBall) = InputView.requestWinningLottoNumber() to InputView.requestBonusBall()

    val lottoResults = store.drawLottoNumber(Lotto(lastWeekLottoNumber), bonusBall)
    ResultView.printWinnerStatistics(lottoResults)

    val rateOfReturn = store.getRateOfReturn(price, lottoResults)
    ResultView.printRateOfReturn(rateOfReturn)
}
