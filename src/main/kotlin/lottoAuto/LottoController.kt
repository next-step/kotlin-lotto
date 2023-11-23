package lottoAuto

import lottoAuto.domain.FixedLottoFactory
import lottoAuto.domain.Lotto
import lottoAuto.domain.LottoNumber
import lottoAuto.domain.RandomLottoFactory
import lottoAuto.domain.WinningLotto
import lottoAuto.domain.toLottoNumber
import lottoAuto.view.InputView
import lottoAuto.view.OutputView

object LottoController {
    fun getWinningLotto(): WinningLotto {
        val winningNumbers = InputView.getWinningNumbers().map { it.toLottoNumber() }
        val bonusLottoNumber = InputView.getBonusNumber().toLottoNumber()
        return WinningLotto(
            lotto = Lotto(winningNumbers),
            bonusLottoNumber = bonusLottoNumber
        )
    }

    fun getBonusLottoNumber(): LottoNumber { // 제거
        val bonusNumber = InputView.getBonusNumber()
        return bonusNumber.toLottoNumber()
    }

    fun createLottoList(purchaseAmount: Int): List<Lotto> {
        val manualLottoSize = getManualLottoSize()
        val randomLottoSize = getRandomLottoSize(purchaseAmount, manualLottoSize)
        val manualNumbers = getManualLottoNumbers(manualLottoSize)

        val fixedLottoList = FixedLottoFactory(numbers = manualNumbers).create(manualLottoSize)
        val randomLottoList = RandomLottoFactory().create(randomLottoSize)
        val lottoList = fixedLottoList + randomLottoList

        OutputView.printNumOfLotto(
            numOfManualLotto = fixedLottoList.size,
            numOfRandomLotto = randomLottoList.size
        )

        lottoList.forEach {
            val lottoNumbers = it.lottoNumbers.map { lottoNumber -> lottoNumber.number }
            OutputView.printLottoNumbers(lottoNumbers)
        }
        return lottoList
    }

    private fun getManualLottoSize(): Int {
        return InputView.getManualLottoSize()
    }

    private fun getRandomLottoSize(purchaseAmount: Int, manualLottoSize: Int): Int {
        return (purchaseAmount / Lotto.LOTTO_PRICE) - manualLottoSize
    }

    private fun getManualLottoNumbers(lottoSize: Int): List<List<Int>> {
        return InputView.getManualLottoNumbers(lottoSize)
    }

    fun statistics(
        purchaseAmount: Int,
        lottoList: List<Lotto>,
        winningLotto: WinningLotto,
    ) {
        OutputView.printStatisticsHeader()
        val lottoRanks = winningLotto.rank(lottoList)
        val lottoRankGroup = lottoRanks.groupByLottoRank()
        val profit = lottoRankGroup.calcProfit(purchaseAmount)

        OutputView.printStatistics(lottoRankGroup)
        OutputView.printProfitResult(profit.rateOfReturn, profit.resultMsg)
    }
}

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoList = LottoController.createLottoList(purchaseAmount)
    val winningLotto = LottoController.getWinningLotto()

    LottoController.statistics(purchaseAmount, lottoList, winningLotto)
}
