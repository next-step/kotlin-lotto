package lotto.controller

import lotto.domain.LottoGame
import lotto.domain.LottoGameResult
import lotto.view.InputView
import lotto.view.ResultView

class LottoGameController {

    fun start() {
        val purchaseResult = InputView.purchaseCost()
        val numberOfManual =
            InputView.numberOfManualPurchase(purchaseResult.numberOfGames)
        val numberOfAuto =
            LottoGame.calculateNumberOfAutoGames(purchaseResult.numberOfGames, numberOfManual.numberOfGames)
        ResultView.buyResult(numberOfManual.numberOfGames, numberOfAuto)

        val manualLotto = InputView.pickManualLottoNumber(numberOfManual.numberOfGames)
        val gameBoard = LottoGame.setGameBoard(manualLotto, numberOfAuto)

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
