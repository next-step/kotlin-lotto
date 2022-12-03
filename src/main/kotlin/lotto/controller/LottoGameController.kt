package lotto.controller

import lotto.domain.AutoLotto
import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoGameResult
import lotto.domain.LottoGameStatus
import lotto.view.InputView
import lotto.view.ResultView
import java.math.BigDecimal

class LottoGameController {

    fun start() {
        val gameStatus = getPurchaseResultsAndNumberOfPurchases()

        val manualLottoList: List<Lotto> = InputView.pickManualLottoNumber(gameStatus.numberOfManual)
        val autoLottoList: List<Lotto> = LottoGame.pick(gameStatus.numberOfAuto, AutoLotto)

        ResultView.buyResult(gameStatus.numberOfManual, gameStatus.numberOfAuto)

        val gameBoard = LottoGame.setGameBoard(manualLottoList, autoLottoList)

        gameBoard.forEach { ResultView.printChosenNumber(it.numbers) }

        val gameResults = checkAnswers(gameBoard)
        printStatistics(gameResults, gameStatus.cost)
    }

    private fun getPurchaseResultsAndNumberOfPurchases(): LottoGameStatus {
        val purchaseResult = InputView.purchaseCost()
        val numberOfManual =
            InputView.numberOfManualPurchase(purchaseResult.numberOfGames)
        val numberOfAuto =
            LottoGame.calculateNumberOfAutoGames(purchaseResult.numberOfGames, numberOfManual.numberOfGames)

        return LottoGameStatus(
            purchaseResult.purchaseCost,
            purchaseResult.numberOfGames,
            numberOfManual.numberOfGames,
            numberOfAuto
        )
    }

    private fun checkAnswers(gameBoard: List<Lotto>): List<LottoGameResult> {
        val winnerNumber = InputView.winningNumberOfLastWeek()
        val bonusNumber = InputView.bonusNumberOfLastWeek(winnerNumber)
        return LottoGame.getResultOfGames(gameBoard, winnerNumber.winnerNumber, bonusNumber.bonusNumber)
    }

    private fun printStatistics(gameResults: List<LottoGameResult>, cost: BigDecimal) {
        ResultView.noticeOfPrize()
        val statistics = LottoGameResult.winningStatistics(gameResults)
        ResultView.printWinningStatistics(statistics)
        val rate = LottoGameResult.rate(gameResults, cost)
        ResultView.printRate(rate)
    }
}
