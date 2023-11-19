package lotto

import lotto.view.InputView
import lotto.view.ResultView


fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoNumberGenerator = LottoNumberGenerator()
    val lottoList = LottoMachine.generateLotto(purchaseAmount, lottoNumberGenerator)

    ResultView.printLottoList(lottoList)

    val winningLotto = InputView.getWinningNumbers()
    val lottoResult = LottoResult.getResult(winningLotto, lottoList)

    ResultView.printWinningResult(lottoResult, purchaseAmount)

}
