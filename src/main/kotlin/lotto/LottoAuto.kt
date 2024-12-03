package lotto

import lotto.model.LottoMatchResults
import lotto.model.LottoPrize
import lotto.model.LottoPurchase
import lotto.model.Lottos
import lotto.view.InputView
import lotto.view.ResultView

class LottoAuto {
    private val lottoAutoController = LottoAutoController()

    private val inputView = InputView()
    private val resultView = ResultView()

    fun start() {
        val (purchaseAmount, purchasedLottoCount) = purchaseLottos()

        val lottos = displayLottoNumber(purchasedLottoCount)

        val matchedLottoNumberCounts = checkLottoNumbers(lottos)

        calculateProfit(matchedLottoNumberCounts, purchaseAmount)
    }

    private fun purchaseLottos(): LottoPurchase {
        val input = inputView.getPurchasAmountInput()
        val lottoPurchase = lottoAutoController.countPurchasedLotto(input)
        resultView.renderPurchaseLottoCountOutput(lottoPurchase.purchaseAmount)
        return lottoPurchase
    }

    private fun displayLottoNumber(count: Int): Lottos {
        val lottos = lottoAutoController.generateLottos(count)

        lottos.getLottos().forEach { lotto ->
            resultView.renderPurchaseLottoNumbersOutput(lotto.getNumbers().map { it.num })
        }
        return lottos
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
        purchaseAmount: Int,
    ) {
        val rate = lottoAutoController.calculateReturnRate(matchedLottoNumberCounts, purchaseAmount)
        resultView.renderLottoProfit(rate)
    }
}
