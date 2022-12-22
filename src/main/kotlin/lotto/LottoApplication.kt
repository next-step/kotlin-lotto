package lotto

import lotto.ui.LottoController
import lotto.ui.view.InputView
import lotto.ui.view.ResultView

fun main() {
    val purchasePrice = InputView.getPurchasePrice()
    val purchaseLottos = LottoController.applyLotto(purchasePrice)

    val winningLottoNumbers = InputView.getWinningLotto()
    val winningLotto = LottoController.drawLotto(winningLottoNumbers)

    val lottoResult = LottoController.announceLottoResult(purchaseLottos, winningLotto)

    ResultView.printLottoResult(lottoResult)
}
