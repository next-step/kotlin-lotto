package lotto

import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchasePrice = InputView.inputPurchasePrice()
    val lottoGame = LottoGame(lottoPrice = purchasePrice)
    val previousLottoNumbers = InputView.inputPreviousLottoNumbers()
    ResultView.printLottoResult(lottoGame.getResult(previousLottoNumbers))
}
