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

        val matchedLottoNumberCounts = calculateLottoMatchResults(lottos)

        calculateProfit(matchedLottoNumberCounts, purchaseAmountInput)
    }

    private fun initLottos(): Pair<String, Lottos> {
        val purchaseAmountInput = inputView.getPurchasAmountInput()
        val lottos = lottoAutoController.buyLottos(purchaseAmountInput)
        resultView.renderPurchaseLottoCountOutput(lottos.getLottos().size)
        lottos.getLottos().forEach { lotto ->
            resultView.renderPurchaseLottoNumbersOutput(lotto.numbers.map { it.num })
        }
        return Pair(purchaseAmountInput, lottos)
    }

    private fun calculateLottoMatchResults(lottos: Lottos): LottoMatchResults {
        val winningNumberInput = inputView.getWinningNumberInput()
        val bonusNumberInput = inputView.getBonusNumberInput()
        val matchResults = lottoAutoController.matchLottoNumbers(winningNumberInput, bonusNumberInput, lottos)

        resultView.renderResultOutput()
        for (lottoPrize in LottoPrize.getLottoPrizes()) {
            val matchCount = matchResults.findMatchCount(lottoPrize)
            resultView.renderLottoMatchResultOutput(
                lottoPrize.matchCount,
                lottoPrize.prizeAmount,
                matchCount,
                lottoPrize.hasBonus,
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
