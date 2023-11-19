package lottoAuto

import lottoAuto.domain.Lotto
import lottoAuto.domain.LottoFactory
import lottoAuto.domain.LottoNumber
import lottoAuto.domain.LottoRank
import lottoAuto.domain.LottoProfitCalculator
import lottoAuto.domain.toLottoNumber
import lottoAuto.domain.WinningLotto
import lottoAuto.view.InputView
import lottoAuto.view.OutputView

object LottoController {
    fun getPurchaseAmount(): Int {
        return InputView.getPurchaseAmount()
    }

    fun getWinningNumbers(): List<LottoNumber> {
        return InputView.getWinningNumbers().map { it.toLottoNumber() }
    }

    fun getWinningLotto(winningNumbers: List<LottoNumber>, bonusLottoNumber: LottoNumber): WinningLotto {
        return WinningLotto(
            winningLottoNumbers = winningNumbers,
            bonusLottoNumber = bonusLottoNumber
        )
    }

    fun getBonusLottoNumber(): LottoNumber {
        val bonusNumber = InputView.getBonusNumber()
        return bonusNumber.toLottoNumber()
    }

    fun createLottoList(purchaseAmount: Int): List<Lotto> {
        val lottoList = LottoFactory.create(purchaseAmount)
        OutputView.printNumOfLotto(lottoList.size)

        lottoList.forEach {
            val lottoNumbers = it.lottoNumbers.map { lottoNumber -> lottoNumber.number }
            OutputView.printLottoNumbers(lottoNumbers)
        }
        return lottoList
    }

    fun statistics(
        purchaseAmount: Int,
        lottoList: List<Lotto>,
        winningLotto: WinningLotto,
    ) {
        OutputView.printStatisticsHeader()
        val lottoRanks = winningLotto.rank(lottoList)
        val lottoRankGroup = lottoRanks.groupByLottoRank()
        lottoRankGroup
            .entries
            .forEach {
                OutputView.printStatistics(
                    matchCount = it.key.matchCount,
                    winningMoney = it.key.winningMoney,
                    countValue = it.value,
                    isBonusMatch = it.key == LottoRank.BONUS
                )
            }

        val totalWinningMoney = lottoRanks.getTotalWinningMoney()
        val profit = LottoProfitCalculator.calcProfit(purchaseAmount, totalWinningMoney)
        OutputView.printProfitResult(profit.rateOfReturn, profit.resultMsg)
    }
}

fun main() {
    val purchaseAmount = LottoController.getPurchaseAmount()
    val lottoList = LottoController.createLottoList(purchaseAmount)
    val winningNumbers = LottoController.getWinningNumbers()
    val bonusLottoNumber = LottoController.getBonusLottoNumber()
    val winningLotto = LottoController.getWinningLotto(winningNumbers, bonusLottoNumber)

    LottoController.statistics(purchaseAmount, lottoList, winningLotto)
}
