package lotto

import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchasePrice = InputView.inputPurchasePrice()
    val lottoGame = LottoGame(purchasePrice = purchasePrice)

    ResultView.printLottos(lottoGame.lottoList)
    val previousLottoNumbers = InputView.inputPreviousLottoNumbers()
    ResultView.printLottoResult(lottoGame.getResult(previousLottoNumbers))
}
