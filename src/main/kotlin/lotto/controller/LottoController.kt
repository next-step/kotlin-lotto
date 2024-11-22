package lotto.controller

import lotto.domain.LottoBallMachine
import lotto.domain.LottoGame
import lotto.domain.LottoPurchaseAmount
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoBallMachine: LottoBallMachine,
) {
    private val lottoGame: LottoGame
    private val lottoPurchaseAmount: LottoPurchaseAmount = LottoPurchaseAmount(inputView.inputPurchaseAmount())

    init {
        lottoGame = LottoGame(lottoPurchaseAmount, lottoBallMachine)
    }

    fun announcePurchasedLotto() {
        outputView.printPurchaseCount(lottoGame.getPurchaseCount())
        outputView.printPurchaseLottoLines(lottoGame.getLottoLines())
    }

    fun announceGameResult() {
        val winningLineInput = inputView.inputWinningNumbers()
        val gameResult = lottoGame.returnGameResult(winningLineInput)
        val lottoProfitRate = gameResult.makeLottoProfitRate(lottoPurchaseAmount.toLottoPurchaseCount())

        outputView.printGameResult(gameResult.extractResult())
        outputView.printLottoProfitRate(lottoProfitRate.rate)
    }
}
