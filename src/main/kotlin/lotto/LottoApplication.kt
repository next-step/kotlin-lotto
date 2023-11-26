package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val lottoGame = LottoGame()

    val amount = inputView.inputPrice()
    val count = LottoGame().getLottoCount(amount)

    resultView.printCount(count)

    val lottoList = lottoGame.start(count)
    resultView.printLottoList(lottoList)

    val lastNumbers = inputView.inputNumbers()

    lottoGame.match(lottoList, lastNumbers)
    val result = lottoGame.result(lottoList)
    val totalWinningMoney = lottoGame.getTotalWinningMoney(result)
    resultView.printResult(amount, result, totalWinningMoney)
}
