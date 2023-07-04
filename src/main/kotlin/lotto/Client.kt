package lotto

import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchasePrice = InputView.inputPurchasePrice()
    val manualLottoList = InputView.inputManualLottos()
    val manualLottoSize = manualLottoList.size()
    val lottoGame = LottoGame(purchasePrice = purchasePrice, lottoList = manualLottoList)

    ResultView.printLottos(lottoGame.lottoList, manualLottoSize)
    val winningLotto = InputView.inputWinningLotto()
    ResultView.printLottoResult(lottoGame.getResult(winningLotto))
}
