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
        val bonusNumber = InputView.bonusNumberOfLastWeek(winnerNumber)
        val gameResults = LottoGame.getResultOfGames(gameBoard, winnerNumber.winnerNumber, bonusNumber.bonusNumber)
        ResultView.noticeOfPrize()
        val statistics = LottoGameResult.winningStatistics(gameResults)
        ResultView.printWinningStatistics(statistics)
        val rate = LottoGameResult.rate(gameResults, purchaseResult.purchaseCost)
        ResultView.printRate(rate)
    }
}
