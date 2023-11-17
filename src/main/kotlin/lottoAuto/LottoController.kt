package lottoAuto

import lottoAuto.domain.*
import lottoAuto.domain.LottoNumber.Companion.toLottoNumber
import lottoAuto.view.InputView
import lottoAuto.view.OutputView

object LottoController {
    private const val LOTTO_PRICE = 1000

    fun getPurchaseAmount(): Int {
        return InputView.getPurchaseAmount()
    }

    fun getWinningLotto(): WinningLotto {
        return WinningLotto(
            InputView.getWinningLottoNumbers().map { it.toLottoNumber() }
        )
    }

    fun createLottoList(purchaseAmount: Int): List<Lotto> {
        val numOfLotto = purchaseAmount / LOTTO_PRICE
        OutputView.printNumOfLotto(numOfLotto)

        val lottoList = LottoFactory.create(numOfLotto)
        lottoList.forEach {
            val lottoNumbers = it.lottoNumbers.map { lottoNumber -> lottoNumber.number }
            OutputView.printLottoNumbers(lottoNumbers)
        }
        return lottoList
    }

    fun statistics(purchaseAmount: Int, lottoList: List<Lotto>, winningLotto: WinningLotto) {
        OutputView.printStatisticsHeader()
        val lottoRanks = LottoRanker.rank(
            lottoList,
            winningLotto
        )
        val lottoRankGroup = lottoRanks.groupByLottoRank()
        lottoRankGroup
            .entries
            .forEach {
                OutputView.printLottoStatistics(it.key.matchCount, it.key.winningMoney, it.value)
            }

        val totalWinningMoney = lottoRanks.getTotalWinningMoney()
        val profit = LottoProfitCalculator.calcProfit(purchaseAmount, totalWinningMoney)
        OutputView.printProfitResult(profit.rateOfReturn, profit.resultMsg)
    }

}

fun main() {
    val purchaseAmount = LottoController.getPurchaseAmount()
    val lottoList = LottoController.createLottoList(purchaseAmount)
    val winningLottoNumbers = LottoController.getWinningLotto()

    LottoController.statistics(purchaseAmount, lottoList, winningLottoNumbers)
}
