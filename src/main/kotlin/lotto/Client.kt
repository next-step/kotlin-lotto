package lotto

import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchasePrice = InputView.inputPurchasePrice()
    val lottoGame = LottoGame(purchasePrice = purchasePrice)

    ResultView.printLottos(lottoGame.lottoList)
    val winningLotto = InputView.inputWinningLotto()
    val bonusNumber = InputView.inputBonusNumber()
    ResultView.printLottoResult(lottoGame.getResult(winningLotto))
}
