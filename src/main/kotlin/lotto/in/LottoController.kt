package lotto.`in`

import lotto.domain.LottoMachine
import lotto.domain.LottoNumbers
import lotto.domain.WinningPrize
import lotto.domain.vo.PurchaseAmount
import lotto.`in`.dto.WinningStatistic

class LottoController(private val input: ConsoleInput, private val outPut: ConsoleOutPut) {
    fun start() {
        val purchaseAmount = PurchaseAmount(input.getPurchaseAmount())
        val lottoNumbers = LottoMachine.createLottoNumbers(purchaseAmount)

        outPut.printPurchasedLottoCount(lottoNumbers.size)
        lottoNumbers.forEach { outPut.printLottoNumbers(it.numbers()) }

        val winnerNumbers = LottoNumbers(input.getWinnerNumbers())
        val winningPrizes = lottoNumbers.map { winnerNumbers.countMatchedNumbers(it) }
            .map { WinningPrize.find(it) }
        val winningStatistic = createWinningStatistic(winningPrizes)
        val rateOfReturn = winningPrizes.sumOf { it.calculateRateOfReturn(purchaseAmount) }

        outPut.printResult(winningStatistic, rateOfReturn)
    }

    private fun createWinningStatistic(winningPrizes: List<WinningPrize>): WinningStatistic {
        val duplicateMatchedCount = winningPrizes.map { it.matchedCount to it.prize }
            .groupingBy { it.first }
            .eachCount()

        return WinningStatistic(WinningPrize.values().map { it.matchedCount to it.prize }, duplicateMatchedCount)
    }
}
