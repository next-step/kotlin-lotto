package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoGameResult
import lotto.domain.PurchaseResult
import lotto.view.InputView
import lotto.view.ResultView

class LottoGameController {

    fun start() {
        val (purchaseResult, numberOfManual, numberOfAuto) = buyLottoGame()

        val manualLotto = InputView.pickManualLottoNumber(numberOfManual)

        ResultView.buyResult(numberOfManual, numberOfAuto)

        val gameBoard = LottoGame.setGameBoard(manualLotto, numberOfAuto)

        gameBoard.forEach { ResultView.printChosenNumber(it.numbers) }

        val gameResults = checkAnswers(gameBoard)
        statistics(gameResults, purchaseResult)
    }

    private fun buyLottoGame(): Triple<PurchaseResult, Int, Int> {
        val purchaseResult = InputView.purchaseCost()
        val numberOfManual =
            InputView.numberOfManualPurchase(purchaseResult.numberOfGames)
        val numberOfAuto =
            LottoGame.calculateNumberOfAutoGames(purchaseResult.numberOfGames, numberOfManual.numberOfGames)
        return Triple(purchaseResult, numberOfManual.numberOfGames, numberOfAuto)
    }

    private fun checkAnswers(gameBoard: List<Lotto>): List<LottoGameResult> {
        val winnerNumber = InputView.winningNumberOfLastWeek()
        val bonusNumber = InputView.bonusNumberOfLastWeek(winnerNumber)
        return LottoGame.getResultOfGames(gameBoard, winnerNumber.winnerNumber, bonusNumber.bonusNumber)
    }

    private fun statistics(gameResults: List<LottoGameResult>, purchaseResult: PurchaseResult) {
        ResultView.noticeOfPrize()
        val statistics = LottoGameResult.winningStatistics(gameResults)
        ResultView.printWinningStatistics(statistics)
        val rate = LottoGameResult.rate(gameResults, purchaseResult.purchaseCost)
        ResultView.printRate(rate)
    }
}
