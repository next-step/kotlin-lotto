package lotto.controller

import lotto.domain.AutoLotto
import lotto.domain.LottoGame
import lotto.domain.LottoGameResult
import lotto.view.InputView
import lotto.view.ResultView

class LottoGameController {

    fun start() {
        val purchaseResult = InputView.purchaseCost()
        InputView.numberOfPurchase(purchaseResult.numberOfGames)

        val gameBoard = LottoGame.pick(purchaseResult.numberOfGames, AutoLotto)
        gameBoard.forEach { ResultView.printChosenNumber(it.numbers) }

        val winnerNumber = InputView.winningNumberOfLastWeek()
        val gameResults = LottoGame.getResultOfGames(gameBoard, winnerNumber.winnerNumber)
        ResultView.noticeOfPrize()
        val statistics = LottoGameResult.winningStatistics(gameResults)
        statistics.forEach {
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
