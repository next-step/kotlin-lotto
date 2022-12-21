package lotto.controller

import lotto.controller.dto.WinningPrizeInfo
import lotto.controller.dto.WinningStatistic
import lotto.domain.LottoMachine
import lotto.domain.LottoNumbers
import lotto.domain.WinningNumbers
import lotto.domain.WinningPrize
import lotto.domain.WinningPrizes
import lotto.domain.vo.PurchaseAmount
import lotto.view.ConsoleInput
import lotto.view.ConsoleOutput

class LottoController(private val input: ConsoleInput, private val output: ConsoleOutput) {
    fun start() {
        val purchaseAmount = PurchaseAmount(input.getPurchaseAmount())
        val manualLottoCount = input.getManualLottoCount()
        val manualLottoNumbers = input.getManualLottoNumbers(manualLottoCount).map { LottoNumbers(it) }
        val autoLottoNumbers = LottoMachine.createAutoLottoNumbers(purchaseAmount, manualLottoCount)
        val lottoNumbers = manualLottoNumbers + autoLottoNumbers

        output.printPurchasedLottoCount(lottoNumbers.size, manualLottoCount)
        lottoNumbers.forEach { output.printLottoNumbers(it.numbers()) }

        val winningNumbers = WinningNumbers(input.getWinnerNumbers(), input.getBonusBall())
        val winningPrizes = WinningPrizes(lottoNumbers.map { winningNumbers.matchPrize(it) })
        val winningStatistic = createWinningStatistic(winningPrizes)
        val rateOfReturn = winningPrizes.calculateTotalRateOfReturn(purchaseAmount)

        output.printWinningPrize(winningStatistic, rateOfReturn)
    }

    private fun createWinningStatistic(winningPrizes: WinningPrizes): WinningStatistic {
        val winningPrizeInfos = WinningPrize.values().map {
            WinningPrizeInfo(it.matchedCount, it.prize, it.hasBonusNumber)
        }

        val statisticOfWinningPrize = winningPrizes.extractStatisticOfWinningPrize().mapKeys {
            WinningPrizeInfo(it.key.matchedCount, it.key.prize, it.key.hasBonusNumber)
        }

        return WinningStatistic(winningPrizeInfos, statisticOfWinningPrize)
    }
}
