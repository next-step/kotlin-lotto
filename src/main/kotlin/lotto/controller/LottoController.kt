package lotto.controller

import lotto.adapter.LottoInputAdapter
import lotto.domain.LottoBallMachine
import lotto.domain.LottoGame
import lotto.domain.LottoPurchaseAmount
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    lottoBallMachine: LottoBallMachine,
) {
    private val adapter = LottoInputAdapter()
    private val lottoGame: LottoGame
    private val lottoPurchaseAmount: LottoPurchaseAmount

    init {
        val purchaseInput = inputView.inputPurchaseAmount()
        lottoPurchaseAmount = adapter.adaptPurchaseAmount(purchaseInput)
        lottoGame = LottoGame(lottoPurchaseAmount, lottoBallMachine)
    }

    fun announcePurchasedLotto() {
        outputView.printPurchaseCount(lottoGame.getPurchaseCount())
        outputView.printPurchaseLottoLines(lottoGame.getLottoLines())
    }

    fun announceGameResult() {
        val winningLineInput = inputView.inputWinningNumbers()
        val winningNumbers = adapter.adaptWinningNumbers(winningLineInput)
        val gameResult = lottoGame.returnGameResult(winningNumbers)
        val lottoProfitRate = gameResult.makeLottoProfitRate(lottoPurchaseAmount.toLottoPurchaseCount())

        outputView.printGameResult(gameResult.extractResult())
        outputView.printLottoProfitRate(lottoProfitRate.rate)
    }
}
