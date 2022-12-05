package lotto

import lotto.ui.LottoController
import lotto.ui.view.InputView
import lotto.ui.view.ResultView

fun main() {
    val purchasePrice = InputView.getPurchasePrice()
    val purchaseLottoList = LottoController.apply(purchasePrice)

    val winningLottoNumbers = InputView.getWinningLotto()
    val lottoResult = LottoController.draw(purchaseLottoList, winningLottoNumbers)

    ResultView.printLottoResult(lottoResult)
}
