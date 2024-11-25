package lotto.client

import lotto.Lotto
import lotto.LottoMachine
import lotto.statistics.Profit
import lotto.statistics.WinningNumber
import lotto.statistics.WinningStatistics
import lotto.view.InputView
import lotto.view.ResultView

class LottoClient(
    private val lottoMachine: LottoMachine,
) {
    fun run() {
        val amount =
            InputView
                .inputPurchaseAmount()
                .also { require(it >= Lotto.PRICE) { "구입 금액이 부족합니다." } }

        val lottoCount = getLottoCount(amount)

        val manualLottos =
            InputView
                .inputManualLottoCount()
                .let { InputView.inputManualLottoNumbers(it) }
                .let { lottoMachine.generateByManual(numbers = it) }

        val autoLottoCount = lottoCount - manualLottos.lottos.size
        require(autoLottoCount >= 0) { "구입금액이 부족하여 수동 로또를 구매할 수 없습니다." }

        val lottos = manualLottos + lottoMachine.generate(lottoCount = autoLottoCount)

        ResultView.printLottoCount(manualLottoCount = manualLottos.lottos.size, autoLottoCount = autoLottoCount)
        ResultView.printLottoList(lottos)

        val winningNumbers = InputView.inputLastWeekWinningNumbers()
        val bonusBall =
            InputView
                .inputBonusBall()
                .also { it.isNotDuplicated(winningNumber = winningNumbers) }

        val lottoRanks =
            WinningStatistics(
                purchasedLottos = lottos,
                winningNumber = WinningNumber(numbers = winningNumbers, bonusBall = bonusBall),
            ).ranks
        ResultView.printStatistics(lottoRanks = lottoRanks)

        val profit = Profit(winningAmount = lottoRanks.sumOf { it.prize }, purchaseAmount = amount).calculateYield()
        ResultView.printProfit(profit)
    }

    private fun getLottoCount(purchaseAmount: Int): Int = (purchaseAmount / Lotto.PRICE)
}
