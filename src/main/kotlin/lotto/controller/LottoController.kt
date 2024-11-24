package lotto.controller

import lotto.adapter.LottoInputAdapter
import lotto.domain.LottoGame
import lotto.domain.LottoPurchaseAmount
import lotto.response.LottoLinesResponse
import lotto.response.LottoRankResponse
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val adapter: LottoInputAdapter,
) {
    fun getLottoPurchaseAmount(): LottoPurchaseAmount {
        val purchaseInput = inputView.inputPurchaseAmount()
        return adapter.adaptPurchaseAmount(purchaseInput)
    }

    fun announcePurchasedLotto(lottoGame: LottoGame) {
        outputView.printPurchaseCount(lottoGame.getPurchaseCount())
        val lottoLines = lottoGame.getLottoLines()
        val lottoLinesResponse = LottoLinesResponse(lottoLines)
        outputView.printPurchaseLottoLines(lottoLinesResponse)
    }

    fun announceGameResult(
        lottoGame: LottoGame,
        lottoPurchaseAmount: LottoPurchaseAmount,
    ) {
        val winningLineInput = inputView.inputWinningNumbers()
        val winningNumbers = adapter.adaptWinningNumbers(winningLineInput)
        val gameResult = lottoGame.returnGameResult(winningNumbers)
        val lottoProfitRate = gameResult.makeLottoProfitRate(lottoPurchaseAmount.toLottoPurchaseCount())

        val gameResultResponse =
            gameResult.extractResult().map {
                LottoRankResponse(it.first, it.second)
            }

        outputView.printGameResult(gameResultResponse)
        outputView.printLottoProfitRate(lottoProfitRate.rate)
    }
}
