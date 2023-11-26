package lotto

import lotto.view.InputType
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val lottoGame = LottoGame()

    val amount = inputView.inputNumber(InputType.PURCHASE_AMOUNT)
    val count = LottoGame().getLottoCount(amount)

    resultView.printCount(count)

    val lottoList = lottoGame.getLottoList(count)
    resultView.printLottoList(lottoList)

    val lastLotto = inputView.inputLastLotto()
    val bonus = inputView.inputNumber(InputType.BONUS_BALL)

    val result = lottoGame.result(lottoList, lastLotto, bonus)
    val totalWinningMoney = lottoGame.getTotalWinningMoney(result)
    resultView.printResult(amount, result, totalWinningMoney)
}
