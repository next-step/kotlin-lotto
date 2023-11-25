package lottoAuto

import lottoAuto.domain.FixedLottoFactory
import lottoAuto.domain.Lotto
import lottoAuto.domain.RandomLottoFactory
import lottoAuto.domain.WinningLotto
import lottoAuto.domain.toLottoNumber
import lottoAuto.view.InputView
import lottoAuto.view.OutputView

object LottoController {
    fun createLottos(): List<Lotto> {
        val purchaseAmount = InputView.getPurchaseAmount()
        val fixedLottos = createFixedLottos()
        val randomLottos = createRandomLottos(purchaseAmount, fixedLottos.size)
        OutputView.printNumOfLotto(
            numOfManualLotto = fixedLottos.size,
            numOfRandomLotto = randomLottos.size
        )

        val lottos = fixedLottos + randomLottos
        lottos.forEach {
            val lottoNumbers = it.lottoNumbers.map { lottoNumber -> lottoNumber.number }
            OutputView.printLottoNumbers(lottoNumbers)
        }
        return lottos
    }

    private fun createFixedLottos(): List<Lotto> {
        val manualLottoSize = InputView.getManualLottoSize()
        val manualNumbers = InputView.getManualLottoNumbers(manualLottoSize)
        return FixedLottoFactory(numbers = manualNumbers).create(manualLottoSize)
    }

    private fun createRandomLottos(purchaseAmount: Int, manualLottoSize: Int): List<Lotto> {
        val randomLottoSize = (purchaseAmount / Lotto.LOTTO_PRICE) - manualLottoSize
        return RandomLottoFactory().create(randomLottoSize)
    }

    fun getWinningLotto(): WinningLotto {
        val winningNumbers = InputView.getWinningNumbers().map { it.toLottoNumber() }
        val bonusLottoNumber = InputView.getBonusNumber().toLottoNumber()
        return WinningLotto(
            lotto = Lotto(winningNumbers),
            bonusLottoNumber = bonusLottoNumber
        )
    }

    fun statistics(
        lottos: List<Lotto>,
        winningLotto: WinningLotto,
    ) {
        OutputView.printStatisticsHeader()
        val lottoRanks = winningLotto.rank(lottos)
        val lottoRankGroup = lottoRanks.groupByLottoRank()
        val profit = lottoRankGroup.calcProfit(lottos.size * Lotto.LOTTO_PRICE)

        OutputView.printStatistics(lottoRankGroup)
        OutputView.printProfitResult(profit.rateOfReturn, profit.resultMsg)
    }
}

fun main() {
    val lottos = LottoController.createLottos()
    val winningLotto = LottoController.getWinningLotto()
    LottoController.statistics(lottos, winningLotto)
}
