package lotto.controller

import lotto.model.Buyer
import lotto.model.Lotto
import lotto.model.Store
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val price = InputView.requestByMode(InputView.Mode.PRICE)
    val buyer = Buyer(price).apply {
        setupManualLotto(getManualLotto())
        buyLotto()
    }
    ResultView.printPurchasedLottoNumbers(manualLotto = buyer.manualLotto, autoLotto = buyer.autoLotto)

    showLottoResult(buyer, price)
}

private fun showLottoResult(buyer: Buyer, price: Int) {
    val (winningLotto, bonusBall) =
        InputView.requestLottoNumberByType(InputView.LottoNumberType.WINNING).first() to
            InputView.requestByMode(InputView.Mode.BONUS_BALL)

    val lottoResults =
        Store.drawLottoNumber(
            buyerLotto = listOf(buyer.autoLotto, buyer.manualLotto).flatten(),
            winningLotto = winningLotto,
            bonusBall = bonusBall
        )
    ResultView.printWinnerStatistics(lottoResults)

    val rateOfReturn = Store.getRateOfReturn(price, lottoResults)
    ResultView.printRateOfReturn(rateOfReturn)
}

private fun getManualLotto(): List<Lotto> {
    InputView.requestByMode(InputView.Mode.MANUALLY_BUY_NUMBER).let {
        return if (it > 0) {
            InputView.requestLottoNumberByType(type = InputView.LottoNumberType.MANUAL, repeatCount = it)
        } else {
            emptyList()
        }
    }
}
