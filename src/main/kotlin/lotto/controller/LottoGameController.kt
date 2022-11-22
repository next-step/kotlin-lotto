package lotto.controller

import lotto.domain.AutoLotto
import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoGameResult
import lotto.view.InputView
import lotto.view.ResultView

class LottoGameController {

    fun main() {
        val purchaseResult = InputView.purchaseCost()
        InputView.numberOfPurchase(purchaseResult.numberOfGames)
        val gameBoard: ArrayList<Lotto> = ArrayList()

        repeat(purchaseResult.numberOfGames) {
            val lotto = LottoGame.start(AutoLotto)
            ResultView.printChosenNumber(lotto.numbers)
            gameBoard.add(lotto)
        }

        val winnerNumber = InputView.winningNumberOfLastWeek()
        val gameResults = gameBoard.map { LottoGame.checkAnswer(it, winnerNumber.winnerNumber) }

        ResultView.noticeOfPrize()
        LottoGameResult.winningStatistics(gameResults) {
            ResultView.printWinningStatistics(
                it.key.criteriaForWinning,
                it.key.prize,
                it.value
            )
        }
        val rate = LottoGameResult.rate(gameResults, purchaseResult.purchaseCost)
        ResultView.printRate(rate)
    }
}
