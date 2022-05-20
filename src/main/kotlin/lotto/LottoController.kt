package lotto

import lotto.domain.Lotto
import lotto.domain.LottoSeller
import lotto.ui.LottoPurchaseView
import lotto.ui.StatisticsView
import lotto.ui.WinningLottoView

class LottoController(private val lottoSeller: LottoSeller) {
    fun start() {
        val inputPrice = LottoPurchaseView.inputPriceForPurchase()
        val lottoList = purchaseLotto(inputPrice)
        val winningLotto = WinningLottoView.inputWinningLotto()
        val matchResult = winningLotto.match(lottoList)
        StatisticsView.printResult(matchResult)
    }

    private fun purchaseLotto(inputPrice: Long): List<Lotto> {
        return lottoSeller.purchaseAuto(inputPrice)
            .also { LottoPurchaseView.printPurchaseResult(it) }
    }
}
