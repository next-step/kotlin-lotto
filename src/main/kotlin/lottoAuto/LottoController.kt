package lottoAuto

import lottoAuto.domain.Lotto
import lottoAuto.domain.LottoFactory
import lottoAuto.domain.LottoRanker
import lottoAuto.domain.LottoStatsEngine
import lottoAuto.view.InputView
import lottoAuto.view.OutputView

object LottoController {
    fun getPurchaseAmount(): Int {
        return InputView.getPurchaseAmount()
    }

    fun getWinningLotto(): Lotto {
        return InputView.getWinningLotto()
    }

    fun createLottoList(purchaseAmount: Int): List<Lotto> {
        val numOfLotto = LottoStatsEngine.calcNumOfLotto(purchaseAmount)
        val lottoList = LottoFactory.create(numOfLotto)
        OutputView.printNumOfLotto(numOfLotto)
        OutputView.printLottoNumbers(lottoList)
        return lottoList
    }

    fun getLottoStats(purchaseAmount: Int, lottoList: List<Lotto>, winningLotto: Lotto) {
        val lottoRanks = LottoRanker.rank(
            lottoList,
            winningLotto
        )
        OutputView.printLottoStatistics(lottoRanks)
        OutputView.printRateOfReturn(purchaseAmount, lottoRanks)
    }
}

fun main() {
    val purchaseAmount = LottoController.getPurchaseAmount()
    val lottoList = LottoController.createLottoList(purchaseAmount)
    val winningLotto = LottoController.getWinningLotto()
    LottoController.getLottoStats(purchaseAmount, lottoList, winningLotto)
}
