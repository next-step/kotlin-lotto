package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoPurchaseAmount
import lotto.infrastructure.RandomLottoBallMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val lottoPurchaseAmount = LottoPurchaseAmount(inputView.inputPurchaseAmount())
    val lottoGame = LottoGame(lottoPurchaseAmount, RandomLottoBallMachine())

    outputView.printPurchaseCount(lottoGame.getPurchaseCount())
    outputView.printPurchaseLottoLines(lottoGame.getLottoLines())

    val winningLineInput = inputView.inputWinningNumbers()

    val gameResult = lottoGame.returnGameResult(winningLineInput)
    val lottoProfitRate = gameResult.makeLottoProfitRate(lottoPurchaseAmount.toLottoPurchaseCount())

    outputView.printGameResult(gameResult.extractResult())
    outputView.printLottoProfitRate(lottoProfitRate.rate)
}
