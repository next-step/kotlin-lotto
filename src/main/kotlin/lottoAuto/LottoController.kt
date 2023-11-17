package lottoAuto

import lottoAuto.domain.*
import lottoAuto.view.InputView
import lottoAuto.view.OutputView

object LottoController {
    private const val LOTTO_PRICE = 1000

    fun getPurchaseAmount(): Int {
        return InputView.getPurchaseAmount()
    }

    fun getWinningLotto(): WinningLotto {
        return InputView.getWinningLotto()
    }

    fun createLottoList(purchaseAmount: Int): List<Lotto> {
        val numOfLotto = purchaseAmount / LOTTO_PRICE
        val lottoList = LottoFactory.create(numOfLotto)
        OutputView.printNumOfLotto(numOfLotto)
        OutputView.printLottoNumbers(lottoList)
        return lottoList
    }

    fun getLottoStats(purchaseAmount: Int, lottoList: List<Lotto>, winningLotto: WinningLotto) {
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
