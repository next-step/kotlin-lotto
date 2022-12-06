package lotto.controller

import lotto.controller.dto.WinningPrizeInfo
import lotto.controller.dto.WinningStatistic
import lotto.domain.LottoMachine
import lotto.domain.WinningNumbers
import lotto.domain.WinningPrize
import lotto.domain.WinningPrizes
import lotto.domain.vo.PurchaseAmount
import lotto.view.ConsoleInput
import lotto.view.ConsoleOutPut

class LottoController(private val input: ConsoleInput, private val outPut: ConsoleOutPut) {
    fun start() {
        val purchaseAmount = PurchaseAmount(input.getPurchaseAmount())
        val lottoNumbers = LottoMachine.createLottoNumbers(purchaseAmount)

        outPut.printPurchasedLottoCount(lottoNumbers.size)
        lottoNumbers.forEach { outPut.printLottoNumbers(it.numbers()) }

        val winningNumbers = WinningNumbers(input.getWinnerNumbers(), input.getBonusBall())
        val winningPrizes = WinningPrizes(lottoNumbers.map { winningNumbers.matchPrize(it) })
        val winningStatistic = WinningStatistic(WinningPrize.values().map { WinningPrizeInfo(it.matchedCount, it.prize) }, winningPrizes.extractStatisticOfMatchedCount())
        val rateOfReturn = winningPrizes.calculateTotalRateOfReturn(purchaseAmount)

        outPut.printResult(winningStatistic, rateOfReturn)
    }
}
