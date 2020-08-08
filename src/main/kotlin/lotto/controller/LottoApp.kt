package lotto.controller

import lotto.model.Buyer
import lotto.model.Store
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val price = InputView.requestByMode(InputView.Mode.PRICE)
    val buyer = Buyer(price).apply { buyLotto() }
    val store = Store(buyer)
    ResultView.printPurchasedLottoNumbers(buyer.purchasedLottos)

    val (winningLotto, bonusBall) =
        InputView.requestLottoNumberByType(InputView.LottoNumberType.WINNING) to InputView.requestByMode(InputView.Mode.BONUS_BALL)

    val lottoResults = store.drawLottoNumber(winningLotto, bonusBall)
    ResultView.printWinnerStatistics(lottoResults)

    val rateOfReturn = store.getRateOfReturn(price, lottoResults)
    ResultView.printRateOfReturn(rateOfReturn)
}
