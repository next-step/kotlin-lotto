package lotto

import lotto.domain.Amount
import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    try {
        startApp()
    }catch (e: Exception) {
        println(e.message)
    }
}

fun startApp() {
    val money = InputView.inputMoney()
    val manualLottoAmount = InputView.inputManualLottoAmount(money.getAmount())
    val amount = Amount(money.getAmount(), manualLottoAmount)
    val manualLottoList = InputView.inputManualLotto(amount)
    val lottoGame = LottoGame(amount, manualLottoList)
    ResultView.resultLotto(lottoGame.lottoList, amount)
    val correctLotto = InputView.inputCorrectLotto()
    val winningLotto = InputView.inputBonusBall(correctLotto)
    val rank = lottoGame.getRank(winningLotto)
    ResultView.resultRank(money.getRateOfReturn(rank), rank)
}
