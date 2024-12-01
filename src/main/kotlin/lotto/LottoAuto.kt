package lotto

import lotto.model.Lotto
import lotto.model.LottoMatchPrize
import lotto.model.LottoPurchase
import lotto.view.InputView
import lotto.view.ResultView

class LottoAuto {
    private val lottoAutoController = LottoAutoController()

    private val inputView = InputView()
    private val resultView = ResultView()

    fun start() {
        val (purchaseAmount, purchasedLottoCount) = purchaseLottos()

        val lottos = diplayLottoNumber(purchasedLottoCount)

        val matchedLottoNumberCounts = checkLottoNumbers(lottos)

        calculateProfit(matchedLottoNumberCounts, purchaseAmount)
    }

    private fun purchaseLottos(): LottoPurchase {
        val input = inputView.getPurchasAmountInput()
        val lottoPurchase = lottoAutoController.countPurchasedLotto(input)
        resultView.renderPurchaseLottoCountOutput(lottoPurchase.purchaseAmount)
        return lottoPurchase
    }

    private fun diplayLottoNumber(purchasedLottoCount: Int): List<Lotto> {
        val purchasedLottos = lottoAutoController.generateLottos(purchasedLottoCount)
        repeat(purchasedLottos.size) { idx ->
            resultView.renderPurchaseLottoNumbersOutput(purchasedLottos[idx].numbers)
        }
        return purchasedLottos
    }

    private fun checkLottoNumbers(lottos: List<Lotto>): Map<Int, Int> {
        val input = inputView.getWinningNumberInput()
        resultView.renderResultOutput()
        val matchedLottoNumberCounts = lottoAutoController.matchLottoNumbers(input, lottos)
        for (prize in LottoMatchPrize.getLottoMatchPrizes()) {
            val count = matchedLottoNumberCounts.getOrDefault(prize.matchCount, 0)
            resultView.renderLottoMatchResultOutput(prize.matchCount, prize.prizeAmount, count)
        }
        return matchedLottoNumberCounts
    }

    private fun calculateProfit(
        matchedLottoNumberCounts: Map<Int, Int>,
        purchaseAmount: Int,
    ) {
        val rate = lottoAutoController.calculateReturnRate(matchedLottoNumberCounts, purchaseAmount)
        resultView.renderLottoProfit(rate)
    }
}
