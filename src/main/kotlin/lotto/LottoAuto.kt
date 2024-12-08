package lotto

import lotto.model.LottoMatchResults
import lotto.model.LottoPrize
import lotto.model.Lottos
import lotto.view.InputView
import lotto.view.ResultView

class LottoAuto {
    private val lottoAutoController = LottoAutoController()

    private val inputView = InputView()
    private val resultView = ResultView()

    fun start() {
        val (purchaseAmountInput, lottos) = initLottos()

        val matchedLottoNumberCounts = checkLottoNumbers(lottos)

        calculateProfit(matchedLottoNumberCounts, purchaseAmountInput)
    }

    private fun initLottos(): Pair<String, Lottos> {
        val purchaseAmountInput = inputView.getPurchasAmountInput()
        val lottos = lottoAutoController.buyLottos(purchaseAmountInput)
        resultView.renderPurchaseLottoCountOutput(lottos.getLottos().size)
        lottos.getLottos().forEach { lotto ->
            resultView.renderPurchaseLottoNumbersOutput(lotto.getNumbers().map { it.num })
        }
        return Pair(purchaseAmountInput, lottos)
    }

    private fun checkLottoNumbers(lottos: Lottos): LottoMatchResults {
        val winningNumberInput = inputView.getWinningNumberInput()
        resultView.renderResultOutput()
        val matchResults = lottoAutoController.matchLottoNumbers(winningNumberInput, lottos)
        for (lottoPrize in LottoPrize.getLottoPrizes()) {
            val matchCount = matchResults.findMatchCount(lottoPrize)
            resultView.renderLottoMatchResultOutput(
                lottoPrize.matchCount,
                lottoPrize.prizeAmount,
                matchCount,
            )
        }
        return matchResults
    }

    private fun calculateProfit(
        matchedLottoNumberCounts: LottoMatchResults,
        purchaseAmountInput: String,
    ) {
        val rate = lottoAutoController.calculateReturnRate(matchedLottoNumberCounts, purchaseAmountInput)
        resultView.renderLottoProfit(rate)
    }
}
