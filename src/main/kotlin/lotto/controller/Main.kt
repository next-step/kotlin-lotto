package lotto.controller

import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val lottoGame = LottoGame(inputView.readMoney())

    resultView.showLottoNums(lottoGame.makeLottoNums())

    val winningNums = inputView.readWinningNums()
    val bonusNum = inputView.readBonusNum()
    resultView.showWinningStats(lottoGame.matchLottoNums(winningNums, bonusNum))
}
