package lotto

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
    val lottoGame = LottoGame(money)
    ResultView.resultLotto(lottoGame.lottoList)
    val correctLotto = InputView.inputCorrectLotto()
    val winningLotto = InputView.inputBonusBall(correctLotto)
    val rank = lottoGame.getRank(winningLotto)
    ResultView.resultRank(money.getRateOfReturn(rank), rank)
}
