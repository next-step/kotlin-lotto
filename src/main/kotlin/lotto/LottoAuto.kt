package lotto

import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.ResultView

class LottoAuto {
    private val lottoAutoController = LottoAutoController()

    private val purchaseAmountInput = InputView("구입금액을 입력해 주세요.")
    private val winningLottoInput = InputView("지난 주 당첨 번호를 입력해 주세요.")

    fun start() {
        val (purchaseAmount, purchasedLottoCount) = purchaseLottos()

        val lottos = diplayLottoNumber(purchasedLottoCount)

        val matchedLottoNumberCounts = checkLottoNumbers(lottos)

        calculateProfit(matchedLottoNumberCounts, purchaseAmount)
    }

    private fun purchaseLottos(): Pair<Int, Int> {
        val input = purchaseAmountInput.getIntput()
        val (purchaseAmount, purchasedLottoCount) = lottoAutoController.countPurchasedLotto(input)
        ResultView("${purchasedLottoCount}개를 구매했습니다.").render()
        return purchaseAmount to purchasedLottoCount
    }

    private fun diplayLottoNumber(purchasedLottoCount: Int): List<Lotto> {
        val purchasedLottos = lottoAutoController.generateLottos(purchasedLottoCount)
        repeat(purchasedLottos.size) { idx ->
            ResultView(purchasedLottos[idx].numbers.toString()).render()
        }
        return purchasedLottos
    }

    private fun checkLottoNumbers(lottos: List<Lotto>): Map<Int, Int> {
        val input = winningLottoInput.getIntput()
        ResultView("당첨 통계\n--------").render()
        val matchedLottoNumberCounts = lottoAutoController.matchLottoNumbers(input, lottos)
        ResultView("3개 일치 (5000원)- ${matchedLottoNumberCounts.getOrDefault(3, 0)}개").render()
        ResultView("4개 일치 (50000원)- ${matchedLottoNumberCounts.getOrDefault(4, 0)}개").render()
        ResultView("5개 일치 (150000원)- ${matchedLottoNumberCounts.getOrDefault(5, 0)}개").render()
        ResultView("6개 일치 (2000000000원)- ${matchedLottoNumberCounts.getOrDefault(6, 0)}개").render()
        return matchedLottoNumberCounts
    }

    private fun calculateProfit(
        matchedLottoNumberCounts: Map<Int, Int>,
        purchaseAmount: Int,
    ) {
        val rate = lottoAutoController.calculateReturnRate(matchedLottoNumberCounts, purchaseAmount)
        ResultView("총 수익률은 ${rate}입니다.").render()
    }
}
